package com.clarivate.prototype.operation;

import com.clarivate.prototype.model.DBInput;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class UpdateQueryExecutor implements Operation {

    public Object execute(NamedParameterJdbcTemplate jdbcTemplate, DBInput DBInput) {
      return jdbcTemplate.update(DBInput.getSql(), DBInput.getParams());
    }

    public Object execute(JdbcTemplate jdbcTemplate, DBInput dbInput) {
        return null;
    }
}
