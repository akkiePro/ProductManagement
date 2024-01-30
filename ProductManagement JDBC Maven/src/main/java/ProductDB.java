import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDB {

    private Connection conn = null;

    public ProductDB() {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/akki", "postgres", "root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(Product product) {
        String query = "INSERT INTO public.\"product\" (name, type, place, warranty) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement st = conn.prepareStatement(query);

            st.setString(1, product.getName());
            st.setString(2, product.getType());
            st.setString(3, product.getPlace());
            st.setInt(4, product.getWarranty());

            st.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        String query = "SELECT name, type, place, warranty FROM public.\"product\"";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setName(rs.getString(1));
                p.setType(rs.getString(2));
                p.setPlace(rs.getString(3));
                p.setWarranty(rs.getInt(4));

                products.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public List<Product> findByTxt(String txt) {
        List<Product> products = new ArrayList<>();
        String query = "SELECT name, type, place, warranty FROM public.\"product\" WHERE name ILIKE '%" + txt + "%' OR type ILIKE '%" + txt + "%' OR place ILIKE '%" + txt + "%'";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setName(rs.getString(1));
                p.setType(rs.getString(2));
                p.setPlace(rs.getString(3));
                p.setWarranty(rs.getInt(4));

                products.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
}
