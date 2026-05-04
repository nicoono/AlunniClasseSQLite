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

    public ArrayList<String> leggiClassi(){
        ArrayList<String> classi = new ArrayList<>();
            try (Connection conn = DriverManager.getConnection(url);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM classi")) {
             
            while (rs.next()) {             
                classi.add(rs.getString("id_classe") + " - " + rs.getString("indirizzo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            return classi;
        }
    
    public ArrayList<String> leggiStudenti(String stringaDallaCombo) {
        ArrayList<String> studenti = new ArrayList<>();
        
        // 1. Estraiamo l'ID (es. "3D") dalla stringa intera (es. "3D - Informatica")
        String idClasseCercato = stringaDallaCombo.split(" - ")[0];

        // 2. Query ottimizzata: chiediamo al DB solo gli alunni di quella classe
        String query = "SELECT nome, cognome FROM alunni WHERE id_classe = ?";
        
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement ps = conn.prepareStatement(query)) {
           
            // Sostituiamo il "?" della query con l'ID pulito
            ps.setString(1, idClasseCercato);
            
            try (ResultSet rs = ps.executeQuery()) {
                while(rs.next()){
                    studenti.add(rs.getString("nome") + " " + rs.getString("cognome"));
                }
            }
            
            // Se la lista è rimasta vuota dopo la query
            if (studenti.isEmpty()) {
                studenti.add("Nessun alunno trovato per questa classe.");
            }
            
        } catch (Exception e) {
            System.err.println("Errore durante la lettura degli studenti: " + e.getMessage());
            e.printStackTrace();
        }
        return studenti;
    }
  
    
    public void leggiPrtecipazioneGita (){
        System.out.println("elenco degli alunni che partecipano ad  una gita:");
        try (Connection conn = DriverManager.getConnection(url);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT alunni.nome, alunni.cognome, gite.destinazione, gite.prezzo, partecipanti.pagato " +
                                            "FROM alunni " +
                                            "JOIN partecipanti ON alunni.id_alunno = partecipanti.id_alunno " +
                                            "JOIN gite ON partecipanti.id_gita = gite.id_gita")){
            while (rs.next()) {
            String nome = rs.getString("nome");
            String cognome = rs.getString("cognome");
            String destinazione = rs.getString("destinazione");
            double prezzo = rs.getDouble("prezzo");
            int pagato = rs.getInt("pagato");
            String pagatoTesto=" ";
            if(pagato == 1){
                pagatoTesto = "SI";
            }
            else{
                pagatoTesto = "NO";
            }
            System.out.println(nome + " - " + cognome + " - " +  destinazione + " - " + prezzo + " - " + pagatoTesto);
        }
        }
        catch (Exception e) {
            System.err.println("Errore durante la lettura: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
}
