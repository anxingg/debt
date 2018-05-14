package com.money.debt.principal.mapper;

import com.money.debt.bean.Entrust;
import com.money.debt.bean.EntrustQuery;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


public interface PrincipalMapper extends Mapper<Entrust> {
    String selectLastOneId();

    List<Entrust> querySelective(EntrustQuery entrustQuery);
}
