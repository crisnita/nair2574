package inventory.repository;

import inventory.model.InhousePart;
import inventory.model.Inventory;
import inventory.model.Part;
import inventory.model.Product;
import inventory.service.InventoryService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

class InventoryRepositoryTest {

    public InventoryRepository repo;

    InhousePart parte;
    String name;
    int indexPart;
    public Inventory service;
    ObservableList<Part> parti;
    ObservableList<Product> products;
    @BeforeEach
    void setup(){
        try {
            PrintWriter myObj=new PrintWriter("target/classes/data/items.txt");
            myObj.print("");
            myObj.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        indexPart=1;
        parte=mock(InhousePart.class);
        parti=FXCollections.observableArrayList();
        products=FXCollections.observableArrayList();
        service=mock(Inventory.class);
        repo=new InventoryRepository(service);
    }

    @Test
    void addPart() {
        Mockito.when(service.getAllParts()).thenReturn(parti);
        Mockito.when(service.getProducts()).thenReturn(products);
        repo.addPart(parte);
        Mockito.verify(service, times(1)).addPart(parte);
    }

    @Test
    void lookupPart() {
        repo.lookupPart(name);
        Mockito.verify(service, times(1)).lookupPart(name);
    }

    @Test
    void updatePart() {
        Mockito.when(service.getAllParts()).thenReturn(parti);
        Mockito.when(service.getProducts()).thenReturn(products);
        repo.updatePart(indexPart,parte);
        Mockito.verify(service, times(1)).updatePart(indexPart,parte);
    }
}