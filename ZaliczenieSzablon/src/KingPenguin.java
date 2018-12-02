public class KingPenguin extends Penguin
{
   private double evenMoreFish;

   public KingPenguin(String n, double f, int year, int month, int day)
   {
      super(n, f, year, month, day);
      evenMoreFish = 0;
   }

   public double getFishRation()
   {
      double baseFishRation = super.getFishRation();
      return baseFishRation + evenMoreFish;
   }

   public void giveEvenMoreFish(double b)
   {
      evenMoreFish = b;
   }
}
