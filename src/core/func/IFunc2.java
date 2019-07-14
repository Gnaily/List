package core.func;

@FunctionalInterface
public interface IFunc2<Param1,Param2,Return > {

    Return apply(Param1 param, Param2 param2);
}
