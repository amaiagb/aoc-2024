package day2_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day2_1 {

	public static void main(String[] args) {

		List<int[]> reports = new ArrayList<>();
		int safeReports = 0;
		
		String file = System.getProperty("user.dir")+"\\src\\day2_1\\input.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))){
			
			String line;
			
			while((line = br.readLine()) != null) {
				
				String[] lineArray = line.split("\\s+");
				int[] report = new int[lineArray.length];
				
				for(int i=0; i<lineArray.length; i++) {
					report[i] = Integer.parseInt(lineArray[i]);
				}
				reports.add(report);	
			}
			
			for(int[] report: reports) {
				if(report[0] < report[1]) {
					if(checkIncreasing(report)) {
						safeReports++;
					}
				} else if(report[0] > report[1]) {
					if(checkDecreasing(report)) {
						safeReports++;
					}
				}
			}
			System.out.println(safeReports);
			
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

	private static boolean checkIncreasing(int[] report) {
		for(int i=1; i<report.length; i++) {
			int diff = report[i]-report[i-1];
			if(diff <1 || diff > 3) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean checkDecreasing(int[] report) {
		for(int i=1; i<report.length; i++) {
			int diff = report[i-1]-report[i];
			if(diff <1 || diff > 3) {
				return false;
			}
		}
		return true;
		
	}


}
