import java.util.*;

public class AmazonShopping{
    private static Scanner sc = new Scanner(System.in);
    static void clear() {
        System.out.print("\033[H\033[2J");
    }
    static void AmazonMain(){
        clear();
        System.out.println("AmazonShopping");
        System.out.println();
        System.out.println("1. Admin");
        System.out.println("2. Merchant");
        System.out.println("3. Buyer");
        System.out.println("4. Exit");
        System.out.println();
        System.out.print("Enter your option : ");
        int ch = sc.nextInt();

        if (ch == 1) {
            Admin.Adminlogin();
        } else if (ch == 2) {
            Merchant.MerchantLogin();
        } else if (ch == 3) {
            Buyer.BuyerLogin();
        } else if (ch == 4) {
            System.exit(0);
        } else {
            System.out.println("Invalid option");
            System.out.println();
            System.out.println("Press enter to continue...");
            try {
                System.in.read();
               AmazonMain();
            } catch (Exception e) {
            }
        }
    }

    public static void main(String[] args) {
        AmazonMain();
    }



}

class Admin{
    private static Scanner sc = new Scanner(System.in);
    static String  caller="User";
    public String MerchantName, MerchantPassword;
    public int MerchantId = 0;
    public static int merchant_id = 1000;
    public boolean MerchantStatus = false;
    public Map<String, List<String>> MerchantProducts = new HashMap<>();

    Admin(String name, String pass, int id, boolean verify) {
        this.MerchantName = name;
        this.MerchantPassword = pass;
        this.MerchantId = id;
        this.MerchantStatus = verify;
    }

    static String Adminname="Admin";
    static String Adminpassword="1234";
    static List<Admin> merchants = new ArrayList<>();

    
    static void Adminlogin(){
        AmazonShopping.clear();
        System.out.println("Admin Login ");
        System.out.println();
        System.out.println("Enter your Username : ");
        String username = sc.next();
        System.out.println("Enter your Password : ");
        String password = sc.next();
        if (username.equals(Adminname) && password.equals(Adminpassword)) {
            AdminMain();

        } else {
            System.out.println("Invalid Credentials");
            try {
                System.in.read();
                AmazonShopping.AmazonMain();
            } catch (Exception e) {
            }
        }
       
    }

    static void AdminMain() {
            AmazonShopping.clear();
            System.out.println("Admin Main");
            System.out.println();   
            System.out.println("1. Add Merchant ");
            System.out.println("2. Remove Merchant");
            System.out.println("3. View All Products ");
            System.out.println("4. Approve Merchants");
            System.out.println("5. Back ");
            int ch = sc.nextInt();
            if (ch == 1) {
                Addmerchant();
            } else if (ch == 2) {
                Removemerchant();
            } else if (ch == 3) {
                Viewproducts();
            }  else if (ch == 4) {
                Approvemerchant();
            } else if (ch == 5) {
                AmazonShopping.AmazonMain();
            
            } else {
                System.out.println("Invalid ch");
                System.out.println("Press enter to continue...");
                 try {
            System.in.read();
            AdminMain();
              } catch (Exception e) {
        }
            }

       
    }
    static void Viewproducts() {
        AmazonShopping.clear();
        System.out.printf("%-10s%-20s%-20\n","products","count","Prize");
        for (int i = 0; i < merchants.size(); i++) {
            Admin k = merchants.get(i);
            for (String name : k.MerchantProducts.keySet()) {
                List<String> li = k.MerchantProducts.get(name);
                System.out.printf("%-10s%-20s%-20\n", name , li.get(0) , li.get(1));
            }
        }
        System.out.println("Press enter to continue...");
        try {
      System.in.read();
       AdminMain();
     } catch (Exception e) {
}
        
       
    }

