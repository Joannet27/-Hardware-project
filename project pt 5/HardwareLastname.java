public class HardwareLastname
{
   //instance 'fields'<--
   private int gpuClockSpeed, cpuClockSpeed, coresNum,monitorResolu;
   
         //Constructors
  // No-arg constructor
   public HardwareLastname()
   {
   }
  
  //COnstucotr that takes arguments
  /**
   @ param gpu the GPU clock speed
   @ param cpu the CPU clock speed
   @ param core the Number of core
   @ param monitor the resolution of the monitor
  */
   public HardwareLastname(int gpu,int cpu, int core, int monitor)
   {
      gpuClockSpeed = gpu;
      cpuClockSpeed = cpu;
      coresNum = core;
      monitorResolu = monitor;
   }
   /**
      get the resolution and pass it as a string varable
   */
   public String getResolutionString()
   {
      String resolution = "";
      switch(monitorResolu)
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
   
   /**
      returnts the appropriate mulitpluiers value for the computer
   */
   public double getMultiplierValue()
   {
      double multiplierValue = 0;
      switch(monitorResolu)
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
   
   /**
      returns the poerformance score of the computer hardware
   */
   public double calculatePerformanceScore()
   {
      return ((5*gpuClockSpeed)+(coresNum*cpuClockSpeed))*getMultiplierValue();
       
   }
   
   /**
      returns recommended graphisc quality
   */
   public String getRecommendedQuality()
   {
      String quality = " ";
      if(calculatePerformanceScore()	> 17000)
      {
         quality	= "Ultra";
      }
      else if(calculatePerformanceScore() > 15000)
      {
         quality	= "High";
      }
      else if(calculatePerformanceScore() > 13000)
      {
         quality	= "Medium";
      }
      else if(calculatePerformanceScore() > 11000)
      {
         quality	= "Low";
      }
      else
      {
         quality	= "Unable to Play";
      }
      return quality;
   
   }
   
   /**
      display the information for a single computer
   */
   public void displayInformation()
   {
      System.out.println("GPU Clock Speed: "	+ gpuClockSpeed	+ " MHz");
      System.out.println("CPU Clock Speed: "	+ cpuClockSpeed + " MHz");
      System.out.println("Number of cores: "	+ coresNum);
      System.out.println("Monitor Resolution: "+ getResolutionString());
      System.out.printf("Performance Score: %,.3f \n", calculatePerformanceScore());
      System.out.println("Recommended Graphics Quality: "+ getRecommendedQuality() + "\n");
   
   }
}