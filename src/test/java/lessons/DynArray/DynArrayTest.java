package lessons.DynArray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DynArrayTest {

    @Test
    @DisplayName("Изменение длины пустого массива. new_capacity > oldCapacity")
    void ensureArray() {
        DynArray array = new DynArray<>(Integer.class);
        array.makeArray(25);
        Assertions.assertEquals(25, array.capacity);

    }

    @Test
    @DisplayName("Изменение длины пустого массива. new_capacity <= oldCapacity")
    void ensureArrayWhenNewCapacityIsLess() {
        DynArray array = new DynArray<>(Integer.class);
        array.makeArray(15);
        Assertions.assertEquals(16, array.capacity);
    }

    @Test
    @DisplayName("Сильное изменение capacity")
    void changeCapacityTo16() {
        DynArray array = new DynArray<>(Integer.class);
        array.append(1);
        array.append(2);
        array.append(3);
        array.append(4);
        array.append(5);
        array.append(6);
        array.append(7);
        array.append(8);
        array.append(9);
        array.append(10);
        array.append(11);
        array.append(12);
        array.append(13);
        array.append(14);
        array.append(15);
        array.append(16);
        array.append(17);
        array.append(18);
        array.append(19);
        array.append(20);
        array.makeArray(1);
        Assertions.assertEquals(32, array.capacity);
        Assertions.assertEquals(20, array.count);
    }

    @Test
    @DisplayName("Добавление элемента в пустой массив")
    void AddToEmptyList() {
        DynArray array = new DynArray<>(Integer.class);
        array.append(12);

        Assertions.assertEquals(16, array.capacity);
        Assertions.assertEquals(1, array.count);
    }

    @Test
    @DisplayName("Добавление в конец полностью заполненного массива")
    void AddToFullList() {
        DynArray array = new DynArray<>(Integer.class);
        array.append(12);
        array.append(12);
        array.append(12);
        array.append(12);
        array.append(12);
        array.append(12);
        array.append(12);
        array.append(12);
        array.append(12);
        array.append(12);
        array.append(12);
        array.append(12);
        array.append(12);
        array.append(12);
        array.append(12);
        array.append(12);
        array.append(13);

        assertEquals(32, array.capacity);
        assertEquals(17, array.count);
    }

    @Test
    @DisplayName("Получение по индексу. index <= capacity")
    void getByIndexWhenInBound() {
        DynArray array = new DynArray<>(Integer.class);
        array.append(12);

        Object item = array.getItem(0);

        assertNotNull(item);
        assertEquals(16, array.capacity);
        assertEquals(1, array.count);
    }

    @Test
    @DisplayName("Получение по индексу. index out of bound")
    void getByIndexWhenOutOfBound() {
        DynArray array = new DynArray<>(Integer.class);
        array.append(12);

        assertThrows(IndexOutOfBoundsException.class, () -> array.getItem(100));
        assertEquals(16, array.capacity);
        assertEquals(1, array.count);
    }

    @Test
    @DisplayName("Вставка в конец заполненного массива")
    void InsertIntoFullList() {
        DynArray array = new DynArray<>(Integer.class);
        array.append(1);
        array.append(2);
        array.append(3);
        array.append(4);
        array.append(5);
        array.append(6);
        array.append(7);
        array.append(8);
        array.append(9);
        array.append(10);
        array.append(11);
        array.append(12);
        array.append(13);
        array.append(14);
        array.append(15);
        array.append(16);

        int count = array.count;

        array.insert(17, count);

        assertEquals(32, array.capacity);
        assertEquals(17, array.count);
    }

    @Test
    @DisplayName("Вставка в 'середину' заполненного массива")
    void InsertIntoFullListAmong() {
        DynArray array = new DynArray<>(Integer.class);
        array.append(12);
        array.append(12);
        array.append(12);
        array.append(12);
        array.append(12);
        array.append(12);
        array.append(12);
        array.append(12);
        array.append(12);
        array.append(12);
        array.append(12);
        array.append(12);
        array.append(12);
        array.append(12);
        array.append(12);
        array.append(12);

        array.insert(13, 5);


        assertEquals(13, (int) array.getItem(5));
        assertEquals(32, array.capacity);
        assertEquals(17, array.count);
    }

    @Test
    @DisplayName("Удаление крайнего элемента")
    void removeLast() {
        DynArray array = new DynArray<>(Integer.class);
        array.append(12);
        array.append(13);
        array.append(14);

        array.remove(2);

        assertNull(array.getItem(2));
        assertEquals(16, array.capacity);
        assertEquals(2, array.count);
    }

    @Test
    @DisplayName("Удаление из середины")
    void removeMiddleElement() {
        DynArray array = new DynArray<>(Integer.class);
        array.append(12);
        array.append(13);
        array.append(14);

        array.remove(1);

        assertEquals(14, (int)array.getItem(1));
        assertEquals(16, array.capacity);
        assertNull(array.getItem(2));
    }

    @Test
    @DisplayName("Удаление с изменением capacity")
    void removeAndChangeCapacity() {
        DynArray array = new DynArray<>(Integer.class);
        array.append(1);
        array.append(2);
        array.append(3);
        array.append(4);
        array.append(5);
        array.append(6);
        array.append(7);
        array.append(8);
        array.append(9);
        array.append(10);
        array.append(11);
        array.append(12);
        array.append(13);
        array.append(14);
        array.append(15);
        array.append(16);
        array.append(17);

        array.remove(0);
        array.remove(0);
        double rate = (double)array.count / (double)array.capacity;
        int newCapacity = (int) (array.capacity / 1.5);



        assertEquals(5, (int)array.getItem(2));
        assertEquals(21, array.capacity);
        assertEquals(15, array.count);
    }
}