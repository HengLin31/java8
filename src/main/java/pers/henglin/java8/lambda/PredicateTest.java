package pers.henglin.java8.lambda;

import org.junit.Test;
import pers.henglin.java8.Identification;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by linheng on 2019/10/20.
 */
public class PredicateTest {

    @Test
    public void testPredicate(){
        filterNames(Identification.initByDefaultData(), (str) -> str.length() == 3).forEach(System.out::println);
    }

    private List<String> filterNames(List<Identification> identifications, Predicate<String> predicate){
        List<String> names = new LinkedList<>();
        for(Identification identification:identifications){
            if(predicate.test(identification.getName())){
                names.add(identification.getName());
            }
        }
        return names;
    }
}
