package com.chinamobile.servlet;

import com.chinamobile.dao.XChargeDao;
import com.chinamobile.dao.XFunctionDao;
import com.chinamobile.pojo.XCharge;
import com.chinamobile.pojo.XFunction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "ChargeServlet")
public class ChargeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();



            XChargeDao dao = new XChargeDao();
            XFunctionDao funcDao = new XFunctionDao();

            String funcode = request.getParameter("funcode");
            funcode = (funcode==null || "".equals(funcode))? "O":funcode;
            // 获取表单值
            String chargeCode = request.getParameter("chargeCode");
            System.out.println("chargeCode="+chargeCode);
            // 默认查询以A 为charcode的数据
            chargeCode = (chargeCode == null || "".equals(chargeCode))? "A":chargeCode;

            String action = request.getParameter("action");
            System.out.println("saction="+action);
            // 默认根据chargecode查询
            action = (action == null || "".equals(action))? "findById":action;
            System.out.println("您的操作是："+action);

            if("findById".equals(action)){
                XCharge xc = dao.findById(chargeCode);
                List<XFunction> list = funcDao.fundByCode(funcode);
                if(xc != null && list != null && list.size()>0){
                    System.out.println(xc);
                    request.setAttribute("xcharge",xc);
                    request.setAttribute("funcode",funcode);
                    for(int i=0;i<list.size();i++){
                        String chargecode = list.get(i).getChargeCode();
                        switch (chargecode){
                            case "A": request.setAttribute("A",chargecode);
                                continue;
                            case "B": request.setAttribute("B",chargecode);
                                continue;
                            case "C": request.setAttribute("C",chargecode);
                                continue;
                            case "D": request.setAttribute("D",chargecode);
                                continue;
                            case "E": request.setAttribute("E",chargecode);
                                continue;
                        }
                    }
                    request.getRequestDispatcher("charge.jsp").forward(request,response);
                }else{
                    out.println("无查询结果");
                    response.setHeader("refresh","2;welcome.jsp");
                }

            }else if("chargemodify".equals(action)){
                System.out.println("chargeCode="+chargeCode);

                XCharge xc = dao.findById(chargeCode);
                String scharge = request.getParameter("charge");

                System.out.println("scharge="+scharge);
                scharge = (scharge == null || "".equals(scharge))? (xc.getCharge()+""):scharge;
                Double charge = Double.parseDouble(scharge);
                System.out.println("charge="+charge);
                xc.setCharge(charge);
                int count = dao.modify(xc);
                if(count>0){
                    response.sendRedirect("ChargeServlet");
                    System.out.println(xc);
                }else{
                    out.println("修改失败");
                    response.setHeader("refresh","2;ChargeServlet");
                }
            }else if("functionmodify".equals(action)){
                String [] charges = request.getParameterValues("charges");
                System.out.println("charges[]="+ Arrays.toString(charges));
                String funName = null;
                switch (funcode){  // 根据业务代码设置业务名称
                    case "O": funName="开户业务";
                        break;
                }
                XFunction xFunction = new XFunction();
                if(funName != null && funName.length()>0){
                    xFunction.setFuncName(funName);
                }
                xFunction.setFuncCode(funcode);
                int count = funcDao.removeXFunc(funcode); // 返回删除结果
                int count2 = 0; // 保存添加到数据库的次数
                if(count>0){
                    for(int i=0;i<charges.length;i++){
                        String chargecode2 = charges[i];
                        xFunction.setChargeCode(chargecode2);
                        count2 = count2 + funcDao.addXFunc(xFunction);
                    }
                    System.out.println("count2="+count2);
                    System.out.println("charges.length="+charges.length);
                    if(count2 == charges.length){
                        response.sendRedirect("ChargeServlet");
                    }else{
                        out.println("配置业务出错");
                        response.sendRedirect("ChargeServlet");
                    }
                }

            }




        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
