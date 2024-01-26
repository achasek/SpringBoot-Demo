package com.example.demo.controller;

import com.example.demo.model.Item;
import com.example.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.lang.Exception;

@RestController
@RequestMapping("/items")
@SuppressWarnings("unused")
// methods below aren't exported like in JavaScript, so they get flagged as never being used even tho they are used upon being called by the running server
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable Long id) throws RuntimeException{
        Item item = itemService.getItemById(id);

        if(item != null) {
            return item;
        }

        throw new RuntimeException("Item not found");
    }

    @PostMapping
    public Item saveItem(@RequestBody Item item) {
        return itemService.saveItem(item);
    }

    @PutMapping("/{id}")
    // throws declares what CAN BE potentially thrown by this function
    public Item editItem(@PathVariable Long id, @RequestBody Item item) throws Exception {
        Item itemToUpdate = itemService.getItemById(id);

        if(itemToUpdate != null) {
            // find the existing item
            // use the setter function made by lombok (ex. setName)
            // params for setter function will be the incoming item/request body
            // to access that, use the @RequestBody annotation
            // and the getter function also made by lombok (ex. getName)
            itemToUpdate.setName(item.getName());
            itemToUpdate.setPrice(item.getPrice());
            itemToUpdate.setDescription(item.getDescription());
            itemToUpdate.setCategory(item.getCategory());
            itemToUpdate.setImage(item.getImage());

            // save updated item
            return itemService.saveItem(itemToUpdate);
        }

        // where throw EXPLICITLY will throw something, being an exception here
        throw new Exception("Item not found.");
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }
}
