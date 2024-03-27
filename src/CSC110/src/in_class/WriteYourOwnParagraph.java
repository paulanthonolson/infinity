package in_class;

public class WriteYourOwnParagraph {
/*Write your own paragraph using
 * -println
 * -print
 * -printf
 * -escape sequence
 */
	public static void main(String[] args) {
	
		System.out.println ("\tI enjoy using a Unix based OS called Unraid to manage my home server.");
		System.out.print   ("Unraid utiilizes Docker so each application is contained within it's own container.\n");
		System.out.printf  ("Unraid also allows for countless plugins so it is infinitely customizable through\n");
		System.out.println ("community built applications and plugins. Each container is isolated from the rest");		
		System.out.println ("so a VPN can be ran on one masking your IP address, while the rest are utilizing your");
		System.out.println ("main IP. This is useful when downloading Linux distros and peer sharing them."); //Insert relevant comment here.
	}

}
