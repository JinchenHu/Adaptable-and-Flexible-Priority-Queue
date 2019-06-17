import java.util.Comparator;

public class DefaultComparator<K> implements Comparator<K>{
	public int compare(K k1, K k2) throws ClassCastException{
		return ((Comparable<K>) k1).compareTo(k2);
	}

}
