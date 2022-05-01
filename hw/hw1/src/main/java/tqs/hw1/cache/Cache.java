package tqs.hw1.cache;

import java.util.HashMap;
import java.util.Map;

public class Cache{
    private Map storage;

    public Cache(){
        storage = new HashMap();
    }

    public void addNewItem(String key, Object response){
        if (storage.size()>=20){
            storage.remove(storage.keySet().stream().findFirst().get());
        }
        storage.put(key, response);
    }

    public boolean checkIfHasResponse(String key){
        if (storage.keySet().contains(key)){
            return true;
        }
        else {
            return false;
        }
    }

    public Object getItem(String key){
        return storage.get(key);
    }
}
