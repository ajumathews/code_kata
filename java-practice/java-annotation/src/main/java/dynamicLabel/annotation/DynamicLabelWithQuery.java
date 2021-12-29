package dynamicLabel.annotation;


import dynamicLabel.dao.DynamicLabelDao;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(value = FIELD)
@Retention(RUNTIME)
public @interface DynamicLabelWithQuery {

    Class<? extends DynamicLabelDao> dataSource();

    String query();
}