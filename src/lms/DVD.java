/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.sql.Statement;

/**
 *
 * @author HUZAIFA JAVED IQBAL
 */
public class DVD extends Book {
    protected double duration;
    
    DVD()
    {
        super();
    }
    
    DVD(String name,String author,String publisher,String Status,int id,double duration)
    {
        super(name,author,publisher,Status,id);
        this.duration=duration;
    }
    
    DVD(int id)
    {
        super(id);
    }
    
    DVD(int id,String Status)
    {
        super(id,Status);
    }
    
    public void add() throws SQLException
    {
        createTable();
        String sql = "INSERT INTO dvd(ID,Name,Author,Publisher,Status,Duration) VALUES(?,?,?,?,?,?)";
          
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, name);  
            pstmt.setString(3, author); 
            pstmt.setString(4,publisher);
            pstmt.setString(5,Status);
            pstmt.setDouble(6,duration);
            pstmt.executeUpdate(); 
    }
    
    public void deleteAll()
    {
        String sql = "DELETE FROM dvd";
        try
        {
            Connection conn = this.connect(); 
            Statement pstmt = conn.createStatement();
            pstmt.execute(sql);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void delete()
    {
        String sql ="DELETE FROM dvd WHERE id = ?";
        try{
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    private void createTable()
    {
        
        String sql ="CREATE TABLE IF NOT EXISTS dvd (\n"
                + " ID REAL PRIMARY KEY,\n"
                + " Name TEXT NOT NULL,\n"
                + " Author TEXT NOT NULL,\n"
                + " Publisher TEXT NOT NULL,\n"
                + " Status TEXT NOT NULL,\n"
                + " Duration REAL NOT NULL\n"
                + ");";
        try
        {
            Connection conn = this.connect(); 
            Statement pstmt = conn.createStatement();
            pstmt.execute(sql);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    private Connection connect()
   {  
        // SQLite connection string  
        String url = "jdbc:sqlite:LMS.db";  
        Connection conn = null;  
        try 
        {  
            conn = DriverManager.getConnection(url);  
        } catch (SQLException e)
        {  
            System.out.println(e.getMessage());  
        }  
        return conn;  
    }
    
    public void update() throws SQLException
    {
        String sql = "UPDATE dvd SET Status =? WHERE ID = ?";
        Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, Status);
        pstmt.setInt(2, id);
        pstmt.executeUpdate();  
    }
}
