package com.money.debt.services;

import com.money.debt.bean.Entrust;
import com.money.debt.bean.EntrustQuery;

import java.util.List;

public interface PrincipalService {
    List<Entrust> showAll();

    String getLastOneId();

    void addOnePrincipal(Entrust entrust);

    void updateOne(Entrust entrust);

    List<Entrust> querySelective(EntrustQuery entrustQuery);
}
