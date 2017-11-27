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
    
    public static void trouverParenthésageMaximal(int n,int p[],double m[][],int frontiere[][])  {
     
        double  maximum=0;
        int j,frontiereTemp=0;
        for(int i=1 ; i<=n ; i++)
           m[i][i]=Double.POSITIVE_INFINITY;
 
        for ( int s=1 ;s<=n-1;s++){
            for ( int i=1 ;i<=n-s;i++){
                j=i+s;
                maximum = 0;
                
                for ( int k=i ;k<=j-1;k++){
                    double temp = m[i][k] + m[k+1][j] + p[i-1] * p[k] * p[j];
                    if(temp>maximum){
                        maximum = temp;
                         frontiereTemp=k;
                        }
                    }
                m[i][j]=maximum;
                frontiere[i][j]=frontiereTemp;
            }
        }
    }
    
}
