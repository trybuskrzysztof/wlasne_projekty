public class Outer {
  String outerText;                     // pole obiektu Outer
  public Outer(String o) {
    outerText=o;
    System.out.println(new Inner("Lolek").describe());  // = this.new
  }
  public class Inner {
    String name ;
    public Inner(String n) { name = n; }
    public String describe() {
      //return Outer.this.outerText+"-"+name; // pełny zapis
      return outerText+"-"+name;  // to tu obiekt wewnętrzny sięga na zwenątrz
    }
  }
}