package annotation;

public @interface Constraint {

	ConstraintType constraint() default ConstraintType.NULL;
	String referencedFeature() default "";
}
