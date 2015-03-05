package code;

import annotation.Feature;

@Feature(featureName="TestClass")
public class TestClass {

	int i;
	String s;
	Object o;
	
	@Feature(featureName="TestClass")
	public TestClass(){}
	
	@Feature(featureName="TestClass")
	private void foo(){
		this.i++;
	}
}
