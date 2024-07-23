import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TaxiBookingApplication {
    public static void main(String[] args) {
        char[] points = {'A', 'B', 'C', 'D', 'E', 'F'};
        int input = 3;
        List<Taxi> taxiList = new ArrayList<>();
        List<Taxi> availableTaxis=new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n=4;
        Taxi taxi;
        for (int i = 1; i <= n; i++) {
            taxi = new Taxi(i);
            taxiList.add(taxi);
        }

        char pickup;
        char drop;
        while (input > 0) {
            System.out.println("Taxi Booking");
            System.out.println("1-Book Taxi");
            System.out.println("2-Print Taxi Details");
            System.out.println("0-Exit");
            input = sc.nextInt();

            switch (input) {
                case 1:
                    System.out.println("Enter Pickup Point");
                    String inputP = sc.nextLine();
                    pickup=sc.nextLine().charAt(0);

                    System.out.println("Enter Dropping Point");
                    drop = sc.nextLine().charAt(0);
                    
                    availableTaxis=getAvailableTaxis(taxiList,pickup,drop);
                    for (Taxi t:availableTaxis) {
                        System.out.println(t.earnings);
                    }
                    Collections.sort(availableTaxis, (a,b)->a.earnings- b.earnings);
                    for (Taxi t:availableTaxis) {
                        System.out.println(t.earnings);
                    }
                    if(availableTaxis!=null ){
                        Taxi available = getTaxi(availableTaxis,pickup)
                        available.location = drop;
                        available.earnings=
                                calcEarnings(availableTaxis.get(0).earnings,pickup,drop);
                        System.out.println(availableTaxis.get(0).taxiId+" booked");
                    }

            }
        }



    }

    private static Taxi getTaxi(List<Taxi> availabeTaxis, char pickup) {
        int nearest=0;
        for (int i = 0; i < availabeTaxis.size(); i++) {
            if ((int)availabeTaxis.get(i).location == pickup){
                availabeTaxis.get(i).isAvailable=true;
                return availabeTaxis.get(i);
            } else if ((int)availabeTaxis.get(i).location > pickup || (int)availabeTaxis.get(i).location < pickup) {
                
            }
        }
    }

    private static int calcEarnings(int earnings,char pickup, char drop) {
        int distance = 15;
        int points = (int)(drop-pickup);
        distance=distance*points;
        if(distance==5){
            earnings=earnings+100;
        }else if(distance>5){
            earnings=earnings+100+(10*(distance-5));
        }

        return earnings;
    }

    public static List<Taxi> getAvailableTaxis (List<Taxi> taxiList, char pickup, char drop){

        List<Taxi> availableTaxiList = new ArrayList<>();

        for (int i = 0; i < taxiList.size(); i++) {
            if(taxiList.get(i).isAvailable && taxiList.get(i).location==pickup
            || taxiList.get(i).isAvailable && (int)taxiList.get(i).location-(int)pickup <= 0){
                availableTaxiList.add(taxiList.get(i));
            }
        }

        return availableTaxiList;
    }
}
