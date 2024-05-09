package Farm;

public class Lamb extends Animal{
    public Lamb(int a,String c, String g)
	//Initializes the characteristics of the class by assigning a, c, g to age, color and gender by calling
	//the super class
	{
		super(a,c,g);
	}
	
	public void eat()
	//prints a message informing the user how much food does a lamb eat daily
	{
		System.out.println("A lamb consumes 2kg of food");
	}
}
