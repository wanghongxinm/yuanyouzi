package yuanyouzi.controller;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yuanyouzi.util.Limit;
import yuanyouzi.util.Result;
import yuanyouzi.entity.Issue;
import yuanyouzi.service.IssueService;

@RestController
@RequestMapping("//issue")
public class IssueController {

    private final IssueService issueService;

    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    Gson gson= new GsonBuilder().serializeNulls().create();
    Result result=new Result();

    /*
    * 反馈方法未完成！
    * 未进行数据对比
    * */

    @PostMapping("/freeBack")
    @Limit(key="freeBack",permitsPerSecond = 1,timeout = 500,msg="我们以及收到您的反馈正在积极修改，请耐心等待！")
    public Result freeBack(String json) {
        String issue = json.substring(1,json.length() - 1);
        String[] issue1 =issue.split("_");

        long uid= Long.parseLong(issue1[0]);
        String name=issue1[1];
        String description=issue1[2];


        Issue issue2=new Issue();
        issue2.setUid(uid);
        Issue issue3;

        /*
        *加不上对比，原因是对issue3不能进行赋值
        issue3=issueService.getById(issue2.getUid());
        System.out.print(issue3);*/
       // if(issue3.getName().equals(issue2.getName())) {
            issue2.setName(name);
            issue2.setDescription(description);
            issue2.setState(0);

       // }
        issueService.updateById(issue2);
        issueService.save(issue2);
        result.setSuccess("i0",gson.toJson(uid));
        return result;

        // System.out.print(issue2);
        /* String[] d={description};
           issue2.setDescription(description+","+Arrays.toString(d));*/
    }

    /*
    * 管理端方法未完成!
    * 2023/4/9
    * Wang
    * */

}