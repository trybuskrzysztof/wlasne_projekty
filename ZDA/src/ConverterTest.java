import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Upper implements Converter {
	@Override
	public String convert(String src) {
		return src.toUpperCase();
	}
}

class Lower implements Converter {
	@Override
	public String convert(String src) {
		return src.toLowerCase();
	}
}

public class ConverterTest {
	public static void main(String[] args) throws IOException{
		   String line = "";
		   InputStreamReader converter = new InputStreamReader(System.in);
		   BufferedReader in = new BufferedReader(converter);
		   Converter upper = new Upper();
		   Converter lower = new Lower();
		   
		   while (!(line.equals("quit"))){
		       line = in.readLine();
		       if(line.charAt(0) > 'a' && line.charAt(0) < 'z' )
		    	   line = lower.convert(line);
		       if(line.charAt(0) > 'A' && line.charAt(0) < 'Z' )
		    	   line = upper.convert(line);
		       System.out.println(line);
		   }
	}
}
