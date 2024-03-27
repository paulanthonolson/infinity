package in_class;
import java.util.Scanner;
public class Ch8_BooksDriver {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		int[] xList = new int[3];
		
		for (int xListIdx = 0; xListIdx < xList.length; xListIdx++)
		{
			xList[xListIdx] = 5;
		}
		
		Ch8_Books[] BookList = new Ch8_Books[3];
		
		for (int bookIdx = 0; bookIdx < BookList.length; bookIdx++)
		{
			BookList[bookIdx] = new Ch8_Books();
			System.out.println("Book number: " + (bookIdx + 1));
			System.out.println("Enter author: ");
			BookList[bookIdx].set_author(null);
			BookList[bookIdx].set_author(scnr.nextLine());
			
			System.out.println("Enter Title: ");
			BookList[bookIdx].set_title(null);
			BookList[bookIdx].set_title(scnr.nextLine());
			
			System.out.println("Enter ISBN: ");
			BookList[bookIdx].set_ISBN(bookIdx);
			BookList[bookIdx].set_ISBN(scnr.nextDouble());
			
			System.out.println("Enter Rating: ");
			BookList[bookIdx].set_rating(bookIdx);
			BookList[bookIdx].set_rating(scnr.nextInt());
			
			
		}
	
		Ch8_Books books1 = new Ch8_Books();
		
		System.out.println("Library Data");
		System.out.println("**************************************");
		System.out.println(books1.get_author());
		System.out.println(books1.get_title());
		System.out.println(books1.get_ISBN());
		System.out.println(books1.get_Rating());
		System.out.println(books1.drawStars());
		System.out.println();
		
		Ch8_Books books2 = new Ch8_Books();
		
	if (books1.equals(books2))
		System.out.println("both objects are equal");
	
	
	else 
		System.out.println("both objects are different");
	
	
	 
	}
}
