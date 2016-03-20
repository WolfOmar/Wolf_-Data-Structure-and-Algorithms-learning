package adt;

/**
 * Created by aristark on 3/20/16.
 * 双链表,后面可以用它来实现stack和queue
 */
public class List<Item> {
    private Node head;
    private Node tail;
    private int size;

    public List(){
        head = null;
        tail = null;
        size = 0;
    }
    /* 默认从表头添加结点 */
    public void add(Item item){
        addFirst(item);
    }

    /* 从表头开始添加结点 */
    public void addFirst(Item item){
        Node n = new Node(item);

        /* 第一次添加,需要处理一下tail */
        if (isEmpty()){
            tail = n;
//            head = n;
        }else {
            head.setPrevious(n);    //把当前的头结点的前指针指向n
            n.setNext(head);        //那n的后指针指向当前的头结点
//            head = n;               //最后头结点就是n啦
        }

        head = n;               //最后头结点就是n啦
        size++;

    }

    /* 从表尾添加结点 */
    public void addLast(Item item){
        Node n = new Node(item);
        if (isEmpty()){
            head = n;
        }else{
            tail.setNext(n);
            n.setPrevious(tail);
        }
        tail = n;
        size++;

    }

    /* 默认从表头删除结点 */
    public Item remove(){
        return removeFirst();
    }

    /* 从表头删除结点 */
    public Item removeFirst(){
        if (isEmpty()){
            return null;
        }
        Node temp = head;
        if (head.getNext() == null){
//            temp = head;
            tail = null;
//            head = null;
        }else{
//            temp = head;
            head.getNext().setPrevious(null);
//            head = head.getNext();
        }
        head = head.getNext();
        size--;
        return temp.getItem();
    }

    /* 从表尾删除结点 */
    public Item removeLast(){
        if (isEmpty()){
            return null;
        }
        Node temp = tail;
        if (tail.getPrevious() == null){
            head = null;
        }else{
            tail.getPrevious().setNext(null);
        }
        tail = tail.getPrevious();
        size--;
        return temp.getItem();
    }


    /* 获取结点数 */
    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return (head == null);
    }

    /* 结点类 */
    private class Node{
        private Item item;
        private Node previous;
        private Node next;

        public Node(Item item){
            this.item = item;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrevious() {
            return previous;
        }

        public Node getNext() {
            return next;
        }

        public String toString(){
            return "this is node "+item;
        }

        public Item getItem() {
            return item;
        }
    }

    /* 测试真的很重要吖 */
    public static void main(String[] args){
        List list = new List();
        /* add first and delete first:stack */
        list.add(1);
        list.add(2);
        list.add(10);
        list.add(20);
        list.add(1);

        System.out.println(list.remove()+"");
        System.out.println(list.remove()+"");
        System.out.println(list.remove()+"");
        System.out.println(list.remove()+"");


        /* add last and delete last:stack*/
        list.addLast(3);
        list.addLast(4);
        System.out.println(list.removeLast());
        System.out.println(list.removeLast());

        /* add first and delete last: queue */
        list.add(5);
        list.add(6);
        System.out.println(list.removeLast());
        System.out.println(list.removeLast());
    }
}
