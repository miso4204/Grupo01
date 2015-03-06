package annotation;

public @interface Feature {

	String featureName() default "";
	boolean optional() default false;
	boolean isParent() default false;
	FeatureType featureType() default FeatureType.AND;
}
