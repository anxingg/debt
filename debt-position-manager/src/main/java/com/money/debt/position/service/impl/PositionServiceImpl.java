package com.money.debt.position.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.money.debt.bean.SysDictionary;
import com.money.debt.bean.SysPosition;
import com.money.debt.position.mapper.DictionaryMapper;
import com.money.debt.position.mapper.PositionMapper;
import com.money.debt.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    PositionMapper positionMapper;

    @Autowired
    DictionaryMapper dictionaryMapper;

    public List<SysPosition> listAllDIY() {
        List<SysPosition>  all=positionMapper.selectAllDIY();
        return all;
    }


    public List<SysDictionary> getAvailableTypes() {
        return dictionaryMapper.selectAll();
    }

    public List<SysPosition> getAvailableParents() {

        return  positionMapper.selectAvailableParents();

    }

    public String getLastOneId() {
        return positionMapper.selectLastOneId();
    }

    public void addOnePosition(SysPosition position) {
        positionMapper.insertSelective(position);
    }

    public void updateOne(SysPosition position) {
        positionMapper.updateByPrimaryKeySelective(position);

    }

    public void delOnePosition(String id) {
        positionMapper.deleteByPrimaryKey(id);
    }
}
