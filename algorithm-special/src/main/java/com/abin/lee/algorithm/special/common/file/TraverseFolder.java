package com.abin.lee.algorithm.special.common.file;

import java.io.File;

/**
 * Created by abin on 2018/8/12.
 * 遍历文件夹下的所有文件(递归调用和非递归调用)
 * https://www.cnblogs.com/azhqiang/p/4596793.html
 */
public class TraverseFolder {
    public static void main(String[] args) {
        String path = "F:\\Sys";
        new TraverseFolder().traverseFolder(path);
    }

    public void traverseFolder(String path) {
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            for (File temp : files) {
                if (temp.isDirectory()) {
                    System.out.println("folder is = " + temp.getAbsolutePath());
                    traverseFolder(temp.getAbsolutePath());
                } else {
                    System.out.println("file is = " + temp.getAbsolutePath());
                }
            }
        } else {
            System.out.println("file is not exists");
        }
    }
}
