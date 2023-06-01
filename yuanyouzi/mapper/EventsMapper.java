package yuanyouzi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Select;
import yuanyouzi.entity.Events;

@Mapper
public interface EventsMapper extends BaseMapper<Events> {
  /*  @Select("select * from events")
    void select(int id, String title, String content, DateTimeLiteralExpression.DateTime time);*/
}
