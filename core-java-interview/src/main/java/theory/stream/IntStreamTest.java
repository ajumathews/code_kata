package theory.stream;

import org.junit.Test;

import java.util.stream.IntStream;

public class IntStreamTest {

    @Test
    public void testRange(){
        IntStream.range(0,10).forEach(System.out::println);
    }

    @Test
    public void testOf(){
        IntStream.of(10,2,3,4).forEach(System.out::println);
    }
}
