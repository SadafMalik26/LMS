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
import java.sql.SQLException;
import javax.swing.*;
public class PaperBackUpdateStatusMenu extends JFrame implements ActionListener{
    
    JPanel panel1,panel2,panel3,panel4;
    JLabel label1;
    JTextField textField;
    JButton back,mainMenu,update;
    JComboBox status1;
    PaperBackUpdateStatusMenu(PaperBackMenu p)
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
        
        label1=new JLabel("Unique ID");
        textField=new JTextField(18);
        label1.setFont(new java.awt.Font("Arial", Font.BOLD, 15));
        textField.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
        panel1.add(label1);
        panel1.add(textField);
        add(panel1,BorderLayout.NORTH);
        
        panel2=new JPanel();
        panel3=new JPanel();
        
        String[] s={"Available","Borrowed"};
        status1=new JComboBox(s);
        panel2.add(status1);
        panel3.add(panel2,BorderLayout.NORTH);
        
        
        back=new JButton("Back");
        mainMenu=new JButton("Main Menu");
        update=new JButton("Update Status");
        
        panel4=new JPanel();
        panel4.add(back);
        panel4.add(mainMenu);
        panel4.add(update);
        
        panel3.add(panel4,BorderLayout.CENTER);
        add(panel3);
        back.addActionListener(this);
        mainMenu.addActionListener(this);
        update.addActionListener(this);
        
    }
    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource()==back)
        {
            PaperBackMenu p=new PaperBackMenu(this);
        }else if(evt.getSource()==mainMenu)
        {
            LMS l=new LMS(this);
        }else if(evt.getSource()==update)
        {
            try{
                String Status;
                int id1=Integer.parseInt(textField.getText());
                if(id1<0)
                {
                    throw new RuntimeException();
                }
                Status=(String)status1.getSelectedItem();
                PaperBack p=new PaperBack(id1,Status);
                p.update();
                JOptionPane.showMessageDialog(null, "Status Updated");
            }catch(RuntimeException e)
            {
                JOptionPane.showMessageDialog(null, "ID can only be a Positive Integer.","Inane error",JOptionPane.ERROR_MESSAGE);
                textField.setText("");
                System.out.println(e.getMessage());
            }catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null, "ID not Found.","Inane error",JOptionPane.ERROR_MESSAGE);
                textField.setText("");
                System.out.println(e.getMessage());
            }
            
        }
    }
}
