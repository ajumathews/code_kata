import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.practice.Child;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {

    @InjectMocks
    @Spy
    Child child;


    @Test
    public void testMockExecuteChild() {
        Mockito.when(child.execute()).thenReturn("Hello from mock parent");
        System.out.println(child.executeChild());
    }
}

