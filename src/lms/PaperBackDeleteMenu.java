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
public class PaperBackDeleteMenu extends JFrame implements ActionListener{
    
    JPanel panel1;
    JButton all,specific,back,mainMenu;
    PaperBackDeleteMenu(PaperBackMenu p)
    {
        p.dispose();
        initComponents();
    }
    
     PaperBackDeleteMenu(PaperBackDeleteSpecificMenu p)
    {
        p.dispose();
        initComponents();
    }
     
    void initComponents()
    {
        setTitle("PaperBack Menu");
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
        all=new JButton("Delete All");
        all.setForeground(Color.BLACK);
        GridBagConstraints constraints1=new GridBagConstraints();
        constraints1.anchor = GridBagConstraints.CENTER;
        constraints1.insets = new Insets(10, 0, 10, 0);
        constraints1.gridx = 0;
        constraints1.gridy = 10;
        specific=new JButton("Delete Specific");
        specific.setForeground(Color.BLACK);
        GridBagConstraints constraints2 = new GridBagConstraints();
        constraints2.anchor = GridBagConstraints.CENTER;
        constraints2.insets = new Insets(10, 0, 10, 0);
        constraints2.gridx = 0;
        constraints2.gridy = 20;
        back=new JButton("Back");
        back.setForeground(Color.BLACK);
        GridBagConstraints constraints3 = new GridBagConstraints();
        constraints3.anchor = GridBagConstraints.CENTER;
        constraints3.insets = new Insets(10, 0, 10, 0);
        constraints3.gridx = 0;
        constraints3.gridy = 30;
        mainMenu=new JButton("Main Menu");
        mainMenu.setForeground(Color.BLACK);
        panel1.add(all,constraints);
        panel1.add(specific,constraints1);
        panel1.add(back,constraints2);
        panel1.add(mainMenu,constraints3);
        all.addActionListener(this);
        specific.addActionListener(this);
        back.addActionListener(this);
        mainMenu.addActionListener(this);
        add(panel1);
    }
    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource()==back)
        {
            PaperBackMenu p=new PaperBackMenu(this);
        }else if(evt.getSource()==mainMenu)
        {
            LMS l=new LMS(this);
        }else if(evt.getSource()==all)
        {
            PaperBack d=new PaperBack();
            d.deleteAll();
            JOptionPane.showMessageDialog(null, "Data Deleted");
        }else if(evt.getSource()==specific)
        {
            PaperBackDeleteSpecificMenu p=new PaperBackDeleteSpecificMenu(this);
        }
    }
}
