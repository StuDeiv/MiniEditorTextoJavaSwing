/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minieditortextojavaswing;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author dsantosc04
 */
public class LogicaEditorTexto {

    private VentanaPrincipal ventanaPrincipal;
    private File archivo;

    public LogicaEditorTexto(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }

    public void pasarJTextAreaFichero() {
        File fichero = ventanaPrincipal.getArchivo();
        String cadena = leerTextArea();
        System.out.println(cadena);

        try {
            FileOutputStream fos = new FileOutputStream(fichero);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            bw.write(cadena);
            bw.newLine();

            bw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LogicaEditorTexto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LogicaEditorTexto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void pasarFicheroAJTextArea() {

        File fichUsers = ventanaPrincipal.getArchivo();
        String lineaFichero = "";
        String lineaTextArea = "";
        JTextArea textAreaPrincipal = ventanaPrincipal.getjTextAreaTexto();
        try {
            FileReader lector = new FileReader(fichUsers);
            BufferedReader br = new BufferedReader(lector);

            while ((lineaFichero = br.readLine()) != null) {
                //Cogemos la linea (usuario:contraseña) y separamos ambos
                lineaTextArea += lineaFichero + "\n";
            }
            textAreaPrincipal.setText(lineaTextArea);

            //Cerramos flujo
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String leerTextArea() {
        JTextArea textAreaPrincipal = ventanaPrincipal.getjTextAreaTexto();
        String palabrasTextArea = textAreaPrincipal.getText();

        return palabrasTextArea;

    }

    public void aumentarTamanioLetra() {
        
        JTextArea textAreaPrincipal = ventanaPrincipal.getjTextAreaTexto();
        String fuente = textAreaPrincipal.getFont().getFontName();
        int tamanio = (int) ventanaPrincipal.getjSlider1().getValue();
        Font font = new Font("Tahoma", Font.PLAIN, tamanio);
        textAreaPrincipal.setFont(font);

    }

}
