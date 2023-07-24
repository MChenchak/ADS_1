package lessons.cache;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NativeCacheTest {

    @Test
    @DisplayName("Добавление элемента в пустой кэш")
    void putInEmpty() {
        NativeCache<String> nc = new NativeCache<>(5, String.class);

        nc.put("key1", "val1");

        assertEquals(1, nc.count);
    }

    @Test
    @DisplayName("Добавление элемента в непустой кэш")
    void putIntoNotEmpty() {
        NativeCache<String> nc = new NativeCache<>(5, String.class);

        nc.put("key1", "val1");
        nc.put("key2", "val2");

        assertEquals(2, nc.count);
    }

    @Test
    @DisplayName("Добавление одного и того же элемента в непустой кэш")
    void putTheSame() {
        NativeCache<String> nc = new NativeCache<>(5, String.class);

        nc.put("key1", "val1");
        nc.put("key1", "val1");

        assertEquals(2, nc.count);
    }

    @Test
    @DisplayName("Запрос элемента из пустого кэша")
    void getFromEmpty() {
        NativeCache<String> nc = new NativeCache<>(5, String.class);

        String val = nc.get("key1");

        assertNull(val);
    }

    @Test
    @DisplayName("Запрос несуществующего элемента из непустого кэша")
    void getWhenNotExists() {
        NativeCache<String> nc = new NativeCache<>(5, String.class);
        nc.put("key1", "val1");

        String val = nc.get("key11");

        assertNull(val);
    }

    @Test
    @DisplayName("Запрос существующего элемента из непустого кэша")
    void getWhenExists() {
        NativeCache<String> nc = new NativeCache<>(5, String.class);
        nc.put("key1", "val1");

        int i = nc.hashFun("key1");
        String val = nc.get("key1");

        assertNotNull(val);
        assertEquals(1, nc.hits[i]);

    }

    @Test
    @DisplayName("Добавление нового элемента с вытеснением")
    void putWhenFull() {
        NativeCache<String> nc = new NativeCache<>(2, String.class);
        nc.put("key1", "val1");
        nc.put("key2", "val2");

        nc.get("key1");
        nc.get("key2");
        nc.get("key2");

        nc.put("key3", "val3");
        nc.put("key4", "val4");

        assertNull(nc.get("key1"));
        assertNotNull(nc.get("key4"));

    }









}