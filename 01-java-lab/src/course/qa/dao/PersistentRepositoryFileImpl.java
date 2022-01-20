package course.qa.dao;

import course.qa.model.Publication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class PersistentRepositoryFileImpl<K, V extends Identifiable<K>>
        extends RepositoryHashMapImpl<K, V> implements PersistentRepository<K, V>{
    public static  final String PUBLICATION_DB_FILE = "publications.db";

    public PersistentRepositoryFileImpl(IdSequenceGenerator generator) {
        super(generator);
    }

    @Override
    public void load() {
        try(ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(PUBLICATION_DB_FILE))) {
            Object dataObj = ois.readObject();
            if(dataObj instanceof List){
                List<V> items = (List<V>) dataObj;
                for(V item : items) {
                    getEntities().put(item.getId(), item);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally{
            System.out.println("Done reading publications.");
        }
    }

    @Override
    public void save() {

    }
}
