/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodcarteing;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 
 */
public class FoodCarteing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
         Scanner in= new Scanner(System.in);
        // loyalityCust loyalObj = new loyalityCust();
        customer guest = new guest_cust();
        customer loyalObj = new loyalityCust();
          menu MenuObj = new menu();
        Order orderObj = new Order();
         String choice = "";
         MenuObj.add_food("drinks", "cola",180 , 1 ,7.0); 
         MenuObj.add_food("drinks", "pepsi",180, 1 ,5.5); 
         MenuObj.add_food("appertizers", "cake",580 , 1 ,15.0); 
         MenuObj.add_food("appertizers", "iceCream",580 , 1 ,3.0); 
         MenuObj.add_food("main_dishes", "chicken",560 , 2 ,25.3);
         MenuObj.add_food("main_dishes","chrimp", 180, 2, 38.0);
         
         System.out.println("*************WELCOME************");
         System.out.println("------------------------------------------------------------------------------------------------------------------");
          System.out.println( "Click: "+'\n'+"1 to add order "+'\n'+" 2 to update order"+'\n'+" 3 to show order ");
          System.out.println("4- add to wish list"+'\n'+"5- to delete from wish list"+'\n'+"6 - to cancel the order");
          System.out.println("7- get delivery date"+'\n'+"8- to get order date");
             System.out.println(" 9 -to remove certain meal from order "+'\n'+"10-to show what in menu "+'\n'+"11- toshow if certain meal in menu or not");
           System.out.println("12- to set order date"+'\n'+"13- to show whish list" +'\n'+"14-set delivary date"+'\n'+"15- Clear whole order");
            System.out.println("------------------------------------------------------------------------------------------------------------------");
            System.out.println("enter your choice and enter y to exit");
            
       while (!"y".equals(choice)){
           choice=in.next();
           
             switch (choice) {
                 case "1":
                     orderObj.add_Order("cola", MenuObj);
                     orderObj.add_Order("cake", MenuObj);
                     orderObj.add_Order("chicken", MenuObj);
                     System.out.println("If you are a loyal customer please enter the loyality code To get your reward (code is abc1 ):");
                     String code = in.next();
                     if( code.equals(loyalObj.Loyality_code)){
                         
                         loyalObj.make_order(orderObj, MenuObj);
                     }else{
                         guest.make_order(orderObj, MenuObj);
                     }       break;
                 case "2":
                     System.out.println("Enter index of element u want to update :");
                     int indx = in.nextInt();
                     orderObj.update(indx, MenuObj);
                     break;
                 case "3":
                     System.out.println("Your have ordered :");
                     orderObj.show_order(MenuObj);
                     break;
                 case "4":
                     {
                         System.out.println("Enter name of meal you want to add to whish list ");
                         String meal = in.next();
                         loyalObj.add_toThe_WishList(meal);
                         break;
                     }
                 case "5":
                     {
                         System.out.println("Enter name of meal you want to delete from whish list ");
                         String meal = in.next();
                         loyalObj.delete_from_wishList(meal);
                         break;
                     }
                 case "6":
                     orderObj.cancel_order(0);
                     break;
                 case "7":
                     orderObj.getDelivery();
                     break;
                 case "8":
                     orderObj.getOrder_date();
                     break;
                 case "9":
                     {
                         System.out.println("Enter name of meal you want to remove ");
                         String meal = in.next();
                         orderObj.remove_order_item(meal);
                         break;
                     }
                 case "10":
                      MenuObj.show();
                     break;
                   
                 case "11":
                     System.out.println("Enter name of meal you want to show all about ");
                     String name = in.next();
                     MenuObj.show(name);
                     break;
                 case "12":
                     orderObj.setOrder_date(9, 6);
                 case "13":
                      loyalObj.show_wishList();
                     break;
                 case "14":
                      System.out.println("Enter the day and the month please");
                     int day = in.nextInt();
                     int month = in.nextInt();
                     orderObj.setOrder_date(day, month);
                     break;
                     case"15":
                         orderObj.clear_order();
                         break;
                 default:
                     break;
             }
       }
    
      }
    }  


class foodItem {
    
    protected String name;
     protected String category;
     protected int calories;
     protected int portion;
     protected double price;
     
     
     
     // constructor

    public  foodItem() {
        
    }
/**
 * @param name
    @param category
    * @param calories
    * @param portion
    * @param price
    */
    public foodItem(String name, String category, int calories, int portion ,double price) {
        this.name = name;
        this.category = category;
        this.calories = calories;
        this.portion = portion;
      this.price = price;
     
    }
    
    
}

