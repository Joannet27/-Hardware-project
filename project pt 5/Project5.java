//Project Part	5
//From chapter	2-6
import java.util.Scanner;
public class Project5
{
   public static void main(String[]args)
   {
   // variables to hold data through the program
      int graphicSpeed, processorSpeed;
      int coreNum, computerNum, resoluChoice;
      String resolution, graphicQuality;
   // Constant
      final int LOWEST_GPU = 800;
      final int HIGHEST_GPU = 2000;
      final int LOWEST_CPU = 1000;
      final int HIGHEST_CPU = 5500;
      final int LOWEST_CORE_NUMBER = 1;
      final int HIGHEST_CORE_NUMBER = 16;
   
      Scanner keyboard = new Scanner(System.in);
   	
                     //	Asking user	for the number	of	computer	they have
      System.out.print("How many computers are being processed? ");
      computerNum	= keyboard.nextInt();
   	//while loop to check if user	is	entering	value	less than 0
      while(computerNum	<=	0)
      {
         System.out.println("Please enter a positive number");
         System.out.print("How many computers are being processed? ");
         computerNum	= keyboard.nextInt();
      }
   	               //	String title
      displayTitle();      	
   
   	
   	        //declaring	varable to take in multipler value from the choosen resolutio
   	//declaring	perforScore	store	the calcuation	for Graphics Quality
      //adding 0 and "" to avoid initialize error
      double multiplier = 0, perforScore = 0, highestPerform = 0, lowestPerform = 0;
      resolution = "";
   	
   	//for	loop
      for(int x = 1; x <= computerNum; x++)
      {
                              //	Asking user	to	enter	the clock speed of the graphics card
      //	Then save to graphicSpeed variable
         System.out.print("Please enter the clock speed(in Megahertz) of your graphics card: ");
         graphicSpeed =	keyboard.nextInt();
      //while loop to check user	are enterin	a valid GPU	clock	speed	from 800	- 2000 MHz
         while(graphicSpeed <	LOWEST_GPU || graphicSpeed > HIGHEST_GPU)
         {
            System.out.println("The GPU clock speed should be between 800 and 2000 MHz");
            System.out.print("Please enter the clock speed(in Megahertz) of your graphics card: ");
            graphicSpeed =	keyboard.nextInt();
         }
      
      
                              //	Asking user	to	enter	the clock speed of their cpu 
      //	Then save to graphicSpeed variable
         System.out.print("Please enter the clock speed(in Megahertz) of your processor: ");
         processorSpeed	= keyboard.nextInt();
      //	while	loop to check user are enterin a	valid(outrange) CPU clock speed from 1000	- 5500 MHz
         while(processorSpeed	< LOWEST_CPU || processorSpeed >	HIGHEST_CPU)
         {
            System.out.println("The CPU clock speed should be between 1000 and 5500 MHz");
            System.out.print("Please enter the clock speed(in Megahertz) of your processor: ");
            processorSpeed	= keyboard.nextInt();
         }
      
      
                           //	Ask user	to	enter	the amount of cores for	their	cpu has
      //	Then save to coreNum	variable	  
         System.out.print("Please enter the number of cores of your processor: ");
         coreNum = keyboard.nextInt();
      //	while	loop to check user are enterin a	valid(outrange) CPU clock speed
         while(coreNum < LOWEST_CORE_NUMBER	||	coreNum > HIGHEST_CORE_NUMBER)
         {
            System.out.println("The number of cores should be between 1 and 16");
            System.out.print("Please enter the number of cores of your processor: ");
            coreNum = keyboard.nextInt();
         }
      
      
                           //	ASking user	to	choose the option	of	their	monitor resolution
      //Then save	the chosen option	to	resoluChoice
         System.out.println("What is the resolution of your monitor?");
         System.out.print("1.1280x720 \n2.1920x1080 \n3.2560x1440 \n4.3840x2160 \nPlease select from the option above: ");
         resoluChoice = keyboard.nextInt();
      
      //while loop to check user	are choosing the vaild(outrange)	resolution choice	given	
         while(resoluChoice <	1 || resoluChoice	> 4)
         {
            System.out.println("Please select between 1 - 4 for your monitor resolution");
            System.out.println("What is the resolution of your monitor?");
            System.out.print("1.1280x720 \n2.1920x1080 \n3.2560x1440 \n4.3840x2160 \nPlease select from the option above: ");
            resoluChoice =	keyboard.nextInt();
         }
      
         HardwareLastname computer = new HardwareLastname(graphicSpeed, processorSpeed, coreNum, resoluChoice);
            
      //If Statement	that checks	which	"Resolution" user	choose to determing th multiplier for later calculation.
         computer.getResolutionString();
         computer.getMultiplierValue();
      			
      //Calculate	the "Performace Score" after getting the monitor resolution
         perforScore = computer.calculatePerformanceScore();
      
      //if statement	to	determined the	recommened Graphics Quality
         computer.getRecommendedQuality();
           
         
         //taking in the highest performance score
         if(perforScore > highestPerform )
         {
            highestPerform = perforScore;
         }
         else if(perforScore < highestPerform)
         {
            lowestPerform = perforScore;
         }
         else
         {
            lowestPerform = perforScore;
         }
      
      //	step 4-5
      //	Will display a	message and	user inputed infomation.  
         displayTitle();
         computer.displayInformation();
      
         
      }
      System.out.printf( "The highest performance score was: %,.3f \n", highestPerform);
      System.out.printf( "The lowest performance score was: %,.3f \n", lowestPerform);
   }
                                        // Methods 
   /** Method: display Title */
   public static void displayTitle()
   {
      System.out.println("\nComputer Hardware Graphics Quality Recommendation Tool \n");
   }
   
