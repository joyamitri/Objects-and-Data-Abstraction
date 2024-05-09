package Farm;

public abstract class Animal {
    // Declaring the attributes of the abstract class Animal:
	protected int age;
	protected String color;
	protected String gender;

	public Animal(int a, String c, String g)
	// Initializes the characteristics of the class by assigning a, c, g to age,
	// color and gender
	{
		age = a;
		color = c;
		gender = g;
	}

	public abstract void eat();
	// creating an abstract method eat (without a body)

	public int getAge()
	// returns the age of the animal
	{
		return age;
	}

	public void setAge(int new_age)
	// changes age to new_age
	{
		age = new_age;
	}

	public String getColor()
	// returns the color of the animal
	{
		return color;
	}

	public void setColor(String new_color)
	// changes color to new_color
	{
		color = new_color;
	}

	public String getGender()
	// returns the gender of the animal
	{
		return gender;
	}

	public void setGender(String new_gender)
	// changes gender to new_gender
	{
		gender = new_gender;
	}

	public boolean equals(Animal a)
	// returns true if two animals have the same age, color and gender, otherwise
	// returns false
	{
		return a.getAge() == age && a.getColor().equals(color) && a.getGender().equals(gender);
	}

	public String toString()
	// returns a string having the information of each characteristic of the animal
	{
		return "color: " + color + ", age: " + age + " years old, gender: " + gender;
	}
}
