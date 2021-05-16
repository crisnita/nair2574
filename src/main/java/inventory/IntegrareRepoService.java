package inventory;

import inventory.model.InhousePart;
import inventory.model.Inventory;
import inventory.model.Part;
import inventory.model.Product;
import inventory.repository.InventoryRepository;
import inventory.service.InventoryService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

public class IntegrareRepoService {

    public InventoryRepository repo;
    public InventoryService service;

    InhousePart parte;
    String name;
    int indexPart;
    public Inventory inventory;
    ObservableList<Part> parti;
    ObservableList<Product> products;
    int partId;
    int min;
    int max;
    int stock;
    int price;
    int machineId;

    @BeforeEach
    void setup() {
        try {
            PrintWriter myObj = new PrintWriter("target/classes/data/items.txt");
            myObj.print("");
            myObj.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        name="parte1";
        partId=1;
        min=2;
        max=5;
        stock=4;
        price=20;
        machineId=2;
        indexPart=1;
        parte = Mockito.mock(InhousePart.class);
        parti = FXCollections.observableArrayList();
        products = FXCollections.observableArrayList();
        inventory = Mockito.mock(Inventory.class);
        repo = new InventoryRepository(inventory);
        service = new InventoryService(repo);
    }

    @Test
    void lookUpPart() {
        service.lookupPart(name);
        Mockito.verify(inventory, Mockito.times(1)).lookupPart(name);
    }
    @Test
    void deletePart() {
        Mockito.when(inventory.getAllParts()).thenReturn(parti);
        Mockito.when(inventory.getProducts()).thenReturn(products);
        service.deletePart(parte);
        Mockito.verify(inventory, Mockito.times(1)).deletePart(parte);
    }
    @Test
    void updateInhousePart(){
        Mockito.when(inventory.getAllParts()).thenReturn(parti);
        Mockito.when(inventory.getProducts()).thenReturn(products);
        Part testPart=service.updateInhousePart(indexPart,partId,name,min,max,stock,price,machineId);
        Mockito.verify(inventory, Mockito.times(1)).updatePart(indexPart,testPart);
    }
}
