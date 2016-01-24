
public class Agent extends Thread {
	
	private String name;
	private Table  table;
	private static int numIngredientsGiven = 0;
	
	public Agent(String name_t, Table table_t) {
		name  = name_t;
		table = table_t;
	}
	
	@Override
	public void run() {
		while(numIngredientsGiven < 20) {
			synchronized(table) {
				while(!table.isEmpty()) {
					try {
						table.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				placeIngredients();
				table.notifyAll();
			}
		}
		System.out.println("The agent is done.\n");
	}
	
	// put the ingredients on the table
	private void placeIngredients() {
		Ingredient itemOne = getRandomIngredient();
		Ingredient itemTwo;
		
		// make sure different ingredients are randomly chosen
		while((itemTwo = getRandomIngredient()) == itemOne);
		table.put(itemOne);
		table.put(itemTwo);
		numIngredientsGiven++;
		System.out.println(name + " has placed " + itemOne.toString() + " and " + itemTwo.toString() + " on the table.\n");
	}
	
	// retrieve a random ingredient
	private Ingredient getRandomIngredient() {
		int index = (int)(Math.random() * Ingredient.values().length); 
		return Ingredient.values()[index];
	}
}
