package inventory.service;

import inventory.model.InhousePart;
import inventory.model.Part;
import inventory.repository.InventoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

class InventoryServiceTest {

    public InventoryRepository repo;

    InhousePart parte;
    String name;
    int partId;
    int min;
    int max;
    int stock;
    int price;
    int machineId;
    int indexPart;
    public InventoryService service;
    @BeforeEach
    void setup(){
        name="parte1";
        partId=1;
        min=2;
        max=5;
        stock=4;
        price=20;
        machineId=2;
        indexPart=1;
        parte= Mockito.mock(InhousePart.class);
        repo= Mockito.mock(InventoryRepository.class);
        service=new InventoryService(repo);
    }

    @Test
    void lookupPart() {
        Mockito.when(repo.lookupPart(name)).thenReturn(parte);
        Part testPart=service.lookupPart(name);
        Assertions.assertEquals(testPart,parte);
    }

    @Test
    void deletePart() {
        service.deletePart(parte);
        Mockito.verify(repo, Mockito.times(1)).deletePart(parte);

    }
    @Test
    void updateInhousePart(){
        Part testPart=service.updateInhousePart(indexPart,partId,name,min,max,stock,price,machineId);
        Mockito.verify(repo, Mockito.times(1)).updatePart(indexPart,testPart);
    }
}