package com.alumnos.j2ee.service;

import com.alumnos.j2ee.dao.HamburguesaDAO;
import com.alumnos.j2ee.model.Hamburguesa;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

public class HamburguesaService {
    private HamburguesaDAO dao = new HamburguesaDAO();

    public void listar(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        List<Hamburguesa> list = dao.getHamburguesas();

        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            Hamburguesa h = list.get(i);
            json.append("{")
                .append("\"nombre\":\"").append(h.getNombre()).append("\",")
                .append("\"precio\":").append(h.getPrecio())
                .append("}");
            if (i < list.size() - 1) json.append(",");
        }
        json.append("]");
        out.print(json.toString());
    }
}
