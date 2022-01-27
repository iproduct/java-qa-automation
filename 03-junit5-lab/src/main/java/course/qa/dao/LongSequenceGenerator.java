package course.qa.dao;

import course.qa.dao.IdSequenceGenerator;

public class LongSequenceGenerator implements IdSequenceGenerator<Long> {
    private Long nextId = 0L;

    @Override
    public Long getNextId() {
        return ++nextId;
    }
}
