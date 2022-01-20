package course.qa.dao;

import course.qa.model.Publication;

import java.io.*;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

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
                Collection<V> items = (Collection<V>) dataObj;
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
        try(ObjectOutputStream ois = new ObjectOutputStream(
                new FileOutputStream(PUBLICATION_DB_FILE))) {
            ois.writeObject(getEntities().values());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            System.out.println("Done reading publications.");
        }

    }
}
