/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tongyongwei_assignment;

import java.util.Scanner;
/**
 *
 * @author User
 */
public class YongElectricalShop  {
        static String [] ElectricalDevice = {"Samsung 4K Smart TV","Sharp 12kg Washing Machine","Daikin FTV-A Air Conditioner","Panasonic Blade Ceiling Fan","Toshiba 24L Microwave Oven"};
        static int numberOfItem = ElectricalDevice.length;
        static double [] price = {2359.00, 1399.00, 1540.00, 399.00,560.00};
        static int [] quantity_device = new int[numberOfItem];
        static double [] subTotal = new double[numberOfItem];
        static double total;
        static int [] discount = {2,4,6,8,10} ;
        static int subDiscount ;
        static double[]discount_price = {3000.00,5000.00,7000.00,9000.00,11000.00};
        static int numberofDiscount = discount.length;
        static double priceAfterDiscount;
        public static void main(String[] args){
            int choice=0 ;
            Scanner input = new Scanner(System.in);
            
          while(choice != 6){
            System.out.println("\n\nWelcome to Yong Electrical Shop");
            System.out.println("1. Electrical Device");
            System.out.println("2. Add Device");
            System.out.println("3. Discaunt");
            System.out.println("4. Cancel Purchase");
            System.out.println("5. Print Bill");
            System.out.println("6. Exit");
            System.out.println("Enter your choice");
            choice = input.nextInt();
            
            switch(choice){
                case 1:
                       ElectricalDevice();
                       break;
                case 2:
                       AddDevice();
                       break;
                case 3:
                       Discount();
                       break;
                case 4:
                      Cancel();
                       break;
                       
                case 5:
                      PrintBill();
                       break;
                       
                case 6:
                       System.out.println("Thank You!! Come Again Next Time");
                       break;
                default:
                        System.out.println("Invalid Option,Please select again");
            }
          }
        }   
            
    
    public static void ElectricalDevice( ){    
       
    
            Scanner input = new Scanner(System.in);
                System.out.printf("\n Welcome to Yong Electrical Shop");
		System.out.printf("\n%-28s %-18s","============================", "\t==================");
		System.out.printf("\n%-28s %-18s", "Electrical Device","\t\tPrice(RM) ");
		System.out.printf("\n%-28s %-18s", "============================", "\t==================\n");
                  for(int i=0; i<numberOfItem; i++) {
			System.out.printf("%-35s %10.2f\n", "["+(i+1)+"]" + "  " + ElectricalDevice[i], price[i]);
		}
                  System.out.println("\nEnter your choice: ");
                  int deviceChoice = input.nextInt();
                  System.out.println("\nEnter your quantity: ");
                  int quantity = input.nextInt();
        
                    switch (deviceChoice) {
                                      case 1:
                                             quantity_device[0] += quantity;
				             subTotal[0] = quantity_device[0] * price[0];
                                             break;
                                      case 2:
                                            quantity_device[1] += quantity;
				            subTotal[1] = quantity_device[1] * price[1];
                                            break;
                                      case 3:
                                            quantity_device[2] += quantity;
				            subTotal[2] = quantity_device[2] * price[2];
                                            break;
                                      case 4:
                                            quantity_device[3] += quantity;
				            subTotal[3] = quantity_device[3] * price[3];
                                            break;
                                      case 5:
                                            quantity_device[4] += quantity;
				            subTotal[4] = quantity_device[4] * price[4];
                                            break;
                                      default:
			                     System.out.println("Invalid input");
               } 
                                      PrintBill();
        }  
           
         public static void AddDevice(){   
             ElectricalDevice();
        }
    
         public static void Discount(){
             System.out.printf("\n Welcome to Yong Electrical Shop");
		System.out.printf("\n%-20s %-10s","====================", "==============================");
		System.out.printf("\n%-20s %-10s", "Discaunt(%)", "Buy More Than This Price(RM) ");
		System.out.printf("\n%-20s %-10s", "====================", "==============================\n");
                    for(int i=0; i<numberofDiscount; i++) {
			System.out.printf("%-20s %10.2f\n", "["+(i+1)+"]" + "  " + discount[i], discount_price[i]);
                    }      
                    
                     if(total == 0)
                     System.out.println("You Buy Nothing!!!");
                    
                     else if (total < 3000)
                      System.out.println("You Need To Buy More Than Three Thousand!!!");
                    
                     else if(total >= 11000 )
                            subDiscount = discount[4] ;
       
                     else if(total >= 9000 )
                            subDiscount = discount[3] ;
       
                     else if(total >= 7000)
                            subDiscount = discount[2] ;
       
                     else if(total >= 5000)
                            subDiscount = discount[1] ;
       
                     else if(total >= 3000)
                            subDiscount = discount[0] ;
                        
                     if(total>3000){   
                    priceAfterDiscount=(total-(total*subDiscount/100));
                    System.out.println("You are Entitle for Discount " + subDiscount + "%");
                    System.out.println("The Payable Price is RM" + priceAfterDiscount);
               
        } 
          
         }

