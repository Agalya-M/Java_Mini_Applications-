
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

//classes={splitwise,user,Groups,GroupExpenses,AddGroupExpensestomem,Contacts,addExpenses,NongroupExpenses,current Date}

//splitwise=[{main}]
//user=[{Login,Register,UserMain,Wallet}]
//Groups=[{creategroup,view groups,add group mem,remove group member}]
//GroupExpenses=[{addgroupexpenses}]
//AddGroupExpensestomem=[{addexpenses,pending dues,view Transcation history}]
//Contacts=[{user Contacts,add friends}]
//NongroupExpenses=[{addexpenses,view expenses,pendingdues,Transaction history}]
//addexpenses=[{addexpensestoFriends}]
//currentdate=[{change current date}}]

class splitwise{
    private static Scanner sc;

    public static String CurrentDate;

    public static String Currenttime;


    static void clear(){
        System.out.println("\033[H\033[2J");

    }
    

    static void splitwiseMain(){
        clear();
        System.out.println(CurrentDate);
        System.out.println(Currenttime);
        System.out.println();
        System.out.println("Split wise");
        System.out.println();
        System.out.println("1.User Login");
        System.out.println("2.Change Date");
        System.out.println("3.Exit");
        int ch=sc.nextInt();
        switch(ch){
            case 1:
              user.userlogin();
              break;
            case 2:
              currentdate.changedate();
              break;
            case 3:
               System.exit(0);

            default:
            System.out.println("Invalid Option");
            System.out.println();
            System.out.println("Press enter to continue...");
            try {
                System.in.read();
                splitwiseMain();
            } catch (Exception e) {}

        }


       
    }
    public static void main(String[] args) {
        sc=new Scanner(System.in);
       
        //Date
        Date date = new Date(); // creating date => Fri jan 1 ...

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // format date => "yyyy-MM-dd"

        CurrentDate = String.valueOf(formatter.format(date)); // changing the date format => "yyyy-MM-dd"
        
        //Time
        Date time=new Date();

        SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");

        Currenttime=String.valueOf(format.format(time));

        //Default user
        user.user.add(new user("A","1","A",2000));
        user.user.add(new user("B","2","B",2000));
        user.user.add(new user("C","3","C",2000));

        
        
       

        

        //main
        splitwiseMain();

    }

}

class user{
    private static Scanner sc=new Scanner(System.in);
    
    public String username;
    public String userid;
    public String password;
    public int Balance;

    static int usergen=4;
    static String currentuser=null;
    static String currentusername=null;

    static ArrayList<user> user= new ArrayList<>();

    
    user(String uname,String uid,String upassword,int balance){
        this.username=uname;
        this.userid=uid;
        this.password=upassword;
        this.Balance=balance;

    }
    static void userlogin(){

        splitwise.clear();
        System.out.println("User Login");
        System.out.println();
        System.out.println("1. New User Registration");
        System.out.println("2. Existing User Login");
        System.out.println("3. Back");
        System.out.println();
        System.out.println( "Enter your Choice : ");
        int ch = sc.nextInt();
        if (ch == 1) {
            Registeruser();
        } else if (ch == 2) {
            Login();
        } else if (ch == 3) {
            splitwise.splitwiseMain();
        } else {
            System.out.println("Invalid Options");
            System.out.println();
            System.out.println("Press enter to continue");
            try {
                System.in.read();
                userlogin();;
            } catch (Exception e) {
            }
        }
    }


    static void Registeruser(){
        splitwise.clear();
        System.out.println("Registeration");
        System.out.println();
        System.out.println("Enter your username");
        sc.nextLine();
        String uname = sc.nextLine();

        System.out.println("Enter your password");
        String upassword = sc.next();

        String uId = String.valueOf(usergen);
        usergen++;

   
        user.add(new user(uname, uId, upassword,2000));


        System.out.println();
        System.out.println("Press enter to continue");
        try {
            System.in.read();
            userlogin();
        } catch (Exception e) {
        }

    }

    static void Login(){
        splitwise.clear();
        System.out.println("Login");
        System.out.println();
        System.out.println("Enter your Username :");
        String uname = sc.next();

        System.out.println("Enter your password :");
        String upassword = sc.next();

        for (int i = 0; i < user.size(); i++) {
            if (user.get(i).username.equals(uname) && user.get(i).password.equals(upassword)) {
                currentuser = user.get(i).userid;
                currentusername=user.get(i).username;
                UserMain();
            }
        }

        System.out.println("Invalid Credentials");
        System.out.println();
        System.out.println("Press enter to continue");
        try {
            System.in.read();
            splitwise.splitwiseMain();
        } catch (Exception e) {
        }
    }   
    
    
    static void UserMain(){
        splitwise.clear();
        System.out.println("User Main");
        System.out.println();
        System.out.println("1.Group");
        System.out.println("2.Contacts");
        System.out.println("3.Non group");
        System.out.println("4.Wallet");
        System.out.println("5.Logout");
        System.out.println("6.Back");
        System.out.println();
        int choice=sc.nextInt();
        if(choice==1){
            Groups.groupMain();
            
        }else if(choice==2){
            Contacts.contactMain();
        }else if(choice==3){
            NongroupExpenses.nongroupMain();
        }else if(choice==4){
            viewwallet();
        }else if(choice==5){
            userlogin();
        }else if(choice==6){
            splitwise.splitwiseMain();
        }
        else{
            System.out.println("Invalid option");
            System.out.println();
            System.out.println("Press enter to continue...");
            try {
                System.in.read();
                UserMain();
            }   catch (Exception e) {
            }
        }

    }

