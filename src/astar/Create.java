/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astar;

import java.util.Random;

/**
 *
 * @author Sadeeb
 */
public class Create {
    int[][] contents;
    public Create()
    {
         contents = new int[][]{ {1 , 2 , 3 , 4}, {5 , 6 , 7 , 8}, {9 , 10, 11, 12},{13, 14, 15, 0}};
        int[] xAxis = new int[] {1, -1, 0,0};
        int[] yAxis = new int[] {0, 0, 1,-1};
        for(int i=0;i<20;i++)
        {
            int x=0,y=0;
            for(int j=0;j<4;j++){
                for(int k=0;k<4;k++)
                {
                    if(contents[j][k]==0){
                        x=j;y=k;
                    }
                }
            }
            boolean found=false;
            while(!found){
            Random rand=new Random();
            int value=rand.nextInt(4);
            if(x+xAxis[value]>=0 && x+xAxis[value]<=3 && y+yAxis[value]>=0 && y+yAxis[value]<=3){
             found=true;
             int temp = contents[x][y];
             contents[x][y]=contents[x+xAxis[value]][y+yAxis[value]];
             contents[x+xAxis[value]][y+yAxis[value]]=temp;
            }
            }
            /*for(int j=0;j<4;j++){
                for(int k=0;k<4;k++){
                    System.out.print(contents[j][k]+" ");
                }
                System.out.println("");
            }*/
        }
        }
        }
        
    

