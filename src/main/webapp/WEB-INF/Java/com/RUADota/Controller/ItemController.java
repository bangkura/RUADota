package com.RUADota.Controller;

import com.RUADota.DAO.ItemDao;
import com.bangkura.Dota2ApiWrapper.Model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ItemController {
    @Autowired
    private ItemDao itemDao;

    @RequestMapping(value="/items", method= RequestMethod.GET)
    public @ResponseBody List<Item> getItem() {
        return itemDao.getAllItems();
    }
}
