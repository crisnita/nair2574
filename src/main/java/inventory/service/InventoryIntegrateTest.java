package inventory.service;

import inventory.model.InhousePart;
import inventory.model.Inventory;
import inventory.model.Part;
import inventory.model.Product;
import inventory.repository.InventoryRepository;
import inventory.service.InventoryService;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class InventoryIntegrateTest {


    private double price;
    private int inStock;
    private int min;
    private int max;
    Product product;
    private ObservableList<Part> associatedParts;
    private InventoryRepository inventoryRepository;
    private Inventory inventory;
    private InhousePart inhousePart;
    @BeforeEach
    void setUp() {
        inventory = new Inventory();
        price=2;
        inStock=4;
        min=2;
        max=3;
        product= Mockito.mock(Product.class);
    }

    @Test
    void addProduct() {
        int productId=1;
        String name="";
        inventory.addProduct(product);
        Product rezultat=inventory.lookupProduct(name);
        Assertions.assertEquals(null,rezultat);
    }
    @Test
    void getAutoPartId(){
        int id=inventory.getAutoPartId();
        Assertions.assertEquals(id,1);
        id=inventory.getAutoPartId();
        Assertions.assertEquals(id,2);
    }
}