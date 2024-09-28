package menu;
import java.lang.*;
import javax.swing.*;

import user.ProfileFrame;
import user.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;




public class MenuFinal extends JFrame
{
	//User user;

    private MenuItem[] burgersMenu;
    private MenuItem[] pizzaMenu;
    private MenuItem[] beveragesMenu;
    private MenuItem b1, b2, b3, p1, p2, p3, d1, d2, d3;

    private DefaultListModel<String> cartModel;
    private ArrayList<MenuItem> orderedItems;
    private JLabel totalLabel;
    private double totalPrice = 0;

    public MenuFinal(User user) {
    	//this.user = user;
    	this.setVisible(true);
        this.setTitle("Menu");
        
        ImageIcon burger = new ImageIcon("images/burger.png");
        this.setIconImage(burger.getImage());
        this.setSize(1300, 900);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setBackground(Color.green);
        this.setLayout(new BorderLayout());
        
        
        
        
        b1 = new MenuItem("Classic Burger", 4.99);
        b2 = new MenuItem("Cheese Burger", 5.99);
        b3 = new MenuItem("Bacon Burger", 6.99);

        burgersMenu = new MenuItem[]{b1, b2, b3};
        
        /*String aa = burgersMenu[0].getName();
        System.out.println(aa);*/
        
        
        
        p1 = new MenuItem("Margherita", 10.99);
        p2 = new MenuItem("Pepperoni", 12.99);
        p3 = new MenuItem("BBQ Chicken", 15.99);
        
        pizzaMenu = new MenuItem[]{p1, p2, p3};

        d1 = new MenuItem("Coke", 1.99);
        d2 = new MenuItem("Sprite", 1.99);
        d3 = new MenuItem("Water", 1);
        
        beveragesMenu = new MenuItem[]{d1, d2, d3};
        
        

        JPanel TopPane = new JPanel();
        
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
		
		JPanel ProfilePane = new JPanel();
		ImageIcon profileicon = new ImageIcon("images/profileicon.png");
		JButton profileButton = new JButton();
		//profile button action listener
		profileButton.setIcon(profileicon);
		profileButton.setText("Profile");
		profileButton.setOpaque(true);
		profileButton.setBackground(Color.black);
		profileButton.setFocusable(false);
		profileButton.setFont(new Font("Arial",Font.PLAIN,20));
		profileButton.setVerticalTextPosition(JButton.BOTTOM);
		profileButton.setHorizontalTextPosition(JButton.CENTER);
		profileButton.setForeground(Color.white);
		profileButton.setBorderPainted(false);
		profileButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
            	dispose();
                new ProfileFrame(user);
            }
        });
		
		ProfilePane.setPreferredSize(new Dimension(150,150));
		ProfilePane.setBackground(Color.blue);
		ProfilePane.setLayout(new BorderLayout());
		ProfilePane.add(profileButton, BorderLayout.CENTER);

		TopPane.setPreferredSize(new Dimension(150,150));
		TopPane.setBackground(Color.ORANGE);
		TopPane.setLayout(new BorderLayout());
		TopPane.add(TitlePane, BorderLayout.CENTER);
		TopPane.add(ProfilePane, BorderLayout.WEST);
		
		this.add(TopPane, BorderLayout.NORTH);
		
		JPanel LeftPane = new JPanel();
		LeftPane.setPreferredSize(new Dimension(150,150));
		LeftPane.setBackground(Color.darkGray);
		LeftPane.setLayout(new FlowLayout());
		
		//this.add(LeftPane, BorderLayout.WEST);
		
		
		
        JPanel ContentPane = new JPanel();
        ContentPane.setLayout(new BorderLayout());
        ContentPane.setBackground(Color.lightGray);
        ContentPane.setPreferredSize(new Dimension(100,100));
        
        this.add(ContentPane, BorderLayout.CENTER);
        
        JPanel burgerPane = new JPanel();
        burgerPane.setLayout(new GridLayout(burgersMenu.length, 1));
        ImageIcon burger1 = new ImageIcon("images/burger1.png");
        ImageIcon burger2 = new ImageIcon("images/burger2.png");
        ImageIcon burger3 = new ImageIcon("images/burger3.png");

        for (MenuItem a : burgersMenu) //FIX THIS
        {
        	String name = a.getName();
        	String price = String.format("%.2f", a.getPrice());
            JButton menuitemButton = new JButton();
            menuitemButton.setText(name + " - $" + price);
            menuitemButton.setFocusable(false);
            menuitemButton.setBackground(Color.white);
            if(name == "Classic Burger")
            {
            	menuitemButton.setIcon(burger1);
            }
            if(name == "Cheese Burger")
            {
            	menuitemButton.setIcon(burger2);
            }
            if(name == "Bacon Burger")
            {
            	menuitemButton.setIcon(burger3);
            }
            //menuitemButton.setIcon(burger1);
            menuitemButton.setHorizontalAlignment(JButton.LEFT);
            menuitemButton.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e)
                {
                    addToCart(a);
                }
            });
            burgerPane.add(menuitemButton);
        }
        
        JPanel pizzaPane = new JPanel();
        pizzaPane.setLayout(new GridLayout(pizzaMenu.length, 1));
        ImageIcon pizza1 = new ImageIcon("images/pizza1.png");
        ImageIcon pizza2 = new ImageIcon("images/pizza2.png");
        ImageIcon pizza3 = new ImageIcon("images/pizza3.png");

        for (MenuItem a : pizzaMenu) 
        {
        	String name = a.getName();
        	String price = String.format("%.2f", a.getPrice());
            JButton menuitemButton = new JButton();
            menuitemButton.setText(name + " - $" + price);
            menuitemButton.setFocusable(false);
            menuitemButton.setBackground(Color.white);
            if(name == "BBQ Chicken")
            {
            	menuitemButton.setIcon(pizza2);
            }
            if(name == "Pepperoni")
            {
            	menuitemButton.setIcon(pizza1);
            }
            if(name == "Margherita")
            {
            	menuitemButton.setIcon(pizza3);
            }
            menuitemButton.setHorizontalAlignment(JButton.LEFT);
            menuitemButton.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e)
                {
                    addToCart(a);
                }
            });
            pizzaPane.add(menuitemButton);
        }
        
        JPanel beveragePane = new JPanel();
        beveragePane.setLayout(new GridLayout(beveragesMenu.length, 1));

        for (MenuItem a : beveragesMenu) 
        {
        	String name = a.getName();
        	String price = String.format("%.2f", a.getPrice());
            JButton menuitemButton = new JButton();
            ImageIcon drink1 = new ImageIcon("images/drink1.png");
            ImageIcon drink2 = new ImageIcon("images/drink2.png");
            ImageIcon drink3 = new ImageIcon("images/drink3.png");
            menuitemButton.setText(name + " - $" + price);
            menuitemButton.setFocusable(false);
            menuitemButton.setBackground(Color.white);
            if(name == "Coke")
            {
            	menuitemButton.setIcon(drink1);
            }
            if(name == "Sprite")
            {
            	menuitemButton.setIcon(drink2);
            }
            if(name == "Water")
            {
            	menuitemButton.setIcon(drink3);
            }
            menuitemButton.setHorizontalAlignment(JButton.LEFT);
            menuitemButton.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e)
                {
                    addToCart(a);
                }
            });
            beveragePane.add(menuitemButton);
        }
        JTabbedPane tabbedPane = new JTabbedPane();

        JLabel tab1 = new JLabel();
        tab1.setText("Burger");
        tab1.setPreferredSize(new Dimension(100,50));
        tab1.setHorizontalAlignment(JLabel.CENTER);
        tabbedPane.addTab(null, burgerPane);
        tabbedPane.setTabComponentAt(0, tab1);
        //tabbedPane.setBackgroundAt(0, Color.green);
        //tabbedPane.setOpaque(true);
        
        
        
        JLabel tab2 = new JLabel();
        tab2.setText("Pizza");
        //tab2.setBackground(Color.GREEN);
        tab2.setPreferredSize(new Dimension(100,50));
        tab2.setHorizontalAlignment(JLabel.CENTER);
        tabbedPane.addTab(null, pizzaPane);
        tabbedPane.setTabComponentAt(1, tab2);
        
        
        JLabel tab3 = new JLabel();
        tab3.setText("Beverage");
        //tab3.setBackground(Color.GREEN);
        tab3.setPreferredSize(new Dimension(100,50));
        tab3.setHorizontalAlignment(JLabel.CENTER);
        tabbedPane.addTab(null, beveragePane);
        tabbedPane.setTabComponentAt(2, tab3);
        
        
        
        

        ContentPane.add(tabbedPane, BorderLayout.NORTH);

        cartModel = new DefaultListModel<>();
        orderedItems = new ArrayList<>();
        
        JList<String> cartList = new JList<>(cartModel);
        cartList.setFont(new Font("Monospaced", Font.PLAIN, 15));
        JScrollPane cartPane = new JScrollPane(cartList);
        cartPane.setPreferredSize(new Dimension(150,150));
        ContentPane.add(cartPane, BorderLayout.SOUTH);

        JPanel bottomPanel = new JPanel();
        ImageIcon cartlogo = new ImageIcon("src\\images\\shopppingcartWHITE.png");
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setPreferredSize(new Dimension(50,50));
        bottomPanel.setBackground(Color.black);

        totalLabel = new JLabel();
        totalLabel.setText("Total: $0.00");
        totalLabel.setIcon(cartlogo);
        totalLabel.setHorizontalAlignment(JLabel.CENTER);
        totalLabel.setForeground(Color.white);
        totalLabel.setFont(new Font("Arial",Font.BOLD,20));
        bottomPanel.add(totalLabel, BorderLayout.CENTER);
        
        JButton clearButton = new JButton();
        clearButton.setText("CLEAR CART");
        clearButton.setFont(new Font("Arial", Font.BOLD, 20));
        clearButton.setForeground(Color.white);
        clearButton.setBorderPainted(false);
        clearButton.setBackground(Color.red);
        clearButton.setFocusable(false);
        clearButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                clearCart();
            }
        });
        bottomPanel.add(clearButton, BorderLayout.WEST);

        JButton checkoutButton = new JButton();
        checkoutButton.setBackground(Color.green);
        checkoutButton.setText("Checkout");
        checkoutButton.setFocusable(false);
        checkoutButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                Checkout(user);
            }
        });
        bottomPanel.add(checkoutButton, BorderLayout.EAST);

        this.add(bottomPanel, BorderLayout.SOUTH);
    }

    
    private void addToCart(MenuItem a) 
    {
    	orderedItems.add(a);
        cartModel.addElement(a.ConvertString());
        totalPrice += a.getPrice();
        this.updateTotalLabel();
    }

    private void updateTotalLabel() 
    {
        totalLabel.setText("Total: $" + String.format("%.2f", totalPrice));
    }

    public void clearCart() 
    {
        cartModel.clear();
        orderedItems.clear();
        totalPrice = 0.0;
        this.updateTotalLabel();
    }

    private void Checkout(User user) 
    {
        if (orderedItems.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Your cart is empty. Please add items before checking out.", "Empty Cart", JOptionPane.WARNING_MESSAGE);
        }
        else 
        {
            new CheckoutWindow(orderedItems, totalPrice, user).setVisible(true);;
        }
    }
}
