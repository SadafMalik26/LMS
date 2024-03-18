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
import javax.swing.*;

public class DVDMenu extends JFrame implements ActionListener{
    JPanel panel1;
    JButton add,delete,update,mainMenu;
    
    DVDMenu(LMS l)
    {
        l.dispose();
        initComponents();
    }
    
    DVDMenu(DVDAddMenu d)
    {
        d.dispose();
        initComponents();
    }
    
    DVDMenu(DVDDeleteMenu d)
    {
        d.dispose();
        initComponents();
    }
    
     DVDMenu(DVDUpdateStatusMenu d)
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
        panel1.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(10, 0, 10, 0);
        constraints.gridx = 0;
        constraints.gridy = 0;
        add=new JButton("Add");
        add.setForeground(Color.BLACK);
        GridBagConstraints constraints1=new GridBagConstraints();
        constraints1.anchor = GridBagConstraints.CENTER;
        constraints1.insets = new Insets(10, 0, 10, 0);
        constraints1.gridx = 0;
        constraints1.gridy = 10;
        delete=new JButton("Delete");
        delete.setForeground(Color.BLACK);
        GridBagConstraints constraints2 = new GridBagConstraints();
        constraints2.anchor = GridBagConstraints.CENTER;
        constraints2.insets = new Insets(10, 0, 10, 0);
        constraints2.gridx = 0;
        constraints2.gridy = 20;
        update=new JButton("Update Status");
        update.setForeground(Color.BLACK);
        GridBagConstraints constraints4 = new GridBagConstraints();
        constraints4.anchor = GridBagConstraints.CENTER;
        constraints4.insets = new Insets(10, 0, 10, 0);
        constraints4.gridx = 0;
        constraints4.gridy = 40;
        mainMenu=new JButton("Main Menu");
        mainMenu.setForeground(Color.BLACK);
        panel1.add(add,constraints);
        panel1.add(delete,constraints1);
        panel1.add(update,constraints2);
        panel1.add(mainMenu,constraints4);
        add(panel1);
        add.addActionListener(this);
        delete.addActionListener(this);
        update.addActionListener(this);
        mainMenu.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource()==add)
        {
            DVDAddMenu dm=new DVDAddMenu(this);
        }
        else if(evt.getSource()==mainMenu)
        {
            LMS l=new LMS(this);
        }else if(evt.getSource()==delete)
        {
            DVDDeleteMenu d=new DVDDeleteMenu(this);
        }else if(evt.getSource()==update)
        {
            DVDUpdateStatusMenu d=new DVDUpdateStatusMenu(this);
        }
    }
}
