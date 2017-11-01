package hometask5.t02;

import org.junit.jupiter.api.Test;

public class PropertyWrapperTest {
    private PropertyWrapper propertyWrapper;

    @Test
    void wrapperTest() {
        propertyWrapper = new PropertyWrapper(
                "src/main/resources/wrapper.properties");
        System.out.println(propertyWrapper.getValue("1"));
    }
}
