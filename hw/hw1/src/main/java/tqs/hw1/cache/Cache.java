package tqs.hw1.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Cache{
    private final Map<String, Object> storage;

    public Cache(){
        storage = new HashMap<String, Object>();
    }

    public void addNewItem(String key, Object response){
        if (storage.size()>=20){
            Optional<String> cacheObject = storage.keySet().stream().findFirst();
            cacheObject.ifPresent(storage::remove);
        }
        storage.put(key, response);
    }

    public boolean checkIfHasResponse(String key){
        return storage.containsKey(key);
    }

    public Object getItem(String key){
        return storage.get(key);
    }

    public int size() {return storage.size();}
}