   /** get resolution string */
   public static String getResolutionString(int choice)
   {  
      // local string variable to return
      String resolution = "";
      switch(choice)
      {
         case 1:
            resolution = "1280 x 720";
            break;
         case 2:
            resolution ="1920 x 1080";
            break;
         case 3:
            resolution ="2560 x 1440";
            break;
         case 4:
            resolution = "3840 x 2160";
            break;
      }
      return resolution;         
   }
   
   /** get resolution string */

   public static double getMultiplierValue(int choice)
   {
      //local value to hold the multipler value to return
      double multiplierValue = 0;
      switch(choice)
      {
         case 1:
            multiplierValue = 1;
            break;
         case 2:
            multiplierValue = .75;
            break;
         case 3:
            multiplierValue = .55;
            break;
         case 4:
            multiplierValue = .35;
            break;
      }
      return multiplierValue;
   }
  
   public static double calculatePerformanceScore(double graphic, int core, double processor, double multiplierValue)
   {
      double score = 0;
      score = ((5*graphic)+(core*processor))*multiplierValue;
      return score;
   }
   
   /** Method: get the performance score get recommended quality */
   public static String getRecommendedQuality( double score)
   {
      String quality = " ";
      if(score	> 17000)
      {
         quality	= "Ultra";
      }
      else if(score > 15000)
      {
         quality	= "High";
      }
      else if(score > 13000)
      {
         quality	= "Medium";
      }
      else if(score > 11000)
      {
         quality	= "Low";
      }
      else
      {
         quality	= "Unable to Play";
      }
      return quality;
   }
   
   /** method: display the recommend computer information */
   public static void displayInformation(double graphicSpeed, double processorSpeed, int coreNum, String resolution, double perforScore, String graphicQuality)
   {
      System.out.println("GPU Clock Speed: "	+ graphicSpeed	+ " MHz");
      System.out.println("CPU Clock Speed: "	+ processorSpeed + " MHz");
      System.out.println("Number of cores: "	+ coreNum);
      System.out.println("Monitor Resolution: "+ resolution);
      System.out.printf("Performance Score: %,.3f \n", perforScore);
      System.out.println("Recommended Graphics Quality: "+graphicQuality + "\n");
   }
   
}//this the class brace