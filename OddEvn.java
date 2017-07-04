/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nishath parthasarthy
 */

import java.util.*;

public class OddEvn {
  public static void main(String args[]){
     int x,r,a=0,b=0,c=0;
     Scanner s = new Scanner(System.in);
     x = s.nextInt();
     while(x>0){
        r = x%10;
        if(r%2==0)
            a++;
        else
            b++;
        if(r==0)
            c++;
        x/=10;
     }
     System.out.println(a+""+b+""+c);
   }    
}
