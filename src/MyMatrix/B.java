/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyMatrix;

class B {
    
    public static double trouverParenthesageOptimalRec(int p[],int frontiere[][], int i, int j){
        double minimum=0;
        
        if (i!=j){
            minimum = Double.POSITIVE_INFINITY;
            double gauche, droite,total;
            int frontiereTemp=0;
            for(int k=i; k<=j-1;k++){
                // (Ai...Ak)(Ak...Aj)
                gauche= trouverParenthesageOptimalRec(p,frontiere,i,k);
                droite = trouverParenthesageOptimalRec(p,frontiere,k+1,j);
                total= gauche+droite+ (p[i-1] * p[k] * p[j]);
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
