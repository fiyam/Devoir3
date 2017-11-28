/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyMatrix;

import java.util.Arrays;

public class F {

    public static void AfficheExpressionRec( int frontiere[][],int p[]) {
        int i = 1;
        int j = p.length;
        int s =  frontiere[i][j];
        
        int p1[] = Arrays.copyOfRange(p, i, s);
        int p2[] = Arrays.copyOfRange(p, s+1 , j);
  
        if(j==i)
            System.out.println ("A"+i );  
        else{
            System.out.println ("(");
            AfficheExpressionRec(frontiere,p1);
            AfficheExpressionRec(frontiere,p2);
            System.out.println (")");
       
        }
     


    }

  
 

}
