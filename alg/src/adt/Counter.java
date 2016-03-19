package adt;

/**
 * Created by aristark on 3/19/16.
 * 这是算法介绍的第一个ADT,用来计数的一个数据结构
 * 因为不熟悉IDEA我真的折腾了好久
 */
public class Counter {
    private final String name;
    private int count;

    public Counter(String id){
        name = id;
    }

    public void increment(){
        count++;
    }

    public int tally(){
        return count;
    }

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
          System.out.println("heads: "+heads+" tails: "+tails);
      }
}
