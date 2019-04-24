package cn.sheep.cmcc.controller;

import cn.sheep.cmcc.beans.MinuteKpiVo;
import cn.sheep.cmcc.service.IMinuteService;
import cn.sheep.cmcc.service.MinuteKpiService;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "minuteServlet",urlPatterns = {"/minutesKpi.cmcc"})
public class MinuteServlet extends HttpServlet {
    IMinuteService service = new MinuteKpiService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");

        //接受参数
        String day=req.getParameter("day");

        Date date =new Date();
        //取到小时和分钟
        SimpleDateFormat format=new SimpleDateFormat("HHmm");
        String time=format.format(date);

        MinuteKpiVo vo =service.findBy(day,time);
        System.out.print(day+" "+time+" "+vo.getCount()+" "+vo.getMoney());
        //将对象转换成对象输出
        resp.getWriter().write(JSONObject.toJSONString(vo));

    }
}
