//interface for the PQ ADT
public interface PriorityQueue<K, V> {
	//returns the size of the PQ
	public int size();
	//inserts a key-value pair into the PQ and returns this entry
	public abstract Entry<K, V> insert(K key, V value) throws IllegalArgumentException;
	//returns the top entry
	public abstract Entry<K, V> top();
	//removes and returns the top entry
	public abstract Entry<K, V> removeTop();
	
}
