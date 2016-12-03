package com.jbehave.pierwszecwiczenia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PsikusImplementacja implements Psikus {

	
	// metoda wycinająca z liczby losową cyfrę
	public Integer cyfrokrad(Integer liczba) {
		double sign = Math.signum(liczba);
		liczba = Math.abs(liczba);
		StringBuilder newString = new StringBuilder(liczba.toString());		
		int length = newString.length();
		if(length > 1) {
			Random rand = new Random();
			int n = rand.nextInt(length);
			newString.deleteCharAt(n);
			if(sign==-1.0f) newString = new StringBuilder("-"+newString.toString());
			return Integer.valueOf(newString.toString());
		}
		return null;
	}

	
	// metoda zamieniające dwie losowe cyfry w liczbie
	public Integer hultajchochla(Integer liczba) throws NieudanyPsikusException {
		double sign = Math.signum(liczba);
		liczba = Math.abs(liczba);
		String l = liczba.toString();
				
		if(l.length() <= 1) throw new NieudanyPsikusException();
		else {
			
			// generating list of possible indexes in string for randomizing
			ArrayList<Integer> listOfIndexes = new ArrayList<Integer>();
			for(int i =0; i < l.length(); i++) {
				listOfIndexes.add(i);
			}
			// randomizing indexes and picking two distinct ones
			Collections.shuffle(listOfIndexes);
			int char_x = listOfIndexes.get(0);
			int char_y = listOfIndexes.get(1);
			
			
			// converting String into char array and swapping chars
			char[] arr = l.toCharArray();
			char temp = arr[char_x];
			arr[char_x] = arr[char_y];
			arr[char_y] = temp;
			
			String result = new String(arr);
			if(sign==-1.0F) result="-"+result;
			
			return Integer.valueOf(result);
		}
	}

	
	public Integer nieksztaltek(Integer liczba) {
		
		// replacement chars
		final char three_replacement = '8';
		final char seven_replacement = '1';
		final char six_replacement = '9';
		
		// Integer to chars array
		char[] liczba_toArray = liczba.toString().toCharArray();
		
		// identifying indexes of chars eligible for change
		ArrayList<Integer> charsToChange = new ArrayList<Integer>();
		for(int i = 0; i < liczba_toArray.length; i++) {
			if(liczba_toArray[i] == '3' ||
			   liczba_toArray[i] == '7' || 
			   liczba_toArray[i] == '6') {
				charsToChange.add(i);
			}
		}
		
		if(!charsToChange.isEmpty()) {
			// getting a random index to change
			Collections.shuffle(charsToChange);
			int random_char = charsToChange.get(0);
			
			StringBuilder result = new StringBuilder(liczba.toString());
			switch(liczba_toArray[random_char]) {
			case '3':
				result.setCharAt(random_char, three_replacement);
				break;
			case '7':
				result.setCharAt(random_char, seven_replacement);
				break;
			case '6':
				result.setCharAt(random_char, six_replacement);
				break;
			}
			
			return Integer.valueOf(result.toString());
		}
		else return liczba;
	}

}
