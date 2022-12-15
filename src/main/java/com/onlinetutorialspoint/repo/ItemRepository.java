package com.onlinetutorialspoint.repo;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.onlinetutorialspoint.model.Item;

@Repository
public class ItemRepository {

    @Autowired
    JdbcTemplate template;

    /*Getting a specific item by item id from table*/
    public Item getItem(int itemId){
        System.out.println("Reading Item From Repository..");
        String query = "SELECT * FROM ITEM WHERE ID=?";
        return template.queryForObject(query,new Object[]{itemId},new BeanPropertyRowMapper<>(Item.class));
    }
    
    /*Getting a specific item by item id and cat from table*/
    public List<Item> getItems(int itemId,String itemCat){
    	 String query = "SELECT * FROM ITEM where ID <? AND CATEGORY=?";

        System.out.println("Reading Item From Repository..");
   
       return template.query(query,new Object[]{itemId,itemCat},new int[] { Types.INTEGER ,Types.VARCHAR },new ItemRowWrapper());
    }

    /*delete an item from database*/
    public int deleteItem(int id){
    	 System.out.println("Reading Item From Repository..");
        String query = "DELETE FROM ITEM WHERE ID =?";
        int size = template.update(query,id);
        return size;
    }

    /*update an item from database*/
    public void updateItem(Item item){
    	 System.out.println("Reading Item From Repository..");
        String query = "UPDATE ITEM SET name=?, category=? WHERE id =?";
        template.update(query,
                new Object[] {
                        item.getName(),item.getCategory(), Integer.valueOf(item.getId())
                });
    }

}
