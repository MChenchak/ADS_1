package lessons.Dictionary;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NativeDictionaryTest {

    @Test
    void put() {
        NativeDictionary<String> dic = new NativeDictionary<>(10, String.class);

        int h = dic.hashFun("key1");
        dic.put("key1", "val1");

        assertEquals(1, dic.count);
        assertEquals(dic.slots[h], "key1");
        assertEquals(dic.values[h], "val1");
    }

    @Test
    void putWithExistsKey() {
        NativeDictionary<String> dic = new NativeDictionary<>(10, String.class);

        int h = dic.hashFun("key1");
        dic.put("key1", "val1");
        dic.put("key1", "newVal1");

        assertEquals(1, dic.count);
        assertEquals(dic.slots[h], "key1");
        assertEquals(dic.values[h], "newVal1");
    }

    @Test
    void isKey() {
        NativeDictionary<String> dic = new NativeDictionary<>(10, String.class);

        int h = dic.hashFun("key1");
        dic.put("key1", "val1");

        boolean key1 = dic.isKey("key1");
        boolean key2 = dic.isKey("key2");

        assertTrue(key1);
        assertFalse(key2);
    }


    @Test
    void get() {
        NativeDictionary<String> dic = new NativeDictionary<>(10, String.class);

        int h = dic.hashFun("key1");
        dic.put("key1", "val1");

        String val = dic.get("key1");
        String nullval = dic.get("key12");

        assertEquals("val1", val);
        assertNull(nullval);
    }

    @Test
    void getLast() {
        NativeDictionary<String> dic = new NativeDictionary<>(5, String.class);

        int h = dic.hashFun("key1");
        dic.slots[4] = "key1";
        dic.values[4] = "val1";

        String key1 = dic.get("key1");
    }


    @Test
    void putInFullDict() {
        NativeDictionary<String> dic = new NativeDictionary<>(5, String.class);

        int h = dic.hashFun("key1");



        dic.put("key1", "val1");
        dic.put("key1", "val1");
        dic.put("key1", "val1");
        dic.put("key1", "val1");
        dic.put("key1", "val1");
        dic.put("key222", "val222");

    }
}