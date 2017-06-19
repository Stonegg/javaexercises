package com.nowcoder.jianzhioffer;

import java.util.LinkedHashMap;

/**
 * 剑指offer题目：
 * 第一个只出现一次的字符。
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 * @author Stone
 *
 */
public class FirstNotRepeatingChar {
	/**
	 * 将每一个字母出现的次数存储在一个一维数组中，然后从头遍历每一个字母。
	 * 那么问题是，如何知道字母出现次数存储在一维数组的哪个位置。
	 * 方法是，将字母的ASCII码值作为下标存储。
	 * @param str
	 * @return
	 */
	public int firstNotRepeatingChar(String str) {
		if (str == null || str.length() == 0) {
			return -1;
		}
		char[] characters = str.toCharArray();
/*		int[] times = new int['z'+1];
		for (char c : characters) {
			times[(int) c]++;
		}
		
		for (int i = 0; i < characters.length; i++) {
			if (times[(int)characters[i]] == 1)
				return i;
		}
*/
		int[] times = new int[52];
		for(char c : characters) {
			if (c < 'a') {
				times[(int)c - 65]++;
			}
			else {
				times[(int)c - 71]++;
			}
		}
		
		for (int i = 0; i < characters.length; i++) {
			if (characters[i] < 'a') {
				if (times[(int)characters[i] - 65] == 1) 
					return i;
			}
			else {
				if (times[(int)characters[i] - 71] == 1)
					return i;
			}
		}
		return -1;
	}
	// 使用LinkedHashMap速度不一定快
	public int firstNotRepeatingChar2(String str) {
		if (str == null || str.length() == 0) {
			return -1;
		}
		
		LinkedHashMap<Character, Integer> map =  new LinkedHashMap<>();
		for (int i = 0; i < str.length(); i++) {
			if (map.containsKey(str.charAt(i))) {
				int times = map.get(str.charAt(i)) + 1;
				map.put(str.charAt(i), times);
			}
			else {
				map.put(str.charAt(i), 1);
			}
		}
		for (int i = 0; i < str.length(); i++) {
			if (map.get(str.charAt(i)) == 1) 
				return i;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		FirstNotRepeatingChar obj = new FirstNotRepeatingChar();
		System.out.println(obj.firstNotRepeatingChar2("zaoozgeal"));

	}

}