    static void Addmerchant() {
        AmazonShopping.clear();
        System.out.print("Enter Name : ");
        String name = sc.next();
        System.out.print("Enter Password : ");
        String pass = sc.next();
        merchants.add(new Admin(name, pass, ++merchant_id, true));
        System.out.println("New Merchant id : " + merchant_id);
        System.out.println("Merchant Added");
        System.out.println("Press enter to continue...");
        try {
   System.in.read();
   AdminMain();
     } catch (Exception e) {
}
    }

    static void Removemerchant() {
        AmazonShopping.clear();
        System.out.print("Enter Merchant Id to remove Merchant : ");
        int id = sc.nextInt();
        for (int i = 0; i < merchants.size(); i++) {
            if (id == merchants.get(i).MerchantId) {
                merchants.remove(i);
                System.out.println("Merchant Removed");
            }
        }
        System.out.println("Press enter to continue...");
        try {
   System.in.read();
   AdminMain();
     } catch (Exception e) {
}
    }

    static void Approvemerchant() {
        int count = 0;
        System.out.println("List of Unapproved merchants");
        for (Admin admin : merchants) {
            if (admin.MerchantStatus == false) {
                System.out.println(admin.MerchantId + "--" + admin.MerchantName);
                count++;
            }
        }
        if (count != 0) {
            System.out.print("Enter Merchant id to Approve : ");
            int id = sc.nextInt();
            System.out.print("Do you want to Approve (y/n) : ");
            String approve = sc.next();
            if (approve.equals("y")) {
                for (Admin admin : merchants) {
                    if (admin.MerchantId == id && !(admin.MerchantStatus)) {
                        admin.MerchantStatus = true;
                        System.out.println("Merchant Approved");
                    }
                }
            }
        }
        System.out.println("Press enter to continue...");
        try {
   System.in.read();
   AdminMain();
     } catch (Exception e) {
}
    }
    

}

class Merchant{
    private static Scanner sc = new Scanner(System.in);

    static void MerchantLogin() {
       
            AmazonShopping.clear();
            System.out.println("Welcome to Merchant Panel");
            System.out.println("\n1. New Merchant(Self Registration)\n2. Existing Merchant\n3. Exit");
            System.out.print("\nEnter your choice : ");
            int choice = sc.nextInt();
            if (choice == 1) {
                AmazonShopping.clear();
                System.out.println("Note..\nSelf Registration must include \nAdmin Verification to use this Applicatin\nPlease wait till Admin approve.");
                MerchantRegister();
                System.out.println("Press enter to continue...");
                try {
               System.in.read();
              AmazonShopping.AmazonMain();
             } catch (Exception e) {
        }
            } else if (choice == 2) {
                AmazonShopping.clear();
                System.out.print("Enter your Id : ");
                int id = sc.nextInt();
                System.out.print("Enter your Pass : ");
                String pass = sc.next();
                for (int i = 0; i < Admin.merchants.size(); i++) {
                    if (id == Admin.merchants.get(i).MerchantId && pass.equals(Admin.merchants.get(i).MerchantPassword)) {
                        if (Admin.merchants.get(i).MerchantStatus == true) {
                            MerchantMain(i);
                            break;
                        } else {
                            System.out.println("\nYour Id is still pending to verify\nSo wait till Admin Approval");
                            System.out.println("Press enter to continue...");
                            try {
                       System.in.read();
                       AmazonShopping.AmazonMain();
                         } catch (Exception e) {
                    }
                        }
                    } else {
                        System.out.println("Username and password is invalid");
                        System.out.println("Press enter to continue...");
                        try {
                   System.in.read();
                   AmazonShopping.AmazonMain();
                     } catch (Exception e) {
                }
                    }
                }
                System.out.println("Press enter to continue...");
                            try {
                       System.in.read();
                       AmazonShopping.AmazonMain();
                         } catch (Exception e) {
                    }
            } else if (choice == 3) {
               AmazonShopping.AmazonMain();
            } else {
                System.out.println("Invalid");
                System.out.println("Press enter to continue...");
                try {
           System.in.read();
           AmazonShopping.AmazonMain();
             } catch (Exception e) {
        }

            }
       
    }

