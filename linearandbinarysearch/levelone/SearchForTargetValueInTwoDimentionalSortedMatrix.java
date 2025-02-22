package com.bridgelabz.linearandbinarysearch.levelone;

public class SearchForTargetValueInTwoDimentionalSortedMatrix {
    public static boolean searchMatrix(int[][] matrix, int target){
        int row = matrix.length;
        int col = matrix[0].length;
        int low = 0;
        int high = matrix.length * matrix[0].length - 1;

        while(low <= high){

            int mid = low + (high-low)/2;

            int r = mid / col;
            int c = mid % col;
            if(matrix[r][c] == target) return true;
            if(matrix[r][c] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 34;

        boolean isPresent = searchMatrix(matrix, target);

        System.out.println("the element is present: " + isPresent);
    }
}
