package com.mycompany.proyectojdbc;

import java.sql.*;

public class EmpleadoDAO {

    // Método para insertar un nuevo empleado en la base de datos
    public static void insertarEmpleado(String nombre, double salario) {
        String query = "INSERT INTO empleados (nombre, salario) VALUES (?, ?)";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {

            pst.setString(1, nombre);
            pst.setDouble(2, salario);
            pst.executeUpdate();
            System.out.println("Empleado insertado correctamente.");

        } catch (SQLException e) {
            System.err.println("Error al insertar empleado: " + e.getMessage());
        }
    }

    // Método para consultar un empleado por su ID
    public static void consultarEmpleado(int id) {
        String query = "SELECT * FROM empleados WHERE id = ?";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("nombre");
                double salario = rs.getDouble("salario");
                System.out.println("Empleado: " + nombre + ", Salario: " + salario);
            } else {
                System.out.println("Empleado no encontrado.");
            }

        } catch (SQLException e) {
            System.err.println("Error al consultar empleado: " + e.getMessage());
        }
    }

    // Método para actualizar los datos de un empleado
    public static void actualizarEmpleado(int id, String nombre, double salario) {
        String query = "UPDATE empleados SET nombre = ?, salario = ? WHERE id = ?";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {

            pst.setString(1, nombre);
            pst.setDouble(2, salario);
            pst.setInt(3, id);
            pst.executeUpdate();
            System.out.println("Empleado actualizado correctamente.");

        } catch (SQLException e) {
            System.err.println("Error al actualizar empleado: " + e.getMessage());
        }
    }

    // Método para eliminar un empleado de la base de datos
    public static void eliminarEmpleado(int id) {
        String query = "DELETE FROM empleados WHERE id = ?";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {

            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Empleado eliminado correctamente.");

        } catch (SQLException e) {
            System.err.println("Error al eliminar empleado: " + e.getMessage());
        }
    }
}
