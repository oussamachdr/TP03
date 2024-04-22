package Exercice3;

public class ProductService {
    private final ProductApiClient apiClient;
    public ProductService(ProductApiClient apiClient) {
        this.apiClient = apiClient;
    }
    public Product getProduct(String productId) {
        return apiClient.getProduct(productId);
    }
}
