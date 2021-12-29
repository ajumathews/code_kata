package org.practice;

import java.util.List;
import java.util.Map;

public interface DBExecutor {

    List<Map<String,Object>> executeQuery(String sql);
}
