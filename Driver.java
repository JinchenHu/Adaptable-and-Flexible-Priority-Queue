
public class Driver {
	public static void main(String[] args) {
		//creates a AFPQ with default constructor
		//min-heap with 10 capacities
		HeapAFPQ<Integer, String> h1 = new HeapAFPQ<Integer, String>();
		h1.insert(22, "A");
		h1.insert(45, "A");
		h1.insert(20, "A");
		h1.insert(2, "A");
		h1.insert(37, "A");
		h1.insert(33, "A");
		System.out.println("Size: " + h1.size() +"; Capacity: " + h1.capacity());
		Entry<Integer, String> e1 = h1.insert(4, "4");
		h1.insert(7, "A");
		h1.insert(10, "A");
		h1.insert(6, "A");
		h1.insert(26, "A");
		Entry<Integer, String> e2 = h1.insert(41, "41");
		h1.insert(14, "A");
		h1.insert(29, "A");
		h1.insert(34, "A");
		System.out.println("After insert 9 entrise. Size: " + h1.size() +"; Capacity: " + h1.capacity());
		Entry<Integer, String> e3 = h1.insert(29, "A");
		h1.insert(46, "A");
		Entry<Integer, String> e4 = h1.insert(12, "A");
		h1.insert(24, "A");
		h1.insert(30, "A");
		System.out.println("\nPrint the PQ: \n\t" + h1);
		System.out.println();
		System.out.println("The top entry is: " + h1.top());
		System.out.println("The top entry " + h1.removeTop() + " has been removed");
		System.out.println("Print the PQ: \n\t" + h1);
		System.out.println();
		System.out.println("Remove the entry: " + h1.remove(e3));
		System.out.println("Print the PQ: \n\t" + h1);
		System.out.println();
		System.out.println("Replace the key of the entry " + e1 +" with 8, the old key is: "+h1.replaceKey(e1, 8));
		System.out.println("Print the PQ: \n\t"+h1);
		System.out.println();
		System.out.println("Replace the value of the entry " + e1 +" with A, the old value is: "+h1.replaceValue(e1, "A"));
		System.out.println("Print the PQ: \n\t"+h1);
		System.out.println();
		Entry<Integer, String> e5 = h1.insert(1, "new");
		System.out.println("Insert the entry: " + e5);
		System.out.println("Print the PQ: \n\t"+h1);
		System.out.println();
		
		System.out.println("\n======================================================= Convert MIN-HEAP to MAX-HEAP =======================================================\n");
		
		h1.toggle();
		System.out.println("Print the PQ: \n\t" + h1);
		System.out.println();
		System.out.println("The top entry is: " + h1.top());
		System.out.println("The top entry " + h1.removeTop() + " has been removed");
		System.out.println("Print the PQ: \n\t" + h1);
		System.out.println();
		System.out.println("Remove the entry: " + h1.remove(e4));
		System.out.println("Print the PQ: \n\t" + h1);
		System.out.println();
		System.out.println("Replace the key of the entry " + e2 +" with 15, the old key is: "+h1.replaceKey(e2, 15));
		System.out.println("Print the PQ: \n\t"+h1);
		System.out.println();
		System.out.println("Replace the value of the entry " + e2 +" with A, the old value is: "+h1.replaceValue(e2, "A"));
		System.out.println("Print the PQ: \n\t"+h1);
		Entry<Integer, String>	e6 = h1.insert(70, "BIG");
		System.out.println("Insert the entry: " + e6);
		System.out.println("Print the PQ: \n\t"+h1);
		
		System.out.println("\n======================================================= Convert MAX-HEAP to MIN-HEAP =======================================================\n");
		h1.toggle();
		System.out.println("Print the PQ: \n\t" + h1);
	}
}
