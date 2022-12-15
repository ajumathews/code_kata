package conditional.daps.cosmos;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class CosmosEnabledCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String databaseProvider = conditionContext.getEnvironment().getProperty("daps.core.persistence.provider", String.class);
        return ("cosmos".equals(databaseProvider));
    }
}
