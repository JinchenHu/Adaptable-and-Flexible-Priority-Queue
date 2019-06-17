
public class HeapAFPQ<K, V> extends HeapAdapatablePriorityQueue<K, V> implements FlexiblePriorityQueue<K, V>{
	boolean flag = true;
	//int count = 0;
	public HeapAFPQ() {
	}
	public HeapAFPQ(int capacity) {
		super(capacity);
	}
	public HeapAFPQ(boolean flag) {
		super();
		this.flag = flag;
	}
	public HeapAFPQ(int capacity, boolean flag) {
		super(capacity);
		this.flag = flag;
	}
	
	//determines whether it's a max-heap or min-heap
	protected int compare(Entry<K, V> e1, Entry<K, V> e2) {
		//if the flag is true, then it's based on min-heap
		if(flag)
			return comp.compare(e1.getKay(), e2.getKay());
		//otherwise, it's based on max-heap
		else
			return comp.compare(e2.getKay(), e1.getKay());
	}
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	
	
	public String toString() {
		String result = "Size: " + size() + " - State: " + state() + " - ";
		for(int i = 0; i < myHeap.size(); i++) {
			result += myHeap.get(i).toString() + "=>";
		}
		return result;
	}
	
	private void convert(int i) {
		//count++;
		int most = i;
		//comparison of current node and its children
		if(hasLeft(i) && compare(myHeap.get(left(i)), myHeap.get(most)) < 0)
			most = left(i);
		if(hasRight(i) && compare(myHeap.get(right(i)), myHeap.get(most)) < 0)
			most = right(i);
		//now, we get the index with the maximal/minimal key among the node and its children
		
		//if the key of current node is the greatest or it's an external node, the method terminates
		//otherwise, exchange the entries of current node and its greater child,
		//then, continues to compare the key of the entry exchanged downward with the keys of its children nodes
		if(most != i && hasChildren(i)) {
			swap(i, most);
			//continues until the 
			convert(most);
		}
	}
	
	public void toggle() {
		//changes the format of current AFPQ
		setFlag(!flag);
		//bottom up from the last internal node
		for(int i = ((size()-2)/2); i >=0; i--)
			convert(i);
	}
	
	
	public String state() {
		if(flag)
			return "*Min*";
		else
			return "*Max*";
		
	}
}
