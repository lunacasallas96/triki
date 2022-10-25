/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.triki;

import java.util.Scanner;

/**
 *
 * @author luna_
 */
public class Triki {

    public static void main(String[] args) {
           Scanner entrada = new Scanner(System.in); // crear un objeto Scanner

        System.out.println("Hola jugador 1, ingresa tu nombre: ");

        String nombreUno = entrada.nextLine();

        System.out.println("Hola jugador 2, ingresa tu nombre: ");

        String nombreDos = entrada.nextLine();

        System.out.println("Los jugadores son los siguientes Jugador 1:" + nombreUno + "\n" + " Jugador 2" + nombreDos);

        System.out.println(nombreUno + " con que figura desaeas jugar ? X ó O ");

        String figuraUno = entrada.nextLine();
        String figuraDos = "Default";

        if (figuraUno.equals("X")) {
            figuraDos = "O";
        }
        if (figuraUno.equals("O")) {
            figuraDos = "X";
        }

        System.out.println(nombreUno + " Jugara con la figura: " + figuraUno
                + "\n El jugador dos jugara con la figura: " + figuraDos);

        String[][] juego = { { "-", "-", "-" }, { "-", "-", "-" }, { "-", "-", "-" } };
        int cont = 0;
        int Pv = 0;
        int Ph = 0;
        int Ganador = 0;
        int valGuardado = 0;
        String nombreJugador = "";
        String figuraJugador = "";

        while (Ganador == 0) {
        if (cont % 2 == 0){
             nombreJugador = nombreUno;
             figuraJugador = figuraUno;
        }else{
             nombreJugador = nombreDos;
             figuraJugador = figuraDos;
        }
        System.out.println(nombreJugador + " Elije posicion vertical");
        Pv = entrada.nextInt() - 1;
        System.out.println(nombreJugador + " Elije posicion Horizontal");
        Ph = entrada.nextInt() - 1;
        System.out.println(nombreJugador + " posicion " + Pv + "-" + Ph);
        
        valGuardado = ValidarGuardar(juego,Pv,Ph);
        
        if(valGuardado == 1){
            juego[Pv][Ph] = figuraJugador;  
            ImprimirJuego(juego);
            cont = cont+1;
            Ganador = ValidarGanador(juego, figuraJugador);
            if(Ganador == 1){
                System.out.println(nombreJugador + " FELICITACIONES ERES EL GANADOR.!!!!!");
            }
            if(Ganador == 3){
                System.out.println(" EMPATE, intenta con otro juego.!!");
                Ganador = 3;
            }
        }
        if(valGuardado == 0){
            System.out.println("Esa posicion ya esta ocupada, elije otra.");
        }
        if(valGuardado == 2){
            System.out.println("Poscion no valida, elije otra.");
        }
        
        }
       
    }
    
    public static int ValidarGanador(String[][] juego, String figura){
        
        int ganador = 0;
        int cont = 0;
        int contEmpate = 0;
        //validar ganador horizontal
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(juego[i][j].equals(figura)){
                    cont = cont + 1 ;
                }
                if(cont == 3){
                    ganador = 1;
                    return ganador;
                }
            }
            cont = 0;
        }
        //validar ganador vertical
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(juego[j][i].equals(figura)){
                    cont = cont + 1 ;
                }
                if(cont == 3){
                    ganador = 1;
                    return ganador;
                }
            }
            cont = 0;
        }
        //validar ganador diagonal 1
        for(int i = 0; i < 3; i++){
            
            if(juego[i][i].equals(figura)){
                cont = cont + 1 ;
            }
            if(cont == 3){
                ganador = 1;
                return ganador;
            }
           
        }
        cont = 0;
         //validar ganador diagonal 1
        for(int i = 0; i < 3; i++){
            int j = 0;
            switch (i){
                case 0:
                   j = 2;
                   break;
                case 1:
                   j = 1;
                   break;
                case 2:    
                   j = 0;
                   break;
            }
            if(juego[i][j].equals(figura)){
                cont = cont + 1 ;
            }
            if(cont == 3){
                ganador = 1;
                return ganador;
            }
           
        }
        cont = 0;
        //validar empate
        for(int i = 0; i < 3; i++){
           for(int j = 0; j < 3; j++){
             if(!"-".equals(juego[i][j])){
                contEmpate = contEmpate + 1;
                if(contEmpate == 9){
                    ganador = 3;
                    return ganador;
                }
             }      
           }
        }
        return 0;
    }
    
    public static int ValidarGuardar(String[][] juego, int i, int j){
        
        int resultado = 0;
        if(i > 3 || i < 0 || j > 3 || j < 0 ){
            resultado = 2;
        }else {
            if(juego[i][j].equals("-")){
                resultado = 1;
            }else{
                resultado = 0;
            }   
        }
        
        
        return resultado;
    }
    
    public static String ImprimirJuego(String[][] juego){
        
          for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 0) {
                    System.out.print(juego[i][j]);
                }
                if (i == 1) {
                    if (j == 0) {
                        System.out.print("\n");
                    }
                    System.out.print(juego[i][j]);
                }
                if (i == 2) {
                    if (j == 0) {
                        System.out.print("\n");
                    }
                    System.out.print(juego[i][j]);
                }

            }
        }
        System.out.print("\n");
        return null;
    }
    
}
