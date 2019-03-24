package firstStep;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class SynchronizedExample{
	public void fun(){
		synchronized (this) {
			for(int i=0;i<20;i++)
				System.out.print(i+" ");
			System.out.println();
		}
	}
	public static void main(String[] args){
		ExecutorService es = Executors.newCachedThreadPool();
		SynchronizedExample e = new SynchronizedExample();
		es.execute(()->e.fun());
		es.execute(()->e.fun());
		es.execute(()->e.fun());
	}
}
