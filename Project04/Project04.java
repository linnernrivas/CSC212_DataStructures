

import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

@SuppressWarnings("serial")
public class Project04 extends Frame implements ActionListener {
	ArrayGenerate tn = new ArrayGenerate();

	// Retrieved command code
	String command = "";

	// Program Description displayed from About sub-menu
	String[] description = new String[] { " This program a menu-based GUI program to generate a matrix of 75X75 ",
			"of integers 0 or 1 using the random number generator in the Math class :", " - Generate Original Array",
			" - Display Original Array ", " - Detect Patterns ", " - Display Patterns ", " Input:",
			"     -Integers 0 or 1 using the random number generator.  ", " Output:",
			"     - Display the original matrix in a grid around the whole matrix and every 5X5 blocks." };

	public static void main(String[] args) {
		Frame f = new Project04();

		f.setResizable(false);
		f.setSize(1000, 950);
		f.setVisible(true);

	}

	public Project04() {
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
		Menu patternsMenu = new Menu("Patterns");
		mb.add(patternsMenu);// Add it to Menu Bar

		// Create the subMenu for the Menu Group label "Search"
		MenuItem miGenerateArray = new MenuItem("Generate Original Array");
		miGenerateArray.addActionListener(this);
		patternsMenu.add(miGenerateArray);

		// Create the subMenu for the Menu Group label "Search"
		MenuItem miDisplayArray = new MenuItem("Display Original Array");
		miDisplayArray.addActionListener(this);
		patternsMenu.add(miDisplayArray);

		// Create the subMenu for the Menu Group label "Search"
		MenuItem miDetectpatterns = new MenuItem("Detect Patterns");
		miDetectpatterns.addActionListener(this);
		patternsMenu.add(miDetectpatterns);

		// Create the subMenu for the Menu Group label "Search"
		MenuItem miDisplaypatterns = new MenuItem("Display Patterns");
		miDisplaypatterns.addActionListener(this);
		patternsMenu.add(miDisplaypatterns);

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
		else if ("Generate Original Array".equals(command)) {
			repaint();
		}
		else if ("Display Original Array".equals(command)) {
			repaint();
		} 
		else if ("Detect Patterns".equals(command)) {
			repaint();
		}
		else if ("Display Patterns".equals(command)) {
			repaint();
		}
	}
	
	public void drawLines(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
 
        g2d.drawLine(120, 50, 360, 50);
        g2d.setStroke(new BasicStroke(10));
        g2d.setColor(Color.GREEN);
 
    //    g2d.draw(new Line2D.Float(21.50f, 132.50f, 459.50f, 132.50f));
 
    }

	// ********************************************************
	// called by repaint() to redraw the screen
	// ********************************************************
	//Graphic2D g2 = (Graphic2D) g;
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		int x=50;
		int y =100;
		if ("About".equals(command)) {
			// replaced value with array.length to avoid index exception.
			for (int i = 0; i < description.length; i++) {
				g.drawString(description[i], x, y);
				y = y + 25;
			}
		}
		if("Generate Original Array".equals(command)){
			g.setColor(Color.RED);
			g.setFont(new Font("TimesRoman", Font.BOLD, 16)); 
			g.drawString("Generated a matrix of 75X75 of integers 0 or 1 using the random number generator in the Math class", x+25, y);
		}
		
