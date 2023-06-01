package yuanyouzi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

import yuanyouzi.entity.Events;
import yuanyouzi.mapper.EventsMapper;
import yuanyouzi.service.EventsService;

import java.util.List;

@Service
public class EventsServiceImpl extends ServiceImpl<EventsMapper, Events> implements EventsService {

   /* private final EventsMapper eventsMapper;

    public EventsServiceImpl(EventsMapper eventsMapper) {
        this.eventsMapper = eventsMapper;
    }

    @Override
    public List<Events> select(Events events) {
        eventsMapper.select(events.getId(),events.getTitle(),events.getContent(),events.getTime());
        return null;
    }*/



}