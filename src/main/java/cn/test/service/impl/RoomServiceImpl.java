package cn.test.service.impl;

import cn.test.mapper.RoomMapper;
import cn.test.pojo.Room;
import cn.test.service.RoomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @Package: service
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
@Service
public class RoomServiceImpl implements RoomService{

    @Resource
    private RoomMapper roomMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return roomMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Room record) {
        return roomMapper.insert(record);
    }

    @Override
    public int insertSelective(Room record) {
        return roomMapper.insertSelective(record);
    }

    @Override
    public Room selectByPrimaryKey(Long id) {
        return roomMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Room record) {
        return roomMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Room record) {
        return roomMapper.updateByPrimaryKey(record);
    }

}
