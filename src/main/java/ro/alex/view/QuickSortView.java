package ro.alex.view;

/**
 * @author Alexandru Comsa
 */

import java.awt.GridBagConstraints;
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
	private JButton clearList;
	private JTextField inputData;
	private SortResultsView resultView;
	private ArrayList<Integer> viewData;
	private QuickSortController controller;

	public QuickSortView() {
		super("QS-Sorter");

		addData = new JButton("Insert Value");
		qSort = new JButton("Sort values");
		clearList = new JButton("Clear List");
		inputData = new JTextField(5);
		viewData = new ArrayList<Integer>();

		addData.addActionListener(new AddDataListener());
		inputData.addActionListener(new AddDataListener());
		qSort.addActionListener(new SortValuesListener());
		clearList.addActionListener(new ClearListListener());

		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(inputData, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(addData, gbc);

		

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.ipady = 20;
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(qSort, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 3;
		this.add(clearList,gbc);

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

	private class AddDataListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {

			Integer data = Integer.parseInt(inputData.getText());
			viewData.add(data);
			inputData.setText("");

		}

	}

	private class SortValuesListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			controller.retriceDataFromViewAndSendToModel(getViewData());

		}

	}
	
	private class ClearListListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			clearViewData();

		}

	}

	public void displayResults(int[] solution) {
		
		setResultView(SortResultsView.displaySolution(solution, getViewData(),
				this));

	}

	public void clearViewData() {
		this.viewData.clear();
		System.out.println("The data collected by the view has been deleted");
	}

	public SortResultsView getResultView() {
		return resultView;
	}

	public void setResultView(SortResultsView resultView) {
		this.resultView = resultView;
	}

}
