package annotation;

public @interface Feature {

	String featureName() default "";
	boolean optional() default false;
	boolean isPatent() default false;
	FeatureType featureType() default FeatureType.AND;
}
