package core.func;
@FunctionalInterface
public  interface IPredicate<Param> extends IFunc1<Param,Boolean> {
    @Override
    Boolean apply(Param param);
}
