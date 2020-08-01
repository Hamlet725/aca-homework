
public class MyHashMap1 {
    private Node1[] table;
    private int current;
    private int capacity;
    private final float loadFactor;

    public MyHashMap1() {
        table = new Node1[16];
        current = 0;
        capacity = 12;
        loadFactor = 0.75f;
    }

    private void increaseArray() {
        Node1[] copy = table;
        table = new Node1[copy.length * 2];
        System.arraycopy(copy, 0, table, 0, copy.length);
        capacity = (int) (loadFactor * table.length);
    }

    private int getIndex(int key, int size) {
        return key % size;
    }

    public void put(int key, int value) {
        Node1 node = new Node1(key, value, null);
        if (key <= 0) {
            if (table[0] == null) {
                table[0] = node;
                ++current;
                if (current == capacity)
                    increaseArray();
                return;
            }
            Node1 cur = table[0];
            while (cur != null) {
                if (key == (int) cur.getKey()) {
                    cur.setValue(value);
                    return;
                }
                cur = cur.next;
            }
            cur = table[0];
            while (cur != null) {
                if (cur.next == null) {
                    cur.next = node;
                    ++current;
                    if (current == capacity)
                        increaseArray();
                    return;
                }
                cur = cur.next;
            }
        }
        int size = table.length;
        while (size >= 16) {
            int index = getIndex(key, size);
            Node1 cur = table[index];
            if (cur == null) {
                size /= 2;
                continue;
            }
            while (cur != null) {
                if (key == (int) cur.getKey()) {
                    cur.setValue(value);
                    return;
                }
                cur = cur.next;
            }
            size /= 2;
        }
        ++current;
        int index = getIndex(key, table.length);
        if (table[index] == null) {
            table[index] = node;
            if (current == capacity)
                increaseArray();
            return;
        }
        Node1 cur = table[index];
        while (cur != null) {
            if (cur.next == null) {
                cur.next = node;
                if (current == capacity)
                    increaseArray();
                return;
            }
            cur = cur.next;
        }
    }

    public int get(int key) {
        if (key <= 0) {
            if (table[0] == null)
                return -1;
            Node1 cur = table[0];
            while (cur != null) {
                if (key == (int) cur.getKey()) {
                    return (int) cur.getValue();
                }
                cur = cur.next;
            }
            return -1;
        }
        int size = table.length;
        while (size >= 16) {
            int index = getIndex(key, size);
            Node1 cur = table[index];
            while (cur != null) {
                if (key == (int) cur.getKey())
                    return (int) cur.getValue();
                cur = cur.next;
            }
            size /= 2;
        }
        return -1;
    }

    public void remove(int key) {
        if (key <= 0) {
            if (table[0] == null)
                return;
            if (key == (int) table[0].getKey()) {
                table[0] = table[0].next;
                --current;
                return;
            }
            Node1 cur = table[0];
            while (cur.next != null) {
                if (key == (int) cur.next.getKey()) {
                    cur.next = cur.next.next;
                    break;
                }
                cur = cur.next;
            }
        }
        int size = table.length;
        while (size >= 16) {
            int index = getIndex(key, size);
            Node1 cur = table[index];
            if (cur == null) {
                size /= 2;
                continue;
            }
            if (key == (int) cur.getKey()) {
                table[index] = table[index].next;
                return;
            }
            while (cur.next != null) {
                if (key == (int) cur.next.getKey()) {
                    cur.next = cur.next.next;
                    break;
                }
                cur = cur.next;
            }
            size /= 2;
        }
    }

    static class Node1<K, V> {

        final K key;
        V value;
        Node1<K, V> next;

        Node1(K key, V value, Node1<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }


        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
