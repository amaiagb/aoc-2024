package day1_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day1_1 {

	public static void main(String[] args) {

		List<Integer> leftList = new ArrayList<Integer>();
		List<Integer> rightList = new ArrayList<Integer>();
		int totalDistance = 0;
		
		String file = System.getProperty("user.dir")+"\\src\\day1_1\\input.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))){
			
			String line;
			while((line = br.readLine()) != null) {
				String[] numbers = line.split("\\s+");
				
				leftList.add(Integer.parseInt(numbers[0]));
				rightList.add(Integer.parseInt(numbers[1]));
			}
			
			Collections.sort(leftList);
			Collections.sort(rightList);
			
			List<Integer> distances = new ArrayList<Integer>();
			
			for(int i=0; i<leftList.size(); i++) {
				
				int distance = Math.abs(leftList.get(i)-rightList.get(i));
				distances.add(distance);
				totalDistance += distance;
				
			}
			System.out.println(totalDistance);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
