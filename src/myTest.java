
import java.util.Scanner;

public class myTest
{
   public static void main (String[] args)
   {
      boolean LinkedListTestRunning = true; //boolean to control loop
      LinkedList linkedList = new LinkedList();
      do{
         printMenu(); //prints the menu out/
         switch (getValidateUserMenuInput()){ //gets the user input.
            case 1 ->{
               System.out.println("Testing method addFirstNode()"); //testing console writes.
               int data = getUserData(); //Store the userInput for data as a local variable so that we can print it.
               System.out.println("Adding "+data+" as first node.");
               System.out.print("List content before adding "+data+" is: "); //printing data before.
               linkedList.printList();

               linkedList.addFirstNode(data);

               System.out.print("\nList content after adding "+data+" is: "); //printing data after
               linkedList.printList();
            }
            case 2 ->{
               System.out.println("Testing method addLastNode()"); //testing console writes.
               int data = getUserData(); //Store the userInput for data as a local variable so that we can print it.
               System.out.println("Adding "+data+" as last node.");
               System.out.print("List content before adding "+data+" is: "); //printing data before.

               linkedList.addLastNode(data);

               System.out.print("\nList content after adding "+data+" is: "); //printing data after
               linkedList.printList();
            }
            case 3 ->{
               System.out.println("Testing method addAtIndex()");
               int index = getUserIndex();
               int data = getUserData();
               System.out.println("Adding "+data+" at specified index "+index);
               System.out.print("List content before adding "+data+" at index "+index+" is: "); //printing data before.
               linkedList.printList();

               linkedList.addAtIndex(index,data);

               System.out.print("\nList content after adding "+data+" at index "+index+" is: "); //printing data after.
               linkedList.printList();
            }
            case 4 -> {
               System.out.println("Testing method removeFirstNode()"); //testing console writes.
               System.out.print("List content before removing first node is: "); //printing data before.
               linkedList.printList();

               linkedList.removeFirstNode();

               System.out.print("\nList content after removing first node is: "); //printing data after.
               linkedList.printList();
            }
            case 5 -> {
               System.out.println("Testing method removeLastNode()"); //testing console writes.
               System.out.print("List content before removing last node is: "); //printing data before.
               linkedList.printList();

               linkedList.removeLastNode();

               System.out.print("\nList content after removing last node is: "); //printing data after.
               linkedList.printList();
            }
            case 6 -> {
               System.out.println("Testing method removeAtIndex()");
               int index = getUserIndex();
               System.out.print("List content before removing value at index "+index+" is: "); //printing data before.
               linkedList.printList();

               linkedList.removeAtIndex(index);

               System.out.print("\nList content after removing value at index "+index+" is: "); //printing data after.
               linkedList.printList();
            }
            case 7 -> System.out.println("Current size of Linked List is: "+linkedList.countNodes());
            case 8 -> {
               System.out.println("Testing method printList()");
               System.out.print("Linked List values forwards are: ");
               linkedList.printList();
               System.out.println();
            }
            case 9 ->{
               System.out.println("Testing method printInReverse()");
               System.out.print("Linked List values backwards are: ");
               linkedList.printInReverse();
               System.out.println();
            }
            case 10 ->{
               System.out.println("Terminating program");
               LinkedListTestRunning = false;
            }
         }
      }while(LinkedListTestRunning);
   }


   /**
    * This method prints the menu for the user.
    */
   public static void printMenu(){
      System.out.println();
      System.out.println("---------MAIN MENU--------");
      System.out.println("1 – Add First Node");
      System.out.println("2 – Add Last Node");
      System.out.println("3 – Add At Index");
      System.out.println("4 – Remove First Node");
      System.out.println("5 – Remove Last Node");
      System.out.println("6 – Remove At Index");
      System.out.println("7 – Print List Size");
      System.out.println("8 – Print List (Forward)");
      System.out.println("9 – Print List In Reverse");
      System.out.println("10- Exit program\n");
   }

   /**
    * This method gets and validates user input. This method should be called every time the menu is called to get an input
    * from the user regrading their choice on the menu.
    */
   public static int getValidateUserMenuInput(){
      boolean testPassed = false;
      int userInputInteger = 0;
      while(!testPassed){
         Scanner sc = new Scanner(System.in);
         System.out.print("Enter option number: ");
         try{
            userInputInteger = Integer.parseInt(sc.nextLine());
            if(userInputInteger>0 && userInputInteger <= 10){ //if the number is actually a valid menu option, return that number.
               testPassed = true;
            }else{
               System.out.println("Please enter a number between 1-10.");
            }
         }catch (NumberFormatException e){
            System.out.println("Please enter an Integer.");
         }
      }
      return userInputInteger;
   }

   /**
    * This method prompts the user to enter a value for the Data node which will then be returned to the caller.
    */
   public static int getUserData(){
      boolean testPassed = false;
      int userInputInteger = 0;
      while(!testPassed){
         Scanner sc = new Scanner(System.in);
         System.out.print("Please enter a value for the Data node: ");
         try{
            userInputInteger = Integer.parseInt(sc.nextLine()); //Try to parse the user Input into an Integer, and break out of loop if successful.
            testPassed = true;
         }catch (NumberFormatException e){
            System.out.println("Please enter an integer.");
         }
      }
      return userInputInteger;
   }

   /**
    * This method prompts the user to enter the index in which will be returned to the caller.
    */
   public static int getUserIndex(){
      boolean testPassed = false;
      int userInputInteger = 0;
      while(!testPassed){
         Scanner sc = new Scanner(System.in);
         System.out.print("Please enter the index: ");
         try{
            userInputInteger = Integer.parseInt(sc.nextLine()); //Try to parse the user Input into an Integer, and break out of loop if successful.
            testPassed = true;
         }catch (NumberFormatException e){
            System.out.println("Please enter an integer.");
         }
      }
      return userInputInteger;
   }
}
    
