package toy2;

import core.func.IAccumulator;

public class Main {

    public static class MulAccumulator implements IAccumulator<Integer,Integer>{


            private Integer res;

            @Override
            public void initResult(Integer integer) {
                res=integer;
            }

            @Override
            public void accumulate(Integer integer) {
                res=res*integer;
            }

            @Override
            public Integer getResult() {
                return res;
            }

    }

    public static void main(String[] args){
        Li<Integer> li=Li.of(1,2,3,4,5,6);

        Li<Integer> list25=Li.of(2,3,4,5);

        Li<Double> list52=Li.of(1*5.2,2*5.2,3*5.2,4*5.2,5*5.2,6*5.2);
        System.out.println("size-li:"+li.size());
        System.out.println("li[0]:"+li.get(0));
        System.out.println("li[2]:"+li.get(2));
        System.out.println("li[6]:"+li.get(5));

        System.out.println("list25:"+list52.toString());
        System.out.println("map-list52:"+li.map(integer ->  5.2*integer).toString());
        System.out.println("filter-li:"+li.filter(integer ->   integer>1&&integer<6).toString());
        System.out.println("foldl-li:"+(5*1*2*3*4*5*6==li.foldLeft(5,  new MulAccumulator())));
        System.out.println("reduce-li:"+(1*2*3*4*5*6==li.reduceLeft(new MulAccumulator())));
        System.out.println("li[6]:"+li.get(6));
    }
}
