package annotation;

public @interface Feature {

	String featureName() default "";
	boolean optional() default false;
}
