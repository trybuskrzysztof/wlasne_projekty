package interClassTraining;

interface X
{
    char c = 'A';

    char methodX();

//    System.out.println("interface A")
}

class Y implements X
{
    {
        System.out.println(c);
    }

    public char methodX()
    {
        char c = this.c;

        return ++c;
    }
}

public class MainClass4
{
    public static void main(String[] args)
    {
        Y y = new Y();

        //System.out.println(y.methodX());

        //System.out.println(y.c);

        //System.out.println(X.c);
    }
}
