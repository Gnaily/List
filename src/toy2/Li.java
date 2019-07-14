package toy2;

import core.func.*;


import java.util.function.Function;

public class Li<T> {

    private Deque<T> deque;

    public Li(){
        deque=new Deque<>();
    }

    public Li(Deque<T> deque){
        this.deque=deque;
    }


    static <T> Li<T> of(T ...items){
        return new Li(Deque.of(items));
    }



    public static void main(String[] args){
       Li<Integer> list= Li.of(1,2,3,4,5);

       list.map(i->{
           System.out.println(i);
           return i;
       }) ;

    }


    public <Element> Li<Element> map(Function<T, Element> f) {
        Li<Element> list=new Li<>();
        deque.forEach(data->list.add(f.apply(data)));
        return list;
    }


    public T reduceLeft(IAccumulator<T,T> accumulator) {
        accumulator.initResult(deque.peekHead());
        return foldLeft(deque.peekHead(),accumulator);
    }


    public <R> R foldLeft(R initial,IAccumulator<T,R> accumulator) {

        accumulator.initResult(initial);
        deque.forRange(1,deque.size(),data->{
            accumulator.accumulate(data);
        });
        return accumulator.getResult();
    }


    public Li<T> filter(IPredicate<T> predicate) {
        Li<T> list=new Li<>();
        deque.forEach(data->{
            if(predicate.apply(data)) {
                list.add(data);
            }
        });
        return list;
    }


    public Li<T> add(T t) {
        deque.addFromTail(t);
        return this;
    }

    public long size() {
       return deque.size();
    }


    private  class CollectResultAction<T> implements Action<T>{
        public T result;
        @Override
        public void on(T arg) {
            result=arg;
        }

        public T getResult() {
            return result;
        }
    }


    public T get(int index){
        if(index>size()) {
            throw  new IndexOutOfBoundsException("size:"+size()+",index:"+index);
        }
        CollectResultAction<T> collect=new CollectResultAction();
        deque.forRange(index, index,collect);
        return  collect.getResult();
    }

    public void remove(T t) {
        deque.remove(t);
    }

    public void removeIf(IPredicate<T> predicate) {
        deque.forEach(data->{
            if (predicate.apply(data)) {
                deque.remove(data);
            }
        });
    }

    @Override
    public String toString() {
        return deque.toString();
    }
}
