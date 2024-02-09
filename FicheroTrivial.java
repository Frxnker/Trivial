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

            pregunta = f.readUTF();
            respuesta = f.readUTF();
            int idPregunta = f.readInt();

            f.close();
            resultado = 0;
        }
        catch (Exception e) {
            resultado = -1;
            e.printStackTrace();
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
}