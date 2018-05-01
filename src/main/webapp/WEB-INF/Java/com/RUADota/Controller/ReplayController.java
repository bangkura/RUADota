package com.RUADota.Controller;

import com.bangkura.Dota2ApiWrapper.Model.Replay;
import com.bangkura.Dota2ApiWrapper.Util.ReplayProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Controller
public class ReplayController {
    @RequestMapping (value="/replay", method = RequestMethod.GET)
    public @ResponseBody
    Replay getReplay() {
        File file = new File("/Users/Bangkura/Documents/SpringMVCtest/replay.dem");
        FileInputStream fs = null;
        try {
            fs = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ReplayProcessor processor = new ReplayProcessor();
        Replay replay = processor.excute(fs);
        return replay;
    }
}
