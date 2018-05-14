package com.money.debt.world.principal.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.money.debt.bean.Entrust;
import com.money.debt.bean.EntrustQuery;
import com.money.debt.services.PrincipalService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class PrincipalController {

    @Reference
    PrincipalService principalService;

    @RequestMapping("principalListPage")
    public String posiListPage() {
        return "principalListPage";
    }

    @RequestMapping("principal/showAll")
    @ResponseBody
    public List<Entrust> showAll(){
        List<Entrust> all=principalService.showAll();
       return  all;
    }

    @RequestMapping(value = "/principal/addOne",method = RequestMethod.POST)
    @ResponseBody
    public String addOne(Entrust entrust){
        if(entrust.getId()==null||entrust.getId().equals("")){//如果id为null,去添加，else去修改
            try {
                //获取到前一个id,+1
                String lastOneId =principalService.getLastOneId();
                Integer temp= Integer.parseInt(lastOneId);
                entrust.setId(String.valueOf(temp.intValue()+1));
                entrust.setState(0);//默认禁用
                entrust.setCreateTime(new Date());
                principalService.addOnePrincipal(entrust);
            }catch (Exception e){
                e.printStackTrace();
                return "fail";
            }

        }else {
            try {
                entrust.setModifyTime(new Date());
                principalService.updateOne(entrust);
            }catch (Exception e){
                e.printStackTrace();
                return "fail";
            }

        }
        return "success";

    }

    @RequestMapping(value = "/principal/freeOrForbidOne",method = RequestMethod.POST)
    @ResponseBody
    public String freeOrForbidOne(@RequestParam Map<String,String> params){
       String tobe= params.get("tobe");
       String id=params.get("id");
        Entrust entrust=new Entrust();
        entrust.setId(id);
        entrust.setModifyTime(new Date());
       if ("1".equals(tobe)){//启用功能
           entrust.setState(1);
       }else if ("0".equals(tobe)){//禁用功能
           entrust.setState(0);
       }else {
           return "fail";
       }
       //去修改
        try {
            principalService.updateOne(entrust);
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
       return "success";

    }

    @RequestMapping("/principal/querySelective")
    @ResponseBody
    public List<Entrust> querySelective(EntrustQuery entrustQuery){
        List<Entrust> all=  principalService.querySelective(entrustQuery);
       return all;
    }
}
