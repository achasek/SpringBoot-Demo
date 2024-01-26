package com.example.demo.service;

import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepository;
// denotes dependency injection
import org.springframework.beans.factory.annotation.Autowired;
// denotes business logic that can be called upon elsewhere in the application
import org.springframework.stereotype.Service;

import java.util.List;
// remember, classes within the same package need not be imported - ItemService
@Service
@SuppressWarnings("unused")
// based off of the blueprint/rulebook set by ItemService interface, we build out the expected and required functions
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    // claims we are overriding existing method in interface, which we are
    @Override
    public List<Item> getAllItems() {
        // methods like findAll come from ItemRepository
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
