package com.smalik.sample.thing;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ThingController {

    @Autowired
    private ThingService service;

    @RequestMapping(value = "/thing/{id}", method = RequestMethod.GET)
    @ResponseBody public Thing getThing(@PathVariable("id") String thingyId) {
        return service.find(thingyId);
    }

    @RequestMapping(value = "/thing", method = RequestMethod.GET)
    @ResponseBody public Collection<Thing> getAllThings() {
        return service.all();
    }

    @RequestMapping(value = "/thing", method = RequestMethod.POST)
    @ResponseBody public Thing addThing() {
        return service.create();
    }
}
