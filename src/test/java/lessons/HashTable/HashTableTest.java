package lessons.HashTable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    void hash() {
        HashTable hashTable = new HashTable(17, 3);
        String s = "str";

        int i = hashTable.hashFun(s);

        assertNotEquals(0, i);
    }

    @Test
    void put() {
        HashTable hashTable = new HashTable(5, 3);
        String s = "str";

        int i = hashTable.put(s);

        assertNotEquals(1, hashTable.size);
        assertTrue(i >= 0);
    }

    @Test
    void seek() {
        HashTable hashTable = new HashTable(5, 3);
        String s = "str";

        int i = hashTable.put(s);
        int i2 = hashTable.put(s);

        assertNotEquals(2, hashTable.size);
    }

    @Test
    void find() {
        HashTable hashTable = new HashTable(17, 3);
        String s = "str"; // hash = 5

        for (int i = 0; i < 17; i++) {
            hashTable.put("val");
        }

        hashTable.slots[3] = s;

        int i = hashTable.find(s);

        assertTrue(i >= 0);
    }

    @Test
    void whenDataMoreThanSize() {
        HashTable hashTable = new HashTable(17, 3);

        for (int i = 0; i < 18; i++) {
            hashTable.put("val");
        }

        assertEquals(17, hashTable.count);

    }

}