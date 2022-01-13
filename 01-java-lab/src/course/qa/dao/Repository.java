package course.qa.dao;

import course.qa.model.Person;

import java.util.Collection;

public interface Repository<K, V extends Identifiable<K>> {
    V create(V p);
    V update(V p);
    V deleteById(K id);
    Collection<V> findAll();
    V findById(K id);
    long getCount();
}
