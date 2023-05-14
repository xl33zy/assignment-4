# Hash table implementation and test
The hashtable is implemented with an ArrayList of ArrayLists, where each inner ArrayList is a bucket containing nodes with a key-value pair. The nodes are implemented as a private static class with two template types, K and V, for key and value, respectively.

**Functions in MyHashTable:**
_put(K key, V value)_: adds a new key-value pair to the hashtable. If the key already exists, it updates its value.
_get(K key)_: retrieves the value associated with a given key from the hashtable.
_remove(K key)_: removes the node with the given key from the hashtable.
_size()_: returns the number of elements in the hashtable.
_printBuckets()_: prints the number of elements in each bucket of the hashtable.

Main class is reponsible for testing. Instance of MyHashTable generates 10000 random key-value pairs using MyTestingClass and Student classes. Then it prints the contents of the hashtable's buckets.
MyTestingClass generates a hashcode for a string object based on the sum of ASCII value of its characters and compares the value variable of MyTestingClass instances for equality.
Student class generates a hashcode based on the id and compares the passed object to a Student object with the same id and name field values.
