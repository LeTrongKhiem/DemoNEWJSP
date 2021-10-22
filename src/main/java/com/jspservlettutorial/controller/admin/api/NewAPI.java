package com.jspservlettutorial.controller.admin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jspservlettutorial.model.NewModel;
import com.jspservlettutorial.service.INewService;
import com.jspservlettutorial.utils.HttpUtils;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api-admin-new"})
public class NewAPI extends HttpServlet {

    @Inject
    private INewService newService;
    private static final long serialVersionUID = -8698274516032023702L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");// postman co ngon ngu la tieng viet
        resp.setContentType("application/json"); // header trong json postman
        NewModel newModel = HttpUtils.of(req.getReader()).toModel(NewModel.class);
        newModel = newService.save(newModel);
        mapper.writeValue(resp.getOutputStream(), newModel);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        NewModel updateNews = HttpUtils.of(req.getReader()).toModel(NewModel.class);
        updateNews = newService.update(updateNews);
        mapper.writeValue(resp.getOutputStream(), updateNews);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        NewModel newModel = HttpUtils.of(req.getReader()).toModel(NewModel.class);
        newService.delete(newModel.getIds());
        mapper.writeValue(resp.getOutputStream(), "{}");
    }

}
