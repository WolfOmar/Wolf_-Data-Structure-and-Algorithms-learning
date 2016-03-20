package search;

/**
 * Created by aristark on 3/20/16.
 * 递归版本的二分查找
 * 如果找不到会抛出一个stackoverflow的异常,那就要想一下递归和stack有什么关系了
 * 理解递归,从我做起
 */
public class BinarySearch {

    /* args是已经排好序的数组*/
    public static int find(double[] args,double key,int low,int high){
        int mid = (low+high) / 2;

        if (key == args[mid])
            return mid;

        if (key > args[mid])
            return find(args,key,mid,high);    //如果key比中值大,那它可能在数组的右边
        else
            return find(args,key,low,mid);     //反之它可能在数组的左边

    }

    /* 测试 */
    public static void main(String[] args){
        double[] d = new double[5];
        d[0] = 1.0;
        d[1] = 2.0;
        d[2] = 3.0;
        d[3] = 4.0;
        d[4] = 5.0;
        double key = 6.0;
        String result;
        try{
            result = find(d,key,0,4)+"";
        }catch (StackOverflowError e){
            result = "没找到";
        }

        System.out.println("最后的结果是: "+result);

    }
}
