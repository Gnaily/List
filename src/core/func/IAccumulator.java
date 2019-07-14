package core.func;

public interface IAccumulator<P,R> {

    default void initResult(R r){

    };

    void accumulate(P p);

    R getResult();
}
