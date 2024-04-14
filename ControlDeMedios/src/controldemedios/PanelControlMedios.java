/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controldemedios;

import java.awt.*;
import javax.swing.*;


/**
 *
 * @author Adrian
 */
public class PanelControlMedios extends JFrame {
    public PanelControlMedios() {
        // Configuración de la ventana principal
        setTitle("Panel de Control de Medios");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        
        // Panel de controles de reproducción
        JPanel panelControles = new JPanel();
        panelControles.setLayout(new BoxLayout(panelControles, BoxLayout.X_AXIS));
        JButton btnPlay = new JButton("Play");
        JButton btnPause = new JButton("Pause");
        JButton btnStop = new JButton("Stop");
        panelControles.add(btnPlay);
        panelControles.add(btnPause);
        panelControles.add(btnStop);
        
        // Teclado numérico de selección rápida
        JPanel panelTeclado = new JPanel();
        panelTeclado.setLayout(new GridLayout(4, 3));
        for (int i = 1; i <= 9; i++) {
            JButton btnNumero = new JButton(String.valueOf(i));
            panelTeclado.add(btnNumero);
        }
        
        // no se si hace falta el cero, pero asi queda centrado
        panelTeclado.add(new JLabel()); // Espacio en blanco
        JButton botonCero = new JButton("0");
        panelTeclado.add(botonCero);
        panelTeclado.add(new JLabel()); // Espacio en blanco
        
        // Diseño general con BorderLayout
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panelControles, BorderLayout.SOUTH);
        getContentPane().add(panelTeclado, BorderLayout.CENTER);
        
        // Barra de progreso
        JProgressBar progressBar = new JProgressBar();
        getContentPane().add(progressBar, BorderLayout.NORTH);
        
        setVisible(true);
    }
}