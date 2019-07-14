package core.func;

@FunctionalInterface
public interface IFunc1<Param,Return> {
     Return apply(Param param);


    default <T> T apply1(Param param, IFunc1<Param,T> func){
      return  func.apply(param);
    };
}
