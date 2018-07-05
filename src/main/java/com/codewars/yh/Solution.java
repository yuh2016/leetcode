package com.codewars.yh;

public class Solution {
	public static String SongDecoder (String song)
	  {
	     // Your code is here...
	     String initial = song.replaceAll("WUB", " ");
	     String str = initial.trim();
	     char[] result = new char[str.length()];
	     int index = -1;
	     for(int i=0; i<str.length(); i++){
	         char c = str.charAt(i);
	         if(c == ' ' && index >= 0 && result[index] == ' '){
	             continue;
	         }
	         index ++;
	         result[index] = c;
	     }
	     return new String(result).trim();
	   }
}
