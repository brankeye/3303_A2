
public class Main {
	public static void main(String[] args) {
		
		// instantiate the table
		Table table = new Table();
		
		// instantiate the agent/chef threads
		Agent agent = new Agent("Agent", table);
		Chef  breadChef = new Chef("BreadChef", table, Ingredient.BREAD);
		Chef  baconChef = new Chef("BaconChef", table, Ingredient.BACON);
		Chef  bananaChef = new Chef("BananaChef", table, Ingredient.BANANA);
		
		// start the threads
		agent.start();
		breadChef.start();
		baconChef.start();
		bananaChef.start();
	}
}
