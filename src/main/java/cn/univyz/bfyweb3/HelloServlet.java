package cn.univyz.bfyweb3;



import cn.univyz.framework.annotation.Controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//继承HttpServlet,让它成为一个Servlet
@Controller
public class HelloServlet  {

        DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = dateFormat.format(new Date());

}
