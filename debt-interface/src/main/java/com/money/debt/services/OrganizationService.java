package com.money.debt.services;

import com.money.debt.bean.SysOrganization;

import java.util.List;

public interface OrganizationService {

    void addOneOrganization(SysOrganization organization);

    void updateOne(SysOrganization organization);

    void delOneOriganization(String id);

    List<SysOrganization> listAll();

    String getLastOneId();

    List<SysOrganization> listAllDIY();
}
