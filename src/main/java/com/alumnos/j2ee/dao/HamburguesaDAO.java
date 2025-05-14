package com.alumnos.j2ee.dao;

import com.alumnos.j2ee.model.Hamburguesa;
import com.alumnos.j2ee.sql.FactoryMotorSQL;
import com.alumnos.j2ee.sql.IMotorSQL;

import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HamburguesaDAO {
    private IMotorSQL motor;

    public HamburguesaDAO() {
        this.motor = FactoryMotorSQL.getInstance(FactoryMotorSQL.POSTGRE);
        this.motor.conectar();
    }

    public List<Hamburguesa> getHamburguesas() {
        List<Hamburguesa> lista = new ArrayList<>();
        try (Statement st = motor.getConnection().createStatement();
             ResultSet rs = st.executeQuery("SELECT nombre, precio FROM hamburguesas")) {
            while (rs.next()) {
                lista.add(new Hamburguesa(rs.getString("nombre"), rs.getDouble("precio")));
            }
        } catch (Exception e) {
            System.err.println("DAO error: " + e.getMessage());
        }
        return lista;
    }
}
