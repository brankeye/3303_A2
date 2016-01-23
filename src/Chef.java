
public class Chef extends Thread {

	private String     name; // literally the chefs name
	private Table      table; // the table they take food from
	private Ingredient ingredient; // chef has infinite amount
	
	public Chef(String name_t, Table table_t, Ingredient ing_t) {
		name 	   = name_t;
		table      = table_t;
		ingredient = ing_t;
	}
	
	@Override
	public void run() {
		
	}
}
