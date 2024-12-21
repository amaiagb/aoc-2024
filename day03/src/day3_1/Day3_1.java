package day3_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day3_1 {

	public static void main(String[] args) {

		List<String> memory = new ArrayList<>();
		List<String> foundMuls = new ArrayList<>();
		List<String[]> foundMulsArrays = new ArrayList<>();
		String[] array;
		String file = System.getProperty("user.dir") + "\\src\\day3_1\\input.txt";
		List<Integer> mulResults = new ArrayList<>();
		int num1;
		int num2;
		Long finalResult = (long) 0;
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			String line;

			while ((line = br.readLine()) != null) {
				memory.add(line);
			}
			
			for (String input : memory) {
				
				foundMuls.clear();				
				
				findMuls(foundMuls, input);
				
				for(String mul: foundMuls) {					
					array = mul.split(",");
					foundMulsArrays.add(array); // example: foundMulsArrays[0] = {"2","4)%mu)"} <- ARRAY
				}				
			}
			
			for(String[] mulArray: foundMulsArrays) {
				num1 = 0; 
				num2 = 0;
				
				if(mulArray[0].length()>0 && mulArray[0].length()<=3) {
					try {
						num1 = Integer.parseInt(mulArray[0]);
						if(mulArray[1].contains(")")) {
							
							int closureIndex = mulArray[1].indexOf(")");
							String num2txt = mulArray[1].substring(0,closureIndex);
							
							try {
								num2 = Integer.parseInt(num2txt);
								mulResults.add(num1*num2);
							} catch (NumberFormatException e) {
								e.printStackTrace();
							}
						}
					} catch (NumberFormatException e) {
						e.printStackTrace();
					}
				}				
			}
			
			
			for (Integer result : mulResults) {
				finalResult+= result;
			}
			System.out.println(finalResult);	
	
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param foundMuls	list where the found strings will be added
	 * @param input		string to search
	 */
	private static void findMuls(List<String> foundMuls, String input) {
		int i=0; 
		do{
			int foundIndex = input.indexOf("mul(", i);
			
			i= input.indexOf("mul(", i)+1;
			
			int mulLengthMax = foundIndex+12;
			if(mulLengthMax <= input.length()) {
				String newMul = input.substring(foundIndex+4,foundIndex+12);
				foundMuls.add(newMul);  // example: foundMuls[0] = "2,4)%mu)" <- STRING
				
			} else {
				String newMul = input.substring(foundIndex+4);
				foundMuls.add(newMul);
			}
		}while(input.indexOf("mul(", i) != -1);
	}

}
