

public class Matrix01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] m = {{0,0,0},{0,1,0},{1,1,1}};
		System.out.println(updateMatrix(m));
	}

	public static int[][] updateMatrix(int[][] matrix) {
        int[][] temp = new int[matrix.length + 2][matrix[0].length + 2];
        for (int i = 0; i < temp.length; i++) {
        	for (int j = 0; j < temp[0].length; j++) {
        		temp[i][j] = Integer.MAX_VALUE;
        	}
        }
        for (int i = 0; i < matrix.length; i++) {
        	for (int j = 0; j < matrix[0].length; j++) {
            	temp[i + 1][j + 1] = matrix[i][j];
            }
        }
        
        Boolean changed = false;
		
        do {
        	changed = false;
        	for (int i = 1; i <= matrix.length; i++) {
            	for (int j = 1; j <= matrix[0].length; j++) {
            		if (temp[i][j] == 0) {
            			continue;
            		}
            		
            		int h = Integer.min(temp[i][j - 1], temp[i][j + 1]);
            		int v = Integer.min(temp[i - 1][j], temp[i + 1][j]);
            		int min = Integer.min(h, v);
            		if (temp[i][j] != min + 1) {
            			temp[i][j] = min + 1;
            			changed = true;
            		}
            		
            	}
        	}
        } while (changed);
        
		
		int[][] result = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
        	for (int j = 0; j < matrix[0].length; j++) {
            	result[i][j] = temp[i + 1][j + 1];
            }
        }
		
		return result;
    }

}
