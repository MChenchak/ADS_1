package lessons.PowerSet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerSetTest {

    @Test
    void putNewInEmpty() {
        PowerSet set = new PowerSet();
        set.put("val1");

        assertEquals(1, set.size());
    }

    @Test
    void putTheSameTwise() {
        PowerSet set = new PowerSet();
        set.put("val1");
        set.put("val1");
        set.put("val2");

        assertEquals(2, set.size());
    }

    @Test
    void removeWhenExists() {
        PowerSet set = new PowerSet();
        set.put("val1");

        boolean del = set.remove("val1");
        boolean get = set.get("val1");

        assertTrue(del);
        assertFalse(get);
        assertEquals(0, set.size());
    }

    @Test
    void removeWhenNotExists() {
        PowerSet set = new PowerSet();
        set.put("val1");

        boolean val12 = set.remove("val12");
        boolean get = set.get("val1");

        assertTrue(get);
        assertFalse(val12);
        assertEquals(1, set.size());
    }

    @Test
    void intersection() {
        PowerSet set1 = new PowerSet();
        set1.put("val1");
        set1.put("val2");
        set1.put("val3");

        PowerSet set2 = new PowerSet();
        set2.put("val1");
        set2.put("val11");
        set2.put("val3");

        PowerSet intersection = set1.intersection(set2);

        assertEquals(2, intersection.size());
        assertTrue(intersection.get("val1"));
        assertTrue(intersection.get("val3"));

    }

    @Test
    void EmptyIntersection() {
        PowerSet set1 = new PowerSet();
        set1.put("val1");
        set1.put("val2");
        set1.put("val3");

        PowerSet set2 = new PowerSet();
        set2.put("val14");
        set2.put("val11");
        set2.put("val34");

        PowerSet intersection = set1.intersection(set2);

        assertNull(intersection);
    }

    @Test
    void union() {
        PowerSet set1 = new PowerSet();
        set1.put("val1");
        set1.put("val2");
        set1.put("val3");

        PowerSet set2 = new PowerSet();
        set2.put("val1");
        set2.put("val11");
        set2.put("val3");

        PowerSet union = set1.union(set2);

        assertEquals(4, union.size());
    }

    @Test
    void unionWhenOneSetIsEmpty() {
        PowerSet set1 = new PowerSet();
        set1.put("val1");
        set1.put("val2");
        set1.put("val3");

        PowerSet set2 = new PowerSet();

        PowerSet union = set1.union(set2);

        assertEquals(3, union.size());
    }

    @Test
    @DisplayName("все элементы параметра входят в текущее множество")
    void isSubset1() {
        PowerSet set1 = new PowerSet();
        set1.put("val1");
        set1.put("val2");
        set1.put("val3");
        set1.put("val4");
        set1.put("val5");

        PowerSet paramSet = new PowerSet();
        paramSet.put("val1");
        paramSet.put("val2");
        paramSet.put("val3");

        boolean subset = set1.isSubset(paramSet);

        assertTrue(subset);
    }

    @Test
    @DisplayName("все элементы текущего множества входят в параметр")
    void isSubset2() {
        PowerSet set1 = new PowerSet();
        set1.put("val1");
        set1.put("val2");
        set1.put("val3");
        set1.put("val4");


        PowerSet paramSet = new PowerSet();
        paramSet.put("val1");
        paramSet.put("val2");
        paramSet.put("val3");
        paramSet.put("val4");
        paramSet.put("val5");

        boolean subset = set1.isSubset(paramSet);

        assertFalse(subset);
    }

    @Test
    @DisplayName("не все элементы параметра входят в текущее множество")
    void isSubset3() {
        PowerSet set1 = new PowerSet();
        set1.put("val1");
        set1.put("val2");
        set1.put("val3");
        set1.put("val4");
        set1.put("val5");


        PowerSet paramSet = new PowerSet();
        paramSet.put("val1");
        paramSet.put("val2");
        paramSet.put("val3");
        paramSet.put("val4");
        paramSet.put("val6");

        boolean subset = set1.isSubset(paramSet);

        assertFalse(subset);
    }

    @Test
    void difference() {
        PowerSet set1 = new PowerSet();
        set1.put("val1");
        set1.put("val2");
        set1.put("val3");
        set1.put("val4");
        set1.put("val5");

        PowerSet paramSet = new PowerSet();
        paramSet.put("val1");
        paramSet.put("val2");
        paramSet.put("val3");
        paramSet.put("val4");
        paramSet.put("val16");

        PowerSet difference = set1.difference(paramSet);

        assertTrue(difference.get("val5"));
    }

}