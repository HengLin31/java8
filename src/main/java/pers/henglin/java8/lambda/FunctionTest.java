package pers.henglin.java8.lambda;

import org.junit.Test;
import pers.henglin.java8.Identification;

import java.util.function.Function;

/**
 * Created by linheng on 2019/10/20.
 */
public class FunctionTest {

    @Test
    public void sss(){
        Identification.initByDefaultData().forEach(identification ->
                System.out.println(getName(identification, (name) ->
                        "[ " + name + " ]" )));
    }

    private String getName(Identification identification, Function<String, String> function){
        return function.apply(identification.getName());
    }
}
