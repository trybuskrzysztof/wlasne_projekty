package application;

public class Points {

	double pointX;
	double pointY;
	
    Main a;
    
	Main b;
	
	
	// pobiera a i b
	// liczy wartoœci funkcji dla y i zapisuje je w tablicy
	
	 public static double oblicz(double x){
		 
		
		 double y= 0.0;
		 double poprawkaX =250.0;
		 double poprawkaY =250.0;
		 
		 //y=ax^2 +b
		 
		 // x^2
		 //x=0 to we wzorze poprawka y=(ax^2 +b)+250
		 double xKwadrat = (x-poprawkaX)*(x-poprawkaX);
		 
		 y=((Main.a*(xKwadrat))+(Main.b*50*50));
		 y= y/50;
		 y = y*-1;
		 if (y<-250.0 ) y= -250.0;
		 else if(y>=250.0) y = 250;
		 y= y+poprawkaY;
		 
		 
		 System.out.println("y=:"+y);
		 return y;
		
	 }
	
	 
}