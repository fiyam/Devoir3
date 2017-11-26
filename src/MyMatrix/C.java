/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyMatrix;

import java.util.Arrays;



/**
 *
 * @author User
 */
public class C {
    
    public static double trouverParenthesageOptimalRecOptimise(int p[],int frontiere[][], int i, int j){
        double minimum=0;
        
        if (i!=j){
            minimum = Double.POSITIVE_INFINITY;
            double gauche=0, droite=0,total=0 ;
            int frontiereTemp=0;
            for(int k=i; k<=j-1;k++){
                // (Ai...Ak)(Ak...Aj)
                
                double matriceOptimal[][]=null;
                Arrays.fill(matriceOptimal,-1);
                
                if(matriceOptimal[i][k]==-1)
                    matriceOptimal[i][k]=trouverParenthesageOptimalRecOptimise(p,frontiere,i,k);

                
                if(matriceOptimal[k+1][j]==-1)
                    matriceOptimal[k+1][j]=trouverParenthesageOptimalRecOptimise(p,frontiere,k+1,j);

                total= matriceOptimal[i][k] + matriceOptimal[k+1][j] + (p[i-1] * p[k] * p[j]);
                if(total<minimum){
                    minimum=total;
                    frontiereTemp=k;
                }
               
            }
            frontiere[i][j]= frontiereTemp;
            
        }
     
        return minimum;
    }
}
