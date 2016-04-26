import java.awt.Color;

public class ArrayGenerate
{
	int[][] tabdis = new int[5][5];
	int[][] arrgen = new int[75][75];
	int[][] patterns = new int[75][75];
	private int x;
	private static final int cellSize = 5;
	final int Green = 0x00CC00;
	
	private final int XP = 1;
	private final int YP = 2;
	private final int ZP = 3;
	 	
	public 	ArrayGenerate()
	{	
        // this generates the random number generator of 0 or 1.
	    for(int i=0;i< 75;i++)
	    {
		    for (int j=0; j<75;j++)
		    {
			    arrgen[i][j]=(int)(Math.random()+ 0.8);
			    patterns[i][j] = 0;
		    }
	    }
	}
public String[] DisplayOriginalArray() throws Exception{
	
	String displayStr[] = new String[75];
    
	for(int i=0;i< 75;i++){
		displayStr[i] ="";
		for (int j=0; j<75;j++){	
	        displayStr[i] = displayStr[i] + " " + arrgen[i][j];	    
		}	
	}
	return displayStr;
	

 }
 
private void patternX(int i, int j){
    for(int r=i, c=j; r<i+cellSize && c<j+cellSize; r++, c++){
        if(arrgen[r][c]!=1) return;
    }
    for(int r=i+cellSize-1, c=j; r>=i && c<j+cellSize; r--, c++){
        if(arrgen[r][c]!=1) return;
    }
    
    // pattern X is found. fill patterns Matrix
    
    for(int r=i, c=j; r<i+cellSize && c<j+cellSize; r++, c++){
        patterns[r][c]= XP;
        //patterns[r][c]= Green;
    }
    for(int r=i+cellSize-1, c=j; r>=i && c<j+cellSize; r--, c++){
        patterns[r][c]=XP;
        //patterns[r][c]= Green;
    }
    
    return;
}
 
private void patternY(int i, int j){
    for(int r=i, c=j; r <= i+(cellSize/2) && c <= j+(cellSize/2); r++, c++){
        if(arrgen[r][c]!=1) return;
    }
    
    for(int r=i+(cellSize/2), c=j+(cellSize/2); r>=i && c<j+cellSize; r--, c++){
        if(arrgen[r][c]!=1) return;
    }
    
    for(int r=i+(cellSize/2), c=j+(cellSize/2); r<i+cellSize; r++){
        if(arrgen[r][c]!=1) return;
    }
    
    // pattern Y is found. fill patterns Matrix
    
    for(int r=i, c=j; r <= i+(cellSize/2) && c <= j+(cellSize/2); r++, c++){
        patterns[r][c] = YP;
    }
    
    for(int r=i+(cellSize/2), c=j+(cellSize/2); r>=i && c<j+cellSize; r--, c++){
        patterns[r][c] = YP;
    }
    
    for(int r=i+(cellSize/2), c=j+(cellSize/2); r<i+cellSize; r++){
        patterns[r][c] = YP;
    }
    
    return;
}

private void patternZ(int i, int j){

    // top row
    for(int r=i,c=j; c<j+cellSize; c++){
        if(arrgen[r][c]!=1) return;
    }
    
    // diagonal
    for(int r=i+cellSize-1, c=j; r>=i && c<j+cellSize; r--, c++){
        if(arrgen[r][c]!=1) return;
    }
    
    // last row
    for(int r=i+cellSize-1,c=j; c<j+cellSize; c++){
        if(arrgen[r][c]!=1) return;
    }
    
    // pattern Z is found. fill patterns Matrix
     // top row
    for(int r=i,c=j; c<j+cellSize; c++){
        patterns[r][c]=ZP;
    }
    
    // diagonal
    for(int r=i+cellSize-1, c=j; r>=i && c<j+cellSize; r--, c++){
        patterns[r][c]=ZP;
    }
    
    // last row
    for(int r=i+cellSize-1,c=j; c<j+cellSize; c++){
        patterns[r][c]=ZP;
    }
 // g.setColor(Color.green);
    
    return ;
}

 
public String[] getPatternMatrix(){
    for(int i=0; i<75; i+=5){
        for(int j=0; j<75; j+=5){
            // now we've each cell as i to i+4, j to j+4
        	patternX(i,j);
            patternY(i,j);
            patternZ(i,j);
        }
    }
    
    String displayPatterns[] = new String[75];
    
	for(int i=0;i< 75;i++){
		displayPatterns[i] ="";
		for (int j=0; j<75;j++){
		    if(patterns[i][j]==0)displayPatterns[i] = displayPatterns[i] + "  ";
		    else displayPatterns[i] = displayPatterns[i]  + " " + String.valueOf(patterns[i][j]);	    
		}	
	}
	
	return displayPatterns;
} 
 

}