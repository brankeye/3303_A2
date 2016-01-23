import java.util.ArrayList;

public class Table {

	private ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
	private boolean empty = true;
	
	public Table() {
	}
	
	// take an ingredient from the table
	public synchronized
	void get() {
		
	}
	
	// put an ingredient on the table
	public synchronized
	void put(Ingredient i) {
		ingredientList.add(i);
		empty = false;
	}
	
	public boolean isEmpty() { return empty; }
}
