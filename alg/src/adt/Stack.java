package adt;

import java.util.Iterator;

/**
 * Created by aristark on 3/19/16.
 * 栈:先进后出FILO
 * 用List实现:addFirst,removeFirst或者addLast,removeLast
 */
public class Stack<Item> implements Iterable<Item> {
    private List<Item> list;

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    public Stack(){
        list = new List<Item>();
    }

    public void push(Item item){
        list.add(item);
    }

    public Item pop(){
        return list.remove();
    }

    public int size(){
        return list.getSize();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    /* 测试 */
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<Integer>();
        int len = (int) (Math.random()*20);
        for (int i=0;i<len;i++){
            int value = (int) (Math.random()*20);
            System.out.println("we will push "+value);
            stack.push(value);
        }
        System.out.println("--------------------------------------------------------");
        for (int i=0;i<len;i++){
            System.out.println("we will pop "+stack.pop());
        }

    }
}
