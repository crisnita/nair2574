package inventory.model;

import inventory.repository.InventoryRepository;
import inventory.service.InventoryService;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {


    private double price;
    private int inStock;
    private int min;
    private int max;
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
    }

    @Test
    void F02_TC01() {
        int productId=1;
        String name="";
        Product test=new Product(productId,"", price,inStock,min,max,associatedParts);
        inventory.addProduct(test);

        Product rezultat=inventory.lookupProduct(name);
        assertEquals(null,rezultat);
    }
    @Test
    void F02_TC02() {
        int productId=1;
        String name="furat";
        Product test=new Product(productId,"furat", price,inStock,min,max,associatedParts);
        inventory.addProduct(test);

        Product rezultat=inventory.lookupProduct(name);
        assertEquals(null,rezultat);
    }
    @Test
    void F02_TC03() {
        int productId=1;
        String name="alb";
        Product rezultat=inventory.lookupProduct(name);
        assertEquals(null,rezultat);
    }
    @Test
    void F02_TC04() {
        int productId=1;
        String name="Product1";
        Product test=new Product(productId,"furat", price,inStock,min,max,associatedParts);
        inventory.addProduct(test);
        Product test2=new Product(productId,"Product1", price,inStock,min,max,associatedParts);
        inventory.addProduct(test2);
        Product rezultat=inventory.lookupProduct(name);
        assertEquals(test2,rezultat);
    }
}