package annotation;

public @interface VariationPoint {
	
	String parentName() default "";
	String variationName() default "";
	FeatureType variationType() default FeatureType.NULL;
	boolean mandatory() default true; 
	boolean parentMandatory() default true;
	FeatureType parentType() default FeatureType.NULL;
}
