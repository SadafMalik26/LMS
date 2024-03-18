/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author HUZAIFA JAVED IQBAL
 */
public class LMS extends JFrame implements ActionListener{

    JPanel panel1;
    JButton paperBack,DVD;
    LMS()
    {
        initComponents();
    }
    
    LMS(DVDMenu m)
    {
        m.dispose();
        initComponents();
    }
    
    LMS(DVDAddMenu m)
    {
        m.dispose();
        initComponents();
    }
    
    LMS(DVDDeleteMenu m)
    {
        m.dispose();
        initComponents();
    }
    
    LMS(DVDDeleteSpecificMenu m)
    {
        m.dispose();
        initComponents();
    }
    
    LMS(DVDUpdateStatusMenu m)
    {
        m.dispose();
        initComponents();
    }
    
    LMS(PaperBackMenu p)
    {
        p.dispose();     
        initComponents();
    }
    
    LMS(PaperBackAddMenu m)
    {
        m.dispose();
        initComponents();
    }
    
     LMS(PaperBackDeleteMenu m)
    {
        m.dispose();
        initComponents();
    }
     
    LMS(PaperBackDeleteSpecificMenu m)
    {
        m.dispose();
        initComponents();
    }
    
    LMS(PaperBackUpdateStatusMenu m)
    {
        m.dispose();
        initComponents();
    }
    void initComponents()
    {
        setTitle("Main Menu");
        setSize(400,400);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        panel1=new JPanel();
        panel1.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(25, 0, 25, 0);
        constraints.gridx = 0;
        constraints.gridy = 0;
        paperBack=new JButton("PaperBack");
        GridBagConstraints constraints1=new GridBagConstraints();
        constraints1.anchor = GridBagConstraints.CENTER;
        constraints1.insets = new Insets(25, 0, 25, 0);
        constraints1.gridx = 0;
        constraints1.gridy = 25;
        DVD=new JButton("DVD");
        panel1.add(paperBack, constraints);
        panel1.add(DVD, constraints1);
        add(panel1);
        paperBack.addActionListener(this);
        DVD.addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource()== DVD)
        {
            DVDMenu d=new DVDMenu(this);
            
        }
        else if(evt.getSource()==paperBack)
        {
            PaperBackMenu p=new PaperBackMenu(this);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) 
    {
        // TODO code application logic here
        LMS l=new LMS();
    }
    
}
