/*
 * To change this license header, choose License Headers in Project 
 * To change this template file, choose 
 * and open the template in the editor.
 */

package RestaurantBillingManagementSystem;

import java.util.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

/*
 * @author MYDELL
 */

public class MenuGUI extends JFrame {

		int sizeX =650;
		int sizeY=600;
		String[] drinks = {"Juice: $160","Soda:$100","Milk:$100","None"};
		String[] appetizers = {"Artichoke Dip: $650","Chip and Salsa:$475","Wings:$550","None"};
		String[] entrees = {"CheeseBurger: $650","Prine Rib:$750","Lobster:$750","None"};
		String[] desert = {"Ice Cream: $300","Chocolate Cake:$450","Lemon Pie:$375","None"};
		JRadioButton[] drinkButtons = new JRadioButton[drinks.length];
		JRadioButton[] appetizersButtons = new JRadioButton[appetizers.length];
		JRadioButton[] entreesButtons = new JRadioButton[entrees.length];
		JRadioButton[] desertButtons = new JRadioButton[desert.length];
		ButtonGroup drinkGroup = new ButtonGroup();
		ButtonGroup appetizersGroup = new ButtonGroup();
		ButtonGroup entreesGroup = new ButtonGroup();
		ButtonGroup desertGroup = new ButtonGroup();
		String stringNumOFPeople;
		int numOfPeople;
		int count = 0;
		double billTotal;
		JTextArea output;
		JTextField nameField;
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
		static ArrayList<String> submitForm = new ArrayList();
		Border black;
		public ButtonGroup entreeGroup;
		public ButtonGroup appetizerGroup;
		
		public MenuGUI () {
			
			super("RBMS");																	//title of window
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 								//exits on close
			setPreferredSize(new Dimension(sizeX, sizeY));									//size of window
			
			Container content = getContentPane();											//Content object
			JPanel innerContent = new JPanel();												//inner Content object
			JPanel drinkButtonContent = new JPanel();										//drink Content object
			JPanel appetizerButtonContent = new JPanel();									//appetizer Content object
			JPanel entreeButtonContent = new JPanel();										//entree Content object
			JPanel desertButtonContent = new JPanel();										//desert Content object
			JButton ok = new JButton("OK");													//OK button
			JLabel title = new JLabel("Restaurant Order Application",JLabel.CENTER);		//title
			nameField = new JTextField(10);													//asks user for name
			output = new JTextArea("Restaurant\n",20,40);									//Creates the output area
			black = BorderFactory.createLineBorder(Color.BLACK);							//place border around the output
/*
 * Button panel labels.
 */
			drinkButtonContent.add(new JLabel("Select your Beverage"));
			appetizerButtonContent.add(new JLabel("Select your appetizer"));
			entreeButtonContent.add(new JLabel("Select your entree"));
			desertButtonContent.add(new JLabel("Select your desert"));
/*
 * Initializes all the buttons, adds them to groups, sets action commands,
 * and adds them to their JPanels
 */
			for(int i=0; i< drinks.length; i++){
				drinkButtons[i] = new JRadioButton(drinks[i]);
				appetizersButtons[i] = new JRadioButton(appetizers[i]);
				entreesButtons[i] = new JRadioButton(entrees[i]);
				desertButtons[i] = new JRadioButton(desert[i]);
				drinkGroup.add(drinkButtons[i]);
				appetizersGroup.add(appetizersButtons[i]);
				entreesGroup.add(entreesButtons[i]);
				desertGroup.add(desertButtons[i]);
				drinkButtons[i].getModel().setActionCommand(drinks[i]);
				appetizersButtons[i].getModel().setActionCommand(appetizers[i]);
				entreesButtons[i].getModel().setActionCommand(entrees[i]);
				desertButtons[i].getModel().setActionCommand(desert[i]);
				drinkButtonContent.add(drinkButtons[i], BorderLayout.CENTER);
				appetizerButtonContent.add(appetizersButtons[i], BorderLayout.CENTER);
				entreeButtonContent.add(entreesButtons[i], BorderLayout.CENTER);
				desertButtonContent.add(desertButtons[i], BorderLayout.CENTER);
			}
			
		content.add(title,BorderLayout.NORTH);												//adds title to content
		innerContent.add(new JLabel("Name:"));												//adds label to text field
		innerContent.add(nameField, BorderLayout.NORTH);									//adds text field
		
		/*
		* adds the button contents to the inner panel.
		*/
		innerContent.add(drinkButtonContent, BorderLayout.CENTER);
		innerContent.add(appetizerButtonContent, BorderLayout.CENTER);
		innerContent.add(entreeButtonContent, BorderLayout.CENTER);
		innerContent.add(desertButtonContent, BorderLayout.CENTER);
		
		output.setBorder(black);														//sets the border to the text area
		output.setEditable(false);										//sets text area so it cannot be edited by the user
		JScrollPane outputPane = new JScrollPane(output);
		innerContent.add(outputPane, BorderLayout.SOUTH);
		content.add(innerContent, BorderLayout.CENTER);
		content.add(ok, BorderLayout.SOUTH);
		ok.addActionListener(new MenuGUI.OKButton());
		
		pack();														//packs the frame
		setLocationRelativeTo(null);								//content the window screen
		setVisible(true);
		numPeople();												//prompts user for number of guests
		print();													//prints the instructions to the program
	}
	
