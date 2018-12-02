package interClassTraining;
class AB implements BA
{
    public int methodB(int i)
    {
        return i =+ i * i;
    }
}

interface BA
{
    int methodB(int i);
}

public class MainClass3
{
    public static void main(String[] args)
    {
        AB b = new AB();

        System.out.println(b.methodB(2));
    }
}
