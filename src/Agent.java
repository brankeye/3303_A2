
public class Agent extends Thread {
	
	private String name;
	private Table  table;
	
	public Agent(String name_t, Table table_t) {
		name  = name_t;
		table = table_t;
	}
	
	@Override
	public void run() {
		while(!table.isEmpty()) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		placeIngredients();
	}
	
	public void placeIngredients() {
		table.put(getRandomIngredient());
		table.put(getRandomIngredient());
	}
	
	public Ingredient getRandomIngredient() {
		int index = (int)(Math.random() * Ingredient.values().length); 
		return Ingredient.values()[index];
	}
}
