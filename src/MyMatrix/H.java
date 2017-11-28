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
public class H {
    
     public static void trouverParenthesageMinimal(int n, int p[], int m[][], int frontiere[][]) {

        int maximum;
        int j, frontiereTemp = 0;

        for (int s = 1; s <= n - 1; s++) {
            for (int i = 1; i <= n - s; i++) {
                j = i + s;
                maximum = Integer.MIN_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int temp = m[i - 1][k - 1] + m[k][j - 1] + (p[i - 1] * p[k] * p[j]);

                    if (temp > maximum) {
                        maximum = temp;
                        frontiereTemp = k;
                    }
                }
                m[i - 1][j - 1] = maximum;
                frontiere[i - 1][j - 1] = frontiereTemp;
                
            }
        }
    }
    
}
