/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.n22dccn045;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class StudentsDAO implements DAOInterface<Students, String >{

    @Override
    public boolean save(Students t) {
         try {
            var con = DatabaseHelper.getConnection();
            String sql = "INSERT INTO Students(LastName, FirstName, ClassID, ClassName, PhoneNumber, Email, StudentID) VALUES (?, ?, ?, ?, ?, ?, ?)";

            var ptmt = con.prepareStatement(sql);
            ptmt.setString(1, t.getHoLot());
            ptmt.setString(2, t.getTen());
            ptmt.setString(3, t.getMaLop());
            ptmt.setString(4, t.getTenLop());
            ptmt.setString(5, t.getSoDT());
            ptmt.setString(6, t.getEmail());
            ptmt.setString(7, t.getMaSV());


            return  ptmt.executeUpdate() >  0 ;
            
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;        


    }

    @Override
    public boolean delete(String id) {
         try {
            var con = DatabaseHelper.getConnection();
            String sql = "DELETE FROM Students WHERE StudentID  = ?";

            var ptmt = con.prepareStatement(sql);
            ptmt.setString(1, id);


            return  ptmt.executeUpdate() >  0 ;
            
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;  
    }

    @Override
    public boolean update(Students t) {
         try {
            var con = DatabaseHelper.getConnection();
            String sql = "UPDATE Students SET LastName=?, FirstName=?, ClassID=?, ClassName=?, PhoneNumber=?, Email=? WHERE StudentID = ? ";

            var ptmt = con.prepareStatement(sql);
            ptmt.setString(1, t.getHoLot());
            ptmt.setString(2, t.getTen());
            ptmt.setString(3, t.getMaLop());
            ptmt.setString(4, t.getTenLop());
            ptmt.setString(5, t.getSoDT());
            ptmt.setString(6, t.getEmail());
            ptmt.setString(7, t.getMaSV());


            return  ptmt.executeUpdate() >  0 ;
            
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;        
    }

    @Override
    public Students findById(String id) {
        try {
            var con = DatabaseHelper.getConnection();
            String sql = "SELECT * FROM Students WHERE StudentID = ?";

            var ptmt = con.prepareStatement(sql);
            ptmt.setString(1, id);
            var rs = ptmt.executeQuery();
            while (rs.next()) {
              return readRow(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null; 
    }
    
    private Students readRow(ResultSet rs ) throws SQLException {
        var sv = new Students(); 
        sv.setMaSV(rs.getString("StudentID"));
        sv.setHoLot(rs.getString("LastName"));
        sv.setTen(rs.getString("FirstName"));
        sv.setMaLop(rs.getString("ClassID"));
        sv.setTenLop(rs.getString("ClassName"));
        sv.setSoDT(rs.getString("PhoneNumber"));
        sv.setEmail(rs.getString("Email"));
        
        return sv;  
        
    }
    @Override
    public List<Students> findAll() {
        List<Students> lst = new ArrayList<>(); 
        try {

            var con = DatabaseHelper.getConnection();
            String sql = "SELECT * FROM Students ORDER BY StudentID";

            var ptmt = con.prepareStatement(sql);
            var rs = ptmt.executeQuery();
            while (rs.next()) {
                lst.add(readRow(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

         return lst; 

    }
    
}
