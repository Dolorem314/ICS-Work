import hsa.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.*;

class IndigenousCultureJourney
{
    int menuChoice = 0;
    String name;
    int mazeQuestion;
    int mazeChoice;
    int mazeScore = 0; //not in plan
    int personX;
    int personY;
    int turtleX = 640;
    int tricksterX = 180;
    int fishX = 640;
    Console c;

    String[] names = new String [10];
    int[] scores = new int [10];

    //Colour Variables
    Color lightYellow = new Color (255, 238, 177);
    Color peach = new Color (241, 222, 205);
    Color oakBrown = new Color (171, 142, 56);
    Color lightGrey = new Color (166, 166, 166);
    Color dullGreen = new Color (119, 162, 144);
    Color lightBlue = new Color (106, 184, 242);
    Color mediumGrey = new Color (116, 116, 116);
    Color darkGrey = new Color (84, 84, 84);
    Color darkBrown = new Color (90, 66, 63);
    Color brightBlue = new Color (46, 133, 198);
    Color brightGreen = new Color (0, 193, 128);
    Color darkGreen = new Color (0, 99, 66);
    Color nightSky = new Color (0, 67, 137);
    Color magenta = new Color (202, 0, 185);
    Color lightPink = new Color (255, 163, 198);
    Color darkRed = new Color (105, 0, 26);
    Color lime = new Color (0, 223, 70);
    Color pinkPeach = new Color (255, 210, 195);
    Color orange = new Color (255, 153, 0);
    Color yellow = new Color (255, 255, 0);

    public IndigenousCultureJourney ()
    {
	c = new Console ("Indigenous Culture Journey");
    }


    public void splashScreen ()
    {
	classBackground ();
	c.setFont (new Font ("Sitka Text", Font.ITALIC, 30));
	c.setColor (darkBrown);
	c.drawString ("Indigenous Culture", 93, 43);
	c.drawString ("Learning Journey", 108, 73);
	c.setColor (Color.WHITE);
	c.drawString ("Indigenous Culture", 90, 40);
	c.drawString ("Learning Journey", 105, 70);

	try
	{ // imports image
	    BufferedImage teacherImage = ImageIO.read (new File ("TeacherImageISP.png"));
	    for (int i = 500 ; i >= 400 ; i--)
	    {
		c.setColor (peach);
		c.fillRect (i, 35, 175, 435);
		c.setColor (darkBrown);
		c.fillRect (i, 470, 175, 5);

		c.drawImage (teacherImage, i, 35, null);
		try
		{
		    Thread.sleep (50);
		}
		catch (Exception e)
		{
		}
	    }
	}
	catch (IOException e)
	{
	}

	c.setColour (Color.WHITE);
	c.setFont (new Font ("Sitka Text", Font.ITALIC, 15));
	c.drawString ("Press any key to continue", 5, 490);
	c.getChar ();
    }


    public void askData ()
    {
	title ();
	flowers ();
	c.print ("Hello User! Please enter your name or pseudonym: ");
	while (true)
	{
	    try
	    {
		c.setCursor (4, 50);
		name = c.readLine ();
		if (name.length () == 0)
		{
		    throw new ArithmeticException ();
		}
	    }
	    catch (ArithmeticException e)
	    {
		new Message ("You have not entered anything. Please enter your name or pseudonym");
		continue;
	    }
	    break;
	}
    }


    public void mainMenu ()
    {
	title ();
	c.println ("Hello " + name + "! Welcome to Indigenous Culture Journey! \n");
	c.println ("Please select one of the options:");
	c.println ("  1. Level 1: Animated Introductions");
	c.println ("  2. Level 2: Maze of Learning");
	c.println ("  3. Level 3: Game of Testing");
	c.println ("  4. Instructions");
	c.println ("  5. High Scores");
	c.println ("  6. Exit\n");
	c.print ("Enter your choice: ");

	while (true)
	{
	    c.setCursor (14, 20);
	    c.println ("\n\n\n\n\n\n");
	    c.setCursor (14, 20);
	    try
	    {
		menuChoice = Integer.parseInt (c.readLine ()); // read user input
		if (menuChoice < 1 || menuChoice > 6)
		{
		    throw new ArithmeticException ();
		}
	    }
	    catch (NumberFormatException e)
	    {
		new Message ("Enter an integer!", "Error");
		continue;
	    }
	    catch (ArithmeticException e)
	    {
		new Message ("The integer should be from 1 to 6!", "Error");
		continue;
	    }
	    break;
	}
    }


    private void turtleLeft ()
    {
	try
	{ // imports image
	    BufferedImage turtleImage = ImageIO.read (new File ("NewTurtleISP.png"));
	    for (int i = turtleX ; i >= 200 ; i--)
	    {
		c.setColor (nightSky);
		c.fillOval (70 + i - 1, 150, 170, 130);
		c.fillOval (5 + i - 1, 220, 72, 72);
		c.fillOval (i + 60 - 1, 205, 220, 130);
		c.fillOval (i + 60 - 1, 300, 100, 50);
		c.fillOval (i + 170 - 1, 300, 75, 50);
		c.drawImage (turtleImage, i, 150, null);
		try
		{
		    Thread.sleep (20);
		}
		catch (Exception e)
		{
		}
	    }
	}
	catch (IOException e)
	{
	}
    }


