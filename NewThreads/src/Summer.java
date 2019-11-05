import java.util.concurrent.Callable;

public class Summer implements Callable<Integer> {
	private int start;
	private int end;
	public Summer(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		int sum =0;
		for(int i=start; i<= end; i++)
		{
			sum+= i;
			System.out.println(Thread.currentThread() + ":" + i);
		}
		return sum;
	}

}
