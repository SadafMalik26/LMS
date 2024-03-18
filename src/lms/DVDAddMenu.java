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
public class DVDAddMenu extends JFrame implements ActionListener{
    
    JButton add,back,mainMenu,clear;
    JComboBox status1;
    JLabel duration,status,publisher,author,name,id;
    JTextField duration1,publisher1,author1,name1,id1;
    JPanel panel1,panel2,panel3,panel4,panel5,panel6,panel7;
    
    DVDAddMenu(DVDMenu d)
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
        setLayout(new GridLayout(0,1));
        
        panel1=new JPanel();
        panel2=new JPanel();
        panel3=new JPanel();
        panel4=new JPanel();
        panel5=new JPanel();
        panel6=new JPanel();
        panel7=new JPanel();
        
        name=new JLabel("Name:");
        id=new JLabel("Unique ID:");
        author=new JLabel("Author:");
        publisher=new JLabel("Publisher:");
        duration=new JLabel("Duration:");
        status=new JLabel("Status:");
        
        name.setFont(new java.awt.Font("Arial", Font.BOLD, 15));
        id.setFont(new java.awt.Font("Arial", Font.BOLD, 15));
        author.setFont(new java.awt.Font("Arial", Font.BOLD, 15));
        publisher.setFont(new java.awt.Font("Arial", Font.BOLD, 15));
        duration.setFont(new java.awt.Font("Arial", Font.BOLD, 15));
        status.setFont(new java.awt.Font("Arial", Font.BOLD, 15));
       
        panel1.add(name);
        panel2.add(id);
        panel3.add(author);
        panel4.add(publisher);
        panel5.add(duration);
        panel6.add(status);
        
        name1=new JTextField(21);
        id1=new JTextField(19);
        author1=new JTextField(20);
        publisher1=new JTextField(19);
        duration1=new JTextField(19);
        
        name1.setFont(new java.awt.Font("Arial", Font.PLAIN, 20));
        id1.setFont(new java.awt.Font("Arial", Font.PLAIN, 20));
        author1.setFont(new java.awt.Font("Arial", Font.PLAIN, 20));
        publisher1.setFont(new java.awt.Font("Arial", Font.PLAIN, 20));
        duration1.setFont(new java.awt.Font("Arial", Font.PLAIN, 20));
        
        String[] s={"Available","Borrowed"};
        status1=new JComboBox(s);
        
        panel1.add(name1);
        panel2.add(id1);
        panel3.add(author1);
        panel4.add(publisher1);
        panel5.add(duration1);
        panel6.add(status1);
        
        add=new JButton("Add");
        back=new JButton("Back");
        mainMenu=new JButton("Main Menu");
        clear=new JButton("Clear");
        
        panel7.add(add);      
        panel7.add(back);
        panel7.add(mainMenu);
        panel7.add(clear);
        
        add.addActionListener(this);
        back.addActionListener(this);
        mainMenu.addActionListener(this);
        clear.addActionListener(this);
        
        add(panel1);
        add(panel2);
        add(panel3);        
        add(panel4); 
        add(panel5);
        add(panel6);
        add(panel7);
        
    }
    
     public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource()==mainMenu)
        {
            LMS l=new LMS(this);
        }
        else if(evt.getSource()==clear)
        {
            duration1.setText("");
            publisher1.setText("");
            author1.setText("");
            name1.setText("");
            id1.setText("");
        }
        else if(evt.getSource()==back)
        {
            DVDMenu d=new DVDMenu(this);
        }
        else if(evt.getSource()==add)
        {
            try{
                String name,author,publisher,Status;
                double duration;
                int id;
                name=name1.getText();
                author=author1.getText();
                publisher=publisher1.getText();
                Status=(String)status1.getSelectedItem();
                if(name.isEmpty()||author.isEmpty()||publisher.isEmpty()||Status.isEmpty())
                {
                    throw new RuntimeException();
                }
                id=Integer.parseInt(id1.getText());
                duration=Double.parseDouble(duration1.getText());
                if(duration<0||id<0)
                {
                    throw new NumberFormatException();
                }
                DVD d=new DVD(name,author,publisher,Status,id,duration);
                d.add();
                JOptionPane.showMessageDialog(null, "Successfully Added");
                duration1.setText("");
                publisher1.setText("");
                author1.setText("");
                name1.setText("");
                id1.setText("");
            }catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null, "Duration and ID can only be Positive Integers.","Inane error",JOptionPane.ERROR_MESSAGE);
                duration1.setText("");
                id1.setText("");
            }catch(RuntimeException r)
            {
                JOptionPane.showMessageDialog(null, "Fields Cannot be Empty","Inane error",JOptionPane.ERROR_MESSAGE);
            }catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null, "ID Already Used","Inane error",JOptionPane.ERROR_MESSAGE);
                id1.setText("");
            }   
        } 
    }
}
