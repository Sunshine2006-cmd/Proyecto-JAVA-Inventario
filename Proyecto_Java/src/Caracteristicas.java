
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Personal
 */
public class Caracteristicas {
    public static void main(String[] args) {

        String opciones = "";
        File archivo = new File("Caracteristicas.txt");
        File archivoCopia = new File("Caracteristicas_copia.txt");
        String caracteristica = "";
        String descripcion;
        String eliminar = "";
        String contenido;
        Boolean dato = false;
        String[] accion = { "Ver Características", "Agregar", "Eliminar", "Regresar a Inicio" };

        // Acciones a tomar(ver Características, agregar, modificar, eliminar, regresar)

        while (!opciones.equals(accion[3])) {
            opciones = (String) JOptionPane.showInputDialog(null,
                    "Características de productos. \n Por favor seleccione la acción que desea realizar.",
                    "Seleccione:", JOptionPane.DEFAULT_OPTION, null, accion, accion[0]);
                    if (opciones.equals(accion[0])) {
                        //Mostrar Contenido
                        try {
                            contenido = "";
                            FileReader fr = new FileReader(archivo);
                            BufferedReader br = new BufferedReader(fr);
                            JOptionPane.showMessageDialog(null, "Ver las características en la línea de comandos\n");
                            while ((contenido = br.readLine()) != null){
                                System.out.println(contenido);
          
                            }
                            br.close();
                        } catch (IOException ex) {
                            System.out.println("Error al leer el archivo");
                        }

                    // agregar característica
                    } else if (opciones.equals(accion[1])) {

                    // Evaluar nombre de la característica(en blanco o vacía )
                        do {
                            caracteristica = JOptionPane.showInputDialog(null,
                            "Ingrese un nombre que no este vacío o sea repetido",
                            JOptionPane.QUESTION_MESSAGE);
                        } while (caracteristica.isBlank() || caracteristica.isEmpty());

                        descripcion = JOptionPane.showInputDialog(null, "Ingrese una descripción (para omitir presione ok)",
                        JOptionPane.QUESTION_MESSAGE);

                    // agregar característica a archivo de texto
                        try {
                            FileWriter fw = new FileWriter(archivo, true);
                            BufferedWriter bw = new BufferedWriter(fw);
                            bw.write(caracteristica + " | " + descripcion + "\n");
                            bw.close();

                        } catch (IOException ex) {
                            System.out.println("Error al escribir en el archivo");
                        }                        

                    } else if(opciones.equals(accion[2])) {

                       // Pedir característica a eliminar
                        eliminar = (String) JOptionPane.showInputDialog(null, "¿Cuál categoría desea eliminar?",
                            "Escriba:", JOptionPane.ERROR_MESSAGE);

                        if (eliminar != null && !eliminar.isBlank()){
                            try {

                                // Leer el archivo principal y colocar los datos de este en una copia
                                FileReader fr = new FileReader(archivo);
                                BufferedReader br = new BufferedReader(fr);

                                FileWriter fw = new FileWriter(archivoCopia);
                                BufferedWriter bw = new BufferedWriter(fw);

                                    //Condiciones para que se elimine la característica

                                    while ((contenido = br.readLine()) != null) {
                                        String[] datos = contenido.split("\\|");

                                        if ((datos[0].trim().equalsIgnoreCase(eliminar.trim()))) {
                                            dato = true;
                                            
                                        }else{
                                            bw.write(contenido + "\n");
                                        }
                                    }

                                    br.close();
                                    bw.close();

                                    if (dato){
                                        archivo.delete();
                                        archivoCopia.renameTo(archivo);
                                        JOptionPane.showMessageDialog(null,"La característica se eliminará");
                                    }else{
                                        archivoCopia.delete(); 
                                        JOptionPane.showMessageDialog(null, "No se encontró la característica");

                                    }
                            } catch (IOException ex) {
                                System.out.println("Error al leer el archivo");
                            } 
                        }   
                    } else {
                        JOptionPane.showMessageDialog(null, "Regresará al inicio");
                    }

        }

    }
    
}
