package lessons.BloomFilter;

public class BloomFilter {
    public int filter_len;
    private int bitArr = 0;

    public BloomFilter(int f_len) {
        filter_len = f_len;
    }

    public int hash1(String str1) {
        // 17
        int hash = 0;
        for (int i = 0; i < str1.length(); i++) {
            int code = (int) str1.charAt(i);
            hash = (hash * 17 + code) % filter_len;
        }
        return hash;
    }

    public int hash2(String str1) {
        // 223
        int hash = 0;
        for (int i = 0; i < str1.length(); i++) {
            int code = (int) str1.charAt(i);
            hash = (hash * 223 + code) % filter_len;
        }
        return hash;
    }

    public void add(String str1) {
        if (isValue(str1)) {
            return;
        }
        bitArr = setBit(hash1(str1), bitArr);
        bitArr = setBit(hash2(str1), bitArr);
    }

    public boolean isValue(String str1) {
        int hash1 = hash1(str1);
        int hash2 = hash2(str1);

        return getbit(bitArr, hash1) && getbit(bitArr, hash2);
    }


    public int setBit(int bit, int target) {
        int mask = 1 << bit;
        return target | mask;
    }

    public boolean getbit(final int x, final int p) {
        return (x & (1 << (p))) != 0;
    }
}