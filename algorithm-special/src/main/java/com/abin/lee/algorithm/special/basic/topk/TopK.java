package com.abin.lee.algorithm.special.basic.topk;

import java.util.Arrays;

/**
 * Top k问题（线性时间选择算法）
 * https://www.cnblogs.com/guozhenqiang/p/5431353.html
 */

public class TopK {
    public static int LinearSelect(int s[], int n, int k) {
        int topk = 0;
        if (n <= 0) return topk;                          //如果数组为空，则返回0
        if (n < 5)                                      //这里对应算法的第一步。这里我定义的是小于5个，则直接排序，读者也可以自己设定
        {
            for (int i = 0; i < n - 1; i++)
                for (int j = i + 1; j < n; j++)
                    if (s[i] > s[j]) {
                        int t = s[i];
                        s[i] = s[j];
                        s[j] = t;
                    }
            topk = s[k - 1];
        } else {

            int ss[][] = new int[n / 5][5];                  //对应算法的第二步
            int j = -1;
            for (int i = 0; i < n / 5 * 5; i++) {
                if (i % 5 == 0) j++;
                ss[j][i % 5] = s[i];

            }

            int sss[] = new int[n / 5];
            for (int i = 0; i < n / 5; i++)                      //对应算法的第三步
            {
                Arrays.sort(ss[i]);
                sss[i] = ss[i][2];

            }
            Arrays.sort(sss);
            int M = sss[n / 5 / 2];                           //对应算法的第四步

            int A[] = new int[n];                         //对应算法的第五步
            int B[] = new int[n];
            int C[] = new int[n];
            int a = 0, b = 0, c = 0;                      //作为三个结合的指针
            for (int i = 0; i < n; i++)                  //放入对应的集合中
            {
                if (s[i] < M) A[a++] = s[i];
                if (s[i] == M) B[b++] = s[i];
                if (s[i] > M) C[c++] = s[i];
            }

            if (a > k - 1) topk = LinearSelect(A, a, k);             //对应算法第六步，我定义的数组是从下标0开始的忙，所以这里是k-1
            else if (a + b < k - 1) topk = LinearSelect(C, c, k - a - b);  //对应算法第七步
            else topk = M;                                   //对应算法第八步

        }
        return topk;                                  //返回最终的Top k
    }

    public static void main(String[] args) {

        int s[] = {16, 9, 92, 40, 25, 27};
        int n = 6;
        int k = 2;
        System.out.print("数组为：");
        for (int i = 0; i < n; i++) {
            System.out.print(s[i] + ",");
        }
        System.out.println();
        System.out.println("第" + k + "小的数为：" + LinearSelect(s, n, k));

    }

}