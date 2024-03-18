/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

/**
 *
 * @author HUZAIFA JAVED IQBAL
 */
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class DVDDeleteSpecificMenu extends JFrame implements ActionListener{
    
    JPanel panel1,panel2;
    JLabel label1;
    JTextField textField;
    JButton back,mainMenu,delete;
    
    DVDDeleteSpecificMenu(DVDDeleteMenu d)
    {
        d.dispose();
        initComponents();
    }
    
    void initComponents()
    {
        setTitle("DVD Menu");
        setSize(400,400);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        panel1=new JPanel();
        
        label1=new JLabel("Unique ID");
        textField=new JTextField(18);
        label1.setFont(new java.awt.Font("Arial", Font.BOLD, 15));
        textField.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
        panel1.add(label1);
        panel1.add(textField);
        add(panel1,BorderLayout.NORTH);
        
        panel2=new JPanel();
        
        back=new JButton("Back");
        mainMenu=new JButton("Main Menu");
        delete=new JButton("Delete");
        
        panel2.add(back);
        panel2.add(mainMenu);
        panel2.add(delete);
        
        add(panel2,BorderLayout.CENTER);
        
        back.addActionListener(this);
        mainMenu.addActionListener(this);
        delete.addActionListener(this);
    }
    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource()==back)
        {
            DVDDeleteMenu d=new DVDDeleteMenu(this);
        }else if(evt.getSource()==mainMenu)
        {
            LMS l=new LMS(this);
        }else if(evt.getSource()==delete)
        {
            int id=Integer.parseInt(textField.getText());
            DVD d=new DVD(id);
            d.delete();
            JOptionPane.showMessageDialog(null, "Successfully Deleted");
            textField.setText("");
        }
    }
}
