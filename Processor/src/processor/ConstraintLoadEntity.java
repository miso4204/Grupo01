package processor;

import annotation.ConstraintType;

public class ConstraintLoadEntity {
	
	private ConstraintType constrainType;
	private String featureOrigin;
	private String referencedFeature;
	
	
	public ConstraintType getConstrainType() {
		return constrainType;
	}
	public void setConstrainType(ConstraintType constrainType) {
		this.constrainType = constrainType;
	}
	public String getFeatureOrigin() {
		return featureOrigin;
	}
	public void setFeatureOrigin(String featureOrigin) {
		this.featureOrigin = featureOrigin;
	}
	public String getReferencedFeature() {
		return referencedFeature;
	}
	public void setReferencedFeature(String referencedFeature) {
		this.referencedFeature = referencedFeature;
	}

}
