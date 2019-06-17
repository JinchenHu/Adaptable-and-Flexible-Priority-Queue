//interface for adaptable priority queue
public interface AdaptablePriorityQueue<K, V> extends PriorityQueue<K, V>{
	public abstract Entry<K, V> remove(Entry<K, V> e);
	public abstract K replaceKey(Entry<K, V> e, K k);
	public abstract V replaceValue(Entry<K, V> e, V v);
}
