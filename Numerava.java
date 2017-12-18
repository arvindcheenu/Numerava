package humanize;
public class Numerava {
	/* CONSTANTS */
	public static final String[] units = { "", "One", "Two", "Three", "Four",
			"Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
			"Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
			"Eighteen", "Nineteen" };
	public static final String[] tens = { "", "", "Twenty", "Thirty","Forty",
			"Fifty", "Sixty", "Seventy",	 "Eighty", "Ninety" };
	
	/* MEMBERS */
	private int number;
	private String contract;
	private String ordinal;
	private String cardinal;
	private String nominal;
	private String format;
	public Numerava() {
		this.number = 0;
		this.contract = "0th";
		this.ordinal = "zeroth";
		this.cardinal = "zero";
		this.nominal = "zero";
		this.format = ""; //TODO add formats for formatting numbers

	}
	public Numerava(int number) {
		this.number = number;
		this.contract = this.toShortOrdinal();
		this.ordinal = this.toOrdinal();
		this.cardinal = this.toCardinal();
		this.nominal = this.toNominal();
		this.format = "";
	}
	public Numerava set(int number) {
		this.number = number;
		return this;
	}
	public int Integer() {
		return this.number;
	}
	public String Ordinal() {
		return this.ordinal;
	}
	public String ShortOrdinal() {
		return this.contract;
	}
	public String Cardinal() {
		return this.cardinal;
	}
	public String Nominal() {
		return this.nominal;
	}
	public String toNominal() {
		String prefix = "";
		char[] digits = Integer.toString(this.number).toCharArray();
		for (int i = 0; i < digits.length; i++) {
			switch (digits[i]) {
			case '0' : 
				prefix += "Zero";
				break;
			case '1' : 
				prefix += "One";
				break;
			case '2' : 
				prefix += "Two";
				break;
			case '3' : 
				prefix += "Three";
				break;
			case '4' : 
				prefix += "Four";
				break;
			case '5' : 
				prefix += "Five";
				break;
			case '6' : 
				prefix += "Six";
				break;
			case '7' : 
				prefix += "Seven";
				break;
			case '8' : 
				prefix += "Eight";
				break;
			case '9' : 
				prefix += "Nine";
				break;
			default: break;
			}
			if (i != digits.length-1)
				prefix += "-";
		}
		this.nominal = prefix;
		return this.nominal;
	}

	public String toShortOrdinal() {
		String suffix = "";
		switch (this.number % 10) {
		case 1: suffix = "st"; break;
		case 2: suffix = "nd"; break;
		case 3: suffix = "rd"; break;
		default: suffix = "th"; break;
		}
		this.contract = this.number + suffix;
		return this.contract;
	}
	
	public String toCardinal() {
		this.cardinal = convert(this.number);
		return this.cardinal;
	}
	
	public String toOrdinal() {
		String suffix = selectSuffix((this.number) % 10);
		this.cardinal = convert((this.number) - (this.number % 10));
		return this.cardinal + suffix;
	}
	private static String selectSuffix(int n) {
		String suffix = " ";
		switch (n) {
		case 1 : 
			suffix += "First";
			break;
		case 2 : 
			suffix += "Second";
			break;
		case 3 :
			suffix += "Third";
			break;
		case 4 :
			suffix += "Fourth";
			break;
		case 5 :
			suffix += "Fifth";
			break;
		case 8 :
			suffix += "Eighth";
		default : 
			suffix += convert(n) + "th";
		}
		return suffix;
	}
	private static String convert(int n) {
		if (n < 0) {
			return "Minus " + convert(-n);
		}
		if (n < 20) {
			return units[n];
		}
		if (n < 100) {
			return tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
		}
		if (n < 1000) {
			return units[n / 100] + " Hundred" + ((n % 100 != 0) ? " and " : "") + convert(n % 100);
		}
		if (n < 100000) {
			return convert(n / 1000) + " Thousand" + ((n % 10000 != 0) ? " " : "") + convert(n % 1000);
		}
		if (n < 10000000) {
			return convert(n / 100000) + " Lakh" + ((n % 100000 != 0) ? " " : "") + convert(n % 100000);
		}
		return convert(n / 10000000) + " Crore" + ((n % 10000000 != 0) ? " " : "") + convert(n % 10000000);
	}
	
}
