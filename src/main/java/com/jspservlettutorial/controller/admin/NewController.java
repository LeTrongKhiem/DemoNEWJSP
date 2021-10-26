package com.jspservlettutorial.controller.admin;

import com.jspservlettutorial.constant.SystemConstant;
import com.jspservlettutorial.model.NewModel;
import com.jspservlettutorial.service.INewService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin-new"})
public class NewController extends HttpServlet {
    private static final long serialVersionUID = 2994638737446305919L;
    @Inject
    private INewService newService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewModel model = new NewModel();
        model.setListResult(newService.findAll());
        req.setAttribute(SystemConstant.MODEL, model);
        req.getRequestDispatcher("/view/admin/new/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }
}
