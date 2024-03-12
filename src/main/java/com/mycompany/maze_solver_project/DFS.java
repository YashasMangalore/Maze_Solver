/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze_solver_project;
import java.util.*;
/**
 *
 * @author yasha
 */
public class DFS {
    public static boolean searchpath(int[][] maze,int y,int x, List<Integer> path)
    {//y coordinate == row ; x coordinate == col
        if(maze[y][x]==9)
        {
            path.add(x);
            path.add(y);
            return true;
        }
        
        if(maze[y][x]==0)
        {
            maze[y][x]=2;
            int[] delrow={-1,0,1,0};
            int[] delcol={0,1,0,-1};
            
            for(int i=0;i<4;i++)
            {
                int row=delrow[i]+x;
                int col=delcol[i]+y;
                if(searchpath(maze,col,row,path))
                {
                    path.add(x);
                    path.add(y);
                    return true;
                }
            }
        }
        
        return false;
    }
    
}
