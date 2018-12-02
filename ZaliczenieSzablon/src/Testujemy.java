public class Testujemy
{
   public static void main(String[] args)
   {
	// construct a Manager object
	  KingPenguin boss = new KingPenguin("Skipper", 8, 1987, 12, 15);
	  boss.giveEvenMoreFish(6);

	  Penguin[] staff = new Penguin[4];

	  // fill the staff array with Manager and Employee objects

	  staff[0] = boss;
	  staff[1] = new Penguin ("Kowalski", 5, 1989, 10, 1);
	  staff[2] = new Penguin ("Private", 4, 1990, 3, 15);
	  staff[3] = new Penguin ("Ricko", 3, 1991, 5, 12);

	  // print out information about all Employee objects
	  for (Penguin e : staff)
	     System.out.println("name=" + e.getName() + ",Fish Ration=" + e.getFishRation() + "Birthday=" + e.getBirthday());
	  
	  System.out.println(" ");
	  
      try
      {
         PenguinClone original = new PenguinClone ("Marlene", 50000);
         original.setBirthday(2000, 1, 1);
         PenguinClone copy = original.clone();
         copy.giveMoreFish(10);
         copy.setBirthday(2002, 12, 31);
         System.out.println("original=" + original);
         System.out.println("copy=" + copy);
      }
      catch (CloneNotSupportedException e)
      {
         e.printStackTrace();
      }
   }
}