package com.abin.lee.algorithm.tree.test.binary;

/**
 * Created with IntelliJ IDEA.
 * User: tinkpad
 * Date: 15-11-13
 * Time: 下午11:01
 * To change this template use File | Settings | File Templates.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,4,5,6,7};
        int result = search(input,1,0,input.length-1);
        System.out.println("result="+result);
        int result1 = search1(input,1);
//        int result1 = searchLoop(input,7);
//        int result1 = binarySearch(input,7);
        System.out.println("result1="+result1);

    }
    public static int search(int[] input,int data,int start,int end){
        int middle = (start+end)/2;
        if(data == input[middle])
            return middle;
        else if(data < input[middle])
            return search(input, data, start, middle-1);
        else if(data > input[middle])
            return search(input, data, middle+1, end);
        else
            return -1;
    }
    public static int search1(int[] input,int data){
        int low = 0;
        int high = input.length-1;
        while(low<=high){
            int middle = (low+high)/2;
            if(data == input[middle])
                return middle;
            else if(data<input[middle])
                high = middle-1;
            else
                low = middle+1;
        }
        return -1;
    }
    public static int binarySearch(int[] srcArray, int des){
        int low = 0;
        int high = srcArray.length-1;
        while(low <= high) {
            int middle = (low + high)/2;
            if(des == srcArray[middle]) {
                return middle;
            }else if(des <srcArray[middle]) {
                high = middle - 1;
            }else {
                low = middle + 1;
            }
        }
        return -1;
    }

    public static int searchLoop(int[] sortedData,int findValue)
    {
        int start=0;
        int end=sortedData.length-1;

        while(start<=end)
        {
            //中间位置
            int middle=(start+end)>>1;    //相当于(start+end)/2
            //中值
            int middleValue=sortedData[middle];

            if(findValue==middleValue)
            {
                //等于中值直接返回
                return middle;
            }
            else if(findValue<middleValue)
            {
                //小于中值时在中值前面找
                end=middle-1;
            }
            else
            {
                //大于中值在中值后面找
                start=middle+1;
            }
        }
        //找不到
        return -1;
    }


}
