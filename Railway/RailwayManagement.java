import java.util.*;

public class RailwayManagement{
    private static Scanner sc;

    static void clear() {
        System.out.print("\033[H\033[2J");
    }
    static void RailwayFunc() {
        clear();
        System.out.println("RailWay Management");
        System.out.println();
        System.out.println("1.Admin Login");
        System.out.println("2.User Login");
        System.out.println("3.Exit");
        System.out.println();
        System.out.println("Enter Choice :");
        int ch = sc.nextInt();

        if (ch == 1) {
            Admin.Adminlogin();
        } else if (ch == 2) {
            Passenger.PassengerLogin();
        } else if (ch == 3) {
            System.exit(0);

        } else {
            System.out.println("Invalid option");
            System.out.println();
            System.out.println("Press enter to continue...");
            try {
                System.in.read();
                RailwayFunc();
            } catch (Exception e) {
            }
        }
    }



    public static void main(String[] args) {
        sc = new Scanner(System.in);

        //Default Train Details 
        for (int i = 0; i < 1; i++) {
            Admin.Trains.add(new ArrayList<ArrayList<String>>(5));
            for (int j = 0; j < 5; j++) {
                Admin.Trains.get(i).add(new ArrayList<String>(Arrays.asList("0", "0", "0")));
            }
        }
        Admin.Traindetails.add(new Trains(String.valueOf(Admin.Traingen), "Express", "Coimbatore-Chennai",
                "Coimbatore Salem Tirchy Chennai"));
        Admin.Traingen++;
      
        //Default User Details 

        Passenger.Passengers.add(new Passenger("1","User","User123"));

        RailwayFunc();
    }

}

class Admin{
    private static Scanner sc = new Scanner(System.in);
    
    static int Traingen=1;
    static boolean call=false;
    static String AdminId="Admin";
    static String AdminPassword="1234";

    static ArrayList<ArrayList<ArrayList<String>>> Trains = new ArrayList<>();
    static List<Trains> Traindetails = new ArrayList<>();

    static void Adminlogin(){
        RailwayManagement.clear();
        System.out.println("Admin Login");
        System.out.println();
        System.out.println("Enter Admin Id: ");
        String adminId = sc.next();
        System.out.println("Enter Password: ");
        String password = sc.next();

        if (adminId.equals(AdminId) && password.equals(AdminPassword)) {
            AdminMain();
        } else {
            System.out.println("Invalid Credentials");
            try {
                System.in.read();
                RailwayManagement.RailwayFunc();
            } catch (Exception e) {
            }
        }
        
        


    }
    static void AdminMain(){
        RailwayManagement.clear();
        System.out.println("Admin Main");
        System.out.println();
        System.out.println("1. Add Train");
        System.out.println("2. Declare Seats");
        System.out.println("3. View Trains");
        System.out.println("4. Back");

        int AdminOption = sc.nextInt();

        if (AdminOption == 1) {
            AddTrain();
        } else if (AdminOption == 2) {
            DeclareSeats();
        } else if (AdminOption == 3) {
            call = true;
            ViewTrains();
        } else if (AdminOption == 4) {
            RailwayManagement.RailwayFunc();
        } else {
            System.out.println("Invalid Option");
            try {
                System.in.read();
                AdminMain();
            } catch (Exception e) {
            }
        }

    }
    
    //AdminMain
    static void AddTrain(){
        RailwayManagement.clear();
        System.out.println("Add Train");
        System.out.println();
        System.out.print("Enter Name : ");
        String tName = sc.next();
        System.out.print("Enter Route : ");
        String tRoute = sc.next();
        System.out.print("Enter Stations : ");
        sc.nextLine();
        String tStations = sc.nextLine();

        Trains.add(new ArrayList<ArrayList<String>>());
        Traindetails.add(new Trains(String.valueOf(Traingen), tName, tRoute, tStations));
        Traingen++;

        System.out.println();
        System.out.println("Press enter to continue");
        try {
            System.in.read();
            AdminMain();
        } catch (Exception e) {
        }
    }
    
