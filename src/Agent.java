
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
		while(numIngredientsGiven++ < 20) {
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
	
	public void placeIngredients() {
		Ingredient itemOne = getRandomIngredient();
		Ingredient itemTwo;
		while((itemTwo = getRandomIngredient()) == itemOne);
		table.put(itemOne);
		table.put(itemTwo);
		System.out.println(name + " has placed " + itemOne.toString() + " and " + itemTwo.toString() + " on the table.\n");
	}
	
	public Ingredient getRandomIngredient() {
		int index = (int)(Math.random() * Ingredient.values().length); 
		return Ingredient.values()[index];
	}
}