    public void animatedIntroduction ()
    {
	//Creation Story
	nightBackground ();
	c.setColor (Color.WHITE);
	c.setFont (new Font ("Sitka Text", Font.BOLD, 30));
	c.drawString ("The Creation Story", 180, 100); //centered screen title
	turtleLeft ();

	//Creation Story Text
	c.setColor (Color.WHITE);
	c.setFont (new Font ("Sitka Text", Font.PLAIN, 15));
	String[] creationTexts = {
	    "The Indigenous creation story is about a cultural hero: the",
	    "Great Spirit. In the 'Earth Diver myth,' Spirit dives into",
	    "ancient waters to find m ud to shape the Earth. Some versions",
	    "feature the Earth on a Turtle's back, leading to N. America",
	    "being called 'Turtle Island'. Click any key to continue.",
	    };
	int creationChangeY = 436; // Initial Y-coordinate
	for (int j = 0 ; j < creationTexts.length ; j++)
	{
	    String creationLine = creationTexts [j];
	    for (int i = 0 ; i < creationLine.length () ; i++)
	    {
		c.drawString (creationLine.charAt (i) + "", i * 10 + 5, creationChangeY);
		try
		{
		    Thread.sleep (30);
		}
		catch (InterruptedException e)
		{
		}
	    }
	    creationChangeY += 15; // Adjust Y-coordinate for the next line
	}
	c.getChar ();

	//Tricksters
	nightBackground ();
	c.setColor (Color.WHITE);
	c.setFont (new Font ("Sitka Text", Font.BOLD, 30)); //centered screen title
	c.drawString ("Tricksters", 240, 100);
	//Extra Stars
	c.setColor (lightYellow);
	c.fillStar (464, 124, 20, 20);
	c.fillStar (368, 135, 20, 20);
	c.fillStar (550, 78, 20, 20);
	c.fillStar (576, 153, 20, 20);
	c.fillStar (533, 284, 20, 20);
	c.fillStar (398, 213, 20, 20);
	c.fillStar (531, 180, 20, 20);
	c.fillStar (423, 63, 20, 20);
	c.fillStar (423, 295, 20, 20);
	c.fillStar (392, 63, 20, 20);
	c.fillStar (465, 213, 20, 20);
	c.fillStar (567, 295, 20, 20);
	c.fillStar (348, 102, 20, 20);
	c.fillStar (491, 158, 20, 20);
	c.fillStar (412, 249, 20, 20);
	try
	{ // imports image
	    BufferedImage trickster = ImageIO.read (new File ("TricksterTransparentImage.png"));
	    c.drawImage (trickster, tricksterX, 100, null);
	}
	catch (IOException e)
	{
	}

	//Tricksters Text
	c.setColor (Color.WHITE);
	c.setFont (new Font ("Sitka Text", Font.PLAIN, 15));
	String[] tricksterTexts = {
	    "Tricksters are wise yet secretive characters in Indigenous",
	    "culture. They can be any gender, foolish or helpful, hero",
	    "or trouble hum an, spirit, anim al, young or old, half hum an",
	    "and half spirit, etc. Click any key to continue.",
	    };
	int tricksterChangeY = 440; // Initial Y-coordinate
	for (int j = 0 ; j < tricksterTexts.length ; j++)
	{
	    String tricksterLine = tricksterTexts [j];
	    for (int i = 0 ; i < tricksterLine.length () ; i++)
	    {
		c.drawString (tricksterLine.charAt (i) + "", i * 10 + 6, tricksterChangeY);
		try
		{
		    Thread.sleep (30);
		}
		catch (InterruptedException e)
		{
		}
	    }
	    tricksterChangeY += 17; // Adjust Y-coordinate for the next line
	}
	c.getChar ();

	//Transformers
	nightBackground ();
	c.setColor (nightSky);
	c.fillRect (180, 70, 250, 40);
	c.setColor (Color.WHITE);
	c.setFont (new Font ("Sitka Text", Font.BOLD, 30));
	c.drawString ("Transformers", 215, 100);
	//Extra Stars
	c.setColor (lightYellow);
	c.fillStar (464, 124, 20, 20);
	c.fillStar (368, 135, 20, 20);
	c.fillStar (550, 78, 20, 20);
	c.fillStar (576, 153, 20, 20);
	c.fillStar (533, 284, 20, 20);
	c.fillStar (398, 213, 20, 20);
	c.fillStar (531, 180, 20, 20);
	c.fillStar (423, 63, 20, 20);
	c.fillStar (423, 295, 20, 20);
	c.fillStar (392, 63, 20, 20);
	c.fillStar (465, 213, 20, 20);
	c.fillStar (567, 295, 20, 20);
	c.fillStar (348, 102, 20, 20);
	c.fillStar (491, 158, 20, 20);
	c.fillStar (412, 249, 20, 20);
	try
	{ // imports image
	    BufferedImage transformer = ImageIO.read (new File ("CrowImageISP.png"));
	    c.drawImage (transformer, 160, 120, null);
	}
	catch (IOException e)
	{
	}

	//Transformers Text
	c.setColor (Color.WHITE);
	c.setFont (new Font ("Sitka Text", Font.PLAIN, 15));
	String[] transformerTexts = {
	    "According to Indigenous beliefs, Transform ers (shape-shifters)",
	    "are beings that can change shape from their original, hum an, ",
	    "form into an anim al or non-living object. Click any",
	    "key to continue.",
	    };
	int transformerChangeY = 440; // Initial Y-coordinate
	for (int j = 0 ; j < transformerTexts.length ; j++)
	{
	    String transformerLine = transformerTexts [j];
	    for (int i = 0 ; i < transformerLine.length () ; i++)
	    {
		c.drawString (transformerLine.charAt (i) + "", i * 10 + 5, transformerChangeY);
		try
		{
		    Thread.sleep (30);
		}
		catch (InterruptedException e)
		{
		}
	    }
	    transformerChangeY += 17; // Adjust Y-coordinate for the next line
	}
	c.getChar ();

	//Shamans
	nightBackground ();
	c.setColor (nightSky);
	c.fillRect (210, 70, 240, 40);
	c.setColor (Color.WHITE);
	c.setFont (new Font ("Sitka Text", Font.BOLD, 30));
	c.drawString ("Shamans", 250, 100); //centered screen title
	shamanHeal ();
	//Extra Stars
	c.setColor (lightYellow);
	c.fillStar (464, 124, 20, 20);
	c.fillStar (368, 135, 20, 20);
	c.fillStar (550, 78, 20, 20);
	c.fillStar (576, 153, 20, 20);
	c.fillStar (533, 284, 20, 20);
	c.fillStar (398, 213, 20, 20);
	c.fillStar (531, 180, 20, 20);
	c.fillStar (423, 63, 20, 20);
	c.fillStar (423, 295, 20, 20);
	c.fillStar (392, 63, 20, 20);
	c.fillStar (465, 213, 20, 20);
	c.fillStar (567, 295, 20, 20);
	c.fillStar (348, 102, 20, 20);
	c.fillStar (491, 158, 20, 20);
	c.fillStar (412, 249, 20, 20);

	//Shamans Text
	c.setColor (Color.WHITE);
	c.setFont (new Font ("Sitka Text", Font.PLAIN, 15));
	String[] shamansText = {
	    "In Indigenous cultures, sham ans play crucial roles as healers,",
	    "prophets, and guardians. They lead cerem onies, have",
	    "powers for the com m unity's well-being, and",
	    "predict hunts, finding lost things, and addressing illnesses or",
	    "com m unal issues. Click any key to continue."
	    };
	int shamanChangeY = 436; // Initial Y-coordinate
	for (int j = 0 ; j < shamansText.length ; j++)
	{
	    String shamanLine = shamansText [j];
	    for (int i = 0 ; i < shamanLine.length () ; i++)
	    {
		c.drawString (shamanLine.charAt (i) + "", i * 10 + 5, shamanChangeY);
		try
		{
		    Thread.sleep (30);
		}
		catch (InterruptedException e)
		{
		}
	    }
	    shamanChangeY += 15; // Adjust Y-coordinate for the next line
	}
	c.getChar ();


	//Guardian Spirit
	riverBackground ();
	c.setColor (Color.WHITE);
	c.setFont (new Font ("Sitka Text", Font.BOLD, 30));
	c.drawString ("Guardian Spirits and Quests", 110, 100); //centered screen title
	try
	{ // imports image
	    BufferedImage standingMan = ImageIO.read (new File ("StandingManImage.png"));
	    c.drawImage (standingMan, 210, 210, null);

	}

	catch (IOException e)
	{
	}
	guardianLeft();
	//Guardian Spirit Text
	c.setColor (Color.WHITE);
	c.setFont (new Font ("Sitka Text", Font.PLAIN, 15));
	String[] riverTexts = {
	    "During puberty, boys stay in rem ote areas for long periods,",
	    "fasting, praying, and purifying in bodies of water. They seek a",
	    "vision or encounter with a guardian spirit, often anim al or",
	    "m ythical, who would ensure health and success in hunting",
	    "and fishing. Click any key to continue."
	    };
	int riverChangeY = 436; // Initial Y-coordinate
	for (int j = 0 ; j < riverTexts.length ; j++)
	{
	    String riverLine = riverTexts [j];
	    for (int i = 0 ; i < riverLine.length () ; i++)
	    {
		c.drawString (riverLine.charAt (i) + "", i * 10 + 5, riverChangeY);
		try
		{
		    Thread.sleep (30);
		}
		catch (InterruptedException e)
		{
		}
	    }
	    riverChangeY += 15; // Adjust Y-coordinate for the next line
	}
	c.getChar ();
    }


