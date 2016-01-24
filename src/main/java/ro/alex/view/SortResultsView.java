package ro.alex.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/*
 * @author Alexandru Comsa
 */

public class SortResultsView extends JDialog{

	
	
	
	private static final long serialVersionUID = 1L;
	
	private Border border = BorderFactory.createLineBorder(Color.GRAY, 2);
	
	private JLabel sortOrder = new JLabel("Sorted Order ");
	private JLabel insertionOrder = new JLabel("Insertion Order");
	 private Font dataF = new Font("Serif", Font.PLAIN, 14);
	
	
	private  SortResultsView(JFrame parent, int solution[], ArrayList<Integer> arrayList){
		super(parent, "Solution", true);
	  
		if (parent != null) {
	      Dimension parentSize = parent.getSize(); 
	      Point p = parent.getLocation(); 
	      setLocation(p.x + parentSize.width / 4, p.y + parentSize.height / 4);
	    }
		

	     
	  
	  
	  
	    setLayout(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
	     this.add(sortOrder);
	    for(int i = 0 ; i< solution.length;i++){
	    	
	    
	    		
	    		gbc.fill = GridBagConstraints.HORIZONTAL;
	    		gbc.gridx = i;
	    		gbc.gridy = 1;
	    		
	    		
	    		
	    		JLabel jLabel = new JLabel();
	    		jLabel.setText(Integer.toString(solution[i]));
	    		jLabel.setFont(dataF);
	    		
	    		jLabel.setBorder(border);
	    		
	    		this.add(jLabel,gbc);
	    	}
	    
	    gbc.gridwidth =2;
	    gbc.gridx = 0;
		gbc.gridy = 2;
	    
		this.add(insertionOrder,gbc);
	    for(int x = 0; x<arrayList.size();x++){

    		gbc.fill = GridBagConstraints.HORIZONTAL;
    		gbc.gridx = x;
    		gbc.gridy = 3;
    		
    		

    		JLabel jLabel = new JLabel();
    		jLabel.setText(Integer.toString(arrayList.get(x)));
    		jLabel.setFont(dataF);
    		jLabel.setSize(300,300);
    		jLabel.setBorder(border);
    		
    		this.add(jLabel,gbc);
	    	
	    }
	    
	    JPanel buttonPane = new JPanel();
	    JButton button = new JButton("Close Solution View"); 
	    button.addActionListener(new ButtonListener());
	    gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 4;
	    buttonPane.add(button); 
	    this.add(buttonPane,gbc);
	    
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	
	   
	    this.setSize(500, 500);
	    pack(); 
	    setVisible(true);
	    	
	    }
	   

	 
	  
         
         
	
	public static SortResultsView displaySolution(int[] solution, ArrayList<Integer> arrayList, JFrame parent) {
		return new SortResultsView(parent,solution,arrayList);
		
	}
	
	
	
	private class ButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			dispose();
			
		}
		
	}

}
