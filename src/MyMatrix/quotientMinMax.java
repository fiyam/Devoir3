/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyMatrix;

/**
 *
 * @author Elle
 */
public class quotientMinMax {
    static double quotientMinMax(){
        
        
        //mettre p fichier dans p
    int p[]=null;
    double quotient=0;
    int frontiereOptimal[][]=null;
    double mOptimal[][]=null;
    int frontiereMaximal[][]=null;
    double mMaximal[][]=null;
    
   
    D.trouverParenthésageOptimal(0, p, mOptimal, frontiereOptimal);
    H.trouverParenthésageMaximal(0, p, mMaximal, frontiereMaximal);
    double maximum= mMaximal[0][mMaximal.length-1];
    double minimum = mOptimal[0][mOptimal.length-1];
    
    quotient=(maximum)/(minimum);
    System.out.println("Le quotient pour le tableau de longueur "+p.length+" est "+quotient);
    
    return quotient;
    
    }
}
