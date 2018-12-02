import java.awt.print.Printable;

class PrintableExt extends Printable {
  public PrintableExt(String type) {
    super(type);
  }
  @Override
  public void print(String msg) {
    System.out.println(msg);
  }
}

public class PrintableTest {
  public static void main(String[] args) {
    Printable p = new PrintableExt("DZM");
    p.print("ZDA");
  }
}