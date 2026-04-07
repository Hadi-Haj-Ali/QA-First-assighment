package main.najah.test;

import main.najah.code.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest {

    static Calculator calc;

    @BeforeAll
    static void setupAll() {
        calc = new Calculator();
        System.out.println("Setup All");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("After All");
    }

    @BeforeEach
    void setup() {
        System.out.println("Before Each");
    }

    @AfterEach
    void tearDown() {
        System.out.println("After Each");
    }

    @Test
    @Order(1)
    @DisplayName("Test Add Numbers")
    void testAdd() {
        assertEquals(6, calc.add(1,2,3));
        assertEquals(0, calc.add());
    }

    @Test
    @Order(2)
    @DisplayName("Test Divide Valid")
    void testDivideValid() {
        assertEquals(2, calc.divide(4,2));
    }

    @Test
    @Order(3)
    @DisplayName("Test Divide By Zero")
    void testDivideInvalid() {
        assertThrows(ArithmeticException.class,
                () -> calc.divide(5,0));
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4})
    @DisplayName("Factorial Parameterized Test")
    void testFactorial(int n) {
        assertTrue(calc.factorial(n) > 0);
    }

    @Test
    @DisplayName("Timeout Test")
    void testTimeout() {
        assertTimeout(java.time.Duration.ofMillis(100),
                () -> calc.factorial(10));
    }
    
    @Test
    @DisplayName("Factorial zero")
    void testFactorialZero() {
        assertEquals(1, calc.factorial(0));
    }

    @Test
    @DisplayName("Factorial negative")
    void testFactorialNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> calc.factorial(-1));
    }
    
    @Test
    @DisplayName("Add negative numbers")
    void testAddNegative() {
        assertEquals(-6, calc.add(-1, -2, -3));
    }

    @Test
    @DisplayName("Add mixed numbers")
    void testAddMixed() {
        assertEquals(0, calc.add(-1, 1));
    }

    @Test
    @DisplayName("Factorial of 1")
    void testFactorialOne() {
        assertEquals(1, calc.factorial(1));
    }
    
    @Test
    @DisplayName("Add single number")
    void testAddSingle() {
        assertEquals(5, calc.add(5));
    }

    @Test
    @DisplayName("Add large numbers")
    void testAddLarge() {
        assertEquals(3000, calc.add(1000, 2000));
    }

    @Test
    @DisplayName("Divide negative numbers")
    void testDivideNegative() {
        assertEquals(-2, calc.divide(-4, 2));
    }

    @Test
    @DisplayName("Divide result zero")
    void testDivideZeroResult() {
        assertEquals(0, calc.divide(0, 5));
    }

    @Test
    @Disabled("Intentional failure - fix expected value")
    void failingTest() {
        assertEquals(5, calc.add(2,2)); // wrong intentionally
    }
}