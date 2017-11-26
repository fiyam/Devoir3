/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyMatrix;

public class F {
    static void expressionRec(int p[],int frontiere[][]){
        int nbMatrices = p.length-1;
        int k = frontiere[1][nbMatrices];
        
        // gauche
        int pGauche[]=null;
        for(int i=0;i<k;i++){
            pGauche[i]=p[i];
        }
        
        //droite
        int pDroite[]=null;
        for(int j=k+1;j<nbMatrices;j++){
            pGauche[j]=p[j];
        }

        int frontiereGauche[][]=null;
        C.trouverParenthesageOptimalRecOptimise(pGauche,frontiereGauche, 0, k);
        
        int frontiereDroite[][]=null;
        C.trouverParenthesageOptimalRecOptimise(pDroite,frontiereDroite, k+1, nbMatrices);
        
        // p est adapté et on crée a chaque fois une nouvelle matrice frontiere?
        
        expressionRec(pGauche,frontiereGauche);
        
        
        expressionRec(pDroite,frontiereDroite);
        
        
        
    }
    
}
