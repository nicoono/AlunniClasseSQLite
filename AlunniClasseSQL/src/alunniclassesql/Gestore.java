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

    public ArrayList<String> leggiClassi() {
        ArrayList<String> classi = new ArrayList<>();
        try (Connection conn = DBManager.getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM classi")) {

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
        String idClasseCercato = stringaDallaCombo.split(" - ")[0];

        String query = "SELECT id_alunno, nome, cognome FROM alunni WHERE id_classe = ?";

        try (Connection conn = DBManager.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, idClasseCercato);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {

                    studenti.add(rs.getInt("id_alunno") + " - " + rs.getString("nome") + " " + rs.getString("cognome"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studenti;
    }

    public ArrayList<String[]> leggiPartecipazioneGita() {
    ArrayList<String[]> partecipanti = new ArrayList<>();
    
    String query = "SELECT alunni.id_alunno, alunni.nome, alunni.cognome, gite.destinazione, gite.prezzo, partecipanti.pagato "
                 + "FROM alunni "
                 + "JOIN partecipanti ON alunni.id_alunno = partecipanti.id_alunno "
                 + "JOIN gite ON partecipanti.id_gita = gite.id_gita";

    try (Connection conn = DBManager.getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(query)) {
         
        while (rs.next()) {
            String idAlunno = String.valueOf(rs.getInt("id_alunno"));
            String nome = rs.getString("nome");
            String cognome = rs.getString("cognome");
            String destinazione = rs.getString("destinazione");
            String prezzo = String.valueOf(rs.getDouble("prezzo"));
            
            int pagato = rs.getInt("pagato");
            String pagatoTesto = " ";
            
            if (pagato == 1) {
                pagatoTesto = "SI";
            } else {
                pagatoTesto = "NO";
            }
            
            String[] riga = {nome, cognome, idAlunno, destinazione, prezzo, pagatoTesto};
            partecipanti.add(riga);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return partecipanti;
    }
    
    public boolean aggiungiAlunno(String nome, String cognome, String idClasse) {

        String query = "INSERT INTO alunni (nome, cognome, id_classe) VALUES (?, ?, ?)";

        try (Connection conn = DBManager.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, nome);
            ps.setString(2, cognome);
            ps.setString(3, idClasse);

            int righeInserite = ps.executeUpdate();
            return righeInserite > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean rimuoviAlunno(int idAlunno) {
        String query = "DELETE FROM alunni WHERE id_alunno=?";
        try (Connection conn = DBManager.getConnection(); 
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, idAlunno);

            int righeCancellate = ps.executeUpdate();

            return righeCancellate > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean aggiornaAlunno(int idAlunno, String nuovoNome, String nuovoCognome) {
        String query = "UPDATE alunni SET nome = ?, cognome = ? WHERE id_alunno = ?";
        try (Connection conn = DBManager.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, nuovoNome);
            ps.setString(2, nuovoCognome);
            ps.setInt(3, idAlunno);

            int righeAggiornate = ps.executeUpdate();

            return righeAggiornate > 0;
        } catch (Exception e) {
            System.err.println("Errore durante l'aggiornamento: " + e.getMessage());
            e.printStackTrace();
            return false;
        }

    }
    
    
    public boolean rimuoviPartecipazioneGita(String nome, String cognome, String destinazione) {
        String query = "DELETE FROM partecipanti WHERE id_alunno = ("
                     + "  SELECT id_alunno FROM alunni WHERE nome = ? AND cognome = ?"
                     + ") AND id_gita = ("
                     + "  SELECT id_gita FROM gite WHERE destinazione = ?"
                     + ")";
                     
        try (Connection conn = DBManager.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, nome);
            ps.setString(2, cognome);
            ps.setString(3, destinazione);
            
            int righeCancellate = ps.executeUpdate();
            return righeCancellate > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
