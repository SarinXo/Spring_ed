package spring_ed.listener.entity;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class EntityListener {
    //Слушает события Event
    //будет вызван если отправится обьект такого же типа
    //через публикацию ивента

    /**
     * может обрабатывать только READ ивенты
     * @param e
     */
    @EventListener(condition = "#root.args[0].accessType.name() == 'READ'")
    @Order(10)
    public void accessEntityRead(Event e){
        System.out.println("Log READ event: "+ e);
    }

    @EventListener(condition = "#root.args[0].accessType.name() == 'UPDATE'")
    @Order(10)
    public void accessEntityUpdate(Event e){
        System.out.println("Log WRITE event: "+ e);
    }
}
