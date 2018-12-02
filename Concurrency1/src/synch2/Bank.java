package synch2;

import java.util.*;

/**
 * A bank with a number of bank accounts that uses synchronization primitives.
 * @version 1.30 2004-08-01
 * @author Cay Horstmann
 */
public class Bank
{
   private final double[] accounts;

   /**
    * Constructs the bank.
    * @param n the number of accounts
    * @param initialBalance the initial balance for each account
    */
   public Bank(int n, double initialBalance)
   {
      accounts = new double[n];
      Arrays.fill(accounts, initialBalance);
   }

   /**
    * Transfers money from one account to another.
    * @param from the account to transfer from
    * @param to the account to transfer to
    * @param amount the amount to transfer
    */
   public synchronized void transfer(int from, int to, double amount) throws InterruptedException
   {
      while (accounts[from] < amount)
         wait();
      System.out.print(Thread.currentThread());
      accounts[from] -= amount;
      System.out.printf(" %10.2f from %d to %d", amount, from, to);
      accounts[to] += amount;
      System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
      notify();
   }

   /**
    * Gets the sum of all account balances.
    * @return the total balance
    */
   public synchronized double getTotalBalance()
   {
      double sum = 0;

      for (double a : accounts)
         sum += a;

      return sum;
   }

   /**
    * Gets the number of accounts in the bank.
    * @return the number of accounts
    */
   public int size()
   {
      return accounts.length;
   }
   
   public synchronized void percents(int accountNr, int percent) throws InterruptedException
   {
      double amountPercent = accounts[accountNr]*percent/100;
      
      System.out.print(Thread.currentThread());
      accounts[accountNr] += amountPercent;
      System.out.printf(" dodajemy %8.2f to %d", amountPercent, accountNr);
      System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
      notifyAll();
   }
   
   public synchronized void percents2(int accountNr, int percent) throws InterruptedException
   {
	   while (accounts[accountNr] < 1000)
	          wait();
      double amountPercent = accounts[accountNr]*percent/100;
      
      System.out.print(Thread.currentThread());
      accounts[accountNr] += amountPercent;
      System.out.printf("Limit przekroczony: dodajemy %8.2f na konto %d", amountPercent, accountNr);
      System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
      notifyAll();
   }
   
   public synchronized void percents3(int accountNr, int percent) throws InterruptedException
   {
	   while (accounts[accountNr] < 1000)
          wait(600);
	   
      double amountPercent = accounts[accountNr]*percent/100;
      
      System.out.print(Thread.currentThread());
      accounts[accountNr] += amountPercent;
      System.out.printf("Limit przekroczony: dodajemy %8.2f na konto %d", amountPercent, accountNr);
      System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
      notifyAll();
   }
}
