package com.alumnos.j2ee.sql;

import java.sql.Connection;

public interface IMotorSQL {
    void conectar();
    Connection getConnection();
}
