package course.qa.dao;

import course.qa.model.Role;
import course.qa.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@Slf4j
public class RepositoryHashMapImplTestCsvSource {
    private RepositoryHashMapImpl<Long, User> repository;

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

    @ParameterizedTest
    @CsvSource({"Trayan, 45, trayan, trayan123", "Georgi, 35, george, george123", "Maria, 25, mary, mary123"})
    public void givenValidUser_whenCreate_thenShouldBeCreated(String name, int age, String username, String password) {
        // test
        User result = repository.create(new User(name, age, username, password));
        User actual = repository.findById(result.getId());

        //assert
        assertEquals(1L, actual.getId(), "User Id should be 1");
        assertEquals(name, actual.getName(), "User name should be the same");
        assertEquals(username, actual.getUsername(), "User username should be the same");
        assertEquals(password, actual.getPassword(), "User pasword should be the same");
        assertEquals(age, actual.getAge(), "User age should be the same");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "users-data.csv", numLinesToSkip = 1)
    public void givenValidUserFromCsvFile_whenCreate_thenShouldBeCreated(String name, int age, String username, String password) {
        // test
        User result = repository.create(new User(name, age, username, password));
        User actual = repository.findById(result.getId());

        //assert
        assertEquals(1L, actual.getId(), "User Id should be 1");
        assertEquals(name, actual.getName(), "User name should be the same");
        assertEquals(username, actual.getUsername(), "User username should be the same");
        assertEquals(password, actual.getPassword(), "User pasword should be the same");
        assertEquals(age, actual.getAge(), "User age should be the same");
    }
}