    static void viewwallet(){
        splitwise.clear();
        System.out.println("1.View Wallet");
        System.out.println("2.Add amount to Wallet");
        System.out.println("3.Back");
        int choice=sc.nextInt();

        if(choice==1){
            viewwallets();
        }else if(choice==2){
            addamount();
        }else if(choice==3){
            UserMain();
        }else{
            System.out.println("Invalid option");
            System.out.println();
            System.out.println("Press enter to continue...");
            try {
                System.in.read();
                viewwallet();
            }   catch (Exception e) {
            }
        }
        
        

    }
    static void viewwallets(){
        splitwise.clear();
        System.out.println("Wallet");
        for(int i=0;i<user.size();i++){
            if(user.get(i).userid.equals(currentuser)){
                System.out.println("Balance :"+user.get(i).Balance);
            }
        }

        System.out.println();
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
            viewwallet();
        }   catch (Exception e) {
        }
    }

    static void addamount(){
        splitwise.clear();
        System.out.println("Wallet");
        System.out.println("Enter the amount want to add to wallet :");
        int amt=sc.nextInt();
        for(int i=0;i<user.size();i++){
            if(user.get(i).userid.equals(currentuser)){
               user.get(i).Balance=user.get(i).Balance+amt;
            }
        }

        
        System.out.println();
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
            viewwallet();
        }   catch (Exception e) {
        }
        
    }

    
        
}


class currentdate{

    private static Scanner sc  = new Scanner(System.in);
    static String DateChanger(String d, int c){
        return LocalDate.parse(d).plusDays(c).toString();
    }
    static void changedate(){
        splitwise.clear();
        System.out.println("Enter the No of Days to be added from today :");
        int chg=sc.nextInt();
        
        
        splitwise.CurrentDate = DateChanger(splitwise.CurrentDate, chg); //changing the current date by changeDate function => current date, no.of days to add
        System.out.println();
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
            splitwise.splitwiseMain();
        } catch (Exception e) {
        }
    }
}

class Groups{
    private static Scanner sc  = new Scanner(System.in);
    
    static int groupgen=1;
    static ArrayList<Groups> Groups=new ArrayList<>();
    static String currentgroupid=null;
   

    public String groupId;
    public String groupName;
    public ArrayList<String> groupusersid;
    public ArrayList<String> groupusersname;

    Groups(String gid,String gname,ArrayList<String> gusersid, ArrayList<String> gusersname){
        this.groupId=gid;
        this.groupName=gname;
        this.groupusersid=gusersid;
        this.groupusersname=gusersname;
    }

    static void groupMain(){
        splitwise.clear();
        System.out.println("1.View Groups");
        System.out.println("2.Create a new Group");
        System.out.println("3.Groups");
        System.out.println("4.Back");
        System.out.println("5.Main");
        System.out.println();
        int choice=sc.nextInt();

        if(choice==1){
            ViewGroups();
        }
        else if(choice==2){
            CreateGroups();
        }else if(choice==3){
            groups();
        }
        else if(choice==4){
            user.UserMain();
        }else if(choice==5){
            splitwise.splitwiseMain();
        }else{
            System.out.println("Invalid option");
            System.out.println();
            System.out.println("Press enter to continue...");
            try {
                System.in.read();
                groupMain();
            }   catch (Exception e) {
            }

        }

    }

    static void ViewGroups(){
        splitwise.clear();
        System.out.println("Groups");
        int c=0;
        System.out.printf("%-8s%-20s%-20s\n","S.no","Group id","Group name");
        for(int i=0;i<Groups.size();i++){
            System.out.printf("%-8s%-20s%-20s\n",i+1,Groups.get(i).groupId,Groups.get(i).groupName);
            c+=1;
        }
        if(c>0){
            System.out.println();
            System.out.println("Do you want to enter into the group (Y/N) :");
            String s=sc.next();
            if(s.equals("Y")){
                groups();
            }
        }else{
            System.out.println("No Groups Created");
        }
       
        System.out.println("Press enter to continue");
        try {
            System.in.read();
           groupMain();
        } catch (Exception e) {}




    }

    static void CreateGroups(){
        splitwise.clear();
        ArrayList<String> userid=new ArrayList<>();
        ArrayList<String> username=new ArrayList<>();

        System.out.println("Enter the Group Name ");
        String gname=sc.next();
        splitwise.clear();
        int c=0;
        System.out.println("Your Contacts");
        System.out.printf("%-8s%-20s%-20s\n","S.No","Friend id","Friend Name");
        for(int i=0;i<Contacts.contacts.size();i++){
            System.out.printf("%-8s%-20s%-20s\n",i+1,Contacts.contacts.get(i).friendid,Contacts.contacts.get(i).friendname);
            c+=1;
        }
        if(c>0){
            System.out.println();
            for(int i=0;i<user.user.size();i++){
                if(user.user.get(i).userid.equals(user.currentuser)){
                    userid.add(user.user.get(i).userid);
                    username.add(user.user.get(i).username);
                }
            }

            System.out.println("Enter the no of friends you need to add:");
            int count=sc.nextInt();
            System.out.println();

            for(int i=0;i<count;i++){
                System.out.println("Enter the Friend Id for Friend "+(i+1)+" :");
                String fid=sc.next();
                userid.add(fid);
                for(int j=0;j<Contacts.contacts.size();j++){
                    if(Contacts.contacts.get(j).friendid.equals(fid)){
                        username.add(Contacts.contacts.get(j).friendname);
                    
                    }
                    continue;
                }
            
                System.out.println();


            }

        Groups.add(new Groups(String.valueOf(groupgen), gname, userid,username));
        System.out.println("Group created succesfully");
       

    }else{
        System.out.println("No Friends in Your Contact");
    }
        System.out.println();
        System.out.println("Press enter to continue");
        try {
            System.in.read();
           groupMain();
        } catch (Exception e) {}


    }

