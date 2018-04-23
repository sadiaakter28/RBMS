package RestaurantBillingManagementSystem;

          import java.awt.Color;
		  import java.awt.Container;
		  import java.awt.Dimension;
		  import java.awt.event.ActionEvent;
		  import java.awt.event.ActionListener;
		  import javax.swing.BorderFactory;
		  import javax.swing.JButton;
		  import javax.swing.JFrame;
		  import javax.swing.JPanel;
		  import javax.swing.JScrollPane;
		  import javax.swing.JTextArea;
		  import javax.swing.border.Border;
import javax.swing.SwingConstants;
 
		  public class TableWindow extends JFrame {
			  int sizeX = 430;
			  int sizeY = 530;
		   MenuGUI mTable1, mTable2, mTable3, mTable4, mTable5, mTable6, mTable7, mTable8, mTable9, mTable10;
		   JButton  table1, table2, table3, table4, table5, table6, table7, table8, table9, table10, submit, clear;
		   JTextArea kitchenForm;
		   JScrollPane kitchenFormPane;
		   
		   public TableWindow() {
		    super("RBMS"); 													//title of window
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 				// exits on close
		    setPreferredSize(new Dimension(sizeX, sizeY)); 					// size of window
		    Container content = getContentPane();
		    JPanel innerContent = new JPanel();
		    JPanel button1 = new JPanel();
		    JPanel button2 = new JPanel();
		    JPanel button3 = new JPanel();
		    JPanel button4 = new JPanel();
		    JPanel button5 = new JPanel();
		    JPanel button6 = new JPanel();
		    JPanel button7 = new JPanel();
		    JPanel clearPanel = new JPanel();
		    Border black = BorderFactory.createLineBorder(Color.BLACK);
		    kitchenFormPane = new JScrollPane();
		    table1 = new JButton("Table 1");
		    table2 = new JButton("Table 2");
		    table3 = new JButton("Table 3");
		    table4 = new JButton("Table 4");
		    table5 = new JButton("Table 5");
		    table6 = new JButton("Table 6");
		    table7 = new JButton("Table 7");
		    clear = new JButton("Clear");
		    button1.add(table1);
		    button2.add(table2);
		    button3.add(table3);
		    button4.add(table4);
		    button5.add(table5);
		    button6.add(table6);
		    button7.add(table7);
		    clearPanel.add(clear);
		    innerContent.add(button1);
		    innerContent.add(button2);
		    innerContent.add(button3);
		    innerContent.add(button4);
		    innerContent.add(button5);
		    innerContent.add(button6);
		    innerContent.add(button7);
		    JPanel button8 = new JPanel();
		    table8 = new JButton("Table 8");
		    button8.add(table8);
		    innerContent.add(button8);
		    table8.addActionListener(new TableWindow.TableButton8());
		    JPanel button9 = new JPanel();
		    table9 = new JButton("Table 9");
		    button9.add(table9);
		    innerContent.add(button9);
		    table9.addActionListener(new TableWindow.TableButton9());
		    JPanel button10 = new JPanel();
		    table10 = new JButton("Table 10");
		    button10.add(table10);
		    innerContent.add(button10);
		    table10.addActionListener(new TableWindow.TableButton10());
		    kitchenForm = new JTextArea("INSTUCTION#\nClick on a table"
		      + "to fill out the order form\n"
		      + "Click the Submit Button to submit orders"
		      + "\nwhenall tables have placed their orders"
		      + "\nPress the Clear Button to clear orders"
		      + "\n\nKITCHEN: CURRENT ORDERS:\n", 20, 30);
		    innerContent.add(kitchenForm);
		    kitchenForm.setBorder(black);
		    kitchenForm.setEditable(false);
		    JPanel submitPanel = new JPanel();
		    innerContent.add(submitPanel);
		    submit = new JButton("Submit");
		    submitPanel.add(submit);
		    submit.addActionListener(new TableWindow.Submit());
		    innerContent.add(clearPanel);
		    innerContent.add(kitchenFormPane);
		    content.add(innerContent);
		    table1.addActionListener(new TableWindow.TableButton1());
		    table2.addActionListener(new TableWindow.TableButton2());
		    table3.addActionListener(new TableWindow.TableButton3());
		    table4.addActionListener(new TableWindow.TableButton4());
		    table5.addActionListener(new TableWindow.TableButton5());
		    table6.addActionListener(new TableWindow.TableButton6());
		    table7.addActionListener(new TableWindow.TableButton7());
		    clear.addActionListener(new TableWindow.Clear());
		    pack();// packs the frame
		    setVisible(true);// makes frame visible
		   }
		   
		   private class TableButton1 implements ActionListener {
		    
		    @Override
		    public void actionPerformed(ActionEvent e) {
		     MenuGUI.submitForm.add("\nTABLE 1:");
		     mTable1 = new MenuGUI();
		   
		     
		    }
		    
		   }
		   
		   
		   private class TableButton2 implements ActionListener {
		    
		    @Override
		    public void actionPerformed(ActionEvent e) {
		     
		     MenuGUI.submitForm.add("\nTABLE 2:");
		     mTable2 = new MenuGUI();
		   
		    }
		     
		   }
		  private class TableButton3 implements ActionListener {
		   
		   @Override
		   public void actionPerformed(ActionEvent e) {
		    MenuGUI.submitForm.add("\nTABLE 3:");
		    mTable3 = new MenuGUI();
		    
		   }
		  } 
		    
		  private class TableButton4 implements ActionListener {
		   
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    MenuGUI.submitForm.add("\nTABLE 4:");
		    
		    mTable4 = new MenuGUI();
		    
		    }
		    
		  }
		  
		  private class TableButton5 implements ActionListener {
		   @Override
		   public void actionPerformed(ActionEvent e) {
		    MenuGUI.submitForm.add("\nTABLE 5:");
		    mTable5 = new MenuGUI();
		    
		   }
		  }
		  
		  private class TableButton6 implements ActionListener {
		   @Override
		   public void actionPerformed(ActionEvent e) {
		    MenuGUI.submitForm.add("\nTABLE 6:");
		    mTable6 = new MenuGUI();
		    
		   }
		  }
		  
		  private class TableButton7 implements ActionListener {
		   @Override
		   public void actionPerformed(ActionEvent e) {
		    MenuGUI.submitForm.add("\nTABLE 7:");
		    mTable7 = new MenuGUI();
		    
		   }
		  }
		  
		  private class TableButton8 implements ActionListener {
		   @Override
		   public void actionPerformed(ActionEvent e) {
		    MenuGUI.submitForm.add("\nTABLE 8:");
		    mTable8 = new MenuGUI();
		    
		   }
		  }
		    
		  private class TableButton9 implements ActionListener {
		   @Override
		   public void actionPerformed(ActionEvent e) {
		    MenuGUI.submitForm.add("\nTABLE 9:");
		    mTable9 = new MenuGUI();
		    
		   }
		  }  
		    
		  
		  private class TableButton10 implements ActionListener {
		   @Override
		   public void actionPerformed(ActionEvent e) {
		    MenuGUI.submitForm.add("\nTABLE 10:");
		    mTable10 = new MenuGUI();
		    
		   }
		  }  
		  
		  private class Submit implements ActionListener {
		   
		   @Override
		   public void actionPerformed(ActionEvent e) {
		    for (int i = 0; i < MenuGUI.submitForm.size(); i++) {
		     kitchenForm.append(MenuGUI.submitForm.get(i) + "\n");
		     
		    }
		    
		   }
		  }
		  
		  private class Clear implements ActionListener {
		   
		   
		   @Override
		   public void actionPerformed(ActionEvent e) {
		    MenuGUI.submitForm.clear();
		    kitchenForm.setText("INSTRUCTIONS:\nClick on a table"
		    + "to fill out the order form\n"
		    + "Click the Submit Button to submit orders"
		    + "\nwhen all tables have placed their orders"
		    + "\nPress the Clear Button to clear orders"
		    + "\n"
		    + "\n\nKITCHEN: CURRENT ORDERS:\n");
		    
		   } 
		   } 
		}
		  


