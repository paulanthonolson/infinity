package in_class;

public class Ch5_StarWhileReview {

	public static void main(String[] args) {
		
		int lineNum;
		int starCount;
		
		lineNum = 1;
		starCount = 1;
		
		
		while (lineNum <= 5) {
			System.out.println(lineNum);
			starCount = 1;
			while (starCount <= 5) {
			
			starCount = starCount + 1;
			System.out.print("*");
							}
			lineNum = lineNum + 1;
						}
		
		

	}

}
