import java.util.ArrayList;

public class Chef extends Thread {

	private String     name; // literally the chefs name
	private Table      table; // the table they take food from
	private Ingredient infiniteIngredient; // chef has infinite amount
	private ArrayList<Ingredient> ingredientBag = new ArrayList<Ingredient>();
	private static int numSandwichesMade = 0;
	
	public Chef(String name_t, Table table_t, Ingredient ing_t) {
		name 	   = name_t;
		table      = table_t;
		infiniteIngredient = ing_t;
	}
	
	@Override
	public void run() {
		while(numSandwichesMade < 20) {
			synchronized(table) {
				try {
					while(table.isEmpty()) {
						table.wait();
					}
					ArrayList<Ingredient> list = table.getIngredientList();
					if(list.get(0) != infiniteIngredient && list.get(1) != infiniteIngredient) {
						ingredientBag = table.get();
						System.out.println(name + " has taken " + ingredientBag.get(0).toString() + " and " + ingredientBag.get(1).toString() + " from the table.");
						table.notifyAll();
						makeSandwich();
					} else {
						table.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println("The chefs are done.\n");
	}
	
	// make a sandwich with all ingredients
	private void makeSandwich() {
		System.out.println(name + " made a sandwich with " + infiniteIngredient.toString() + ", " + 
														     ingredientBag.get(0).toString() + ", and " +
														     ingredientBag.get(1).toString() + ".");
		numSandwichesMade++;
		System.out.println(numSandwichesMade + " sandwiches have been made.\n");
		ingredientBag.clear();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
