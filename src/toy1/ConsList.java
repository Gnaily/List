package toy1;

import core.func.IFold;
import core.func.IFunc1;
import core.func.IPredicate;
import core.func.IReduce;

import java.util.Objects;

public class ConsList<Item> implements IList<Item> {
    private final Item first;
    private IList<Item> rest;
    private final   int size;


    public ConsList(Item first, IList<Item> rest) throws  IllegalArgumentException {
        if(first==null || rest==null){
            throw new IllegalArgumentException("null argument is not allowed");
        }
        size=1+rest.size();
        this.first = first;
        this.rest = rest;
    }

    public <Element> IList<Element> map(IFunc1<Item, Element> mapper) {
        return new ConsList<>(mapper.apply(this.first), this.rest.map(mapper));
    }

    @Override
    public Item reduceLeft(IReduce<Item> reducer) {
        if(rest.isEmpty()){
            return  first;
        }else{
            return reducer.apply(first, rest.reduceLeft(reducer));
        }
    }

    @Override
    public <Accumulation> Accumulation foldLeft( Accumulation initial, IFold<Item,Accumulation> fold) {
        return rest.foldLeft(fold.apply(first,initial),fold);
    }

    @Override
    public IList<Item> filter(IPredicate<Item> predicator) {

        if(predicator.apply(first)){
            return new ConsList<>(first, this.rest.filter(predicator));
        }else{
            return this.rest.filter(predicator);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsList<?> consList = (ConsList<?>) o;
        return Objects.equals(first, consList.first) &&
                Objects.equals(rest, consList.rest);
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Item first() {
        return first;
    }

    @Override
    public IList rest() {
        return rest;
    }

    @Override
    public IList add(Item item) {
        return new ConsList(item,this);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, rest);
    }
}
