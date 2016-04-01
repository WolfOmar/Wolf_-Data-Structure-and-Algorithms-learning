package util;


import java.util.ArrayList;

/**
 * Created by aristark on 4/1/16.
 * A Collection filled with data using a generator object
 */
public class CollectionData<T> extends ArrayList<T> {
    public CollectionData(Generator<T> gen,int quantity){
        //这个写法很吊啊
        for (int i=0;i<quantity;i++){
            add(gen.next());
        }
    }

    //A generic convenience method:
    public static <T> CollectionData<T> list(Generator<T> gen,int quantity){
        return new CollectionData<T>(gen,quantity);
    }

}
