import java.util.List;
import java.util.ArrayList;

class ClimbInfo
{
   private String name;
   private int time;

   /** Creates a ClimbInfo object with name peakName and time climbTime.
     *
     * @param peakName the name of the mountain peak
     * @param climbTime the number of minutes taken to complete the climb */
   public ClimbInfo(String peakName, int climbTime)
   {
      name = peakName;
      time = climbTime;
   }

   /** @return the name of the mountain peak */
   public String getName()
   {
      return name;
   }

   /** @return the number of minutes taken to complete the climb */
   public int getTime()
   {
      return time;
   }

   public String toString()
   {
      return "Peak name: " + name + " time: " + time;
   }
}

public class ClimbingClub
{
   /** The list of climbs completed by members of the club.
     *  Guaranteed not to be null. Contains only non-null references.
     */
   private List<ClimbInfo> climbList;

   /** Creates a new ClimbingClub object. */
   public ClimbingClub()
   {
      climbList = new ArrayList<ClimbInfo>();
   }

   /** Adds a new climb with name peakName and time climbTime to the end of the list of climbs
     *
     * @param peakName the name of the mountain peak climbed
     * @param climbTime the number of minutes taken to complete the climb
     */
   public void addClimbA(String peakName, int climbTime)
   {
      climbList.add(new ClimbInfo(peakName, climbTime));
   }

   /** Adds a new climb with name peakName and time climbTime to the list of climbs in order by name
     *
     * @param peakName the name of the mountain peak climbed
     * @param climbTime the number of minutes taken to complete the climb
     */
   public void addClimbB(String peakName, int climbTime)
   {
      // find the position for the new item
      int index = 0;
      while (index < climbList.size() && climbList.get(index).getName().compareTo(peakName) <= 0)
      {
         index++;
      }
      climbList.add(index, new ClimbInfo(peakName, climbTime));
   }

   /** @return the number of distinct names in the list of climbs */
   public int distinctPeakNames()
   {
      if (climbList.size() == 0)
      {
         return 0;
      }

      ClimbInfo currInfo = climbList.get(0);
      String prevName = currInfo.getName();
      String currName = null;
      int numNames = 1;
      for (int k = 1; k < climbList.size(); k++)
      {
         currInfo = climbList.get(k);
         currName = currInfo.getName();
         if (prevName.compareTo(currName) != 0)
         {
            numNames++;
            prevName = currName;
         }
      }
      return numNames;
   }

   public String toString()
   {
      String output ="";
      for (ClimbInfo info : climbList)
      {
         output = output + info.toString() + "\n";
      }
      return output;
   }

   public static void main(String[] args)
   {
      ClimbingClub hikerClub = new ClimbingClub();
      hikerClub.addClimbA("Monadnock", 274);
      hikerClub.addClimbA("Whiteface", 301);
      hikerClub.addClimbA("Algonquin", 225);
      hikerClub.addClimbA("Monadnock", 344);
      System.out.print(hikerClub);
      System.out.println("The order printed above should be Monadnock, Whiteface, Algonquin, Monadnock");
      System.out.println("Distinct peaks is " + hikerClub.distinctPeakNames() + " and should be " + 3);

      hikerClub = new ClimbingClub();
      hikerClub.addClimbB("Monadnock", 274);
      hikerClub.addClimbB("Whiteface", 301);
      hikerClub.addClimbB("Algonquin", 225);
      hikerClub.addClimbB("Monadnock", 344);
      System.out.print(hikerClub);
      System.out.println("The order printed above should be Algonquin, Monadnock, Monadnock, Whiteface");
      System.out.println("Distinct peaks is " + hikerClub.distinctPeakNames() + " and should be " + 3);
   }

}
