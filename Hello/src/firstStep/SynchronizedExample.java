package firstStep;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
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
		
		Lock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		try {
			condition.await();
			condition.signal();
			condition.signalAll();
		} catch (Exception e2) {
			// TODO: handle exception
		}
//		CountDownLatch
		CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
		
	}
}
