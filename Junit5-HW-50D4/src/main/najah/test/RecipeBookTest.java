package main.najah.test;

import main.najah.code.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class RecipeBookTest {

    RecipeBook book;
    Recipe recipe;

    @BeforeEach
    void setup() throws Exception {
        book = new RecipeBook();
        recipe = new Recipe();
        recipe.setName("Coffee");
        recipe.setPrice("10");
    }

    @Test
    @DisplayName("Add Recipe")
    void testAddRecipe() {
        assertTrue(book.addRecipe(recipe));
        assertEquals("Coffee", book.getRecipes()[0].getName());
    }

    @Test
    @DisplayName("Delete Recipe")
    void testDeleteRecipe() {
        book.addRecipe(recipe);
        String name = book.deleteRecipe(0);
        assertEquals("Coffee", name);
    }

    @Test
    @DisplayName("Edit Recipe")
    void testEditRecipe() throws Exception {
        book.addRecipe(recipe);

        Recipe newRecipe = new Recipe();
        newRecipe.setName("Latte");
        newRecipe.setPrice("15");

        String oldName = book.editRecipe(0, newRecipe);

        assertEquals("Coffee", oldName);
    }
}