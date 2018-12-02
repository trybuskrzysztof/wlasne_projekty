package synch;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * This program shows how multiple threads can safely access a data structure.
 * @version 1.31 2015-06-21
 * @author Cay Horstmann
 */
public class SynchBankTest1_2
{
   public static final int NACCOUNTS = 100;
   public static final double INITIAL_BALANCE = 1000;
   public static final double MAX_AMOUNT = 1000;
   public static final int DELAY = 10;
   public static final int PERCENT = 2;
   
   public static void main(String[] args)
   {
      Bank bank = new Bank(NACCOUNTS, INITIAL_BALANCE);
      for (int i = 0; i < NACCOUNTS; i++)
      {
         int fromAccount = i;
         Runnable r1 = () -> {
            try
            {
               while (true)
               {
                  int toAccount = (int) (bank.size() * Math.random());
                  double amount = MAX_AMOUNT * Math.random();
                  bank.transfer(fromAccount, toAccount, amount);
//                  bank.percents(fromAccount, PERCENT);
                  Thread.sleep((int) (DELAY * Math.random()));
               }
            }
            catch (InterruptedException e)
            {
            }            
         };
         
         Runnable r2 = () -> {
             try
             {
                while (true)
                {
//                  int toAccount = (int) (bank.size() * Math.random());
//                   double amount = MAX_AMOUNT * Math.random();
//                   bank.transfer(fromAccount, toAccount, amount);
                   bank.percents(fromAccount, PERCENT);
                   Thread.sleep((int) (DELAY * Math.random()));
                }
             }
             catch (InterruptedException e)
             {
             }            
          };
          
          Runnable r3 = () -> {
              try
              {
                 while (true)
                 {
//                   int toAccount = (int) (bank.size() * Math.random());
//                    double amount = MAX_AMOUNT * Math.random();
//                    bank.transfer(fromAccount, toAccount, amount);
                    bank.percents(fromAccount, PERCENT);
                    Thread.sleep((int) (DELAY * Math.random()));
                 }
              }
              catch (InterruptedException e)
              {
              }            
           };
//       Thread t = new Thread(r);
//       t.start();
         Executor executor = Executors.newCachedThreadPool();
         executor.execute(r1);        
         executor.execute(r2);
         executor.execute(r3);
      }
   }
}
