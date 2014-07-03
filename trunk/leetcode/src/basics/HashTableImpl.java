package basics;

import java.util.LinkedList;
import java.util.List;

/**
 * Implement a hash table using an array
 * 
 * That should handle collision
 * */

// consider multi-threading

/**
 * Here the entry can also be implemented
 * as a list node, with a node pointing to the rest
 * */

/**
 * To make it thread-safe, can use read-write lock
 * 
 * also, be careful to make some data structure volatile
 * 
 * Volatile variable: : two threads may have their local copies
 * 
 * 
 * lock.read();
 * try {
 *    xxx
 *    
 * } finally {
 *    lock.unlock();
 * }
 * 
 * */

class MyEntry<K, V> {
	K key;
	V value;
	public MyEntry(K k, V v) {
		key = k;
		value = v;
	}
}

class MyHashTable<K, V> {

	/* take the capacity as prime number to reduce the collision */

	private static int SIZE = 31;

	/* initialize array to store value */

	private List<MyEntry>[] tableValues = new List[SIZE];

	public synchronized V put(K key, V value) {
		if (value == null) {
			throw new NullPointerException();
		}
		int index = hash(key.hashCode()) % SIZE;
		if(tableValues[index] == null) {
			tableValues[index] = new LinkedList<MyEntry>();
		}
		for(MyEntry<K, V> e : tableValues[index]) {
			if(e.key.equals(key)) {
				e.value = value;
				return value;
			}
		}
		tableValues[index].add(new MyEntry(key, value));
		return value;
	}

	public synchronized V get(K key) {
		int index = hash(key.hashCode()) % SIZE;
		for(MyEntry<K, V> e : tableValues[index]) {
			if(e.key.equals(key)) {
				return e.value;
			}
		}
		return null;
	}

	//rehash function will copy every entry to the new place
	
	/**
	 * 
	 * method calculates the hash code
	 */

	private synchronized int hash(int h) {
		h ^= (h >>> 20) ^ (h >>> 12);
		return h ^ (h >>> 7) ^ (h >>> 4);
	}

	public static void main(String arg[]) {
		MyHashTable<String, String> table = new MyHashTable<String, String>();
		/* store 10 values in Hashtable */
		for (int i = 0; i < 10; i++) {
			table.put("key" + i, "value" + i);
		}

		/* retrive values */
		for (int i = 0; i < 10; i++) {
			System.out.println(table.get("key" + i));
		}
	}
}
