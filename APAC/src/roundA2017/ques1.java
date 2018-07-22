package roundA2017;

import java.util.ArrayList;
import java.util.Scanner;

public class ques1 {
	
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int t = s.nextInt();
		ArrayList<String> leaders = new ArrayList<>();
		
		for(int i = 0; i < t; i++){
			int n = s.nextInt();
			leaders.add(findleader(getInput(n)));
		}
		
		for(int i = 0; i < t; i++){
			System.out.println("Case #" + (i + 1) + ": " + leaders.get(i));
		}
		
	}
	
	public static ArrayList<String> getInput(int n){
		ArrayList<String> names = new ArrayList<>();
		s.nextLine();
		for(int j = 0; j < n; j++){
			names.add(s.nextLine());
		}
		return names;
	}


	private static String findleader(ArrayList<String> names) {
		int tempLeaderIndex = 0;
		int tempSize = 0;
		for(int i = 0; i < names.size(); i++){
			if(findUniqueChars(names.get(i)) > tempSize){
				tempLeaderIndex = i;
				tempSize = findUniqueChars(names.get(i));
			}//TODO
			else if (findUniqueChars(names.get(i)) == tempSize){
				String temp = dictOrder(names.get(tempLeaderIndex), names.get(i));
				if(temp.equals(names.get(i))){
					tempLeaderIndex = i;
					tempSize = findUniqueChars(names.get(i));
				}
			}
		}
		return names.get(tempLeaderIndex);
	}

	private static int findUniqueChars(String string) {
		
		boolean[] charArr = new boolean[26];
		for(int i = 0; i < 26; i++){
			charArr[i] = false;
		}
		
		int count = 0;
		
		for(int i = 0; i < string.length(); i++){
			int temp = (int) string.charAt(i);
			temp -= 65;
			if(temp < 26 && temp >= 0){
				if(!charArr[temp]){
					charArr[temp] = true;
					count++;
				}
			}
		}
		return count;
	}
	
	public static String dictOrder(String a, String b){
		int size;
		if(a.length() < b.length()){
			size = a.length();
		} else {
			size = b.length();
		}
		for(int i = 0; i < size; i++){
			if(a.charAt(i) < b.charAt(i)){
				return a;
			}
			if(a.charAt(i) > b.charAt(i)){
				return b;
			}
		}
		return a;
	}

}