    static void DeclareSeats(){
        RailwayManagement.clear();

        System.out.println("Enter Train Id : ");
        String id = sc.next();
        boolean Idp = false;
       
        for (int i = 0; i < Traindetails.size(); i++) {
            if (Traindetails.get(i).TrainId.equals(id)) {
                Idp = true;
            }
        }
        if (Idp) {

            System.out.println("Enter No of Seats : ");
            int No = sc.nextInt();

            int Id = Integer.parseInt(id) - 1;

            if (Trains.get(Id).size() == 0) {
                for (int i = 0; i < No; i++) {
                    String[] str = Traindetails.get(Id).TrainStations.split(" ");
                    ArrayList<String> arr = new ArrayList<String>();
                    for (int j = 0; j < str.length; j++) {
                        arr.add("0");
                    }
                    Trains.get(Id).add(arr);
                }
            } else {
                Trains.get(Id).clear();
                for (int i = 0; i < No; i++) {
                    String[] str = Traindetails.get(Id).TrainStations.split(" ");
                    ArrayList<String> arr = new ArrayList<String>();
                    for (int j = 0; j < str.length; j++) {
                        arr.add("0");
                    }
                    Trains.get(Id).add(arr);
                }
            }

            System.out.println();
            System.out.println("Seat Declarated");
            System.out.println();
            System.out.println("Press enter to continue");
            try {
                System.in.read();
                AdminMain();
            } catch (Exception e) {
            }
        } else {
            System.out.println();
            System.out.println("Invalid Train ID");
            System.out.println();
            System.out.println("Press enter to continue");
            try {
                System.in.read();
                AdminMain();
            } catch (Exception e) {
            }
        }

    }
    static void  ViewTrains(){
        RailwayManagement.clear();
        System.out.println("Trains");
        System.out.println();
        System.out.printf("%-8s%-20s%-20s%-45s%-35s\n","TrainId", "Train Name","Train Route","Stations","seats");
        for (int i = 0; i < Trains.size(); i++) {
            
            int seats=getAvailseats(Integer.parseInt(Traindetails.get(i).TrainId) - 1);
            System.out.printf("%-8s%-20s%-20s%-45s%-35s\n", Traindetails.get(i).TrainId, Traindetails.get(i).TrainName, Traindetails.get(i).TrainRoute,Traindetails.get(i).TrainStations,seats);
           
            System.out.println();
        }
        System.out.println("Press enter to continue");
        

        try {
            System.in.read();
            if (call) {
                AdminMain();
            } else {
                Passenger.PassengerMain();
            }
        } catch (Exception e) {
        }

    }

    static int getAvailseats(int id){
        int tot = 0;
        for (int j = 0; j < Trains.get(id).size(); j++) {
            for (int k = 0; k < Trains.get(id).get(j).size(); k++) {
                if (Trains.get(id).get(j).get(k).equals("0")) {
                    tot++;
                }
            }
        }

        return tot;

    }

}

class Passenger{
    private static Scanner sc = new Scanner(System.in);
    
    public String PassengerId;
    public String PassengerName;
    public String PassengerPassword;
    static String Current = null;
    static int Passengergen = 1;

    Passenger(String pId, String pName, String pPassword) {
        this.PassengerId = pId;
        this.PassengerName = pName;
        this.PassengerPassword = pPassword;
    }

    static List<Passenger> Passengers = new ArrayList<>();

    static void PassengerLogin(){
        RailwayManagement.clear();
        System.out.println("Passenger Login");
        System.out.println("1. New User Registration");
        System.out.println("2. Existing User Login");
        System.out.println("3. Back");
        System.out.println();
        System.out.println( "Enter your Choice : ");
        int ch = sc.nextInt();
        if (ch == 1) {
            RegisterUser();
        } else if (ch == 2) {
            Login();
        } else if (ch == 3) {
            RailwayManagement.RailwayFunc();
        } else {
            System.out.println("Invalid Options");
            System.out.println();
            System.out.println("Press enter to continue");
            try {
                System.in.read();
                PassengerLogin();;
            } catch (Exception e) {
            }
        }
    }


