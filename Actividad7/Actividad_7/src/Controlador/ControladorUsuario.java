/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


public class ControladorUsuario {
    
    // aqui vamos a tener que va hacer el usuario el tipo de operaciones 
    
    public static double suma(int a, int b){
        return a + b;
    }
    
    public static double resta(int n1, int n2){
        return n1 - n2;
    } 
    
    public static double division(int div1, int div2){
        try{
            return div1 / div2;
            
        }catch(ArithmeticException e){
            System.err.println("Erro division 0" + e);
            
        }
        
        return 0000000000000000000;
    }
    
    
    public static double multplicacion(int mul1, int mul2){
        return mul1 * mul2;
    }
    
    
    
    
    
    
}
