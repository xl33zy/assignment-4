import java.util.Random;
import java.util.Objects;


public class Main {
    public static MyHashTable<String, Integer> hashTable;

    //creates a new MyHashTable instance and generates 10000 random key-value pairs using MyTestingClass and Student classes as key and value respectively. Finally, it prints the contents of the hash table's buckets
    public static void main(String[] args) {
//        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();
//        Random random = new Random();
//        for (int i = 0; i < 10000; i++) {
//            MyTestingClass key = new MyTestingClass(Integer.toString(random.nextInt(1000)));
//            Student value = new Student(5, "Trututu Barababa");
//            table.put(key, value);
//        }
//        table.printBuckets();

        testTwoTables();
    }

    private static void testTwoTables() {
        testFirstTable();
        cloneAndTestTable();
    }

    private static void testFirstTable() {
        hashTable = new MyHashTable<>();

        hashTable.put("One", 1);
        hashTable.put("Two", 2);
        hashTable.put("Three", 3);
        hashTable.put("Four", 4);
        hashTable.put("Five", 5);
        hashTable.put("Six", 6);
        hashTable.put("Seven", 7);
        hashTable.put("Eight", 8);
        hashTable.put("Nine", 9);
        hashTable.put("Ten", 10);

        System.out.println("Value for key 'Three': " + hashTable.get("Three"));  // Expected output: 3
        System.out.println("Value for key 'Two': " + hashTable.get("Two"));  // Expected output: 2
        System.out.println("Value for key 'Eleven': " + hashTable.get("Eleven"));  // Expected output: null

        hashTable.remove("Four");
        System.out.println("Value for key 'Four' after removal: " + hashTable.get("Four"));  // Expected output: null

        System.out.println("Contains key 'Three': " + hashTable.containsKey("Three"));  // Expected output: true
        System.out.println("Contains key 'Eleven': " + hashTable.containsKey("Eleven"));  // Expected output: false

        System.out.println("Size of hash table: " + hashTable.size());  // Expected output: 4

        hashTable.printBuckets();
    }

    private static void cloneAndTestTable() {
        MyHashTable<String, Integer> newHashTable = hashTable.cloneTable();

        System.out.println("Value for key 'Three': " + newHashTable.get("Three"));  // Expected output: 3
        System.out.println("Value for key 'Two': " + newHashTable.get("Two"));  // Expected output: 2
        System.out.println("Value for key 'Eleven': " + newHashTable.get("Eleven"));  // Expected output: null

        newHashTable.remove("Four");
        System.out.println("Value for key 'Four' after removal: " + newHashTable.get("Four"));  // Expected output: null

        System.out.println("Contains key 'Three': " + newHashTable.containsKey("Three"));  // Expected output: true
        System.out.println("Contains key 'Eleven': " + newHashTable.containsKey("Eleven"));  // Expected output: false

        System.out.println("Size of hash table: " + newHashTable.size());  // Expected output: 4

        newHashTable.printBuckets();
    }
}

class MyTestingClass {
    private String value;

    //accepts a string parameter value and assigns it to the instance variable value
    public MyTestingClass(String value) {
        this.value = value;
    }

    //returns value
    public String getValue() {
        return value;
    }

    //sets value
    public void setValue(String value) {
        this.value = value;
    }

    //generates a hash code for a String object based on the sum of the ASCII values of its characters
    @Override
    public int hashCode() {
        int result = 0;
        for (char c : value.toCharArray()) {
            result += (int) c;
        }
        return result;
    }

    //compares the value variable of MyTestingClass instances for equality
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyTestingClass that = (MyTestingClass) o;
        return Objects.equals(value, that.value);
    }
}

class Student {
    private int id;
    private String name;

    //takes an integer ID and a string Name as parameters and sets them to the corresponding instance variables
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //returns id
    public int getId() {
        return id;
    }

    //returns name
    public String getName() {
        return name;
    }

    //returns id
    @Override
    public int hashCode() {
        return id;
    }

    //returns true if the passed object is a Student object with the same id and name field values as this instance
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student student = (Student) obj;
        return id == student.id && Objects.equals(name, student.name);
    }
}




