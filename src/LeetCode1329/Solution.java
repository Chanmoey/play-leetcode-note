package LeetCode1329;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Chanmoey
 * @date 2022年08月28日
 */
class Solution {

    public int[][] diagonalSort(int[][] mat) {
        final int totalRows = mat.length;
        final int totalCols = mat[0].length;

        List<Integer> diagonalElements;
        for (int row = 0; row < totalRows; row++) {
            int i = row;
            int j = 0;

            diagonalElements = new ArrayList<>();
            while (i < totalRows && j < totalCols) diagonalElements.add(mat[i++][j++]);
            Collections.sort(diagonalElements);

            i = row;
            j = 0;
            int k = 0;

            while (i < totalRows && j < totalCols) mat[i++][j++] = diagonalElements.get(k++);
        }

        for (int col = 0; col < totalCols; col++) {
            int i = 0;
            int j = col;

            diagonalElements = new ArrayList<>();
            while (i < totalRows && j < totalCols) diagonalElements.add(mat[i++][j++]);
            Collections.sort(diagonalElements);

            i = 0;
            j = col;
            int k = 0;

            while (i < totalRows && j < totalCols) mat[i++][j++] = diagonalElements.get(k++);
        }

        return mat;
    }
}