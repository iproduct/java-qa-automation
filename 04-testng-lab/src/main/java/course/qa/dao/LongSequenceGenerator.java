package course.qa.dao;

public class LongSequenceGenerator implements IdSequenceGenerator<Long> {
    private Long nextId = 0L;

    @Override
    public Long getNextId() {
        return ++nextId;
    }
}
