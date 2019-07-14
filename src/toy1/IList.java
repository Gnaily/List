package toy1;

import core.func.IFold;
import core.func.IFunc1;
import core.func.IPredicate;
import core.func.IReduce;

public interface IList<Item> {

    <Element> IList<Element> map(IFunc1<Item, Element> f);

    Item reduceLeft(IReduce<Item> reducer) throws IllegalStateException;

    <Accumulation> Accumulation foldLeft(Accumulation initial, IFold<Item,Accumulation> accumulator);

    IList<Item> filter(IPredicate<Item> condition);

    boolean equals(Object that);

    boolean isEmpty();

    int size();

    Item first() throws IllegalAccessException;

    IList rest();

    IList add(Item item);

}
