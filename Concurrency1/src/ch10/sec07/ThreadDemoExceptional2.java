package ch10.sec07;

public class ThreadDemoExceptional2 {
	public static void main(String[] args) throws InterruptedException {
		
		Runnable exceptionalTask1 = () -> {
            System.out.print("\nExceptional: ");
            for (int i = 1; i <= 100; i++) {
                System.out.print(i + " ");
                if (i == 92) throw new IllegalStateException();
            }            
        };
        Thread thread1 = new Thread(exceptionalTask1);
        thread1.setUncaughtExceptionHandler((t, ex) -> System.out.println("Yikes!"));
        thread1.start();
        thread1.join();
		
        Runnable interruptibleTask2 = () -> {
            System.out.print("\nInterruptible: ");
            try {
                for (int i = 1; i <= 100; i++) {
                    System.out.print(i + " ");
                    Thread.sleep(100);
                }
            }
            catch (InterruptedException ex) {
                System.out.println("Interrupted!");
            }
        };
        
       Thread thread2 = new Thread(interruptibleTask2);
        thread2.start();
        Thread.sleep(1000);
        thread2.interrupt();  
	}

}
