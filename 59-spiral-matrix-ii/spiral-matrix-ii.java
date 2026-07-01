class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix= new int[n][n];
        int top=0;
        int bottom=n-1;
        int left = 0;
        int right = n-1;
        int number=1;
        while(top<=bottom && left <= right){
            //left to right
            for(int i=left; i<=right; i++){
                matrix[top][i] = number++;
            }
            top ++;

            //top to bottom

            for(int t=top; t<=bottom; t++){
                matrix[t][right]=number++;
            }
            right--;

            //right to left
            if(top<=bottom){
                for(int i=right; i>=left; i--){
                    matrix[bottom][i]=number++;
                }
                bottom--;
            }
            //bottom to top
            if(left<=right) {
                for(int i = bottom; i>=top; i--){
                    matrix[i][left]=number++;
                }
                left++;
            }
        }
        return matrix;
    }
}
