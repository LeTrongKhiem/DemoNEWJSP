package com.jspservlettutorial.controller.admin;

import com.jspservlettutorial.constant.SystemConstant;
import com.jspservlettutorial.model.NewModel;
import com.jspservlettutorial.service.INewService;
import com.jspservlettutorial.utils.FormUtil;

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
        NewModel model = FormUtil.toModel(NewModel.class, req);
//        String pageStr = req.getParameter("page");
//        String maxPageItemStr = req.getParameter("maxPageItem");
//        if (pageStr != null) {
//            model.setPage(Integer.parseInt(pageStr));
//        } else model.setPage(1);
//        if (maxPageItemStr != null) {
//            model.setMaxPageItem(Integer.parseInt(maxPageItemStr));
//        }
        Integer offset = (model.getPage() - 1) * model.getMaxPageItem();
        model.setListResult(newService.findAll(offset, model.getMaxPageItem()));
        model.setTotalPage(newService.getTotalItem());
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));//totalpage = totalitem / maxpageitem
        req.setAttribute(SystemConstant.MODEL, model);
        req.getRequestDispatcher("/view/admin/new/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }
}
