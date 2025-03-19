/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.n22dccn045;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class App {

    public static void main(String[] args) {
//        DatabaseHelper.getConnection();
//        test();
//        System.out.println("Hello World!");
        new fStudent().setVisible(true);
    }

    private static void test() {
        try {

            var con = DatabaseHelper.getConnection();
            String sql = "SELECT * FROM sys.tables";

            var ptmt = con.prepareStatement(sql);
            var rs = ptmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
