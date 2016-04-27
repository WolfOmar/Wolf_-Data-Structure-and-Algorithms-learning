package util;

/**
 * Created by aristark on 4/6/16.
 * Framework for performing timed tests of containers.
 */
public abstract class Test<C> {
    private String name;
    public Test(String name){
        this.name = name;
    }

    abstract int test(C container,TestParam tp);
}


