package Lab01;

import java.util.TreeMap;

public class LiczbaRzymska {
	
	private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

    static {

        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

    }

	private int number;
	private String romanNumber;
	
	public LiczbaRzymska(int x){
		this.number = Math.abs(x);
		this.romanNumber = transform();
		
	}
	
	public LiczbaRzymska(double x){
		this.number = Math.abs((int) x);
		this.romanNumber = transform();
	}
	
	public LiczbaRzymska(String x) {
		this.number = Math.abs(Integer.parseInt(x));
		this.romanNumber = transform();
	}

	@Override
	public String toString() {
		return romanNumber;
	};
	
	private String transform() {
		int l =  map.floorKey(number);
        if ( number == l ) {
            return map.get(number);
        }
        number = number-l;
        return map.get(l) + transform();
	}
	
	
	
}
