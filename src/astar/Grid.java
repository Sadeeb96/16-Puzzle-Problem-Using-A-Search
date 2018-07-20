/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astar;

/**
 *
 * @author Sadeeb
 */
public class Grid {
    int[][] X;
    Grid prev;
    Grid[] child;
    int level;
    boolean expanded;
    int size;
    Grid(int[][] Y){
        this.X = new int[4][4];
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                this.X[i][j]=Y[i][j];
            }
        }
        this.prev=null;
        this.level=0;
        this.expanded=false;
                
    }
    public int Heuristic(){
        int h=0;
    for (int i = 0; i < 4; i++){ // x-dimension, traversing rows (i)
    for (int j = 0; j < 4; j++) { // y-dimension, traversing cols (j)
        int value = this.X[i][j]; // tiles array contains board elements
        if (value != 0) { // we don't compute MD for element 0
            int targetX = (value - 1) / 4; // expected x-coordinate (row)
            int targetY = (value - 1) % 4; // expected y-coordinate (col)
            int dx = i - targetX; // x-distance to expected coordinate
            int dy = j - targetY; // y-distance to expected coordinate
            h+= Math.abs(dx) + Math.abs(dy); 
        } 
    } 
    }
    return h+this.level;
    }
    public void expand(){
        int[] xAxis = new int[] {1, -1, 0,0};
        int[] yAxis = new int[] {0, 0, 1,-1};
        
        int x = 0,y = 0;
     for(int i=0;i<4;i++)
     {
         for(int j=0;j<4;j++){
             if(this.X[i][j]==0){
                 x=i;
                 y=j;
             }
         }
     }
    // int size;
     if(x>0 && x<3 && y>0 && y<3)size=4;
     else if((x==0 && y==0) || (x==0 && y==3) || (x==3 && y==0) || (x==3 || y==3))size=2;
     else size=2;
     this.child = new Grid[size+1];
     //Grid[] child = null;
     int count=0;
     while(count<size){
     for(int i=0;i<4;i++){
         if(x+xAxis[i]>=0 && x+xAxis[i]<=3 && y+yAxis[i]>=0 && y+yAxis[i]<=3){
             
             Grid child= new Grid(this.X);
             int temp =child.X[x][y];
             child.X[x][y]=child.X[x+xAxis[i]][y+yAxis[i]];
             child.X[x+xAxis[i]][y+yAxis[i]]=temp;
             child.prev=this;
             child.level=child.prev.level+1;
             this.child[count++]=child;
            // System.out.println("count:"+count);
             //System.out.println(size);
             //count++;
             this.expanded=true;
             //System.out.println(count+" Child   Heuristic="+child.Heuristic());
             //child.print();
         }
     }
     }
    }
    public boolean check()
    {
         int[][] contents = new int[][]{ {1, 2, 3,4}, {5, 6, 7,8}, {9, 10, 11,12},{13,14,15,0}};
       
        int c=1;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
             if(this.X[i][j]!=contents[i][j])return false;   
            }
        }
        return true;
    }
    public void print()
    {
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                
                System.out.print(this.X[i][j]);
                if(this.X[i][j]<10)System.out.print("  ");
                else System.out.print(" ");
            }
            System.out.println("");
        }
    }
    public boolean equal(Grid b){
        int n=0;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(this.X[i][j]==b.X[i][j]){
                    n++;
                }
            }
        }
        return n==16;
    }
}
