
package MyMatrix;

class B {
    
   public static int trouverParenthesageOptimalRec(int p[],int frontiere[][], int i, int j){
        int minimum=0;
        
        if (i!=j){
            minimum = Integer.MAX_VALUE;
            int gauche, droite,total;
            int frontiereTemp=0;
            for(int k=i; k<=j-1;k++){
                // (Ai...Ak)(Ak...Aj)
                gauche= trouverParenthesageOptimalRec(p,frontiere,i,k);
                droite = trouverParenthesageOptimalRec(p,frontiere,k+1,j);
                total= gauche+droite+ (p[i-1] * p[k] * p[j]);
                if(total<minimum){
                    minimum=total;
                    frontiereTemp=k;
                }
            }
            
            frontiere[i-1][j-1]= frontiereTemp;   
        }
        return minimum;
    }
}
