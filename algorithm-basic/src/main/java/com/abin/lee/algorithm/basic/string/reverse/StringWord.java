package com.abin.lee.algorithm.basic.string.reverse;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 15-5-24 上午1:30
 */
public class StringWord {
    public static List<String> findWordInString(String str){

        return null;
    }
}



//public class WrodSorting {
//    private static final String test="I love you not for who you are, but for who I am before you. i think!";
//    //65～90为26个大写英文字母，97～122号为26个小写英文字母
//    public static List sortWord(String word){
//        byte[] bytes=word.getBytes();
//        List list=new ArrayList<String>();
//        StringBuffer buffer=new StringBuffer();
//        for (int i = 0; i <bytes.length ; i++) {
//            if ((bytes[i]>=65&&bytes[i]<=90)||(bytes[i]>=97&&bytes[i]<=122)){
//                buffer.append(word.charAt(i));
//            }else {
//                list.add(buffer.toString());
//                buffer=new StringBuffer();
//            }
//        }
//        return list;
//    }
//    public static void main(String[] args) {
//        System.out.print(WrodSorting.sortWord(WrodSorting.test));
//    }
//}