    static void groups(){
        
        System.out.println("Enter the Group name:");
        String gname=sc.next();
        boolean isgrouppresent =false;
        for(int i=0;i<Groups.size();i++){
            if(Groups.get(i).groupName.equals(gname)){
                currentgroupid=Groups.get(i).groupId;
                isgrouppresent=true;
            }
        }
       if(isgrouppresent){
           Groupsub(gname);
            
        }else{
            System.out.println("Invalid Group name");
            System.out.println();
            System.out.println("Press enter to continue...");
            try {
                System.in.read();
                groupMain();
            }   catch (Exception e) {
            }

        }
    }
    static void Groupsub(String gname){
        splitwise.clear();

        System.out.println("Welcome to the "+gname+" ");
        System.out.println();
        System.out.println("1.Group members");
        System.out.println("2.Group Expenses");
        System.out.println("3.Pending dues");
        System.out.println("4.Transactions");
        System.out.println("5.Back");
        System.out.println("6.Main");
        int choice=sc.nextInt();
        if(choice==1){
            Groupmemmain(gname);
        }else if(choice==2){
            groupExpensesMain(gname);
        }else if(choice==3){
            AddgroupExpensestomem.PendingDues(gname);
        }else if(choice==4){
            AddgroupExpensestomem.groupTransactions(gname);

        }else if(choice==5){
            user.UserMain();
        }else if(choice==6){
            splitwise.splitwiseMain();
        }else{
            System.out.println("Invalid option");
            System.out.println();
            System.out.println("Press enter to continue...");
            try {
                System.in.read();
                Groupsub(gname);
            }   catch (Exception e) {
            }
        }
    }


    static void Groupmemmain(String gname){
        splitwise.clear();
        System.out.println(gname);
        System.out.println();
        System.out.println("1.View Group Members");
        System.out.println("2.Add Group Members");
        System.out.println("3.Remove Group Members");
        System.out.println("4.Back");
        System.out.println("5.User main");
        System.out.println("6.Main");
        int choice =sc.nextInt();

        if(choice==1){
           viewgroupmem(gname);

        }else if(choice==2){
           Addgroupmem(gname);
        }else if(choice==3){
           removegroupmem(gname);
        }
        else if(choice==4){
            Groupsub(gname);
        }
        else if(choice==5){
            user.UserMain();
        }else if(choice==6){
            splitwise.splitwiseMain();
        }else{
            System.out.println("Invalid option");
            System.out.println();
            System.out.println("Press enter to continue...");
            try {
                System.in.read();
                Groupmemmain(gname);
            }   catch (Exception e) {
            }
        }


    }

    static void viewgroupmem(String gname){
        splitwise.clear();
        System.out.println(gname+" Group Members");
        System.out.printf("%-8s%-20s%-20s\n","S.No","Friend id","Friend name" );
        for(int i=0;i<Groups.size();i++){
            if(Groups.get(i).groupName.equals(gname)){
                for(int j=0;j<Groups.get(i).groupusersid.size();j++){
                    System.out.printf("%-8s%-20s%-20s\n",i+1,Groups.get(i).groupusersid.get(j),Groups.get(i).groupusersname.get(j));
                }
                
            }
            
        }

        System.out.println();
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
            Groupmemmain(gname);
        }   catch (Exception e) {
        }

    }

    static void Addgroupmem(String gname){
        splitwise.clear();
        System.out.println("Add Group members");
        System.out.println();
        
        
       /* for(int i=0;i<Groups.size();i++){
            if(Groups.get(i).groupName.equals(gname)){
                for(int j=0;j<Groups.get(i).groupusersid.size();j++){
                    for(int k=0;k<Contacts.contacts.size();k++){
                        if(Contacts.contacts.get(k).friendid.equals(Groups.get(i).groupusersid.get(j))){
                            continue;
                             
                           
                        } 
                       
                        
                    }
             
                }
            }else{
                break;
            }
           


        }*/
        ArrayList<String> contactid=new ArrayList<>();
        contactid.add(user.currentuser);
        for(int i=0;i<Contacts.contacts.size();i++){
             contactid.add(Contacts.contacts.get(i).friendid);
            
                 
             

        }

        for(int i=0;i<Groups.size();i++){
            if(Groups.get(i).groupName.equals(gname)){
              
                ArrayList<String> userids=new ArrayList<>(Groups.get(i).groupusersid);
                for(int j=0;j<userids.size();j++){
                    
                }
                contactid.removeAll(userids);
               
               
            }
        }
        
        for(int i=0;i<contactid.size();i++){
            System.out.println(contactid.get(i));
        }
        if(contactid.size()>0){
            System.out.printf("%-8s%-20s%-20s\n","S.No","Friend id","Friend name");
            for(int j=0;j<contactid.size();j++){
                for(int i=0;i<Contacts.contacts.size();i++){
                    if(Contacts.contacts.get(i).friendid.equals(contactid.get(j))){
                        System.out.printf("%-8s%-20s%-20s\n",i+1,Contacts.contacts.get(i).friendid,Contacts.contacts.get(i).friendname);

                    }
                }
            }
       
            System.out.println("Enter the Friend Id for Friend :");
            String id=sc.next();

            Boolean ispresent=true;
            for(int i=0;i<Groups.size();i++){
                if(Groups.get(i).groupName.equals(gname)){
                    for(int j=0;j<Groups.get(i).groupusersid.size();j++){
                        if(Groups.get(i).groupusersid.get(j).equals(id)){
                            ispresent=false;
                        }

                    }
                }
            }

            if(ispresent){
                String fname=null;
                for(int j=0;j<Contacts.contacts.size();j++){
                    if(Contacts.contacts.get(j).friendid.equals(id)){
                        fname=Contacts.contacts.get(j).friendname;
                    
                    }
                    continue;
                }

                for(int i=0;i<Groups.size();i++){
                    if(Groups.get(i).groupName.equals(gname)){
                        Groups.get(i).groupusersid.add(id);
                        Groups.get(i).groupusersname.add(fname);
                    }
                }
                System.out.print("Added");
            }else{
                System.out.println("Friend is already in the group ");
            }
        }else{
            System.out.println("All the Friends in Your contacts are in the group ");
        }
        
        System.out.println();
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
            Groupmemmain(gname);
        }   catch (Exception e) {
        }
    }

    static void removegroupmem(String gname){
        splitwise.clear();
        System.out.println(gname+" Group Members");
        System.out.printf("%-8s%-20s%-20s\n","S.No","Friend id","Friend name" );
        for(int i=0;i<Groups.size();i++){
            if(Groups.get(i).groupName.equals(gname)){
                for(int j=0;j<Groups.get(i).groupusersid.size();j++){
                    System.out.printf("%-8s%-20s%-20s\n",i+1,Groups.get(i).groupusersid.get(j),Groups.get(i).groupusersname.get(j));
                }
                
            }
            
        }
        System.out.println("Enter the user id ");
        String uid=sc.next();
          
        for(int i=0;i<Groups.size();i++){
            if(Groups.get(i).groupName.equals(gname)){
                for(int j=0;j<Groups.get(i).groupusersid.size();j++){
                    if(Groups.get(i).groupusersid.get(j).equals(uid)){
                        Groups.get(i).groupusersid.remove(j);
                        Groups.get(i).groupusersname.remove(j);
                    }
                }
                
            }
            
        }

        System.out.println("Deleted successfully");
        System.out.println();
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
            Groupmemmain(gname);
        }   catch (Exception e) {
        }

        
        

    }

    
   

    static void groupExpensesMain(String gname){
        splitwise.clear();
        System.out.println("1.Expenses");
        System.out.println("2.Add Expenses");
        System.out.println("3.Back");
        System.out.println("4.User Main");
        int choice=sc.nextInt();
        if(choice==1){
            AddgroupExpensestomem.viewGroupExpenses(gname);
        }else if(choice==2){
             GroupExpenses.AddgroupExpenses(gname);
        }else if(choice==3){
            Groupsub(gname);
        }else if(choice==4){
            user.UserMain();
        }
    }

   
   
    

}