		if ("Display Original Array".equals(command)) {
			String display[] =new String[75];

			g.setColor(Color.RED);
			g.setFont(new Font("TimesRoman", Font.BOLD, 16)); 
			g.drawString("Original Array", 410, y);
			y=y+25;
			g.setFont(new Font("Courier New", Font.PLAIN, 9)); 
			g.setColor(Color.BLACK);
			
			g.drawRect(110,115,750,752);
			
//This is the up& down line that make the 5X5
			g.drawLine(160,115,160,866);
			g.drawLine(210,115,210,866);
			g.drawLine(260,115,260,866);
			g.drawLine(310,115,310,866);
			g.drawLine(360,115,360,866);
			g.drawLine(410,115,410,866);
			g.drawLine(460,115,460,866);
			g.drawLine(510,115,510,866);
			g.drawLine(560,115,560,866);
			g.drawLine(610,115,610,866);
			g.drawLine(660,115,660,866);
			g.drawLine(710,115,710,866);
			g.drawLine(760,115,760,866);
			g.drawLine(810,115,810,866);
			g.drawLine(860,115,860,866);
			
//This is the line that goes side to side that make 5X5			
			g.drawLine(110,164,860,164);
			g.drawLine(110,214,860,214);
			g.drawLine(110,264,860,264);
			g.drawLine(110,314,860,314);
			g.drawLine(110,364,860,364);
			g.drawLine(110,414,860,414);
			g.drawLine(110,464,860,464);
			g.drawLine(110,514,860,514);
			g.drawLine(110,564,860,564);
			g.drawLine(110,614,860,614);
			g.drawLine(110,664,860,664);
			g.drawLine(110,714,860,714);
			g.drawLine(110,764,860,764);
			g.drawLine(110,814,860,814);
			
			
			try {
				display = tn.DisplayOriginalArray();
				for(int i=0;i<75;i++)
				{
				g.drawString(display[i], x+60, y);
				y=y+10;
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if("Detect Patterns".equals(command)){
			g.setColor(Color.RED);
			g.setFont(new Font("TimesRoman", Font.BOLD, 16)); 
			g.drawString("Scan the matrix, check the blocks of 5X5 (there are 20/row and 20/column) for patterns.", x+25, y);
		}
		
		if ("Display Patterns".equals(command)) {
			String displayp[] =new String[75];
			
			g2.setColor(Color.RED);
			g2.setFont(new Font("TimesRoman", Font.BOLD, 16)); 
			g2.drawString("Patterns Found", 410, y);
			y=y+15;
			g2.setFont(new Font("Courier New", Font.PLAIN, 9)); 
			g2.setColor(Color.BLACK);
			g2.drawRect(110,115,750,752);


			g2.setColor(Color.BLACK);
			//This is the up& down line that make the 5X5
			g2.drawLine(160,115,160,866);
			g2.drawLine(210,115,210,866);
			g2.drawLine(260,115,260,866);
			g2.drawLine(310,115,310,866);
			g2.drawLine(360,115,360,866);
			g2.drawLine(410,115,410,866);
			g2.drawLine(460,115,460,866);
			g2.drawLine(510,115,510,866);
			g2.drawLine(560,115,560,866);
			g2.drawLine(610,115,610,866);
			g2.drawLine(660,115,660,866);
			g2.drawLine(710,115,710,866);
			g2.drawLine(760,115,760,866);
			g2.drawLine(810,115,810,866);
			g2.drawLine(860,115,860,866);

			//This is the line that goes side to side that make 5X5			
			g2.drawLine(110,164,860,164);
			g2.drawLine(110,214,860,214);
			g2.drawLine(110,264,860,264);
			g2.drawLine(110,314,860,314);
			g2.drawLine(110,364,860,364);
			g2.drawLine(110,414,860,414);
			g2.drawLine(110,464,860,464);
			g2.drawLine(110,514,860,514);
			g2.drawLine(110,564,860,564);
			g2.drawLine(110,614,860,614);
			g2.drawLine(110,664,860,664);
			g2.drawLine(110,714,860,714);
			g2.drawLine(110,764,860,764);
			g2.drawLine(110,814,860,814);

			
			try {
				displayp = tn.getPatternMatrix();
				for(int i=0; i<75; i++)System.out.println(displayp[i]);
				final int xscale = 49;
				final int yscale = 49;
				for(int i=0; i<75; i+=5){
                    x = 110;
                    for(int j=0; j<75; j+=5){
                        // now we've each cell as i to i+4, j to j+4
                    	// check with unique positions(X, Y, Z patterns have unique positions)
                    	if(displayp[i+3].charAt(j+3) != ' '){
                    		// draw X
                    		g2.setColor(Color.GREEN);
                    		g2.drawLine(x, y, x+xscale, y+yscale);
                    		g2.drawLine(x, y, x+xscale, y+yscale);
                    		g2.drawLine(x+xscale, y+2, x+2, y+yscale);
                    		g2.drawLine(x+xscale, y+1, x+1, y+yscale);
                    	}
                    	if(displayp[i+3].charAt(j+2) != ' '){
                    		// draw Y
                    		g2.setColor(Color.RED);
                    		g2.drawLine(x+2, y+2, x+xscale/2, y+yscale/2);
                    		g2.drawLine(x+1, y+1, x+xscale/2, y+yscale/2);
                    		g2.drawLine(x+xscale, y, x+xscale/2, y+yscale/2);
                    		g2.drawLine(x+xscale, y, x+xscale/2, y+yscale/2);
                    		g2.drawLine(x+xscale/2, y+yscale/2, x+xscale/2, y+yscale);
                    		g2.drawLine(x+xscale/2, y+yscale/2, x+xscale/2, y+yscale);
                    	}	
                    	if(displayp[i].charAt(j+2) != ' '){
                    		// draw Z
                    		g2.setColor(Color.BLUE);
                    		g2.drawLine(x, y, x+xscale+2, y);
                    		g2.drawLine(x, y, x+xscale+1, y);
                    		g2.drawLine(x+xscale, y+2, x+2, y+yscale);
                    		g2.drawLine(x+xscale, y+1, x+1, y+yscale);
                    		g2.drawLine(x+2, y+yscale+2, x+xscale+2, y+yscale+2);
                    		g2.drawLine(x+1, y+yscale+1, x+xscale+1, y+yscale+1);
                    	}

                        x = x + xscale+1;
                    }
                    y = y+yscale+1;
                }
			} 
				catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}