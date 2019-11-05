import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>();
		list.add(44);
		list.add(55);
		
		List<Integer> other = Collections.synchronizedList(list);
		
		Thread t1 = new Thread(()->{
			other.add(88);
			list.add(88);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list.add(22);
			other.add(22);
		});
		
		Thread t2 = new Thread(()-> {
			other.add(28);
			list.add(28);
			list.add(113);
			other.add(113);
		});
		t1.start();
		t2.start();
		System.out.println(list);
		System.out.println(other);
	}

}
