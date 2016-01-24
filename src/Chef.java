import java.util.ArrayList;

public class Chef extends Thread {

	private String     name; // literally the chefs name
	private Agent      agent;
	private Table      table; // the table they take food from
	private Ingredient infiniteIngredient; // chef has infinite amount
	private ArrayList<Ingredient> ingredientBag = new ArrayList<Ingredient>();
	
	public Chef(String name_t, Agent agent_t, Table table_t, Ingredient ing_t) {
		name 	   = name_t;
		agent      = agent_t;
		table      = table_t;
		infiniteIngredient = ing_t;
	}
	
	@Override
	public void run() {
		while(true) {
			synchronized(table) {
				try {
					while(table.isEmpty()) {
						table.wait();
					}
					ArrayList<Ingredient> list = table.getIngredientList();
					if(list.get(0) != infiniteIngredient && list.get(1) != infiniteIngredient) {
						takeIngredients();
						table.notifyAll();
						makeSandwich();
					} else {
						table.wait();
					}
					//table.notifyAll();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void makeSandwich() {
		System.out.println(name + " is making a sandwich with " + infiniteIngredient.toString() + ", " + 
																  ingredientBag.get(0).toString() + ", and " +
																  ingredientBag.get(1).toString() + ".\n");
		ingredientBag.clear();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void takeIngredients() {
		ingredientBag = table.get();
		System.out.println(name + " has taken " + ingredientBag.get(0).toString() + " and " + ingredientBag.get(1).toString() + " from the table.");
	}
}
