
public class HeapAdapatablePriorityQueue<K, V> extends HeapPriorityQueue<K, V> implements AdaptablePriorityQueue<K, V> {
	public static class AdaptablePQEntry<K, V> extends PQEntry<K, V>{
		private int index;
		public AdaptablePQEntry(K k, V v){
			super(k, v);
		}
		public void setIndex(int index) {
			this.index = index;
		}
		public int getIndex() {
			return this.index;
		}
	}
	//constructors
	public HeapAdapatablePriorityQueue() {}
	public HeapAdapatablePriorityQueue(int compacity) {
		super(compacity);
	}
	
	//validates an entry to ensure it is location-aware
	protected AdaptablePQEntry<K, V> validate(Entry<K, V> entry) throws IllegalArgumentException{
		//verifies whether the entry is valid
		if(!(entry instanceof AdaptablePQEntry))
			throw new IllegalArgumentException("invalid entry");
		//down-casts the entry object
		AdaptablePQEntry<K, V> locator = (AdaptablePQEntry<K,V>) entry;
		//get the index of the locator
		int i = locator.getIndex();
		//checks the validation of the index
		if(i >= myHeap.size() || myHeap.get(i) != locator)
			throw new IllegalArgumentException("invalid entry");
		return locator;
			
	}
	
	//exchanges the entries at indices i and j
	protected void swap(int i, int j) {
		//swaps the key-value pairs of two entries
		super.swap(i, j);
		//swaps the indices of two entries
		((AdaptablePQEntry<K, V>) myHeap.get(i)).setIndex(i);
		((AdaptablePQEntry<K, V>) myHeap.get(j)).setIndex(j);
	}
	
	//restores the heap property by moving the entry at index i upward or downward
	protected void bubble(int i) {
		//assume it's a min-heap,if the key of the current entry is smaller than the key of its parent, 
		//does the up-heap; otherwise, does the down-heap, and vice verse
		if(i > 0 && compare(myHeap.get(i),myHeap.get(parent(i))) < 0)
			upheap(i);
		else
			downheap(i);
	}
	
	//insert a key-value pair and returns the entry created
	public Entry<K, V> insert(K k, V v) throws IllegalArgumentException{
		checkKey(k);
		AdaptablePQEntry<K, V> in = new AdaptablePQEntry<K, V>(k, v);
		in.setIndex(myHeap.size());
		myHeap.add(in);
		//upheap the new entry, since the swap method has been overridden, we don't need to reset the index
		upheap(myHeap.size() - 1);
		return in;
	}
	
	//removes the given entry
	public Entry<K, V> remove(Entry<K, V> e) {
		AdaptablePQEntry<K, V> locator = validate(e);
		int i = locator.getIndex();
		//removes the entry if it is at last position
		if(i == myHeap.size() - 1)
			myHeap.remove(myHeap.size() - 1);
		else {
			//swap the entry to the last position
			swap(i, myHeap.size() - 1);
			myHeap.remove(myHeap.size() - 1);
			//restore the heap property according to the rank of key
			bubble(i);
		}
		return locator;
	}

	//replaces the key of the passing entry
	public K replaceKey(Entry<K, V> e, K k) throws IllegalArgumentException{
		AdaptablePQEntry<K, V> locator = validate(e);
		K old = locator.getKay();
		checkKey(k);
		//resets the key of the entry
		locator.setKey(k);
		//restore the heap property
		bubble(locator.getIndex());
		return old;
	}

	public V replaceValue(Entry<K, V> e, V v) throws IllegalArgumentException{
		AdaptablePQEntry<K, V> locator = validate(e);
		V old = locator.getValue();
		//resets the value
		locator.setValue(v);
		return old;
	}
}
