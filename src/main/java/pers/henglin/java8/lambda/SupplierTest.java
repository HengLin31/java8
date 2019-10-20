package pers.henglin.java8.lambda;

import org.junit.Test;
import pers.henglin.java8.Identification;

import java.util.function.Supplier;

/**
 * Created by linheng on 2019/10/20.
 */
public class SupplierTest {
    private static final String SAY_HI = "Hi, ";

    @Test
    public void testSupplier(){
        Identification.initByDefaultData().forEach(identification ->
                System.out.println(say(identification, () ->
                        SAY_HI)));
    }

    private String say(Identification identification, Supplier<String> supplier){
        return supplier.get() + identification.getName();
    }
}
