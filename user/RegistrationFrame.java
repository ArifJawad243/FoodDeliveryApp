package user;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class RegistrationFrame extends JFrame {
    public RegistrationFrame() {
    	this.setTitle("Registration");
    	this.setSize(500, 600);
    	this.setVisible(true);
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	this.setLocationRelativeTo(null);
        //setLayout(new BorderLayout());
        
        ImageIcon burger = new ImageIcon("images/burger.png");
        this.setIconImage(burger.getImage());
        
        JLabel Title = new JLabel();
		Title.setText("REGISTRATION");
		Title.setIcon(burger);
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
        
        
        
        JPanel BodyPane = new JPanel();
        BodyPane.setLayout(new BorderLayout());
        BodyPane.setBackground(Color.lightGray);
        this.add(BodyPane, BorderLayout.CENTER);
        
        
        
        JPanel registerPanel = new JPanel();
        registerPanel.setPreferredSize(new Dimension(300,200));
        registerPanel.setBackground(Color.lightGray);
        
        registerPanel.setLayout(new GridLayout(6, 2, 0 ,5));

        JLabel usernameLabel = new JLabel("Username:");
        registerPanel.add(usernameLabel);

        JTextField usernameField = new JTextField();
        registerPanel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        registerPanel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        registerPanel.add(passwordField);

        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        registerPanel.add(confirmPasswordLabel);

        JPasswordField confirmPasswordField = new JPasswordField();
        registerPanel.add(confirmPasswordField);

        JLabel emailLabel = new JLabel("Email:");
        registerPanel.add(emailLabel);

        JTextField emailField = new JTextField();
        registerPanel.add(emailField);
        
        JLabel phoneLabel = new JLabel("Phone:");
        registerPanel.add(phoneLabel);

        JTextField phoneField = new JTextField();
        registerPanel.add(phoneField);

        JButton registerButton = new JButton("Register");
        registerButton.setPreferredSize(new Dimension(100, 25));
        registerButton.setFocusable(false);
        
        JButton backButton = new JButton("Back");
        backButton.setFocusable(false);
        backButton.setPreferredSize(new Dimension(100, 25));
        
        
        JPanel bot = new JPanel();
        bot.setLayout(new FlowLayout());
        bot.setBackground(Color.lightGray);
        

        bot.add(backButton);
        bot.add(registerButton);
        

        BodyPane.add(registerPanel, BorderLayout.NORTH);
        add(bot, BorderLayout.SOUTH);
        

        backButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				new UserLogin();
			}
		});

        registerButton.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
	            String username = usernameField.getText();
	            String password = new String(passwordField.getPassword());
	            String confirmPassword = new String(confirmPasswordField.getPassword());
	            String email = emailField.getText();
	            String phone = phoneField.getText();
	
	            if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || email.isEmpty() || phone.isEmpty()) 
	            {
	                JOptionPane.showMessageDialog(null, "Please Enter Your Credentials", "Error", JOptionPane.ERROR_MESSAGE);
	            } 
	            else if (!password.equals(confirmPassword)) 
	            {
	                JOptionPane.showMessageDialog(null, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
	                passwordField.setText("");
	                confirmPasswordField.setText("");
	            } 
	            else 
	            {
	            	try 
	                {
	                    User newUser = new User(username, password, email, phone);
	                    newUser.saveUser();
	                    JOptionPane.showMessageDialog(null, "User registered successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
	                    new UserLogin().setVisible(true);
	                    dispose();
	                } 
	            	catch (Exception q) 
	            	{
	                	JOptionPane.showMessageDialog(null, "Something Went Wrong", "Error", JOptionPane.ERROR_MESSAGE);
	                }
	            }
        	}
        });
    }
}