package com.nowcoder.jianzhioffer;
/**
 * 剑指offer题目：数组中只出现一次的数字。
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * num1,num2分别为长度为1的数组。传出参数将num1[0],num2[0]设置为返回结果
 * @author Stone
 *
 */
public class FindNumsAppearOnce {
	public void findNumsAppearOnce(int[] array, int num1[], int num2[]) {
		if (array.length < 2) {
			return;
		}
		int temp = array[0];
		int size = array.length;
		for (int i = 1; i < size; i++) {
			temp ^= array[i];
		}
		if (temp == 0) return;
		
		int index = 0;
		while ((temp & 1) == 0) {
			temp = temp >> 1;
			index++;
		}
		num1[0] = 0;
		num2[0] = 0;
		for (int i = 0; i < size; i++) {
			if (isBit(array[i], index)) {
				num1[0] ^= array[i];
			}
			else {				
				num2[0] ^= array[i];
			}
		}
	}

	private boolean isBit(int num, int index) {
		num = num >> index;
		return (num & 1) == 1;
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 3, 2, 1, 5};
		int num1[] = {0};
		int num2[] = {0};
		FindNumsAppearOnce obj = new FindNumsAppearOnce();
		obj.findNumsAppearOnce(array, num1, num2);
		System.out.println(num1[0] + ", " + num2[0]);
	}
}
