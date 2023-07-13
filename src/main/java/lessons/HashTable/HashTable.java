package lessons.HashTable;

public class HashTable {
    public int size;
    public int step;
    public String[] slots;

    public HashTable(int sz, int stp) {
        size = sz;
        step = stp;
        slots = new String[size];
        for (int i = 0; i < size; i++) slots[i] = null;
    }

    public int hashFun(String value) {
        if (value == null) {
            return 0;
        }
        int hash = 0;
        byte[] bytes = value.getBytes();
        for (byte b : bytes) {
            hash = hash + b;
        }

        return hash % size;
    }

    public int seekSlot(String value) {
        int hash = hashFun(value);

        while (slots[hash] != null && (hash + step) < size) {
            hash = hash + step;
        }

        if (slots[hash] == null) {
            return hash;
        }

        return -1;
    }

    public int put(String value) {
        int slot = seekSlot(value);
        if (slot > -1) {
            slots[slot] = value;
            return slot;
        }

        return -1;
    }

    public int find(String value) {
        int hash = hashFun(value);
        while (value != slots[hash] && (hash + step) < size) {
            hash = hash + step;
        }

        if (value == slots[hash]) {
            return hash;
        }

        return -1;
    }
}
