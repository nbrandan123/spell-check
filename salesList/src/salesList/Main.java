package salesList;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.DropMode;
import javax.swing.JTextArea;

public class Main {

	private JFrame frame;
	private JTextField textItem;
	private JTextField textPrice;
	private JTextField textCount;
	private JTextField textTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 0, 434, 38);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Sales List");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(55, 164, 321, 90);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textList = new JTextArea();
		textList.setEditable(false);
		scrollPane.setViewportView(textList);
		
		JLabel lblItem = new JLabel("Item:");
		lblItem.setHorizontalAlignment(SwingConstants.RIGHT);
		lblItem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblItem.setBounds(55, 49, 70, 14);
		frame.getContentPane().add(lblItem);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrice.setBounds(55, 74, 70, 14);
		frame.getContentPane().add(lblPrice);
		
		JLabel lblCount = new JLabel("Quantity:");
		lblCount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCount.setBounds(55, 99, 70, 14);
		frame.getContentPane().add(lblCount);
		
		textItem = new JTextField();
		textItem.setBounds(135, 49, 201, 20);
		frame.getContentPane().add(textItem);
		textItem.setColumns(10);
		
		textPrice = new JTextField();
		textPrice.setColumns(10);
		textPrice.setBounds(135, 73, 201, 20);
		frame.getContentPane().add(textPrice);
		
		textCount = new JTextField();
		textCount.setColumns(10);
		textCount.setBounds(135, 98, 201, 20);
		frame.getContentPane().add(textCount);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotal.setBounds(55, 265, 70, 14);
		frame.getContentPane().add(lblTotal);
		
		textTotal = new JTextField();
		textTotal.setEditable(false);
		textTotal.setBounds(135, 264, 201, 20);
		frame.getContentPane().add(textTotal);
		textTotal.setColumns(10);
		
		salesSlip mList = new salesSlip();
		
		JButton btnAdd = new JButton("Add Item");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// When button is activated, first check all fields for a valid entry
				if (textItem.getText().trim().isEmpty()) {
					textTotal.setText("Please enter an item.");
					return;
				} 
				if (textPrice.getText().trim().isEmpty() || textPrice.getText().matches(".*[a-zA-Z].*")) {
					textTotal.setText("Please enter a valid price.");
					return;
				}
				if (textCount.getText().trim().isEmpty() || textCount.getText().matches(".*[a-zA-Z].*")) {
					textTotal.setText("Please enter a valid quantity.");
					return;
				}
				
				// Assuming all fields have been entered, proceed by creating new SalesItem
				SalesItem newItem = new SalesItem(textItem.getText(), textPrice.getText(), textCount.getText());
				
				// Then store this new SalesItem into an array
				mList.addItem(newItem);
				
				// Apply values to the window
				textList.setText(textList.getText() + newItem.toList(newItem));
				textTotal.setText("$" + mList.itemTotal(mList.getMasterSalesList()));
			}
		});
		btnAdd.setBounds(145, 129, 177, 23);
		frame.getContentPane().add(btnAdd);
	}
}
