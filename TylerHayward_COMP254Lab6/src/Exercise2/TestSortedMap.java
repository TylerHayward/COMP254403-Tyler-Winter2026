package Exercise2;

public class TestSortedMap {
    public static void main(String[] args) {

        SortedTableMap<Integer, String> map = new SortedTableMap<>();

        map.put(10, "A");
        map.put(20, null);

        System.out.println(map.get(10));          // A
        System.out.println(map.get(20));          // null

        System.out.println(map.containsKey(10));  // true
        System.out.println(map.containsKey(20));  // true
        System.out.println(map.containsKey(30));  // false
    }
}