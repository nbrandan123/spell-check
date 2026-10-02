package newsom;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.util.Scanner;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ScrollPaneConstants;

public class Main {

	private JFrame frame;
	// Initialize the dictionary BST
	static Dictionary dTree = new Dictionary();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// Load dictionary via file path found in arguments
		if (args.length > 0) {
			String filePath = args[0];
			File dict = new File(filePath);
			try (Scanner scanner = new Scanner(dict)) {
	            while (scanner.hasNext()) {
	                // Scan each word of the document and convert it to lower case, then add to BST
	                dTree.insertWordNode(scanner.next().toLowerCase());
	            }
	        } catch (FileNotFoundException e) {
	            System.err.println("Error: The file could not be found at " + filePath);
	        }
	    }
		//System.out.println(dTree.root.key);
		
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
		frame.setBounds(100, 100, 450, 285);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 51, 414, 133);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		
		JLabel lblNewLabel = new JLabel("Spell Checker");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(144, 11, 144, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnDisplay = new JButton("Show Dictionary");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// On button press, will display the dictionary in alphabetical order
				dTree.inorder();
				textArea.setText(dTree.displayTxt);
			}
		});
		btnDisplay.setBounds(237, 195, 138, 36);
		frame.getContentPane().add(btnDisplay);
		
		JButton btnCheck = new JButton("Check Spelling");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// On button press, will check words in the text area against the BST dictionary
				// UserTxt stores the text in the textArea
				// Array words stores each word in textArea for ease of looping
				// misspelled String is to hold any words that are flagged as incorrect
				// misWords is the array to hold misspelled words for display in textArea
				String userTxt;
				userTxt = textArea.getText().toLowerCase();
				String[] words = userTxt.split(" ");
				String misspelled = "";
				for (int i = 0; i < words.length; i++) {
					if (!dTree.check(words[i])) {
						misspelled += words[i] + " ";
					}
				}
				String[] misWords = misspelled.split(" ");
				textArea.setText(userTxt + "\n" + "These words are misspelled or not recognized: " + String.join(", ", misWords));
			}
		});
		btnCheck.setBounds(55, 195, 138, 36);
		frame.getContentPane().add(btnCheck);
	}
}
