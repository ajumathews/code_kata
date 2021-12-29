package com.clarivate.prototype.executor;

import com.clarivate.prototype.model.DBInput;
import com.clarivate.prototype.operation.Operation;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

public class DBQueryExecutor implements DBExecutor {

    private NamedParameterJdbcTemplate jdbcTemplate;

    public DBQueryExecutor(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public Object execute(Operation operation, DBInput DBInput) {
        return operation.execute(jdbcTemplate, DBInput);
    }
}
