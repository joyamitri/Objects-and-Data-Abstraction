package Farm;

public class Goat extends Animal{
    public Goat(int a, String c, String g)
	// Initializes the characteristics of the class by assigning a, c, g to age,
	// color and gender by calling
	// the super class
	{
		super(a, c, g);
	}

	public void eat()
	// prints a message informing the user how much food does a goat eat daily
	{
		System.out.println("A goat consumes 7kg of food");
	}
}
