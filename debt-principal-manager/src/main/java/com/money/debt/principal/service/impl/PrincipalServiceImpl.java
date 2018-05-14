package com.money.debt.principal.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.money.debt.bean.Entrust;
import com.money.debt.bean.EntrustQuery;
import com.money.debt.principal.mapper.PrincipalMapper;
import com.money.debt.services.PrincipalService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class PrincipalServiceImpl implements PrincipalService {

    @Autowired
    PrincipalMapper principalMapper;

    public List<Entrust> showAll() {
        return principalMapper.selectAll();
    }

    public String getLastOneId() {
        return principalMapper.selectLastOneId();
    }

    public void addOnePrincipal(Entrust entrust) {
        principalMapper.insertSelective(entrust);
    }

    public void updateOne(Entrust entrust) {
        principalMapper.updateByPrimaryKeySelective(entrust);
    }

    public List<Entrust> querySelective(EntrustQuery entrustQuery) {
        return principalMapper.querySelective(entrustQuery);
    }
}
