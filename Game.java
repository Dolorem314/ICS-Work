import hsa.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.*;

class Game
{
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



    String[] questions = {
	"1. What did the Great Spirit do to shape the Earth?",
	"2. How was the Earth formed in the Indigenous story?",
	"3. Why is North America sometimes called 'Turtle Island'?",
	"4. What can tricksters be in Indigenous stories?",
	"5. What ability do transformers have in Indigenous tales?",
	"6. What is role that Shamans play in Indigenous cultures?",
	"7. What do Shamans do in their communities?",
	"8. During puberty, what do some Indigenous boys?",
	"9. What are guardian spirits often in Indigenous stories?",
	"10. How do boys purify themselves during their quest?",
	"11. What is the main goal of boys during their quest?",
	"12. What is a benefit of guardian spirits?",
	"13. What do Shamans do during religious ceremonies?",
	"14. What special powers do Shamans have in Indigenous cultures?",
	"15. Why is the Earth Diver myth significant in creation stories?",
	"16. How are transformers different from tricksters?",
	"17. What is a common characteristic of Tricksters?",
	"18. How do guardian spirits help someone's well-being?",
	"19. What do Shamans do to address community problems in?",
	"20. What makes Shamans different in Indigenous communities?",
	"21. Why is the Earth being on a Turtle's back significant?",
	"22. What's the main purpose of fasting and praying during puberty?",
	"23. How do Indigenous communities refer to North America in stories?",
	"24. What's a characteristic of guardian spirits?",
	"25. What do Shamans predict in Indigenous communities?"
	};

    String[] [] answers = {
	    {"a. Planted seeds",
	    "b. Created mountains",
	    "c. Dived into waters to get mud",
	    "d. Sculpted human beings"},  //1
	    {"a. By fire",
	    "b. With sunlight",
	    "c. Using mud from waters",
	    "d. Through magic"},  //2
	    {"a. Turtles are sacred",
	    "b. The continent looks like a turtle",
	    "c. Earth was formed on a turtle's back",
	    "d. Turtles bring good luck"},  //3
	    {"a. Always helpful",
	    "b. Strictly human",
	    "c. Anything",
	    "d. Only troublemakers"},  //4
	    {"a. Immortality",
	    "b. Invisibility",
	    "c. Shape-shifting abilities",
	    "d. Superhuman strength"},  //5
	    {"a. Warriors",
	    "b. Merchants",
	    "c. Healers",
	    "d. Political leaders"},  //6
	    {"a. Train warriors",
	    "b. Predict hunt outcomes",
	    "c. Fight monsters",
	    "d. Manage farms"},  //7
	    {"a. Exercise a lot",
	    "b. Go to school",
	    "c. Stay isolated fasting & praying",
	    "d. Attend parties"},  //8
	    {"a. Human-like",
	    "b. Silent and mysterious",
	    "c. Animals or mythical figures",
	    "d. Urban beings"},  //9
	    {"a. Avoid water",
	    "b. Use fire",
	    "c. Wash themselves in streams",
	    "d. Stay indoors"},  //10
	    {"a. Become rich",
	    "b. Seek revenge",
	    "c. Encounter a guardian spirit",
	    "d. Master art skills"},  //11
	    {"a. Cooking skills",
	    "b. Success in hunting",
	    "c. Physical strength",
	    "d. Farming mastery"},  //12
	    {"a. Lead debates",
	    "b. Entertain people",
	    "c. Officiate and guide the ceremony",
	    "d. Negotiate trades"},  //13
	    {"a. Super strength",
	    "b. Healing powers",
	    "c. Telepathy with animals",
	    "d. Invisibility"},  //14
	    {"a. Shows struggles between good/evil",
	    "b. Shows life and death cycles",
	    "c. Explains how Earth formed",
	    "d. Shows the importance of farming"},  //15
	    {"a. Always wise",
	    "b. Can change into animals or objects",
	    "c. Strictly villains",
	    "d. Immortal"},  //16
	    {"a. Always wise",
	    "b. Strict rule-followers",
	    "c. Anything",
	    "d. Exclusively male"},  //17
	    {"a. Grant wealth",
	    "b. Provide protection and guidance",
	    "c. Enhance physical beauty",
	    "d. Control natural elements"},  //18
	    {"a. Engage in debates",
	    "b. Perform healing ceremonies",
	    "c. Lead military campaigns",
	    "d. Organize festivals"},  //19
	    {"a. Wealth",
	    "b. They are prophets",
	    "c. Farming skills",
	    "d. Physical strength"},  //20
	    {"a. Turtles are creators",
	    "b. Represents land and water balance",
	    "c. Symbolizes Earth resting on a Turtle",
	    "d. Turtles are wise beings"},  //21
	    {"a. Show bravery",
	    "b. Seek a guardian spirit",
	    "c. Improve appearance",
	    "d. Prepare for leadership"},  //22
	    {"a. Eagle's Nest",
	    "b. Bear Haven",
	    "c. Turtle Island",
	    "d. Serpent's Back"},  //23
	    {"a. Often human-like",
	    "b. Evil intentions",
	    "c. Often animals/mythological figures",
	    "d. Control the weather"},  //24
	    {"a. Weather patterns",
	    "b. Agricultural yields",
	    "c. Hunt outcomes",
	    "d. Success in military campaigns"}  //25
	};

