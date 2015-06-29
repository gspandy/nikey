package net.docs.design.pattern.consumerproducer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {

	private volatile boolean isRunning = true;
	private BlockingQueue<PCData> queue;
	private static AtomicInteger count = new AtomicInteger();
	private static final int SLEEPTIME = 1000;
	
	public Producer(BlockingQueue<PCData> queue){
		this.queue = queue;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		PCData data = null;
		Random r = new Random();
		System.out.println("Start producer id="+Thread.currentThread().getId());
		try {
			while(isRunning){
			   Thread.sleep(r.nextInt(SLEEPTIME));
			   data = new PCData(count.incrementAndGet());
			   System.out.println(data+" is put int queue");
			   if(!queue.offer(data,2,TimeUnit.SECONDS)){
				   System.out.println("failed to put data :"+data);
			   }
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}

	public void stop(){
		this.isRunning = false;
	}
	
}
