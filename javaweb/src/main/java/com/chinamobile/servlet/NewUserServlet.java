package com.chinamobile.servlet;


import com.chinamobile.dao.XChargeDao;
import com.chinamobile.dao.XFunctionDao;
import com.chinamobile.dao.XMobilesDao;
import com.chinamobile.dao.XUserDao;
import com.chinamobile.pojo.XCharge;
import com.chinamobile.pojo.XFunction;
import com.chinamobile.pojo.XMobiles;
import com.chinamobile.pojo.XUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "NewUserServlet")
public class NewUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");
        action = (action==null || "".equals(action))? "list":action;
        System.out.println("您的操作是："+action);

        XUserDao dao = new XUserDao();
        XMobilesDao mobilesDao = new XMobilesDao();
        XFunctionDao funcDao = new XFunctionDao();
        XChargeDao chargeDao = new XChargeDao();

        if("list".equals(action)){
            System.out.println("进行查询操作");

        }else if("addUser".equals(action)){
            // 获取表单值
            String mobileNum = request.getParameter("mobileNum");
            XMobiles mobile = mobilesDao.findByMobileNum(mobileNum);
            String scusId = request.getParameter("cusId");
            scusId = (scusId==null || "".equals(scusId))? "0":scusId;
            Integer cusId = Integer.parseInt(scusId);
            if(mobile != null){
                if("1".equals(mobile.getIsAvailable())){
                    String userStatus = request.getParameter("userStatus");
                    String userLevel = request.getParameter("userLevel");
                   /* String scusId = request.getParameter("cusId");
                    scusId = (scusId==null || "".equals(scusId))? "0":scusId;
                    Integer cusId = Integer.parseInt(scusId);*/
                    // 封装成对象
                    XUser xUser = new XUser();
                    xUser.setUserStatus(userStatus);
                    xUser.setUserLevel(userLevel);
                    xUser.setMobilesNum(mobileNum);
                    xUser.setCusId(cusId);
                    xUser.setUserBalance(0.00);
                    System.out.println("User:"+xUser);
                    int count = 0;
                    count = dao.addXUser(xUser);
                    if(count>0){
                        int count2 = mobilesDao.midifyXMobiles(mobileNum); // 新增用户成功后，改变号码状态
                        XUser user2 = dao.findByNum(mobileNum);
                        if(count2>0){
                            List<XFunction> funcList = funcDao.fundByCode("O"); // 开户业务
                            if(funcList != null && funcList.size()>0){
                                Double total = 0d;
                                for(XFunction xf : funcList){
                                    String chargeCode = xf.getChargeCode();
                                    switch (chargeCode){
                                        case "A":
                                            XCharge xCharge = chargeDao.findById(chargeCode);
                                            request.setAttribute("A",xCharge.getCharge());
                                            total += xCharge.getCharge();
                                            continue;
                                        case "B":
                                            XCharge xCharge1 = chargeDao.findById(chargeCode);
                                            request.setAttribute("B",xCharge1.getCharge());
                                            total += xCharge1.getCharge();
                                            continue;
                                        case "C":
                                            XCharge xCharge2 = chargeDao.findById(chargeCode);
                                            request.setAttribute("C",xCharge2.getCharge());
                                            total += xCharge2.getCharge();
                                            continue;
                                        case "D":
                                            XCharge xCharge3 = chargeDao.findById(chargeCode);
                                            request.setAttribute("D",xCharge3.getCharge());
                                            total += xCharge3.getCharge();
                                            continue;
                                        case "E":
                                            XCharge xCharge4 = chargeDao.findById(chargeCode);
                                            request.setAttribute("E",xCharge4.getCharge());
                                            total += xCharge4.getCharge();
                                            continue;
                                    }
                                }
                                request.setAttribute("user2",user2);
                                request.setAttribute("total",total);
                                request.getRequestDispatcher("newUser1.jsp").forward(request,response);
                            }else{
                                out.println("新增用户成功，未查询到开户业务,请联系管理员");
                                response.setHeader("refresh","3;url=newCustomer.jsp");
                            }
                        }else{
                            out.println("新增用户成功，修改号码状态出错,请联系管理员");
                            response.setHeader("refresh","3;url=newCustomer.jsp");
                        }
                    }else{
                        out.println("号码可用，添加USER出错,请重试");
                        response.setHeader("refresh","3;url=newCustomer.jsp");
                    }
                }else{
                    out.println("号码不可用，请重新输入");
                    response.setHeader("refresh","3;url=newCustomer.jsp");
                }
            }else{
                out.println("查询无此号码，请重新输入");
                response.setHeader("refresh","3;url=newCustomer.jsp");
            }
        }

        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
