import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

//class={Libray,Admin,Borrower,Books,CurrentDate,BorrowerBooks}

class Library{
    private static Scanner sc;

    public static String CurrentDate;
    
    static void clear(){
        System.out.println("\033[H\033[2J");
    } 
    public static void LibraryMain(){
        Library.clear();
       System.out.println("Current Date:" +CurrentDate);
       System.out.println();
       System.out.println("WELCOME TO LIBRARAY MANAGEMENT");
       System.out.println();
        System.out.println("1.Admin Login");
        System.out.println("2.Borrower Login");
        System.out.println("3.Change Current Date");
        System.out.println("4.Exit");
        int choice =sc.nextInt();

        switch(choice){
            case 1:
               Admin.Login();
               break;
            case 2:
               Borrower.Login();
               break;
            case 3:
               currentdate.ChangeCurrentDate();
               break;
            case 4:
               System.exit(0);
            default:
               System.out.println("Invalid Option");
               System.out.println();
               System.out.println("Press enter to continue...");
               try {
                   System.in.read();
                   LibraryMain();
               } catch (Exception e) {

               }
        }
    
    }
    public static void main(String args[]){
         sc=new Scanner(System.in);

         Date date = new Date(); // creating date => Fri jan 1 ...

         SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // format date => "yyyy-MM-dd"
 
         CurrentDate = String.valueOf(formatter.format(date)); // changing the date format => "yyyy-MM-dd"
 
         
 
         //Defaut Admin info
         Admin.Admin.add(new Admin("A0","Admin1","Admin@gmail.com","Admin"));

        //Default Borrower info
        Borrower.Borrower.add(new Borrower("B0","Borrower", "Borrower@gmail.com", "Borrower"));

        
         LibraryMain();
    }
}

class Admin{
    private static Scanner sc  = new Scanner(System.in);

    public String AdminId;
    public String AdminName;
    public String AdminEmail;
    public String AdminPassword;

    static int Adminidgen=1;
    static int Lossbookper=50;
    static int MembershipCardloss=10;
    static int ReturnBooksevenafterper=80;
    static int fineforeachday=2;


    static ArrayList<Admin> Admin=new ArrayList<>();

    Admin(String aid,String aname,String aemail,String apwd){
        this.AdminId=aid;
        this.AdminName=aname;
        this.AdminEmail=aemail;
        this.AdminPassword=apwd;
    }
    
