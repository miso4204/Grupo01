package code;


@annotation.Feature(featureName = "TestClass")
public class TestClass {
    int i;
    
    java.lang.String s;
    
    java.lang.Object o;
    
    @annotation.Feature(featureName = "TestClass")
    public TestClass() {
    }
    
    @annotation.Feature(featureName = "TestClass")
    private void foo() {
        (this.i)++;
    }
    
}

