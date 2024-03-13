package com.example.jpa_announce.component;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class cach {
    private Map<String, Object> cacheMap = new HashMap<>();

    public void put(String key, Object value) {
        cacheMap.put(key, value);
    }

    public Object get(String key) {
        return cacheMap.get(key);
    }

    public boolean containsKey(String key) {
        return cacheMap.containsKey(key);
    }
}
