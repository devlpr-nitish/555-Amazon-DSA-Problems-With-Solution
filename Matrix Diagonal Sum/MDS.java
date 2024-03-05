
public class MDS {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;
        for(int i= 0; i< n;i++){

            //Primary diagonal sum
            sum+=mat[i][i];
            //Secondry diagonal sum ( elements of primary diagonal are not included)
            if(i != n - 1-i){
                sum+=mat[i][n-1-i];
            }
        }
        return sum;
    }
}