    int[] multipleChoices = {1, 3, 3, 3, 3, 3, 3, 2, 3, 3, 3, 3, 3, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 3};
    int gameLevel = 0;
    int currentAnswer = multipleChoices [gameLevel % 25];
    int nextAnswer = multipleChoices [(gameLevel + 1) % 25];

    Console c;
    int[] xy = {120, 50};

    public Game (Console a)
    {
	c = a;
    }


    public void startGame ()
    {
	gameLevel = 0;
	int currentAnswer = multipleChoices [gameLevel % 25];
	int nextAnswer = multipleChoices [(gameLevel + 1) % 25];
	Color[] blockColours = {
	    Color.WHITE, Color.DARK_GRAY, Color.BLACK,
	    lightYellow, peach, lightPink, pinkPeach, magenta,
	    dullGreen, mediumGrey, darkGreen, brightGreen, lime,
	    lightGrey, darkBrown, brightBlue, nightSky, darkRed,
	    orange, yellow
	    };
	boolean winlose = false;
	background ();
	char[] key = {' ', '0'};
	CheckKey thread = new CheckKey (c, key);
	thread.start ();
	YChangeThread thread1 = new YChangeThread (c, key, xy);
	thread1.start ();
	LeftCheck thread2 = new LeftCheck (c, xy, key);
	thread2.start ();
	RightCheck thread3 = new RightCheck (c, xy, key);
	thread3.start ();
	int slowdown = 0;
	drawGameQuestion ();
	try
	{
	    BufferedImage characterImage = ImageIO.read (new File ("gameCharacter.png"));

	    while (true)
	    {
		//Draws object
		c.drawImage (characterImage, xy [0] - 20, 450 - xy [1] - 63, null);

		try

		{
		    Thread.sleep (20);
		}
		catch (Exception e)
		{
		}
		c.setColor (lightBlue);
		c.fillRect (xy [0] - 40, 450 - xy [1] - 63, 79, 73);
		blocks ();


		if (!(xy [1] <= 0) && !(xy [1] >= 155 && xy [1] <= 160 && thread1.vel < 0 && checkBlock (true)))
		{
		    thread1.vel -= 0.1;
		    xy [1] += (int) thread1.vel / 2;
		}
		else
		{
		    if (xy [1] <= 0 && checkBlock ())
		    {
			xy [1] = 10;
		    }
		    else if (xy [1] <= 0)
		    {
			break;
		    }
		    else
		    {
			c.drawImage (characterImage, xy [0] - 20, 450 - xy [1] - 63, null);
			blocks ();
			try

			{
			    Thread.sleep (1000);
			}
			catch (Exception e)
			{
			}
			c.setColor (lightBlue);
			c.fillRect (xy [0] - 40, 450 - xy [1] - 63, 79, 73);
			xy [1] = 10;
			gameLevel++;

			currentAnswer = multipleChoices [gameLevel % 25];
			nextAnswer = multipleChoices [(gameLevel + 1) % 25];
			drawGameQuestion ();
			blocks ();
		    }
		    thread1.vel = 1;

		    c.setColor (lightBlue);
		    c.fillRect (xy [0] - 40, 450 - xy [1] - 63, 79, 73);
		    blocks ();

		    while (thread1.vel < 10 && checkBlock ())
		    {
			c.drawImage (characterImage, xy [0] - 20, 450 - xy [1] - 63, null);
			try

			{
			    Thread.sleep (100);
			}
			catch (Exception e)
			{
			}
			c.setColor (lightBlue);
			c.fillRect (xy [0] - 40, 450 - xy [1] - 63, 79, 73);
			blocks ();

		    }
		}
	    }

	}
	catch (IOException e)
	{
	}

	//GAME OVER!

	c.clear ();
	c.setColor (Color.BLACK);

	c.setFont (new Font ("Sitka Text", 1, 60));
	c.drawString ("GAME OVER", 140, 130);
	c.setFont (new Font ("Sitka Text", 0, 40));
	c.drawString ("Your score is: ", 195, 180);
	c.drawString ("" + gameLevel, 305, 230);
	int x = 50;
	int y = 250;
	int length = 30;
	int width = 30;

	// Skull outline
	c.drawRect (x, y, 5 * length, 7 * width);

	// Eyes
	c.fillRect (x + length, y + 2 * width, length, width);
	c.fillRect (x + 3 * length, y + 2 * width, length, width);

	// Nose
	c.fillRect (x + 2 * length, y + 3 * width, length, width);

	// Mouth
	c.fillRect (x + length, y + 5 * width, 3 * length, width);

	x = 450;
	y = 250;
	length = 30;
	width = 30;

	// Skull outline
	c.drawRect (x, y, 5 * length, 7 * width);

	// Eyes
	c.fillRect (x + length, y + 2 * width, length, width);
	c.fillRect (x + 3 * length, y + 2 * width, length, width);

	// Nose
	c.fillRect (x + 2 * length, y + 3 * width, length, width);

	// Mouth
	c.fillRect (x + length, y + 5 * width, 3 * length, width);

	x = 215;
	y = 320;
	length = 20;
	width = 20;

	// Skull outline
	c.drawRect (x, y, 5 * length, 7 * width);

	// Eyes
	c.fillRect (x + length, y + 2 * width, length, width);
	c.fillRect (x + 3 * length, y + 2 * width, length, width);

	// Nose
	c.fillRect (x + 2 * length, y + 3 * width, length, width);

	// Mouth
	c.fillRect (x + length, y + 5 * width, 3 * length, width);

	x = 335;
	y = 320;
	length = 20;
	width = 20;

	// Skull outline
	c.drawRect (x, y, 5 * length, 7 * width);

	// Eyes
	c.fillRect (x + length, y + 2 * width, length, width);
	c.fillRect (x + 3 * length, y + 2 * width, length, width);

	// Nose
	c.fillRect (x + 2 * length, y + 3 * width, length, width);

	// Mouth
	c.fillRect (x + length, y + 5 * width, 3 * length, width);

	thread.stop ();
	thread1.stop ();
	thread2.stop ();
	thread3.stop ();
	
	c.setFont (new Font ("Sitka Text", 0, 17));
	c.drawString ("Press any key to continue", 225, 280);
	c.getChar ();
	return;

    }


