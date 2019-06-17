import java.util.Comparator;

public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
	int compacity;
	//creates a dynamic array stored the entry objects
	DynamicArray<Entry<K, V>> myHeap;
	
	//default constructor
	public HeapPriorityQueue() {
		myHeap = new DynamicArray<>();
	}
	
	public HeapPriorityQueue(int compacity) {
		myHeap = new DynamicArray<>(compacity);
	}
	
	public HeapPriorityQueue(Comparator<K> comp, int compacity) {
		super(comp);
		myHeap = new DynamicArray<>(compacity);
	}
	
	//returns the rank of the parent and children, the positions of right and left children nodes are 2i+1 and 2i+2 respectively
	public int parent(int i) {
		return (i-1)/2;
	}
	public int right(int i) {
		return 2 * i + 1;
	}
	public int left(int i) {
		return 2 * i + 2;
	}
	//verifies whether the current entry has a left or right child
	protected boolean hasRight(int i) {
		return right(i) < myHeap.size();
	}
	protected boolean hasLeft(int i) {
		return left(i) < myHeap.size();
	} 
	protected boolean hasChildren(int i) {
		return hasLeft(i) || hasRight(i);
	}
	//exchanges the entry at indices i and j
	protected void swap(int i, int j) {
		Entry<K, V> temp = myHeap.get(i);
		myHeap.set(i, myHeap.get(j));
		myHeap.set(j, temp);
	}
	
	//moves the entry at index j higher
	public void upheap(int i) {
		//loop until reaching the root , or the key is greater than or equal to that of parent
		while(i > 0) {
			//get the rank of its parent
			int p = parent(i);
			//restore the heap property
			if(compare(myHeap.get(i),myHeap.get(p)) >=0)
				break;
			swap(i, p);
			//gets the current rank of the entry
			i = p;
		}
	}
	
	//moves the entry at index j lower
	public void downheap(int i) {
		//since it's a proper heap, the last node is the rightmost of maximal height, we execute form left
		while(hasLeft(i)) {
			int leftIndex = left(i);
			int smallChild = leftIndex;
			//if 
			if(hasRight(i)) {
				int rightIndex = right(i);
				//gets the smaller key between left child and right child
				if(compare(myHeap.get(leftIndex), myHeap.get(rightIndex)) > 0)
					smallChild = rightIndex;
			}
			if(compare(myHeap.get(smallChild), myHeap.get(i)) >= 0)
				break;
			swap(i,smallChild);
			i=smallChild;
		}
	}
	
	
	//returns the top entry
	public Entry<K, V> top() {
		if(myHeap.isEmpty())
			return null;
		return myHeap.get(0);
	}
	//removes and returns the top entry
	public Entry<K, V> removeTop() {
		if(myHeap.isEmpty())
			return null;
		Entry<K, V> old = myHeap.get(0);
		//exchanges the 
		swap(0, myHeap.size() - 1);
		myHeap.remove(myHeap.size() - 1);
		downheap(0);
		return old;
	}
	
	//
	public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
		checkKey(key);
		Entry<K, V> in = new PQEntry<>(key,value);
		myHeap.add(in);
		upheap(myHeap.size()-1);
		return in;
	}
	
	//returns the number of entry stored in the PQ
	public int size() {
		return myHeap.size();
	}
	
	public int capacity() {
		return myHeap.capacity();
	}
}
