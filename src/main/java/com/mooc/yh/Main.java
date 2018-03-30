package com.mooc.yh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		/*BufferedReader str=new BufferedReader(new InputStreamReader(System.in));  
        String len = str.readLine();
        int length = Integer.parseInt(len);
        String num = str.readLine();
        String[] nums = num.split(" ");
        int max = 0;
        int tmp = 0;
        for(int i = 0; i < length; i++){
        	tmp += Integer.parseInt(nums[i]);
        	if(tmp > max){
        		max = tmp;
        	}else if (tmp < 0){
        		tmp = 0;
        	}
        }
        if(max < 0){
        	System.out.println(0);
        }
        System.out.println(max);*/
		
		
		BufferedReader str=new BufferedReader(new InputStreamReader(System.in));  
        String len = str.readLine();
        int length = Integer.parseInt(len);
        String num = str.readLine();
        String[] nums = num.split(" ");
        Integer max = 0;
        int tmp = 0, start = 0, tmpstart = 0, end = 0;
        boolean negativeFlag = true;
        for(int i = 0; i < length; i++){
        	if(Integer.parseInt(nums[i]) >= 0){
        		negativeFlag = false;
        	}
        	tmp += Integer.parseInt(nums[i]);
        	if(tmp > max){
        		max = tmp;
        		start = tmpstart;
        		end = i;
        	}else if (tmp < 0){
        		tmp = 0;
        		tmpstart = i + 1;
        	}
        }
        if(negativeFlag){
        	System.out.println(0 + " " + nums[0] + " " + nums[length-1]);
        }else{
        	System.out.println(max + " " + nums[start] + " " + nums[end]);
        }
	}
}