    private void shamanHeal ()
    {
	try
	{ // imports image
	    BufferedImage hurtMan = ImageIO.read (new File ("HurtManImage.png"));
	    c.drawImage (hurtMan, 250, 100, null);
	}
	catch (IOException e)
	{
	}
    }


    private void guardianLeft ()
    {
	try
	{ // imports image
	    BufferedImage fish = ImageIO.read (new File ("NewTransparentFish.png"));
	    for (int i = fishX ; i >= 270 ; i--)
	    {
		c.setColor (brightBlue);
		c.fillOval (i + 9, 365, 70, 45);
		c.drawImage (fish, i, 360, null);
		try
		{
		    Thread.sleep (20);
		}
		catch (Exception e)
		{
		}
	    }
	}
	catch (IOException e)
	{
	}
    }


    public void mazeOfLearning ()
    {
	mazeQuestion = 1;
	mazeScore = 0;
	personX = 55;
	personY = 55;
	mazeBackground ();

	//Draws Checkpoints
	c.setColor (orange);
	c.fillOval (35, 170, 40, 40); //draws first checkpoint
	c.fillOval (210, 420, 40, 40);
	c.fillOval (270, 230, 40, 40);
	c.fillOval (330, 230, 40, 40);
	c.fillOval (450, 370, 40, 40);
	c.fillOval (450, 310, 40, 40);
	c.fillOval (390, 50, 40, 40);
	c.fillOval (510, 120, 40, 40);

	while (mazeQuestion <= 8)
	{
	    if (mazeQuestion == 1)
	    {
		while (personY != 120)
		{
		    //Draws Person
		    characterAnimation ();

		    personY++;
		    try
		    {
			Thread.sleep (10);
		    }
		    catch (InterruptedException e)
		    {
		    }

		}
		mazeQuestion ();
		if (mazeChoice == 2)
		{
		    c.setColor (brightGreen);
		    c.fillOval (35, 170, 40, 40);
		    try
		    {
			Thread.sleep (500);
		    }
		    catch (InterruptedException e)
		    {
		    }
		    mazeScore++;
		}
		else
		{
		    c.setColor (Color.RED);
		    c.fillOval (35, 170, 40, 40);
		    try
		    {
			Thread.sleep (500);
		    }
		    catch (InterruptedException e)
		    {
		    }
		}
		c.setColor (Color.WHITE);
		c.fillOval (35, 170, 40, 40);
		mazeQuestion++;
	    }
	    else if (mazeQuestion == 2)
	    {
		while (personY != 430)
		{
		    //Draws Person
		    characterAnimation ();

		    personY++;
		    try
		    {
			Thread.sleep (10);
		    }
		    catch (InterruptedException e)
		    {
		    }
		}
		while (personX != 110)
		{
		    //Draws Person
		    characterAnimation ();

		    personX++;
		    try
		    {
			Thread.sleep (10);
		    }
		    catch (InterruptedException e)
		    {
		    }
		}
		while (personY != 240)
		{
		    //Draws Person
		    characterAnimation ();

		    personY--;
		    try
		    {
			Thread.sleep (10);
		    }
		    catch (InterruptedException e)
		    {
		    }

		}
		while (personX != 230)
		{
		    //Draws Person
		    characterAnimation ();

		    personX++;
		    try
		    {
			Thread.sleep (10);
		    }
		    catch (InterruptedException e)
		    {
		    }
		}
		while (personY != 380)
		{
		    //Draws Person
		    characterAnimation ();

		    personY++;
		    try
		    {
			Thread.sleep (10);
		    }
		    catch (InterruptedException e)
		    {
		    }
		}
		mazeQuestion ();
		if (mazeChoice == 4)
		{
		    c.setColor (brightGreen);
		    c.fillOval (210, 420, 40, 40);
		    try
		    {
			Thread.sleep (500);
		    }
		    catch (InterruptedException e)
		    {
		    }
		    mazeScore++;
		}
		else
		{
		    c.setColor (Color.RED);
		    c.fillOval (210, 420, 40, 40);
		    try
		    {
			Thread.sleep (500);
		    }
		    catch (InterruptedException e)
		    {
		    }
		}
		c.setColor (Color.WHITE);
		c.fillOval (210, 420, 40, 40);
		mazeQuestion++;

	    }
	    else if (mazeQuestion == 3)
	    {
		while (personY != 430)
		{
		    //Draws Person
		    characterAnimation ();

		    personY++;
		    try
		    {
			Thread.sleep (10);
		    }
		    catch (InterruptedException e)
		    {
		    }
		}
		while (personX != 290)
		{
		    //Draws Person
		    characterAnimation ();

		    personX++;
		    try
		    {
			Thread.sleep (10);
		    }
		    catch (InterruptedException e)
		    {
		    }
		}
		while (personY != 280)
		{
		    //Draws Person
		    characterAnimation ();
		    personY--;
		    try
		    {
			Thread.sleep (10);
		    }
		    catch (InterruptedException e)
		    {
		    }
		}
		mazeQuestion ();
		if (mazeChoice == 1)
		{
		    c.setColor (brightGreen);
		    c.fillOval (270, 230, 40, 40);
		    try
		    {
			Thread.sleep (500);
		    }
		    catch (InterruptedException e)
		    {
		    }
		    mazeScore++;
		}
		else
		{
		    c.setColor (Color.RED);
		    c.fillOval (270, 230, 40, 40);
		    try
		    {
			Thread.sleep (500);
		    }
		    catch (InterruptedException e)
		    {
		    }
		}
		c.setColor (Color.WHITE);
		c.fillOval (270, 230, 40, 40);
		mazeQuestion++;
	    }
	    else if (mazeQuestion == 4)
	    {
		while (personY != 235)
		{
		    //Draws Person
		    characterAnimation ();

		    personY--;
		    try
		    {
			Thread.sleep (10);
		    }
		    catch (InterruptedException e)
		    {
		    }
		}
		while (personX != 305)
		{
		    //Draws Person
		    characterAnimation ();

		    personX++;
		    try
		    {
			Thread.sleep (10);
		    }
		    catch (InterruptedException e)
		    {
		    }
		}
		mazeQuestion ();
		if (mazeChoice == 2)
		{
		    c.setColor (brightGreen);
		    c.fillOval (330, 230, 40, 40);
		    try
		    {
			Thread.sleep (500);
		    }
		    catch (InterruptedException e)
		    {
		    }
		    mazeScore++;
		}
		else
		{
		    c.setColor (Color.RED);
		    c.fillOval (330, 230, 40, 40);
		    try
		    {
			Thread.sleep (500);
		    }
		    catch (InterruptedException e)
		    {
		    }
		}
		c.setColor (Color.WHITE);
		c.fillOval (330, 230, 40, 40);
		mazeQuestion++;

	    }
	    else if (mazeQuestion == 5)
	    {
		while (personX != 350)
		{
		    //Draws Person
		    characterAnimation ();

		    personX++;
		    try
		    {
			Thread.sleep (10);
		    }
		    catch (InterruptedException e)
		    {
		    }
		}
		while (personY != 430)
		{
		    //Draws Person
		    characterAnimation ();

		    personY++;
		    try
		    {
			Thread.sleep (10);
		    }
		    catch (InterruptedException e)
		    {
		    }
		}
		while (personX != 410)
		{
		    //Draws Person
		    characterAnimation ();

		    personX++;
		    try
		    {
			Thread.sleep (10);
		    }
		    catch (InterruptedException e)
		    {
		    }
		}
		while (personY != 380)
		{
		    //Draws Person
		    characterAnimation ();

		    personY--;
		    try
		    {
			Thread.sleep (10);
		    }
		    catch (InterruptedException e)
		    {
		    }
		}
		while (personX != 430)
		{
		    //Draws Person
		    characterAnimation ();

		    personX++;
		    try
		    {
			Thread.sleep (10);
		    }
		    catch (InterruptedException e)
		    {
		    }
		}
		mazeQuestion ();
		if (mazeChoice == 4)
		{
		    c.setColor (brightGreen);
		    c.fillOval (450, 370, 40, 40);
		    try
		    {
			Thread.sleep (500);
		    }
		    catch (InterruptedException e)
		    {
		    }
		    mazeScore++;
		}
		else
		{
		    c.setColor (Color.RED);
		    c.fillOval (450, 370, 40, 40);
		    try
		    {
			Thread.sleep (500);
		    }
		    catch (InterruptedException e)
		    {
		    }
		}
		c.setColor (Color.WHITE);
		c.fillOval (450, 370, 40, 40);
		mazeQuestion++;

	    }
	    else if (mazeQuestion == 6)
	    {
		while (personX != 470)
		{
		    //Draws Person
		    characterAnimation ();

		    personX++;
		    try
		    {
			Thread.sleep (10);
		    }
		    catch (InterruptedException e)
		    {
		    }
		}
		while (personY != 360)
		{
		    //Draws Person
		    characterAnimation ();

		    personY--;
		    try
		    {
			Thread.sleep (10);
		    }
		    catch (InterruptedException e)
		    {
		    }
		}
		mazeQuestion ();
		if (mazeChoice == 4)
		{
		    c.setColor (brightGreen);
		    c.fillOval (450, 310, 40, 40);
		    try
		    {
			Thread.sleep (500);
		    }
		    catch (InterruptedException e)
		    {
		    }
		    mazeScore++;
		}
		else
		{
		    c.setColor (Color.RED);
		    c.fillOval (450, 310, 40, 40);
		    try
		    {
			Thread.sleep (500);
		    }
		    catch (InterruptedException e)
		    {
		    }
		}
		c.setColor (Color.WHITE);
		c.fillOval (450, 310, 41, 41);
		mazeQuestion++;
	    }
	    else if (mazeQuestion == 7)
	    {
		while (personY != 180)
		{
		    //Draws Person
		    characterAnimation ();

		    personY--;
		    try
		    {
			Thread.sleep (10);
		    }
		    catch (InterruptedException e)
		    {
		    }
		}
		while (personX != 410)
		{
		    //Draws Person
		    characterAnimation ();

		    personX--;
		    try
		    {
			Thread.sleep (10);
		    }
		    catch (InterruptedException e)
		    {
		    }
		}
		while (personY != 100)
		{
		    //Draws Person
		    characterAnimation ();

		    personY--;
		    try
		    {
			Thread.sleep (10);
		    }
		    catch (InterruptedException e)
		    {
		    }
		}
		mazeQuestion ();
		if (mazeChoice == 1)
		{
		    c.setColor (brightGreen);
		    c.fillOval (390, 50, 40, 40);
		    try
		    {
			Thread.sleep (500);
		    }
		    catch (InterruptedException e)
		    {
		    }
		    mazeScore++;
		}
		else
		{
		    c.setColor (Color.RED);
		    c.fillOval (390, 50, 40, 40);
		    try
		    {
			Thread.sleep (500);
		    }
		    catch (InterruptedException e)
		    {
		    }
		}
		c.setColor (Color.WHITE);
		c.fillOval (390, 50, 41, 41);
		mazeQuestion++;
	    }
	    else if (mazeQuestion == 8)
	    {
		while (personY != 40)
		{
		    //Draws Person
		    characterAnimation ();

		    personY--;
		    try
		    {
			Thread.sleep (10);
		    }
		    catch (InterruptedException e)
		    {
		    }
		}
		while (personX != 470)
		{
		    //Draws Person
		    characterAnimation ();

		    personX++;
		    try
		    {
			Thread.sleep (10);
		    }
		    catch (InterruptedException e)
		    {
		    }
		}
		while (personY != 120)
		{
		    //Draws Person
		    characterAnimation ();

		    personY++;
		    try
		    {
			Thread.sleep (10);
		    }
		    catch (InterruptedException e)
		    {
		    }
		}
		while (personX != 495)
		{
		    //Draws Person
		    characterAnimation ();

		    personX++;
		    try
		    {
			Thread.sleep (10);
		    }
		    catch (InterruptedException e)
		    {
		    }
		}
		mazeQuestion ();
		if (mazeChoice == 3)
		{
		    c.setColor (brightGreen);
		    c.fillOval (510, 120, 40, 40);
		    try
		    {
			Thread.sleep (500);
		    }
		    catch (InterruptedException e)
		    {
		    }
		    mazeScore++;
		}
		else
		{
		    c.setColor (Color.RED);
		    c.fillOval (510, 120, 40, 40);
		    try
		    {
			Thread.sleep (500);
		    }
		    catch (InterruptedException e)
		    {
		    }
		}
		c.setColor (Color.WHITE);
		c.fillOval (510, 120, 41, 41);
		while (personX != 530)
		{
		    //Draws Person
		    characterAnimation ();

		    personX++;
		    try
		    {
			Thread.sleep (10);
		    }
		    catch (InterruptedException e)
		    {
		    }
		}
		while (personY != 260)
		{
		    //Draws Person
		    characterAnimation ();
		    personY++;
		    try
		    {
			Thread.sleep (10);
		    }
		    catch (InterruptedException e)
		    {
		    }
		}
		while (personX != 590)
		{
		    //Draws Person
		    characterAnimation ();
		    personX++;
		    try
		    {
			Thread.sleep (10);
		    }
		    catch (InterruptedException e)
		    {
		    }
		}
		while (personY != 180)
		{
		    //Draws Person
		    characterAnimation ();
		    personY--;
		    try
		    {
			Thread.sleep (10);
		    }
		    catch (InterruptedException e)
		    {
		    }
		}
		while (personX != 660)
		{
		    //Draws Person
		    characterAnimation ();
		    personX++;
		    try
		    {
			Thread.sleep (10);
		    }
		    catch (InterruptedException e)
		    {
		    }
		}

		break;
	    }
	}


	if (mazeQuestion == 8 && personX >= 650)
	{
	    c.setColor (brightBlue);
	    c.fillRect (88, 40, 284, 112);
	    c.setColor (Color.WHITE);
	    c.drawString ("You scored " + mazeScore + "/8.", 90, 75);
	    c.drawString ("Click any key to continue.", 90, 90);
	    c.getChar ();
	}
    }


