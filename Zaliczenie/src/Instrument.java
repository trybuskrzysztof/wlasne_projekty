public abstract class Instrument
{
   public abstract String getDescription();
   private String model;

   public Instrument(String n)
   {
      model = n;
   }

   public String getName()
   {
      return model;
   }
}