    static void MerchantRegister() {
        System.out.print("\nEnter name : ");
        String name = sc.next();
        System.out.print("Enter pass : ");
        String pass = sc.next();
        Admin.merchants.add(new Admin(name, pass, Admin.merchant_id, false));
        System.out.println(
                "\nNew merchant Created\nBut wait till Admin Approval\nNew Merchant id : " + Admin.merchant_id);
    }

    static void MerchantMain(int currentuser) {
       
            AmazonShopping.clear();
            System.out.println("Welcome " + Admin.merchants.get(currentuser).MerchantName + "");
            System.out.println("1. Add Products");
            System.out.println("2. Update Productst");
            System.out.println("3. Remove Productst");
            System.out.println("4. Exit");
            System.out.print("Enter your Option : ");
            int choice = sc.nextInt();
            if (choice == 1) {
                addproducts(currentuser);
            } else if (choice == 2) {
                updateproducts(currentuser);
            } else if (choice == 3) {
                removeproducts(currentuser);
           
            } else if (choice == 4) {
                AmazonShopping.AmazonMain();
            } else {
                System.out.println("Invalid Option");
                System.out.println("Press enter to continue...");
                try {
           System.in.read();
           AmazonShopping.AmazonMain();
             } catch (Exception e) {
        }
            }
       
    }

    static void addproducts(int currentuser) {
        AmazonShopping.clear();
        List<String> product = new ArrayList<>();
        System.out.print("Enter product name : ");
        String pro_name = sc.next().toLowerCase();
        System.out.print("Enter count of the product : ");
        product.add(sc.next());
        System.out.print("Enter product prize : ");
        product.add(sc.next());
        Admin.merchants.get(currentuser).MerchantProducts.put(pro_name, product);

        System.out.println("Press enter to continue...");
        try {
   System.in.read();
   MerchantMain(currentuser);
     } catch (Exception e) {
}
    }

    static void updateproducts(int currentuser) {
        System.out.println("List of Products\n");
        Products(currentuser);
        System.out.print("\nEnter product to Update : ");
        String toUpdateproduct = sc.next().toLowerCase();
        System.out.print("Enter Count to Update(if don't update enter 0) : ");
        String pro_count = sc.next();
        System.out.print("Enter prize to Update(if don't update enter 0) : ");
        String pro_prize = sc.next();
        updatevalueinmap(currentuser, toUpdateproduct, pro_count, pro_prize);
        Products(currentuser);
        System.out.println("\nproduct Update successfully");
        System.out.println("Press enter to continue...");
        try {
   System.in.read();
   MerchantMain(currentuser);
     } catch (Exception e) {
}

    }

    static void Products(int currentuser) {
        Admin k = Admin.merchants.get(currentuser);
        System.out.printf("%-10s%-20s%-20\n","products","count","Prize");
        for (String name : k.MerchantProducts.keySet()) {
            List<String> li = k.MerchantProducts.get(name);
                System.out.printf("%-10s%-20s%-20\n", name , li.get(0) , li.get(1));
            
        }
        

        System.out.println("Press enter to continue...");
        try {
   System.in.read();
   MerchantMain(currentuser);
     } catch (Exception e) {
}
    }

    static void updatevalueinmap(int currentuser, String product, String count, String prize) {
        Admin k = Admin.merchants.get(currentuser);
        List<String> li = new ArrayList<>();
        String oldcount = k.MerchantProducts.get(product).get(0);
        String oldprize = k.MerchantProducts.get(product).get(1);
        if (count.equals("0"))
            li.add(oldcount);
        else
            li.add(count);
        if (prize.equals("0"))
            li.add(oldprize);
        else
            li.add(prize);
        k.MerchantProducts.put(product, li);

        System.out.println("Press enter to continue...");
        try {
   System.in.read();
   MerchantMain(currentuser);
     } catch (Exception e) {
}
    }

