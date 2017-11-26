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
public class E  {

    public static void testVitesse() {

        //Meilleur cas
        //Moyen cas
        //Pire cas
        
        int[] test1 = {40, 70, 5, 4, 12, 25, 10, 41, 79, 30, 7, 100,
            7, 300, 40, 15, 68, 200, 6, 150, 48, 80, 18, 222, 110, 290};
        
            // Test algo D trouverParenthésageOptimal
            int frontiereD[][]=null;
            double m[][]=null;
            long avantProgDyn = System.nanoTime();
            D.trouverParenthésageOptimal(test1.length-1, test1,m, frontiereD);
            long apresProgDyn = System.nanoTime();
            
            
            // Test algo C trouverParenthesageOptimalRecOptimise
            int frontiereC[][]=null;
            long avantMemo = System.nanoTime();
            C.trouverParenthesageOptimalRecOptimise(test1, frontiereC, 0,test1.length-1);
            long apresMemo = System.nanoTime();
            
            //Test algo B trouverParenthesageOptimalRec
            int frontiereB[][]=null;
            long avantRec = System.nanoTime();
            B.trouverParenthesageOptimalRec(test1, frontiereB, 0,test1.length-1);
            long apresRec = System.nanoTime();
            
            
            System.out.println("n = " + (test1.length-1)
                    + ", " + (apresProgDyn - avantProgDyn) / 1000.0
                    + ", " + (apresMemo - avantMemo) / 1000.0
                    + ", " + (apresRec - avantRec) / 1000.0);
        }

    
}
