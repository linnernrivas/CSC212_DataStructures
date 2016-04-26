import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.swing.JFileChooser;

public class SortArray {
	// File Parameters
	String dataFilePath;
	String dataFileName;
	String searchkeyFilePath;
	String searchkeyFileName;
	
	public SortArray(){
		dataFilePath = null;
		dataFileName= null;
		searchkeyFilePath = null;
		searchkeyFileName = null;
	}
	
	public void OpenDataFile() throws IOException{
		JFileChooser chooser = new JFileChooser();
		  chooser.setDialogType(JFileChooser.OPEN_DIALOG );
		  chooser.setDialogTitle("Open Data File");
	      
	      int returnVal = chooser.showOpenDialog(null);
	      if( returnVal == JFileChooser.APPROVE_OPTION) 
	      	{
	          dataFilePath = chooser.getSelectedFile().getPath();
	          dataFileName = chooser.getSelectedFile().getName();
	        }
		}
	public void OpenKeyFile() throws IOException{
		JFileChooser chooser = new JFileChooser();
		  chooser.setDialogType(JFileChooser.OPEN_DIALOG );
		  chooser.setDialogTitle("Open Data File");
	      
	      int returnVal = chooser.showOpenDialog(null);
	      if( returnVal == JFileChooser.APPROVE_OPTION) 
	      	{
	    	  searchkeyFilePath = chooser.getSelectedFile().getPath();
	    	  searchkeyFileName = chooser.getSelectedFile().getName();
	        }
	}
	
	
}
