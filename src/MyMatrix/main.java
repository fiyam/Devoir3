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
public class main {
     public static void main(String[] args) {

        //System.out.println("Test de multiplication :");
        int[][] A = {{4, 3}, {2, 1}};
        int[][] B = {{-1, +1}, {1, -2}};
        int[][] C = {{10, 20, 30}, {40, 50, 60}};
        int[][] D = {{0, 9, 40, 77}, {11, 37, 82, 28}};
        int[][] E = {{4, 3, 7, 11}, {2, 1, 11, 15}, {12, -5, 34, 30}, {28, -7, 42, 50}};
        int[][] F = {{1, 25}, {2, 40}, {3, 77}, {4, 112}};
        int[][] G = {{1, 2, 3, 4}, {5, 6, 7, 8}};
        /*
        int[][] matrix = multiplicar(E,F);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

         */
        /*
        int p[] = {13, 5, 89, 3, 34};
        int frontiere[][] = new int[p.length - 1][p.length - 1];
        for (int i = 0; i < frontiere.length; i++) {
            for (int j = 0; j < frontiere[i].length; j++) {
                frontiere[i][j] = 0;
            }
        }

        //  int p[]={2,2,2,3,4,4,2,4};
        int m[][] = new int[p.length - 1][p.length - 1];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = 0;
            }
        }

        trouverParenthesageOptimal(p.length - 1, p, m, frontiere);
        
        int nbMinMulti = m[0][p.length - 2];
        //print frontiere
        System.out.println("Le nombre minimal de multiplications est " + nbMinMulti);
        for (int i = 0; i < frontiere.length; i++) {
            for (int j = 0; j < frontiere[i].length; j++) {
                System.out.print(frontiere[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("La matrice m est " + nbMinMulti);
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        //int p[]={13,5,89,3,34};
        // int frontiere2[][] = {{0,1,1,3}, {0,0,2,3},{0,0,0,3}, {0,0,0,0}};
*/
        testVitesse();
    }

    // Test A **************************************************************
    public static int[][] multiplicar(int[][] A, int[][] B) {

        int aRows = A.length;
        int aColumns = A[0].length;
        int bRows = B.length;
        int bColumns = B[0].length;

        if (aColumns != bRows) {
            throw new IllegalArgumentException("Le nombre de colonnes de la première matrice '" + aColumns + "' n'est pas égal au nombre de lignes de la seconde matrice '" + bRows + "'.");
        }

        int[][] C = new int[aRows][bColumns];
        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bColumns; j++) {
                C[i][j] = 0;
            }
        }

        for (int i = 0; i < aRows; i++) { // aRow
            for (int j = 0; j < bColumns; j++) { // bColumn
                for (int k = 0; k < aColumns; k++) { // aColumn
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C;
    }

    // Test B **************************************************************
    public static int trouverParenthesageOptimalRec(int p[], int frontiere[][], int i, int j) {

        int minimum = 0;

        if (i != j) {
            minimum = Integer.MAX_VALUE;
            int gauche, droite, total;
            int frontiereTemp = 0;
            for (int k = i; k <= j - 1; k++) {
                // (Ai...Ak)(Ak...Aj)
                gauche = trouverParenthesageOptimalRec(p, frontiere, i, k);
                droite = trouverParenthesageOptimalRec(p, frontiere, k + 1, j);
                total = gauche + droite + (p[i - 1] * p[k] * p[j]);
                if (total < minimum) {
                    minimum = total;
                    frontiereTemp = k;
                }
            }
           
            frontiere[i - 1][j - 1] = frontiereTemp;
        }
        return minimum;
    }

    // Test C **************************************************************
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

    // Test D***************************************************************
    public static void trouverParenthesageOptimal(int n, int p[], int m[][], int frontiere[][]) {

        int minimum;
        int j, frontiereTemp = 0;
        
        for (int s = 1; s <=n - 1; s++) {
            for (int i = 1; i <= n - s; i++) {
                j = i + s;
                minimum = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int temp = m[i-1][k-1] + m[k][j-1] + (p[i - 1] * p[k] * p[j]);
                   
                    if (temp < minimum) {
                        minimum = temp;
                        frontiereTemp = k;
                    }
                }
                m[i-1][j-1] = minimum;
                frontiere[i-1][j-1] = frontiereTemp;
            }
        }
    }

     public static void testVitesse() {

        //Meilleur cas
        //Moyen cas
        //Pire cas
        
        int[] test1 = {40, 70, 5,40,87,120,65,89,42,150,500,40, 70, 5,40,87};
        int m[][] = new int[test1.length - 1][test1.length - 1];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = 0;
            }
        }
        int frontiereD[][] = new int[test1.length - 1][test1.length - 1];
        for (int i = 0; i < frontiereD.length; i++) {
            for (int j = 0; j < frontiereD[i].length; j++) {
                frontiereD[i][j] = 0;
            }
        }
            // Test algo D trouverParenthésageOptimal
            
           
            long avantProgDyn = System.nanoTime();
            trouverParenthesageOptimal(test1.length-1, test1,m, frontiereD);
            long apresProgDyn = System.nanoTime();
            
            
            // Test algo C trouverParenthesageOptimalRecOptimise
            int frontiereC[][] = new int[test1.length - 1][test1.length - 1];
        for (int i = 0; i < frontiereC.length; i++) {
            for (int j = 0; j < frontiereC[i].length; j++) {
                frontiereC[i][j] = 0;
            }
        }
       
            long avantMemo = System.nanoTime();
            trouverParenthesageOptimalRecOptimise(test1, frontiereC, 1,test1.length-1);
            long apresMemo = System.nanoTime();
           
            
            //Test algo B trouverParenthesageOptimalRec
            int frontiereB[][] = new int[test1.length - 1][test1.length - 1];
        for (int i = 0; i < frontiereB.length; i++) {
            for (int j = 0; j < frontiereB[i].length; j++) {
                frontiereB[i][j] = 0;
            }
        }

            long avantRec = System.nanoTime();
            trouverParenthesageOptimalRec(test1, frontiereB, 1,test1.length-1);
            long apresRec = System.nanoTime();
            
            
            System.out.println("n = " + (test1.length-1)
                    + ", Algorithme de Programmation Dynamique (D) " + (apresProgDyn - avantProgDyn) / 1000.0
                    + ", Algorithme Récursif Optimisé (C) " + (apresMemo - avantMemo) / 1000.0
                    + ", Algorithme Récursif de base (B) " + (apresRec - avantRec) / 1000.0);
        }


}
