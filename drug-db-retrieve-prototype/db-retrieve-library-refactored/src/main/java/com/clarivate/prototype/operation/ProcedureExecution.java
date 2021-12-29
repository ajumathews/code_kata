package com.clarivate.prototype.operation;

import com.clarivate.prototype.model.DBInput;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.util.HashMap;
import java.util.Map;

public class ProcedureExecution implements Operation {

    public Object execute(NamedParameterJdbcTemplate jdbcTemplate, DBInput DBInput) {
        return null;
    }

    public Object execute(JdbcTemplate jdbcTemplate, DBInput dbInput) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName(dbInput.getProcedureName());
        SqlParameterSource in = new MapSqlParameterSource(dbInput.getParams());
        return simpleJdbcCall.execute(in);
    }
}
