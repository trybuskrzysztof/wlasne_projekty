import java.util.Date;
import java.util.GregorianCalendar;

public class PenguinClone implements Cloneable
{
   private String name;
   private double fishRation;
   private Date birthday;

   public PenguinClone (String n, double f)
   {
      name = n;
      fishRation = f;
      birthday = new Date();
   }

   public PenguinClone clone() throws CloneNotSupportedException
   {
      // call Object.clone()
      PenguinClone cloned = (PenguinClone) super.clone();

      // clone mutable fields
      cloned.birthday = (Date) birthday.clone();

      return cloned;
   }

   /**
    * Set the hire day to a given date. 
    * @param year the year of the hire day
    * @param month the month of the hire day
    * @param day the day of the hire day
    */
   public void setBirthday(int year, int month, int day)
   {
      Date newBirthday = new GregorianCalendar(year, month - 1, day).getTime();
      
      // Example of instance field mutation
      birthday.setTime(newBirthday.getTime());
   }

   public void giveMoreFish(double byPercent)
   {
      double raise = fishRation * byPercent / 100;
      fishRation += raise;
   }

   public String toString()
   {
      return "Penguin [name=" + name + ",Fish Ration=" + fishRation + ",Birthday=" + birthday + "]";
   }
}