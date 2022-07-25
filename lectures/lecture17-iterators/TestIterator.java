import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.*;

public class TestIterator {

	@Test
	public void testIterartor() {
		
		ArrayList<String> list = new ArrayList<>();
		
		list.add("a");
		list.add("b");
		list.add("c");

		Iterator<String> iter = list.iterator();
		System.out.println(iter);
		
		//System.out.println(iter.next());

		//list.add("d");
		//list.set(1, "zzzzz");
		
		//System.out.println(iter.next());
		
		
		
		//Iterator<String> iter2 = list.iterator();
		//System.out.println(iter2.next());
		//System.out.println(iter2.next());
		
		AList<Integer> a = new AList<Integer>();
		//a.add(1);
		//a.add(2);
		//a.add(3);
		
		Iterator<Integer> iter1 = a.iterator();
		System.out.println(iter1);
		//System.out.println(iter1.next());
		//System.out.println(iter1.next());
		//System.out.println(iter1.next());
		//System.out.println(iter1.next());
		
		//for (Integer i : a) {
		//	System.out.println(i);
		//}
	}
	

	@Test
	public void testRange() {

		Range r = new Range(0, 100);
		
		int sum = 0;
		for (Integer i: r) {
			sum += i;
		}
		System.out.println(sum);
		
		int sumAgain = 0;
		for (Integer i: r) {
			sumAgain += i;
		}
		System.out.println(sumAgain);

		
		MemoryStream<Integer> stream = new MemoryStream<>();
		ArrayList<Integer> aList = new ArrayList<>();
		
		for (int i = 0; i < 100; i++) {
			aList.add(i);
			stream.write(i);
		}
		
		System.out.println(sum(aList));
		System.out.println(sum(stream));
	}

	// Idea:
	Integer sum(Iterable<Integer> iterable) {
		int sum = 0;
		for(Integer i: iterable) {
			sum += i;
		}
		return sum;
	}
	
	@Test
	public void testTransformed() {
		
		Range r = new Range(0, 10);
		
		for (Integer i : r) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		Transformed<Integer> t = 
				new Transformed<Integer>(r, new AddThree());
		
		for (Integer i : t) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		t = new Transformed<Integer>(r, new ModValue(5));
		for (Integer i : t) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
}