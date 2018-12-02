import java.util.Date;
import java.util.GregorianCalendar;

public class Penguin
{
   private String name;
   private double fishRation;
   private Date birthday;

   public Penguin(String n, double f, int year, int month, int day)
   {
      name = n;
      fishRation = f;
      GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
      birthday = calendar.getTime();
   }

   public String getName()
   {
      return name;
   }

   public double getFishRation()
   {
      return fishRation;
   }

   public Date getBirthday()
   {
      return birthday;
   }

   public void giveMoreFish(double byPercent)
   {
      double raise = fishRation * byPercent / 100;
      fishRation += raise;
   }
}