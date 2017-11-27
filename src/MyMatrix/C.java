/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyMatrix;

import java.util.Arrays;

public class C {
     public static int trouverParenthesageOptimalRecOptimise(int p[], int frontiere[][], int i, int j) {
        int minimum = 0;

        if (i != j) {
            minimum = Integer.MAX_VALUE;
            int gauche = 0, droite = 0, total = 0;
            int frontiereTemp = 0;
            for (int k = i; k <= j - 1; k++) {
                // (Ai...Ak)(Ak...Aj)

                int matriceOptimal[][] = new int[p.length][p.length];
                for (int l = 0; l < matriceOptimal.length; l++) {
                    for (int m = 0; m < matriceOptimal[l].length; m++) {
                        matriceOptimal[l][m] = -1;
                    }
                }

                if (matriceOptimal[i][k] == -1) {
                    matriceOptimal[i][k] = trouverParenthesageOptimalRecOptimise(p, frontiere, i, k);
                }

               
                if (matriceOptimal[k + 1][j] == -1) {
                    matriceOptimal[k + 1][j] = trouverParenthesageOptimalRecOptimise(p, frontiere, k + 1, j);
                }

                total = matriceOptimal[i][k] + matriceOptimal[k + 1][j] + (p[i - 1] * p[k] * p[j]);
                if (total < minimum) {
                    minimum = total;
                    frontiereTemp = k;
                }

            }
            frontiere[i - 1][j - 1] = frontiereTemp;

        }

        return minimum;
    }
}
