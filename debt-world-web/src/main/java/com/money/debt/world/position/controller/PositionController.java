package com.money.debt.world.position.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.money.debt.bean.SysDictionary;
import com.money.debt.bean.SysOrganization;
import com.money.debt.bean.SysPosition;
import com.money.debt.services.PositionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PositionController {

    @Reference
    PositionService positionService;

    @RequestMapping("posiListPage")
    public String posiListPage() {
        return "posiListPage";
    }

    @RequestMapping("/position/showAll")
    @ResponseBody
    public List<SysPosition> showAll() {
        return positionService.listAllDIY();
    }

    @RequestMapping("/position/getAvailableTypes")
    @ResponseBody
    public List<SysDictionary> getAvailableTypes() {
        return positionService.getAvailableTypes();
    }

    @RequestMapping("/position/getAvailableParents")
    @ResponseBody
    public List<SysPosition> getAvailableParents() {
        return positionService.getAvailableParents();
    }


    @RequestMapping(value = "/position/addOne", method = RequestMethod.POST)
    @ResponseBody
    public String addOne(SysPosition position) {
        if (position.getId() == null || position.getId().equals("")) {//如果id为null,去添加，else去修改
            try {
                //获取到前一个id,+1
                String lastOneId = positionService.getLastOneId();
                Integer temp = Integer.parseInt(lastOneId);
                position.setId(String.valueOf(temp.intValue() + 1));

                if (position.getParentId() == null || position.getParentId().equals("")) {//如果没有填写上级机构，为根节点
                    position.setParentId(position.getId());
                }
                positionService.addOnePosition(position);
            } catch (Exception e) {
                e.printStackTrace();
                return "fail";
            }

        } else {
            try {
                positionService.updateOne(position);
            } catch (Exception e) {
                e.printStackTrace();
                return "fail";
            }

        }
        return "success";
    }

    @RequestMapping(value = "/position/delOne",method =RequestMethod.POST)
    @ResponseBody
    public String delOne(String id){
        positionService.delOnePosition(id);
        return "success";
    }

}
