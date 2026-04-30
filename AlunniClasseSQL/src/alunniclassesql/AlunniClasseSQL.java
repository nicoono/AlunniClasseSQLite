/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package alunniclassesql;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author onorati.nicolo
 */
public class AlunniClasseSQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Interfaccia i = new Interfaccia();
        i.setVisible(true);
        
        Gestore g = new Gestore();
        g.leggiClassi();
        ArrayList<String> listaClassi = g.leggiClassi();
        for (String classe : listaClassi) {
            System.out.println("- " + classe);
        }
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Inserisci classe: ");
         String classe = sc.nextLine();
        
        
        ArrayList<String> listaStudenti = g.leggiStudenti(classe);
    
        System.out.println("Studenti della classe " + classe + ":");
    
        for (String studente : listaStudenti) {
            System.out.println("- " + studente);
        }
        sc.close();
        
        g.leggiPrtecipazioneGita();
    }
}   
