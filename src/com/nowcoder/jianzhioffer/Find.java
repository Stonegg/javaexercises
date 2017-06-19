package com.nowcoder.jianzhioffer;

/**
 * 剑指offer题目1:
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Find {
	public boolean find (int target, int [][] array) {
		int i = 0;
		int j = array[0].length - 1;
		while (i <=array.length -1 && j >= 0) {
			if (array[i][j] == target)
				return true;
			if (array[i][j] > target) 
				j--;
			else 
				i++;
		}
		
		return false;
	}

	// 简单测试
	public static void main(String[] args) {
		int [][] array = {{1, 2, 5},{2, 3, 20}};
		int target = 3;
		Find fo = new Find();
		System.out.println(fo.find(target,array));
	}
}


