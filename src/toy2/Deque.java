package toy2;

import core.func.Action;
import core.func.IPredicate;
import core.node.AbstractNode;
import core.node.Node;
import core.node.Sentinel;

import java.util.function.Function;

public class Deque<T> {
    private long size;
    private  final Sentinel<T> head;

    private  final Sentinel<T> tail;

    public Deque(){
        head=new Sentinel<>();
        tail=new Sentinel<>();
        head.add(tail);
        size=0;
    }

    static <T> Deque<T> of(T ...items){
        Deque<T> deque= new Deque<>();
        for (T  item:items) {
            deque.addFromTail(item);
        }
        return deque;
    }

    public <Element> Li<Element> map(Function<T, Element> f) {
        AbstractNode<T> node=head.next();//head is Sentinel
        Li<Element> returnL=new Li<>();
        while ( node instanceof Node){
            Node<T>  n=(Node<T>)node;

            Element  element=f.apply(n.getData());
            returnL.add(element);
            node=node.next();
        }
        return returnL;
    }

    public  void forEach(Action<T> action){
        AbstractNode<T> iterNode=head.next();
        while (iterNode instanceof Node){
            action.on(getData(iterNode));
            iterNode=iterNode.next();
        }
    }

    public  void forM(long from, IPredicate<Long> predicate,Action<T> action){
        AbstractNode<T> iterNode=head.next();
        while (iterNode instanceof Node){
            action.on(getData(iterNode));
            iterNode=iterNode.next();
        }
    }

    public  void forRange(long from,long to,Action<T> action){

        if(from>to){
            return;
        }
        AbstractNode<T> iterNode=head.next();
        int i=0;
        while (iterNode instanceof Node){

            if(i>=from && i<=to ){
                action.on(getData(iterNode));
                iterNode=iterNode.next();
                i=i+1;
            }else if (i<from){
                i=i+1;
                iterNode=iterNode.next();
            }else {
                return;
            }
        }
    }


    public Deque<T> addFromTail(T t) {
        checkSize();
        Node<T> node=new Node<>(t);
        tail.pre().add(node);
        node.add(tail);
        size=size+1;
        return this;
    }

    public Deque<T> addFromHead(T t) {
        checkSize();
        Node<T> node=new Node<>(t);
        node.add(head.next());
        head.add(node);
        size=size+1;
        return this;
    }

    public T removeFromHead(){
        if(isEmpty()){
           throw  new IllegalStateException("can not remove element from  empty queue");
        }
        Node<T> wantRemove= (Node<T>) head.next();
        return helpRemove(wantRemove);
    }


    public T removeFromTail(){
        if(isEmpty()){
            throw  new IllegalStateException("can not remove element from  empty queue");
        }
        Node<T> wantRemove= (Node<T>) tail.pre();
        return helpRemove(wantRemove);
    }

    public T peekHead(){
        if(isEmpty()){
            throw  new IllegalStateException("can not peek element from  empty queue");
        }
        Node<T> wantRemove= (Node<T>) head.next();
        return getData(wantRemove);
    }

    public T peekTail(){
        if(isEmpty()){
            throw  new IllegalStateException("can not peek element from  empty queue");
        }
        Node<T> wantRemove= (Node<T>) tail.pre();
        return getData(wantRemove);
    }

    private T helpRemove( Node<T> node){
        node.alone();
        return node.getData();
    }

    public  void remove(T that){
         this.forEachNode(node->{
             if(node.equals(that)){
                 node.alone();
             }
         });
    }

    private   void forEachNode(Action<Node<T>> action){
        AbstractNode<T> next=head.next();
        while (next instanceof Node){
            action.on((Node)next);
            next=next.next();
        }
    }


    private  T getData(AbstractNode<T> node){
        Node<T> n=(Node<T>)node;
        return n.getData();
    }

    private void checkSize(){
        if(size==Long.MAX_VALUE){
            throw new IllegalStateException("no capacity");
        }
    }

    long size(){
      return this.size;
    }

    boolean isNotEmpty(){
        return  size()>0;
    }

    boolean isEmpty(){
        return  size()==0;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder().append("( ");
        this.forEach(data->sb.append(data).append(" "));
        return sb.append(")").toString();
    }
}

