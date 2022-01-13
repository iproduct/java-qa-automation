package course.qa.dao;

import course.qa.model.User;

import java.util.Arrays;
import java.util.Collection;

public class UserRepositoryMemoryImpl implements UserRepository {
    public static final int MAX_USERS = 100;
    private long nextId = 0;

    private User[] users = new User[MAX_USERS];
    private int length = 0;

    @Override
    public User create(User p) {
        p.setId(++ nextId);
        users[length++] = p;
        return p;
    }

    @Override
    public User update(User p) {
        int index =  Arrays.binarySearch(users, p); // O(log(N)
        users[index] = p;
        return p;
    }

    @Override
    public User deleteById(Long id) {
        int index =  Arrays.<User>binarySearch(users, 0, length, new User(id)); // O(log(N)
        if(index < 0) return null;
        User removed =  users[index];
        for(int i = index; i < length - 1; i++){
            users[i] = users[i + 1]; // O(N)
        }
        length --;
        return removed;
    }

    @Override
    public Collection<User> findAll() {
        return Arrays.asList(Arrays.copyOfRange(users, 0, length));
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public long getCount() {
        return 0;
    }
}
