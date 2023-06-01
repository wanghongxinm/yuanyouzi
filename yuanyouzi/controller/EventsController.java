package yuanyouzi.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yuanyouzi.entity.Events;
import yuanyouzi.service.EventsService;
import yuanyouzi.util.Result;


@RestController
@RequestMapping("//events")
public class EventsController {

    final EventsService eventsService;

    public EventsController(EventsService eventsService) {
        this.eventsService = eventsService;

    }

    Gson gson = new GsonBuilder().serializeNulls().create();
    Result result = new Result();
    Result result1 = new Result();
    Result result2 = new Result();

    @PostMapping("/event")
    public Result event(String json) {

        String event = json.substring(1, json.length() - 1);
        String[] events1 = event.split("_");

        int id1 = Integer.parseInt(events1[0]);
        int id2 = Integer.parseInt(events1[1]);
        int id3 = Integer.parseInt(events1[2]);
        Events event1 = new Events();
        Events event2 = new Events();
        Events event3 = new Events();
        Events event4;
        Events event5;
        Events event6;
        event1.setId(id1);
        event2.setId(id2);
        event3.setId(id3);

        event4=eventsService.getById(event1.getId());
        event5=eventsService.getById(event2.getId());
        event6=eventsService.getById(event3.getId());
        if(event4!=null){
           result.setSuccess("e0",gson.toJson(event4));
            if(event5!=null){
                result1.setSuccess2("e1",gson.toJson(event4),gson.toJson(event5));
                 result=result1;
                if(event6!=null){
                    result2.setSuccess1("e2",gson.toJson(event6),gson.toJson(event4),gson.toJson(event5));
                    result=result2;
                }
            }
        }
        return result;
    }

/*
* 管理端方法未完成！
* Wang
* 2023/4/13
* */
}