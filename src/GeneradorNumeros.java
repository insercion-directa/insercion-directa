import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class GeneradorNumeros {
	
	public static void main(String[] args) {
		GeneradorNumeros g = new GeneradorNumeros();
		int[] a = g.makeSequence(1,100000);
		//a = g.shuffle(a); //Funcion para desordenar el arreglo
		a = g.invert(a); // Funcion para invertir el arreglo
		try {

			String nums = Arrays.toString(a);
			nums = nums.substring(1, nums.length()-1);
			File file = new File("nums.in");

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
	
	public int[] invert(int[] a)
	{
	    int n = a.length - 1;
	    for (int i = 0; i < n; i++)
	    {
	        a[i] = a[n];
	        n--;
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
