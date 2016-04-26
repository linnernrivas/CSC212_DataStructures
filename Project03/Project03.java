import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class Project03 extends Frame implements ActionListener {
	SortArray tn = new SortArray();
	// Retrieved command code
	
	String command = "";
	
	//Program Description displayed from About sub-menu
	String[] description = new String[] {
	    		" Thisprogram to compare the performance of data retrieval ",
	    		"for the following search methods:",
				" - Sequential Search",
				" - Binary Search of a sorted array",
				" Input:",
				"     - The file have Data File,Search Files and Key files  ",
				" Output:",
				"     - Will be provided with several datasets, Data Files (DataFile) containing unique integer",
				"	  - numbers and Search Keys files (Keys) containing keys to search among data files.", 
				};
	  
			
		public static void main(String[] args){
			Frame f = new  Project03();
			
			f.setResizable(false);
			f.setSize(900,620);
			f.setVisible(true);
			
		}
		
		
		public Project03(){
		//Creates the title for frame
			setTitle("Search Routines-Rivas-Linner");
			
		// Create Menu Bar
			MenuBar mb = new MenuBar();
			setMenuBar(mb);
			
		//Create Menu Group Labeled "File"
			Menu fileMenu = new Menu("File");
			mb.add(fileMenu);//Add it to Menu Bar
			
		//Create Menu Group Label "Search"
			Menu searchMenu = new Menu("Search");
			mb.add(searchMenu);//Add it to Menu Bar
			
			
       //Creates the subMenu for the Menu Group label "File"
			 MenuItem miAbout = new MenuItem("About");
			 miAbout.addActionListener(this);
			 fileMenu.add(miAbout);
			 
			 MenuItem miOpenFile = new MenuItem("Open File");
			 miOpenFile.addActionListener(this);
			 fileMenu.add(miOpenFile);
			 
			 MenuItem miExit = new MenuItem("Exit");
			 miExit.addActionListener(this);
			 fileMenu.add(miExit);
	  
	  //Create the subMenu for the Menu Group label "Search"
			 MenuItem miSSearch = new MenuItem("Sequential Search");
			 miSSearch.addActionListener(this);
			 searchMenu.add(miSSearch);
			 
			 MenuItem miBSearch = new MenuItem("Binary Search");
			 miBSearch.addActionListener(this);
			 searchMenu.add(miBSearch);
			 
			 WindowListener l = new WindowAdapter(){
								
					public void windowClosing(WindowEvent ev){
						System.exit(0);
					}
					
					public void windowActivated(WindowEvent ev){
						repaint();
					}
					
					public void windowStateChanged(WindowEvent ev){
						repaint();
					}
				
				};
				
				ComponentListener k = new ComponentAdapter(){
					public void componentResized(ComponentEvent e){
		        		repaint();           
		    		}
				};
				
				// register listeners
					
				this.addWindowListener(l);
				this.addComponentListener(k);	
		}
		
	/*
	* Called by windows manager whenever the application window performs an action
	* (Select a menu item, close, resize, etc)
	*/
		public void actionPerformed(ActionEvent ev){
			// figure out which command was issued
				command = ev.getActionCommand();
				
			//take action accordingly
				if ("About".equals(command)){
					repaint();
				}
				
				else if ("Exit".equals(command)){
					System.exit(0);
				}
				else if ("Open File".equals(command)){
					try{
						tn.OpenDataFile();
						tn.OpenKeyFile();
					}
					catch(IOException ioe){
						System.exit(0);
					}
					repaint();
				}
				else if ("Sequential Search".equals(command))
				{
					//arr.SequentialSearch();
					repaint();
				}
				
				else if ("Binary Search".equals(command))
				{
				//	arr.BinarySearch();
					repaint();
				}
			
			
		}
//********************************************************
// called by repaint() to redraw the screen
//********************************************************
				
				public void paint(Graphics g)
				{
					int x=200;
					int y=150;
					
					if ("About".equals(command))
					{
						for (int i=0; i<12; i++)
						{
							g.drawString(description[i],x-120,y);
							y=y+25;
						}
					}
					 if  ("Open File".equals(command)){
			        	x=200;//make it 50+25
			     	    y=150;
			            g.setColor(Color.black);
			            g.drawString(" File"+ "--"+ tn.dataFileName +"--"+"was succesfully opened",x-120,y+40);
			            y+=25;
			        }
					 else{
						 g.drawString("File was Unsuccesufully opened.", x-120,y+40);
					 }
					if("Sequential Search".equals(command) || "Binary Search".equals(command)){
						
						
					}
				}
		
}
