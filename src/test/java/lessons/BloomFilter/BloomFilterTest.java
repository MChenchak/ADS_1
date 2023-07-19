package lessons.BloomFilter;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BloomFilterTest {

    @Test
    void createFilter() {
        BloomFilter bf = new BloomFilter(32);
        int a = bf.hash1("0123456789");
        int b = bf.hash2("0123456789");

        double len = Math.pow(0.6931, (32.0/10.0));

    }

    @Test
    void setAndGetBit() {
        BloomFilter bf = new BloomFilter(32);
        int a = 5;
        int b = bf.setBit(1, a);


        boolean getFromA = bf.getbit(a, 1);
        boolean getFromB = bf.getbit(b, 3);
    }


    @Test
    void isValueInEmpty() {
        BloomFilter bf = new BloomFilter(32);
        String val = "0123456789";

        boolean value = bf.isValue(val);

        assertFalse(value);
    }

    @Test
    void isValue() {
        BloomFilter bf = new BloomFilter(32);
        List<String> strings = List.of("0123456789","912345678");
        strings.forEach(x -> bf.add(x));

        assertTrue(bf.isValue("0123456789"));
        assertTrue(bf.isValue("912345678"));
        assertFalse(bf.isValue("891234567"));
    }
}