    static void Login() {
        Library.clear();
        System.out.println("\tAdmin Login");

        System.out.println();
      
        System.out.println("Enter Email: ");
        String adminemail = sc.next();

        System.out.println("Enter Password: ");
        String adminpassword = sc.next();

       // System.out.println(adminemail+" "+adminpassword);
        for (int i = 0; i < Admin.size(); i++) {
            if (Admin.get(i).AdminEmail.equals(adminemail) && Admin.get(i).AdminPassword.equals(adminpassword)) {
              
                AdminMain();
            }
        }
     
        System.out.println("Invalid Credentials");
        System.out.println();
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
            Library.LibraryMain();
        } catch (Exception e) {
        }
    }
    static void AdminMain(){
        Library.clear();
        System.out.println("Admin Main");
        System.out.println();
        System.out.println("1.Books Module");
        System.out.println("2.Borrower Module");
        System.out.println("3.Add Admin");
        System.out.println("4.Back");
        int choice=sc.nextInt();
        switch(choice){
            case 1:
               BooksMain();
               break;
            case 2:
               BorrowerMain();
               break;
            case 3:
               AddAdmin();
               break;
            case 4:
               Library.LibraryMain();
               break;
            default:
               System.out.println("Invalid option");
               System.out.println();
                System.out.println("Press enter to continue...");
                try {
                   System.in.read();
                    AdminMain();
                }   catch (Exception e) {
                
                }
        }
    }

    static void BooksMain(){
        Library.clear();
        System.out.println("Books Module");
        System.out.println();
        System.out.println("1.Add Books");
        System.out.println("2.Modify Books");
        System.out.println("3.Delete Books");
        System.out.println("4.View Books");
        System.out.println("5.Search Books");
        System.out.println("6.Books Report");
        System.out.println("7.Back");
        int choice=sc.nextInt();
        switch(choice){
            case 1:
                Books.AddBooks();
                break;
            case 2:
                Books.ModifyBooks();
                break;
            case 3:
                Books.DeleteBooks();
                break;
            case 4:
                Borrower.call=false;
                Books.ViewBooks();
                break;
            case 5:
                Books.SearchBooks();
                break;
            case 6:
                Books.Booksreport();
                break;
            case 7:
                AdminMain();
                break;
            default:
                System.out.println("Invalid option");
                System.out.println();
                System.out.println("Press enter to continue...");
                try {
                    System.in.read();
                    BooksMain();
                }   catch (Exception e) {
                }
        }
    }

    static void BorrowerMain(){
        Library.clear();
        System.out.println("Borrower Module");
        System.out.println();
        System.out.println("1.Add Borrower");
        System.out.println("2.View Borrowers");
        System.out.println("3.Manage Borrower Fines");
        System.out.println("4.Back");
        int choice=sc.nextInt();
        switch(choice){
            case 1:
               Borrower.AddBorrower();
               break;
            case 3:
               ManageBorrowerFine();
               break;
            case 2:
               viewborrower();
              break;
            case 4:
              AdminMain();
              break;
            default:
                System.out.println("Invalid option");
                System.out.println();
                System.out.println("Press enter to continue...");
                try {
                    System.in.read();
                    BorrowerMain();
                }    catch (Exception e) {
                }
        }
       

    }

    static void viewborrower(){
        Library.clear();
        System.out.println("Borrowers");
        System.out.println();
        System.out.printf("%-8s%-20s%-20s%-20s\n","S.no","Borrower id","Borrower name","Borrower email");
        for(int i=0;i<Borrower.Borrower.size();i++){
            System.out.printf("%-8s%-20s%-20s%-20s\n",i+1,Borrower.Borrower.get(i).BorrowerId,Borrower.Borrower.get(i).BorrowerName,Borrower.Borrower.get(i).BorrowerEmail);
        }
        System.out.println();
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
            BorrowerMain();
        }   catch (Exception e) {
        }
    }

    static void AddAdmin(){
        Library.clear();
        System.out.println("Add Admin");
        System.out.println();
      
        System.out.println("Enter Admin name:");
        String aname=sc.next();

        System.out.println("Enter Admin Email:");
        String aemail=sc.next();
    
        String[] arr=aemail.split("@");
        String apwd=arr[0];

        Admin.add(new Admin(String.valueOf(Adminidgen), aname, aemail, apwd));
        Adminidgen++;

        System.out.println();
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
            AdminMain();
        } catch (Exception e) {
        }

    }

   //BorrowerMain 
    static void ManageBorrowerFine(){
        Library.clear();
        System.out.println("Manage Borrower Fine");
        System.out.println();
       
        System.out.println("1.Fine for Each day after 15 days of return date");
        System.out.println("2.Fine for after 25 days of return");
        System.out.println("3.Fine for Lost Book");
        System.out.println("4.Fine for Lost Memebership card");
        System.out.println("5.Back");
        int ch=sc.nextInt();
        if(ch==1){
            fineforeachday();

        }else if(ch==2){
            fineafter25days();

        }else if(ch==3){
            fineforlostbook();
        }else if(ch==4){
           fineforlostmembershipcard();
        }else if(ch==5){
           BorrowerMain();
        }else{
            System.out.println("Invaild Option");
            System.out.println();
            System.out.println("Press enter to continue...");
            try {
                System.in.read();
                ManageBorrowerFine();
            }   catch (Exception e) {
            }
        }


       
    
    }

    static void fineforeachday(){
        Library.clear();
        System.out.println("Fine for Each Day");
        System.out.println("Fine Amount : "+fineforeachday);
        System.out.println();
        System.out.println("Enter the fine amount : ");
        int s=sc.nextInt();
        fineforeachday=s;
        System.out.println("Fine changed");
        System.out.println();
        System.out.println("Press enter to continue...");
        try {
           System.in.read();
            ManageBorrowerFine();
         }   catch (Exception e) {
        }



    }

    static void fineafter25days(){

        Library.clear();
        System.out.println("Fine for after 25 Days");
        System.out.println("Fine per : "+ReturnBooksevenafterper);
        System.out.println();
        System.out.println("Enter the fine percentage : ");
        int s=sc.nextInt();
        ReturnBooksevenafterper=s;

        System.out.println("Fine changed");
        System.out.println();
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
            ManageBorrowerFine();
        }   catch (Exception e) {
        }



    }

    static void  fineforlostbook(){
        Library.clear();
        System.out.println("Fine for Loss Book");
        System.out.println("Fine Percentage :"+Lossbookper);
        System.out.println();
        System.out.println("Enter the fine percentage : ");
        int s=sc.nextInt();
        Lossbookper=s;
        System.out.println("Fine changed");
        System.out.println();
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
            ManageBorrowerFine();
         }    catch (Exception e) {
        }



    }

    static void fineforlostmembershipcard(){
        Library.clear();
        System.out.println("Fine for MemeberShip Card Lost");
        System.out.println("Fine Amount :"+MembershipCardloss);
        System.out.println();
        System.out.println("Enter the fine amount : ");
        int s=sc.nextInt();
        MembershipCardloss=s;
        System.out.println("Fine changed");
        System.out.println();
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
             ManageBorrowerFine();
        }   catch (Exception e) {
      }



    }

}

class Borrower{
    private static Scanner sc  = new Scanner(System.in);

    public String BorrowerId;
    public String BorrowerName;
    public String BorrowerEmail;
    public String BorrowerPassword;

    static int Borroweridgen=1;
    static boolean call=false;
    static String CurrentUser=null;
    static int BorrowedCountno=0;
    static int MemberShip=1;

    static ArrayList<Borrower> Borrower=new ArrayList<>();

    Borrower(String bid,String bname,String bemail,String bpwd){
        this.BorrowerId=bid;
        this.BorrowerName=bname;
        this.BorrowerEmail=bemail;
        this.BorrowerPassword=bpwd;
    }
    
 
    static void Login(){
        Library.clear();
        System.out.println("\tBorrower Login");
       // for(int i=0;i<Admin.size();i++){
         //   System.out.println(Admin.get(i).AdminPassword);
        //}
        System.out.println("Enter Email: ");
        String bemail = sc.next();

        System.out.println("Enter Password: ");
        String bpassword = sc.next();

        int d=0;
        for (int i = 0; i < Borrower.size(); i++) {
            if (Borrower.get(i).BorrowerEmail.equals(bemail) && Borrower.get(i).BorrowerPassword.equals(bpassword)) {
                CurrentUser=Borrower.get(i).BorrowerId;
                d=1;
               
                BorrowerFunc();
            }
        }
        if(d==0){
            System.out.println("Invalid Credentials");
            System.out.println();
            System.out.println("Press enter to continue...");
            try {
                System.in.read();
                Library.LibraryMain();
            } catch (Exception e) {
            }
        }
    }

