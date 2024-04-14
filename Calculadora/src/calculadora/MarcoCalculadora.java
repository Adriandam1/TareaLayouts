/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora;

import javax.swing.*;

/**
 *
 * @author Adrian
 */
public class MarcoCalculadora extends JFrame {
    
    public MarcoCalculadora(){
    //Marco ventana de la calculadora con los tamaños requeridos
        setTitle("Calculadora");
        setBounds(500, 300, 450, 300);
        
        // despues del titulo y la constitucion creamos una instancia de lamina calculadora        
        LaminaCalculadora milamina = new LaminaCalculadora();
        // agregamos la lamina
        add (milamina);
        
        //Dar tamaño por defecto a los elementos contenedores:
        //pack(); la VENTANA se adaptaria el tamaño de sus conponentes en layout
        
}
    
}
