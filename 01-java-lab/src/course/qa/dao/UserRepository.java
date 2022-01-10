package course.qa.dao;

import course.qa.model.User;

public interface UserRepository {
    User create(User p);
    User update(User p);
    User deleteById(Long id);
    User[] findAll();
    User findById(Long id);
    long getCount();
}
