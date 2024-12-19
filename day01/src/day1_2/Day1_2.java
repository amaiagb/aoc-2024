package day1_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day1_2 {

	public static void main(String[] args) {
		
		List<Long> leftList = new ArrayList<>();
		List<Long> rightList = new ArrayList<>();
		int similarityScore = 0;
		
		String file = System.getProperty("user.dir")+"\\src\\day1_2\\input.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))){
			
			String line;
			while((line = br.readLine()) != null) {

				String[] numbers = line.split("\\s+");
				
				leftList.add(Long.parseLong(numbers[0]));
				rightList.add(Long.parseLong(numbers[1]));
			}
			

			List<Long> similarity = new ArrayList<>();
			
			for(int i=0; i<leftList.size(); i++) {
				int count = 0;
				for (int j = 0; j < rightList.size(); j++) {
					
					String num1 = leftList.get(i).toString();
					String num2 = rightList.get(j).toString();
					
					if(num1.equals(num2)) {
						count++;
					}
				}
				similarity.add(leftList.get(i)*count);
				similarityScore += leftList.get(i)*count;
			}
			System.out.println(similarityScore);
			
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