    private void characterAnimation ()
    {
	c.setColor (Color.WHITE);
	c.fillOval (personX - 17, personY - 10, 30, 30); //draws stick-man head
	c.fillRect (personX - 1, personY + 12, 3, 14); //draws stick-man body
	c.fillRect (personX - 12, personY + 17, 24, 7); //draws stick-man arms
	c.fillRect (personX - 12, personY + 23, 24, 14);
	c.setColor (Color.BLACK);
	c.fillOval (personX - 10, personY - 7, 20, 20); //draws stick-man head
	c.drawLine (personX, personY + 15, personX, personY + 25); //draws stick-man body
	c.drawLine (personX - 10, personY + 20, personX + 10, personY + 20); //draws stick-man arms
	c.drawLine (personX, personY + 25, personX - 10, personY + 35); //draws stick-man left leg
	c.drawLine (personX, personY + 25, personX + 10, personY + 35); //draws stick-man right leg
    }


    private void mazeQuestion ()
    {
	String[] [] questionText = {
		{"What does the Great Spirit retrieve in", "the ancient waters?", "1. sand", "2. mud", "3. rocks", "4. plants"},  // question 1: mud
		{"On which animal's back was the Earth", "said to grow on?", "1. elephant", "2. moose", "3. dog", "4. turtle"},  // question 2: turtle
		{"Which characteristic would never be", "used to describe a trickster?", "1. invisible", "2. secretive", "3. foolish", "4. young"},  // question 3: invisible
		{"What is a transformer's original form?", "1. animal", "2. human", "3. spirit", "4. non-living object"},  // question 4: human
		{"Which of the following can a Shaman", "not do?", "1. predict hunts", "2. address illnesses", "3. find lost things", "4. build homes"},  // question 5: build homes
		{"Why do boys stay in remote areas for", "long periods of time?", "1. to hunt", "2. to find a guardian spirit", "3. to explore", "4. to search for unoccupied land"},  // question 6: to search unoccupied land
		{"Which of the following do boys not do", "during their stays in remote areas?", "1. farm", "2. fast", "3. self-purify", "4. pray"},  // question 7: farm
		{"Which of the following can a Guardian", "Spirit not promise?", "1. success in hunting", "2. success in fishing", "3. fertility", "4. health"}  // question 8: fertility
	    };
	c.setColor (nightSky);
	c.fillRect (78, 30, 304, 132);
	c.setColor (brightBlue);
	c.fillRect (88, 40, 284, 112);
	c.setColor (Color.WHITE);
	c.setFont (new Font ("Sitka Text", Font.PLAIN, 15));

	// Display question based on mazeQuestion
	for (int i = 0 ; i < questionText [mazeQuestion - 1].length ; i++)
	{
	    c.drawString (questionText [mazeQuestion - 1] [i] + "", 90, 55 + i * 15);
	}


	c.setColor (Color.BLACK);
	c.drawString ("Enter the int for the correct answer: ", 90, 15);
	c.setColor (Color.WHITE);

	while (true)
	{
	    try
	    {
		c.setCursor (1, 45);
		c.fillRect (350, 0, 200, 20);
		c.setCursor (1, 45);
		mazeChoice = Integer.parseInt (c.readLine ()); // read user input
		if (mazeChoice < 1 || mazeChoice > 4)
		{
		    throw new ArithmeticException ();
		}
	    }
	    catch (ArithmeticException e)
	    {
		new Message ("You have not entered a menu option. Please enter an int from 1-4.");
		continue;
	    }
	    catch (NumberFormatException e)
	    {
		new Message ("You have not entered an int. Please enter an int from 1-4.");
		continue;
	    }
	    break;
	}
    }



