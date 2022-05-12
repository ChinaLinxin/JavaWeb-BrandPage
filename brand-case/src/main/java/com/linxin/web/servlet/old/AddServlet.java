package com.linxin.web.servlet.old; /**
 * @author 刘林鑫
 * @version 1.0
 */

import com.alibaba.fastjson.JSON;
import com.linxin.pojo.Brand;
import com.linxin.service.BrandService;
import com.linxin.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

//@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {

    private BrandService brandService = new BrandServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、接收品牌数据
        BufferedReader reader = request.getReader();
        String params = reader.readLine();//json字符串

        //转为brand对象
        Brand brand = JSON.parseObject(params, Brand.class);

        //2、调用service添加
        brandService.addBrand(brand);

        //3、响应成功的标识
        response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
