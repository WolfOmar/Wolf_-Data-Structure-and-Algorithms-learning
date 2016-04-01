package util;

import java.util.Arrays;

/**
 * Created by aristark on 4/1/16.
 */
public class Generated {
    //fill an existing array:
    public static <T> T[] array(T[] a,Generator<T> gen){
        return new CollectionData<T>(gen,a.length).toArray(a);
    }

    //Create a new array:
    public static <T> T[] array(Class<T> type,Generator<T> gen,int size){
        T[] a = (T[]) java.lang.reflect.Array.newInstance(type,size);
        return new CollectionData<T>(gen,size).toArray(a);
    }

    //测试
    public static void main(String[] args){
        Integer[] a = {1,2,3,4};
        System.out.println(Arrays.toString(a));
        a = Generated.array(a, new CountingGenerator.Integer());
        System.out.printf(Arrays.toString(a));
        Integer[] b = array(Integer.class,new CountingGenerator.Integer(),20);
        System.out.println(Arrays.toString(b));
    }
}
