package core.node;

/**
 * initial Sentinel
 * +----+              +----+
 * |    |              |    |
 * |    V              V    |
 * |  +------------------+  |
 * |  | Sentinel<T>      |  |
 * |  +------------------+  |
 * +--- next             |  |
 *    | prev ---------------+
 *    +------------------+
 *
 */
public class Sentinel<T> extends AbstractNode<T>{

    public Sentinel() {
        super(null, null);
        this.pre=this;
        this.next=this;
    }

    @Override
    public boolean isSentinel() {
        return true;
    }

}
