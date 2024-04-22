package Exercice3;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.mockito.Mockito.*;
public class ProductServiceTest {
    @Test
    public void testGetProductWithExsistingProduct() {
        //mock de ProductApiClient
        ProductApiClient mockApiClient = mock(ProductApiClient.class);

        // Création de ProductService par le mock ProductApiClient
        ProductService productService = new ProductService(mockApiClient);

        Product expectedProduct = new Product("1", "Produit 1", 10.0);

        when(mockApiClient.getProduct("1")).thenReturn(expectedProduct);

        Product actualProduct = productService.getProduct("1");

        // Vérifier que getProduct du mock a été appelé avec le bon argument
        verify(mockApiClient).getProduct("1");

        // Vérifier que le produit retourné correspond à celui attendu
        Assertions.assertEquals(expectedProduct, actualProduct);
    }
    @Test
    public void testGetProductWithApiCallFailure() {
        //mock de ProductApiClient
        ProductApiClient mockApiClient = mock(ProductApiClient.class);

        // Création de ProductService par le mock ProductApiClient
        ProductService productService = new ProductService(mockApiClient);

        when(mockApiClient.getProduct("3")).thenThrow(new IllegalArgumentException("Erreur lors de l'appel d'API"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> productService.getProduct("3"));

        // Vérifier que getProduct du mock a été appelé avec le bon argument
        verify(mockApiClient).getProduct("3");
    }
}