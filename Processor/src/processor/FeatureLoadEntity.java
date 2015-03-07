package processor;

import annotation.FeatureType;
/**
 * 
 * @author harold
 *
 */
public class FeatureLoadEntity {
	
	private String name;
	private String parentName;
	private FeatureType featureType;
	private boolean mandatory;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public FeatureType getFeatureType() {
		return featureType;
	}
	public void setFeatureType(FeatureType featureType) {
		this.featureType = featureType;
	}
	public boolean isMandatory() {
		return mandatory;
	}
	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}
	
}
