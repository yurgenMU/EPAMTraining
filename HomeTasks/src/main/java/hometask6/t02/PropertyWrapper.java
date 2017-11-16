package hometask6.t02;

import hometask5.t02.NoPropertyFileException;
import hometask5.t02.NoSuchPropertyKeyException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyWrapper {
    private String path;
    Map<Object, Object> propMap;


    public PropertyWrapper(String path) throws NoPropertyFileException {
        this.path = path;
        propMap = getProperties();
    }

    public Map<Object, Object> getProperties() throws NoPropertyFileException {
        Properties properties = new Properties();
        Map<Object, Object> ans = new HashMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            properties.load(bufferedReader);
            properties.keySet().stream().forEach(x -> ans.put(x, properties.get(x)));
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