	private void appetizerGroup(JRadioButton jRadioButton) {		// TODO Auto-generated method stub
			
		}

	/*
	 * inputs how many people will be dining at the restaurant and catches all exceptions
	 */
	public void numPeople()  {
		boolean badInput = true;
		while (badInput) {
			stringNumOFPeople = JOptionPane.showInputDialog(this,"How many people are we serving today?");
			try{
				numOfPeople = Integer.parseInt(stringNumOFPeople);
				if (numOfPeople >12) {
					throw new Exception();
				}
				if (numOfPeople == 0) {
					
					throw new NumberFormatException();
				}
				badInput = false;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Please enter an integer value of 1 or more");
			} catch (Exception f) {
				JOptionPane.showMessageDialog(this, "I'm sorry but our tables can only hold a maximum of 12 people,");
			}
		}
	}
	/*
	 * this method is a shortcut for printing to the TextArea
	 */
	
	public void updateText(String s) {
		output.append(s+ "\n");
	}
	/*
	 * prints program instructions to the user
	 */
	public void print() {
		updateText("*****************************************************************");
		updateText("You selected " + stringNumOFPeople + " people.");
		updateText("Click the OK button when you have finished ordering for each person");
		updateText("Continue to fill out orders for the amount of people Specified");
		updateText("Once everyone has ordered, your totale will be calculated");
		updateText("*****************************************************************");
	}
	
