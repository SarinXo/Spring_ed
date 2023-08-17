package spring_ed.database.entity;

import java.io.Serial;
import java.io.Serializable;

public interface BaseEntity<T extends Serializable> {
    T getId();
    void setId(T id);
}
