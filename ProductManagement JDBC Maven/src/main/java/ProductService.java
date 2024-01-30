import java.util.List;

public class ProductService {

    private ProductDB db = new ProductDB();

    public void addProduct(Product product) {
        db.save(product);
    }

    public void displayAllProducts() {
        List<Product> products = db.findAll();
        products.forEach(System.out::println);
    }

    public void findByTxt(String text) {
        String txt = text.toLowerCase();

        List<Product> matchedProducts = db.findByTxt(txt);
        matchedProducts.forEach(System.out::println);
    }

}
