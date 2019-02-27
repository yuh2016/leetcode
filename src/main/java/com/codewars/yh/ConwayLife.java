package com.codewars.yh;

public class ConwayLife {
	/**
	 * 2*2维
	 1，周围生命为3，此格存活
	 2，周围生命为2，此格保持状态
	 3，周围指此格四周的8格
	 4，宇宙无限，未显示在数组中的都是dead
	 */
	public static int[][] getGeneration(int[][] cells, int generations) {
		if(generations == 0) return cells;
		if(cells.length == 0) return cells;
		
		int yLength = 0;
		for(int i=0; i<cells.length; i++){
			if(cells[i].length > yLength){
				yLength = cells[i].length;
			}
		}
		
		int xLength = cells.length;
		
		// your code goes here
		int[][] result = cells;
		for (int i = 0; i < generations; i++) {
			result = nextGeneration(result, xLength, yLength);
		}
		return result;
	}
	
	public static int[][] nextGeneration(int[][] cells, int xLength, int yLength){
		int[][] result = new int[xLength][yLength];
		for (int i = 0; i < xLength; i++) {
			for (int j = 0; j < yLength; j++) {
				result[i][j] = getNextLive(cells, i, j, xLength, yLength);
			}
		}
		return result;
	}
	
	public static int getNextLive(int[][] cells, int i, int j, int xLength, int yLength){
		int minX = i-1, minY = j-1, maxX = i+1, maxY = j+1;
		if(minX < 0){
			minX = 0;
		}

		if(maxX > xLength - 1){
			maxX = xLength - 1;
		}
		
		if(minY < 0){
			minY = j;
		}
		if(maxY > yLength - 1){
			maxY = yLength - 1;
		}
		
		int live = 0;
		for (int m = minX; m < maxX + 1; m++) {
			for (int n = minY; n < maxY + 1; n++) {
				if(m == i && n == j){
					continue;
				}
				if(cells[m][n] == 1){
					live ++;
				}
			}
		}
		
		if(cells[i][j] == 1 && (live == 2 || live == 3)){
			return 1;
		}
		if(cells[i][j] == 0 && live == 3){
			return 1;
		}
		return 0;
	}
	
	public static void main(String[] args){
		int[][] a= {{1, 0, 0}, {1, 1, 0}, {0,0,0,0,0,0,0,1,1}};
		System.out.println(a.length);
		System.out.println(a[0].length);
	}
}