         public static void Cancel(){
             Scanner input = new Scanner(System.in);
		System.out.printf("\n%-20s", "====================");
		System.out.printf("\n%-20s", "Cancel purchase");
		System.out.printf("\n%-20s", "====================\n");
		
		PrintBill() ;
        
		boolean isBuy = false;
		
		for(int i=0; i<numberOfItem; i++) {
			if(quantity_device[i] > 0) 
				isBuy = true;
		}
		
		if(!isBuy)
			return;
		
		System.out.println("\nEnter your choice: ");
                int deviceChoice = input.nextInt();
                System.out.println("\nEnter your quantity: ");
                int quantity = input.nextInt();
        
        switch (deviceChoice) {
            case 1:
			     if(quantity_device[0] >= quantity) {
					quantity_device[0] -= quantity;
					subTotal[0] = quantity_device[0] * price[0];
				}
                                 break;
            case 2:
				if(quantity_device[1] >= quantity) {
					quantity_device[1] -= quantity;
					subTotal[1] = quantity_device[1] * price[1];
				}
                                 break;
            case 3:
				if(quantity_device[2] >= quantity) {
					quantity_device[2] -= quantity;
					subTotal[2] = quantity_device[2] * price[2];
				}
                                 break;
            case 4:
				if(quantity_device[3] >= quantity) {
					quantity_device[3] -= quantity;
					subTotal[3] = quantity_device[3] * price[3];
				}
                                 break;
            case 5:
                                if(quantity_device[4] >= quantity) {
					quantity_device[4] -= quantity;
					subTotal[4] = quantity_device[4] * price[4];
				}
                                break;
            default:
				System.out.println("Invalid input");
        }
        
		PrintBill(); 
               
             
     }
         
         
         
          public static void PrintBill(){
             
                total=0;
		boolean isBuy = false;
                System.out.printf("\n%-35s %-15s %-9s %-13s", "===================================", "===============", "=========", "=============");
		System.out.printf("\n%-35s %-15s %-9s %-13s", "Electrical Device", "Price(RM)", "Quantitiy", "Sub Total(RM)");
		System.out.printf("\n%-35s %-15s %-9s %-13s", "===================================", "===============", "=========", "=============\n");
		for(int i=0; i<numberOfItem; i++) {
			
			if(quantity_device[i] > 0) {
				System.out.printf("%-20s %10.2f %9d %13.2f\n", "["+(i+1)+"]" + "  " + ElectricalDevice[i], price[i], quantity_device[i], subTotal[i]);
				isBuy = true;
			}
			
			total += subTotal[i];
		}
		
		
		if(!isBuy) {
			System.out.println("\n\nNo buy device yet!!!");
		
		}
		
		System.out.printf("\n\nTotal: RM %.1f" , total);
                 if(total == 0)
                     System.out.println("\nYou Buy Nothing!!!");
                    
                     else if (total < 3000)
                      System.out.println("\nYou Need To Buy More Than Three Thousand!!!");
                    
                     else if(total >= 11000 )
                            subDiscount = discount[4] ;
       
                     else if(total >= 9000 )
                            subDiscount = discount[3] ;
       
                     else if(total >= 7000)
                            subDiscount = discount[2] ;
       
                     else if(total >= 5000)
                            subDiscount = discount[1] ;
       
                     else if(total >= 3000)
                            subDiscount = discount[0] ;
                        
                     if(total>3000){   
                    priceAfterDiscount=(total-(total*subDiscount/100));
                    System.out.println("\nYou are Entitle for Discount " + subDiscount + "%");
                    System.out.println("\nThe Payable Price is RM" + priceAfterDiscount);
               
        } 

          }
    }
         


