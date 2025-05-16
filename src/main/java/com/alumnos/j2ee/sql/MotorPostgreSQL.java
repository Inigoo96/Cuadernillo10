package com.alumnos.j2ee.sql;

import java.sql.DriverManager;
import java.util.Properties;

public class MotorPostgreSQL extends MotorSQLA {
    // Apunta al RDS de AWS en vez de al localhost
    private static final String URL      = "jdbc:postgresql://cuaderno10.c5o4moqmqwht.us-east-1.rds.amazonaws.com:5432/postgres";
    private static final String USER     = "postgres";           // usuario de la RDS (ajusta si usas otro)
    private static final String PASSWORD = "DANISDANIS";         // la contraseña que has dado

    @Override
    public void conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            Properties props = new Properties();
            props.setProperty("user", USER);
            props.setProperty("password", PASSWORD);
            props.setProperty("ssl", "false");  // si tu RDS exige SSL pon "true" y añade props.setProperty("sslmode","require");
            conn = DriverManager.getConnection(URL, props);
            System.out.println("¡Conectado al RDS PostgreSQL!");
        } catch (Exception e) {
            System.err.println("Error conexión PostgreSQL RDS: " + e.getMessage());
        }
    }
}