  //BorrowerMain --> Admin
    static void AddBorrower(){
        Library.clear();
        ArrayList<String> acc=new ArrayList<>();
        System.out.println("Add Borrower");
        System.out.println();
        System.out.println("Enter Borrower name:");
        String bname=sc.nextLine();

        System.out.println("Enter Borrower Email:");
        String bemail=sc.nextLine();
    
        String[] arr=bemail.split("@");
        String bpwd=arr[0];

        acc.add(String.valueOf(Borroweridgen));
        acc.add(bname);
        acc.add(bemail);
        acc.add("1500");

        BorrowerBooks.Account.add(acc);

        Borrower.add(new Borrower(String.valueOf(Borroweridgen), bname, bemail, bpwd));
        Borroweridgen++;

        System.out.println("Press enter to continue...");
        try {
            System.in.read();
            Admin.BorrowerMain();
        } catch (Exception e) {
        }

    }


    static void BorrowerFunc(){
        Library.clear();
        System.out.println("Borrowing Functions");
        System.out.println();
        System.out.println("1.Books");
        System.out.println("2.Fines");
        System.out.println("3.MemberShip card");
        System.out.println("4.Account");
        System.out.println("5.Back");
        int choice=sc.nextInt();
        switch(choice){
            case 1:
                BooksFunc();
                break;
            case 2:
                FineMain();
                break;
            case 3:
                MemeberShipcard();
                break;
            case 4:
                Account();
                break;
            case 5:
                Library.LibraryMain();
          
            default:
                System.out.println("Invalid option");
                System.out.println();
                System.out.println("Press enter to continue...");
                try {
                    System.in.read();
                    BorrowerFunc();
                }   catch (Exception e) {
                }
        }
    }

  //BorrowerFunc
    static void BooksFunc(){
        Library.clear();
        System.out.println("Books Functions");
        System.out.println("1.View Books");
        System.out.println("2.Add Books to cart");
        System.out.println("3.Cart");
        System.out.println("4.Borrow Books History");
        System.out.println("5.Return Book");
        System.out.println("6.Extend return Date");
        System.out.println("7.Back");
        int choice=sc.nextInt();
        switch(choice){
            case 1:
                call=true;
                Books.ViewBooks();
                break;
            case 2:
                BorrowerBooks.AddBookstocart();
                break;
            case 3:
                BorrowerBooks.cart();
                break;
            case 4:
                BorrowerBooks.BorrowBooksHistory();
                break;
            case 5:
                BorrowerBooks.ReturnBooks();
                break;
            case 6:
                BorrowerBooks.Extendreturndate();
                break;
            case 7:
                BorrowerFunc();
                break;
            default:
                System.out.println("Invalid option");
                System.out.println();
                System.out.println("Press enter to continue...");
                try {
                     System.in.read();
                    BooksFunc();
                }   catch (Exception e) {
                }
        }

    }
  
  //BorrowerFunc
    static void FineMain(){
        Library.clear();
        System.out.printf("%-8s%-20s%-20s%-20s\n","S.no", "Fine name","Fined on","Amount");
        for(int i=0;i<BorrowerBooks.Fines.size();i++){
            if(BorrowerBooks.Fines.get(i).get(0).equals(CurrentUser)){
                System.out.printf("%-8s%-20s%-20s%-20s",i+1,BorrowerBooks.Fines.get(i).get(1),BorrowerBooks.Fines.get(i).get(2),BorrowerBooks.Fines.get(i).get(3));
            }
        }
        System.out.println();
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
            BorrowerFunc();
         }   catch (Exception e) {
        }

    }

  //BorrowerFunc
    static void MemeberShipcard(){
        Library.clear();
        System.out.println("Do you lost Your MemeberShip card(y/n):");
        String s=sc.next();

        if(s.equals("y")){
            MemberShip=0;
            ArrayList<String> fine=new ArrayList<>();
            fine.add(CurrentUser);
            fine.add("Memebership card Lost");
            int fineamt=Admin.MembershipCardloss;
            fine.add(String.valueOf(fineamt));
            fine.add(Library.CurrentDate);

            BorrowerBooks.Fines.add(fine);

            for(int i=0;i<BorrowerBooks.Account.size();i++){

                if(BorrowerBooks.Account.get(i).get(0).equals(CurrentUser)){
                    String g=BorrowerBooks.Account.get(i).get(3);
                    int k=Integer.parseInt(g);
                    int sum=k-fineamt;
                    BorrowerBooks.Account.get(i).set(3,String.valueOf(sum));
                }

            }
            System.out.println("Press enter to continue...");
            try {
                System.in.read();
                BorrowerFunc();
            }   catch (Exception e) {
            }


        }else if(s.equals("n")){
            System.out.println("Press enter to continue...");
            try {
                System.in.read();
                BorrowerFunc();
            }   catch (Exception e) {
            }

        }else{
            System.out.println();
            System.out.println("Press enter to continue...");
            try {
                System.in.read();
                BorrowerFunc();
            }   catch (Exception e) {
            }
        }


    }

  //BorrowerFunc
    static void Account(){
        Library.clear();
        System.out.println("Welcome ");
        System.out.println();
        for(int i=0;i<BorrowerBooks.Account.size();i++){
            if(BorrowerBooks.Account.get(i).get(0).equals(CurrentUser)){
                System.out.println("Account name: "+BorrowerBooks.Account.get(i).get(1));
                System.out.println("Email :" +BorrowerBooks.Account.get(i).get(2));
                System.out.println("Account Balance :"+BorrowerBooks.Account.get(i).get(3));
            }
        }
        System.out.println();
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
            BorrowerFunc();
        }   catch (Exception e) {
        }

    }
  
}

