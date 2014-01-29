package basics;

/**
 * Implement a hash table using an array
 * */
class MyHashTable<K, V> {

	/* take the capacity as prime number to reduce the collision */

	private static int SIZE = 31;

	/* initialize array to store value */

	private V[] tableValues = (V[]) new Object[SIZE];

	public synchronized V put(K key, V value) {
		if (value == null) {
			throw new NullPointerException();
		}
		int index = hash(key.hashCode()) % SIZE;
		tableValues[index] = value;
		return value;
	}

	public synchronized V get(K key) {
		int index = hash(key.hashCode()) % SIZE;
		return tableValues[index];
	}

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
