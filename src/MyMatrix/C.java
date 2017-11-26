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
    
    public static double trouverParenthesageOptimalRec(int p[],int frontiere[][], int i, int j){
        double minimum=0;
        
        if (i!=j){
            minimum = Double.POSITIVE_INFINITY;
            double gauche=0, droite=0,total=0 ;
            int frontiereTemp=0;
            for(int k=i; k<=j-1;k++){
                // (Ai...Ak)(Ak...Aj)
                
                double matriceOptimal[][]=null;
                Arrays.fill(matriceOptimal,-1);
                
                if(matriceOptimal[i][k]==-1){
                    gauche= trouverParenthesageOptimalRec(p,frontiere,i,k);
                    matriceOptimal[i][k]=gauche;
                }
                
                if(matriceOptimal[k+1][j]==-1){
                    droite = trouverParenthesageOptimalRec(p,frontiere,k+1,j);
                    matriceOptimal[k+1][j]=droite;
                }
                
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
