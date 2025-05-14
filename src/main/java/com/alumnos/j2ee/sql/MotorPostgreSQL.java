package com.alumnos.j2ee.sql;

import java.sql.DriverManager;
import java.util.Properties;

public class MotorPostgreSQL extends MotorSQLA {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";

    @Override
    public void conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            Properties props = new Properties();
            props.setProperty("user", USER);
            props.setProperty("password", PASSWORD);
            props.setProperty("ssl", "false");
            conn = DriverManager.getConnection(URL, props);
            System.out.println("Connected to PostgreSQL!");
        } catch (Exception e) {
            System.err.println("PostgreSQL connection error: " + e.getMessage());
        }
    }
}
