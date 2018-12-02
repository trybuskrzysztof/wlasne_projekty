public class OuterTest {
  public static void main(String[] args) {
      Outer n = new Outer("Koziołek");
      Outer.Inner i = n.new Inner("Matołek");
      System.out.println(i.describe());
  }
}