import java.util.ArrayList;

public class MyHashTable<K, V> {
    private ArrayList<ArrayList<Node<K, V>>> buckets;
    private int size;

    //initializes a hash table with 10 empty buckets, each represented by an empty ArrayList. The size of the hash table is set to zero
    public MyHashTable() {
        buckets = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<>());
        }
        size = 0;
    }

    //function takes a key and a value, calculates the hash of the key, then adds the key-value pair to a bucket in an array of buckets. If the key already exists in the bucket, its value is updated.
    public void put(K key, V value) {
        int hash = key.hashCode() % buckets.size();
        ArrayList<Node<K, V>> bucket = buckets.get(hash);
        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        bucket.add(new Node<>(key, value));
        size++;
    }

    //returns the value associated with a given key from an ArrayList of nodes. If the key is not found, it returns null
    public V get(K key) {
        int hash = key.hashCode() % buckets.size();
        ArrayList<Node<K, V>> bucket = buckets.get(hash);
        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    //takes a key, computes a hashcode based on the key and removes the node with the given key from the ArrayList of nodes in the corresponding bucket, reducing the size by 1 if successful
    public void remove(K key) {
        int hash = key.hashCode() % buckets.size();
        ArrayList<Node<K, V>> bucket = buckets.get(hash);
        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                bucket.remove(node);
                size--;
                return;
            }
        }
    }

    public boolean containsKey(K key) {
        int hash = getHash(key);
        ArrayList<Node<K, V>> bucket = buckets.get(hash);
        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    private int getHash(K key) {
        return key.hashCode() % buckets.size();
    }

    //returns size
    public int size() {
        return size;
    }

    //prints the number of elements in each bucket of a hash table. It iterates through all the buckets and prints their index and size
    public void printBuckets() {
        for (int i = 0; i < buckets.size(); i++) {
            ArrayList<Node<K, V>> bucket = buckets.get(i);
            System.out.println("Bucket " + i + ": " + bucket.size() + " elements");
        }
    }

    public MyHashTable<K, V> cloneTable() {
        MyHashTable<K, V> newTable = new MyHashTable<>();

        for (ArrayList<Node<K, V>> bucket : buckets) {
            for (Node<K, V> node : bucket) {
                K key = node.key;
                V value = node.value;
                newTable.put(key, value);
            }
        }

        return newTable;
    }

    //defines a private static Node class with two template types K and V for key and value respectively. It has a constructor to initialize the key and value
    private static class Node<K, V> {
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}

