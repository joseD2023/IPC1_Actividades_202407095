/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import javax.swing.JOptionPane;


public class Calculadora {
    
      //operaciones que puede hacer el usuario 
   
    
    public double sumar(double a, double b){

        return a + b; 
    }
    
    public double restar(double c, double d){
        return c - d; 
    }
    
    public double multiplicar(double e, double f){
        return e*f; 
    }
    
    public double dividir(double g, double h){
       try{
           
           if (h == 0) {  // verificamos antes de dividir
            JOptionPane.showMessageDialog(null, "Error: División entre 0");
            return 0;  // o cualquier valor que indique error
        }
        return g / h;  // si no es cero, hacemos la división
           
       }catch(ArithmeticException e){
           JOptionPane.showMessageDialog(null, "Erro Division entre 0");
           return 0000000000000000000000000000000000000000000000;
           
       }
      
       
    }
    
    
}
