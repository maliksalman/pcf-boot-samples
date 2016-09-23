package com.smalik.sample.thing;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ThingService {

    private Map<String, Thing> datastore = new HashMap<>();

    public Thing create() {
        Thing thingy = new Thing();
        datastore.put(thingy.getId(), thingy);
        return thingy;
    }

    public Thing find(String id) {
        return datastore.get(id);
    }

    public Collection<Thing> all() {
        return datastore.values();
    }
}
