/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Calculadora;
import Modelo.Usuario;
import Vista.VentanaCalculadora;
import javax.swing.JOptionPane;


public class ControladorUsuario {
    
    //el controlador es el intemedario de lo que hace el Usuario y la vista 
    
    private String numero_1; 
    private String numero_2;
    private String numero_temporal = ""; 
    private Double resultado; 
    private String opera; 
    static Calculadora u = new Calculadora();
    
    
    public String obtenerNumero(String num){
         return numero_temporal += num; // concatenamos los numeros  hasta que el usuario pueda colocar una operacion
        
    }
    
    public void operacionAritmetica(String operacion){
        //vamos a obtener el primer numero 
        numero_1 = numero_temporal; 
        //limpiamos el numero temporal 
        numero_temporal = "";
        
        //guardamos la opeeracion en nuestro atributo 
        opera = operacion;  
    }
    
    
    public void calcularResultado(){
        numero_2 = numero_temporal; 
        
        if(numero_1.isEmpty() || numero_2.isEmpty()){
            JOptionPane.showMessageDialog(null, "Operacion Incompleta");
            return;  
        }
        
        if(numero_1 == null || numero_2 == null){
            JOptionPane.showMessageDialog(null, "Valores Null");
            return;
        }
        
        try{
            double n1 = Double.parseDouble(numero_1);
            double n2 = Double.parseDouble(numero_2); 
            
            switch (opera) {
            
            case "+":
                resultado = u.sumar(n1, n2);
                break;
            case "-":
                resultado = u.restar(n1, n2);
                break;
            case "*":
                resultado = u.multiplicar(n1, n2);
                break;
            case "/":
                resultado = u.dividir(n1, n2);
                break;
               
        }
        
        numero_temporal = "";
            
        }catch(NullPointerException e){
            
        }
        
        
       
        
        
        
    }

    public void setNumero_temporal(String numero_temporal) {
        this.numero_temporal = numero_temporal;
    }
    
    
  
   
    public String getNumero_1() {
        return numero_1;
    }

    public String getNumero_2() {
        return numero_2;
    }

    public String getNumero_temporal() {
        return numero_temporal;
    }

    public double getResultado() {
        return resultado;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
 
    
    
    
    
    
}
