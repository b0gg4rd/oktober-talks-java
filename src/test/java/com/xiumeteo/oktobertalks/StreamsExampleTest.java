package com.xiumeteo.oktobertalks;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.xiumeteo.oktobertalks.Person.somePeople;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class StreamsExampleTest {

    private final List<Integer> ages = IntStream.range(0, 1000).boxed().collect(Collectors.toList());

    @Test
    public void testCreateStreams(){

        final Stream<Integer> over2 = ages //
                .stream() //
                .filter(age -> age > 2); //

        final Stream<Integer> under2 = ages //
                .stream() //
                .filter(age -> age < 2);//

        over2.collect(Collectors.toList());
        under2.collect(Collectors.toList());

        assertTrue(true);
    }


    @Test
    public void testCloseStreamsAlreadyClosed(){

        final Stream<Integer> over2 = ages //
                .stream() //
                .filter(age -> age > 2); //

        final Stream<Integer> over2and5 = over2 //
                .filter( age -> age > 5);

        over2.collect(Collectors.toList());
        over2and5.collect(Collectors.toList());

        assertTrue(true);
    }

    @Test
    public void testDoWeHave5(){
        assertTrue(ages.stream() //
            .anyMatch( age -> age == 5));

    }

    @Test
    public void testGroupByCountry(){
        final Map<String, List<Person>> personByCountry = somePeople.stream()
                .collect(Collectors.groupingBy(Person::getCountry));

        System.out.println( personByCountry );

        assertEquals( 3, personByCountry.keySet().size());
    }

    @Test
    public void testPrintEachOne(){
        somePeople.forEach( System.out::println );
        assertTrue( true );
    }

    @Test
    public void testFindTheYounger(){
        final OptionalInt min = Person.somePeople.stream()
                .mapToInt(Person::getAge)
                .min();

        assertEquals( 10, min.getAsInt() );
    }

    @Test
    public void testSumAges(){
        final Integer reduce = ages.stream() //
                .reduce(0, (a, b) -> a + b);

        final int sum = ages.stream() //
                .mapToInt(Integer::intValue) //
                .sum();

        assertEquals(reduce.intValue(), sum);

    }

    @Test
    public void testWrongDontDo(){

        List<String> salutations = new ArrayList<>();

        ages.stream() //
                .map( a -> "I have "+a ) //
                .sorted() //
                .forEach(salutations::add); //

        System.out.println( salutations );

        fail();
    }



}