class menu extends foodItem{
    protected  ArrayList<foodItem> appertizers;
    protected ArrayList<foodItem> drinks ;
    protected ArrayList<foodItem> main_dishes;

    public menu() {
        this.main_dishes = new ArrayList<foodItem>();
        this.drinks =  new ArrayList<foodItem>();
        this.appertizers =  new ArrayList<>();
    }
    /**
     * 
     * @param category
     * @param name
     * @param calories
     * @param portion
     * @param price 
     */
    public final void add_food(String category, String name, int calories , int portion , double price){
        
        if(null != category)switch (category) {
            case "appertizers":{
                appertizers.add(new foodItem(name , category , calories,portion,price));
                  //System.out.println("Thank You <3");
                break;}
            case "main_dishes":{
                main_dishes.add(new foodItem(name , category , calories,portion,price));
                
                    //System.out.println("Thank You <3");
                    break;
                }
            case "drinks":{
                drinks.add(new foodItem(name , category , calories,portion,price));
               
                   // System.out.println("Thank You <3");
                     break;
                }
            default:
               
                break;
        }
    }
    /**
     * overloading
     * @param nam 
     */
     public void show( String nam){
  boolean  found = false;
     
         for(int i = 0 ; i < appertizers.size(); i++){
          if(appertizers.get(i).name .equals(nam)){
     System.out.println("the name is"+ " " + appertizers.get(i).name + "the calories" +" "+appertizers.get(i).calories + " portion"+ " "+ appertizers.get(i).portion
     + "category :" + " "+ appertizers.get(i).category +"its price" + " "+ appertizers.get(i).price);
     found = true;
break;
     }}
  
          for(int i = 0 ; i < drinks.size(); i++){
          if(drinks.get(i).name .equals(nam)){
     System.out.println("the name is"+ " " + drinks.get(i).name + "the calories" +" "+drinks.get(i).calories + " portion"+ " "+ drinks.get(i).portion
     + "category :" + " "+ drinks.get(i).category +"its price" + " "+ drinks.get(i).price);
  found = true;
     break;
     
          }
      }
      for(int i = 0 ; i < main_dishes.size(); i++){
          if(main_dishes.get(i).name .equals(nam)){
     System.out.println("the name is"+ " " + main_dishes.get(i).name + "the calories" +" "+main_dishes.get(i).calories + " portion"+ " "+ main_dishes.get(i).portion
     + "category :" + " "+ main_dishes.get(i).category +"its price" + " "+ drinks.get(i).price); found = true;
break;
     }
      }
      if( found == false){
      System.out.println("Not exist... please add it");
      }
      
    }
    
