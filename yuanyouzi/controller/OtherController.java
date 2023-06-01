package yuanyouzi.controller;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yuanyouzi.entity.Other;
import yuanyouzi.service.OtherService;
import yuanyouzi.util.Result;

import java.util.Arrays;

@RestController
@RequestMapping("//other")
public class OtherController {

    private final OtherService otherService;

    public OtherController(OtherService otherService) {
        this.otherService = otherService;
    }

    Gson gson= new GsonBuilder().serializeNulls().create();
    Result result=new Result();

    @PostMapping("others")
    public Result others(String json) {
        String other = json.substring(1, json.length() - 1);
        String[] other1 = other.split("_");

        Other  other2=new Other();
        Other  other3=new Other();

        Other other4;
        Other other5;

        other2.setId(Integer.parseInt(other1[0]));
        other3.setId(Integer.parseInt(other1[1]));

        other4 =otherService.getById(other2.getId());
        other5 =otherService.getById(other3.getId());

        result.setSuccess2("o0",gson.toJson(other4),gson.toJson(other5));
        return  result;
    }


}