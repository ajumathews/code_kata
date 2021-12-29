package dynamicLabel.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Annotation to define the labels for columns
 * @since  22/01/2013
 * @version 1.0
 */
@Target(value=FIELD)
@Retention(RUNTIME)
@Documented
public @interface DocumentColumn {
	
	String label() ;
	String searchField() default "";
}