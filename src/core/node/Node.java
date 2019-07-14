package core.node;

public class Node<T> extends AbstractNode<T>{
    private T data;
    public Node(T data){
        super(null,null);
        this.data=data;
    }

    public Node(T data,AbstractNode<T> next){
        this(data);
        this.add(next);
    }

    public Node(T data,AbstractNode<T> pre,AbstractNode<T> next){
        this(data);
        // pre->this->next
        pre.add(this);
        this.add(next);
    }



    public T getData() {
        return data;
    }
}
