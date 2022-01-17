package course.qa.dao;

import course.qa.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RepositoryHashMapImpl<K, V extends Identifiable<K>> implements Repository<K, V> {
    private Map<K, V> entities = new HashMap<>();
    private IdSequenceGenerator<K> idGen;

    public RepositoryHashMapImpl(IdSequenceGenerator generator) {
        idGen = generator;
    }

    @Override
    public V create(V entity) {
        entity.setId(idGen.getNextId());
        if(entities.putIfAbsent(entity.getId(), entity) == null) {
            return entity;
        }else {
            return null;
        }
    }

    @Override
    public V update(V user) {
        return entities.replace(user.getId(), user);
    }

    @Override
    public V deleteById(K id) {
        return entities.remove(id);
    }

    @Override
    public Collection<V> findAll() {
        return entities.values();
    }

    @Override
    public V findById(K id) {
        return entities.get(id);
    }

    @Override
    public long getCount() {
        return entities.size();
    }
}
