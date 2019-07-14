package core.func;

public interface IReduce<Param> extends IFold<Param,Param> {
    @Override
    Param apply(Param initial, Param param2);
}
