package com.chinamobile.servlet;

import com.chinamobile.dao.XCustomerDao;
import com.chinamobile.pojo.XCustomer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "XCustomerServlet")
public class XCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String action = request.getParameter("action");
        action = (action == null) ? "list" : action;
        System.out.println("本次操作：" + action);
        XCustomerDao dao = new XCustomerDao();

        if ("list".equals(action)) {
            //模糊查询 查询所有
            String cusType = request.getParameter("cusType");
            cusType = (cusType == null || "".equals(cusType)) ? "0" : cusType;
            System.out.println("类型：" + cusType);
            String cusNumber = request.getParameter("cusNumber");

            cusNumber = (cusNumber == null || "".equals(cusNumber)) ? "0" : cusNumber;
            System.out.println("号码为：" + cusNumber);
            XCustomer xcustomer = dao.findByParam(cusType, cusNumber);

            if (xcustomer != null) {
                request.setAttribute("xCustomers", xcustomer);
                request.getRequestDispatcher("newCustomer1.jsp").forward(request, response);
            } else {
                XCustomer xc = new XCustomer();
                xc.setCusType(cusType);
                xc.setCusNumber(cusNumber);
                request.setAttribute("xCustomers", xc);
                request.getRequestDispatcher("newCustomer1.jsp").forward(request, response);
            }

        } else if ("save".equals(action)) { //第一步增加
            // 获取表单值
            String scusId = request.getParameter("cusId");
            scusId = (scusId == null || "".equals(scusId))?"0":scusId;
            Integer cusId = Integer.parseInt(scusId);
            String cusType = request.getParameter("cusType");
            String cusNumber = request.getParameter("cusNumber");
            String cusName = request.getParameter("cusName");
            Date cusBirth = new Date();
            /*时间转换*/
            if (request.getParameter("cusBirth") != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    cusBirth = sdf.parse(request.getParameter("cusBirth"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            String cusSex = request.getParameter("cusSex");
            String cusAdd = request.getParameter("cusAdd");

            // 2.封装数据到对象
            XCustomer xCustomer = new XCustomer();
            xCustomer.setCusId(cusId);
            xCustomer.setCusType(cusType);
            xCustomer.setCusNumber(cusNumber);
            xCustomer.setCusName(cusName);
            xCustomer.setCusBirth(cusBirth);
            xCustomer.setCusSex(cusSex);
            xCustomer.setCusAdd(cusAdd);
            System.out.println("xCustomer:"+xCustomer);

            int count = 0;
            /*是否成功*/
            if (cusId>0) {
                count = dao.modifyXCustomer(xCustomer);
            } else{
                count = dao.addXCustomer(xCustomer);
            }

            if (count > 0) {
                request.setAttribute("xCustomer", xCustomer);
                request.getRequestDispatcher("newUser.jsp").forward(request, response);
            } else {
                //失败
                out.println("保存失败");
                response.setHeader("refresh", "2;url=XCustomerServlet");
            }

        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