    /**
     * overloading
     */
    public void show( ){

     System.out.println("****************APPERTIZERS*********");
         for(int i = 0 ; i < appertizers.size(); i++){

     System.out.println("the name is"+ " " + appertizers.get(i).name + "the calories" +" "+appertizers.get(i).calories + " portion"+ " "+ appertizers.get(i).portion
     + "category :" + " "+ appertizers.get(i).category +"its price" + " "+ appertizers.get(i).price);

     }
     System.out.println("****************DRINKS*********");
          for(int i = 0 ; i < drinks.size(); i++){

     System.out.println("the name is"+ " " + drinks.get(i).name + "the calories" +" "+drinks.get(i).calories + " portion"+ " "+ drinks.get(i).portion
     + "category :" + " "+ drinks.get(i).category +"its price" + " "+ drinks.get(i).price);
  
      }
      
      System.out.println("****************MAIN DISHES*********");
      for(int i = 0 ; i < main_dishes.size(); i++){

     System.out.println("the name is"+ " " + main_dishes.get(i).name + "the calories" +" "+main_dishes.get(i).calories + " portion"+ " "+ main_dishes.get(i).portion
     + "category :" + " "+ main_dishes.get(i).category +"its price" + " "+ drinks.get(i).price);


      }
      
    }
}

        
 class Order {
 /*string array list to carry orders names in it*/
public ArrayList<String> order;
/* order unique code*/
 public static int orderNumber = 0;
 private int order_date_day;
  private int  order_date_month;
  private int delivery;
 private String customer_nam;
private double price;
  private final Date now;//to bring current date from operating system(final method)
  menu b = new menu();
  
/**
 * getter
 */
    public void getOrder_date() {
      System.out.println(order_date_day +"/" + order_date_month) ;
    }
/**
 * setter*/
    public void setOrder_date(int day, int month ) {
        this.order_date_day = day;
        this.order_date_month = month;
       
    }
 
    public Order () {
       now = new Date();
        order = new ArrayList<String>(); // keep the name of meals in this array list 
         this.order_date_day = 0;
        this.order_date_month = 0;
        this.delivery = 0;
        this.price = 0f;
        orderNumber++;//each time we call constructor it will incerement to get the number of order
   }
    
/**
 * add a meal to order list
 * @param nam
 * @param c 
 */
   public  void add_Order(String nam, menu c){
       
       boolean found = false;
   for(int i = 0 ; i < c.appertizers.size() ; i++ ){
       
   if(c.appertizers.get(i).name.equals(nam)){
       order.add(nam );
     found = true;
      System.out.println("Information about your Meal:");
   c.show(nam);
   }
   }
 for(int i = 0 ; i < c.drinks.size() ; i++ ){
   if(c.drinks.get(i).name.equals(nam)){
       order.add( nam);
      found = true;
        System.out.println("Information about your Meal:");
   c.show(nam);
   }
   }   
 for(int i = 0 ; i < c.main_dishes.size() ; i++ ){
   if(c.main_dishes.get(i).name.equals(nam)){
       order.add(nam);
        found = true;
          System.out.println("Information about your Meal:");
   c.show( nam);
   }}
 if(! found){
     System.out.println("Not Exist");
 }else{
     System.out.println("Done order added .. ");
 } 
      
 
   } 
 /**
  * remove certain meal by its name
  * @param item 
  */
    public void remove_order_item(String item){
    order.remove(item);
    System.out.println("Done removing..");
    }
   
   /**
    * delete all elements in order list
    */
   public void clear_order(){
   order.clear();
    System.out.println("Done clearing..");
   }
   
   /**
    * 
    * @param index
    * @return 
    */
    public String get_order_item(int index){
       return order.get(index);
       
   }
   /**
    *static method 
    * @return 
    */
    public static int get_orderNumb(){
    return orderNumber;
    }
  
    /**
     * 
     * @return Return delivery date
     */
    public int getDelivery() {
        return delivery;
    }
/**
 * add days user want to extend to delivery date
 * @param delivery_after 
 */
    public  void setDelivery(int delivery_after) {
       delivery += delivery_after;
    }
    /**
     * 
     * @param e
     * @param isloyal
     * @return Return double total price
     */
    public double calculate_total_price(menu e , boolean isloyal) {
      price = 0f;
       
     for(int j = 0 ; j < order.size() ; j++){
       for(int i = 0 ; i < e.drinks.size(); i++ ){
           if(e.drinks.get(i).name.equals(order.get(j)))
           price += e.drinks.get(i).price;
       }
        for(int i = 0 ; i < e.appertizers.size(); i++ ){
           if(e.appertizers.get(i).name.equals(order.get(j)))
           price += e.appertizers.get(i).price;
               }
         for(int i = 0 ; i < e.main_dishes.size(); i++ ){
           if(e.main_dishes.get(i).name.equals(order.get(j)))
           price += e.main_dishes.get(i).price;
               }}
       if(!isloyal){
       System.out.println( price);
        return price - (price *2)/10;
       }else{
       System.out.println( price);
       return price - 25;
       }
       }
     
   /**
    * @exception user defines exception
    * @param index 
    */ 
 public void cancel_order(int index) {
 boolean error = false;

  try{
  if( order_date_month < now.getMonth() || (order_date_day <= now.getDate())){ 
     
  error = true;
  throw new MakeException(" Sorry cant cancel ordern !");
  }
 }catch(MakeException exn){
 System.out.println("error"+ exn.getMessage());
 }
  if(!error){
 String a = get_order_item(index);
  remove_order_item(a);
  System.out.println("Done Deleting");
 }
 }
 /**
  * 
  * @param e 
  */
    public void show_order(menu e){
        
        for(int i = 0 ; i < order.size() ; i++){
        System.out.println(order.get(i));
        }
    } 

    /**
     * update order  
     * @param index
     * @param e 
     */
  public void update(int index, menu e){
Scanner in= new Scanner(System.in);
 String choice , a;
 a = get_order_item(index);

 System.out.println("enter what u want to update : press y to delete item / press yy to add extra item / press yyy extend delivary date" );
  choice =in.next();
  if( null != choice)switch (choice) {
        case "y":
            remove_order_item(a);
            break;
        case "yy":
            // hard coded to not take input from user,u can change attributes as u want
            e.add_food("drinks", "cola",5 , 1 ,7);
            e.show();
            System.out.println("enter name of meal you want to add");
            String name = in.next();
            add_Order( name , e);
            break;
        case "yyy":
            int date;
            System.out.println("enter number of days u want to extend " );
            date =in.nextInt();
            setDelivery(date);
            break;
        default:
            break;
    }
  }
 
  }

