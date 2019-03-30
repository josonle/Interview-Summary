package Test329;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		AtomicLong
//		LongAdder
		BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(5);
		ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, queue);
	}

}
