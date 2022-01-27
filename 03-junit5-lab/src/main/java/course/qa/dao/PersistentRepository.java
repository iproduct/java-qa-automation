package course.qa.dao;

public interface PersistentRepository<K, V extends Identifiable<K>> extends Repository<K, V> {
    void load();
    void save();
}
