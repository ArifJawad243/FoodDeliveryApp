package user;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserLogin extends JFrame{

    private static final int CENTER = 0;

	public UserLogin() 
    {
		this.setTitle("Bob's Kitchen App");
		this.setSize(500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.setVisible(true);
        
        
        ImageIcon burger = new ImageIcon("images/burger.png");
        this.setIconImage(burger.getImage());
        
        JLabel Title = new JLabel();
		Title.setText("Bob's Kitchen");
		Title.setIcon(burger);
		Title.setForeground(Color.WHITE);
		Title.setBackground(Color.black);
		Title.setOpaque(true);
		Title.setFont(new Font("Arial",Font.PLAIN,50));
		Title.setHorizontalAlignment(JLabel.CENTER);
		
		
		JPanel TitlePane = new JPanel();
		TitlePane.setPreferredSize(new Dimension(150,150));
		//TitlePane.setBackground(Color.yellow);
		TitlePane.setLayout(new BorderLayout());
		TitlePane.add(Title, BorderLayout.CENTER);
		this.add(TitlePane, BorderLayout.NORTH);
		

        JPanel mainPanel = new JPanel();
        JPanel log = new JPanel();
        JPanel reg = new JPanel();
        //mainPanel.setLayout(new BorderLayout());
        //mainPanel.setLayout(new FlowLayout(1));
        mainPanel.setLayout(new GridLayout(2,2));
        
        JLabel l = new JLabel("Existing User?");
        l.setHorizontalAlignment(CENTER);
        l.setVerticalAlignment(JLabel.BOTTOM);
        
        JLabel r = new JLabel("New User?");
        r.setHorizontalAlignment(CENTER);
        r.setVerticalAlignment(JLabel.BOTTOM);

        JButton loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(120, 30));
        loginButton.setBackground(Color.white);
        loginButton.setFocusable(false);
        log.setPreferredSize(new Dimension(250,250));
        log.setLayout(new FlowLayout(1));
        //log.setBackground(Color.cyan);
        log.add(loginButton);

        JButton registerButton = new JButton("Register");
        registerButton.setPreferredSize(new Dimension(120, 30));
        registerButton.setBackground(Color.white);
        registerButton.setFocusable(false);
        reg.setPreferredSize(new Dimension(250,250));
        reg.setLayout(new FlowLayout(1));
        reg.add(registerButton);
        
        
        mainPanel.add(l);
        mainPanel.add(r);
        mainPanel.add(log);
        mainPanel.add(reg);
        
        //mainPanel.add(loginButton, BorderLayout.EAST);
        //mainPanel.add(registerButton, BorderLayout.WEST);

        this.add(mainPanel, BorderLayout.CENTER);

        
        
        loginButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
            	new LoginFrame();
            	dispose();
            }
        }
        );
        registerButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	new RegistrationFrame();
            	dispose();
            }
        }
        );
        
        
    }
}