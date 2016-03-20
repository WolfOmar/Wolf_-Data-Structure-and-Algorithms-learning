package sort;

/**
 * Created by aristark on 3/20/16.
 * 冒泡排序
 * 说实话我经常忘记它是怎么玩的
 */
public class BubbleSort {
    public static void sort(double[] args){
        for (int out=0;out<args.length-1;out++){
            for (int in=args.length-1;in>out;in--){
                if (args[in]<args[in-1])
                    swap(args,in,in-1);
            }
        }
    }

    public static void swap(double[] args,int i,int j){
        double temp = args[i];
        args[i] = args[j];
        args[j] = temp;
    }

    public static void main(String[] args){
        int len = (int) (Math.random()*300);
        double[] d = new double[len];
        for (int i=0;i<len;i++){
            d[i] = Math.random()*100;
        }
        sort(d);
        for (int i=0;i<len;i++){
            System.out.println(d[i]+"");
        }
    }
}
