package course.qa.dao;

import course.qa.model.Role;
import course.qa.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RepositoryHashMapImplTest {
    private RepositoryHashMapImpl<Long, User> repository;

    @BeforeAll
    public void beforeAll() {
        log.info("Setup before all tests.");
    }

    @AfterAll
    public void afterAll() {
        log.info("Cleanup after all tests.");
    }

    @BeforeEach
    public void beforeEach() {
        log.info("Setup RepositoryHashMapImpl before each test");
        repository = new RepositoryHashMapImpl<Long, User>(new LongSequenceGenerator());
    }

    @AfterEach
    public void afterEach() {
        log.info("Cleanup RepositoryHashMapImpl after each test");
        repository = null;
    }

    @Test
    public void givenValidUser_whenCreate_thenShouldBeCreated() {
        // test
        User result = repository.create(NEW_USER);
        User actual = repository.findById(result.getId());

        //assert
        assertEquals(1L, actual.getId(), "User Id should be 1");
        assertEquals(NEW_USER.getName(), actual.getName(), "User name should be the same");
        assertEquals(NEW_USER.getUsername(), actual.getUsername(), "User username should be the same");
        assertEquals(NEW_USER.getPassword(), actual.getPassword(), "User pasword should be the same");
        assertEquals(NEW_USER.getAge(), actual.getAge(), "User age should be the same");
    }

    @Test
    @DisplayName("When multiple users and call findAll(), then all users should be returned")
    public void givenValidMultipleUsersInRepository_whenFindAll_thenShouldReturnAllUsers() {
        // setup
        for (User user : SAMPLE_USERS) {
            repository.create(user);
        }

        // test
        Collection<User> actual = repository.findAll();

        //assert
        assertEquals(3, actual.size(), "Users count should be 3");
        Set<String> actualUsernames = actual.stream().map(user -> user.getUsername()).collect(Collectors.toSet());
        Set<String> expectedUsernames = SAMPLE_USERS.stream().map(user -> user.getUsername()).collect(Collectors.toSet());
        assertEquals(expectedUsernames, actualUsernames, "Usernames should be the same");
        assertThat(actual.stream().map(user -> user.getName()).collect(Collectors.toSet()))
                .containsOnly("Trayan", "Georgi", "Maria");
    }

    @Test
    void assumptionThat() {
        String someString = "Some string";
        assumingThat(someString.equals("Some string"),
                () -> assertEquals(11, someString.length()));
    }


    private static final User NEW_USER = new User("Georgi", 35, "george", "george123");
    private static final List<User> SAMPLE_USERS = List.of(
            new User("Trayan", 45, "trayan", "trayan123"),
            new User("Georgi", 35, "george", "george123"),
            new User("Maria", 25, "mary", "mary123", new Role[]{Role.CLIENT, Role.ISSUER, Role.ADMIN})
    );
}
