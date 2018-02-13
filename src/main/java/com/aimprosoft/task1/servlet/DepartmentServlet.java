package com.aimprosoft.task1.servlet;

import com.aimprosoft.task1.dao.DepartmentDao;
import com.aimprosoft.task1.dao.MysqlDepartmentDao;
import com.aimprosoft.task1.model.Department;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class DepartmentServlet extends HttpServlet {

    private DepartmentDao dao;

    private static final long serialVersionUID = 1L;
    private final static String DEPARTMENTS_LIST = "/WEB-INF/pages/departments.jsp";
    private final static String DEPARTMENT_FORM = "/WEB-INF/pages/departmentForm.jsp";
    private final static String ERROR_PAGE = "/WEB-INF/pages/error.jsp";

    public DepartmentServlet() {
        super();
        dao =  new MysqlDepartmentDao();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path="";
        String action = request.getParameter("action");
        String name = request.getParameter("name");
        String newName = request.getParameter("newName");
        String newInfo = request.getParameter("newInfo");
        Department department = new Department();
        department.setName(newName);
        department.setInfo(newInfo);
        try {

            if("edit".equals(action)) {
                dao.update(name,department);
            }

            else if("add".equals(action)) {
               dao.add(department);
            }

            path = DEPARTMENTS_LIST;
            request.setAttribute("departments", dao.list());

        }
        catch (Exception e) {
            path = ERROR_PAGE;
            request.setAttribute("errorMessage", e.getMessage());

        }
        RequestDispatcher view = request.getRequestDispatcher(path);
        view.forward(request, response);


    }

    //VALIDATE



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path="";
try {
    String action = request.getParameter("action");
    if("list".equals(action)) {
        request.setAttribute("departments", dao.list());
        path=DEPARTMENTS_LIST;
    }


//show form for editing
    else if("edit".equals(action)) {
        String name = request.getParameter("name");
        request.setAttribute("department", dao.getByName(name));
        path = DEPARTMENT_FORM;
    }

    else if("delete".equals(action)) {
        String name = request.getParameter("name");
        dao.delete(name);
        request.setAttribute("department", dao.list());
        path = DEPARTMENTS_LIST;
    }

    else {
        path = DEPARTMENTS_LIST;
    }




        }
        catch (Exception e) {
           path = ERROR_PAGE;
            request.setAttribute("errorMessage", e.getMessage());

        }
        RequestDispatcher view = request.getRequestDispatcher(path);
        view.forward(request, response);


    }



}