    static void removeproducts(int currentuser) {
        Products(currentuser);
        System.out.print("\nEnter product to remove : ");
        String product = sc.next();
        Admin.merchants.get(currentuser).MerchantProducts.remove(product);
        Products(currentuser);
        System.out.println("Press enter to continue...");
        try {
   System.in.read();
   MerchantMain(currentuser);
     } catch (Exception e) {
}
    }
}
class Buyer{
    private static Scanner sc = new Scanner(System.in);
    static int Buyergen = 101;

    

    public String BuyerName, BuyerPassword;
    public int BuyerId;
    static String  caller="User";

    Buyer(String name, String pass, int id) {
        this.BuyerName = name;
        this.BuyerPassword = pass;
        this.BuyerId = id;
    
    }
    static List<String>purchase=new ArrayList<>();
    static List<String>cart=new ArrayList<>();
    static List<Buyer> BuyersList = new ArrayList<>();

    static void BuyerLogin() {
        
            AmazonShopping.clear();
            System.out.println("1. Buyer New self Registration");
            System.out.println("2. Existing Buyer Login");
            System.out.println("3. Exit");
            System.out.println();
            System.out.print("Enter your option : ");
            int ch = sc.nextInt();
            if (ch == 1) {
                BuyerRegister();
            } else if (ch == 2) {
                AmazonShopping.clear();
                System.out.println(BuyersList.toString());
                System.out.print("Enter your name : ");
                String name = sc.next();
                System.out.print("Enter password : ");
                String pass = sc.next();
                for (int i = 0; i < BuyersList.size(); i++) {
                    if (name.equals(BuyersList.get(i).BuyerName) && pass.equals(BuyersList.get(i).BuyerPassword)) {
                        Buyer_existing(i);
                        break;
                    } else {
                        System.out.println("Invalid Credtial");
                    try {
                    System.in.read();
                    BuyerLogin();
                  } catch (Exception e) {
                   }
                    }
                }
            } else if (ch == 3) {
                AmazonShopping.AmazonMain();
               
            } else {
                System.out.println("Invalid Option");
                try {
                    System.in.read();
                    BuyerLogin();
                } catch (Exception e) {
                }
            }
    }


    static void BuyerRegister() {
        AmazonShopping.clear();
        System.out.print("Enter name : ");
        String name = sc.next();
        System.out.print("Enter Password : ");
        String pass = sc.next();
        BuyersList.add(new Buyer(name, pass, ++Buyergen));
        System.out.println("New Buyer created successfully");
       
                try {
                    System.in.read();
                    BuyerLogin();
                } catch (Exception e) {
                }
    }

