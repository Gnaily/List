package core.func;

public interface IFold<Param,Return> extends IFunc2<Param,Return,Return> {
    @Override
    Return apply(Param param, Return initial);
}
