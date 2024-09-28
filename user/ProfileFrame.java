package user;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import menu.MenuFinal;


public class ProfileFrame extends JFrame {
    public ProfileFrame(User user) {
    	this.setTitle("User Profile");
    	this.setSize(500, 400);
    	this.setVisible(true);
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	this.setLocationRelativeTo(null);
    	this.setLayout(new BorderLayout());
        
        ImageIcon burger = new ImageIcon("images/burger.png");
        ImageIcon profileicon = new ImageIcon("images/profileicon.png");
        this.setIconImage(burger.getImage());
        
        JLabel Title = new JLabel();
		Title.setText("PROFILE");
		Title.setIcon(profileicon);
		Title.setForeground(Color.WHITE);
		Title.setBackground(Color.black);
		Title.setOpaque(true);
		Title.setFont(new Font("Arial", Font.PLAIN, 40));
		Title.setHorizontalAlignment(JLabel.CENTER);
		
		
		JPanel TitlePane = new JPanel();
		TitlePane.setPreferredSize(new Dimension(150,150));
		//TitlePane.setBackground(Color.yellow);
		TitlePane.setLayout(new BorderLayout());
		TitlePane.add(Title, BorderLayout.CENTER);
		this.add(TitlePane, BorderLayout.NORTH);
        
        JPanel profilePanel = new JPanel();
        profilePanel.setLayout(null);

        JLabel nameLabel = new JLabel("Name: " + user.getUsername());
        nameLabel.setBounds(10, 20, 200, 25);
        profilePanel.add(nameLabel);

        JLabel emailLabel = new JLabel("Email: " + user.getEmail());
        emailLabel.setBounds(10, 50, 200, 25);
        profilePanel.add(emailLabel);
        
        JLabel phoneLabel = new JLabel("Phone: " + user.getPhone());
        phoneLabel.setBounds(10, 80, 200, 25);
        profilePanel.add(phoneLabel);
        
        JButton deleteButton = new JButton("Delete User");
        deleteButton.setFocusable(false);
        deleteButton.setPreferredSize(new Dimension(100, 25));
        deleteButton.setBackground(Color.red);
        deleteButton.setForeground(Color.black);
        deleteButton.setBounds(0, 140, 100, 30);
        profilePanel.add(deleteButton);
        

        JButton updateButton = new JButton("Update");
        updateButton.setFocusable(false);
        updateButton.setBackground(Color.white);
        updateButton.setPreferredSize(new Dimension(100, 25));
        //updateButton.setHorizontalAlignment(JButton.CENTER);
        
        JButton closeButton = new JButton("Close");
        closeButton.setFocusable(false);
        closeButton.setBackground(Color.white);
        closeButton.setPreferredSize(new Dimension(100, 25));
        //closeButton.setHorizontalAlignment(JButton.CENTER);
        
        //profilePanel.add(updateButton);
        
        
        profilePanel.setBackground(Color.white);
        
        JPanel bot = new JPanel();
        bot.setBackground(Color.lightGray);
        bot.setLayout(new FlowLayout());

        bot.add(closeButton);
        bot.add(updateButton);
        this.add(bot, BorderLayout.SOUTH);
        this.add(profilePanel, BorderLayout.CENTER);

        updateButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                new UpdateProfileFrame(user);
                dispose();
            }
        });
        
        closeButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                new MenuFinal(user);
            }
        });
        
        deleteButton.addActionListener(new ActionListener()
		{
        	public void actionPerformed(ActionEvent e)
        	{
        		int q = JOptionPane.showConfirmDialog(null, "Are you sure?");
        		if(q == 0)
        		{
	        		JOptionPane.showMessageDialog(null, "User Deleted. You will be redirected to the Login Page", "RIP", JOptionPane.INFORMATION_MESSAGE);
	        		try
	        		{
						user.deleteUser();
					} 
	        		catch (IOException ee)
	        		{
	        			JOptionPane.showMessageDialog(null, "Something Went Wrong", "RIP", JOptionPane.ERROR_MESSAGE);
					}
	        		dispose();
	        		new UserLogin();
        		}
        		else
        		{
        			System.out.println("Cancelled");
        		}
        	}
		});
    }
}