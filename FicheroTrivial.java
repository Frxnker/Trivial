import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.io.File;

public class FicheroTrivial {

    /*
     * Creamos un método guardar, que nos guardará las preguntas y respuestas
     * en un fichero binario
     */
    public int guardar(int id, String pregunta, String respuesta) {
        int resultado;
        try {
            RandomAccessFile f = new RandomAccessFile("Trivial.bin", "rw");
            f.seek(f.length());
            f.writeInt(id);
            f.writeUTF(pregunta);
            f.writeUTF(respuesta);

            f.close();
            resultado = 0;
        }
        catch (Exception e) {
            resultado = -1;
            e.printStackTrace();
            System.out.println("No se ha podido guardar");
        }
        return resultado;
    }
    
    /*
     * Creamos un método mostrar, 
     * que nos mostrará las preguntas y respuestas
     */
    public String[] mostrar() {
        String[] datos = new String[40];
        try {
            File f = new File("Trivial.bin");
            if (!f.exists()) {
                System.out.println("Creando...");
                return datos;
            }
            Scanner s = new Scanner(f);
            int i = 0;
            while (s.hasNextLine()) {
                String linea = s.nextLine();
                String[] partes = linea.split(";");
                for (int j = 0; j < partes.length; j++) {
                    datos[i] = partes[j];
                    i++;
                }
            } s.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return datos;
    }

    /*
     * Creamos un método modificar,
     * que nos permitirá modificar las preguntas y respuestas
     */
    public void modificar (String pregunta, String respuesta) {
        int resultado;
        try {
            FileWriter f = new FileWriter("Trivial.bin", true);
            f.write(pregunta + ";" + respuesta + "\n");
            f.close();
            resultado = 0;
        }
        catch (Exception e) {
            resultado = -1;
            e.printStackTrace();
        }
    }

    /*
     * Creamos un método buscar,
     * que nos buscará las preguntas que le pidamos
     */
    public void buscar (int id) {
        try {
            File f = new File("Trivial.bin");
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String linea = s.nextLine();
                String[] partes = linea.split(";");
                if (Integer.parseInt(partes[0]) == id) {
                    System.out.println(partes[0] + " " + partes[1] + " " + partes[2]);
                }
            } s.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void azar() {
        try {
            File f = new File("Trivial.bin");
            Scanner s = new Scanner(f);
            int num = (int) (Math.random() * 10);
            for (int i = 0; i < num; i++) {
                String linea = s.nextLine();
                String[] partes = linea.split(";");
                System.out.println(partes[0] + " " + partes[1] + " " + partes[2]);
            } s.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}