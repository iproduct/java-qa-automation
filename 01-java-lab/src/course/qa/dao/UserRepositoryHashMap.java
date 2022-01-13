package course.qa.dao;

import course.qa.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepositoryHashMap implements UserRepository {
    private Map<Long, User> entities = new HashMap<>();

    @Override
    public User create(User user) {
        return entities.put(user.getId(), user);
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
