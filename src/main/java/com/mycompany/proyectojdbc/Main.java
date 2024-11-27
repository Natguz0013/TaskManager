package com.mycompany.proyectojdbc;

public class Main {

    public static void main(String[] args) {
        // Insertar un nuevo empleado
        EmpleadoDAO.insertarEmpleado("Juan Pérez", 2500.50);

        // Consultar un empleado
        EmpleadoDAO.consultarEmpleado(1);

        // Actualizar un empleado
        EmpleadoDAO.actualizarEmpleado(1, "Juan Pérez", 3000.00);

        // Eliminar un empleado
        EmpleadoDAO.eliminarEmpleado(1);
    }
}
