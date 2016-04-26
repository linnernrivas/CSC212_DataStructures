import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.text.*;
import javax.swing.*;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;


public class Project05 extends Frame implements ActionListener {

	AlgorRecursion tn = new AlgorRecursion();

	// Retrieved command code
	String command = "";


	// Program Description displayed from About sub-menu
	String[] description = new String[] { 
			" Develop a program to implement following algorithms using recursion:",
			"1. Summing series ",
			"2.	Combination( N,K):",
			"     - number of combinations of K elements from N elements", 
			"3.	Towers of Hanoi: ",
			"	  -	report the number of moves and description of each move ",
			"(Disk number, FROM shaft , TO shaft) using a sequence of properly",
			" formatted text similar to program 2",
	};
	public static void main(String[] args) {
		Frame f = new Project05();

		f.setResizable(true);
		f.setSize(650,650);
		f.setVisible(true);

	}public Project05() {
		// Creates the title for frame
		setTitle("Pattern Recognition - Rivas - Linner");

		// Create Menu Bar
		MenuBar mb = new MenuBar();
		setMenuBar(mb);

		/* Create Menu Group Labeled "File" */
		Menu fileMenu = new Menu("File");
		mb.add(fileMenu);// Add it to Menu Bar

		/* Creates the subMenu for the Menu Group label "File" */
		MenuItem miAbout = new MenuItem("About");
		miAbout.addActionListener(this);
		fileMenu.add(miAbout);

		MenuItem miExit = new MenuItem("Exit");
		miExit.addActionListener(this);
		fileMenu.add(miExit);

		/* Create Menu Group Label "Patterns" */
		Menu functionMenu = new Menu("Function");
		mb.add(functionMenu);// Add it to Menu Bar

		// Create the subMenu for the Menu Group label "Recursion"
		MenuItem miSummingSeries = new MenuItem("Summing Series");
		miSummingSeries.addActionListener(this);
		functionMenu.add(miSummingSeries);

		// Create the subMenu for the Menu Group label "Recursion"
		MenuItem miCombinationNK = new MenuItem("Combination( N,K)");
		miCombinationNK.addActionListener(this);
		functionMenu.add(miCombinationNK);

		// Create the subMenu for the Menu Group label "Recursion"
		MenuItem miTowersofHanoi = new MenuItem("Towers of Hanoi");
		miTowersofHanoi.addActionListener(this);
		functionMenu.add(miTowersofHanoi);
		
		
		/* Create Menu Group Label "Bonus" */
		Menu bonusMenu = new Menu("Bonus");
		mb.add(bonusMenu);// Add it to Menu Bar

		// Create the subMenu for the Menu Group label "Recursion"
		MenuItem miSerpinskiTriangle = new MenuItem("Serpinski Triangle");
		miSerpinskiTriangle.addActionListener(this);
		bonusMenu.add(miSerpinskiTriangle);



		/* End program when window is closed */
		WindowListener l = new WindowAdapter() {

			public void windowClosing(WindowEvent ev) {
				System.exit(0);
			}

			public void windowActivated(WindowEvent ev) {
				repaint();
			}

			public void windowStateChanged(WindowEvent ev) {
				repaint();
			}

		};

		ComponentListener k = new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				repaint();
			}
		};

		// register listeners

		this.addWindowListener(l);
		this.addComponentListener(k);
	}

	/*
	 * Called by windows manager whenever the application window performs an
	 * action (Select a menu item, close, resize, etc)
	 */
	public void actionPerformed(ActionEvent ev) {
		// figure out which command was issued
		command = ev.getActionCommand();

		// take action accordingly
		if ("About".equals(command)) {
			repaint();
		}

		else if ("Exit".equals(command)) {
			System.exit(0);
		}
		else if ("Summing Series".equals(command)) {
			tn.noInput=false;

			while(!tn.noInput){
				try {
					tn.input =JOptionPane.showInputDialog("Please Enter your value for N:");
					tn.N = Integer.parseInt(tn.input);
					if(tn.N >0)
						tn.noInput = true;

				}
				catch (Exception ioe) {
					System.exit(0);
				}
			}
			tn.TimeElapsed = System.nanoTime();
			tn.Result = tn.SummingSeries(tn.N);
			tn.TimeSSElapsed = System.nanoTime() - tn.TimeElapsed;
			repaint();
		}
		else if ("Combination( N,K)".equals(command)) {
			tn.noInput=false;

			while(!tn.noInput){
				try {
					tn.input =JOptionPane.showInputDialog("Please Enter your value for K:");
					tn.K = Integer.parseInt(tn.input);
					if(tn.K >0)
						tn.noInput = true;

				}
				catch (Exception ioe) {
					System.exit(0);
				}
			}
			tn.CNKTimeElapsed = System.nanoTime();
			tn.CNKResult = tn.CombinationNK(tn.N,tn.K);
			tn.TimeCNKElapsed = System.nanoTime() - tn.CNKTimeElapsed;
			repaint();
		} 
		else if ("Towers of Hanoi".equals(command)) {
			tn.noInput=false;
			while(!tn.noInput){
				try {
					tn.input = JOptionPane.showInputDialog("Please Enter number of disk:");
					tn.K = Integer.parseInt(tn.input);
					if(tn.K >0)
						tn.noInput = true;

				}
				catch (Exception ioe) {
					System.exit(0);
				}
			}
			System.out.println(tn.K);
			tn.toTimeElapsed = System.nanoTime();
			tn.TowersOH(tn.K, "A", "C", "B");
			tn.towTimeElapsed = System.nanoTime() - tn.toTimeElapsed;
			repaint();
		}
		else if ("Serpinski Triangle".equals(command)) {
			  tn.noInput=false;
				while(!tn.noInput){
					try {
						tn.input = JOptionPane.showInputDialog("Please Enter the length of triangle:");
						tn.K = Integer.parseInt(tn.input);
						if(tn.K >0)
							tn.noInput = true;

					}
					catch (Exception ioe) {
						System.exit(0);
					}
				}
				
				// create three points for the outmost triangle
				Point2D A, B, C;
				// A - top vertex
				A = new Point2D.Double(100, 0);
				// B - left bottom vertex
				B = new Point2D.Double(100-tn.K/2, Math.sqrt(0.75*tn.K*tn.K ));
				// C - right bottom vertex
				C = new Point2D.Double(100+tn.K/2 , Math.sqrt(0.75*tn.K*tn.K));
				
				tn.serpinskiTriangle(A, B, C);
			}

	}


	// ********************************************************
	// called by repaint() to redraw the screen
	// ********************************************************
	//Graphic2D g2 = (Graphic2D) g;
	public void paint(Graphics g) {

		int x=250;
		int y =300;
		if ("About".equals(command)) {
			// replaced value with array.length to avoid index exception.
			for (int i = 0; i < description.length; i++) {
				g.drawString(description[i], x, y);
				y = y + 25;
			}
		}
		if("Summing Series".equals(command)){
			g.drawString("N ="+ "  "+tn.N, x, y);
			y+= 25;
			g.drawString("Summation ="+ " " + tn.Result, x, y);
			y+= 25;
			g.drawString("Execution Time =" + "  " + tn.TimeSSElapsed, x, y);
			y+= 25;

		}

		if("Combination( N,K)".equals(command)){
			g.drawString("N ="+ "  "+tn.N, x, y);
			y+= 25;
			g.drawString("K ="+ "  "+tn.K, x, y);
			y+= 25;
			g.drawString("Combination ="+ " " + tn.CNKResult, x, y);
			y+= 25;
			g.drawString("Execution Time =" + "  " + tn.TimeCNKElapsed, x, y);
			y+= 25;

		}
		if("Towers of Hanoi".equals(command)){
			x =25;
			y = 100;
			g.drawString( "Disk#       From             To",x,y);  
			g.setColor(Color.black);
			g.drawString( "Disk#       From             To",x,y);
			g.drawLine(x+1,y+10,x+30,y+10);
			g.drawLine(x+67,y+10,x+100,y+10);
			g.drawLine(x+135,y+10,x+175,y+10);
			y+=55;

			g.setColor(Color.black);
			for(int j=0;j<tn.from.size();j++){
				while(y >=450){
				x +=200;
				y = 100;
				g.drawString( "Disk#       From             To",x,y);
				g.drawLine(x+1,y+10,x+30,y+10);
				g.drawLine(x+67,y+10,x+100,y+10);
				g.drawLine(x+135,y+10,x+175,y+10);
				y+=25;
				
			}
				g.drawString(String.valueOf(tn.discN.get(j)),x,y);
				
				g.drawString(String.valueOf( tn.from.get(j)),x+75,y);
				g.drawString(String.valueOf(tn.to.get(j)), x+150, y);

				y += 25;
				
			}
			g.drawString("Total Number of Moves ="+ (tn.add) , 600, 600);
		}	
		if("Serpinski Triangle".equals(command)){
			Graphics2D g2 = (Graphics2D) g;
			
			x =25;
			y = 120;
			g2.drawString("Serpinski Triangle of your chosen length", x, y);
			g2.setColor(Color.black);
			y+=25;   
			
			// get points from tn.p1, tn.p2, tn.p3 and draw triangles
			// each trangle is 3 lines !
			for(int j=0; j<tn.p1.size(); j++){
			    Point2D A = tn.p1.get(j);
			    Point2D B = tn.p2.get(j);
			    Point2D C = tn.p3.get(j);
			    
			    g2.draw(new Line2D.Double(x + A.getX(), y + A.getY(), x + B.getX(), y + B.getY()));
			}

		}
	}
}

