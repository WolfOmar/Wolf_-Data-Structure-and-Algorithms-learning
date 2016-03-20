package sort;


/**
 * Created by aristark on 3/19/16.
 * 插入排序,很经典的排序方法
 * 对我的人生很重要
 */
public class InsertionSort {
    public static void sort(double[] args){
        int length = args.length;
        int out;

        /* 循环不变式(即已经排好序的部分)是args[0.......out-1]
        * key是下一个需要插入到循环不变式的值
        * 联想扑克牌吧,只能解释这么多了*/
        for (out=1;out<length;out++){
            double key = args[out];
            int in = out-1;
            while (in>=0 && key<args[in]){
                args[in+1] = args[in];
                in--;
            }
            args[in+1] = key;
        }
    }

    /* 随机生成一个数组来测试 */
    public static void main(String[] args){
        int randomLength = (int) (Math.random()*50);
        double[] randomArray = new double[randomLength];
        for (int i=0;i<randomLength;i++){
            randomArray[i] = Math.random()*100;
        }

        sort(randomArray);
        for (int i=0;i<randomLength;i++){
            System.out.println((int)randomArray[i]+"");
        }
    }
}
