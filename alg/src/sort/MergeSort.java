package sort;

/**
 * Created by aristark on 3/20/16.
 * 归并排序
 */
public class MergeSort {
    /**
     * 代码非常简介
     * 但是我相信
     * 你可能和
     * 我一样
     * 不理
     * 解
     * */
    public static void sort(double[] args,int low,int high){
       if (low < high){
           int mid = (low+high)/2;
           sort(args,low,mid);
           sort(args,mid+1,high);
           merge(args,low,mid,high);
       }
    }

    /**
     * 归并排序的子程序
     * @param args 需要排序的数组
     * @param low 到middle段子数组已经排好序
     * @param middle 到high段子数组已经排好序列
     * example:A = [2,4,6,8,1,3,5,7]
     * */
    public static void merge(double[]args,int low,int middle,int high){
        /* 先要把分别已经排好序的左右两段复制出来,合并成一个数组后再复制回去*/
        int leftLen = middle-low+1;
        int rightLen = high-middle;
        double[] left = new double[leftLen];
        double[] right = new double[rightLen];
        double[] result = new double[leftLen+rightLen];

        for (int i=0;i<leftLen;i++){
            left[i] = args[low+i];
        }

        for (int i=0;i<rightLen;i++){
            right[i] = args[middle+1+i];
        }

        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;

        while (leftIndex < leftLen && rightIndex < rightLen){
            if (left[leftIndex] < right[rightIndex]){
                result[resultIndex++] = left[leftIndex++];

            }else{
                result[resultIndex++] = right[rightIndex++];
            }
        }

        while (leftIndex < leftLen){
            result[resultIndex++] = left[leftIndex++];
        }

        while (rightIndex < rightLen){
            result[resultIndex++] = right[rightIndex++];
        }

        /* 复制回原数组 */
        for (int i=0;i<high-low+1;i++){
            args[low+i] = result[i];
        }

    }

    public static void main(String[] args){
        int len = (int) (Math.random()*300);
        double[] d = new double[len];
        for (int i=0;i<len;i++){
            d[i] = Math.random()*100;
        }
        sort(d,0,len-1);
        for (int i=0;i<len;i++){
            System.out.println(d[i]+"");
        }
    }
}
