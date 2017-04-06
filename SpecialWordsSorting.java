package com;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class SpecialWordsSorting {
	public static void main(String args[]) throws Exception{
		Scanner in = new Scanner(new File("input1.txt" ) );
		int n = Integer.parseInt(in.nextLine());
		String strArr [] = new String[n];
		HashMap<String, String> mapFirst = new HashMap<String, String>();
		HashMap<String, String> mapLast = new HashMap<String, String>();
		for(int i=0;i<n;i++){
			strArr[i] = in.nextLine();
			strArr[i] = strArr[i].toLowerCase();
			char first = strArr[i].charAt(0);
			char last = strArr[i].charAt(strArr[i].length()-1);
			mapFirst.put(first+"", strArr[i]);
			mapLast.put(last+"",strArr[i]);
		}
		String output = "";
		String start = "";
		for(int i=0;i<strArr.length ; i++){
			char first = strArr[i].charAt(0);
			
			if(mapLast.get(first+"")==null){
				output += strArr[i]+" ";
				start = strArr[i];
				break;
			}
		}		
		while(true){
			char end = start.charAt(start.length()-1);
			if(mapFirst.get(end+"")==null){
				break;
			}
			else{
				output += mapFirst.get(end+"")+" ";
			}
			start = mapFirst.get(end+"");
		}
		
		System.out.println(output);
	}
}
