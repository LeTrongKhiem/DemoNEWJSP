package com.jspservlettutorial.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspservlettutorial.service.ICaregoryService;
import com.jspservlettutorial.service.INewService;

@WebServlet(urlPatterns = {"/trang-chu"})
public class HomeController extends HttpServlet {

    @Inject
    private ICaregoryService categoryService;

    @Inject
    private INewService newService;
    private static final long serialVersionUID = 2994638737446305919L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("categores", categoryService.findAll());
        req.getRequestDispatcher("/view/web/home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }

}
