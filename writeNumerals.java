import static java.lang.System.*;
import java.util.Scanner;
import humanize.Numerava;

public class writeNumerals {
	private static Scanner scan = new Scanner(in);
	private static Numerava number;
	public static void main (String[] args) {
		out.print("Enter Number : ");
		number = new Numerava(scan.nextInt());
		/*
		 * The Direct assignment of functions to members of constructor
		 * calls the respective functions and assigns their returned
		 * values to the initialized constructor. 
		 * 
		 * Hence, it provides a higher level of abstraction since the 
		 * **knowledge** about the functional implementation is hidden
		 * along with its private members. 
		 */
		out.println("number.Integer() 	→ " + number.Integer());
		out.println("number.Cardinal() 	→ " + number.Cardinal());
		out.println("number.ShortOrdinal()   → " + number.ShortOrdinal());
		out.println("number.Ordinal() 	→ " + number.Ordinal());
		out.println("number.Nominal() 	→ " + number.Nominal());
	}
}
