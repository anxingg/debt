package com.money.debt.organization.mapper;

import com.money.debt.bean.SysOrganization;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface OrganizationMapper extends Mapper<SysOrganization> {

    String selectLastOneId();

    List<SysOrganization> selectAllDIY();
}
