package util;

/**
 * Created by aristark on 4/1/16.
 */
public class GeneratorsTest {

    /**
     * test for Counting Generator
     */
    public static int size = 10;
    public static void main(String[] args){
//        test(CountingGenerator.class);
        test(RandomGenerator.class);
    }

    public static void test(Class<?> surroundingClass){
        for (Class<?> type : surroundingClass.getClasses()){
            System.out.println(type.getSimpleName());
            try {
                Generator<?> g = (Generator<?>) type.newInstance();
                for (int i=0;i<size;i++){
                    System.out.println(g.next());
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }
}
