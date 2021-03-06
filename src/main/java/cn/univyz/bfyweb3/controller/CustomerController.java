package cn.univyz.bfyweb3.controller;

import cn.univyz.bfyweb3.model.Customer;
import cn.univyz.bfyweb3.service.CustomerService;
import cn.univyz.framework.annotation.Action;
import cn.univyz.framework.annotation.Controller;
import cn.univyz.framework.annotation.Inject;
import cn.univyz.framework.bean.Data;
import cn.univyz.framework.bean.Param;
import cn.univyz.framework.bean.View;
import java.util.List;
import java.util.Map;

/**
 * 控制器
 * 处理客户管理相关请求
 */
@Controller
public class CustomerController {


    @Inject
    private CustomerService customerService;

    /**
     * 进入客户列表界面
     */

    @Action("get:/Customer")
    public View index(Param param){
        List<Customer> customerList = customerService.getCustomerList();
        return new View("Customer.jsp").addModel("customerList",customerList);

    }

    /**
     * 显示客户基本信息
     */

    @Action("get:/customer_show")
    public View show(Param param){
        long id=param.getLong("id");
        Customer customer = customerService.getCustomer(id);
        return new View("customer_show.jsp").addModel("customer",customer);

    }

    /**
     * 进入创建客户界面
     */

    @Action("get:/customer_create")
    public View create(Param param){
        return new View("customer_create.jsp");
    }

    /**
     * 处理创建客户请求
     */

    @Action("post:/customer_create")
    public Data createSubmit(Param param){
        Map<String,Object> fieldMap=param.getMap();
        boolean result = customerService.createCustomer(fieldMap);
        return new Data(result);
    }

    /**
     * 进入编辑客户界面
     */

    @Action("get:/customer_edit")
    public View edit(Param param){
        long id = param.getLong("id");
        Customer Customer=customerService.getCustomer(id);
        return new View("customer_edit.jsp").addModel("customer",Customer);
    }

    /**
     *  处理编辑客户请求
     */

    @Action("put:/customer_edit")
    public Data editSubnit(Param param){
        long id = param.getLong("id");
        Map<String,Object> fieldMap = param.getMap();
        boolean result=customerService.updateCustomer(id, fieldMap);
        return new Data(result);
    }

    /**
     * 处理删除客户请求
     */

    @Action("delete:/customer_edit")
    public Data delete(Param param){
        long id = param.getLong("id");
        boolean result = customerService.deleteCustomer(id);
        return new Data(result);
    }




}
