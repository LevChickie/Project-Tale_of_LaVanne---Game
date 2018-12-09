package sample;

import java.util.ArrayList;

public class InventoryManager {
    String inventory;

    InventoryManager(String inv) {
        inventory = inv;

    }

      public void addItem(String newElement) {
        inventory += newElement;
    }

    public String writeInventory() {
        return inventory;
    }

    public void removeItem(String Element)
    {
        String parts = "";
        int length;
        ArrayList<String> inventoryList = new ArrayList<>();
        for (length = 0; length < inventory.length(); length++) {
            if (inventory.charAt(length) == '\n') {
                inventoryList.add(parts);
                parts = "";
            } else {
                parts += inventory.charAt(length);
            }
        }

        if (inventoryList.contains(Element)) {
            inventoryList.remove(Element);
        }
        inventory = "";
        for (length = 0; length < inventoryList.size(); length++) {
            inventory += inventoryList.get(length);
            if (length != inventoryList.size() - 1) {
                inventory += "\n";
            }
        }
        return;
    }


}