    static void RegisterUser(){
        RailwayManagement.clear();
        System.out.println("Registeration");
        System.out.println();
        System.out.println("Enter your username");
        sc.nextLine();
        String passengername = sc.nextLine();

        System.out.println("Enter your password");
        String passengerpassword = sc.next();

        String pId = String.valueOf(Passengergen);
        Passengergen++;
        for(int i=0;i<Passengers.size();i++){
            if(Passengers.get(i).PassengerName.equals(passengername)){
                Current= Passengers.get(i).PassengerId;
            }
        }
        
        Passengers.add(new Passenger(pId, passengername, passengerpassword));


        System.out.println();
        System.out.println("Press enter to continue");
        try {
            System.in.read();
            PassengerMain();
        } catch (Exception e) {
        }

    }

    static void Login(){
        RailwayManagement.clear();
        System.out.println("Login");
        System.out.println();
        System.out.println("Enter your Username :");
        String passengername = sc.next();

        System.out.println("Enter your password :");
        String passengerpassword = sc.next();

        for (int i = 0; i < Passengers.size(); i++) {
            if (Passengers.get(i).PassengerName.equals(passengername) && Passengers.get(i).PassengerPassword.equals(passengerpassword)) {
                Current = Passengers.get(i).PassengerId;
                PassengerMain();
            }
        }

        System.out.println("Invalid Credentials");
        System.out.println();
        System.out.println("Press enter to continue");
        try {
            System.in.read();
            RailwayManagement.RailwayFunc();
        } catch (Exception e) {
        }
    }
    static void PassengerMain(){
        RailwayManagement.clear();
        System.out.println("Welcome to Booking System");
        System.out.println("1. Trains ");
        System.out.println("2. Book Ticket");
        System.out.println("3. Booking History");
        System.out.println("4. Cancel Bookings");
        System.out.println("5. Back");

        int ch= sc.nextInt();

        if (ch== 1) {
            Admin.call = false;
            Admin.ViewTrains();
        } else if (ch == 2) {
            BookingTickets.BookTickets();
        } else if (ch == 3) {
            BookingTickets.BookingHistory();
        } else if (ch == 4) {
            BookingTickets.CancelBooking();
        } else if (ch == 5) {
            RailwayManagement.RailwayFunc();
        } else {
            System.out.println("Invalid option");
            System.out.println();
            System.out.println("Press enter to continue");
            try {
                System.in.read();
                PassengerMain();
            } catch (Exception e) {
            }
        }


    }

    
        
    

}

class Trains{
    public String TrainId;
    public String TrainName;
    public String TrainRoute;
    public String TrainStations;
    Trains(String tId, String tName, String tRoute, String tStations) {
        this.TrainId = tId;
        this.TrainName = tName;
        this.TrainRoute = tRoute;
        this.TrainStations = tStations;
    }
}

class BookingTickets{
    private static Scanner sc = new Scanner(System.in);

    static int Ticketgen = 1;
    static List<BookingTickets> Tickets = new ArrayList<>();
    static boolean bookingstatus=false;


    

    public int TicketNo;
    public String TicketPassangerId;
    public int TicketTrainId;
    public String TicketTrainName;
    public String TicketTrainRoute;
    public int TicketStartstation;
    public int TicketEndstation;
    public String TicketBookingStatus;
    public int TicketTrainSeat;

    BookingTickets(int tNo, String PId, String tTrainName, String tTrainRoute,String tTicketStatus, int tTrainId, int tTrainSeat, int tStartstations, int tEndstation) {
        this.TicketNo = tNo;
        this.TicketPassangerId = PId;
        this.TicketTrainId = tTrainId;
        this.TicketTrainName = tTrainName;
        this.TicketTrainRoute = tTrainRoute;
        this.TicketTrainSeat = tTrainSeat;
        this.TicketStartstation = tStartstations;
        this.TicketEndstation = tEndstation;
        this.TicketBookingStatus = tTicketStatus;
    }

