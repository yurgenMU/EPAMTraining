package hometask5.t02;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyWrapper {
    private String path;
    Map<Object, Object> propMap;


    public PropertyWrapper(String path) {
        this.path = path;
        propMap = getProperties();
    }

    public Map<Object, Object> getProperties() {
        Properties properties = new Properties();
        Map<Object, Object> ans = new HashMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            properties.load(bufferedReader);
            for (Object obj : properties.keySet()) {
                ans.put(obj, properties.get(obj));
            }
        } catch (NoPropertyFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ans;
    }

    public Object getValue(Object key) {
        if (propMap.containsKey(key))
            return propMap.get(key);
        else throw new NoSuchPropertyKeyException("No such key in property File");
    }
}
