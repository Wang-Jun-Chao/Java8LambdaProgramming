import com.java.lambda.Testing;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Author: 王俊超
 * Date: 2015/12/7 14:25
 * All Rights Reserved !!!
 */
public class TestingTest {
    @Test
    public void multipleWordsToUppercase() {
        List<String> input = Arrays.asList("a", "b", "hello");
        List<String> result = Testing.allToUpperCase(input);
        Assert.assertEquals(Arrays.asList("A", "B", "HELLO"), result);
    }

    @Test
    public void twoLetterStringConvertedToUppercaseLambdas() {
        List<String> input = Collections.singletonList("ab");
        List<String> result = Testing.elementFirstToUpperCaseLambdas(input);
        Assert.assertEquals(Collections.singletonList("Ab"), result);
    }

    @Test
    public void twoLetterStringConvertedToUppercase() {
        String input = "ab";
        String result = Testing.firstToUppercase(input);
        Assert.assertEquals("Ab", result);
    }

    private List<Integer> otherList = Arrays.asList(1, 2, 3);
    @Test
    public void mockitoLambdas() {
        List<String> list = Mockito.mock(List.class);

        Mockito.when(list.size()).thenAnswer(inv -> otherList.size());

        Assert.assertEquals(3, list.size());
    }
}
