package yuanyouzi.controller;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.*;
import yuanyouzi.util.Limit;
import yuanyouzi.util.Result;
import yuanyouzi.entity.User;
import yuanyouzi.service.UserService;

import java.util.Arrays;

@RestController
@RequestMapping("//user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    Gson gson= new GsonBuilder().serializeNulls().create();
    Result result=new Result();

    /*
    * 自定义注解Limit 对insert进行限流
    * Wang
    * 2023/4/21
    * */
    @PostMapping("/insert")
    @Limit(key="insert",permitsPerSecond = 2,timeout = 500,msg="当前访问人数太多，请稍后重试！")
    public Result insert(String json) {

        System.out.print(json);
        String user = json.substring(1, json.length() - 1);
        String[] user1 = user.split("_");

        System.out.print(Arrays.toString(user1));

        String password=user1[0];
        int p1= Integer.parseInt(user1[1]);
        int p2= Integer.parseInt(user1[2]);
        int state= Integer.parseInt(user1[3]);
        int state1= Integer.parseInt(user1[4]);
        int state2= Integer.parseInt(user1[5]);
        int state3= Integer.parseInt(user1[6]);
        int state4= Integer.parseInt(user1[7]);

        User user3;
        do {
            int min = 3;
            long max = 100003;
            long id = min + (int) (Math.random() * ((max - min) + 1));
            User user2 = new User();
            user2.setId(id);
            user3 = userService.getById(user2.getId());
        }

        while (user3 == null);
        user3.setPassword(password);
        user3.setP1(p1);
        user3.setP2(p2);
        user3.setState(state);
        user3.setState1(state1);
        user3.setState2(state2);
        user3.setState3(state3);
        user3.setState4(state4);
        userService.updateById(user3);
        System.out.print(user3);
        result.setSuccess("i0",gson.toJson(user3.getId()));

        return result;
    }

    @PostMapping("/login")
    public Result login(String json) {
        String user = json.substring(1,json.length() - 1);
        String[] user1 =user.split("_");
        long id= Long.parseLong(user1[0]);
        String password=user1[1];
        User user2=new User();
        User user3;
        user2.setId(id);
        user3=userService.getById(user2.getId());

        if(user3==null) {
            result.setSuccess("s3",gson.toJson(id));
        }
        else if (password.equals(user3.getPassword())) {
            if(user3.getState()==0) {
                result.setSuccess("s0", gson.toJson(id));
                user3.setState(1);
                userService.updateById(user3);
            } else{
                    result.setSuccess("s4", gson.toJson(id));
                }
        }else{
            result.setSuccess("s1",gson.toJson(id));

        }
        return result;
    }

    @PostMapping("/quit")
    public Result quit(String json) {
        String user = json.substring(1,json.length() - 1);
        String[] user1 =user.split("_");
        long id= Long.parseLong(user1[0]);
        int state= Integer.parseInt(user1[1]);
        User user2=new User();
        User user3;
        user2.setId(id);
        user3=userService.getById(user2.getId());
        user3.setState(state);
        userService.updateById(user3);
        result.setSuccess("q1",gson.toJson(id));
        return result;
    }

    @PostMapping("/modification")
    public Result modification(String json) {
        String user = json.substring(1,json.length() - 1);
        String[] user1 =user.split("_");
        long id= Long.parseLong(user1[0]);
        String password=user1[1];
        int p1= Integer.parseInt(user1[2]);
        int p2= Integer.parseInt(user1[3]);
        User user2=new User();
        User user3;
        user2.setId(id);
        user3=userService.getById(user2.getId());
        if(p1==user3.getP1()&&p2==user3.getP2()) {
            user3.setPassword(password);
            userService.updateById(user3);
            result.setSuccess("m0", gson.toJson(id));
        }else{
            result.setSuccess("m1", gson.toJson(id));
        }
        return result;
    }

    @PostMapping("/state1")
    public Result state1(String json) {
        String user = json.substring(1,json.length() - 1);
        String[] user1 =user.split("_");
        long id= Long.parseLong(user1[0]);
        int state= Integer.parseInt(user1[1]);

        User user2=new User();
        User user3;
        user2.setId(id);
        user3=userService.getById(user2.getId());
        user3.setState1(state);
        user3.setState2(state);
        user3.setState3(state);
        user3.setState4(state);
        userService.updateById(user3);
        result.setSuccess("s10", gson.toJson(id));
        return result;
    }

    @PostMapping("/state2")
    public Result state2(String json) {
        String user = json.substring(1,json.length() - 1);
        String[] user1 =user.split("_");
        long id= Long.parseLong(user1[0]);
        int state= Integer.parseInt(user1[1]);
        User user2=new User();
        User user3;
        user2.setId(id);
        user3=userService.getById(user2.getId());
        user3.setState2(state);
        userService.updateById(user3);
        result.setSuccess("s20", gson.toJson(id));
        return result;
    }

    @PostMapping("/state3")
    public Result state3(String json) {
        String user = json.substring(1,json.length() - 1);
        String[] user1 =user.split("_");
        long id= Long.parseLong(user1[0]);
        int state= Integer.parseInt(user1[1]);
        User user2=new User();
        User user3;
        user2.setId(id);
        user3=userService.getById(user2.getId());
        user3.setState3(state);
        userService.updateById(user3);
        result.setSuccess("s30", gson.toJson(id));
        return result;
    }

    @PostMapping("/state4")
    public Result state4(String json) {
        String user = json.substring(1,json.length() - 1);
        String[] user1 =user.split("_");
        long id= Long.parseLong(user1[0]);
        int state= Integer.parseInt(user1[1]);

        User user2=new User();
        User user3;
        user2.setId(id);
        user3=userService.getById(user2.getId());
        user3.setState4(state);
        userService.updateById(user3);
        result.setSuccess("s40", gson.toJson(id));
        return result;
    }


    /*
    * 管理端方法未完成！
    * 2023/4/6
    * Wang
    * */
}