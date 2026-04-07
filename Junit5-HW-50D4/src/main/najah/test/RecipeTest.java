package main.najah.test;

import main.najah.code.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class RecipeTest {

    Recipe recipe;

    @BeforeEach
    void setup() {
        recipe = new Recipe();
    }

    @Test
    @DisplayName("Set valid values")
    void testValidSetters() throws Exception {
        recipe.setName("Mocha");
        recipe.setPrice("20");
        recipe.setAmtCoffee("2");
        recipe.setAmtMilk("1");
        recipe.setAmtSugar("1");
        recipe.setAmtChocolate("3");

        assertEquals("Mocha", recipe.getName());
        assertEquals(20, recipe.getPrice());
        assertEquals(2, recipe.getAmtCoffee());
    }

    @Test
    @DisplayName("Invalid price")
    void testInvalidPrice() {
        assertThrows(RecipeException.class,
                () -> recipe.setPrice("abc"));
    }

    @Test
    @DisplayName("Invalid coffee amount")
    void testInvalidCoffee() {
        assertThrows(RecipeException.class,
                () -> recipe.setAmtCoffee("-1"));
    }

    @Test
    @DisplayName("Invalid milk format")
    void testInvalidMilk() {
        assertThrows(RecipeException.class,
                () -> recipe.setAmtMilk("abc"));
    }

    @Test
    @DisplayName("Equals test")
    void testEquals() {
        Recipe r1 = new Recipe();
        r1.setName("Latte");

        Recipe r2 = new Recipe();
        r2.setName("Latte");

        assertEquals(r1, r2);
    }
    
    @Test
    @DisplayName("Set Sugar and Chocolate")
    void testSugarAndChocolate() throws Exception {
        recipe.setAmtSugar("2");
        recipe.setAmtChocolate("3");

        assertEquals(2, recipe.getAmtSugar());
        assertEquals(3, recipe.getAmtChocolate());
    }
    
    @Test
    @DisplayName("Negative Sugar")
    void testNegativeSugar() {
        assertThrows(RecipeException.class,
                () -> recipe.setAmtSugar("-1"));
    }

    @Test
    @DisplayName("Negative Chocolate")
    void testNegativeChocolate() {
        assertThrows(RecipeException.class,
                () -> recipe.setAmtChocolate("-2"));
    }
    
    
    @Test
    @DisplayName("Negative Price")
    void testNegativePrice() {
        assertThrows(RecipeException.class,
                () -> recipe.setPrice("-5"));
    }
    
    
    @Test
    @DisplayName("Equals different names")
    void testEqualsFalse() {
        Recipe r1 = new Recipe();
        r1.setName("A");

        Recipe r2 = new Recipe();
        r2.setName("B");

        assertNotEquals(r1, r2);
    }
    
    
    @Test
    @DisplayName("Equals with null")
    void testEqualsNull() {
        Recipe r1 = new Recipe();
        assertNotEquals(r1, null);
    }
    
    
    @Test
    @DisplayName("Set null name")
    void testNullName() {
        recipe.setName(null);
        assertEquals("", recipe.getName()); // لأنه ما بغير القيمة
    }

    @Test
    @DisplayName("toString test")
    void testToString() {
        recipe.setName("Cappuccino");
        assertEquals("Cappuccino", recipe.toString());
    }

    @Test
    @DisplayName("Equals same object")
    void testEqualsSameObject() {
        assertTrue(recipe.equals(recipe));
    }

    @Test
    @DisplayName("Equals different class")
    void testEqualsDifferentClass() {
        assertFalse(recipe.equals("string"));
    }

    @Test
    @DisplayName("HashCode test")
    void testHashCode() {
        Recipe r1 = new Recipe();
        r1.setName("Espresso");

        Recipe r2 = new Recipe();
        r2.setName("Espresso");

        assertEquals(r1.hashCode(), r2.hashCode());
    }
}