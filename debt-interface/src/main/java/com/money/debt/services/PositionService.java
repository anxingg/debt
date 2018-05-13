package com.money.debt.services;

import com.money.debt.bean.SysDictionary;
import com.money.debt.bean.SysPosition;

import java.util.List;

public interface PositionService {
    List<SysPosition>  listAllDIY();

    List<SysDictionary> getAvailableTypes();

    List<SysPosition> getAvailableParents();

    String getLastOneId();

    void addOnePosition(SysPosition position);

    void updateOne(SysPosition position);

    void delOnePosition(String id);
}
