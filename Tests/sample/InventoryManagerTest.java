package sample;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventoryManagerTest {


    @Test
    public void addItem() {
        InventoryManager inventory = new InventoryManager("");
        String trial = "Trial";
        assertNotEquals(trial,inventory.toString());
        inventory.addItem(trial);
        assertEquals(trial,inventory.writeInventory());

    }

    @Test
    public void writeInventory() {
        InventoryManager inventory = new InventoryManager("List\nElement\n");
        String trial = "List\nElement\n";
        assertEquals(trial, inventory.writeInventory());
    }

    @Test
    public void removeItem() {
        InventoryManager inventory= new InventoryManager("List");
        inventory.removeItem("List");
        assertEquals("",inventory.writeInventory());
    }
}