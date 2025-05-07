package controlador;

import vista.VistaRanking;
import interfaces.Controlador;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class ControladorRanking implements Controlador {

    private static final String RUTA_ARCHIVO = "ranking.txt";
    private JFrame ventana;
    private VistaRanking vista;
    private static List<String> todasLasEntradas = new ArrayList<>();

    public ControladorRanking(JFrame ventana) {
        this.ventana = ventana;
        this.vista = new VistaRanking();
        cargarRanking();
    }

    @Override
    public void inicializar() {
        ventana.setContentPane(vista);
        ventana.revalidate();
        ventana.repaint();

        mostrarTop5();

        vista.getBtnVolver().addActionListener(e -> {
            ControladorMenu menu = new ControladorMenu(ventana);
            menu.inicializar();
        });
    }

    public static void guardarPuntuacion(String nombre, int puntos) {
        if (nombre.length() > 3) nombre = nombre.substring(0, 3);
        String entrada = nombre.toUpperCase() + " - " + puntos;
        todasLasEntradas.add(entrada);
        guardarArchivo();
    }

    private static void guardarArchivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_ARCHIVO))) {
            for (String s : todasLasEntradas) {
                bw.write(s);
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar ranking: " + e.getMessage());
        }
    }

    private void cargarRanking() {
        todasLasEntradas.clear();
        File archivo = new File(RUTA_ARCHIVO);
        if (!archivo.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                todasLasEntradas.add(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer ranking: " + e.getMessage());
        }
    }

    private void mostrarTop5() {
        List<String> top = obtenerTop5();
        StringBuilder sb = new StringBuilder("TOP 5:\n");
        for (int i = 0; i < top.size(); i++) {
            sb.append((i + 1)).append(". ").append(top.get(i)).append("\n");
        }
        vista.getAreaRanking().setText(sb.toString());
    }

    private static List<String> obtenerTop5() {
        List<String> copia = new ArrayList<>(todasLasEntradas);
        copia.sort((a, b) -> {
            int puntosA = Integer.parseInt(a.split(" - ")[1]);
            int puntosB = Integer.parseInt(b.split(" - ")[1]);
            return Integer.compare(puntosB, puntosA);
        });
        return copia.subList(0, Math.min(5, copia.size()));
    }

    public static boolean entraEnTop(int nuevaPuntuacion) {
        List<String> copia = new ArrayList<>(todasLasEntradas);
        copia.sort((a, b) -> {
            int puntosA = Integer.parseInt(a.split(" - ")[1]);
            int puntosB = Integer.parseInt(b.split(" - ")[1]);
            return Integer.compare(puntosB, puntosA);
        });

        if (copia.size() < 5) return true;
        for (String entrada : copia.subList(0, 5)) {
            int puntosExistente = Integer.parseInt(entrada.split(" - ")[1]);
            if (nuevaPuntuacion > puntosExistente) return true;
        }
        return false;
    }

    public static String obtenerTopFormateado() {
        List<String> top = obtenerTop5();
        StringBuilder sb = new StringBuilder("TOP 5:\n");
        for (int i = 0; i < top.size(); i++) {
            sb.append((i + 1)).append(". ").append(top.get(i)).append("\n");
        }
        return sb.toString();
    }
}
