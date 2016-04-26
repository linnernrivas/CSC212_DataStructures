
import javax.swing.JOptionPane;
public class LinkedList 
{
    Node head = null;
    Node tail = null;
    long  length;
    
    public LinkedList()
    {
        head = null; 
        tail = null;
        length = 0;
    }
    public void AddToBegining(int number)
    {
        length++;
        Node t = new Node();
        t.data = number;
        t.next = head;
        head = t;
        if (tail == null)
            tail = t;
    }
    public void AddToEnd(int number)
    {
       Node t = new Node();
       t.data= number;
       if(tail!=null){
    	   tail.next = t;
    	   tail= t;
       }
       else{
    	   head=t;
           tail=t;
       }
    }
    public void AddBeforeNthNode(int number, int position)
    {
        
    }
    
    public void AddAfterValue(int number, int value)
    {
        
    }
    public Node DeleteFromBegining()
    {
        Node t =head;
        if(head == null){
        	JOptionPane.showMessageDialog(null, "\n\n  Project06  \n\n\n" + "\n   List is Empty          \n","Deleting the First Node",JOptionPane.INFORMATION_MESSAGE);
            return t;
        }
        else{
        	head=head.next;
        	if (head ==null)
        		tail = null;
        		return t;
        }
    }
    public Node DeleteFromEnd()
    {
    	Node t =head;
        if(head == null){
        	JOptionPane.showMessageDialog(null, "\n\n  Project06  \n\n\n" + "\n   List is Empty          \n","Deleting the Last Node",JOptionPane.INFORMATION_MESSAGE);
            return t;
            }
        else if(head == tail){
        		t = head;
        		head= tail=null;
        		return t;
        		
        	}
        else{
        	while(t.next != tail){
        		t= t.next;
        				}
        	t.next = null;
        	tail = t;
        	return t;
        	}
    }
    public Node DeleteAfterSpecificNode(int arg)
    { 
    	int position = 0;
    	int counter = 1;
    	Node t = null ;
    	Node temp = head;
    while(counter < position - 1){
    	counter ++;
    	temp = temp.next;
    }
   
	if(temp!= head){
    	t.next= temp.next;
    	temp.next = t;
    }
    else {
    	t.next= temp.next;
    	head = t;
    }
      return t;
    }
    /*//Node temp = head;
    		
    		while(temp!= null && temp.data != number){
    			temp = temp.next;
    			
    			if (head == null){
    				notfound,
    				return null;
    			}
    				else{
    				Node p = temp.next;
    				if (p==null){
    					return null;
    			}
    				else{
    					temp.next = p.next;
    					if (p.next == null){
    						tail = temp;
    					}
    				}
    			}
    		}*/
    public Node DeleteBeforeValue(int value)
    { 
    	if (head.data == value){
			head = head.next;
			return head ;
		}
    	Node temp = head;
    	//int number;
    	//Object P2;
		//Object P1;
    	Node P1 = head;
    	Node P2 = new Node();
		while (P2 != null){
    				P1 = P2;
    				P2 = temp;
    			temp = temp.next;
    			
    		
    	if(P1 == null){ // trying to delete the first node 
    		if (P2 == null){
    			//can't delete, no node  the Finished
    		//else 
    			head = head.next;
    		 
    		}
    		else {
    			P1.next = P2.next;
    		}
    	}	
    return P2;
     
		}
		return P2;
    }
    public Node LocateNode(int arg)
    {	
    	if (head.data == arg){
    		return head;
    	}
    	Node temp = head;
    	while(temp.data != arg && temp.next != null){
    		
    		temp = temp.next;
    		if(temp.data == arg){
    	
    			return temp;
    		}
    	}
    	return null;
    }
    
    public void CreateSortedList()
    {
    	/*int number;
    	
    	for(int i = 0; i <50; i++){
    		number = (int)(100+400 *Math.E);
    		AddToSortList(number);
    		
    	}    */
for(Node move = head;move != null;move = move.next){
    	    
    	    for(Node temp = move.next;temp != null;temp = temp.next){
    	        if(move.data > temp.data){
    	            int tempNum = move.data;
    	            move.data = temp.data;
    	            temp.data = tempNum;
    	        }
    	    }
    	} 
    }
	
	    
}