class GroupExpenses{
    private static Scanner sc  = new Scanner(System.in);

    static int groupexpensesgen=1;
    static ArrayList<GroupExpenses> GroupExpenses=new ArrayList<>();

    public String groupid;
    public String groupname;
    public String expensesid;
    public String expensesname;
    public int totalexpenses;
    public String createdname;
    public String Date;
    public String Time;
    
   

    GroupExpenses(String gid,String gname,String eid,String ename,int totexp,String cname,String date,String Time){
        this.groupid=gid;
        this.groupname=gname;
        this.expensesid=eid;
        this.expensesname=ename;
        this.totalexpenses=totexp;
        this.createdname=cname;
        this.Date=date;
        this.Time=Time;
        
    
    }

    static void AddgroupExpenses(String gname){
        splitwise.clear();
        System.out.println("Enter the Expenses Name :");
        String expname=sc.next();

        System.out.println("Enter the Expenses Amount :");
        int amount=sc.nextInt();

        String cname=null;
        for(int k=0;k<user.user.size();k++){
            if(user.user.get(k).userid.equals(user.currentuser)){
                cname=user.user.get(k).username;
            }
        }

        String gid=null;

        ArrayList<String> userids=new ArrayList<>();
        ArrayList<String> username=new ArrayList<>();
        

        for(int i=0;i<Groups.Groups.size();i++){
            if(Groups.Groups.get(i).groupName.equals(gname)){
                gid=Groups.Groups.get(i).groupId;
                for(int j=0;j<Groups.Groups.get(i).groupusersid.size();j++){
                    userids.add(Groups.Groups.get(i).groupusersid.get(j));
                    username.add(Groups.Groups.get(i).groupusersname.get(j));

                }
            }
        }

        GroupExpenses.add(new GroupExpenses(gid,gname, String.valueOf(groupexpensesgen), expname, amount, cname , splitwise.CurrentDate, splitwise.Currenttime));

        AddgroupExpensestomem.groupexpensestomem(gid,gname, String.valueOf(groupexpensesgen),expname,amount,cname,userids,username);
        
        groupexpensesgen++;
   

        
        System.out.println();
        System.out.println("Added");
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
            Groups.groupExpensesMain(gname);
        }   catch (Exception e) {
        }
       
    }

    
    
   

}
class AddgroupExpensestomem{
    private static Scanner sc  = new Scanner(System.in);

    static ArrayList<AddgroupExpensestomem> groupdues=new ArrayList<>();

    public String groupid;
    public String groupname;
    public String createdname;
    public String Expid;
    public String expname;
    public String username;
    public String Amount;
    public String Date;
    public String Time;
    public String Status;

    AddgroupExpensestomem(String groupid,String gname,String createdname,String expid,String ename,String uname,String amt,String date,String time,String Status){
        this.groupid=groupid;
        this.groupname=gname;
        this.createdname=createdname;
        this.Expid=expid;
        this.expname=ename;
        this.username=uname;
        this.Amount=amt;
        this.Date=date;
        this.Time=time;
        this.Status=Status;
    }
    //AddgroupExpensestomem.groupexpensestomem(gid, String.valueOf(groupexpensesgen),expname,amount,cname,userids,username);

    static void groupexpensestomem(String gid,String gname,String expid,String expname,int amount,String cname,ArrayList<String> userids,ArrayList<String> username){
        int amountpermem=amount/userids.size();
        for(int i=0;i<userids.size();i++){
            if(i==0){
                groupdues.add(new AddgroupExpensestomem(gid,gname, cname, expid, expname, username.get(i),String.valueOf(amountpermem), splitwise.CurrentDate, splitwise.Currenttime, "Paid"));

            }else{
                groupdues.add(new AddgroupExpensestomem(gid,gname, cname, expid, expname, username.get(i),String.valueOf(amountpermem), splitwise.CurrentDate, splitwise.Currenttime, "Not Paid"));

            }
        }

    }

