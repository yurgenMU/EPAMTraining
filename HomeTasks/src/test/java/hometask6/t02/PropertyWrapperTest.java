package hometask6.t02;

import hometask5.t02.NoPropertyFileException;
import org.junit.jupiter.api.Test;

public class PropertyWrapperTest {
    private PropertyWrapper propertyWrapper;

    @Test
    void wrapperTest() {
        try {
            propertyWrapper = new PropertyWrapper(
                    "src/main/resources/wrapper.properties");
        } catch (NoPropertyFileException e) {
            e.printStackTrace();
        }
        System.out.println(propertyWrapper.getValue("1"));
    }
}
