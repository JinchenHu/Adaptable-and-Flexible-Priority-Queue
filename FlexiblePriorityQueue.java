
public interface FlexiblePriorityQueue<K,V> extends PriorityQueue<K, V> {
	public abstract String state();
	public abstract void toggle();
	
}
