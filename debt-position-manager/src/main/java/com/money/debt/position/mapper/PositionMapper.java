package com.money.debt.position.mapper;

import com.money.debt.bean.SysPosition;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PositionMapper extends Mapper<SysPosition> {

    List<SysPosition> selectAllDIY();

    List<SysPosition> selectAvailableParents();

    String selectLastOneId();
}
