package spring_ed.listener.entity;

import lombok.Getter;

import java.util.EventObject;

public class Event extends EventObject {

    @Getter
    private final AccessType accessType;
    //private final Object entity;
    // нужна какая-то сущность под обьектом, но у нас есть source от EventObject

    public Event(Object source, AccessType accessType) {
        super(source);
        this.accessType = accessType;
    }
}
