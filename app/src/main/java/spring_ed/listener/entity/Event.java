package spring_ed.listener.entity;

import java.util.EventObject;

public class Event extends EventObject {
    private final AccessType accessType;
    //private final Object entity;
    // нужна какая-то сущность под обьектом, но у нас есть source от EventObject

    public Event(Object source, AccessType accessType) {
        super(source);
        this.accessType = accessType;
    }

    public AccessType getAccessType() {
        return accessType;
    }
}
