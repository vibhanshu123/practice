import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;


public class NavigableTree {
	
	public static void main(String[] args){
		TreeSet<Integer> time=new TreeSet<Integer>();
		time.add(3);
		time.add(6);
		time.add(10);
		time.add(1);
		time.add(8);
		System.out.println(time);
		TreeSet<Integer> subTime= new TreeSet<Integer>();
		subTime = (TreeSet)time.headSet(7);
		System.out.println(time.lower(9));
		System.out.println(time.higher(9));
		//System.out.println(((TreeSet)time.tailSet(4)).first());
		System.out.println(time.pollLast());
		System.out.println(time.descendingSet());
		System.out.println(time);
		
		TreeMap<String, String> map= new TreeMap<String, String>();
		map.put("d", "dog");
		map.put("a", "ant");
		map.put("h", "horse");
		map.put("l", "lake");
		map.put("s", "sex");
		map.put("f", "fucks");
		System.out.println(map);
		System.out.println(map.headMap("f", false));
		System.out.println(map.tailMap("f", false));
		SortedMap<String, String> subMap;
		subMap=map.subMap("i", "k");
		subMap.put("j", "lund");
		//subMap.put("k", "kites");
		System.out.println(map+"    "+subMap);
	}

}
