package lessons.Dictionary;

import java.lang.reflect.Array;

class NativeDictionary<T> {
    public int size;
    public String[] slots;
    public T[] values;
    public int step;
    public int count;

    public NativeDictionary(int sz, Class clazz) {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
        step = 3;
        count = 0;
    }

    public int hashFun(String key) {
        if (key == null) {
            return 0;
        }
        int hash = 0;
        byte[] bytes = key.getBytes();
        for (byte b : bytes) {
            hash = hash + b;
        }

        return hash % size;
    }

    public boolean isKey(String key) {
        for (String s : slots) {
            if (s == key) {
                return true;
            }
        }
        return false;
    }

    public void put(String key, T value) {
        if (value == null) {
            throw new NullPointerException();
        }

        if (size == count) {
            return;
        }

        int slot = seekSlot(key);
        if (slot > -1) {
            slots[slot] = key;
            values[slot] = value;
            count++;
        }
    }

    public T get(String key) {
        int hash = hashFun(key);

        if (key == slots[hash]) {
            return values[hash];
        }

        hash = 0;

        while (hash < size) {
            if (key == slots[hash]) {
                return values[hash];
            }
            hash ++;
        }

        return null;
    }

    private int seekSlot(String value) {
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
}