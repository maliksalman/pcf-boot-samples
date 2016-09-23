package com.smalik.sample.thing;

import java.util.Date;
import java.util.UUID;

public class Thing {

    private Date created = new Date();
    private String id = UUID.randomUUID().toString();

    public Date getCreated() {
        return created;
    }

    public String getId() {
        return id;
    }
}
