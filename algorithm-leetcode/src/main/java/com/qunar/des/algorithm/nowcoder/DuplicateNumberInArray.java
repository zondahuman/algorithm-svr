package com.qunar.des.algorithm.nowcoder;

/**
 * Created by abin on 2018/7/30.
 * 数组中重复的数字
 * 题目描述
 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。

 */
public class DuplicateNumberInArray {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < length; i++){
            sb.append(numbers[i] + "");
        }
        for(int j = 0; j < length; j++){
            if(sb.indexOf(numbers[j]+"") != sb.lastIndexOf(numbers[j]+"")){
                duplication[0] = numbers[j];
                return true;
            }
        }
        return false;
    }

    public boolean duplicate2(int numbers[],int length,int [] duplication) {
        int temp;
        if(length<=1)
            return false;
        for(int i=0;i<length;i++) {
            while(numbers[i]!=i) {
                if(numbers[numbers[i]]!=numbers[i]) {
                    temp=numbers[numbers[i]];

                    numbers[numbers[i]]=numbers[i];
                    numbers[i]=temp;
                }
                else {
                    duplication[0]=numbers[i];
                    return true;
                }

            }


        }
        return false;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2,3,1,0,2,5,3};
        int[] output = new int[1];
        boolean flag = new DuplicateNumberInArray().duplicate(input, input.length,output);
        System.out.println("flag="+flag);
    }


}
