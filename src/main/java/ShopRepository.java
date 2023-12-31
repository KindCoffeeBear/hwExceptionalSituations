public class ShopRepository {
    private Product[] products = new Product[0];

    /**
     * Вспомогательный метод для имитации добавления элемента в массив
     * @param current — массив, в который мы хотим добавить элемент
     * @param product — элемент, который мы хотим добавить
     * @return — возвращает новый массив, который выглядит, как тот, что мы передали,
     * но с добавлением нового элемента в конец
     */
    private Product[] addToArray(Product[] current, Product product) {
        Product[] tmp = new Product[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = product;
        return tmp;
    }

    /**
     * Метод добавления товара в репозиторий
     * @param product — добавляемый товар
     */
    public void add(Product product) {
        if (findById(product.getId()) == null) {
            System.out.println(product.getId());
            products = addToArray(products, product);
        } else {throw new AlreadyExistsException(
                "Товар с ID " + product.getId() + " уже существует"
        );}
    }

    public Product[] findAll() {
        return products;
    }

    // Этот способ мы рассматривали в теории в теме про композицию
    public void remove(int id) {
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        if (findById(id) == null) {
            throw new NotFoundException(
                    "Товар с ID " + id + " не найден"
            );
        };
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }

    // Поиск товара в репозитории по его id
    public Product findById(int ID) {
        for (Product product : products) {
            if (product.getId() == ID) {
                return product;
            }
        }
        return null;
    }
}
