package com.clarivate.prototype.executor;

import com.clarivate.prototype.model.DBInput;
import com.clarivate.prototype.operation.Operation;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class DBProcedureExecutor implements DBExecutor {

    private JdbcTemplate jdbcTemplate;

    public DBProcedureExecutor(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Object execute(Operation operation, DBInput DBInput) {
        return null;
    }

}
