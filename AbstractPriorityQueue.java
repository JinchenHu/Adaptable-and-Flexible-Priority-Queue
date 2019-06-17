import java.util.Comparator;

//an abstract base class to assist implementations of the PQ interface
public abstract class AbstractPriorityQueue<K, V> implements PriorityQueue<K, V>{
	protected static class PQEntry<K, V> implements Entry<K, V>{
		private K k;
		private V v;
		public PQEntry() {}
		public PQEntry(K k, V v) {
			this.k = k;
			this.v = v;
		}
		//override the methods of Entry interface
		public K getKay() {
			return k;
		}
		public V getValue() {
			return v;
		}
		//
		public void setKey(K k) {
			this.k = k;
		}
		//
		public void setValue(V v) {
			this.v = v;
		}
		public String toString() {
			return "[Key: " + k.toString() +", value:"+ v.toString()+ "]";
		}
	}//end of PQEntry class
	
	//the comparator defining the ordering of keys in the PQ
	protected Comparator<K> comp;
	//creates an empty PQ using the given comparator to order keys
	protected AbstractPriorityQueue(Comparator<K> comp) {
		this.comp = comp;
	}
	//sorts the PQ according to the law we defines
	protected AbstractPriorityQueue() {
		this(new DefaultComparator<K>());
	}
	//compares two entries according to their keys
	
	protected int compare(Entry<K, V> e1, Entry<K, V> e2) {
		return comp.compare(e1.getKay(), e2.getKay());
	}
	//checks if the key is valid
	protected boolean checkKey(K k) throws IllegalArgumentException{
		try {
			return (comp.compare(k, k) == 0);
		}catch(ClassCastException e) {
			throw new IllegalArgumentException();
		}
	}
	
//	public String toString() {
//		PQEntry<K, V> pq = new PQEntry<K,  V>();
//		return pq.getKay().toString() + pq.getValue().toString() ;
//	}
	//returns true if the PQ is empty, returns false otherwise
	public boolean isEmpty() {
		return size() == 0;
	}
	
}//end of AbstractPriorityQueue
