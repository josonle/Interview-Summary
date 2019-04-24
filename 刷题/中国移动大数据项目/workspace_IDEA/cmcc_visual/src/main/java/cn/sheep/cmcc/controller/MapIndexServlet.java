package cn.sheep.cmcc.controller;
/**
 * 充值成功业务分布Servlet接口
 */

import cn.sheep.cmcc.beans.MapVo;
import cn.sheep.cmcc.service.IMapIndexService;
import cn.sheep.cmcc.service.MapIndexImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//统一资源通配符
@WebServlet(name = "mapIndexServlet",urlPatterns = {"/mapIndex.cmcc"})
public class MapIndexServlet extends HttpServlet {
    IMapIndexService service=new MapIndexImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.setCharacterEncoding("utf-8");
       resp.setContentType("application/json");
       //接受前端传过来的参数
        String day = req.getParameter("day");
        //调用service
        List<MapVo> voList=service.findAllBy(day);
        //将数据返回前端
        String jsonStr= JSON.toJSONString(voList);
        resp.getWriter().write(jsonStr);

    }
}
