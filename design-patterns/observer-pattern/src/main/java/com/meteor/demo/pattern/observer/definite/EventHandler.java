package com.meteor.demo.pattern.observer.definite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created  meteor on 2020/11/9
 **/
public class EventHandler {

    private List<Event> events;

    public EventHandler() {
        events = new ArrayList<>();
    }

    public void attach(Object object, String methodName, Object... params) {
        events.add(new Event(object, methodName, params));
    }

    public void detach(Object object, String methodName, Object... params) {
        events.remove(new Event(object, methodName, params));
    }

    public void call() throws Exception  {
        for (Event event : events) {
            event.invoke();
        }
    }


}
