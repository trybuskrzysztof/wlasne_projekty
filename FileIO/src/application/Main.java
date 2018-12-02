package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
      Scanner in=null;
      int id;
      String firstName;
      String lastName;
      
      ArrayList<Integer> idList=new ArrayList();
      ArrayList<String> firstNameList=new ArrayList();
      ArrayList<String> lastNameList=new ArrayList();
    
      try {
		in=new Scanner(Paths.get("/home/users/xgucio/workspace1c2/FileIO/src/infile.txt"));
		while (in.hasNext())
		{
			id=in.nextInt();
			firstName=in.next();
			lastName=in.next();
			
			idList.add(id);
			firstNameList.add(firstName);
			lastNameList.add(lastName);
			
			System.out.printf(
			  "Wczytano dane -> id: %d, imie: %s, nazwisko: %s\n", 
			  id, firstName, lastName);
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    finally
    {
    	if (in!=null)
    		in.close();
    }
    //---------------------
    //zapis do pliku
      
    PrintWriter out=null;
    
    try {
		out=new PrintWriter("/home/users/xgucio/workspace1c2/FileIO/src/outfile.txt");
		
		for (int i=0; i<idList.size(); i++)
		{
			out.printf(
			   "Wczytano dane -> id: %d, imie: %s, nazwisko: %s\n",
			   idList.get(i),
			   firstNameList.get(i),
			   lastNameList.get(i)
			   );
		}
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    finally {
    	if (out!=null) 
    		out.close();
    }

}

}