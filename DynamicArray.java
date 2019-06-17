//creates a dynamic array to store entry object
public class DynamicArray<E> {
	private E[] array;
	private int capacity;
	private int pointer = 0;
	private static final int DEFAULT_CAPACITY = 10;
	//default constructor
	public DynamicArray() {
		array = (E[]) (new Object[DEFAULT_CAPACITY]);
	}
	//argument constructor
	public DynamicArray(int capacity) {
		this.capacity = capacity;
		if(capacity > 0)
			array = (E[])(new Object[capacity]);
		else
			throw new IllegalArgumentException("Illegal Capacity: " + capacity); 	
	}
	//add e to the array
	public void add(E e) {
		checkcapacity();
		array[pointer] = e;
		pointer++;
	}
	//checks whether the array is full, if it is, extends the capacity by 10
	public void checkcapacity() {
		if(pointer == capacity) {
			//creates a new array whose capacity is 5 more than the old one
			E[] temp = (E[])(new Object[capacity+10]);
			//assigns the elements to the new array
			for(int i =0; i < capacity; i++) {
				temp[i] = array[i];
			}
			//assigns the reference of new array to the old array
			array = temp;
			capacity += 10;
		}
	}
	//gets the value associated with the index
	public E get(int index) {
		if(index < 0 || index > pointer)
			throw new IllegalArgumentException();
		return array[index];
	}
	
	//sets the new value on the index, and returns the old element 
	public E set(int index, E e) {
		if(index < 0 || index > pointer)
			throw new IllegalArgumentException();
		E old = array[index];
		array[index] = e;
		return old;
	}
	
	//removes and returns the element at index
	public E remove(int index) {
		if(index < 0 || index > pointer)
			throw new IllegalArgumentException();
		E old = this.get(index);
		//calculates the number of elements form the index to the end
		int num = pointer - 1 - index;
		//moves the elements forward
		if(num > 0) {
			for(int i = index; i < size()-1; i++) {
				E current = array[i];
				array[i] = array[i+1];
				array[i+1] = current;
			}
		}
		//clears the reference of the last element, and change size of array
		array[--pointer] = null;
		return old;
	}
	
	public int capacity() {
		return this.capacity;
	}
	
	public boolean isEmpty() {
		return pointer == 0;
	}
	public int size() {
		return pointer;
	}
}
