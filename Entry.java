//interface for a key-value pair
public interface Entry<K,V> {
	//returns the key stored in the entry
	public abstract K getKay();
	//returns the value stored in the entry
	public abstract V getValue();
}
