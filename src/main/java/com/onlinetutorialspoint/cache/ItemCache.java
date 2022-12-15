package com.onlinetutorialspoint.cache;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.onlinetutorialspoint.model.Item;
import com.onlinetutorialspoint.repo.ItemRepository;

@Component
public class ItemCache {

    @Autowired
    ItemRepository itemRepo;

    @Cacheable(value="itemCache", key="#id")
    public Item getItem(int id) throws Exception{
        System.out.println("In ItemCache Component..");
        return itemRepo.getItem(id);
    }

    @Cacheable(value="itemCache", key="{#id,#cat}")
    public List<Item> getItems(int id,String cat) throws Exception{
        System.out.println("In ItemCache Component..");
        return itemRepo.getItems(id,cat);
    }
    

    @CacheEvict(value="itemCache",key = "#id")
    public int deleteItem(int id){
        System.out.println("In ItemCache Component..");
        return itemRepo.deleteItem(id);
    }

    @CachePut(value="itemCache")
    public void updateItem(Item item){
        System.out.println("In ItemCache Component..");
        itemRepo.updateItem(item);
    }
}