class MakeException extends Exception{
public MakeException(String message_error){
super(message_error);
}
}

 abstract class customer {
    
    //protected ArrayList<ArrayList<foodItem>> whish_list ;
   protected  ArrayList<String> add_wish;
   /*loyality code to differentiate between loyal and guest in main*/
    public static String Loyality_code = "abc1";
    protected boolean issue;
/**
 * 
 * @return if there is an issue 
 */
    public boolean isIssue() {
        return issue;
    }
/**
 * to set complain
 * @param issue 
 */
    public void setIssue(boolean issue) {
        this.issue = issue;
    }
    
    customer(){
       add_wish = new ArrayList<String>();
        issue = false;
   
    }
/**
 * 
 * @param index
 * @param c 
 */
     public void Cancel_cust_order(int index , Order c){
     c.cancel_order(index);
     }
     /**
      * abstract method
      * @param s
      * @param e 
      */
     public  abstract void make_order( Order s ,menu e); 
     /**
      * static method
      * @param items 
      */
     public final void add_toThe_WishList(String items){
    add_wish.add(items);
     System.out.println("Done adding to wishlist");
     }
     /**
      * final method to show what in wish list
      */
     public  void show_wishList(){
     for(int i = 0 ; i < add_wish.size();i++){
     System.out.println("name is:"+'\t' + add_wish.get(i)); 
      System.out.println("if you want to add them pleae choose Add order");
     }
     }
     /**
      * overloading
      * delete from whish list by index
      * @param index 
      */
     public void delete_from_wishList(int index){
     add_wish.remove(0);
     }
     /**
      * overloading
      * delete from whish list by name of meal
      * @param items 
      */
     public void delete_from_wishList(String items){
     add_wish.remove(items);
     }
}

 class loyalityCust extends customer{

    public loyalityCust(){}
    /**
     * 
     * @param s
     * @param k 
     */
    @Override
    public void make_order( Order s,menu k) {
      boolean error = false;
       try{
       if(s.order.isEmpty()){
       error = true;
       throw new Exception("Add a meal plaese !!!");
       }
       }
       catch(Exception ex){
           
           Logger.getLogger(FoodCarteing.class.getName()).log(Level.SEVERE, null, ex);
       }
       if(! error){
       System.out.println("A drink and 2 appertizers added succesfully to your order  Thanks <3");
     // adding reward to order of loyal customer
       s.add_Order("cola",k);
       s.add_Order("cake",k);
       s.add_Order("iceCream",k);
       double pricee = s.calculate_total_price(k, true);
        System.out.println("the total price after your reward will be:" + pricee);
      
      
       }
    }  
}

class guest_cust extends customer{

    public guest_cust(){}
    /**
     * 
     * @param s
     * @param e 
     */
    @Override
    public void make_order( Order s, menu e) {
     
      boolean error = false;
       try{
       if(s.order.isEmpty()){
       error = true;
       throw new Exception("Add a meal plaese !!!");
       }
       }
       catch(Exception ex){
           
           Logger.getLogger(FoodCarteing.class.getName()).log(Level.SEVERE, null, ex);
       }
       if(! error){
           
           double pricee = s.calculate_total_price(e, false);
           System.out.println("the total price after your discound will be:" );
           System.out.println( pricee);//making discound 20% to guest order
           
       }
 }
    
}
 interface RestaurantInterface {           //interface
  public  void set_clientName(String name);
  public String get_clientName();
  public  void takeTelephoneOrder();
  public  void set_clientAddres(String Address);
  public String get_clientAddress();
  public  void payWhenArrive();
}
 class telephone_order implements RestaurantInterface{
     
     String name;
     String Address;
         /**
          * 
          * @param name 
          */    
  @Override
 public  void set_clientName(String name) {
    this.name = name;
  }
 /**
  * 
  * @return 
  */
 public String get_clientName(){
 return name;
 }
 /**
  * 
  * @return 
  */
   public String get_clientAddress(){
   return Address;
   }
 /**
  * unsupported option to throw exception
  */
  @Override
  public void takeTelephoneOrder() {
    
    throw new UnsupportedOperationException();      
  }
  /**
   * 
   * @param Address 
   */
  @Override
 public  void set_clientAddres(String Address) {
    this.Address = Address; 
  }
  @Override
  public void payWhenArrive() {
    System.out.println("Please check when your order arrive");
  }
}