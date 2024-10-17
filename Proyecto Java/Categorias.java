import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class Categorias {
    public static void main(String[] args) {

        String opciones = "";
        File archivo = new File("Categorias.txt");
        String categoria = "";
        String descripcion;
        String contenido;
        boolean condicion = false;
        String[] accion = { "VerCategorias", "Agregar", "Modificar", "Eliminar", "Regresar" };

        // Acciones a tomar(ver categorias, agregar, modificar, eliminar, regresar)

        while (!opciones.equals(accion[4])) {
            opciones = (String) JOptionPane.showInputDialog(null,
                    "Categorías de productos. \n Por favor seleccione lo que desea.\n",
                    "Seleccione:", JOptionPane.DEFAULT_OPTION, null, accion, accion[0]);

            if (opciones.equals(accion[0])) {

                // agregar categoria
            } else if (opciones.equals(accion[1])) {

                // Leer archivo
                try {
                    contenido = "";
                    FileReader fr = new FileReader(archivo);
                    BufferedReader br = new BufferedReader(fr);
                    while ((contenido = br.readLine()) != null) {
                        
                    }

                } catch (Exception e) {
                    System.out.println("Error al leer el archivo");
                }

                // Evaluar nombre de la categoria(en blanco, vacia o repetida)

                do 
                {
                    categoria = JOptionPane.showInputDialog(null,
                            "Ingrese un nombre que no sea repetido o que este vacio",
                            JOptionPane.QUESTION_MESSAGE); 
                            System.out.println(contenido);
                            condicion = (contenido.contains(categoria));       
                }
                while (categoria.isBlank() || categoria.isEmpty() || condicion );

                descripcion = JOptionPane.showInputDialog(null, "Ingrese una descripcion (para omitir presione ok)",
                        JOptionPane.QUESTION_MESSAGE);

                // agregar categoria a archivo de texto
                try {
                    FileWriter fw = new FileWriter(archivo, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(categoria + " | " + descripcion + "\n");
                    bw.close();

                } catch (IOException ex) {
                    System.out.println("Error al escribir en el archivo");
                }

            } else if (opciones.equals(accion[2])) {
                JOptionPane.showMessageDialog(null, "Cual categoria desea modificar");

            } else if (opciones.equals(accion[3])) {
                JOptionPane.showMessageDialog(null, "Cual categoria desea eliminar");

            } else {
                JOptionPane.showMessageDialog(null, "Regresar");
            }

        }

    }
}
