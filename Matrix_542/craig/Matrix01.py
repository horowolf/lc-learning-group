from collections import deque
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        
        
        m = len(matrix);
        n = len(matrix[0]);
        
        myqueue=deque();
        for x, col in enumerate(matrix):
            for y, val in enumerate(matrix[0]):
                if matrix[x][y]==1:
                    matrix[x][y]=sys.maxsize;
                else:
                    myqueue.append([x,y]);  # ensure we will visit nodes with zero val first
                    # visit 1  X
                    
        direction=[[1,0],[-1,0],[0,1],[0,-1]];
        #print(myqueue);
        while len(myqueue)!=0:
            x,y=myqueue.popleft();
            for newnode in direction:
                newx,newy=newnode;
                if -1<x+newx<m and -1<y+newy<n and matrix[x+newx][y+newy]!=0 and matrix[x+newx][y+newy]>matrix[x][y]+1:
                    matrix[x+newx][y+newy]=matrix[x][y]+1;
                    myqueue.append([x+newx,y+newy]); 
                    #print(matrix);
      
        return matrix;
    
