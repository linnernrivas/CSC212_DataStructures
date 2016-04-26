import java.util.ArrayList;
import java.awt.geom.Point2D;


public class AlgorRecursion {
	String input;
	boolean noInput;
	int N;
	int K;
	
	//Summing Series
	double TimeElapsed;
	double TimeSSElapsed;
	double Result;
	
	//Combination( N,K)
	double TimeCNKElapsed;
	double CNKResult;
	double CNKTimeElapsed;
	
	//Tower of hanoi
	double toTimeElapsed;
	double towTimeElapsed;
	
	// Towers of Hanoi
		ArrayList<String> from;
		ArrayList<String> to;
		ArrayList<Integer> discN;
		
		// Serpinski Triangle
	    ArrayList<Point2D> p1;
	    ArrayList<Point2D> p2;
	    ArrayList<Point2D> p3;

	int totalDisks;
	public int add = 0;

	public AlgorRecursion(){

		from = new ArrayList<>();
		to = new ArrayList<>();
		discN = new ArrayList<>();
		
		p1 = new ArrayList<>();
		p2 = new ArrayList<>();
		p3 = new ArrayList<>();
	}
	public  int  factorial( int n ){
		if ( n == 1 )                                       // base case
			return 1;
		else                                               // general case
			return ( n * factorial ( n - 1 ) );
	}


	public double SummingSeries(double n){
		if(n==1)
			return 1;
		else
			return(n/(2*n-1)+SummingSeries(n-1));
	}

	public double CombinationNK(int n, int k){
		return factorial(n)/(factorial(k)*factorial(n-k)) ;
	}

	public void TowersOH(int n,String FROMshaft ,String TOshaft,String Auxshaft){

		if(n <= 0){
			return;
		}

		TowersOH(n-1,FROMshaft,Auxshaft,TOshaft);

		from.add(FROMshaft);
		to.add(TOshaft);
		discN.add(n);
         add++;
		System.out.println(n + " : " + FROMshaft + " -> " + TOshaft);

		TowersOH(n-1,Auxshaft,TOshaft,FROMshaft);

	}
	
	public void serpinskiTriangle(Point2D A, Point2D B, Point2D C){
	    if(A.distance(B) <= 0.01) return;
	    
	    p1.add(A);
	    p2.add(B);
	    p3.add(C);
	    
	    Point2D midAB = new Point2D.Double( (A.getX() + B.getX())/2, (A.getY() + B.getY())/2 );
	    Point2D midAC = new Point2D.Double(( A.getX() + C.getX())/2, (A.getY() + C.getY())/2);
	    Point2D midBC = new Point2D.Double((B.getX() + C.getX())/2, (B.getY() + C.getY())/2);
	    
	    p1.add(midBC);
	    p2.add(midAC);
	    p3.add(midAB);
	
	    serpinskiTriangle(A, midAB, midAC);
	    serpinskiTriangle(B, midBC, midAB);
	    serpinskiTriangle(C, midAC, midBC);
	}
	
}
