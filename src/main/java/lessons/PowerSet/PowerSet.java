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
        if (get(value)) {
            return;
        }
        table.add(value);
    }

    public boolean get(String value) {
        if (size() == 0) {
            return false;
        }

        for (String s : table) {
            if (s == value) {
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

        return resultSet.size() > 0 ? resultSet : null;
    }

    public PowerSet union(PowerSet set2) {
        if (size() == 0 && set2.size() == 0) {
            return null;
        }

        for (String s : set2.table) {
            if (!get(s)) {
                this.put(s);
            }
        }
        return this;
    }

    public PowerSet difference(PowerSet set2) {
        PowerSet resultSet = new PowerSet();

        for (String s : table) {
            if (!set2.get(s)) {
                resultSet.put(s);
            }
        }

        return resultSet.size() > 0 ? resultSet : null;
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