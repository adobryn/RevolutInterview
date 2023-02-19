import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoadBalancerTest {
    LoadBalancer testee;

    @BeforeEach
    public void setUp(){
        testee = new LoadBalancer();
    }

    @Test
    public void shouldRegisterNewInstance(){
        int initialAmountOfInstances = testee.getCurrentAmountOfInstances();
        String newInstance = "somenewinstance";
        testee.registerNewInstance(newInstance);

        assertEquals(testee.getCurrentAmountOfInstances(), initialAmountOfInstances + 1);
        assertTrue(testee.getInstancesArray().contains(newInstance));
    }

    @Test
    public void shouldNotAddNewInstanceWhenFull(){
        for(int i = 1; i <= 10; i++){
            testee.registerNewInstance("instance" + i);
        }
        assertThrows(IllegalArgumentException.class, () -> testee.registerNewInstance("someothertarget"));
    }

    @Test
    public void shouldGetRandomInstance(){
        for(int i = 1; i <= 5; i++){
            testee.registerNewInstance("instance" + i);
        }

        String instance1 = testee.getInstance();
        String instance2 = testee.getInstance();

        assertNotEquals(instance1, instance2);
    }

}