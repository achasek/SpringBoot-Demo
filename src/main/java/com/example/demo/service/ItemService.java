package com.example.demo.service;

import com.example.demo.model.Item;
import java.util.List;

public interface ItemService {
    List<Item> getAllItems();

    Item getItemById(Long id);

    Item saveItem(Item item);

    void deleteItem(Long id);
}
