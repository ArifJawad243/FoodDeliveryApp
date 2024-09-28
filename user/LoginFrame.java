package user;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import menu.MenuFinal;



public class LoginFrame extends JFrame {
    public LoginFrame() {
        this.setTitle("Login");
        this.setSize(500, 400);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setLayout(new BorderLayout());
        
        ImageIcon burger = new ImageIcon("images/burger.png");
        this.setIconImage(burger.getImage());
        
        JLabel Title = new JLabel();
		Title.setText("LOGIN");
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
        
        
        
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(2, 1));
        loginPanel.setPreferredSize(new Dimension(300,100));
        loginPanel.setBackground(Color.lightGray);

        JLabel usernameLabel = new JLabel("Username:");
        //usernameLabel.setBounds(10, 20, 80, 25);
        loginPanel.add(usernameLabel);

        JTextField usernameField = new JTextField();
        //usernameField.setBounds(100, 20, 165, 25);
        loginPanel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        //passwordLabel.setBounds(10, 50, 80, 25);
        loginPanel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        //passwordField.setBounds(100, 50, 165, 25);
        loginPanel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(100, 25));
        loginButton.setBackground(Color.green);
        loginButton.setFocusable(false);
        
        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(100, 25));
        backButton.setBackground(Color.white);
        backButton.setFocusable(false);
        
        JPanel bot = new JPanel();
        bot.setLayout(new FlowLayout());
        bot.setBackground(Color.lightGray);
        
        bot.add(backButton);
        bot.add(loginButton);

        BodyPane.add(loginPanel, BorderLayout.NORTH);
        this.add(bot, BorderLayout.SOUTH);
        
        
        backButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				new UserLogin();
			}
		});
        
        
        
        loginButton.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
	            String username = usernameField.getText();
	            String password = new String(passwordField.getPassword());
	
	            try {
	                User user = User.verifyUser(username, password);
	                if (user == null)
	                {
	                	JOptionPane.showMessageDialog(null, "Invalid credentials", "Error", JOptionPane.ERROR_MESSAGE);
	                    
	                } 
	                else 
	                {
	                	JOptionPane.showMessageDialog(null, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
	                    dispose();
	                    new MenuFinal(user);
	                }
	            } 
	            catch (IOException q) 
	            {
	            	JOptionPane.showMessageDialog(null, "Something Went Wrong", "Error", JOptionPane.ERROR_MESSAGE);
	            }
        	}
        });
    }
}