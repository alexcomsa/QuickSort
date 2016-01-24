package ro.alex.controller;
/**
 * @author Alexandru Comsa
 */

import java.util.ArrayList;

import ro.alex.model.QuickSortModel;
import ro.alex.view.QuickSortView;


public class QuickSortController {
	private QuickSortModel model;
	private QuickSortView view;

	/**
	 * @param model
	 * @param view
	 */
	public QuickSortController(QuickSortModel model, QuickSortView view) {
		
		this.model = model;
		this.view = view;
	}

	public QuickSortModel getModel() {
		return model;
	}

	public void setModel(QuickSortModel model) {
		this.model = model;
	}

	public QuickSortView getView() {
		return view;
	}

	public void setView(QuickSortView view) {
		this.view = view;
	}

	public void retriceDataFromViewAndSendToModel(ArrayList<Integer> arrayList) {
		int size = arrayList.size();
		int[] viewCollector = new int[size];
		for (int i = 0; i < size; i++) {
			viewCollector[i] = arrayList.get(i);
		}
		model.setNumbers(viewCollector);
		model.setNumber(size);
		model.sort();
		view.displayResults(model.getNumbers());
	}

}
