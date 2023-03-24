package mainPart.Extras;

public class StringPixelLegnths {
	
	public double getEmptySpace() {
		return check(70, 20);
	}
	
	public double getDigitSpace() {
		return check(70, 10);
	}
	
	public double getLetterSpace() {
		return check(75, 10);
	}
	
	
	private double check(int size, int amount) {
		double result = 69;
		if(Math.round(size / amount) >= size / amount) {
			result = size / amount;
		}else {
			result = size / amount;
			result++;
		}
		return result;
	}
	
	
	
	
	
	
}
