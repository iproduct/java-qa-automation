package course.qa.dao;

import course.qa.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserRepositoryHashMap implements UserRepository {
    private Map<Long, User> entities = new HashMap<>();
    private long nextId = 0;

    @Override
    public User create(User user) {
        user.setId(++ nextId);
        if(entities.putIfAbsent(user.getId(), user) == null) {
            return user;
        }else {
            return null;
        }
    }

    @Override
    public User update(User user) {
        return entities.replace(user.getId(), user);
    }

    @Override
    public User deleteById(Long id) {
        return entities.remove(id);
    }

    @Override
    public Collection<User> findAll() {
        return entities.values();
    }

    @Override
    public User findById(Long id) {
        return entities.get(id);
    }

    @Override
    public long getCount() {
        return entities.size();
    }
}
