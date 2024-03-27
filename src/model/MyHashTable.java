package model;

/**
 *
 * @author LENOVO
 * @param <T>
 */
public class MyHashTable<T> {

    private static int tableSize;
    MyList<Entry<T>>[] table;
    public int countMaxCollision = 0;

    public MyList<Entry<T>>[] getTable() {
        return table;
    }


    public MyHashTable(int size) {
        tableSize = size;
        table = new MyList[tableSize];
        for (int i = 0; i < tableSize; i++) {
            table[i] = new MyList<>();
        }
    }

    private int hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (31 * hash + key.charAt(i)) % tableSize;
        }
        return hash;
    }

    public boolean put(String key, T value) {
        
        int index = hash(key);
        Entry entry = new Entry(key, value);
        MyList<Entry<T>> list = table[index];
        if (!list.isEmpty()) {
            if (list.searchList(entry)) {
                return false;
            }
            
        }

        list.add(entry);
        return true;
    }

    public T get(String key) {
        int index = hash(key);

        MyList<Entry<T>> list = table[index];
        if (list.isEmpty()) {
            return null;
        }
        Entry<T> found = list.searchListReturn(new Entry<> (key, null));
         if (found!= null) {
                return found.value;
            }
        return null;
    }
    
    public int countCollision(){
        for(MyList<Entry<T>> e : table){
            if(e.getListSize()> countMaxCollision){
                countMaxCollision = e.getListSize();
            }
        }
        return countMaxCollision;
    }

}
