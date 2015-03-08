package annotation;

public @interface Constraint {

	ConstraintType constrainType() default ConstraintType.NULL;
	String featureOrigin() default "";
	String referencedFeature() default "";
}
