package toy1;

public class Main {
    
    public static void main(String[] args){
        MtList<Integer> mt=new MtList<>();
        System.out.println(mt.equals(mt));
        System.out.println(mt.equals(new MtList<>()));
        System.out.println(mt.equals(new MtList<Double>()));
        System.out.println(mt.hashCode()==new MtList<Integer>().hashCode());

        IList<Integer> list=
                new ConsList<>(1,
                                    new ConsList<>(2,
                                            new ConsList<>(3,
                                                    new ConsList<>(4,
                                                            new ConsList<>(5,
                                                                    new ConsList<>(6,
                                                                            new MtList<>()))))));

        System.out.println("size:"+list.size());
        IList<Integer> list25=
                new ConsList<>(2,
                        new ConsList<>(3,
                                new ConsList<>(4,
                                        new ConsList<>(5,
                                                        new MtList<>()))));

        IList<Double> list52=
                new ConsList<>(1*5.2,
                    new ConsList<>(2*5.2,
                        new ConsList<>(3*5.2,
                            new ConsList<>(4*5.2,
                                new ConsList<>(5*5.2,
                                        new ConsList<>(6*5.2,
                                                new MtList<>()))))));


        System.out.println("map:"+list52.equals(list.map(integer ->  5.2*integer)));
        System.out.println("filter:"+list25.equals(list.filter(integer ->   integer>1&&integer<6)));
        System.out.println("foldl:"+(1*2*3*4*5*6==list.foldLeft(1,(foldResult,item) ->   foldResult*item)));
        System.out.println("reduce:"+(1*2*3*4*5*6==list.reduceLeft((reduceResult,item) ->   reduceResult*item)));

    }
}



