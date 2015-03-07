package annotation;

public @interface Constraint {

	ConstraintType constraint() default ConstraintType.NULL;
	String featureOrigin() default "";
	String referencedFeature() default "";
}
