package com.example.demo.service;

import com.example.demo.model.Item;
import java.util.List;

// this file is simply an interface. No actual functions live here,
// but instead, act as instructions for our ItemServiceImpl class,
// which MUST contain the below methods in that class or else it will fail at compile,
// this just makes code more sound and less error-prone
public interface ItemService {
    List<Item> getAllItems();

    Item getItemById(Long id);

    Item saveItem(Item item);

    void deleteItem(Long id);
}
