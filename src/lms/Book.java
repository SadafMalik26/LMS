/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import java.sql.SQLException;
/**
 *
 * @author HUZAIFA JAVED IQBAL
 */
public abstract class Book {
    protected String name,author,publisher,Status;
    protected int id;
    Book()
    {
        
    }
    Book(String name,String author,String publisher,String Status,int id)
    {
        this.name=name;
        this.author=author;
        this.publisher=publisher;
        this.Status=Status;
        this.id=id;
    }
    
    Book(int id)
    {
        this.id=id;
    }
    
    Book(int id,String Status)
    {
        this.id=id;
        this.Status=Status;
    }
    public abstract void add() throws SQLException;
    public abstract void deleteAll();
    public abstract void delete();
    public abstract void update() throws SQLException;
    
}
