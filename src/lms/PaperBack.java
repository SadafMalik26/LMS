/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import java.sql.*;

/**
 *
 * @author HUZAIFA JAVED IQBAL
 */
public class PaperBack extends Book{
    protected int noOfPages;
    
    PaperBack()
    {
        super();
    }
    
    PaperBack(String name,String author,String publisher,String Status,int id,int noOfPages)
    {
        super(name,author,publisher,Status,id);
        this.noOfPages=noOfPages;
    }
    
    PaperBack(int id)
    {
        super(id);
    }
    
    PaperBack(int id,String Status)
    {
        super(id,Status);
    }
    
    public void add() throws SQLException
    {
        createTable();
        String sql = "INSERT INTO paperback(ID,Name,Author,Publisher,Status,NoOfPages) VALUES(?,?,?,?,?,?)";
        Connection conn = this.connect();  
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.setString(2, name);  
        pstmt.setString(3, author); 
        pstmt.setString(4,publisher);
        pstmt.setString(5,Status);
        pstmt.setDouble(6,noOfPages);
        pstmt.executeUpdate(); 
    }
    
    public void deleteAll()
    {
        String sql = "DELETE FROM paperback";
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
        String sql ="DELETE FROM paperback WHERE id = ?";
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
        
        String sql ="CREATE TABLE IF NOT EXISTS paperback (\n"
                + " ID REAL PRIMARY KEY,\n"
                + " Name TEXT NOT NULL,\n"
                + " Author TEXT NOT NULL,\n"
                + " Publisher TEXT NOT NULL,\n"
                + " Status TEXT NOT NULL,\n"
                + " NoOfPages REAL NOT NULL\n"
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
        String sql = "UPDATE paperback SET Status =? WHERE ID = ?";
        Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, Status);
        pstmt.setInt(2, id);
        pstmt.executeUpdate();  
    }
}
