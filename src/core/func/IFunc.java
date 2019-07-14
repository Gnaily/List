package core.func;

@FunctionalInterface
public interface IFunc<A> {
     void apply(A arg);

     default void apply(A ...args){
          for (A arg:args){
               apply(arg);
          }
     }
}