    static void BookTickets(){
        RailwayManagement.clear();
        System.out.println();
        System.out.println("Trains Available");
        System.out.println();
        System.out.printf("%-8s%-20s%-20s%-20s\n", "S.no", "Train ID", "Train Name", "Train Routes");
        for (int i = 0; i < Admin.Traindetails.size(); i++) {
            System.out.printf("%-8s%-20s%-20s%-20s\n", i + 1, Admin.Traindetails.get(i).TrainId, Admin.Traindetails.get(i).TrainName,
                    Admin.Traindetails.get(i).TrainRoute);
        }
        System.out.println();
        System.out.println("Enter number of Bookings, you need to Book : ");
        int noofbooking = sc.nextInt();

        for (int i = 0; i < noofbooking; i++) {
            RailwayManagement.clear();
            System.out.println("Book Tickets");
            System.out.println();
            System.out.println("Enter Train Id");
            String bookingtrainId = sc.next();

            boolean Idp = false;
            
            for (int j = 0; j < Admin.Traindetails.size(); j++) {
                if (Admin.Traindetails.get(j).TrainId.equals(bookingtrainId)) {
                    Idp= true;
                }
            }

            if (Idp) {
                
                ViewavailTrains(Integer.parseInt(bookingtrainId) - 1);

                System.out.println("Enter Boarding Station : ");
                int stationBoard = sc.nextInt();

                System.out.println("Enter Depature Station :");
                int stationDepature = sc.nextInt();

                int tId = Integer.parseInt(bookingtrainId) - 1;
                bookingstatus = true;


                int Seatno = BookSeat(stationBoard, stationDepature, tId, Passenger.Current);

                if (Seatno != -1) {
                    System.out.println("Your Seat no is : " + Seatno);
                } else {
                        Tickets.add(new BookingTickets(-1, Passenger.Current, Admin.Traindetails.get(tId).TrainName,
                            Admin.Traindetails.get(tId).TrainRoute, "Pending",
                            Integer.parseInt(Admin.Traindetails.get(tId).TrainId),
                            -1, stationBoard, stationDepature));
                    System.out.println("No Seats Available,you are in the waiting list");
                }

                System.out.println();
                System.out.println("Press enter to continue");
                try {
                    System.in.read();
                } catch (Exception e) {
                }
            } else {
                System.out.println();
                System.out.println("Invalid Train ID");
                System.out.println();
                System.out.println("Press enter to continue");
                try {
                    System.in.read();
                    BookTickets();
                } catch (Exception e) {
                }
            }
        }

        System.out.println();
        System.out.println("Press enter to continue");
        try {
            System.in.read();
            Passenger.PassengerMain();
        } catch (Exception e) {
        }

     
    }
    static void ViewavailTrains(int id){
        
        System.out.println("Trains");
        System.out.println();
        System.out.printf("%-8s%-20s%-20s%-20s%-25s\n","TrainId", "Train Name","Train Route","Train Stations","seats");
            int seats=Admin.getAvailseats(Integer.parseInt(Admin.Traindetails.get(id).TrainId) - 1);
            System.out.printf("%-8s%-20s%-20s%-20s%-25s\n", Admin.Traindetails.get(id).TrainId, Admin.Traindetails.get(id).TrainName, Admin.Traindetails.get(id).TrainRoute,Admin.Traindetails.get(id).TrainStations,seats);
            System.out.println();
    }
    static int BookSeat(int board,int depature,int id,String passenger){
           
        int total = -1;
        for (int i = 0; i < Admin.Trains.get(id).size(); i++) {
            int tot = 0, c = 0;
            for (int j = board- 1; j < depature; j++) {
                c+=1;
                if (Admin.Trains.get(id).get(i).get(j).equals("0")) {
                    tot+=1;
                }
            }
            if (tot == c) {

                for (int j = board - 1; j < depature; j++) {
                    Admin.Trains.get(id).get(i).set(j, passenger);
                }
                total = i;
                if (bookingstatus) {
                    Tickets.add(new BookingTickets(Ticketgen,Passenger.Current,
                            Admin.Traindetails.get(id).TrainName, Admin.Traindetails.get(id).TrainRoute, "Booked",
                            Integer.parseInt(Admin.Traindetails.get(id).TrainId), i, board, depature));
                    Ticketgen+=1;
                }
                return total;
            }
        }

        return total;

    }

