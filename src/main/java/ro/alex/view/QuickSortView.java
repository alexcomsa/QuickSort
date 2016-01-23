package ro.alex.view;
/**
 * @author Alexandru Comsa
 */


import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import ro.alex.controller.QuickSortController;


public class QuickSortView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton addData;
	private JButton qSort;
	private JTextField inputData;
	private ArrayList<Integer> viewData;
	private QuickSortController controller;
	
	

	public QuickSortView(){
		super("QS-Sorter");
	
		addData = new JButton("Insert Value");
		qSort = new JButton("Sort values");
		inputData = new JTextField(5);
		viewData = new ArrayList<Integer>();
		
		addData.addActionListener(new AddDataListener());
		inputData.addActionListener(new AddDataListener());
		qSort.addActionListener(new SortValuesListener());
		this.add(addData);
		this.add(qSort);
		this.add(inputData);
		
		setLayout(new GridBagLayout());
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 400);
		pack();
		setVisible(true);
		
	}
	
	public ArrayList<Integer> getViewData() {
		return viewData;
	}

	public void setViewData(ArrayList<Integer> viewData) {
		this.viewData = viewData;
	}

	public QuickSortController getController() {
		return controller;
	}

	public void setController(QuickSortController controller) {
		this.controller = controller;
	}

	private class AddDataListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			
			Integer data = Integer.parseInt(inputData.getText());
			viewData.add(data);
			inputData.setText("");
			
		}
		
	}
	private class SortValuesListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			controller.retriceDataFromViewAndSendToModel(getViewData());
			
		}
		
	}
	
}
