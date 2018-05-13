package com.money.debt.organization.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.money.debt.bean.SysOrganization;
import com.money.debt.organization.mapper.OrganizationMapper;
import com.money.debt.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    OrganizationMapper organizationMapper;

    @Override
    public void addOneOrganization(SysOrganization organization) {
        organizationMapper.insertSelective(organization);
    }

    @Override
    public void updateOne(SysOrganization organization) {
        organizationMapper.updateByPrimaryKeySelective(organization);
    }

    @Override
    public void delOneOriganization(String id) {
        organizationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<SysOrganization> listAll() {
        List<SysOrganization> organizations = organizationMapper.selectAll();
        return organizations;
    }

    @Override
    public String getLastOneId() {
       return organizationMapper.selectLastOneId();
    }

    @Override
    public List<SysOrganization> listAllDIY() {
        List<SysOrganization> all=organizationMapper.selectAllDIY();
        return all;
    }
}