    static void BookingHistory(){
        RailwayManagement.clear();
        System.out.println("Tickets Booked");
        System.out.println();
        System.out.printf("%-15s%-20s%-20s%-13s%-13s%-13s%-5s\n", "Ticket No", "Train Name", "Train Route", "Seat No","Boarding", "Depature", "BookStatus");
        for (int i = 0; i < Tickets.size(); i++) {
            if (Tickets.get(i).TicketPassangerId.equals(Passenger.Current)) {

                System.out.printf("%-15s%-20s%-20s%-13s%-13s%-13s%-5s\n", Tickets.get(i).TicketNo,Tickets.get(i).TicketTrainName, Tickets.get(i).TicketTrainRoute,
                        Tickets.get(i).TicketTrainSeat, Tickets.get(i).TicketStartstation,Tickets.get(i).TicketEndstation, Tickets.get(i).TicketBookingStatus);
            }
        }
        System.out.println();
        System.out.println("Press enter to continue");
        try {
            System.in.read();
            Passenger.PassengerMain();
        } catch (Exception e) {
        }

    }
    static void CancelBooking(){
        RailwayManagement.clear();
        System.out.println("Enter Ticket No : ");
        int Ticketno = sc.nextInt();

        boolean isTicketavail = false;
       
        for (int i = 0; i < Tickets.size(); i++) {
            if (Tickets.get(i).TicketNo == Ticketno) {
                isTicketavail = true;
            }
        }

        if (isTicketavail) {

            for (int i = 0; i < Tickets.size(); i++) {
                if (Tickets.get(i).TicketNo == Ticketno) {
                    RemoveSeats(Tickets.get(i).TicketTrainId - 1, Tickets.get(i).TicketTrainSeat,
                            Tickets.get(i).TicketStartstation, Tickets.get(i).TicketEndstation);
                    Tickets.remove(i);
                    WaitingListcheck();
                    break;
                }
            }

            System.out.println();
            System.out.println("Ticket No " + Ticketno + " is Cancelled ");
        } else {
            System.out.println();
            System.out.println("Ticket No " + Ticketno  + "is Not Found ");
        }
        System.out.println();
        System.out.println("Press enter to continue");
        try {
            System.in.read();
            Passenger.PassengerMain();
        } catch (Exception e) {
        }
    }

    static void RemoveSeats(int id,int seatno,int tboard,int tdepature){
        for (int k = tboard - 1; k < tdepature; k++) {
            Admin.Trains.get(id).get(seatno).set(k, "0");
        }

    }


    static void WaitingListcheck(){
        bookingstatus = false;

        for (int i = 0; i < Tickets.size(); i++) {
            if (Tickets.get(i).TicketBookingStatus.equals("Pending")) {
                int tot = BookSeat(Tickets.get(i).TicketStartstation, Tickets.get(i).TicketEndstation,
                        Tickets.get(i).TicketTrainId - 1, Tickets.get(i).TicketPassangerId);
                if (tot != -1) {
                    Tickets.get(i).TicketBookingStatus = "Booked";
                    Tickets.get(i).TicketNo = Ticketgen;
                    Tickets.get(i).TicketTrainSeat = tot;

                    Ticketgen+=1;
                }
            }
        }
    }

}