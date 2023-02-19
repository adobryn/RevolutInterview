import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SomeClassTest {

    private SomeClass testee;

    @BeforeEach
    void setUp() {
        testee = new SomeClass();
    }

    @Test
    void SomeMethodTest(){
        assertEquals(testee.SomeMethod(), 0);
    }
}