    private boolean checkBlock ()
    {


	switch (currentAnswer)
	{

	    case 1:
		return (xy [0] > 66 && xy [0] < 146);
	    case 2:
		return (xy [0] > 212 && xy [0] < 292);
	    case 3:
		return ((xy [0] > 212 + 146 && xy [0] < 292 + 146));
	    case 4:
		return (xy [0] > 212 + 146 + 146 && xy [0] < 292 + 146 + 146);
	}
	return false;
    }


    private boolean checkBlock (boolean next)
    {

	switch (nextAnswer)
	{
	    case 1:
		return (xy [0] > 66 && xy [0] < 146);
	    case 2:
		return (xy [0] > 212 && xy [0] < 292);
	    case 3:
		return ((xy [0] > 212 + 146 && xy [0] < 292 + 146));
	    case 4:
		return (xy [0] > 212 + 146 + 146 && xy [0] < 292 + 146 + 146);
	}
	return false;
    }


    private void drawGameQuestion ()
    {
	c.setColour (oakBrown);
	c.fillRect (100, 50, 450, 100);
	c.setColour (Color.WHITE);
	c.setFont (new Font ("Sitka Text", Font.BOLD, 12));
	c.drawString (questions [gameLevel % 25], 110, 70);
	c.setFont (new Font ("Sitka Text", Font.BOLD, 11));

	c.drawString (answers [gameLevel % 25] [0], 110, 110);
	c.drawString (answers [gameLevel % 25] [1], 350, 110);
	c.drawString (answers [gameLevel % 25] [2], 110, 130);
	c.drawString (answers [gameLevel % 25] [3], 350, 130);

    }


