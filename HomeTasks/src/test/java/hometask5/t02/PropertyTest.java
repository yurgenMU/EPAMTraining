package hometask5.t02;

import org.junit.Test;

public class PropertyTest {
    private Property propertyWrapper;

    @Test
    public void wrapperTest() throws NoPropertyFileException {
        try {
            propertyWrapper = new Property(
                    "src/main/resources/wrapper.properties");
        } catch (NoPropertyFileException e) {
            e.printStackTrace();
        }
        System.out.println(propertyWrapper.getProperties().get("1"));
    }
}
