public class MagicSquare {

    /**
     *
     * @param array2d
     * @return the sum of the first row in array2d.
     */
    public static int calculateCheckSum(int[][] array2d) {
        int sum = 0;
        for (int i = 0; i < array2d[0].length; i++){
            sum+=array2d[0][i];
        }
        return sum;
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each row in array2d is equal to checkSum or not.
     *         Because we have already determined the sum of the first row
     *         via the method 'calculateCheckSum', this method can begin
     *         iterating from the second row.
     */
    public static boolean magicRows(int[][] array2d, int checkSum) {
        for (int i = 0; i < array2d.length; i++){
            int sum = 0;
            for (int j = 0; j < array2d[0].length; j++){
                sum+=array2d[i][j];
            }
            if(sum!=checkSum) return false;
        }
        return true;
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each column in array2d is equal to checkSum or not.
     */
    public static boolean magicColumns(int[][] array2d, int checkSum) {
        for (int i = 0; i < array2d[0].length; i++){ //realized that it's a square so adding [0] isn't necessary but im too lazy to change it
            int sum = 0;
            for (int j = 0; j < array2d.length; j++){
                sum+=array2d[j][i];
            }
            if(sum!=checkSum) return false;
        }
        return true;
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each of the two main diagonals is equal to checkSum or not.
     */
    public static boolean magicDiagonals(int[][] array2d, int checkSum) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < array2d.length; i++){
            sum1+=array2d[i][i];
            sum2+=array2d[i][array2d.length-i-1];
        }
        if(sum1!=checkSum || sum2!=checkSum) return false;
        return true;
    }

    /**
     *
     * @param array2d
     * @return whether array2d is magic or not.
     */
    public static boolean isMagic(int[][] array2d) {
        int sum = calculateCheckSum(array2d);
        if(magicRows(array2d, sum) && magicColumns(array2d, sum) && magicDiagonals(array2d, sum)){
            return true;
        }
        return false;
    }

}