class Books{
    private static Scanner sc  = new Scanner(System.in);

    static ArrayList<Books> Books=new ArrayList<>();
    static ArrayList<String> Booksort=new ArrayList<>();

    static int Bookidgen=1;

    public String Bookid;
    public String Bookname;
    public String Isbn;
    public int BookCost;
    public  ArrayList<Integer> Bookborrowedcount;
    public  ArrayList<Integer> Quantity;

    Books(String Bkid,String Bkname,String Isbn,int bcost,ArrayList<Integer> bcount,ArrayList<Integer> Q){
        this.Bookid=Bkid;
        this.Bookname=Bkname;
        this.Isbn=Isbn;
        this.BookCost=bcost;
        this.Bookborrowedcount=bcount;
        this.Quantity=Q;
    }
     //BooksMain
    static void AddBooks(){
        Library.clear();
        ArrayList<Integer> quantity = new ArrayList<Integer>();
        ArrayList<Integer> bcount = new ArrayList<Integer>();
        System.out.println("Add Books");
        System.out.println();

        System.out.println("Enter Book name:");
        String bname=sc.next();

        System.out.println("Enter ISBN:");
        String bisbn=sc.next();

        System.out.println("Enter Book Cost:");
        int bcost=sc.nextInt();

        System.out.println("Enter Book Quantity:");
        int bquantity=sc.nextInt();
     
        Books.add(new Books(String.valueOf(Bookidgen),bname,bisbn,bcost,bcount,quantity));
        for(int i=0;i<Books.size();i++){
            if(Books.get(i).Bookname.equals(bname)){
                Books.get(i).Quantity.add(bquantity);
                Books.get(i).Bookborrowedcount.add(0);
            }
        }
        Booksort.add(bname);
        Bookidgen++;
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
            Admin.BooksMain();
        } catch (Exception e) {
        }
    }

     //BooksMain
    static void ModifyBooks(){
        Library.clear();
        System.out.println("Modify Books");
        System.out.println();

        System.out.println("Enter the Book Name to Modify :");
        String bname=sc.next();

        System.out.println("Enter the Quantity to be added :");
        int bquantity=sc.nextInt();
        
        for(int i=0;i<Books.size();i++){
            if(Books.get(i).Bookname.equals(bname)){
                int k=Books.get(i).Quantity.get(0);
                int tot=bquantity+k;
                Books.get(i).Quantity.set(0,tot);
            }
        }

        System.out.println("Modified");
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
            Admin.BooksMain();
        } catch (Exception e) {
        }

    }

     //BooksMain
    static void DeleteBooks(){
        Library.clear();
        System.out.println("Delete Books");
        System.out.println();

        System.out.println("Enter the Book Name to Delete :");
        String bname=sc.next();
        String g=null;
        for(int i=0;i<Books.size();i++){
            if(Books.get(i).Bookname.equals(bname) || Books.get(i).Isbn.equals(bname)){
                g=Books.get(i).Bookname;
                Books.remove(i);
            }
        }

        for(int i=0;i<Booksort.size();i++){
            if(Booksort.get(i).equals(g) ){
                Booksort.remove(i);
            }
        }
        System.out.println("Deleted");
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
            Admin.BooksMain();
        } catch (Exception e) {
        }
    }

     //BooksMain and BooksFunc
    static void ViewBooks(){
        Library.clear();
        Collections.sort(Booksort);
        System.out.printf("%-8s%-20s%-20s%-20s%-13s\n","S.no", "Book Id", "Book Name", "ISBN", "Qunatity");
        for(int j=0;j<Booksort.size();j++){
            for(int i=0;i<Books.size();i++){
                if(Books.get(i).Bookname.equals(Booksort.get(j))){
            
                    System.out.printf("%-8s%-20s%-20s%-20s%-13s\n",j+1,Books.get(i).Bookid,Books.get(i).Bookname,Books.get(i).Isbn,Books.get(i).Quantity.get(0));
                }
            }
        }

        System.out.println("Press enter to continue...");
        if(Borrower.call){
            try {
                System.in.read();
                Borrower.BooksFunc();
            } catch (Exception e) {}
        }else{
           
            try {
                System.in.read();
                Admin.BooksMain();
            } catch (Exception e) {

            }
        }
    }


     //BooksMain
    static void SearchBooks(){
        Library.clear();
        System.out.println("Enter Book name or ISBN :");
        String b=sc.next();
        System.out.printf("%-8s%-20s%-10s%-10s%-10s%-15s%-15s%-15s%-15s%-15s\n", "S.no","Borrower id" ,"Book Id", "Book Name", "ISBN","BorrowedDate","return Date","return within","status","Extend-Times");
        for(int i=0;i<BorrowerBooks.BorrowedBooks.size();i++){
            if(BorrowerBooks.BorrowedBooks.get(i).get(1).equals(b) || BorrowerBooks.BorrowedBooks.get(i).get(2).equals(b)){
                System.out.printf("%-8s%-20s%-10s%-10s%-10s%-15s%-15s%-15s%-15s%-15s\n",i+1,BorrowerBooks.BorrowedBooks.get(i).get(0),BorrowerBooks.BorrowedBooks.get(i).get(1),BorrowerBooks.BorrowedBooks.get(i).get(2),BorrowerBooks.BorrowedBooks.get(i).get(3),BorrowerBooks.BorrowedBooks.get(i).get(4),BorrowerBooks.BorrowedBooks.get(i).get(5),BorrowerBooks.BorrowedBooks.get(i).get(6),BorrowerBooks.BorrowedBooks.get(i).get(7),BorrowerBooks.BorrowedBooks.get(i).get(8));
  
            }
        }
        System.out.println();
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
            Admin.BooksMain();
        } catch (Exception e) {}
        

    }

    //BooksMain
    static void Booksreport(){
        Library.clear();
        System.out.println("1.Less Quantity Books");
        System.out.println("2.Not Borrowed");
        System.out.println("3.Heavily Borrowed");
        System.out.println("4.Not Returned after return date");
        System.out.println("5.Back");
        int ch=sc.nextInt();
        if(ch==1){
            LessQuantity();

        }else if(ch==2){
            NotBorrowed();
        }else if(ch==3){
            HeavilyBorrowed();
        }
        else if(ch==4){
            NotReturned();
        }else if(ch==5){
            Admin.BooksMain();
        }
        else{
            System.out.println("Invalid option");
            System.out.println();
            System.out.println("Press enter to continue...");
            try {
                System.in.read();
                Booksreport();
            } catch (Exception e) {}
            }
    }

     //Booksreport
    static void LessQuantity(){
        Library.clear();
        System.out.printf("%-8s%-20s%-20s%-20s%-20s\n","S.no","Book id","Book name","ISBN","Quantity");
        for(int i=0;i<Books.size();i++){
            if(Books.get(i).Quantity.get(0)==0){

              System.out.printf("%-8s%-20s%-20s%-20s%-20s\n",i+1,Books.get(i).Bookid,Books.get(i).Bookname,Books.get(i).Isbn,Books.get(i).Quantity.get(0));

            }

        }
        System.out.println();
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
            Booksreport();
        } catch (Exception e) {}
            

    }

     //Booksreport
    static void NotBorrowed(){
        Library.clear();
        System.out.printf("%-8s%-20s%-20s%-20s%-20s%-20s\n","S.no","Book id","Book name","ISBN","Quantity","Borrowed");
        for(int i=0;i<Books.size();i++){
            if(Books.get(i).Bookborrowedcount.get(0)==0){

                System.out.printf("%-8s%-20s%-20s%-20s%-20s%-20s\n",i+1,Books.get(i).Bookid,Books.get(i).Bookname,Books.get(i).Isbn,Books.get(i).Quantity.get(0),Books.get(i).Bookborrowedcount.get(0));

            }

        }
        System.out.println();
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
            Booksreport();
        } catch (Exception e) {}
            

    }

     //Booksreport
    static void HeavilyBorrowed(){
        Library.clear();
        System.out.printf("%-8s%-20s%-20s%-20s%-20s%-20s\n","S.no","Book id","Book name","ISBN","Quantity","Borrowed");
        int max=0;
        for(int i=0;i<Books.size();i++){
            if(Books.get(i).Bookborrowedcount.get(0)>max){
                max=Books.get(i).Bookborrowedcount.get(0);
              //System.out.printf("%-8s%-20s%-20s%-20s%-20s%-20s\n",i+1,Books.get(i).Bookid,Books.get(i).Bookname,Books.get(i).Isbn,Books.get(i).Quantity.get(0),Books.get(i).Bookborrowedcount.get(0));

            }

        }

        if(max != 0){
            for(int i=0;i<Books.size();i++){
                if(Books.get(i).Bookborrowedcount.get(0)==max ){
                //max=Books.get(i).Bookborrowedcount.get(0);
                    System.out.printf("%-8s%-20s%-20s%-20s%-20s%-20s\n",i+1,Books.get(i).Bookid,Books.get(i).Bookname,Books.get(i).Isbn,Books.get(i).Quantity.get(0),Books.get(i).Bookborrowedcount.get(0));

                }

            }
        }else{
            System.out.println("Books Not Borrowed So far !");
        }
        System.out.println();
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
            Booksreport();
        } catch (Exception e) {}
            

    }

     //Booksreport
    static void NotReturned(){
        Library.clear();
        System.out.printf("%-8s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s\n", "S.no","Borrower id","Book Id", "Book Name", "ISBN","BorrowedDate","return Date","return within","status","Extend-Times");

        for(int i=0;i<BorrowerBooks.BorrowedBooks.size();i++){
            if(BorrowerBooks.BorrowedBooks.get(i).get(5).compareTo(Library.CurrentDate)<0 && BorrowerBooks.BorrowedBooks.get(i).get(7).equals("Not Returned")  ){
                System.out.printf("%-8s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s\n",i+1,BorrowerBooks.BorrowedBooks.get(i).get(0),BorrowerBooks.BorrowedBooks.get(i).get(1),BorrowerBooks.BorrowedBooks.get(i).get(2),BorrowerBooks.BorrowedBooks.get(i).get(3),BorrowerBooks.BorrowedBooks.get(i).get(4),BorrowerBooks.BorrowedBooks.get(i).get(5),BorrowerBooks.BorrowedBooks.get(i).get(6),BorrowerBooks.BorrowedBooks.get(i).get(7),BorrowerBooks.BorrowedBooks.get(i).get(8));

            }
        }
         
        System.out.println();
            System.out.println("Press enter to continue...");
            try {
                System.in.read();
                Booksreport();
            } catch (Exception e) {}
            
    }
}

