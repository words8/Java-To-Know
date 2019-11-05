import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class PoolExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		Future <Integer> f1 = service.submit(new Summer(1, 9 ));
		Future <Integer> f2 = service.submit(new Summer(11, 99 ));
		Future <Integer> f3 = service.submit(new Summer(11, 23 ));
		Future <Integer> f4 = service.submit(new Summer(1, 10 ));
		
		try {
			System.out.println(f1.get());
			System.out.println(f2.get());
			System.out.println(f3.get());
			System.out.println(f4.get());

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		service.shutdown();
	}

}
