package pers.henglin.java8.stream;

import org.junit.Before;
import org.junit.Test;
import pers.henglin.java8.Identification;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by linheng on 21/10/2019.
 */
public class StreamTest {
    private static final String NOT_FIND_DATA = "not find data";

    private List<Identification> identifications;

    @Before
    public void streamTest(){
        this.identifications = Identification.initByDefaultData();
    }

    @Test
    public void findAgeRange(){
        int ageStart = 20;
        int ageEnd = 70;
        identifications.stream()
                .filter(identification -> (identification.getAge() >= ageStart && identification.getAge() <= ageEnd))
                .map(identification -> identification.getName() + ": " + identification.getAge())
                .forEach(System.out::println);
    }

    @Test
    public void findTopByAge(){
        int topNum = 5;
        identifications.stream()
                .sorted((obj1, obj2) -> Integer.compare(obj2.getAge(), obj1.getAge()))
                .limit(topNum)
                .forEach(System.out::println);
    }

    @Test
    public void totalAge(){
        Optional<Integer> sum = identifications.stream()
                .map(Identification::getAge)
                .reduce(Integer::sum);
        print(sum);
    }

    @Test
    public void getNames(){
        identifications.stream()
                .map(Identification::getName)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    @Test
    public void getMaxAge(){
        Optional<Integer> maxAge =identifications.stream()
                .map(Identification::getAge)
                .min(Integer::compare);
        print(maxAge);
    }

    private void print(Optional<?> data){
        //System.out.println(data.orElse(NOT_FIND_DATA);
        if(data.isPresent()){
            System.out.println(data.get());
        }else{
            System.out.println(NOT_FIND_DATA);
        }
    }
}
