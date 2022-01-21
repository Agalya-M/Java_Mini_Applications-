import java.util.*;

class AtmMachine{
    private static Scanner sc;
    
    static void clear(){
        System.out.print("\033[H\033[2J");
    }
    static void AtmMain(){
        clear();
        System.out.println("ATM MACHINE");
        System.out.println();
        System.out.println("1. Admin Login");
        System.out.println("2. User Login");
        System.out.println("3. Exit");
        System.out.println();
        System.out.println("Enter your choice");
        int ch = sc.nextInt();
        switch (ch) {
            case 1:
                Admin.adminlogin();
                break;
            case 2:
                User.userlogin();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }


    }

    public static void main(String args[]) {
    sc = new Scanner(System.in);
    AtmMain();
    }
}

class Admin{
    private static Scanner sc = new Scanner(System.in);
    static String Adminid="Admin";
    static String Adminpassword="1234";

    static int amount[] = { 0, 0, 0, 0 };
    static int amountnum[] = { 2000, 500, 200, 100 };
   
    static int  total;

    static void adminlogin(){
        AtmMachine.clear();

       

        System.out.println("Enter Admin Id");
        String adminid = sc.nextLine();
        
        if (adminid.equals(Adminid)) {
            System.out.println("Enter Password");
            String adminpass = sc.nextLine();
            if (adminpass.equals(Adminpassword)) {
                Adminfunc();
            } else {
                System.out.println("Invalid password");
                try {
                    System.in.read();
                    AtmMachine.AtmMain();
                } catch (Exception e) {
                }
            }
        } else {
            System.out.println("Invalid admin id");
            try {
                System.in.read();
                AtmMachine.AtmMain();
            } catch (Exception e) {
            }
        }
    }

    static void Adminfunc(){
        AtmMachine.clear();
        System.out.println("Admin Main");
        System.out.println("1. Add Amount");
        System.out.println("2. Show Amount");
        System.out.println("3. Back");
        int ch1 = sc.nextInt();
        switch (ch1) {
            case 1:
                Addamount();
                break;
            case 2:
                Showamount();
                break;
            case 3:
                AtmMachine.AtmMain();;
                break;
            default:
                System.out.println("Invalid choice");
                try {
                    System.in.read();
                    Adminfunc();
                } catch (Exception e) {
                }
                break;
        }
    }

    static void Addamount(){
        AtmMachine.clear();
        for (int i = 0; i < 4; i++) {
            System.out.println("Enter number of " + amountnum[i] + " is ");
            amount[i] += sc.nextInt();
            System.out.print("\033[H\033[2J");
        }
        for (int i = 0; i < 4; i++) {

            total += amountnum[i] * amount[i];
        }
        System.out.println("Amount added Successfully");
        System.out.println();
        System.out.println("Please press enter for continue");
        try {
            System.in.read();
            Adminfunc();
        } catch (Exception e) {
        }
    }

    static void Showamount(){
        AtmMachine.clear();
        for (int i = 0; i < 4; i++) {
            System.out.println("Number of notes in " + amountnum[i] + " is " + amount[i]);
        }
        System.out.println("Total amount added " + total);
        System.out.println();
        System.out.println("Please press enter for continue");
        try {
            System.in.read();
            Adminfunc();
        } catch (Exception e) {
        }
    }
}
class User{
    private static Scanner sc = new Scanner(System.in);
    static String name[] = { "User1", "User2" };
    static String pass[] = { "1234", "2022" };
    static String bank[] = { "HDFC", "state" };
    static int WithDraw_count = 0;
    static int Transfer_count = 0;
    static int account[] = { 10000, 30000 };
    static int amount;
    
    static boolean ApplyCom = false;
    static int count = 0;
    static int j = 0;
    static ArrayList<String> mini = new ArrayList<>();
    static int a, b, c, d, e, f, g, h;
   
  

