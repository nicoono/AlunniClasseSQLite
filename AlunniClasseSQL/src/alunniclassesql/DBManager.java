/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alunniclassesql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author onorati.nicolo
 */
public class DBManager {
    private static final String URL = "jdbc:sqlite:scuola.db";

    // Questo metodo serve solo a "aprire il rubinetto"
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
