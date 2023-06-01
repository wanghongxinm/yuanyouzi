package yuanyouzi.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import yuanyouzi.entity.Issue;
import yuanyouzi.mapper.IssueMapper;
import yuanyouzi.service.IssueService;

@Service
public class IssueServiceImpl extends ServiceImpl<IssueMapper, Issue> implements IssueService {
}
