import java.util.ArrayList;
import java.util.List;

public class ProductService {
//    private List<Product> products = new ArrayList<>();
    private ProductDB db = new ProductDB();
    public void addProduct(Product product) {
//        products.add(product);
        db.save(product);
    }

    public void displayAllProducts() {
        List<Product> products = db.findAll();
        products.forEach(System.out::println);
    }

    public void findByTxt(String text) {
        String txt = text.toLowerCase();

        // traditional way
        /*for (Product p : products) {
            String name = p.getName().toLowerCase();
            String type = p.getType().toLowerCase();
            String place = p.getPlace().toLowerCase();
            if (name.contains(txt) || type.contains(txt) || place.contains(txt)) {
                System.out.println(p);
            }
        }*/

        List<Product> matchedProducts = db.findByTxt(txt);
        matchedProducts.forEach(System.out::println);
        // using stream and lambda
//        products.stream().filter(item -> item.getName().toLowerCase().contains(txt) || item.getType().toLowerCase().contains(txt) || item.getPlace().toLowerCase().contains(txt)).forEach(System.out::println);
    }
}
