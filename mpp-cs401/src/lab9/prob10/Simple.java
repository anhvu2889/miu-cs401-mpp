package lab9.prob10;

import java.util.Arrays;
import java.util.List;

public class Simple {

    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public Simple(boolean flag) {
        this.flag = flag;
    }

    public static boolean someSimpleIsTrue(List<Simple> simples) {
        return simples.stream()
                .map(Simple::isFlag)
                .reduce(false, (flag1 , flag2) -> flag1 || flag2);
    }

    public static void main(String[] args) {
        List<Simple> list = Arrays.asList(new Simple(false), new Simple(true), new Simple(true));
        System.out.println(someSimpleIsTrue(list));
    }

}
