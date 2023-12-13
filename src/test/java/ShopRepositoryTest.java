import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    ShopRepository products = new ShopRepository();
    Product product1 = new Product(234, "Мыло", 101);
    Product product2 = new Product(513, "Хлеб", 68);
    Product product3 = new Product(563, "Компьютер", 75_087);
    Product product4 = new Product(513, "Ключ", 150);

    @Test
    public void shouldAddProductAndFindAll() {
        products.add(product1);
        products.add(product2);
        products.add(product3);

        Product[] expected = {product1, product2, product3};
        Product[] actual = products.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.findById(563);

        Product expected = product3;
        Product actual = products.findById(563);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.remove(513);

        Product[] expected = {product1, product3};
        Product[] actual = products.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testNotFoundException() {
        products.add(product1);
        products.add(product2);
        products.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            products.remove(100);
        });
    }

    @Test
    public void testAlreadyExistsException() {
        products.add(product1);
        products.add(product2);
        products.add(product3);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            products.add(product4);
        });
    }
}
