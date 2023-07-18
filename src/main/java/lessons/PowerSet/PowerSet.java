package lessons.PowerSet;

public class PowerSet {
    public HashTable table;

    public PowerSet() {
        table = new HashTable(20000, 10);
    }

    public int size() {
        return table.count;
    }

    public void put(String value) {
        if (value == null || get(value)) {
            return;
        }
        table.put(value);
    }

    public boolean get(String value) {
        if (size() == 0) {
            return false;
        }

        for (String s : table.slots) {
            if (s == value) {
                return true;
            }
        }

        return false;
    }

    public boolean remove(String value) {
        int index = table.find(value);
        if (index < 0) {
            return false;
        }

        table.slots[index] = null;
        table.count--;
        return true;
    }

    public PowerSet intersection(PowerSet set2) {
        PowerSet resultSet = new PowerSet();
        for (String s : table.slots) {
            if (set2.get(s)) {
                resultSet.put(s);
            }
        }

        if (resultSet.size() > 0) {
            return resultSet;
        }

        return null;
    }

    public PowerSet union(PowerSet set2) {
        if (size() == 0 && set2.size() == 0) {
            return null;
        }
        String[] second = set2.table.slots;

        for (String s : second) {
            if (!get(s)) {
                this.put(s);
            }
        }
        return this;
    }

    public PowerSet difference(PowerSet set2) {
        PowerSet resultSet = new PowerSet();

        for (String s : table.slots) {
            if (!set2.get(s)) {
                resultSet.put(s);
            }
        }

        if (resultSet.size() > 0) {
            return resultSet;
        }

        return null;
    }

    public boolean isSubset(PowerSet set2) {
        if (set2.size() > this.size()) {
            return false;
        }

        String[] second = set2.table.slots;

        for (String s : second) {
            if (!get(s)) {
                return false;
            }
        }
        return true;
    }

}

