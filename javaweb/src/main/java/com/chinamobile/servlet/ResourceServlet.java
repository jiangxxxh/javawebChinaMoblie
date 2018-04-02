package com.chinamobile.servlet;

import com.chinamobile.condition.MobileCondition;
import com.chinamobile.dao.XMobilesDao;
import com.chinamobile.pojo.XMobiles;
import com.chinamobile.util.Pager;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@WebServlet(name = "ResourceServlet")
public class ResourceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        XMobilesDao mDao = new XMobilesDao();
        String insertType = null;
        String MType = null;
        File file = null;

        // 处理文件上传
        // 是否有文件需上传: enctype="multipart/form-data"
        boolean flag1 = ServletFileUpload.isMultipartContent(request);
        if (flag1) {
            DiskFileItemFactory factory =
                    new DiskFileItemFactory(10000, new File("upload/"));
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setHeaderEncoding("utf-8");
            try {
                List<FileItem> items = upload.parseRequest(request);
                System.out.println("上传文件的个数: " + items.size());
                for (FileItem fileItem : items) {
                    // 是文件,不是表单字段
                    if (fileItem.isFormField()) {
                        if (fileItem.getFieldName().equals("insertType")) {
                            insertType = fileItem.getString();
                        }
                        if (fileItem.getFieldName().equals("MType")) {
                            MType = fileItem.getString();
                        }
                    } else {
                        String filename = fileItem.getName();
                        System.out.println("原文件名:" + filename);
                        filename = System.currentTimeMillis() + filename;
                        System.out.println("新文件名:" + filename);
                        // 服务器端的保存文件路径
                        // D:/apache-tomcat/webapps/javaweb/upload/xxx.png
                        String path = getServletContext().getRealPath("upload");
                        File dir = new File(path);
                        if (!dir.exists()) {
                            dir.mkdirs();
                        }
                        // 临时文件复制到指定文件
                        file = new File(dir, filename);
                        fileItem.write(file);
                        // 删除临时文件
                        fileItem.delete();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            insertType = request.getParameter("insertType");
        }
        insertType = (insertType == null || "".equals(insertType)) ? "list" : insertType;
        System.out.println("您的操作是：" + insertType);
        if ("list".equals(insertType)) {
            // 必需参数
            String spage = request.getParameter("page");
            spage = (spage == null || "".equals(spage)) ? "1" : spage;
            Integer page = Integer.parseInt(spage); // 默认第 1 页

            String srows = request.getParameter("rows");
            srows = (srows == null || "".equals(srows)) ? "10" : srows;
            Integer rows = Integer.parseInt(srows); // 默认每页显示 5 条数据

            String sort = request.getParameter("sort");
            sort = (sort == null || "".equals(sort)) ? "mobilesNum" : sort; // 默认排序字段

            String order = request.getParameter("order");
            order = (order == null || "".equals(order)) ? "asc" : order;// 默认排序方式

            // 可选参数
            String mobilesType = request.getParameter("mobilesType");
            //mobilesType = ("".equals(mobilesType)) ?  null: mobilesType;

            MobileCondition condition = new MobileCondition();
            condition.setPage(page);
            condition.setRows(rows);
            condition.setOrder(order);
            condition.setSort(sort);
            condition.setMobilesType(mobilesType);
            System.out.println("page="+page+"--"+"rows="+rows+"--"+"order="+order+"--"+"sort="+sort+"--"+"mobilesType="+mobilesType);
            Pager<XMobiles> pager = mDao.findPager(condition);

            // 计算总页数
            Integer pageSize =
                    (pager.getTotal() % rows == 0) ?
                            pager.getTotal() /
                                    rows : pager.getTotal() / rows + 1;
            request.setAttribute("pageSize", pageSize);

            request.setAttribute("pager", pager);
            request.setAttribute("page",page);
            request.setAttribute("rows",rows);
            request.setAttribute("sort",sort);
            request.setAttribute("order",order);
            request.setAttribute("mobilesType",mobilesType);
            //request.setAttribute("param", "all");
            // 转发
            request.getRequestDispatcher("showmobiles.jsp").forward(request, response);
        } else if ("bySetting".equals(insertType)) {

            MType = request.getParameter("MType");
            String snum1 = request.getParameter("T1");
            String snum2 = request.getParameter("T2");
            System.out.println(MType + " " + snum1 + " " + snum2);
            if ((snum1 != null && !"".equals(snum1)) && (snum2 != null && !"".equals(snum2))) {
                if (mDao.addMany(snum1, snum2, MType)) {
                    // 重定向
                    response.sendRedirect("ResourceServlet");
                } else {
                    out.println("导入出错");
                    response.setHeader("refresh", "2;resource.jsp");
                }
            } else {
                out.println("输入有误");
                response.setHeader("refresh", "2;resource.jsp");
            }
            if (mDao.addMany(snum1, snum2, MType)) {
                // 重定向
                response.sendRedirect("ResourceServlet");
            } else {
                out.println("导入出错");
                response.setHeader("refresh", "2;resource.jsp");
            }

        } else if ("byFile".equals(insertType)) {
            if (file != null && MType != null && MType.length() > 0) {
                int i = mDao.addByFile(file, MType);
                if (i > 0) {
                    System.out.println("总共添加了"+i+"行数据");
                    response.sendRedirect("ResourceServlet");
                }else{
                    out.println("添加出错");
                    response.setHeader("refresh","3;url=resource.jsp");
                }
            }


        } else if ("findByParam".equals(insertType)) {
            String param = request.getParameter("param");
            //param = (param == null || "".equals(param) || "ALL".equals(param)) ? null : param;
            param = ( "".equals(param))? null : param;
            System.out.println("param=" + param);
            List<XMobiles> list = mDao.findByParam(param);
            request.setAttribute("mobiles", list);
            //String param2 = (param == null) ? "ALL" : param;
            request.setAttribute("param", param);
            // 转发
            request.getRequestDispatcher("showmobiles.jsp").forward(request, response);
        }

        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
