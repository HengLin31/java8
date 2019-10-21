package pers.henglin.java8.lambda;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pers.henglin.java8.Identification;

import java.util.function.Supplier;

/**
 * Created by linheng on 2019/10/20.
 */
public class SupplierTest {
    private static final String SAY_HI = "Hi, ";

    private static Logger logger = LoggerFactory.getLogger(SupplierTest.class);

    @Test
    public void testSupplier(){
        Identification.initByDefaultData().forEach(identification ->
                logger.info(say(identification, () ->
                        SAY_HI)));
    }

    private String say(Identification identification, Supplier<String> supplier){
        return supplier.get() + identification.getName();
    }
}
