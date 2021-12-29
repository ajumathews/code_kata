package com.clarivate.prototype.operation;

import com.clarivate.prototype.model.DBInput;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public interface Operation {

    Object execute(NamedParameterJdbcTemplate jdbcTemplate, DBInput DBInput);

    Object execute(JdbcTemplate jdbcTemplate, DBInput dbInput);
}
