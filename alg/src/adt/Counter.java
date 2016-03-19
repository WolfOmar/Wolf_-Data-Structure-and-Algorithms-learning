package adt;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by aristark on 3/19/16.
 * 这是算法介绍的第一个ADT,用来计数的一个数据结构
 * 因为不熟悉IDEA我真的折腾了好久
 */
public class Counter {
    private final String name;
    private int count;

    /* create a counter named id */
    public Counter(String id){
        name = id;
    }

    /* increment the counter */
    public void increment(){
        count++;
    }

    /* number of increments since creation */
    public int tally(){
        return count;
    }

    /* string representation */
    public String toString(){
        return name+" "+count;
    }

    /*
    * 测试,我也不知道要测试什么,就当养成习惯的开始吧
    */
      public static void main(String[] args){
          Counter heads = new Counter("heads");
          Counter tails = new Counter("tails");
          heads.increment();
          heads.increment();
          tails.increment();
//          System.out.println("heads: "+heads+" tails: "+tails);
          StdOut.println("heads: "+heads+" tails: "+tails);

      }
}