    public void gameOfTesting ()
    {
	Game g = new Game (c);
	g.startGame ();

	String fileName = "HighScores.txt";
	BufferedReader input;

	try
	{
	    input = new BufferedReader (new FileReader (fileName));
	    for (int i = 0 ; i < 10 ; i++)
	    {
		names [i] = input.readLine ();
		scores [i] = Integer.parseInt (input.readLine ());
	    }
	    input.close ();
	}
	catch (IOException e)
	{
	    // Handle IOException
	}

	for (int i = 0 ; i < 10 ; i++)
	{
	    if (g.gameLevel > scores [i])
	    {
		// Shift scores and names down to make room for the new score
		for (int j = 8 ; j > i ; j--)
		{
		    scores [j] = scores [j + 1];
		    names [j] = names [j + 1];
		}
		// Insert the new score and name
		scores [i] = g.gameLevel;
		names [i] = name;
		break; // Exit the loop once the new score is inserted
	    }
	}

	// Save the updated high scores back to the file (assuming you want to save them)
	try
	{
	    PrintWriter output = new PrintWriter (new FileWriter ("HighScores.txt"));
	    for (int i = 0 ; i < 10 ; i++)
	    {
		output.println (names [i]);
		output.println (scores [i]);
	    }
	    output.close ();
	}
	catch (IOException e)
	{
	    // Handle IOException
	}
    }


