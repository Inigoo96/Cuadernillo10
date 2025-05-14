package com.alumnos.j2ee.sql;

public class FactoryMotorSQL {
    public static final String POSTGRE = "POSTGRE";
    public static final String MY_SQL  = "MYSQL";
    public static final String ORACLE  = "ORACLE";

    public static IMotorSQL getInstance(String bd) {
        switch (bd) {
            case POSTGRE: return new MotorPostgreSQL();
            case MY_SQL:  return new MotorMySQL();
            case ORACLE:  return new MotorOracle();
            default:      throw new IllegalArgumentException("Motor desconocido: " + bd);
        }
    }
}
