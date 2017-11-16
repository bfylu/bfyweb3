package cn.univyz.bfyweb3.test;


import cn.univyz.bfyweb3.model.customer;
import cn.univyz.bfyweb3.service.CustomerService;
import cn.univyz.framework.helper.DatabaseHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 单元测试
 */
public class CustomerServiceTest {
    private final CustomerService customerService;

    public CustomerServiceTest() {
        this.customerService =new CustomerService();

    }

    @Before
    public void init() throws Exception {
        //TODO 初始化数据库
        DatabaseHelper.executeSqlFile("sql/customer_init.sql");

    }
    @Test
    public void getCustomerListText() throws Exception{
        List<customer> customerList = customerService.getCustomerList();
        Assert.assertEquals(2,customerList.size());
    }

    @Test
    public  void getCustomerTest() throws Exception{
        long id=1;
        customer customer = customerService.getCustomer(id);
        Assert.assertNotNull(customer);
    }

    @Test
    public void createCustomerTest() throws Exception{
        Map<String, Object> fieldMap = new HashMap<String, Object>();
        fieldMap.put("name","customer100");
        fieldMap.put("contact","bfy32");
        fieldMap.put("telephone","13512345678");
        boolean result = customerService.createCustomer(fieldMap);
        Assert.assertTrue(result);
    }

    @Test
    public void updateCustomerTest() throws Exception{
        long id=1;
        Map<String, Object> fieldMap = new HashMap<String,Object>();
        fieldMap.put("contact","Eric");
        boolean result = customerService.updateCustomer(id,fieldMap);
        Assert.assertTrue(result);
    }

    @Test
    public void deleteCustomerTest() throws Exception{
        long id=1;
        boolean result = customerService.deleteCustomer(id);
        Assert.assertTrue(result);
    }
}