	/*
	 * This inner class implements the ActionListenet for the OK button
	 * It handles all circumstance in which the OK button is hit.
	 */
	private class OKButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (count <= numOfPeople) {
				try{
					String nameText = nameField.getText();
					String drinkChoice = drinkGroup.getSelection().getActionCommand();
					String appetizerChoice = appetizersGroup.getSelection().getActionCommand();
					String entreeChoice = entreesGroup.getSelection().getActionCommand();
					String desertChoice = desertGroup.getSelection().getActionCommand();
					calculateBill(drinkChoice, appetizerChoice, entreeChoice, desertChoice);
					updateText("Thank you for ordering" + nameText + ", the current total is : " + currencyFormatter.format(billTotal));
					if 
					(drinkChoice.equals(drinks[0]))
						{
						updateText(drinks[0]);
						submitForm.add(drinks[0]);
						} 
					else if 
						(drinkChoice.equals(drinks[1]))
						{
							updateText(drinks[1]);
							submitForm.add(drinks[1]);
						} else if 
						(drinkChoice.equals(drinks[2])) {
							updateText(drinks[2]);
							submitForm.add(drinks[2]);
						} else {
							updateText("You selected no drink");
						}
					if 
						(appetizerChoice.equals(appetizers[0])) 
					{
						updateText(appetizers[0]);
						submitForm.add(appetizers[0]);
						} 
					else if 
					(appetizerChoice.equals(appetizers[1]))
						{
							updateText(appetizers[1]);
							submitForm.add(appetizers[1]);
						} 
					else if 
					(appetizerChoice.equals(appetizers[2])) {
						updateText(appetizers[2]);
						submitForm.add(appetizers[3]);
						} 
					else {
						updateText("You selected no appetizer");
						}
					if 
					(entreeChoice.equals(entrees[0])) 
				{
					updateText(entrees[0]);
					submitForm.add(entrees[0]);
					} 
				else if 
				(entreeChoice.equals(entrees[1]))
					{
						updateText(entrees[1]);
						submitForm.add(entrees[1]);
					} 
				else if 
				(entreeChoice.equals(entrees[2])) 
					{
					updateText(entrees[2]);
					submitForm.add(entrees[3]);
					} 
				else {
					updateText("You selected no entree");
					}
					if 
					(desertChoice.equals(desert[0])) 
					{
					updateText(desert[0]);
					submitForm.add(desert[0]);
					} 
				else if 
				(desertChoice.equals(desert[1]))
					{
						updateText(desert[1]);
						submitForm.add(desert[1]);
					} 
				else if 
				(desertChoice.equals(desert[2])) 
					{
					updateText(desert[2]);
					submitForm.add(desert[2]);
					} 
				else {
					updateText("You selected no desert");
					}
					nameField.setText(null);
					drinkGroup.clearSelection();
					appetizerGroup.clearSelection();
					entreeGroup.clearSelection();
					desertGroup.clearSelection();
					count++;
					if (count >= numOfPeople) {
						updateText("*****************************************************************");
						updateText("Thank you for di ing at our Restaurant");
						updateText("Youd drder total is " + currencyFormatter.format(billTotal));
						updateText("Pleas press the X buttone to exit the current order form");
						updateText("*****************************************************************");
						submitForm.add("Order Total: " + currencyFormatter.format(billTotal));
					}}
					 catch (NullPointerException n) {
						 printErrorIncompleteMenu();
						 
					 }
				}
			}
		/*
		 * Error massage for when from is not complete, OR when the OK button is pressed to exit the program. 
		 */
		public void printErrorIncompleteMenu() {
			if (count >= numOfPeople) {
				updateText("Press the X button to close the current order form.");
			} else {
				//JOptionPane.showMessageDialog(rootPane,this, "Please completely full out the order form before clicking OK", count, null);
			}
		}
		/*
		 * Calculates the running total of the bill for the guest
		 */
		public void calculateBill(String drink, String app, String entree, String des) {
			if (drink.equals(drinks[0])) {
				billTotal+= 160;
			} else if (drink.equals(drinks[1])) {
				billTotal+= 100;
			} else if (drink.equals(drinks[2])) {
				billTotal+= 100;
			}
			
			if (app.equals(appetizers[0])) {
				billTotal+= 650;
			} else if (app.equals(appetizers[1])) {
				billTotal+= 475;
			} else if (app.equals(appetizers[2])) {
				billTotal+= 550;
			}
			
			if (entree.equals(entrees[0])) {
				billTotal+= 650;
			} else if (entree.equals(entrees[1])) {
				billTotal+= 1750;
			} else if (entree.equals(entrees[2])) {
				billTotal+= 3275;
			}
			if (des.equals(desert[0])) {
				billTotal+= 300;
			} else if (des.equals(desert[1])) {
				billTotal+= 450;
			} else if (des.equals(desert[2])) {
				billTotal+= 500;
			}
			
		}
		
	}
}
