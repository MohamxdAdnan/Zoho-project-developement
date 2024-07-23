public class Taxi {

    int bookingId;
    int taxiId;
    Boolean isAvailable;
    char pickupPoint;
    char dropPoint;

    int earnings;
    char location;

    Taxi(int id){
        this.location = 'A';
        this.isAvailable=true;
        this.taxiId=id;
        this.earnings=0;
    }


}
