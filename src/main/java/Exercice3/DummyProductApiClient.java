package Exercice3;

public class DummyProductApiClient implements ProductApiClient {
    @Override
    public Product getProduct(String productId) {
        if (productId.equals("1")) {
            return new Product("1", "Produit 1", 10.0);
        } else if (productId.equals("2")) {
            return new Product("2", "Produit 2", 20.0);
        } else {
            throw new IllegalArgumentException("Produit not found with ID : " + productId);
        }
    }
}
