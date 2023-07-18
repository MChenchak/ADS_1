package lessons.PowerSet;

public class HashTable {
    public int size;
    public int step;
    public String[] slots;
    public int count;

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

        while (slots[hash] != null && hash <= size) {
            hash = hash + step;
            if (hash >= size) {
                hash = 0;
                step = 1;
            }
        }

        if (slots[hash] == null) {
            return hash;
        }

        return -1;
    }

    public int put(String value) {
        if (size == count) {
            return -1;
        }

        int slot = seekSlot(value);
        if (slot > -1) {
            slots[slot] = value;
            count++;
            return slot;
        }

        return -1;
    }

    public int find(String value) {
        int hash = hashFun(value);

        if (value == slots[hash]) {
            return hash;
        }

        hash = 0;

        while (hash < size) {
            if (value == slots[hash]) {
                return hash;
            }
            hash ++;
        }

        return -1;
    }
}
