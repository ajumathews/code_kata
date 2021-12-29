import oracle.jdbc.pool.OracleDataSource;
import org.testcontainers.containers.OracleContainer;
import org.testcontainers.jdbc.ext.ScriptUtils;
import org.testcontainers.shaded.com.google.common.base.Charsets;
import org.testcontainers.shaded.com.google.common.io.Resources;

import javax.sql.DataSource;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;

public class OracleTestContainer {

    public static void main(String[] args) throws InterruptedException {
        OracleContainer oracle = new OracleContainer("ls-docker.repo.clarivate.io/oracle/oracle-xe-11g-db");
        oracle.start();
        System.out.println(oracle.getOraclePort());
        System.out.println(oracle.getJdbcUrl());
        System.out.println(oracle.getUsername());
        System.out.println(oracle.getPassword());
        initializeDb(oracle);
        System.out.println("Done");
        while(true){
        }
    }


    private static void initializeDb(OracleContainer oracle) {
        try {
            OracleDataSource oracleDataSource = new OracleDataSource();
            oracleDataSource.setURL(oracle.getJdbcUrl());
            oracleDataSource.setUser(oracle.getUsername());
            oracleDataSource.setPassword(oracle.getPassword());
            oracleDataSource.setDriverType("oracle.jdbc.OracleDriver");

            String initScriptPath_DDL = "sp_ddl.sql";
            String initScriptPath_DML = "sp_dml.sql";

            executeScript(oracleDataSource, initScriptPath_DDL);
            executeScript(oracleDataSource, initScriptPath_DML);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    private static boolean executeScript(DataSource dataSource, String scriptPath) {
        try {
            URL resource = Resources.getResource(scriptPath);
            String sql = Resources.toString(resource, Charsets.UTF_8);
            Connection connect1 = dataSource.getConnection();
            ScriptUtils.executeSqlScript(connect1, scriptPath, sql);
            connect1.commit();
            System.out.println("******************initSQLFunction SUCCESS:******************* " + scriptPath);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println("******************FAILED:START******************* " + e.getMessage());
            System.out.println("******************FAILED:END******************* " + scriptPath);
            throw new RuntimeException("******Script initialization failed for " + scriptPath);
        }
    }

    ;
}
