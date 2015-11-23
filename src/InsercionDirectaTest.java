import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class InsercionDirectaTest {
	public static void main(String[] args) {

		BufferedReader br = null;
		InsercionDirectaTest i = new InsercionDirectaTest();
		
		try {

			String sCurrentLine;
			br = new BufferedReader(new FileReader("nums.in"));
			sCurrentLine = br.readLine();
			//System.out.println(sCurrentLine);
			int[] nums = stringToInt(sCurrentLine);
			long startTime = System.nanoTime();
			int[] sortArray = insertSort(nums);
			long endTime = System.nanoTime();
			
			long duration = (endTime - startTime) / 1000000;
			
			System.out.println(duration);
			
			//System.out.println(Arrays.toString(sortArray));
			
			
			try {

				String strNums = Arrays.toString(sortArray);
				strNums = strNums.substring(1, strNums.length()-1);
				File file = new File("nums.out");

				// if file doesnt exists, then create it
				if (!file.exists()) {
					file.createNewFile();
				}

				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(strNums);
				bw.close();

				

			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}
	
	public static int[] stringToInt(String str){
		String[] numberStrs = str.split(", ");
		int[] numbers = new int[numberStrs.length];
		for(int i = 0;i < numberStrs.length;i++){			
		   numbers[i] = Integer.parseInt(numberStrs[i]);
		}
		return numbers;
	}
	
	public static int[] insertSort(int[] A){
		  for(int i = 1; i < A.length; i++){
		    int value = A[i];
		    int j = i - 1;
		    while(j >= 0 && A[j] > value){
		      A[j + 1] = A[j];
		      j = j - 1;
		    }
		    A[j + 1] = value;
		  }
		  return A;
	}
}
