package com.nowcoder.jianzhioffer;
/**
 * 剑指offer题目：数组中的逆对数。
 * 归并排序的思想，在合并数组时，从后往前判断第一个数组的每一个元素大小是否大于第二个数组的
 * @author Stone
 *
 */
public class InversePairs {
    public static int inversePairs(int [] array) {
        if (array==null || array.length == 0 || array.length == 1) return 0;
        
        int[] firstHalf = new int[array.length / 2];
        System.arraycopy(array, 0, firstHalf, 0, array.length / 2);
        int firstCount = inversePairs(firstHalf);
        
        int secondHalfLength = array.length - array.length / 2;
        int[] secondHalf = new int[secondHalfLength];
        System.arraycopy(array, array.length / 2, secondHalf, 0, secondHalfLength);
         int secondCount = inversePairs(secondHalf);
        
        int[] temp = merge(firstHalf, secondHalf);
        System.arraycopy(temp, 0, array, 0, temp.length - 1);
        
        return (firstCount + secondCount + temp[temp.length - 1]) % 1000000007;
    }
    
    private static int[] merge(int[] list1, int[] list2) {
        int[] temp = new int[list1.length + list2.length + 1];
        int index1 = list1.length - 1;
        int index2 = list2.length - 1;
        int index3 = temp.length - 2;
        while (index1 >= 0 && index2 >= 0) {
            if (list1[index1] > list2[index2]) {
            	temp[temp.length - 1] += (index2 + 1);
                temp[index3--] = list1[index1--];
                if (temp[temp.length - 1] > 1000000007) {
                    temp[temp.length - 1] %= 1000000007;
                }
            }
            else {
                temp[index3--] = list2[index2--];
            }
        }
        
        while (index1 >= 0) {
            temp[index3--] = list1[index1--];
        }
                
        while (index2 >= 0) {
            temp[index3--] = list2[index2--];
        }
        
        return temp;
    }
    
    public static int inversePairsByInsersionSort(int[] list) {
    	int count = 0;
		for (int i = 1; i < list.length; i++) {
			int temp = list[i];
			int j = i;
			for (; j > 0 && temp < list[j - 1]; j--) {
				list[j] = list[j - 1];
				count++;
			}
			
			list[j] = temp;
		}
    	return count;
    	
    }
    public static void main(String[] args) {
    	int[] array = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
    	//int[] array = {34, 8, 64, 51, 32, 21};
    	System.out.println(inversePairsByInsersionSort(array));
    }
}
