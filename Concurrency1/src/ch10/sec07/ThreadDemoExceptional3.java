package ch10.sec07;

import java.util.Random;

public class ThreadDemoExceptional3 {
	public static void main(String[] args) throws InterruptedException {
		
		Random random = new Random ();
 
        Runnable interruptibleTask = () -> {
            System.out.print("\nInterruptible: ");
            try {
                for (int i = 1; i <= 100; i++) {
                    System.out.print(i + " ");
                    Thread.sleep(random.nextInt());
                    for (int j = 1; j <= 100; j++) {
                        System.out.print(j + " ");
                        if (j == 92) throw new IllegalStateException();
                    }            
                }
            }
            catch (InterruptedException ex) {
                System.out.println("Interrupted!");
            }
        };
        Thread thread = new Thread(interruptibleTask);
        thread.start();
        thread.setUncaughtExceptionHandler((t, ex) -> System.out.println("Yikes!"));
     //   Thread.sleep(10000);
        thread.interrupt();
		}
	}
      
