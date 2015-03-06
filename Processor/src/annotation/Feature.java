package annotation;

public @interface Feature {

	String featureName() default "";
	boolean optional() default false;
	String parentName() default "";
	FeatureType featureType() default FeatureType.NULL;
}
