import java.io.*;
import java.time.LocalDate;
class OnlineReservation{
BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
public void startReservationSystem()throws IOException
{
String base="Burdwan";
String stations[]={"Duragpur","Duragpur","Duragpur","Duragpur","Duragpur","Duragpur","Duragpur","Duragpur","Duragpur","Duragpur","Duragpur","Duragpur","Duragpur","Duragpur","Duragpur","Duragpur","Duragpur","Duragpur","Duragpur","Duragpur","Duragpur","Duragpur","Duragpur","Duragpur"};
double fares[]={20.0,25,30,10,20,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25};
while(true){
    System.out.println("\f Welcome To Online Reservation System");
    System.out.println("================================");
    System.out.println("Press               Station                Fares");
    System.out.println("====================================");
    for(int i=0;i<stations.length;i++){
        System.out.println((i+1)+"                  "+stations[i]+"                    "+fares[i]);

    }
    int option=Integer.parseInt(r.readLine());
    if(option>0&&option<=24)
    {
        System.out.println("Press enter the number of passangers");
        int p=Integer.parseInt(r.readLine());
        System.out.println("Press E for express and L for Local/Passanger Ticket");
      int factor=1;
      String type;  
      while(true){
        type=r.readLine();
        if(type.equalsIgnoreCase("E"))
            {factor=3;
            break;
            }
        else if(!type.equalsIgnoreCase("L")){
            System.out.println("Wrong Choice Enter Again::");
            continue;
        }
        else{
            break;
        }
      }
      type=type.toUpperCase();
      System.out.println("Do you want a RETURN ticket? Y for YES,Any other character for NO: ");
      String ret=r.readLine();
      boolean returnTkt=ret.equalsIgnoreCase("Y")|| ret.equalsIgnoreCase("Yes")?true:false;
      printTicket(stations[option-1],fares[option-1],p,factor,type,base,returnTkt);
    System.out.println("Do you want to continue to next reservation? Y for YES Any other character for no :");
    String choice=r.readLine();
    if(choice.equalsIgnoreCase("Y")||choice.equalsIgnoreCase("YES"))
    continue;
   else
   break;
    }
    else{
         System.out.println("Enter Wrong Choice .Do you want to continue with correct choice ? press Y for YES Any other character for no :");
    String choice=r.readLine();
    if(choice.equalsIgnoreCase("Y")||choice.equalsIgnoreCase("YES"))
    continue;
   else
   break;
}
}
}
    
private void printTicket(String station,double fare,int p,int factor,String type,String base,boolean returnTkt){
System.out.println("-----------------------------------------------------------------------");    
System.out.println("--------------------------ONLINE TICKET--------------------------------");
System.out.println("Journey from : "+base+"\njourney to :"+station+"\nNo of passengers:  "+p+"\n Ticket type: "+type);
String ret=returnTkt==true?"Return ticket":"Not Return Ticket";
System.out.println("\nJourney Return type ? :"+ret+"\n");
System.out.println("Date of journey:"+LocalDate.now());
System.out.println("------------------------------------------------------------------------");
double totalFare= fare+factor*p;
if(returnTkt)
totalFare=2;
System.out.println("Total fare :: Rs"+totalFare);
System.out.println("-------------------------------------------------------------------------");
} 
}

