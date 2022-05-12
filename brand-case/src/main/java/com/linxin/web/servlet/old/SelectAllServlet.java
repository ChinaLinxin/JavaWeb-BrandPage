package com.linxin.web.servlet.old; /**
 * @author 刘林鑫
 * @version 1.0
 */

import com.alibaba.fastjson.JSON;
import com.linxin.pojo.Brand;
import com.linxin.service.BrandService;
import com.linxin.service.impl.BrandServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

//@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {

    private BrandService brandService = new BrandServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、调用service查询
        List<Brand> brands = brandService.selectAll();

        //2、转为JSON
        String jsonString = JSON.toJSONString(brands);

        //3、写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