class currentdate{
    private static Scanner sc  = new Scanner(System.in);
    static String DateChanger(String d, int c){
        return LocalDate.parse(d).plusDays(c).toString();
    }
    static void ChangeCurrentDate(){
        Library.clear();
        System.out.println("Enter the No of Days to be added from today");
        int chg=sc.nextInt();
        
        Library.CurrentDate = DateChanger(Library.CurrentDate, chg); //changing the current date by changeDate function => current date, no.of days to add
        System.out.println();
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
            Library.LibraryMain();
        } catch (Exception e) {
        }


    }

    static int Daysbetween(String d1,String d2){
        int daysBetween = 0;

        while(!d1.equals(d2)){
            daysBetween++;
            d1 = DateChanger(d1, 1);
        }
        
        return(daysBetween);
    }
    
}

class BorrowerBooks{
    private static Scanner sc  = new Scanner(System.in);
    
    static ArrayList<ArrayList<String>> Cart=new ArrayList<>();
    static ArrayList<ArrayList<String>> BorrowedBooks=new ArrayList<>();
    static ArrayList<ArrayList<String>> Account=new ArrayList<>();
    static ArrayList<ArrayList<String>> Fines=new ArrayList<>();
    static ArrayList<ArrayList<String>> BooksBorrowedcount=new ArrayList<>();

