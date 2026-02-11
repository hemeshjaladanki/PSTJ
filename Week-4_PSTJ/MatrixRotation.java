import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class MatrixRotation {

    /*
     * Complete the 'matrixRotation' function below.
     *
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY matrix
     *  2. INTEGER r
     */

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
    // Write your code here
    int m = matrix.size();
    int n = matrix.get(0).size();

    int layers = Math.min(m, n) / 2;

    for (int layer = 0; layer < layers; layer++) {
        List<Integer> ring = new ArrayList<>();

        int top = layer;
        int left = layer;
        int bottom = m - 1 - layer;
        int right = n - 1 - layer;

        for (int j = left; j <= right; j++)
            ring.add(matrix.get(top).get(j));

        for (int i = top + 1; i < bottom; i++)
            ring.add(matrix.get(i).get(right));

        for (int j = right; j >= left; j--)
            ring.add(matrix.get(bottom).get(j));

        for (int i = bottom - 1; i > top; i--)
            ring.add(matrix.get(i).get(left));

        int len = ring.size();
        int rot = r % len;

        Collections.rotate(ring, -rot);

        int idx = 0;

        for (int j = left; j <= right; j++)
            matrix.get(top).set(j, ring.get(idx++));

        for (int i = top + 1; i < bottom; i++)
            matrix.get(i).set(right, ring.get(idx++));

        for (int j = right; j >= left; j--)
            matrix.get(bottom).set(j, ring.get(idx++));

        for (int i = bottom - 1; i > top; i--)
            matrix.get(i).set(left, ring.get(idx++));
    }

    for (List<Integer> row : matrix) {
        for (int val : row) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}


    }



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] matrixRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> matrixRowItems = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int matrixItem = Integer.parseInt(matrixRowTempItems[j]);
                matrixRowItems.add(matrixItem);
            }

            matrix.add(matrixRowItems);
        }

        Result.matrixRotation(matrix, r);

        bufferedReader.close();
    }
}

