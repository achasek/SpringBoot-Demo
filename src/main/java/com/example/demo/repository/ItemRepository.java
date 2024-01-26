package com.example.demo.repository;

import com.example.demo.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

// what is JpaRepository?
// It is what provides the build-out functionalities that you see in repository/ItemServiceImpl.java
// such as findAll(), findById(), deleteById(), save(), and so forth
// it is pre-built and offered CRUD functionality, as well as pagination and deleteInBatch and whatnot

// so this file doesn't seem to do much, but what is does is simply provides the aforementioned functions to our services and controllers packages
public interface ItemRepository extends JpaRepository<Item, Long> {

}
