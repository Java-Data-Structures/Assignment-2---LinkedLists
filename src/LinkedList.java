
/*
This class define a linked list that stores integer values.
*/

//todo make the debug messages in the main method.

public class LinkedList
{
   public Node head, tail;

   //constructor method to create a list of object with head, tail, and size. 
   public LinkedList()
   {
      head = null;
      tail = null;
   }
  
   //method add node to end of list
   public void addLastNode(int data) 
   {
      if (tail == null) 
         head = tail = new Node(data); //empty list
      else 
      {
         tail.next = new Node(data); //link new node as last node
         tail = tail.next; //make tail pointer points to last node
      }
   }
  
   //======== Your part to complete for this assignment =========
   
   //method #1: add first node
   public void addFirstNode(int data)
   {
      Node temp = new Node(data); //Create and initialize a new Node.
      temp.next = head; //Set temp.next to point to the current head node.
      head = temp; //Set the head pointer to point to the new Node that we inserted.
      if(head.next == null) tail = head; //if there is only 1 node, then we can say it is both the head and tail.
   }
      
   //method #2: add node at index
   public void addAtIndex(int index, int data)
   {
      if(index < 0){ //if the index specified was out of bounds (too small)
         System.out.println("Cannot add an element from a negative index.");
      }else if(index > (countNodes()-1)){ //if the index specified was out of bounds (too big).
         System.out.println("Adding new element to the end of the list");
         addLastNode(data);
      }else if(index == 0){ //if we want to insert at the first index.
         addFirstNode(data);
      }else{
         Node temp = head;
         for(int i=0;i<index-1;i++){ //Increment our temp pointer until we get to one node before we want to insert.
            temp = temp.next;
         }
         Node newNode = new Node(data); //create a new Node to insert.
         newNode.next = temp.next; //Point the new Node to the Node after whatever is after the index it's replacing.
         temp.next = newNode; //set the temp to point to the new Node, thus completing the insertion.
      }
   }
      
   //method #3: remove first node
   public void removeFirstNode()
   {
      if(head==null){ //Check to see that there actually is a Node to remove.
         System.out.println("List is Empty.");
      }else if (head.next == null){ // If there is only 1 item in the list just point head and tail to null.
         head = null;
         tail = null;
      }else{
         head = head.next; //set the head pointer to point to the next node, effectively deleting the first node.
         if(head.next == null) tail = head; //if the new head has no next node, it is the last node, so set the tail to it too.
      }
   }
      
   //method #4: remove last node
   public void removeLastNode()
   {
      if(head == null){ //check to make sure there is a list to begin with.
         System.out.println("List is Empty.");
      }else if(head.next == null){ //if there is only 1 Node, then just set head and tail to null.
         head = null;
         tail = null;
      }else{
         Node temp = head; //Set the temp pointer to head initially.
         while(temp.next.next!=null){ //Iterate through the list until we hit the second-to-last Node.
            temp = temp.next;
         }
         temp.next = null; //Change the pointer to the last Node to null, effectively deleting it.
         tail = temp;
      }
   }
    
   //method #5: remove node at index
   public void removeAtIndex(int index) {
      if(head == null){
         System.out.println("List is Empty.");
      }else if (index < 0) {
         System.out.println("Cannot remove anything from a negative index.");
      } else if (index > (countNodes() - 1)) {
         System.out.println("Out of Bounds! Can not remove anything from a index out of bounds.");
      } else if (index == (countNodes()-1)){
         removeLastNode(); //if the index specified was the last node, just call the remove last node method.
      } else if(index == 0){
         removeFirstNode(); //if the index specified was the first node, call the remove first method.
      }else{
         Node temp = head;
         for(int i =0;i<index-1;i++){ // Simple for loop to get us to one index before what was specified.
            temp = temp.next;
         }
         //This will set the pointer to the one before the index we want to remove to point to the node ahead of the
         //node we want to remove, effectively removing it.
         temp.next = temp.next.next;
      }
   }
          
   //method #6: countNodes
   //counts the number of nodes.
   public int countNodes()
   {
      if(head == null){ //edge case check to make sure we actually have a list to check.
         return 0;
      }else{
         int listSize= 0;
         Node temp = head;
         while(temp!=null){ //go to every single node and increment the counter by 1.
            temp = temp.next;
            listSize++;
         }
         return listSize;
      }
   }
   
   //method #7: printInReverse  (Recursive method)
   //prints out the list in reverse.
   public void printInReverse(){ //Helper method that calls the actual recursive method.
      if(head == null){ //Edge case check to make sure that the list is not empty.
         System.out.println("List is empty.");
      }else{
         printInReverse(head);
      }
   }

   private void printInReverse(Node L) //actual recursive method that prints the list in reverse.
   {
      if(L.next != null){
         printInReverse(L.next); //Recursive call to make it to the end of the linked list.
      }
      //Non-tail recursion that will make it to the end of the linked list, and then start printing out values.
      System.out.print(L.data + "   ");

   }   

   //================= end of your part ==============

   //method to print out the list
   public void printList() 
   {
      Node temp;
      temp = head;
      while (temp != null)
      {
         System.out.print(temp.data + "   ");
         temp = temp.next;
      }
   }
  
   //class to create nodes as objects
   private class Node
   {
      private int data;  //data field
      private Node next; //link field
       
      public Node(int item) //constructor method
      {
         data = item;
         next = null;
      }
   }
}

