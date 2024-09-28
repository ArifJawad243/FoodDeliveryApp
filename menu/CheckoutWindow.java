package menu;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import user.User;


public class CheckoutWindow extends JFrame
{
	private ArrayList<MenuItem> orderedItems;
    private DefaultListModel<String> orderListModel;
    private JTextField nameField, phoneField, addressField, cardNumberField;
    private JRadioButton cashRadioButton, cardRadioButton;
    private JComboBox<String> cardTypeComboBox;
    private JPanel cardDetailsPanel;
    private ButtonGroup paymentButttonGroup;

    public CheckoutWindow(ArrayList<MenuItem> orderedItems, double totalPrice, User user) {
        this.orderedItems = orderedItems;

        this.setTitle("Checkout");
        this.setSize(500, 800);
        this.setBackground(Color.lightGray);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        
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
        
        JPanel BodyPane = new JPanel();
        BodyPane.setLayout(new BorderLayout());
        //BodyPane.setBackground(Color.lightGray);
        this.add(BodyPane, BorderLayout.CENTER);
        
        
        orderListModel = new DefaultListModel<>();
        for (MenuItem item : this.orderedItems) 
        {
            orderListModel.addElement(item.ConvertString());
        }
        JList<String> orderList = new JList<>(orderListModel);
        orderList.setFont(new Font("Monospaced", Font.PLAIN, 15));
        JScrollPane orderScrollPane = new JScrollPane(orderList);
        orderScrollPane.setPreferredSize(new Dimension(150,150));
        
        //centerPanel.add(orderScrollPane, BorderLayout.CENTER);

        
        
        JPanel inputPanel = new JPanel();
        
        inputPanel.setLayout(new GridLayout(4, 2, 0, 5));
        //inputPanel.setBackground(Color.lightGray);
        
        JLabel l1 = new JLabel("Name:");
        inputPanel.add(l1);
        
        nameField = new JTextField(user.getUsername());
        inputPanel.add(nameField);
        
        JLabel l2 = new JLabel("Phone Number:");
        inputPanel.add(l2);
        
        phoneField = new JTextField(user.getPhone());
        inputPanel.add(phoneField);
        
        JLabel l3 = new JLabel("Address:");
        inputPanel.add(l3);
        addressField = new JTextField();
        inputPanel.add(addressField);

        inputPanel.add(new JLabel("Payment Method:"));
        
        cashRadioButton = new JRadioButton("Cash");
        //cashRadioButton.setBackground(Color.LIGHT_GRAY);
        
        cardRadioButton = new JRadioButton("Card");
        //cardRadioButton.setBackground(Color.LIGHT_GRAY);
        paymentButttonGroup = new ButtonGroup();
        paymentButttonGroup.add(cashRadioButton);
        paymentButttonGroup.add(cardRadioButton);
        
        
        JPanel paymentPanel = new JPanel(new FlowLayout());
        paymentPanel.add(cashRadioButton);
        paymentPanel.add(cardRadioButton);
        inputPanel.add(paymentPanel);
        
        
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        //centerPanel.setBackground(Color.lightGray);
        centerPanel.add(orderScrollPane, BorderLayout.SOUTH);

        BodyPane.add(inputPanel, BorderLayout.NORTH);

        cardDetailsPanel = new JPanel();
        //cardDetailsPanel.setBackground(Color.LIGHT_GRAY);
        cardDetailsPanel.setPreferredSize(new Dimension(400,80));
        cardDetailsPanel.add(new JLabel("Card Type:"));
        
        
        String[] cards = new String[] {"Visa", "MasterCard", "American Express"};       
        cardTypeComboBox = new JComboBox<>(cards);
        cardDetailsPanel.add(cardTypeComboBox);
        JLabel cardNumber = new JLabel("Card Number:");
        cardDetailsPanel.add(cardNumber);
        //cardDetailsPanel.setBackground(Color.gray);
        cardDetailsPanel.setLayout(new GridLayout(2, 1, 50, 5));
        cardNumberField = new JTextField();
        cardDetailsPanel.add(cardNumberField);
        cardDetailsPanel.setVisible(false);
        
        centerPanel.add(cardDetailsPanel, BorderLayout.NORTH);
        BodyPane.add(centerPanel, BorderLayout.CENTER);

        cardRadioButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                cardDetailsPanel.setVisible(true);
            }
        });

        
        cashRadioButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                cardDetailsPanel.setVisible(false);
            }
        });


        
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        JLabel totalLabel = new JLabel();
        totalLabel.setText("Total: $" + String.format("%.2f", totalPrice));
        totalLabel.setFont(new Font("Monospaced", Font.PLAIN, 20));
        bottomPanel.add(totalLabel, BorderLayout.NORTH);

        JButton confirmButton = new JButton("Confirm Order");
        confirmButton.setBackground(Color.green);
        confirmButton.setForeground(Color.BLACK);
        confirmButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                confirmOrder();
            }
        });
        bottomPanel.add(confirmButton, BorderLayout.SOUTH);

        BodyPane.add(bottomPanel, BorderLayout.SOUTH);
    }

    
    
    
    private void confirmOrder() 
    {
        String name = nameField.getText();
        String phone = phoneField.getText();
        String address = addressField.getText();
        String paymentMethod;
        if(cardRadioButton.isSelected() == true)
        {
        	paymentMethod = "Card";
        }
        else
        {
        	paymentMethod = "Cash";
        }
        String orderDetails = "Order for " + name + " confirmed!\nPhone: " + phone + "\nAddress: " + address + "\nPayment Method: " + paymentMethod + "\nThank you for your order!";

        if (name.isEmpty() || phone.isEmpty() || address.isEmpty() || (cardRadioButton.isSelected() == false && cashRadioButton.isSelected() == false)) 
        {
            JOptionPane.showMessageDialog(this, "Please proide contact details and select a payment method.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (cardRadioButton.isSelected() == true) 
        {
            String cardNumber = cardNumberField.getText();

            if (cardNumber.isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Please enter your card number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else 
            {
                JOptionPane.showMessageDialog(this, orderDetails, "Order Confirmed", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        }
        else 
        {
            JOptionPane.showMessageDialog(this, orderDetails, "Order Confirmed", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }
    }
}