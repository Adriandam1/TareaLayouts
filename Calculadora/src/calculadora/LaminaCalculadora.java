/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Adrian
 */

// 
public class LaminaCalculadora extends JPanel{
    
    // EN ESTA CLASE CREO LA PANTALLA DONDE SE HARAN LAS OPERACIONES
    
    public LaminaCalculadora(){
        //Fijaos el booleano principio a true para que se cumpla la condicion del IF de InsertaNumero
        principio=true;
        
        setLayout(new BorderLayout());
        
        pantalla = new JButton("0");
        
        // deshabilitamos la pantalla para que no actue como un boton
        pantalla.setEnabled(false);
        
        add (pantalla,BorderLayout.NORTH);
        
        
        //-------- Parte de abajo de la calculadora donde los botones
        //Como ya tenemor milamina2 declarada fuera solo tenemos que iniciarla
        milamina2 = new JPanel();
        
        milamina2.setLayout(new GridLayout(4,4));  
        
        /*// Creacion manual de los botones(esta bien pero es una maraña de codigo)
        JButton boton1 = new JButton("1");
        // Añadimos el boton a lamina2
        milamina2.add(boton1);
        //Copy pasteo el creado y añadido boton:
        JButton boton2 = new JButton("2");
        milamina2.add(boton2);        
        ...
        */
        
        ActionListener insertar = new InsertaNumero();
        
        ActionListener orden = new AccionOrden();
        
        //Creacion de botones con el metodo ponerboton (add rellena de fila en fila izq a derecha)
        ponerBoton("7", insertar);
        ponerBoton("8", insertar);
        ponerBoton("9", insertar);
        ponerBoton("/",orden);
        ponerBoton("4",insertar);
        ponerBoton("5",insertar);
        ponerBoton("6",insertar);
        ponerBoton("*",orden);
        ponerBoton("1",insertar);
        ponerBoton("2",insertar);
        ponerBoton("3",insertar);
        ponerBoton("-",orden);
        ponerBoton("0",insertar);
        ponerBoton(".",insertar);
        ponerBoton("=",orden);
        ponerBoton("+",orden);
        
        
        
        // Habria que agregar esta segunda lamina a la lamina1 en ves de agregar botoners
        // ponemos center por que en el north esta la pantalla
        add(milamina2, BorderLayout.CENTER);       
        
        ultimaOperacion="=";
    }
    
    // Metodo que pone botones y los pone a la escucha
    private void ponerBoton(String rotulo, ActionListener oyente){
        
        JButton boton = new JButton(rotulo);
        
        //pone el boton a la escucha de un evento ActionListener
        boton.addActionListener(oyente);
        
        milamina2.add(boton);
    }
    
    private class InsertaNumero implements ActionListener {
    // esta clase pone a los botones de la lamina en escucha
        @Override
        public void actionPerformed(ActionEvent e) {
            //Almacenamos en la variable entrada el texto del boton pulsado
            String entrada = e.getActionCommand();
        
            //En caso de que principio, la variable booleana sea true nos borre la pantalla y nos lo pone en false
            //el booleano esta en true y lo cambiamos a flase, esto solo se hara la primera vez que introduzcamos un parametro
            if (principio){
                pantalla.setText("");
                
                principio= false;
            }
            
            //Hacemos que el display en la pantalla aparezca ese texto
            pantalla.setText(pantalla.getText() + entrada);
         }  
    }  
    private class AccionOrden implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            
            String operacion=e.getActionCommand();
            
            //lamada a metodo calcular
            calcular(Double.parseDouble(pantalla.getText()));
            
            ultimaOperacion = operacion;
            //cambiamos booleano a true para que nos salte el if de insertar numero y asi limpiar la pantalla
            principio = true;
         }       
        public void calcular(double x){
            
            //si la ultima operacion es + almacenamos el + al resultado
            if (ultimaOperacion.equals("+")){
                resultado +=x;
            }
            else if (ultimaOperacion.equals("-")){
                resultado-=x;
            }
            else if (ultimaOperacion.equals("*")){
                resultado*=x;
            }
            else if (ultimaOperacion.equals("/")){
                resultado/=x;
            }            
            //else if para arreglar que pusimos resultado = al principio
            else if (ultimaOperacion.equals("=")){
                resultado=x;
            }
            //como resultado es una variable doble tenemos que ponerle 2 valores, "" y resultado
            pantalla.setText(""+resultado);
        
        }     
    }
   
    

    
    //Declaramos la segunda lamina FUERA DEL CONTRUCTOR para que la puedan utilizar todos los metodos
    // como por ejemplo ponerboton
    private JPanel milamina2;
    
    private JButton pantalla;
    
    private boolean principio;
    
    //variable para almacenar el resultado de las operaciones
    private double resultado;
    
    private String ultimaOperacion;
}
