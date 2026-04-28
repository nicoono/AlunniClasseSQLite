/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alunniclassesql;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author onorati.nicolo
 */
public class Gestore {
    
    private String url = "jdbc:sqlite:scuola.db";

    public void leggiClassi(){
            try (Connection conn = DriverManager.getConnection(url);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM classi")) {
             
            while (rs.next()) {
                System.out.println(
                    rs.getString("id_classe") + " - " + 
                    rs.getString("indirizzo")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    
    public ArrayList<String> leggiStudenti(String idClasse) {
        ArrayList<String> studenti = new ArrayList<>();
        
        try (Connection conn = DriverManager.getConnection(url);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT nome, cognome, id_classe FROM alunni")) {
           
            while(rs.next()){
                if(rs.getString("id_classe").equals(idClasse)) {
                    studenti.add(rs.getString("nome") + " " + rs.getString("cognome"));
                }
            }
            
        } catch (Exception e) {
            System.err.println("Errore durante la lettura degli studenti: " + e.getMessage());
            e.printStackTrace();
        }
        return studenti;
    }
    
    
}
