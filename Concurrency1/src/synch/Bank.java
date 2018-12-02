package synch;

import java.util.*;
import java.util.concurrent.locks.*;

/**
 * A bank with a number of bank accounts that uses locks for serializing access.
 * @version 1.30 2004-08-01
 * @author Cay Horstmann
 */
public class Bank
{
   private final double[] accounts;
   private Lock bankLock;
   private Condition sufficientFunds;

   /**
    * Constructs the bank.
    * @param n the number of accounts
    * @param initialBalance the initial balance for each account
    */
   public Bank(int n, double initialBalance)
   {
      accounts = new double[n];
      Arrays.fill(accounts, initialBalance);
      bankLock = new ReentrantLock();
      sufficientFunds = bankLock.newCondition();
   }

   /**
    * Transfers money from one account to another.
    * @param from the account to transfer from
    * @param to the account to transfer to
    * @param amount the amount to transfer
    */
   public void transfer(int from, int to, double amount) throws InterruptedException
   {
      bankLock.lock();
      try
      {
         while (accounts[from] < amount)
            sufficientFunds.await();
         System.out.print(Thread.currentThread());
         accounts[from] -= amount;
         System.out.printf(" %10.2f from %d to %d", amount, from, to);
         accounts[to] += amount;
         System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
         sufficientFunds.signal();
      }
      finally
      {
         bankLock.unlock();
      }
   }

   /**
    * Gets the sum of all account balances.
    * @return the total balance
    */
   public double getTotalBalance()
   {
      bankLock.lock();
      try
      {
         double sum = 0;

         for (double a : accounts)
            sum += a;

         return sum;
      }
      finally
      {
         bankLock.unlock();
      }
   }

   /**
    * Gets the number of accounts in the bank.
    * @return the number of accounts
    */
   public int size()
   {
      return accounts.length;
   }
   
   public void percents(int accountNr, int percent) throws InterruptedException
   {
      bankLock.lock();
      try
      {

          double amountPercent = accounts[accountNr]*percent/100;
          
          System.out.print(Thread.currentThread());
          accounts[accountNr] += amountPercent;
          System.out.printf(" dodajemy %8.2f dodajemy na konto %d", amountPercent, accountNr);
          //accounts[to] += amount;
          System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
         sufficientFunds.signalAll();
      }
      finally
      {
         bankLock.unlock();
      }
   }
   
   public void percents2(int accountNr, int percent) throws InterruptedException
   {
      bankLock.lock();
      try
      {
    	  if (accounts[accountNr] < 10 ) 
    	  {
              sufficientFunds.await();
    	  }
    	  
    	  else
    	  {
          double amountPercent = accounts[accountNr]*percent/100;
          
          System.out.print(Thread.currentThread());
          accounts[accountNr] += amountPercent;
          System.out.printf("Limit przekroczony: dodajemy %8.2f dodajemy konto %d", amountPercent, accountNr);
          //accounts[to] += amount;
          System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
         sufficientFunds.signalAll();
    	  }
      }
      finally
      {
         bankLock.unlock();
      }
   }
   /*
   public void percents3(int accountNr, int percent) throws InterruptedException
   {
      bankLock.lock();
      try
      {
    	  while (accounts[accountNr] < 15)
              sufficientFunds.wait(300);
          double amountPercent = accounts[accountNr]*percent/100;
          
          System.out.print(Thread.currentThread());
          accounts[accountNr] += amountPercent;
          System.out.printf("Limidodajemy %8.2f dodajemt konto %d", amountPercent, accountNr);
          //accounts[to] += amount;
          System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
         sufficientFunds.signalAll();
      }
      finally
      {
         bankLock.unlock();
      }
   }
   */
}
