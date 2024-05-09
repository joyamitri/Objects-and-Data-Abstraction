package Farm;

public class Chicken extends Animal{
    public Chicken(int a, String c, String g)
	// Initializes the characteristics of the class by assigning a, c, g to age,
	// color and gender by calling
	// the super class
	{
		super(a, c, g);
	}

	public void eat()
	// prints a message informing the user how much food does a chicken eat daily
	{
		System.out.println("A chicken consumes 0.25kg of food");
	}
}