    static void viewGroupExpenses(String gname){
        splitwise.clear();
        System.out.println(gname);
        System.out.println();
        int c=1;
        System.out.printf("%-8s%-20s\n","S.no","Expenses Name");
        for(int i=0;i<GroupExpenses.GroupExpenses.size();i++){
            if(GroupExpenses.GroupExpenses.get(i).groupname.equals(gname)){
                System.out.printf("%-8s%-20s\n",c,GroupExpenses.GroupExpenses.get(i).expensesname);
                c+=1;
            }
        }
        System.out.println();
        System.out.println("Enter the expenses name :");
        String expname=sc.next();

        for(int i=0;i<GroupExpenses.GroupExpenses.size();i++){
            if(GroupExpenses.GroupExpenses.get(i).groupname.equals(gname)&&GroupExpenses.GroupExpenses.get(i).expensesname.equals(expname)){
                System.out.println();
                System.out.println("Expenses Name :"+GroupExpenses.GroupExpenses.get(i).expensesname);
                System.out.println();
                System.out.println("Expenses created by :"+GroupExpenses.GroupExpenses.get(i).createdname);
                System.out.println();
                System.out.println("Total Expenses Amount : "+GroupExpenses.GroupExpenses.get(i).totalexpenses);
                System.out.println();
            }
        }
        
        for(int i=0;i<groupdues.size();i++){
            if(groupdues.get(i).groupname.equals(gname)&&groupdues.get(i).expname.equals(expname)){
                
                System.out.println("---------");
                if(groupdues.get(i).Status.equals("Paid")){
                    System.out.println(groupdues.get(i).username+" "+groupdues.get(i).Status+" "+groupdues.get(i).Amount+" on "+groupdues.get(i).Date+" "+groupdues.get(i).Time);
                    
                }else{
                    System.out.println(groupdues.get(i).username+" "+groupdues.get(i).Status+" "+groupdues.get(i).Amount);

                }
                System.out.println("---------");
            }
        }
         
        System.out.println();
        System.out.println("Added");
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
            Groups.groupExpensesMain(gname);
        }   catch (Exception e) {
        }
       

    }

    static void PendingDues(String gname){
        splitwise.clear();
        int c=0;
    
        String uname=null;
        for(int i=0;i<user.user.size();i++){
            if(user.user.get(i).userid.equals(user.currentuser)){
                uname=user.user.get(i).username;
    
            }
        }
        System.out.printf("%-8s%-20s%-20s%-20s%-20s%20s\n","S.no","Username","Expenses_id","Ecpensesname","Expense by","Amount");
        for(int i=0;i<groupdues.size();i++){
            if(groupdues.get(i).username.equals(uname)&&groupdues.get(i).Status.equals("Not Paid")){
                System.out.printf("%-8s%-20s%-20s%-20s%-20s%20s\n",++c,groupdues.get(i).username,groupdues.get(i).Expid,groupdues.get(i).expname,groupdues.get(i).createdname,groupdues.get(i).Amount);
            }
        }
        if(c>=1){
            System.out.println();
            System.out.println("Do You want to pay the Amount(y/n) :");
            String s=sc.next();
            if(s.equals("y")){
                System.out.println("Enter the no of Payments");
                int pcount=sc.nextInt();
                for(int j=0;j<pcount;j++){
                    System.out.println("Enter the Expenses id: ");  
                    String expid=sc.next();
                    
                    if(Statuschanger(expid,uname)){
                        System.out.println("Amount paid for "+expid);
                    }else{
                        System.out.println("Amount not paid for "+expid+" Balance is not Sufficient to pay");
                    }
                }
    
            }else{
    
                
                System.out.println();
                System.out.println("Press enter to continue...");
                try {
                    System.in.read();
                    Groups.Groupsub(gname);
                } catch (Exception e) {}
    
            
            }
        } else{
            System.out.println("no dues");
        }
        System.out.println();
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
            Groups.Groupsub(gname);
        } catch (Exception e) {}

    
        
    }

    static boolean Statuschanger(String expid,String uname){

        String amount=null;
        String cname=null;
        for(int i=0;i<groupdues.size();i++){
            if(groupdues.get(i).Expid.equals(expid)&& groupdues.get(i).username.equals(uname)){
               // addExpenses.nongroupdues.get(i).Status="Paid";
                amount=groupdues.get(i).Amount;
                cname=groupdues.get(i).createdname;
            }
        }
        boolean ispaid=false;
       if (withdraw(amount)){
        for(int i=0;i<groupdues.size();i++){
            if(groupdues.get(i).Expid.equals(expid)&&groupdues.get(i).username.equals(uname)){
                groupdues.get(i).Status="Paid";
                //amount=addExpenses.nongroupdues.get(i).Amount;
                ispaid=true;
            }
        }
        for(int i=0;i<user.user.size();i++){
            if(user.user.get(i).username.equals(cname)){
                user.user.get(i).Balance= user.user.get(i).Balance+(Integer.valueOf(amount));
            }
        }
        

       }
       return(ispaid);


      

    }

    static boolean withdraw(String amount){
        int amt=Integer.valueOf(amount);
        boolean ispos=false;

        for(int i=0;i<user.user.size();i++){
            if(user.user.get(i).userid.equals(user.currentuser)){
                if(user.user.get(i).Balance>amt){
                    int l=user.user.get(i).Balance;
                    user.user.get(i).Balance=l-amt;
                    ispos=true;
                }
                
            }
        }
        return ispos;

    }

    
    static void groupTransactions(String gname){
        splitwise.clear();
        System.out.println(gname);
        int c=1;
        System.out.printf("%-8s%-10s%-10s%-20s%-10s%20s%10s%10s\n","S.no","Username","Expenses_id","Ecpensesname","Expense by","Amount","Date","Time");
        for(int i=0;i<groupdues.size();i++){
            if(groupdues.get(i).username.equals(user.currentusername)){
                if(groupdues.get(i).Status.equals("Paid")){
                   System.out.printf("%-8s%-10s%-10s%-20s%-10s%20s%10s%10s\n",c,groupdues.get(i).username,groupdues.get(i).Expid,groupdues.get(i).expname,groupdues.get(i).createdname,groupdues.get(i).Amount,groupdues.get(i).Date,groupdues.get(i).Time);
                   c++;
                }
                
            }
            
        }
         
        System.out.println();
            System.out.println("Press enter to continue...");
            try {
                System.in.read();
                Groups.Groupsub(gname);;
            } catch (Exception e) {}

       

    }


   
  







}
class Contacts{
    private static Scanner sc  = new Scanner(System.in);

  

