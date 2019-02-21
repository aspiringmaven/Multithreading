package me.sumitkawatra.java8.concept.async;

public class MaxZeroROwFounder {
	public static void main(String[] args) {
		
	}
	
	public static int rowWithMaxZero(int[][] twoDArray) {
		//assumption zeroth row has max zero's
		int max=0;
		int maxVal = 0;
		
		for(int row=0; row < twoDArray.length; row++ ) {
			//assume all zero in row;
			int zeroCount = twoDArray[row].length; 
			for(int col=0; col < twoDArray[row].length; col++ ) {
				if(twoDArray[row][col] == 0) {
					break;
				} else {
					zeroCount--;
				}
				
			} // row loop end
			
			if(maxVal < zeroCount) {
				maxVal = zeroCount;
				max = row;
			}
			
		} // col loop end
		
		return max;
		
	}
	
}
