package course.qa.dao;

import course.qa.model.User;

import java.util.Collection;

public interface UserRepository {
    User create(User p);
    User update(User p);
    User deleteById(Long id);
    Collection<User> findAll();
    User findById(Long id);
    long getCount();
}
