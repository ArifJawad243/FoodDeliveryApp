package user;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;


public class UpdateProfileFrame extends JFrame {
    public UpdateProfileFrame(User user) {
    	this.setTitle("Update Profile");
    	this.setSize(500, 600);
    	this.setVisible(true);
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        
        
        
        ImageIcon burger = new ImageIcon("images/burger.png");
        ImageIcon profileicon = new ImageIcon("images/profileicon.png");
        this.setIconImage(burger.getImage());
        
        JLabel Title = new JLabel();
		Title.setText("UPDATE PROFILE");
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
		
		
		JPanel BodyPane = new JPanel();
        BodyPane.setLayout(new BorderLayout());
        BodyPane.setBackground(Color.lightGray);
        this.add(BodyPane, BorderLayout.CENTER);
        
        
        
        
        JPanel updatePanel = new JPanel();
        updatePanel.setLayout(new GridLayout(5, 2, 0 ,5));
        updatePanel.setBackground(Color.LIGHT_GRAY);
        updatePanel.setPreferredSize(new Dimension(300,200));

        JLabel usernameLabel = new JLabel("Username:");
        updatePanel.add(usernameLabel);

        JTextField usernameField = new JTextField(user.getUsername());
        updatePanel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        updatePanel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField(user.getPassword());
        updatePanel.add(passwordField);

        JLabel emailLabel = new JLabel("Email:");
        updatePanel.add(emailLabel);

        JTextField emailField = new JTextField(user.getEmail());
        updatePanel.add(emailField);
        
        JLabel phoneLabel = new JLabel("Phone:");
        updatePanel.add(phoneLabel);

        JTextField phoneField = new JTextField(user.getPhone());
        updatePanel.add(phoneField);

        JButton saveButton = new JButton("Save");
        saveButton.setPreferredSize(new Dimension(100, 25));
        saveButton.setBackground(Color.green);
        saveButton.setForeground(Color.black);
        saveButton.setFocusable(false);
        
        JButton closeButton = new JButton("Close");
        closeButton.setFocusable(false);
        closeButton.setBackground(Color.white);
        closeButton.setPreferredSize(new Dimension(100, 25));
        
        JPanel bot = new JPanel();
        bot.setLayout(new FlowLayout());
        bot.add(closeButton);
        bot.add(saveButton);
        
        BodyPane.add(updatePanel, BorderLayout.NORTH);

        add(BodyPane, BorderLayout.CENTER);
        add(bot, BorderLayout.SOUTH);

        saveButton.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
	            String username = usernameField.getText();
	            String password = new String(passwordField.getPassword());
	            String email = emailField.getText();
	            String phone = phoneField.getText();
	
	            if (username.isEmpty() || password.isEmpty() || email.isEmpty() || phone.isEmpty())
	            {
	                JOptionPane.showMessageDialog(null, "All fields must be filled", "Error", JOptionPane.ERROR_MESSAGE);
	            } 
	            else 
	            {
	                user.setUsername(username);
	                user.setPassword(password);
	                user.setEmail(email);
	                user.setPhone(phone);
	
	                try
	                {
	                    user.saveUser();
	                    JOptionPane.showMessageDialog(null, "Profile updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
	                    dispose();
	                } 
	                catch (Exception a)
	                {
	                    JOptionPane.showMessageDialog(null, "Error updating profile.", "Error", JOptionPane.ERROR_MESSAGE);
	                }
	                new ProfileFrame(user);
	            }
        	}
        });
        
        closeButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                new ProfileFrame(user);
            }
        });
    }
}