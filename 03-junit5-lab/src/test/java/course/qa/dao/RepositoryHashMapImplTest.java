package course.qa.dao;

import org.junit.jupiter.api.BeforeEach;

public class RepositoryHashMapImplTest {
    private RepositoryHashMapImpl repository;

    @BeforeEach
    public void beforeEach() {
        repository = new RepositoryHashMapImpl(new LongSequenceGenerator());
    }
}
