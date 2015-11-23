import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class GeneradorNumeros {
	
	public static void main(String[] args) {
		GeneradorNumeros g = new GeneradorNumeros();
		int[] a = g.makeSequence(1,50000);
		a = g.shuffle(a);
		try {

			String nums = Arrays.toString(a);
			nums = nums.substring(1, nums.length()-1);
			File file = new File("nums.in");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(nums);
			bw.close();

			System.out.println("Generado!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int[] shuffle(int[] a)
	{
	    int n = a.length;
	    for (int i = 0; i < n; i++)
	    {
	        int r = i + (int) (Math.random() * (n-i));
	        int tmp = a[i];    
	        a[i] = a[r];
	        a[r] = tmp;
	    }
	    return a;
	}
	 
	public int[] makeSequence(int begin, int end)
	{
	    if(end < begin)
	        return null;

	    int[] ret = new int[++end - begin];
	    for (int i=0; begin < end; )
	        ret[i++] = begin++;
	    return ret;
	}
	
}
