package com.onlinetutorialspoint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinetutorialspoint.cache.ItemCache;
import com.onlinetutorialspoint.model.Item;

@RestController
public class ItemController {

    @Autowired
    ItemCache itemCache;
    @GetMapping("/item/{itemId}")
    @ResponseBody
    public ResponseEntity<Item> getItem(@PathVariable int itemId) throws Exception{
        System.out.println("RestController..");
        Item item = itemCache.getItem(itemId);
        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }
    
    @GetMapping("/item/{itemId}/{itemCat}")
    @ResponseBody
    public ResponseEntity<List<Item>> getItems(@PathVariable int itemId,@PathVariable String itemCat) throws Exception{
        List<Item> item = itemCache.getItems(itemId,itemCat);
        return new ResponseEntity<List<Item>>(item, HttpStatus.OK);
    }

    @PutMapping("/updateItem")
    @ResponseBody
    public ResponseEntity<Item> updateItem(@RequestBody Item item){
        if(item != null){
            itemCache.updateItem(item);
        }
        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteItem(@PathVariable int id){
        itemCache.deleteItem(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

}
