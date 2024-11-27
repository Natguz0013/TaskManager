package com.mycompany.proyectojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    // Datos de conexión a la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/ejemplodb";  
    private static final String USER = "root";  
    private static final String PASSWORD = "#Nn312630170312";  

    /**
     * Establece y retorna la conexión con la base de datos.
     *
     * @return Connection - La conexión a la base de datos.
     * @throws SQLException - Si hay un error al intentar establecer la conexión.
     */
    public static Connection getConnection() throws SQLException {
        try {
            // Cargar el driver JDBC para MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");  // Asegúrate de tener el driver de MySQL configurado en tu proyecto

            // Establecer y devolver la conexión
            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException e) {
            // Si no se encuentra el driver de MySQL, lanzar una excepción SQL
            throw new SQLException("No se pudo encontrar el driver JDBC.", e);
        }
    }
}

    
    
    