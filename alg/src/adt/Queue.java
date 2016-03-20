package adt;

import java.util.Iterator;

/**
 * Created by aristark on 3/19/16.
 * 队列:先进先出FIFO
 * 用List实现:addFirst,removeLast活着addLast,removeFirst
 */

public class Queue<Item> implements Iterable<Item> {
    private List<Item> list;

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    public Queue(){
        list = new List<Item>();
    }

    /* add a item */
    public void enqueue(Item item){
        list.addLast(item);
    }

    /* remove the least recently added item*/
    public Item dequeue(){
        return list.remove();   //remove first
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public int size(){
        return list.getSize();
    }

    public static void main(String[] args){
        int length = (int) (Math.random()*20);
        Queue<Integer> q = new Queue<Integer>();
        for (int i=0;i<length;i++){
            int value = (int) (Math.random()*30);
            System.out.println("we will enqueue: "+value);
            q.enqueue(value);
        }
        System.out.println("-------------------------------------------");
        for (int i=0;i<length;i++){
            System.out.println("we will dequeue: "+q.dequeue());

        }
    }
}
