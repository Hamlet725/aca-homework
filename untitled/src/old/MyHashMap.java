package old;

import java.util.Iterator;
import java.util.LinkedList;

public class MyHashMap {
    private LinkedList<Entry>[] table;
    private int current;
    private int capacity;
    private final float loadFactor;

    public MyHashMap() {
        table = new LinkedList[16];
        current = 0;
        loadFactor = 0.75f;
        capacity = (int) (table.length * loadFactor);
    }

    private void rehash(LinkedList<Entry>[] entries) {
        for (LinkedList<Entry> entryList : entries) {
            if (entryList != null) {
                for (Entry entry : entryList) {
                    put(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    private void increaseMyTable() {
        LinkedList<Entry>[] copy = table;
        table = new LinkedList[copy.length * 2];
        capacity = (int) (loadFactor * table.length);
        rehash(copy);
    }

    private int getIndex(int key, int size) {
        if (key < 0) {
            key = -key;
        }
        return key % size;
    }

    public void put(int key, int value) {
        if (current == capacity)
            increaseMyTable();
        Entry entry = new Entry(key, value);
        int index = getIndex(key, table.length);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        for (Entry currentEntry : table[index]) {
            if (key == currentEntry.getKey()) {
                currentEntry.setValue(value);
                return;
            }
        }
        table[index].add(entry);
        ++current;
    }


    public int get(int key) {
        int index = getIndex(key, table.length);
        if (table[index] != null) {
            for (Entry entry : table[index]) {
                if (key == entry.getKey())
                    return entry.getValue();
            }
        }

        return -1;
    }

    public void remove(int key) {
        int index = getIndex(key, table.length);
        if (table[index] != null) {
            Iterator<Entry> entryListIterator = table[index].iterator();
            while (entryListIterator.hasNext()) {
                Entry entry = entryListIterator.next();
                if (entry.getKey() == key) {
                    entryListIterator.remove();
                    return;
                }
            }
        }
    }

    static class Entry {
        final int key;
        int value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

}
