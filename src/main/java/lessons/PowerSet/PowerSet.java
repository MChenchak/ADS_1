package lessons.PowerSet;

public class PowerSet {
    private List<String> table;

    public PowerSet() {
        table = new ArrayList<>(200000);
    }

    public int size() {
        return table.size();
    }

    public void put(String value) {
        if (value == null || get(value)) {
            return;
        }
        table.add(value);
    }

    public boolean get(String value) {
        if (size() == 0) {
            return false;
        }

        for (String s : table) {
            if (s.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public boolean remove(String value) {
        return table.remove(value);
    }

    public PowerSet intersection(PowerSet set2) {
        PowerSet resultSet = new PowerSet();

        for (String s : table) {
            if (set2.get(s)) {
                resultSet.put(s);
            }
        }

        return resultSet.size() > 0 ? resultSet : new PowerSet();
    }

    public PowerSet union(PowerSet set2) {
        if (size() == 0 && set2.size() == 0) {
            return new PowerSet();
        }

        PowerSet union = new PowerSet();

        for (String s : this.table) {
            union.put(s);
        }

        for (String s : set2.table) {
            union.put(s);
        }
        return union;
    }

    public PowerSet difference(PowerSet set2) {
        PowerSet resultSet = new PowerSet();

        for (String s : table) {
            if (!set2.get(s)) {
                resultSet.put(s);
            }
        }

        return resultSet.size() > 0 ? resultSet : new PowerSet();
    }

    public boolean isSubset(PowerSet set2) {
        if (set2.size() > this.size()) {
            return false;
        }

        for (String s : set2.table) {
            if (!get(s)) {
                return false;
            }
        }
        return true;
    }
}