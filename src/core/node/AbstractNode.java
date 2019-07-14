package core.node;

public abstract class AbstractNode<T> {

    protected AbstractNode<T> pre;
    protected AbstractNode<T> next;

    public AbstractNode(AbstractNode<T> pre,AbstractNode<T> next){
        this.pre=pre;
        this.next=next;
    }

    public AbstractNode pre(){
        return  this.pre;
    }

    public void add(AbstractNode<T> next){
        next.pre=this;
        this.next=next;
    }

    public  void alone(){
        if(pre==null && this.next!=null){
            this.next.pre=null;
            this.next=null;
        }else  if(pre!=null && this.next==null){
            this.pre.next=null;
            this.pre=null;
        }else if(pre!=null && this.next!=null){
              this.pre.add(this.next);
              this.pre=null;
              this.next=null;
        }
    }


    public AbstractNode next(){
        return  this.next;
    }

    public boolean isSentinel(){
        return false;
    }

}


