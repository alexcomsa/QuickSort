package ro.alex;
/**
 * @author Alexandru Comsa
 */

import ro.alex.controller.QuickSortController;
import ro.alex.model.QuickSortModel;
import ro.alex.view.QuickSortView;

public class MainApp {

	
	public static void main(String[] args){
		
		
		QuickSortModel model = new QuickSortModel();
		
		QuickSortView view = new QuickSortView();
		QuickSortController controller = new QuickSortController(model,view);
		view.setController(controller);
	}
}
