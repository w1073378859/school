package cn.test.service;

import cn.test.pojo.Room;

/**
* @Package: impl
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
public interface RoomService{


int deleteByPrimaryKey(Long id);

int insert(Room record);

int insertSelective(Room record);

Room selectByPrimaryKey(Long id);

int updateByPrimaryKeySelective(Room record);

int updateByPrimaryKey(Room record);

}
