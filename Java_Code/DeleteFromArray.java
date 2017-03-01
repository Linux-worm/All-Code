public class DeleteFromArray
{
    public static void main(String [] args)
    {
	int [] a = new int[6];
	for(int i = 0; i < 6; i++)
		a[i] = i + 1;	
	int pos = 2;
	int data = 6;
	int l = a.length;
	for(int i = 1; i < 5; i++)
		a[i] = a[i + 1];
	for(int i = 0; i < 5; i++)
		System.out.print(a[i]+" ");	
    }	
}