    static ArrayList<Contacts> contacts=new ArrayList<>();

    public String userid;
    public String friendid;
    public String friendname;
    

    
    
    Contacts(String userid,String uid,String fname){
        this.userid=userid;
        this.friendid=uid;
        this.friendname=fname;
        
       
    }

    static void contactMain(){
        splitwise.clear();
        System.out.println("1.Add Friends");
        System.out.println("2.view Friends");
        System.out.println("3.Back");
        System.out.println("4.Main");
        System.out.println();
        int choice=sc.nextInt();
        if(choice==1){
            addfriends();
        }else if(choice==2){
            viewfriends();
        }else if(choice==3){
            user.UserMain();
        }else if(choice==4){
            splitwise.splitwiseMain();
        }else{
            System.out.println("Invalid Option");
            System.out.println();
            System.out.println("Press enter to continue...");
            try {
                System.in.read();
                contactMain();
            } catch (Exception e) {}

        }


    }

    static void addfriends(){
        splitwise.clear();
        System.out.println("Available Users");
        System.out.printf("%-20s%-20s\n","Username","Userid");
        for(int i=0;i<user.user.size();i++){
            if(!user.user.get(i).userid.equals(user.currentuser)){
           System.out.printf("%-20s%-20s\n",user.user.get(i).username,user.user.get(i).userid);
            }
        }
        System.out.println("Enter the User name");
        String fname=sc.next();
        String fid=null;
        
        boolean isuserpresent=false;
        for(int i=0;i<user.user.size();i++){
            if(user.user.get(i).username.equals(fname)){
                isuserpresent=true;
                fid=user.user.get(i).userid;
            }
           

        }
        
        if(isuserpresent){
            Boolean isuseringroup=true;
            for(int i=0;i<contacts.size();i++){
                if(contacts.get(i).friendname.equals(fname)){
                    isuseringroup=false;
                }
            }
            if(isuseringroup){
                contacts.add(new Contacts(user.currentuser,fid,fname));
                System.out.println("Added succesfully");
            }else{
                System.out.println("Already in Group");
            }

        }
        else{
            System.out.println("User not available");
        }
        System.out.println();
        System.out.println("Press enter to continue");
        try {
            System.in.read();
            contactMain();
        } catch (Exception e) {}
    

    }

    static void viewfriends(){
        splitwise.clear();
        System.out.println("Contacts");
        System.out.printf("%-8s%-20s%-20s\n","S.No","Friend id","Friend Name");
        for(int i=0;i<contacts.size();i++){
            if(contacts.get(i).userid.equals(user.currentuser)){
              System.out.printf("%-8s%-20s%-20s\n",i+1,contacts.get(i).friendid,contacts.get(i).friendname);
            }
        }

        System.out.println();
        System.out.println("Press enter to continue");
        try {
            System.in.read();
            contactMain();
        } catch (Exception e) {}


    }

    
}


class addExpenses{
    private static Scanner sc  = new Scanner(System.in);

    static ArrayList<addExpenses> nongroupdues=new ArrayList<>();

    public String userid;
    public String createdname;
    public String nonExpid;
    public String expname;
    public String username;
    public String Amount;
    public String Date;
    public String Time;
    public String Status;

    addExpenses(String userid,String createdname,String expid,String ename,String uname,String amt,String date,String time,String Status){
        this.userid=userid;
        this.createdname=createdname;
        this.nonExpid=expid;
        this.expname=ename;
        this.username=uname;
        this.Amount=amt;
        this.Date=date;
        this.Time=time;
        this.Status=Status;
    }


   

    static void AddexpenseMain(ArrayList<String> userid,String createdname,String ename,int tot,String type){
        if(type.equals("1")){
            int amtpermem=tot/userid.size();
            for(int i=0;i<userid.size();i++){
                if(userid.get(i).equals(user.currentuser)){
                   
                    nongroupdues.add(new addExpenses(String.valueOf(userid.get(i)), createdname, String.valueOf(NongroupExpenses.Nongroupexpensesgen),ename, createdname,String.valueOf(amtpermem), splitwise.CurrentDate, splitwise.Currenttime, "Paid"));
                    
                }
                else{
                    String uname=null;
                    for(int j=0;j<user.user.size();j++){
                        if(user.user.get(j).userid.equals(userid.get(i))){
                           
                            uname=user.user.get(j).username;
                        }
                    }
                    nongroupdues.add(new addExpenses(String.valueOf(userid.get(i)), createdname, String.valueOf(NongroupExpenses.Nongroupexpensesgen),ename, uname,String.valueOf(amtpermem),"0","0", "Not paid"));



                }
            }

            System.out.println("Added succussfully");

        }else if(type.equals("2")){
            int total=0;
            for(int i=0;i<userid.size();i++){
                String uname=null;
                for(int j=0;j<user.user.size();j++){
                    if(user.user.get(j).userid.equals(userid.get(i))){
                        uname=user.user.get(j).username;
                    }
                }
                int left=tot-total;
                System.out.println("Total expenses left :"+left);
                System.out.println();
                System.out.println("Enter Amount for "+uname+" : ");
                String amt=sc.next();

                total=total+Integer.valueOf(amt);

                if(userid.get(i).equals(user.currentuser)){
                    nongroupdues.add(new addExpenses(String.valueOf(userid.get(i)), createdname, String.valueOf(NongroupExpenses.Nongroupexpensesgen), ename,createdname,amt, splitwise.CurrentDate, splitwise.Currenttime, "Paid"));
                    //NongroupExpenses.Nongroupexpensesgen+=1;
                  
                }else{
                   
                    System.out.println(uname);

                    nongroupdues.add(new addExpenses(String.valueOf(userid.get(i)), createdname, String.valueOf(NongroupExpenses.Nongroupexpensesgen),ename, uname,amt, "0", "0", "Not paid"));
                    //NongroupExpenses.Nongroupexpensesgen+=1;
                }
                
            }
            
           
            System.out.println("Added succussfully");

           
        }else{
            System.out.println("Invalid options");
           

        }

        System.out.println("Press enter to continue");
        try {
          System.in.read();
          NongroupExpenses.nongroupMain();
       } catch (Exception e) {}


        
        

    }
}

