package lessons.DynArray;

import java.lang.reflect.Array;
import java.util.*;

public class DynArray<T> {
    public T[] array;
    public int count;
    public int capacity;
    Class clazz;
    private static final int DEFAULT_CAPACITY = 10;

    public DynArray(Class clz) {
        clazz = clz;
        count = 0;
        makeArray(16);
    }

    public void makeArray(int new_capacity) {
        if (new_capacity < count) {
            return;
        }

        if (array == null) {
            array = (T[]) Array.newInstance(this.clazz, new_capacity);
            capacity = array.length;
            return;
        }

        if (new_capacity > 16) {
            array = Arrays.copyOf(array, new_capacity);
            capacity = new_capacity;
        } else {
            array = Arrays.copyOf(array, 16);
            this.capacity = 16;
        }
    }

    public T getItem(int index) {
        rangeCheck(index);
        return (T) array[index];
    }

    public void append(T itm) {
        if (count == array.length) {
            makeArray(capacity * 2);
        }
        array[count] = itm;
        count++;
    }

    public void insert(T itm, int index) {
        rangeCheck(index);

        if (count == capacity) {
            makeArray(capacity * 2);
        }
        System.arraycopy(array, index, array, index + 1, count - index);
        array[index] = itm;
        count++;
    }

    public void remove(int index) {
        rangeCheck(index);
        int newCount = count - 1;
        if (newCount > index) {
            System.arraycopy(array, index + 1, array, index, newCount - index);
        }
        count = newCount;
        array[newCount] = null;

        double rate = checkCapacityRate();
        if (rate < 0.5) {
            int newCapacity = (int) (capacity / 1.5);
            if (newCapacity > 16) {
                makeArray(newCapacity);
            } else {
                makeArray(16);
            }
        }
    }

    private double checkCapacityRate() {
        return (double) count / (double) capacity;
    }

    private void rangeCheck(int index) {
        if (index > capacity || index < 0)
            throw new IndexOutOfBoundsException("Index out of bound");
    }

}
