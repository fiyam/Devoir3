
package MyMatrix;


public class D {
    
    public static void trouverParenthésageOptimal(int n,int p[],int m[][],int frontiere[][])  {
     
        int  minimum;
        int j,frontiereTemp=0;
        for(int i=1 ; i<=n ; i++)
           m[i][i]=0;
 
        for ( int s=1 ;s<=n-1;s++){
            for ( int i=1 ;i<=n-s;i++){
                j=i+s;
                minimum = Integer.MAX_VALUE;
                
                for ( int k=i ;k<=j-1;k++){
                    int temp = m[i][k] + m[k+1][j] + p[i-1] * p[k] * p[j];
                    if(temp<minimum){
                        minimum = temp ;
                         frontiereTemp=k;
                        }
                    }
                m[i][j]=minimum;
                frontiere[i][j]=frontiereTemp;
            }
        }
    }
}