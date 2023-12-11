package tui;

import java.util.Random;

public class TryMe {

	
	private String randomPhoneNo() {
		String number = "";
		int length = 8;
		Random random = new Random();
		
		while(length-- > 0) {
			int nextNumber = random.nextInt(0, 9);
			
			number += nextNumber;
		}
		return number;
	}
}
