package com.money.debt.organization.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.money.debt.bean.SysOrganization;
import com.money.debt.services.OrganizationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Controller
public class OrganizationController {

    @Reference
    OrganizationService organizationService;

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("orgaListPage")
    public String orgaListPage(){
        return "orgaListPage";
    }


    @RequestMapping("/organization/showAll")
    @ResponseBody
    public List<SysOrganization> showAll(){
       return  organizationService.listAllDIY();
    }

    @RequestMapping("/organization/getAllIds")
    @ResponseBody
    public List<SysOrganization> getAllIds(){
        return  organizationService.listAll();
    }

    @RequestMapping(value="/organization/addOne",method = RequestMethod.POST)
    @ResponseBody
    public String addOne(SysOrganization organization){
        if(organization.getId()==null||organization.getId().equals("")){//如果id为null,去添加，else去修改
            try {
                String lastOneId =organizationService.getLastOneId();
                Integer temp= Integer.parseInt(lastOneId);
                organization.setId(String.valueOf(temp.intValue()+1));
                //获取到前一个id,+1
                organizationService.addOneOrganization(organization);
            }catch (Exception e){
                e.printStackTrace();
                return "fail";
            }

        }else {
            try {
                organizationService.updateOne(organization);
            }catch (Exception e){
                e.printStackTrace();
                return "fail";
            }

        }
        return "success";
    }

    @RequestMapping(value = "/organization/delOne",method =RequestMethod.POST)
    @ResponseBody
    public String delOne(String id){
        organizationService.delOneOriganization(id);
        return "success";
    }
}