     //BooksFunc --> Borrower
    static void AddBookstocart(){
        Library.clear();
    
        ArrayList<String> books=new ArrayList<>();
        System.out.printf("%-15s%-20s%-20s%-13s\n", "Book Id", "Book Name", "ISBN", "Qunatity");
      
        for(int i=0;i<Books.Books.size();i++){
            System.out.printf("%-15s%-20s%-20s%-13s\n",Books.Books.get(i).Bookid,Books.Books.get(i).Bookname,Books.Books.get(i).Isbn,Books.Books.get(i).Quantity.get(0));

        }
        
        System.out.println("Enter the Book name or isbn :");
        String bname=sc.nextLine();
        int check=0;
        for(int i=0;i<Cart.size();i++){
           if(Cart.get(i).get(2).equals(bname) || Cart.get(i).get(1).equals(bname) ){
               check=1;
           }
       }
        if(check==0){
            for(int i=0;i<Books.Books.size();i++){
                if(Books.Books.get(i).Bookname.equals(bname) || Books.Books.get(i).Bookid.equals(bname) ){
                   
                    books.add(Borrower.CurrentUser);
                    books.add(Books.Books.get(i).Bookid);
                    books.add(Books.Books.get(i).Bookname);
                    books.add(Books.Books.get(i).Isbn);
               
                    String returndate=currentdate.DateChanger(Library.CurrentDate, 15);
                    books.add(returndate);
                    Cart.add(books);
                
                    System.out.println("Added");
                }
            }
        }else{
            System.out.println("Books already in Cart");
        }
            
        System.out.println();
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
            Borrower.BooksFunc();
        } catch (Exception e) {
        }

    }
        


    
    //BooksFunc --> Borrower
    static void cart(){
        Library.clear();
        System.out.println("Cart Functions");
        System.out.println("1.View Cart");
        System.out.println("2.Borrow Books");
        System.out.println("3.Remove Books from Cart");
        System.out.println("4.Back");
        int choice=sc.nextInt();
        switch(choice){
            case 1:
                viewCart();
                break;
            case 2:
                BorrowBooksfromcart();
                break;
            case 3:
                RemoveBooksfromcart();
                break;
            case 4:
                Borrower.BooksFunc();
            default:
                System.out.println("Invalid option");
                System.out.println();
                System.out.println("Press enter to continue...");
                try {
                    System.in.read();
                    cart();
                }   catch (Exception e) {
                }
        }


    }

    //cart
    static void viewCart(){
        Library.clear();
        int d=0;
        System.out.printf("%-8s%-20s%-20s%-20s%-20s\n", "S.no", "Book Id", "Book Name", "ISBN","Book_returned");
        for(int i=0;i<Cart.size();i++){
            if(Cart.get(i).get(0).equals(Borrower.CurrentUser)){
            System.out.printf("%-8s%-20s%-20s%-20s%-20s\n",i+1,Cart.get(i).get(1),Cart.get(i).get(2),Cart.get(i).get(3),Cart.get(i).get(4));
             d+=1;
            }
        }
        System.out.println("Viewd");

        if(d>=0){
        System.out.println();
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
            cart();
        } catch (Exception e) {
        }
    }

    }
    //cart
    static void BorrowBooksfromcart(){
        Library.clear();
        System.out.println("Enter the Book name:");
        sc.nextLine();
        String bname=sc.nextLine();
        int con1=0;
        int con2=0;
        int con3=0;
        int con4=0;
         
        if(Borrower.BorrowedCountno<=3){
            con1=1;
            
        }

        for(int i=0;i<Account.size();i++){
            if(Account.get(i).get(0).equals(Borrower.CurrentUser)){
                String g=Account.get(i).get(3);
                int k=Integer.parseInt(g);
                if(k>=500){
                    con2=1;

                }
            }
        }
        if(BorrowedBooks.size()>0){
            for(int i=0;i<BorrowedBooks.size();i++){
                if(BorrowedBooks.get(i).get(0).equals(Borrower.CurrentUser)){
                    if(BorrowedBooks.get(i).get(2).equals(bname)){
                        System.out.println("true");
                        con3=0;
                    }else{
                        System.out.println("true");
                        con3=1;
                    }
                } else{
                    con3=1;
                }
            }
        } else{
           con3=1;
        }
        if(Borrower.MemberShip==1){
            con4=1;
         
        }


        if(con1==1 && con2==1 && con3==1 && con4==1){
            int f=0;
            String bookid=null;
            for(int i=0;i<Cart.size();i++){
                if(Cart.get(i).get(2).equals(bname)){
                    f=1;
                    bookid=Cart.get(i).get(1);

                }
            }

            if(f==1){
                for(int i=0;i<Books.Books.size();i++){
                    if(Books.Books.get(i).Bookid.equals(bookid)){
                        if(Books.Books.get(i).Quantity.get(0)>0){
                        
                            BorrowBooks(bookid);
                        }else{
                            System.out.println("Books currently not Available");
                        }
                    }
                }
            }else{
                System.out.println("Books Not in cart");
           
            }
        }else{
            if(con1==0){
               System.out.println("You cannot Borrow More than 3 Books at time");
               System.out.println();
            }
            if(con2==0){
                System.out.println("Your Account Balance is Less than minimum of 500");
                System.out.println();
            }
            if(con3==0){
                System.out.println("You cannot borrow same book");
               System.out.println();
            }if(con4==0){
                System.out.println("you cannot borrow books due to lost of Membership card");
                System.out.println();
            }
           
        }

        System.out.println();
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
            cart();
        } catch (Exception e) {
        }
        

    }

    //BorrowBooksfromcart
    static void BorrowBooks(String bid){
        Library.clear();
        System.out.println("Enter the Return date yyyy-MM-dd :");
        String rdate=sc.nextLine();
        int f=0;
        if(currentdate.Daysbetween(Library.CurrentDate, rdate)<=15){
            f=1;
        }
        
        if(f==1){
            ArrayList<String> arr=new ArrayList<>();
            String exdate=null;
            arr.add(Borrower.CurrentUser);
            for(int i=0;i<Cart.size();i++){
                if(Cart.get(i).get(1).equals(bid)){
                    arr.add(Cart.get(i).get(1));
                    arr.add(Cart.get(i).get(2));
                    arr.add(Cart.get(i).get(3));
                    exdate=Cart.get(i).get(4);
                }
            }
            arr.add(Library.CurrentDate);
            arr.add(rdate);
            arr.add(exdate);
            arr.add("Not Returned");
            arr.add("0");

            for(int i=0;i<Books.Books.size();i++){
                if(Books.Books.get(i).Bookid.equals(bid)){
                    int g=Books.Books.get(i).Quantity.get(0);
                    int h=g-1;
                    Books.Books.get(i).Quantity.set(0,h);
                    int c=Books.Books.get(i).Bookborrowedcount.get(0);
                    Books.Books.get(i).Bookborrowedcount.set(0,c+1);
                }
            }
            for(int i=0;i<Cart.size();i++){
                if(Cart.get(i).get(1).equals(bid)){
                    Cart.remove(i);
                }
            }

            BorrowedBooks.add(arr);
    
            System.out.println("Books borrowed");
            System.out.println();
            System.out.println("Press enter to continue...");
            try {
                System.in.read();
                cart();
            } catch (Exception e) {
            }

        }else{
            System.out.println("Enter the date within 15 days");
            System.out.println();
            System.out.println("Press enter to continue...");
            try {
                System.in.read();
                BorrowBooksfromcart();
            } catch (Exception e) {
            }
        }
  
    }
    //cart
    static void RemoveBooksfromcart(){
        Library.clear();
        System.out.println("Enter Book name  :");
        String s=sc.next();

        for(int i=0;i<Cart.size();i++){
            if(Cart.get(i).get(0).equals(Borrower.CurrentUser) && Cart.get(i).get(2).equals(s)){
                   Cart.remove(i);
            }
        }

        System.out.println();
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
            cart();
        } catch (Exception e) {
        }



    }
    //BooksFunc
    static void BorrowBooksHistory(){   
        Library.clear();
        System.out.printf("%-8s%-10s%-20s%-20s%-20s%-20s%-20s%-10s%-20s\n", "S.no", "Book Id", "Book Name", "ISBN","BorrowedDate","return Date","return within","status","Extend-Times");
        for(int i=0;i<BorrowedBooks.size();i++){
            if(BorrowedBooks.get(i).get(0).equals(Borrower.CurrentUser)){
                System.out.printf("%-8s%-10s%-20s%-20s%-20s%-20s%-20s%-10s%-20s\n",i+1,BorrowedBooks.get(i).get(1),BorrowedBooks.get(i).get(2),BorrowedBooks.get(i).get(3),BorrowedBooks.get(i).get(4),BorrowedBooks.get(i).get(5),BorrowedBooks.get(i).get(6),BorrowedBooks.get(i).get(7),BorrowedBooks.get(i).get(8));
            }
        }
        System.out.println();
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
            Borrower.BooksFunc();
        }   catch (Exception e) {
         }
    }   
    //BooksFunc
    static void ReturnBooks(){
        Library.clear();
        System.out.println("1.Return Book");
        System.out.println("2.Book Lost");
        System.out.println("3.Back");
        int ch=sc.nextInt();
        if(ch==1){
            ReturnBookmain();
            
        }else if(ch==2){
            BookLost();
           
        }
        else if(ch==3){
            Borrower.BooksFunc();

        }else{
            System.out.println();
            System.out.println("Invalid option");
            
            System.out.println("Press enter to continue...");
            try {
                System.in.read();
                ReturnBooks();
            } catch (Exception e) {
            }

        }
        

    }

    // ReturnBooks
    static void ReturnBookmain(){
        Library.clear();
        System.out.println("Enter the Book Name:");
        String bname=sc.next();
         
        String exdate=null;
        for(int i=0;i<BorrowedBooks.size();i++){
            if(BorrowedBooks.get(i).get(0).equals(Borrower.CurrentUser) && BorrowedBooks.get(i).get(2).equals(bname)){
                exdate=BorrowedBooks.get(i).get(6);
                BorrowedBooks.get(i).set(7,Library.CurrentDate);
            }

        }
         
        for(int i=0;i<Books.Books.size();i++){
            if(Books.Books.get(i).Bookname.equals(bname)){
                int g=Books.Books.get(i).Quantity.get(0);
                int h=g+1;
                Books.Books.get(i).Quantity.set(0,h);
               
            }
        }
         
        if((Library.CurrentDate).compareTo(exdate)<=0){
            System.out.println("Returned book on time");

        }else if((Library.CurrentDate).compareTo(exdate)>0){
            fineforBook(bname,exdate);

        }
        System.out.println();
       
         
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
            ReturnBooks();
        } catch (Exception e) {
        }

    }

    // ReturnBookmain  
    static void fineforBook(String bname,String exdate){
        int d=currentdate.Daysbetween(exdate, Library.CurrentDate);
        System.out.println(exdate); 
        if(d<=10){
            fineforeachday(bname,d);
        }else if(d>=10){
           fineformorethan(bname,d);
        }
        System.out.println("Returned book atfter return date");
        System.out.println();
       
         
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
            ReturnBooks();
        } catch (Exception e) {
        }

    }
    // ReturnBookmain 
    static void fineforeachday(String bname,int d){
        ArrayList<String> fine=new ArrayList<>();
        fine.add(Borrower.CurrentUser);
        fine.add("Return Books Late");
        int tot=d*Admin.fineforeachday;
        fine.add(String.valueOf(tot));
        fine.add(Library.CurrentDate);
        Fines.add(fine);

        for(int i=0;i<Account.size();i++){

            if(Account.get(i).get(0).equals(Borrower.CurrentUser)){
                String g=Account.get(i).get(3);
                int k=Integer.parseInt(g);
                int sum=k-tot;
                Account.get(i).set(3,String.valueOf(sum));
            }
        }
    }
   // ReturnBookmain 
    static void fineformorethan(String bname,int d){
        ArrayList<String> fine=new ArrayList<>();
        fine.add(Borrower.CurrentUser);
        fine.add("Return Books Late");
        int t=0;
        for(int i=0;i<Books.Books.size();i++){
            if(Books.Books.get(i).Bookname.equals(bname)){
                t=Books.Books.get(i).BookCost;
            }
        }
        int tot=t*Admin.ReturnBooksevenafterper/100;
        fine.add(String.valueOf(tot));
        fine.add(Library.CurrentDate);
        Fines.add(fine);

        for(int i=0;i<Account.size();i++){
            if(Account.get(i).get(0).equals(Borrower.CurrentUser)){
                String g=Account.get(i).get(3);
                int k=Integer.parseInt(g);
                int sum=k-tot;
                Account.get(i).set(3,String.valueOf(sum));
            }
        }
    }

    // ReturnBooks
    static void BookLost(){
        Library.clear();
        System.out.println("Enter the Book name");
        String bname=sc.next();

        ArrayList<String> fine=new ArrayList<>();
        fine.add(Borrower.CurrentUser);
        fine.add("Book Lost");
        int t=0;
        for(int i=0;i<Books.Books.size();i++){
            if(Books.Books.get(i).Bookname.equals(bname)){
                t=Books.Books.get(i).BookCost;
            }
        }
        int tot=t*Admin.Lossbookper/100;
        fine.add(String.valueOf(tot));
        fine.add(Library.CurrentDate);
        Fines.add(fine);


        for(int i=0;i<BorrowedBooks.size();i++){
            if(BorrowedBooks.get(i).get(0).equals(Borrower.CurrentUser) && BorrowedBooks.get(i).get(2).equals(bname)){
                BorrowedBooks.get(i).set(7,"Book Lost");
            }

        }

        
        for(int i=0;i<Account.size();i++){
            if(Account.get(i).get(0).equals(Borrower.CurrentUser)){
                
                String g=Account.get(i).get(3);
                int k=Integer.valueOf(g);
                int sum=k-tot;
                Account.get(i).set(3,String.valueOf(sum));
            }
        }

        System.out.println();
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
            ReturnBooks();
        } catch (Exception e) {
        }


    }
    //BooksFunc
    static void Extendreturndate(){
        Library.clear();

        System.out.println("Enter the Book name:");
        String bname=sc.next();

        System.out.println("Enter the date:");
        String s=sc.next();
        
        int f=0;
        if(currentdate.Daysbetween(Library.CurrentDate, s)<=15){
            f=1;
        }

        String returndate=currentdate.DateChanger(Library.CurrentDate, 15);

        if(f==1){
            String g=null;
            for(int i=0;i<BorrowedBooks.size();i++){
                if(BorrowedBooks.get(i).get(0).equals(Borrower.CurrentUser) && BorrowedBooks.get(i).get(2).equals(bname)){
                    // BorrowedBooks.get(i).set(5,s);
                    // BorrowedBooks.get(i).set(6,returndate);
                    g=BorrowedBooks.get(i).get(8);
                }
            }

            if(Integer.valueOf(g)<2){
                for(int i=0;i<BorrowedBooks.size();i++){
                    if(BorrowedBooks.get(i).get(0).equals(Borrower.CurrentUser) && BorrowedBooks.get(i).get(2).equals(bname)){
                        BorrowedBooks.get(i).set(5,s);
                        BorrowedBooks.get(i).set(6,returndate);
                        int k=Integer.valueOf(g);
                        int h=k+1;
                        String extend=String.valueOf(h);
                        BorrowedBooks.get(i).set(8,extend);
                    }
                }
            
    
            }else{
                System.out.println("You cannot extend return date");
           
    
            }
        }else{
            System.out.println("Enter date within 15days");
        }

        System.out.println();
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
            Borrower.BooksFunc();
        } catch (Exception e) {
        }





    }


}