import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {
    Product product = new Product(123, "Хлеб", 45);

    @Test
    public void testGetId() {
        int expected = 123;
        int actual = product.getId();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetTitle() {
        String expected = "Хлеб";
        String actual = product.getTitle();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetPrice() {
        int expected = 45;
        int actual = product.getPrice();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetTitle() {
        product.setTitle("Молоко");

        String expected = "Молоко";
        String actual = product.getTitle();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetPrice() {
        product.setPrice(56);

        int expected = 56;
        int actual = product.getPrice();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testHashCode() {
        System.out.println(product.hashCode());
        int expected = 1013335733;
        int actual = product.hashCode();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldEqualsIfSameObject() {
        boolean expected = true;
        boolean actual = product.equals(product);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotEqualsIfNull() {
        boolean expected = false;
        boolean actual = product.equals(null);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotEqualsId() {
        Product newProduct = new Product(142, "Хлеб", 45);
        boolean expected = false;
        boolean actual = product.equals(newProduct);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotEqualsTitle() {
        Product newProduct = new Product(123, "Молоко", 45);
        boolean expected = false;
        boolean actual = product.equals(newProduct);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotEqualsPrice() {
        Product newProduct = new Product(123, "Хлеб", 76);
        boolean expected = false;
        boolean actual = product.equals(newProduct);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldEqualIdTitlePrice() {
        Product newProduct = new Product(123, "Хлеб", 45);
        boolean expected = true;
        boolean actual = product.equals(newProduct);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotEqualsWithOtherClass() {
        class NewClass {
            public int id = 123;
            public String title = "Хлеб";
            public int price = 45;
        }

        NewClass newClass = new NewClass();

        boolean expected = false;
        boolean actual = product.equals(newClass);

        Assertions.assertEquals(expected, actual);
    }
}
