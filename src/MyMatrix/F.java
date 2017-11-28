/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyMatrix;

import java.util.Arrays;

public class F {

    public static void afficheExpression(int frontiere[][], int p[]) {

        afficheExpressionRec(frontiere, 1, p.length - 1);

    }
    static void afficheExpressionRec(int[][] s, int i, int j) {
        if (i == j) {
            System.out.print(("A") + (i));
            if (i != s[0].length && j != s[0].length) {
                System.out.print("*");
            }
        } else {
            System.out.print("(");
            afficheExpressionRec(s, i, s[i - 1][j - 1]);
            afficheExpressionRec(s, s[i - 1][j - 1] + 1, j);
            System.out.print(")");
        }
    }

  
 

}
