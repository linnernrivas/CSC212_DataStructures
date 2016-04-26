
// GUI-related imports

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Project06 extends Frame implements ActionListener
{
	String command = "";
	
	LinkedList            LL = new LinkedList();
	int                   position, value;
	String                inputValue;
	Node                  location = new Node();
	public static void main(String[] arg )
	{
		Frame frame = new Project06();	
			
		frame.setResizable(true);
		frame.setSize(900,500);
		frame.setVisible(true);
	}
	
	public  Project06()
	{
		setTitle("Linked List Operations");
		
		// Create Menu Bar
		   			
		MenuBar mb = new MenuBar();
		setMenuBar(mb);
		
		// Create Menu Group Labeled "File"
		Menu aboutMenu = new Menu("About");
		mb.add(aboutMenu);
		
		
		Menu UtilitiesMenu = new Menu("Utilities");
		mb.add(UtilitiesMenu);
		
		MenuItem miNewList = new MenuItem("New List");
		miNewList.addActionListener(this);
		UtilitiesMenu.add(miNewList);
		
		MenuItem miLocate = new MenuItem("Locate A Value");
		miLocate.addActionListener(this);
		UtilitiesMenu.add(miLocate);
		MenuItem miSorted = new MenuItem("Create Sorted List");
		miSorted.addActionListener(this);
		UtilitiesMenu.add(miSorted);
		
		
		Menu AddMenu = new Menu("Add");
		mb.add(AddMenu);
		
		MenuItem miBegining = new MenuItem("Begining");
		miBegining.addActionListener(this);
		AddMenu.add(miBegining);
		
		MenuItem miAddToEnd = new MenuItem("End");
		miAddToEnd.addActionListener(this);
		AddMenu.add(miAddToEnd);
		
		
		Menu DeleteMenu = new Menu("Delete");
		mb.add(DeleteMenu);
		
		MenuItem miFirstNode = new MenuItem("First Node");
		miFirstNode.addActionListener(this);
		DeleteMenu.add(miFirstNode);
		
		MenuItem miLastNode = new MenuItem("Last Node");
		miLastNode.addActionListener(this);
		DeleteMenu.add(miLastNode);
		
		
		MenuItem miAfterYNode = new MenuItem("After the Node with Y");
		miAfterYNode.addActionListener(this);
		DeleteMenu.add(miAfterYNode);
		
		MenuItem miBeforeXNode = new MenuItem("Before the Node with X");
		miBeforeXNode.addActionListener(this);
		DeleteMenu.add(miBeforeXNode);
		
		//"New List".
		MenuItem miNewListt = new MenuItem("New List");
		miNewListt.addActionListener(this);
		DeleteMenu.add(miNewListt);
		
		//if("Locate A Value"
		MenuItem miLocateAValue = new MenuItem("Locate A Value");
		miLocateAValue.addActionListener(this);
		DeleteMenu.add(miLocateAValue);
		
		//"Create Sorted List"
		MenuItem miCreateSortedList = new MenuItem("Create Sorted List");
		miCreateSortedList.addActionListener(this);
		DeleteMenu.add(miCreateSortedList);
		
		//
		
		
		
		WindowListener l = new WindowAdapter()
		{
						
			public void windowClosing(WindowEvent ev)
			{
				System.exit(0);
			}
			
			public void windowActivated(WindowEvent ev)
			{
				repaint();
			}
			
			public void windowStateChanged(WindowEvent ev)
			{
				repaint();
			}
		
		};
		
		ComponentListener k = new ComponentAdapter()
		{
			public void componentResized(ComponentEvent e) 
			{
        		repaint();           
    		}
		};
		
		// register listeners
			
		this.addWindowListener(l);
		this.addComponentListener(k);

	}
	
//******************************************************************************
//  called by windows manager whenever the application window performs an action
//  (select a menu item, close, resize, ....
//******************************************************************************

	public void actionPerformed (ActionEvent ev)
		{
			// figure out which command was issued
			
			command = ev.getActionCommand();
			
			// take action accordingly
						
			if("Begining".equals(command))
			{
				LL.AddToBegining((int) (100 + 900*Math.random() ));
				repaint();		
			}
			
			else
				if("End".equals(command))
				{
					LL.AddToEnd((int) (100 + 900*Math.random() ));
					repaint();
				}
			else
				if("Before the Nth Node".equals(command))
				{
					position = Integer.parseInt(JOptionPane.showInputDialog(null, 
							"Type an Integer Number for the position of the Node the New to be Added Before" ));
					LL.AddBeforeNthNode((int) (100 + 900*Math.random() ), position);
					repaint();
				}
			else
				if("After the Node with X".equals(command))
				{
					value = Integer.parseInt(JOptionPane.showInputDialog(null, "Type an Integer Number for X ---- New Node Will be Added After the Node With X in it" ));
					LL.AddAfterValue((int) (100 + 900*Math.random() ), value);
					repaint();
				}	
			else
				if("First Node".equals(command))
				{
					LL.DeleteFromBegining();
					repaint();
				}
			else
				if("Last Node".equals(command))
				{
					LL.DeleteFromEnd();		
					repaint();
				}
			else
				if("After the Node with Y".equals(command))
				{
					value = Integer.parseInt(JOptionPane.showInputDialog(null, 
							"Type an Integer Number --- the Node After Value Entered Will be Deleted" ));
					LL.DeleteAfterSpecificNode(value);		
					repaint();
				}
			else
				if("Before the Node with X".equals(command))
				{
					value = Integer.parseInt(JOptionPane.showInputDialog(null, 
							"Type an Integer Number --- the Node Before Value Entered Will be Deleted" ));
					LL.DeleteBeforeValue(value);		
					repaint();
				}
			else
				if("New List".equals(command))
				{
					LL.head = null;	
					LL.tail = null;
					LL.length = 0;
					repaint();
				}
			else
				if("Locate A Value".equals(command))
				{
					value = Integer.parseInt(JOptionPane.showInputDialog(null, "Type an Integer Number for the Value to be Found" ));
					location = LL.LocateNode(value);		
					repaint();
				}
			else
				if("Create Sorted List".equals(command))
				{	
					//LL.AddToSortList(LL.number);
					LL.CreateSortedList();
					repaint();
				}
			else
				if("Exit".equals(command))
				{
							
					System.exit(0);
				}
		}
//********************************************************
// called by repaint() to redraw the screen
//********************************************************
		
		public void paint(Graphics g)
		{
			int ww = (int) this.getWidth();
			int wh = (int) this.getHeight();
			
			if (LL.head == null)
			{
				g.drawString(" Empty List", 400, 250);
				return;
			}
			else 
			{
				int xs = 100;
				int ys = 100;
				Node t= LL.head;
				g.drawString("Head", 40, 80);
				g.drawLine(60, 80, 100, 100);
				while (t != null)
				{
					// add code to display the nodes
					g.drawRect(xs-10, ys-10, 33, 20);
					
					
					g.drawLine(xs+25, ys+25, xs+40, ys-10);
					g.drawLine(xs+25, 100, xs+40, 100);
					g.drawLine(xs+25, ys+25, xs+40, ys-10);
					/*g.drawLine(xs+25, ys+3, xs+60, ys-10);
					g.drawLine(xs+50, ys+3, xs+60, ys-10);
					g.drawLine(xs+50, ys-15, xs+60, ys-10);*/
					
				
					
					g.drawString(Integer.toString(t.data), xs-1, ys+4);
					t = t.next;
					
					xs = xs +50;
					
					
					if("Locate A Value".equals(command)){
						 if(t.data == location.data){
							 g.setColor(Color.RED);
						 } 
					}
					
					
				}
			
				g.drawString("End Of List", xs+5, ys+10);
			}
			
			
		}
}