    public void instructions ()
    {
	title ();
	c.print ("", 40 - "Instructions".length () / 2);
	c.println ("Instructions\n");

	//Prints Paragraph 1
	c.println ("Hello " + name + "! Welcome to the Indigenous Culture Journey Program! Designed for users");
	c.println ("aged 10-13, this program educates you on Indigenous culture, beliefs, and");
	c.println ("traditions in Canada. Explore The Creation Story, Tricksters, Transformers,");
	c.println ("Shamans, and Guardian Spirits.");

	//Prints Paragraph 2
	c.println ("\nAfter a brief splash screen, you'll encounter three main sections:");

	c.println (" 1. Animated Instruction: Learn about the five topics mentioned above.");
	c.println (" 2. Maze of Learning: Answer questions about the information learned.");
	c.println (" 3. Game of Testing: Navigate platforms and deciding which phrase is true.");
	//Prints Paragraph 3
	c.println ("\nTo Navigate through the main menu: Press (1) in the main menu for the Animated");
	c.println ("Introductions,(2) for Maze of Learning,(3) for Game of Testing, (4) to return to");
	c.println ("Instructions,(5) to view High Scores,(6) to exit the program.");
	c.println ("\nIf you do not plan on exiting the program, we strongly suggest that you select");
	c.println ("(1) to understand the material before continuing to the maze or game.\n");
	pauseProgram ();
    }


    private void pauseProgram ()
    {
	c.println ("Press any key to continue:");
	c.getChar ();
    }


