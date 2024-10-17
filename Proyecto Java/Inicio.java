import javax.swing.*;
import java.time.LocalDate;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class Inicio {
    public static void main(String[] args){

        //Declarar variables
        
        String opciones;
        LocalDate fechaIngreso;
        String nombre;
        String[] cargo = {"Administrador","Vendedor", "EncargadodeBodega"};

        
        //Obtener datos del usuario(nombre, cargo, fecha de ingreso )
        opciones = (String) JOptionPane.showInputDialog(null,
        "Bienvenido al inventario,por favor seleccione cual es su cargo.",
        "Opciones", JOptionPane.DEFAULT_OPTION,null,cargo, cargo[0]);
        fechaIngreso = LocalDate.now();
        System.out.println(fechaIngreso);

        nombre = JOptionPane.showInputDialog(null,"Ingrese su nombre.");
        System.out.println(nombre);

        if (nombre.isEmpty() || nombre.isBlank()){
        JOptionPane.showMessageDialog(null,"No ingreso ningun dato, ingreselo de nuevo.");
        nombre = JOptionPane.showInputDialog(null,"Ingrese su nombre", JOptionPane.ERROR_MESSAGE);
        System.out.println(nombre);  
        }
        

        //Guardar datos en archivo de texto
        File registroUsuario = new File ("Historial_de_movimientos.txt");

        try {
            FileWriter fw = new FileWriter(registroUsuario, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(opciones + " | " + nombre + " | "+ fechaIngreso + "\n");
            bw.close();
            
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo");

        }

        





    }
}
