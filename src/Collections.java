import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Collections {
	public static void main(String arg[]) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		System.out.println(arr.size());
		arr.add(1);
		arr.add(2);
		arr.add(3);
		
		Iterator<Integer> i = arr.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
		LinkedList<String> ll = new LinkedList<String>();
		ll.add("a");
		ll.add("b");
		ll.add("c");
		for(String s:ll) {
			System.out.println(s);
		}
		
		HashSet<Integer> hs = new HashSet<Integer>();
		hs.add(3);
		hs.add(6);
		hs.add(6);
		hs.add(7);
		hs.add(1);
		for(Integer si :hs) {
			System.out.println(si);
		}

		
		TreeSet<Integer> ths = new TreeSet<Integer>(hs);
		for(Integer tsi :ths) {
			System.out.println(tsi);
		}
		
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
	}
}
