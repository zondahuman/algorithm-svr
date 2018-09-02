package com.abin.lee.algorithm.special.common;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abin on 2017/12/8 18:39.
 * algorithm-svr
 * com.qunar.des.algorithm.special.common
 * 从范围n中产生k(k<n)个不重复随机数
 * 如何高效产生m个n范围内的不重复随机数(m<=n)
 * 给你n个不重复的整数,随机找出m个不重复的整数
 * 给你n个不重复的整数，随机找出m个不重复的整数，要求时间和空间复杂度都是O(m)。（方法很简单，就是每次把取出来的数放到后面，
 * 只在前面的数组随机访问就可以了，时间复杂度是O(m)，空间复杂度是O(1)，不过我刚开始没有想到把选出来的放后面去。。。）。
 * http://www.dewen.net.cn/q/4764
 */
public class RandomNm {
    /**
     * 算法的原理很简单：
     假想有一列N个元素排在你面前，你随便从中间抽走一个。然后就留下了一个空在这里。有空在这里下次抽到了怎么办？要把空填上，于是你把整列的最后一个元素拿起来填到了空位上。下次就是从N-1个元素里取一个。
     因为N可能很大，所以用一个HashTable替代数组。如果replaceTable[i]不存在，就认为值为i。剩下的代码就顺理成章了。
     * @param args
     */
    public static void main(String[] args) {
//        List<Integer> list = Lists.newCopyOnWriteArrayList();
//        for (int i = 0; i <10 ; i++) {
//            list.add(i);
//        }
//        System.out.println("list="+ JsonUtil.toJson(list));
//        List<Integer> result = getRand(list, 5);
//        System.out.println("result="+ JsonUtil.toJson(result));

        int[] input = new int[10];
        for (int i = 0; i <10 ; i++) {
            input[i] = i+10;
        }
        System.out.println("input="+ JsonUtil.toJson(input));
        int[] result1 = getRandByArray(input, 5);
        System.out.println("result1="+ JsonUtil.toJson(result1));
    }

    public static int[] getMFromN(int m){

        return null;
    }


    /**
     * 从list中随机取出count个不同的整数
     * http://blog.csdn.net/ssh_kobe/article/details/6850754
     * @param list
     * @param count
     * @return relist
     */
    public static List<Integer> getRand(List<Integer> list, int count){
        int [] num = new int[count];//记录下标，长度为count
        int size = list.size();//list的长度
        int [] rem = new int[size];//list的下标
        List<Integer> relist = new ArrayList<Integer>();//最终返回结果

        for(int i=0; i<rem.length; i++) {
            rem[i] = i;
            System.out.println("--------------------------------");
        }

        for(int i=0; i<num.length; i++) {//循环count次，取出count个不同随机数
            int r = (int)(Math.random()*size);
            num[i] = rem[i];
            relist.add(list.get(num[i]));
            rem[i] = rem[size-1];
            size --;//每取出一个随机数，size就减1，即下一次在size-1的范围内取随机数，达到不重复的效果
            System.out.println("+++++++++++++++++++++++++++++++++++");
        }
        return relist;
    }


    public static int[] getRandByArray(int[] input, int m){
        int [] num = new int[m];//记录下标，长度为m, 最终返回结果
        int size = input.length;//input的长度
        for(int i=0; i<num.length; i++) {//m，取出m个不同随机数
            int random = (int)(Math.random()*size);
            num[i] = input[random];
            int temp = input[random];
            input[random] = input[size-1];
            input[size-1] = temp;
            size --;//每取出一个随机数，size就减1，即下一次在size-1的范围内取随机数，达到不重复的效果
        }
        return num;
    }

}
