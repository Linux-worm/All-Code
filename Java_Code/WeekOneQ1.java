import java.io.*;
import static java.lang.System.*;

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
	    int A = Integer.parseInt(data.substring(0, data.indexOf(' ')));
	    int B = Integer.parseInt(data.substring(data.indexOf(' ') + 1));
	    int c = A + B;
	    br.close();
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
