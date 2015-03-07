package annotation;

public @interface Feature {

	String featureName() default "";
	boolean mandatory() default true;
	String parentName() default "";
	FeatureType featureType() default FeatureType.NULL;
	boolean isRoot() default false;
}
