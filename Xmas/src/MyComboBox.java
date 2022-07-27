import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class MyComboBox extends AbstractListModel<Integer> implements ComboBoxModel<Integer>{
	private final int[] layers = {5, 6, 7, 8, 9, 10, 11};
	int selectedItem;
	
	public MyComboBox() {
		this.setSelectedItem(this.getElementAt(0));
	}
	
	@Override
	public Integer getElementAt(int index) {
		return layers[index];
	}

	@Override
	public int getSize() {
		return layers.length;
	}

	@Override
	public Object getSelectedItem() {
		return selectedItem;
	}

	@Override
	public void setSelectedItem(Object item) {
		selectedItem = (int) item;
		
	}

}
