package com.codewars.yh;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SudokuValidator {
	public static boolean check(int[][] sudoku) {
        //do your magic
		for(int i=0; i<9; i++){
			Set<Integer> set = IntStream.range(1,9)
			         .boxed().collect(Collectors.toSet());
			Arrays.stream(sudoku[i]).forEach(num -> set.remove(num));
			if(!set.isEmpty()) return false;
		}
		
		for(int j = 0; j < 9; j++){
			Set<Integer> set = IntStream.range(1,9)
			         .boxed().collect(Collectors.toSet());
			for(int i=0; i<9; i++){
				set.remove(sudoku[j][i]);
			}
			if(!set.isEmpty()) return false;
		}
		return true;
    }
}
