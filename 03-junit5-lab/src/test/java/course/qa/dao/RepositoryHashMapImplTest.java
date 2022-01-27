package course.qa.dao;

import course.qa.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class RepositoryHashMapImplTest {
    private RepositoryHashMapImpl<Long, User> repository;

    @BeforeEach
    public void beforeEach() {
        log.info("Setup Calculator before each test");
        repository = new RepositoryHashMapImpl<Long, User>(new LongSequenceGenerator());
    }

    @Test
    public void givenValidUser_whenCreate_thenShouldBeCreated(){
        // test
        User result = repository.create(SAMPLE_USER);
        User actual = repository.findById(result.getId());

        //assert
        assertEquals(1L, actual.getId(), "User Id should be 1");
        assertEquals(SAMPLE_USER.getName(), actual.getName(), "User name should be the same");
        assertEquals(SAMPLE_USER.getUsername(), actual.getUsername(), "User username should be the same");
        assertEquals(SAMPLE_USER.getPassword(), actual.getPassword(), "User pasword should be the same");
        assertEquals(SAMPLE_USER.getAge(), actual.getAge(), "User age should be the same");
    }

    @AfterEach
    public void afterEach() {
        log.info("Setup Calculator after each test");
        repository = null;
    }

    private static final User SAMPLE_USER = new User("Georgi", 35, "george", "george123");
}
