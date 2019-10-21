package pers.henglin.java8.lambda;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pers.henglin.java8.Identification;

import java.util.List;
import java.util.function.Consumer;

/**
 * Created by linheng on 2019/10/20.
 */
public class ConsumerTest {
    private static Logger logger = LoggerFactory.getLogger(ConsumerTest.class);

    private static final String OLD = "old";
    private static final String YOUNG = "young";

    @Test
    public void testConsumer(){
        int oldAge = 40;
        List<Identification> identifications = Identification.initByDefaultData();
        identifications.forEach(identification ->
                isOld(identification, oldAge, (old) ->
                        logger.info("{} {} {}", identification.getName(), "is", (old ? OLD : YOUNG ))));
    }

    private void isOld(Identification identification, int oldAge, Consumer<Boolean> consumer){
        consumer.accept(identification.getAge() > oldAge);
    }
}
