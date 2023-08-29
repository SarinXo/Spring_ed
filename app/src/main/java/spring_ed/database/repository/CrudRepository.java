package spring_ed.database.repository;

import java.util.Optional;

//больше не используем
public interface CrudRepository<K, E> {

    Optional<E> findById(K id);

    void delete(E entity);
}
