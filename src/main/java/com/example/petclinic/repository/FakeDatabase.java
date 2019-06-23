package com.example.petclinic.repository;

import com.example.petclinic.model.Modifiable;

import java.io.InvalidObjectException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Fake database uses eager creation of tables.  Uses enum to identify table names to be created.
 */
public class FakeDatabase {

    // To add a table, add a value to this enum.  An empty table will be added automatically with the name used here.
    private enum TableName {
        OWNER, PET, VISIT, VET
    }

    private static FakeDatabase INSTANCE = null;

    private Map<String, List<?>> map = new ConcurrentHashMap<>();

    // Uses 'singleton' pattern to ensure we're only ever dealing with one instance of our database
    private FakeDatabase() {

        initializeTables();

    }

    private void initializeTables() {

        // initialize 'database'
        for (TableName tableName : TableName.values()) {
            List<?> table = new ArrayList<>();
            map.put(tableName.name(), table);
        }
    }

    // implemented as part of singleton pattern
    public static FakeDatabase getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new FakeDatabase();
        }

        return INSTANCE;
    }

    /**
     * Save that record.
     *
     * @param t
     * @param <T>
     * @return
     */
    public <T> T save(T t) {

        // using reflection to get table name
        String tableName = t.getClass().getSimpleName().toUpperCase();

        // create object
        List<T> table = (List<T>) map.get(tableName);
        table.add(t);

        return t;
    }

    /**
     * Get me some record.
     *
     * @param t
     * @param <T>
     * @return
     */
    public <T> T get(T t) {

        // using reflection to get table name
        String tableName = t.getClass().getSimpleName().toUpperCase();

        // read object
        List<T> table = (List<T>) map.get(tableName);
        T result = table.get(table.indexOf(t));

        return result;
    }

    /**
     * Change that record!
     *
     * @param t
     * @param <T>
     * @return
     * @throws InvalidObjectException
     */
    public <T extends Modifiable> T modify(T t) {

        // using reflection to get table name
        String tableName = t.getClass().getSimpleName().toUpperCase();

        // update object
        List<T> table = (List<T>) map.get(tableName);
        T obj = table.get(table.indexOf(t));

        copyFields(t, obj);

        return obj;
    }

    /**
     * Wanna remove the record.
     *
     * @param t
     * @param <T>
     * @return
     */
    public <T> boolean delete(T t) {

        // using reflection to get table name
        String tableName = t.getClass().getSimpleName().toUpperCase();

        // update object
        List<T> table = (List<T>) map.get(tableName);
        boolean result = table.remove(t);

        return result;
    }

    /**
     * Lets get it all!!
     *
     * @param tableName
     * @param <T>
     * @return
     */
    public <T> List<T> getAll(String tableName) {

        List<T> result = (List<T>) this.map.get(tableName.toUpperCase());
        return result;
    }

    public void dropAll() {

        this.map.clear();
        initializeTables();
    }

    /**
     * Convenience method to deep copy an object.
     *
     * @param from object to copy from
     * @param to   object to copy to
     * @param <T>  type of object being copied
     */
    private static <T> void copyFields(T from, T to) {

        for (Field f : from.getClass().getFields()) {
            try {

                if (isPrimitivish(f.getType())) {
                    f.set(to, f.get(from));
                } else {
                    // looks like recursion, baby!
                    copyFields(f.get(from), f.get(to));
                }

            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * Convenience method to determine if Class is primitive or primitive wrapper class
     *
     * @param c Class to test
     * @return true if primitivish
     */
    private static boolean isPrimitivish(Class c) {

        return c.isPrimitive() ||
                c == String.class ||
                c == Boolean.class ||
                c == Byte.class ||
                c == Short.class ||
                c == Character.class ||
                c == Integer.class ||
                c == Float.class ||
                c == Double.class ||
                c == Long.class;
    }

}