    static void userlogin(){
        AtmMachine.clear();
        if (count < 9) {
            System.out.print("\033[H\033[2J");
            count++;
            System.out.println("Enter Username");
            
            String username = sc.nextLine();
            System.out.print("\033[H\033[2J");
            if (username.equals(name[0])) {
                System.out.println("Enter Password");
                String userpass = sc.nextLine();
                if (userpass.equals(pass[0])) {
                    Transfer_count = 0;
                    mini.clear();
                    UserMain(0);
                } else {
                    System.out.println("Invalid password");
                }
            } else if (username.equals(name[1])) {
                System.out.println("Enter Password");
                String userpass = sc.nextLine();
                if (userpass.equals(pass[1])) {
                    UserMain(1);
                } else {
                    System.out.println("Invalid password");
                    try {
                        System.in.read();
                        AtmMachine.AtmMain();
                    } catch (Exception e) {
                    }
                }
            } else {
                System.out.println("Invalid Username");
                try {
                    System.in.read();
                    AtmMachine.AtmMain();
                } catch (Exception e) {
                }
            }
        } else {
            System.out.println("Login Attempt Exceeded");
            try {
                System.in.read();
                AtmMachine.AtmMain();
            } catch (Exception e) {
            }
        }

    }

    static void UserMain(int userid){
        AtmMachine.clear();
        System.out.println("User Main");
        System.out.println();
        System.out.println("1. Withdraw Amount");
        System.out.println("2. Account Balance");
        System.out.println("3. Mini Statement");
        System.out.println("4.  Amount Transfer");
        System.out.println("5. Deposite Amount");
        System.out.println("6. Pin change");
        System.out.println("7. Back");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                if (bank[userid] == "State") {
                    WithdrawAmount(userid);
                    break;
                } else if (WithDraw_count < 1) {
                    WithDraw_count += 1;
                    WithdrawAmount(userid);
                    break;
                } else {
                    ApplyCom = true;
                    WithdrawAmount(userid);
                }
            case 2:
                ShowBalance(userid);
                break;
            case 3:
                MiniStatement(userid);
                break;
            case 4:
                Amounttransfer(userid);
                break;
            case 5:
                DepositAmt(userid);
                break;
            case 6:
                Pinchange(userid);
                
                break;
            case 7:
                AtmMachine.AtmMain();
                break;
            default:
                System.out.println("Invalid choice");
                try {
                    System.in.read();
                    AtmMachine.AtmMain();
                } catch (Exception e) {
                }
        }

    }

    static void WithdrawAmount(int userid){
        AtmMachine.clear();
        System.out.println("Enter the amount");
        amount = sc.nextInt();
        if (account[userid] >= amount) {
            if (Admin.total < amount) {
                System.out.println("No Cash to Dispence");
                System.out.println();
                System.out.println("Please press enter for previous menu");
                try {
                    System.in.read();
                    UserMain(userid);
                } catch (Exception e) {
                }
            } else {

                Admin.total -= amount;
                if (ApplyCom) {
                    if (amount % 100 == 0) {
                        if (account[userid] >= amount + 100) {
                            account[userid] -= 100;
                            Withdraw(amount);
                            Transfer_count++;
                            account[userid] -= amount;
                            MiniStatement(userid);
                            System.out.println("Withdraw Successfully");
                            System.out.println();
                            System.out.println("Please press enter for continue");
                            try {
                                System.in.read();
                                UserMain(userid);
                            } catch (Exception e) {
                            }
                        } else {
                            System.out.println("Insufficent balance for  transation");
                            System.out.println();
                            System.out.println("Please press enter for continue");
                            try {
                                System.in.read();
                                UserMain(userid);
                            } catch (Exception e) {
                            }
                        }
                    } else {
                        System.out.println("Invalid Input");
                        System.out.println();
                        System.out.println("Please press enter for continue");
                        try {
                            System.in.read();
                            UserMain(userid);
                        } catch (Exception e) {
                        }
                    }

                } else {

                    if (amount % 100 == 0) {
                        Withdraw(amount);
                        Transfer_count++;
                        account[userid] -= amount;
                        addtomini(String.valueOf(amount), "Withdrawn");
                        System.out.println("Amount Withdraw Successfully");
                        System.out.println();
                        System.out.println("Please press enter for previous menu");
                        try {
                            System.in.read();
                            UserMain(userid);
                        } catch (Exception e) {
                        }
                    } else {
                        System.out.println("Invalid Input");
                        System.out.println();
                        System.out.println("Please press enter for continue");
                        try {
                            System.in.read();
                            UserMain(userid);
                        } catch (Exception e) {
                        }
                    }
                }
            }
        } else {
            System.out.println("Insufficent Balance in your account " + account[userid]);
            System.out.println();
            System.out.println("Please press enter for continue");
            try {
                System.in.read();
                UserMain(userid);
            } catch (Exception e) {
            }
        }
    }
    static void ShowBalance (int userid){
        AtmMachine.clear();
        System.out.println("Your account balance is " + account[userid]);
        System.out.println();
        System.out.println("Please press enter for Continue");
        try {
            System.in.read();
            UserMain(userid);
        } catch (Exception e) {
        }
  
    }

    static void addtomini(String amt,String id){
        mini.add("The Amount is " + a + ": " + b);

    }
    static void MiniStatement(int userid){
        AtmMachine.clear();
        int indx = mini.size() - 1, i = 0;
        if (Transfer_count >= 6) {
            while (i < 6) {
                System.out.println(mini.get(indx));
                i++;
                indx--;
            }

            System.out.println();
            System.out.println("Please press enter for Continue");
            try {
                System.in.read();
                UserMain(userid);
            } catch (Exception e) {
            }
        } else {
            System.out.println("Required Minimum 6 Transactions");
            System.out.println();
            System.out.println("Please press enter for continue");
            try {
                System.in.read();
                UserMain(userid);
            } catch (Exception e) {
            }
        }

    }
    static void Withdraw(int amt){
        
        for (int i = 0; i < Admin.amount.length; i++) {
            if (amt >= Admin.amountnum[i]) {
                int temp = Math.abs(Admin.amount[i] - (amt / Admin.amountnum[i]));

                int rec = (temp - Admin.amount[i] == 0) ? temp : Math.abs(temp - Admin.amount[i]);
                int mul = rec * Admin.amountnum[i];
                amt -= mul;
                Admin.amount[i] -= rec;
            }
        }
    }

    static void Amounttransfer(int userid){
        AtmMachine.clear();
        System.out.println("Enter Username of Transfer :");
        sc.nextLine();
        String toUser = sc.nextLine().trim();
        if (Arrays.asList(name).contains(toUser)) {
            System.out.println("Enter Amount:");
            int Amount = sc.nextInt();
            if (account[userid] >= Amount) {
                Transfer_count++;
                for (int i = 0; i < name.length; i++) {
                    if (name[i].equals(toUser)) {
                        account[i] += Amount;
                        account[userid] -= Amount;
                        break;
                    }
                }
                addtomini(String.valueOf(Amount), "Transfred");
                System.out.println("Amount Transfered Successfully");
                System.out.println();
                System.out.println("Please press enter for Continue");
                try {
                    System.in.read();
                    UserMain(userid);
                } catch (Exception e) {
                }
            } else {
                System.out.println("Insufficent Balance");
                System.out.println();
                System.out.println("Please press enter for continue");
                try {
                    System.in.read();
                    UserMain(userid);
                } catch (Exception e) {
                }
            }
        } else {
            System.out.println("Invalid UserName");
            System.out.println();
            System.out.println("Please press enter for continue");
            try {
                System.in.read();
                UserMain(userid);
            } catch (Exception e) {
            }
        }
    }

    static void DepositAmt(int userid){
        AtmMachine.clear();
        int v = 0;
        for (int k = 0; k < 4; k++) {
            System.out.println("Enter number of " + Admin.amountnum[k] + " is ");
            int t = sc.nextInt();
            v += t * Admin.amountnum[k];
            Admin.amount[k] += t;
            System.out.print("\033[H\033[2J");
        }
        account[userid] += v;
        Admin.total += v;

        System.out.println("Amount Added Successfully !!!");
        System.out.println();
        System.out.println("Please press enter for continue");
        try {
            System.in.read();
            UserMain(userid);
        } catch (Exception e) {
        }
        
    }
    static void Pinchange(int userid){
        AtmMachine.clear();
        System.out.println("Enter Old Password :");
        String oldpass = sc.next();
        if (pass[userid].equals(oldpass)) {
            AtmMachine.clear();
            System.out.println("Enter new password :");
            String newpass = sc.next();
            pass[userid] = newpass;
            System.out.println("Password Changed successfully");
        } else {
            System.out.println("Password incorrect");
        }
        System.out.println();
        System.out.println("Please press enter for continue");
        try {
            System.in.read();
            UserMain(userid);
        } catch (Exception e) {
        }
    }
}