import java.util.*;

public class oper {
	public static void main (String args[]){
		int x,y,z,g=0,sm=0;
		Scanner s = new Scanner(System.in);
        System.out.println("Enter the three values");
        x = s.nextInt();
        y = s.nextInt();
        z = s.nextInt();
        System.out.println("The Sum of three number is "+(x+y+z));
        if(x>y&&x>z)
		   	g=x;
		else if(y>x&&y>z)		
            g=y;
        else
            g=z;
        if(x<y&&x<z)
		   	sm=x;
		else if(y<x&&y<z)		
            sm=y;
        else
            sm=z;
         System.out.println("The largest of the three is "+g);
         System.out.println("The smallest of the three is "+sm);	
        if((x*y)==z)
         System.out.println("The Product of first two values "+x+" and "+y+" is equal to third "+z);			
	 }  
}