
package MyMatrix;


public class D {
    
    public static void trouverParenthésageOptimal(int n,int p[],double m[][],int frontiere[][])  {
     
        double  minimum;
        int j;
        for(int i=1 ; i<=n ; i++)
           m[i][i]=0;
        
        
        for ( int s=1 ;s<=n-1;s++){
            for ( int i=1 ;i<=n-s;i++){
                j=i+s;
                minimum = Double.POSITIVE_INFINITY;
                
                for ( int k=i ;k<=j-1;k++){
                    double temp = m[i][k] + m[k+1][j] + p[i-1] * p[k] * p[j];
                    if(temp<minimum){
                        minimum = temp ;
                        int frontiereTemp=k;
                        }
                    }
                m[i][j]=minimum;
                int frontiereTemp = 0;
                frontiere[i][j]=frontiereTemp;
            }
        }
    }
}