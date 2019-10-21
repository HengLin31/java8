package pers.henglin.java8.lambda;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pers.henglin.java8.Identification;

import java.util.function.Function;

/**
 * Created by linheng on 2019/10/20.
 */
public class FunctionTest {
    private static Logger logger = LoggerFactory.getLogger(FunctionTest.class);

    @Test
    public void testFunction(){
        Identification.initByDefaultData().forEach(identification ->
                logger.info(getName(identification, (name) ->
                        "[ " + name + " ]" )));
    }

    private String getName(Identification identification, Function<String, String> function){
        return function.apply(identification.getName());
    }
}
