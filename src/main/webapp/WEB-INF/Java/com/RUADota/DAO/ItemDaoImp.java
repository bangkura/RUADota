package com.RUADota.DAO;

import com.bangkura.Dota2ApiWrapper.Api.GetGameItems;
import com.bangkura.Dota2ApiWrapper.Model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemDaoImp implements ItemDao{
    @Autowired
    private MongoOperations mongo;

    @Override
    public List<Item> getAllItems() {
        List<Item> items = null;
        items = mongo.findAll(Item.class);
        if(items.size() > 0)
            return items;
        else {
            synItems();
            return getAllItems();
        }
    }

    private void synItems() {
        GetGameItems api = new GetGameItems();
        List<Item> items = api.excute();
        for(Item item: items) {
            mongo.save(item);
        }
    }
}
