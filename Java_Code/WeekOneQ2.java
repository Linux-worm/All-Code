import java.io.*;
import static java.lang.System.*;
import static java.lang.Math.*;
import java.math.*;

public class WeekOneQ2
{
    public static void main(String... args)
    {
	try
	{
	    File file = new File("input.txt");
	    FileReader fr = new FileReader(file);
	    BufferedReader br = new BufferedReader(fr);

	    String data = br.readLine();
	    br.close();

	    BigInteger A = new BigInteger(data.substring(0, data.indexOf(' ')));
	    BigInteger B =  new BigInteger(data.substring(data.indexOf(' ') + 1));
	    BigInteger c = A.add(B.pow(2));
	    
	       

	    File file1 = new File("output.txt");
	    FileWriter fw = new FileWriter(file1);
	    fw.write(String.valueOf(c));
	    fw.flush();
	    fw.close();				  
	}
	catch(IOException e)
	{
	    out.println("In catch block");
	}
    }			
}
