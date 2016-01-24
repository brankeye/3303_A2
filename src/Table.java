import java.util.ArrayList;

public class Table {

	private ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
	private boolean empty = true;
	
	public Table() {
	}
	
	// take an ingredient from the table
	public ArrayList<Ingredient> get() {
		ArrayList<Ingredient> list = new ArrayList<Ingredient>(ingredientList);
		ingredientList.clear();
		empty = true;
		return list;
	}
	
	// put an ingredient on the table
	public void put(Ingredient i) {
		ingredientList.add(i);
		empty = false;
	}
	
	public ArrayList<Ingredient> getIngredientList() { return ingredientList; }
	public boolean isEmpty() { return empty; }
}