    public void getHighScores ()
    {
	title ();
	String fileName = "HighScores.txt";
	BufferedReader input;

	try
	{
	    input = new BufferedReader (new FileReader (fileName));
	    for (int i = 0 ; i < 10 ; i++)
	    {
		names [i] = input.readLine ();
		scores [i] = Integer.parseInt (input.readLine ());
	    }
	    input.close ();
	}
	catch (IOException e)
	{
	    // Handle IOException
	}

	c.println ("Current High Scores:");
	for (int i = 0 ; i < 10 ; i++)
	{
	    c.println ("  " + (i + 1) + ". " + names [i] + " - " + scores [i]);
	}
	c.println ("Press any key to continue:");
	c.getChar ();

    }


    public void goodBye ()
    {
	title ();
	c.println ("Thank you for using this program! Made by Jonathan Ye and Raquel Canto.");
	flowers ();
    }


    private void flowers ()
    {
	try
	{ // imports image
	    BufferedImage flowers = ImageIO.read (new File ("Flowers.png"));
	    c.drawImage (flowers, 270, 155, null);
	}
	catch (IOException e)
	{
	}
    }


    private void title ()
    {
	c.clear ();
	c.print ("\n", 40 - "Indigenous Culture Journey".length () / 2);
	c.println ("Indigenous Culture Journey\n");
    }


    private void classBackground ()
    {
	c.setColor (darkBrown); //sets colour to dark brown
	c.fillRect (0, 470, 640, 30);
	c.setColor (peach); //sets colour to peach
	c.fillRect (0, 0, 640, 470); //draws peach background
	c.setColor (oakBrown); //sets colour to oak brown
	c.fillRect (50, 100, 350, 300); //draws chalkboard's wooden back
	c.setColor (brightGreen); //sets colour to bright green
	c.fillRect (60, 110, 330, 260); //draws chalk board
	c.setColor (lightGrey); //sets colour to light grey
	c.fillRect (60, 370, 330, 30); //draws bottom metal part of chalk board
	c.setColor (Color.WHITE); //sets colour to white
	c.fillRect (110, 380, 50, 10); //draws left piece of chalk
	c.fillRect (290, 380, 50, 10); //draws right piece of chalk

	c.setFont (new Font ("Sitka Text", Font.ITALIC, 15));
	c.drawString ("2024-01-08 -  Ms. Canto's Class", 65, 130);
	c.drawString ("TODAY'S ASSIGNMENT", 65, 170);
	c.drawString ("- Research Indigenous Culture", 70, 190);
	c.drawString ("- Creation Story", 90, 210);
	c.drawString ("- Tricksters and Transformers", 90, 230);
	c.drawString ("- Shamans", 90, 250);
	c.drawString ("- Guardian Spirits Quests", 90, 270);
	c.drawString ("- Complete Maze of Learning Assignment", 70, 290);
	c.drawString ("- Get as many points from the Game of", 70, 310);
	c.drawString ("  Testing as possible", 70, 330);
    }


    private void nightBackground ()
    {
	c.setColor (nightSky); //sets colour to night blue
	c.fillRect (0, 0, 640, 500); //draws night blue background
	c.setColor (darkGreen); //sets colour to dark green
	c.fillRect (0, 350, 640, 75); //draws grass
	c.setColor (dullGreen); //sets colour to dull green
	c.fillRect (0, 425, 640, 75); //draws text box

	//Draws Stars
	c.setColor (lightYellow); //sets colour yo light yellow
	c.fillStar (79, 313, 20, 20);
	c.fillStar (568, 27, 20, 20);
	c.fillStar (76, 270, 20, 20);
	c.fillStar (605, 99, 20, 20);
	c.fillStar (528, 114, 20, 20);
	c.fillStar (22, 94, 20, 20);
	c.fillStar (55, 212, 20, 20);
	c.fillStar (546, 13, 20, 20);
	c.fillStar (584, 16, 20, 20);
	c.fillStar (71, 162, 20, 20);
	c.fillStar (50, 59, 20, 20);
	c.fillStar (157, 114, 20, 20);
	c.fillStar (5, 151, 20, 20);
	c.fillStar (52, 263, 20, 20);
	c.fillStar (34, 207, 20, 20);
	c.fillStar (119, 192, 20, 20);
	c.fillStar (120, 220, 20, 20);
	c.fillStar (471, 50, 20, 20);
	c.fillStar (411, 16, 20, 20);
	c.fillStar (96, 14, 20, 20);
	c.fillStar (157, 51, 20, 20);
	c.fillStar (203, 136, 20, 20);
	c.fillStar (588, 45, 20, 20);
	c.fillStar (281, 130, 20, 20);
	c.fillStar (537, 86, 20, 20);
	c.fillStar (182, 153, 20, 20);
	c.fillStar (228, 144, 20, 20);
	c.fillStar (128, 54, 20, 20);
	c.fillStar (19, 318, 20, 20);
	c.fillStar (387, 49, 20, 20);
    }


