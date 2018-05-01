package com.RUADota.Controller;

import com.RUADota.DAO.MatchDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SyncController {
    @Autowired
    private MatchDao matchDao;

    @RequestMapping("/sync/{userId}")
    public void syncUser(@PathVariable long userId) {
        matchDao.syncUser(userId);
    }
}
