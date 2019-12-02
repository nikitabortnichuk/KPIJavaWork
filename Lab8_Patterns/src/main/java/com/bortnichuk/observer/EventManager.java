package com.bortnichuk.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {

    private Map<String, List<Visitor>> visitors = new HashMap<>();

    public Map<String, List<Visitor>> getVisitors() {
        return visitors;
    }

    public EventManager(String... events) {
        for (String event: events){
            this.visitors.put(event, new ArrayList<>());
        }
    }

    public void subscribe(String event, Visitor visitor){
        List<Visitor> visitors = this.visitors.get(event);
        visitors.add(visitor);
    }

    public void unsubscribe(String event, Visitor visitor){
        List<Visitor> visitors = this.visitors.get(event);
        visitors.remove(visitor);
    }

    public void send(String event){
        List<Visitor> visitors = this.visitors.get(event);
        for (Visitor visitor: visitors) {
            visitor.update(event);
        }
    }

}
