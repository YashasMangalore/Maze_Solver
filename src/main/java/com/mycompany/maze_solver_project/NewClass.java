/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze_solver_project;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import javax.swing.JFrame;

/**
 *
 * @author yasha
 */
public class NewClass extends JFrame
{
    private int[][] maze = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
        {1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1},
        {1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1},
        {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1},
        {1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1},
        {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 9, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
//        private int[][] maze = {
//        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//        {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
//        {1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1},
//        {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
//        {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
//        {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
//        {1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1},
//        {1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
//        {1, 0, 0, 0, 1, 0, 1, 0, 9, 0, 1, 0, 1},
//        {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1},
//        {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
//        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
//    };

    
    public List<Integer> path=new ArrayList<>();
    
    public NewClass()
    {
        setTitle("Maze Solver");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DFS.searchpath(maze, 1, 1, path);
    }
    
    @Override
    public void paint(Graphics g)
    {
        g.translate(50, 50);
        for(int i=0;i<maze.length;i++)
        {
            for(int j=0;j<maze[0].length;j++)
            {
                Color colr;
                switch(maze[i][j])
                {
                    case 1:colr=Color.BLACK;
                    break;
                    case 9:colr=Color.RED;
                    break;
                    default:colr=Color.WHITE;
                    break;
                }
                g.setColor(colr);
                g.fillRect(30*j, 30*i, 30, 30);
                g.setColor(Color.RED);
                g.drawRect(30*j, 30*i, 30, 30);
                
            }
        }
        
        g.setColor(Color.RED);//Starting point
        g.fillRect(30*1, 30*1, 30, 30);
        
        for(int i = 0; i < path.size(); i = i + 2) {
            int pathx = path.get(i);
            int pathy = path.get(i + 1);

            // Calculate the coordinates to draw the rectangle at the center
            int rectX = 30 * pathx + 5; // Offset by half the width of the rectangle (20 / 2 = 10)
            int rectY = 30 * pathy + 5; // Offset by half the height of the rectangle (20 / 2 = 10)

            g.setColor(Color.GREEN);
            g.fillRect(rectX, rectY, 20, 20);
        }


        
//        for(int i=0;i<path.size();i=i+2)
//        {
//            int pathx=path.get(i);
//            int pathy=path.get(i+1);
//            
//            g.setColor(Color.GREEN);
//            g.fillRect(30*pathx,30*pathy,25,25);
//        }
    }
        public static void main(String[] args)
    {
        NewClass view=new NewClass();
        view.setVisible(true);
    }
}

