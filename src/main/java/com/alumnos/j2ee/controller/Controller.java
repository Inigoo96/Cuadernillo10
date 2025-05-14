package com.alumnos.j2ee.controller;

import com.alumnos.j2ee.service.HamburguesaService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
    private HamburguesaService service = new HamburguesaService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action = req.getParameter("ACTION");
        try {
            if ("HAMBURGUESA.LIST".equalsIgnoreCase(action)) {
                service.listar(req, resp);
            } else {
                resp.sendError(400, "Operación no soportada: " + action);
            }
        } catch (Exception e) {
            resp.sendError(500, e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }
}
