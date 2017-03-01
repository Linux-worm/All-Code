public class InsertIntoArray
{
    public static void main(String [] args)
    {
	int [] a = new int[6];
	for(int i = 0; i < 5; i++)
		a[i] = i + 1;	
	int pos = 2;
	int data = 6;
	int l = a.length;
	for(int i = 5; i >= 2; i--)
		a[i] = a[i - 1];
	a[pos - 1] = data;
	for(int i = 0; i < 6; i++)
		System.out.print(a[i]+" ");	
    }	
}