    private void background ()
    {
	c.setColor (lightBlue);
	c.fillRect (0, 0, 650, 470);
	blocks ();
	c.setColor (oakBrown);
	c.fillRect (100, 50, 450, 100);
	c.setColor (darkBrown);

	c.drawLine (0, 0, 100, 50);
	c.drawLine (640, 0, 550, 50);

    }


    private void blocks ()
    {
	Color[] blockColours = {
	    Color.WHITE, Color.DARK_GRAY, Color.BLACK,
	    lightYellow, peach, lightPink, pinkPeach, magenta,
	    dullGreen, mediumGrey, darkGreen, brightGreen, lime,
	    lightGrey, darkBrown, brightBlue, nightSky, darkRed,
	    orange, yellow
	    };
	c.setColor (Color.RED);
	c.fillRect (0, 470, 650, 50);
	c.setColor (blockColours [gameLevel % 5]);
	c.fillRect (66, 450, 80, 20);
	c.fillRect (212, 450, 80, 20);
	c.fillRect (358, 450, 80, 20);
	c.fillRect (504, 450, 80, 20);
	c.setColor (blockColours [(gameLevel + 1) % 5]);

	c.fillRect (66, 300, 80, 20);
	c.fillRect (212, 300, 80, 20);
	c.fillRect (358, 300, 80, 20);
	c.fillRect (504, 300, 80, 20);
    }
}


class CheckKey extends Thread
{

    Console a;
    char[] key;
    public CheckKey (Console c, char[] tempkey)
    {
	a = c;

	key = tempkey;
    }


    public void run ()
    {
	while (true)
	{
	    key [0] = a.getChar ();
	    key [1] = '1';
	}
    }
}

class YChangeThread extends Thread
{

    Console a;
    char[] key;
    double vel = 0;
    int[] xy;

    public YChangeThread (Console c, char[] tempkey, int[] xyval)
    {
	a = c;
	xy = xyval;
	key = tempkey;
    }


    public void run ()
    {
	while (true)
	{

	    if ((key [0] == ' ' || key [0] == 'W' || key [0] == 'w') && key [1] == '1' && checkBlock ())
	    {
		vel = 10;
		key [1] = '0';
	    }

	}
    }


    private boolean checkBlock ()
    {
	return ((xy [0] > 66 && xy [0] < 146)
		|| (xy [0] > 212 && xy [0] < 292)
		|| ((xy [0] > 212 + 146 && xy [0] < 292 + 146))
		|| (xy [0] > 212 + 146 + 146 && xy [0] < 292 + 146 + 146)) && xy [1] <= 10;
    }
}

class LeftCheck extends Thread
{

    Console a;
    int[] xy;
    char[] key;

    public LeftCheck (Console c, int[] xval, char[] tempkey)
    {
	a = c;
	xy = xval;
	key = tempkey;

    }


    public void run ()
    {

	while (true)
	{

	    if ((key [0] == 'a' || key [0] == 'A') && key [1] == '1')
	    {
		xy [0] -= 5;
		key [1] = '0';

	    }

	}
    }
}


class RightCheck extends Thread
{

    Console a;
    int[] xy;
    char[] key;

    public RightCheck (Console c, int[] xval, char[] tempkey)
    {
	a = c;
	xy = xval;
	key = tempkey;

    }


    public void run ()
    {

	while (true)
	{

	    if ((key [0] == 'd' || key [0] == 'D') && key [1] == '1')
	    {
		xy [0] += 5;
		key [1] = '0';
	    }

	}
    }
}
