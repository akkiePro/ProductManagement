import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private List<Product> products = new ArrayList<>();
    public void addProduct(Product product) {
        products.add(product);
    }

    public void displayAllProducts() {
        // traditional way
        /*for (Product product : products) {
            System.out.println(product);
        }*/
        // using forEach and lambda
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

        // using stream and lambda
        products.stream().filter(item -> item.getName().toLowerCase().contains(txt) || item.getType().toLowerCase().contains(txt) || item.getPlace().toLowerCase().contains(txt)).forEach(System.out::println);
    }
}
