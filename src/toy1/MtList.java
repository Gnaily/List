package toy1;

import core.func.*;

public class MtList<Item > implements IList<Item> {

    public <Element> IList<Element> map(IFunc1<Item, Element> map) {
        return new MtList<>();
    }


    /**
     * @see IList#reduceLeft
     **/
    @Override
    public Item reduceLeft(IReduce<Item> reducer)  {
         throw new IllegalStateException("can not reduce empty list");
    }

    @Override
    public <Accumulation> Accumulation foldLeft(Accumulation initial, IFold<Item,Accumulation> accumulator) {
        return initial;
    }

    /**
     * @see IList#filter
     **/
    @Override
    public IList<Item> filter(IPredicate<Item> condition) {
        return new MtList<>();
    }

    @Override
    public boolean equals(Object that) {
        if(this==that){
            return true;
        }else{
            if (that == null || this.getClass() != that.getClass()) {
                return false;
            }else {
                return true;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public int size() {
        return 0;
    }

    /**
     * @see IList#first
     */
    @Override
    public Item first() {
         throw new IllegalStateException("can not get first element from empty list");
    }

    @Override
    public IList rest() {
        return this;
    }


    @Override
    public IList add(Item item) {
        return  new ConsList(item,this);
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