    private void riverBackground ()
    {
	for (int i = 0 ; i <= 350 ; i++)
	{
	    c.setColor (new Color (i / 2 + 75, 184, 242)); //changes the colour of the background to create a gradient
	    c.drawLine (0, i, 640, i); //draws gradient background line by line
	}


	c.setColor (lightYellow); //sets colour to light yellow
	c.fillArc (250, 250, 240, 240, 0, 180); //draws sun
	c.setColor (darkGreen); //sets colour to dark green
	c.fillRect (0, 350, 640, 75); //draws grass
	c.setColor (dullGreen); //sets colour to dull green
	c.fillRect (0, 425, 640, 75); //draws text box

	//Rocks
	c.setColor (mediumGrey); //sets colour to medium grey
	c.fillOval (25, 225, 150, 150); //draws first rock
	c.setColor (lightGrey); //sets colour to light grey
	c.fillOval (-25, 250, 150, 150); //draws second rock
	c.setColor (darkGrey); //sets colour to dark grey
	c.fillOval (100, 275, 125, 125); //draws third rock
	c.setColor (mediumGrey); //sets colour to medium grey
	c.fillOval (70, 310, 100, 100); //draws fourth rock

	//Water
	c.setColor (brightBlue); //sets colour to bright blue
	c.fillRect (280, 365, 360, 45); //draws water
	c.fillArc (260, 365, 45, 45, 90, 180); //draws end of water

	//Tree
	c.setColor (darkBrown); //sets colour to dark brown
	int treeX1[] = {520, 580, 550}; //sets x-coordinates for tree bark
	int treeY1[] = {350, 350, 200}; //sets y-coordinates for tree bark
	c.fillPolygon (treeX1, treeY1, 3); //draws tree bark
	int treeX2[] = {540, 540, 510, 520, 500}; //sets x-coordinates for left twig
	int treeY2[] = {275, 250, 225, 190, 225}; //sets y-coordinates for left twig
	c.fillPolygon (treeX2, treeY2, 5); //draws left twig
	int treeX3[] = {550, 550, 580, 570, 590, 615}; //sets x-coordinates for top right twig
	int treeY3[] = {270, 240, 205, 180, 200, 180}; //sets y-coordinates for top right wtig
	c.fillPolygon (treeX3, treeY3, 6); //draws top right twig
	int treeX4[] = {550, 550, 590, 580, 600}; //sets x-coordinates for bottom left twig
	int treeY4[] = {340, 300, 270, 240, 270}; //sets y-coordinates for bottom left twig
	c.fillPolygon (treeX4, treeY4, 5); //draws bottom right twig
    }


    private void mazeBackground ()
    {
	c.setColor (Color.WHITE); //sets colour to white
	c.fillRect (0, 0, 640, 500); //draws white background
	//Draws Maze Borders
	c.setColor (Color.BLACK);
	c.fillRect (20, 20, 600, 10); //draws top border
	c.fillRect (20, 30, 10, 10); //draws the top part of the left border
	c.fillRect (20, 100, 10, 380); //draws the bottom part of the left border
	c.fillRect (20, 470, 600, 10); //draws bottom border
	c.fillRect (610, 20, 10, 140); //draws the top part of the right border
	c.fillRect (610, 220, 10, 260); //draws the bottom part of the right border
	//Draws Maze Box
	c.fillRect (78, 30, 244, 132); //draws black box where the answer correction message will appear
	//Draws Walls Inside Maze
	c.fillRect (78, 218, 4, 194); //draws vertical wall right of first checkpoint
	c.fillRect (78, 218, 184, 4); //draws horizontal wall directly under box
	c.fillRect (198, 158, 4, 62); //draws vertical wall under box
	c.fillRect (138, 278, 4, 192); //draws vertical wall under box
	c.fillRect (138, 278, 64, 4); //draws horiztonal wall under box
	c.fillRect (198, 278, 4, 138); //draws vertical wall under box
	c.fillRect (258, 218, 4, 198); //draws vertical wall under box
	c.fillRect (318, 160, 4, 62); //draws vertical wall under box
	c.fillRect (318, 288, 4, 182); //draws vertical wall under box
	c.fillRect (378, 78, 4, 334); //draws vertical wall to the right of the box
	c.fillRect (318, 158, 64, 4); //draws horizontal wall to the right of the box
	c.fillRect (438, 428, 4, 42); //draws vertical wall
	c.fillRect (378, 358, 64, 4); //draws horizontal wall
	c.fillRect (498, 358, 4, 114); //draws vertical wall
	c.fillRect (558, 298, 4, 124); //draws vertical wall
	c.fillRect (498, 298, 114, 4); //draws horizontal wall
	c.fillRect (498, 158, 4, 144); //draws vertical wall
	c.fillRect (438, 158, 64, 4); //draws horizontal wall
	c.fillRect (438, 78, 4, 84); //draws vertical wall
	c.fillRect (498, 28, 4, 74); //draws vertical wall
	c.fillRect (558, 88, 4, 134); //draws vertical wall
	c.fillRect (558, 156, 54, 4); //draws horizontal wall
	c.fillRect (378, 218, 64, 4); //draws horizontal wall
	c.fillRect (438, 218, 4, 64); //draws vertical wall

    }


    private void gameBackground ()
    {
	c.setColor (lightBlue); //sets colour to light blue
	c.fillRect (0, 0, 640, 500); //draws light blue background
	for (int i = 0 ; i <= 75 ; i++)
	{
	    c.setColor (new Color (255, 2 * i, 0));
	    c.drawLine (0, 425 + i, 640, 425 + i);
	}


	int bubbleX[] = {015, 368, 434, 469, 65, 411, 215, 96, 308, 551, 533, 343, 569, 49, 129, 252, 491, 286, 183, 599}; //stores x values for bubbles
	int bubbleY[] = {451, 453, 462, 438, 475, 469, 469, 451, 464, 457, 465, 479, 440, 436, 469, 452, 467, 430, 451, 461}; //stores y values for bubbles

	for (int i = 0 ; i < bubbleX.length ; i++) //for loop drawing bubbles in lava
	{
	    c.setColor (orange); //sets colour to red
	    c.fillOval (bubbleX [i], bubbleY [i], 20, 20); //draws red bubble
	    c.setColor (yellow); //sets colour to yellow
	    c.fillOval (bubbleX [i] + 3, bubbleY [i] + 3, 14, 14); //draws yellow bubble
	}
    }


    public static void main (String[] args)
    {
	IndigenousCultureJourney icj = new IndigenousCultureJourney ();
	icj.splashScreen ();
	icj.askData ();
	while (icj.menuChoice != 6)
	{
	    icj.mainMenu ();
	    if (icj.menuChoice == 1)
	    {
		icj.animatedIntroduction ();
	    }
	    else if (icj.menuChoice == 2)
	    {
		icj.mazeOfLearning ();
	    }
	    else if (icj.menuChoice == 3)
	    {
		icj.gameOfTesting ();
	    }
	    else if (icj.menuChoice == 4)
	    {
		icj.instructions ();
	    }
	    else if (icj.menuChoice == 5)
	    {
		icj.getHighScores ();
	    }
	}
	icj.goodBye ();
    }
}









