package util;

/**
 * Created by aristark on 4/6/16.
 * A data transfer object
 */
public class TestParam {
    public final int size;
    public final int loop;

    public TestParam(int size,int loop){
        this.size = size;
        this.loop = loop;
    }

    public static TestParam[] array(int... values){
        int size = values.length/2;
        TestParam[] result = new TestParam[size];
        int n = 0;
        for (int i=0;i<size;i++){
            result[i] = new TestParam(values[n++],values[n++]);
        }
        return result;
    }

    public static TestParam[] array(String[] values){
        int[] vals = new int[values.length];
        for (int i=0;i<values.length;i++){
            vals[i] = Integer.decode(values[i]);
        }
        return array(vals);
    }

    public static void main(String[] args){
        test(1,2,3);
        int[] a = new int[3];
        for (int i=0;i<a.length;i++){
            a[i] = i+3;
        }
        test(a);
    }

    public static void test(int... values){
        for (int i : values){
            System.out.println(i+"");
        }
    }
}
