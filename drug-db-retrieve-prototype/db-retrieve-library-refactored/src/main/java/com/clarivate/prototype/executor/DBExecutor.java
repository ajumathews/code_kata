package com.clarivate.prototype.executor;

import com.clarivate.prototype.model.DBInput;
import com.clarivate.prototype.operation.Operation;

public interface DBExecutor {

    Object execute(Operation operation, DBInput DBInput);
}