    static void Buyer_existing(int currentBuyer) {
        
            AmazonShopping.clear();
            System.out.println("Welcome " + BuyersList.get(currentBuyer).BuyerName + " -----");
            System.out.println("1. View Products");
            System.out.println("2. buy product");
            System.out.println("3. Add products to cart");
            System.out.println("4. View purchasehase history");
            System.out.println("5. View ");
            System.out.println("6. Back");
            System.out.println();
            System.out.println("Enter your Option : ");
            int ch = sc.nextInt();
            if (ch == 1) {
                Viewproductsdetails(currentBuyer);
            } 
            else if (ch == 2) {
                if(Admin.merchants.size()==0){
                    System.out.println("No products Available");
                    System.out.println("Press enter to continue...");
                    try {
                    System.in.read();
                    Buyer_existing(currentBuyer);;
                    } catch (Exception e) {
                  }
                }
                else if(Admin.merchants.size()>0){
                    
                
                Viewproducts();
                System.out.println("Enter the product name");
                String na=sc.next();
                System.out.println("Enter the count");
                int co=sc.nextInt();
               System.out.println("Press Enter");
                sc.nextLine();
                int g=Integer.parseInt(Admin.merchants.get(currentBuyer).MerchantProducts.get(na).get(0));
                if(co<=g){
                g-=co;
                System.out.println("Product purchasehased");
                
                Admin.merchants.get(currentBuyer).MerchantProducts.get(na).set(0,Integer.toString(g));

                purchase.add(na+" "+Integer.toString(co));
                System.out.println("press Enter");
                
                sc.nextLine();
                

                }else{
                    if(g==0){
                        System.out.println("product solded out");
                        System.out.println("Press enter to continue");
                        try {
                        System.in.read();
                        Buyer_existing(currentBuyer);;
                        } catch (Exception e) {
                      }
                    }
                    else{
                        System.out.println("please enter count within "+g);
                        System.out.println("Press enter to continue");
                    try {
                    System.in.read();
                    Buyer_existing(currentBuyer);;
                    } catch (Exception e) {
                  }
                    }
                }
            }
        }
            else if (ch == 3) {
                if(Admin.merchants.size()==0){
                    System.out.println("No products Available");
                    System.out.println("Press enter to continue");
                    try {
                    System.in.read();
                    Buyer_existing(currentBuyer);;
                    } catch (Exception e) {
                  }
                }
                else if(Admin.merchants.size()>0){
                    
                
                Viewproducts();
                System.out.println("Enter the product name to add to your cart ");
                String na=sc.next();
                System.out.println("Enter the count");
                int co=sc.nextInt();
               System.out.println("Press Enter");
                sc.nextLine();
                int g=Integer.parseInt(Admin.merchants.get(currentBuyer).MerchantProducts.get(na).get(0));
                if(co<=g){
                
                System.out.println("Product added to cart succesfully");
                

                cart.add(na+" "+Integer.toString(co));
                System.out.println("press Enter to continue");
                
                sc.nextLine();
                

                }else{
                    if(g==0){
                        System.out.println("product sold out");
                        System.out.println("Press enter to continue...");
                    try {
                    System.in.read();
                    Buyer_existing(currentBuyer);;
                    } catch (Exception e) {
                  }
                    }
                    else{
                        System.out.println("please enter count within "+g);
                        System.out.println("Press enter to continue...");
                    try {
                    System.in.read();
                    Buyer_existing(currentBuyer);;
                    } catch (Exception e) {
                  }
                    }
                }
            }
                
            } else if (ch == 4) {
                System.out.println("purchasehase history");
                for(String i:purchase){
                    System.out.println(i);
                }
               
            }
            else if(ch==5){
                System.out.println("Product available in cart");
                for(String d:cart){
                    System.out.println(d);
                }
                System.out.println("Press enter to continue...");
                    try {
                    System.in.read();
                    Buyer_existing(currentBuyer);;
                    } catch (Exception e) {
                  }
            } else if (ch == 6) {
               AmazonShopping.AmazonMain();
            } else {
                System.out.println("Invalid Option");
                System.out.println("Press enter to continue...");
                    try {
                    System.in.read();
                    Buyer_existing(currentBuyer);;
                    } catch (Exception e) {
                  }
            }
       
    }

    static void Viewproducts() {
        System.out.printf("%-10s%-20s%-20\n","products","count","Prize");
        for (int i = 0; i < Admin.merchants.size(); i++) {
            Admin k = Admin.merchants.get(i);
            for (String name : k.MerchantProducts.keySet()) {
                List<String> li = k.MerchantProducts.get(name);
                System.out.printf("%-10s%-20s%-20\n", name , li.get(0) , li.get(1));
            }
        }
        
       
    }

    static void Viewproductsdetails(int currentBuyer) {
        System.out.printf("%-10s%-20s%-20\n","products","count","Prize");
        for (int i = 0; i < Admin.merchants.size(); i++) {
            Admin k = Admin.merchants.get(i);
            for (String name : k.MerchantProducts.keySet()) {
                List<String> li = k.MerchantProducts.get(name);
                System.out.printf("%-10s%-20s%-20\n", name , li.get(0) , li.get(1));
            }
        }
        System.out.println("Press enter to continue...");
        try {
        System.in.read();
        Buyer_existing(currentBuyer);;
        } catch (Exception e) {
      }
        
       
    }
}