class NongroupExpenses{
    private static Scanner sc  = new Scanner(System.in);

    static int Nongroupexpensesgen=0;
    static ArrayList<NongroupExpenses> nongroupExpenses=new ArrayList<>();
    
    public String userid;
    public String expensesid;
    public String expensesname;
    public int totalexpenses;
    public String username;
    public String Date;
    public String Time;
    ArrayList<String> userexpensesid;
   

    NongroupExpenses(String uid,String eid,String ename,int totexp,String uname,String date,String Time,ArrayList<String> eusers){
        this.userid=uid;
        this.expensesid=eid;
        this.expensesname=ename;
        this.totalexpenses=totexp;
        this.username=uname;
        this.Date=date;
        this.Time=Time;
        this.userexpensesid=eusers;
    
    }
    
    static void nongroupMain(){
        splitwise.clear();
        System.out.println("1.View Expenses");
        System.out.println("2.Add Expenses");
        System.out.println("3.Pending dues");
        System.out.println("4.Transactions");
        System.out.println("5.Back");
        System.out.println("6.Main");
        int choice=sc.nextInt();

        if(choice==1){
            viewexpenses();
        }else if(choice==2){
            createexpense();
        }else if(choice==3){
            pendingdues();
        }else if(choice==4){
            Transactions();
        }
        else if(choice==5){
            user.UserMain();
        }else if(choice==6){
            splitwise.splitwiseMain();
        }else{
            System.out.println("Invalid Option");
            System.out.println();
            System.out.println("Press enter to continue...");
            try {
                System.in.read();
                nongroupMain();
            } catch (Exception e) {}

        }

    } 
    static void viewexpenses(){
        splitwise.clear();

        System.out.println();
        int c=1;
        System.out.printf("%-8s%-20s\n","S.no","Expenses Name");
        for(int i=0;i<nongroupExpenses.size();i++){
            if(nongroupExpenses.get(i).username.equals(user.currentusername)){
                System.out.printf("%-8s%-20s\n",c,nongroupExpenses.get(i).expensesname);
                c+=1;
            }
        }
        System.out.println();
        if(c>1){
        System.out.println("Enter the expenses name:");
        String expname=sc.next();
        
        boolean isexpname=false;
        for(int i=0;i<nongroupExpenses.size();i++){
            if(nongroupExpenses.get(i).expensesname.equals(expname)){
               
                isexpname=true;
            }
        }

        if(isexpname){
            for(int i=0;i<nongroupExpenses.size();i++){
                if(nongroupExpenses.get(i).expensesname.equals(expname)){
                    splitwise.clear();
                    System.out.println();
                    System.out.println("Expense Name :"+nongroupExpenses.get(i).expensesname);
                    System.out.println();
                    System.out.println("Expense Created by :"+nongroupExpenses.get(i).username);
                    System.out.println();
                    System.out.println("Total Expense amount : "+nongroupExpenses.get(i).totalexpenses);
                    System.out.println();
                    break;
                }
               
                
                
            }
            for(int i=0;i<addExpenses.nongroupdues.size();i++){
                if(addExpenses.nongroupdues.get(i).expname.equals(expname)){
                    System.out.println("---------");
                    if(addExpenses.nongroupdues.get(i).Status.equals("Paid")){
                        System.out.println(addExpenses.nongroupdues.get(i).username+" "+addExpenses.nongroupdues.get(i).Status+" "+addExpenses.nongroupdues.get(i).Amount+" "+"on "+addExpenses.nongroupdues.get(i).Date+" "+addExpenses.nongroupdues.get(i).Time);
                    }
                    else{
                        System.out.println(addExpenses.nongroupdues.get(i).username+" "+addExpenses.nongroupdues.get(i).Status+" "+addExpenses.nongroupdues.get(i).Amount);

                    }
                    
                    
                }
                
                
            }
        }else{
            System.out.println("Expenses not available");

        }
    }else{
        System.out.println("No Expenses yet Created");
    }
        System.out.println();
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
            nongroupMain();
        } catch (Exception e) {}

         


    }
    static void createexpense(){
        splitwise.clear();
        ArrayList<String> userid=new ArrayList<>();


       

        System.out.println("Enter the Expenses Name :");
        String ename=sc.next();

        splitwise.clear();
         
        userid.add(user.currentuser);
        System.out.println();
        int c=0;
        int t=0;
        System.out.printf("%-8s%-20s%-20s\n","S.No","Friend id","Friend Name");
        for(int i=0;i<Contacts.contacts.size();i++){
            if(Contacts.contacts.get(i).userid.equals(user.currentuser)){
            System.out.printf("%-8s%-20s%-20s\n",++c,Contacts.contacts.get(i).friendid,Contacts.contacts.get(i).friendname);
            t++;
            }
        }
          
       if(t>0){
        Nongroupexpensesgen+=1;
        System.out.println("Enter the no of user,you need to add for your Expenses");
        int count=sc.nextInt();
        if(count>0){
        for(int i=0;i<count;i++){
            System.out.println("Enter the user id for user "+(i+1)+" :");
            String uid=sc.next();
            userid.add(uid);

        }

        System.out.println("Enter the Total Expenses :");
        int totexp=sc.nextInt();
        
        String uname=null;
        for(int i=0;i<user.user.size();i++){
            if(user.user.get(i).userid.equals(user.currentuser)){
                uname=user.user.get(i).username;
            }
        }
        
                
        nongroupExpenses.add(new NongroupExpenses(user.currentuser, String.valueOf(Nongroupexpensesgen), ename, totexp, uname, splitwise.CurrentDate, splitwise.Currenttime, userid) );
        
        System.out.println("Select the Expenses type ");
        System.out.println("1.Split Equally");
        System.out.println("2.Split Unequally");
        String type=sc.next();
        
        addExpenses.AddexpenseMain(userid,uname,ename,totexp,type);

        
       

        }
    }else{
        System.out.println("No friends in your contacts");
    }
        System.out.println();
            System.out.println("Press enter to continue...");
            try {
                System.in.read();
                nongroupMain();
            } catch (Exception e) {}

        

        
    }
    static void pendingdues(){

        splitwise.clear();
        int c=1;
        System.out.printf("%-8s%-20s%-20s%-20s%-20s%20s\n","S.no","Username","Expenses_id","Ecpensesname","Expense by","Amount");
        for(int i=0;i<addExpenses.nongroupdues.size();i++){
            if(addExpenses.nongroupdues.get(i).userid.equals(user.currentuser)){
                if(addExpenses.nongroupdues.get(i).Status.equals("Not paid")){
                   System.out.printf("%-8s%-20s%-20s%-20s%-20s%20s\n",c,addExpenses.nongroupdues.get(i).username,addExpenses.nongroupdues.get(i).nonExpid,addExpenses.nongroupdues.get(i).expname,addExpenses.nongroupdues.get(i).createdname,addExpenses.nongroupdues.get(i).Amount);
                   c++;
                }
                
            }
            
        }
        if(c>1){
            System.out.println();
            System.out.println("Do You want to pay the Amount(y/n) :");
            String s=sc.next();
            if(s.equals("y")){
                System.out.println("Enter the no of Payments");
                int pcount=sc.nextInt();
                for(int j=0;j<pcount;j++){
                    System.out.println("Enter the Expenses id: ");  
                    String expid=sc.next();
                
                    if(Statuschanger(expid)){
                        System.out.println("Amount paid for "+expid);
                    }else{
                        System.out.println("Amount not paid for "+expid+" Balance is not Sufficient to pay");
                    }
                }

            }else{
               

            
                System.out.println();
                System.out.println("Press enter to continue...");
                try {
                    System.in.read();
                    nongroupMain();
                } catch (Exception e) {}

        
            }
        }else{
            System.out.print("No Pending Dues");
        }
        
        System.out.println();
            System.out.println("Press enter to continue...");
            try {
                System.in.read();
                nongroupMain();
            } catch (Exception e) {}

        

    }

    static boolean Statuschanger(String expid){
        String amount=null;
        String cname=null;
        for(int i=0;i<addExpenses.nongroupdues.size();i++){
            if(addExpenses.nongroupdues.get(i).nonExpid.equals(expid)&&addExpenses.nongroupdues.get(i).userid.equals(user.currentuser)){
               // addExpenses.nongroupdues.get(i).Status="Paid";
                amount=addExpenses.nongroupdues.get(i).Amount;
                cname=addExpenses.nongroupdues.get(i).createdname;

            }
        }
        boolean ispaid=false;
       if (withdrawAmout(amount)){
        for(int i=0;i<addExpenses.nongroupdues.size();i++){
            if(addExpenses.nongroupdues.get(i).nonExpid.equals(expid)&&addExpenses.nongroupdues.get(i).userid.equals(user.currentuser)){
                addExpenses.nongroupdues.get(i).Status="Paid";
                addExpenses.nongroupdues.get(i).Date=splitwise.CurrentDate;
                addExpenses.nongroupdues.get(i).Time=splitwise.Currenttime;
                
                //amount=addExpenses.nongroupdues.get(i).Amount;
                ispaid=true;
            }
        }
        for(int i=0;i<user.user.size();i++){
            if(user.user.get(i).username.equals(cname)){
                user.user.get(i).Balance= user.user.get(i).Balance+(Integer.valueOf(amount));
            }
        }
       }
       return(ispaid);
    }

    static boolean withdrawAmout(String amount){
        int amt=Integer.valueOf(amount);
        boolean ispos=false;

        for(int i=0;i<user.user.size();i++){
            if(user.user.get(i).userid.equals(user.currentuser)){
                if(user.user.get(i).Balance>amt){
                    int l=user.user.get(i).Balance;
                    user.user.get(i).Balance=l-amt;
                    ispos=true;
                }
                
            }
        }

        return ispos;
    }
    static void Transactions(){
        splitwise.clear();
        int c=1;
        System.out.printf("%-8s%-10s%-20s%-20s%-10s%10s%10s%10s\n","S.no","Username","Expenses_id","Ecpensesname","Expense by","Amount","Date","Time");
        for(int i=0;i<addExpenses.nongroupdues.size();i++){
            if(addExpenses.nongroupdues.get(i).userid.equals(user.currentuser)){
               // if(addExpenses.nongroupdues.get(i).Status.equals("Paid")){
                   System.out.printf("%-8s%-10s%-20s%-20s%-10s%10s%10s%10s\n",c,addExpenses.nongroupdues.get(i).username,addExpenses.nongroupdues.get(i).nonExpid,addExpenses.nongroupdues.get(i).expname,addExpenses.nongroupdues.get(i).createdname,addExpenses.nongroupdues.get(i).Amount,addExpenses.nongroupdues.get(i).Date,addExpenses.nongroupdues.get(i).Time);
                   c++;
                //}
                
            }
            
        }
         
        System.out.println();
            System.out.println("Press enter to continue...");
            try {
                System.in.read();
                nongroupMain();
            } catch (Exception e) {}

        


    }

}



   

