/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astar;

import java.io.PrintStream;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

/**
 *
 * @author Sadeeb
 */
public class Astar {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here
//        2 4 5 1 
//3 6 9 0 
//7 12 14 8 
//10 11 13 15
        
        int[][] contents = new int[][]{ {6 , 1 , 3 , 4}, {5 , 2 , 7 , 8}, {0 , 9, 15, 11},{13, 10, 14, 12}};
     //   Create c = new Create();
       // exit(0);
        Grid g= new Grid(contents);
        Grid[] space = new Grid[100000];
        int l=1;
        space[0]=g;
        boolean found=false;
        System.out.println(g.Heuristic());
        g.print();
        g.expand();
        for(int i=0;i<g.size;i++){
            space[i] = g.child[i];      
          //  System.out.println(space[i].Heuristic());
            //space[i].print();
           
        }
       //exit(0);
        int x=g.size;
        Grid dest = null;
        System.out.println("");
        while(found==false)
        {
           // Scanner sc = new Scanner(System.in);
         //   int z=sc.nextInt();
            int min=10000000;
            int in=-1;
            for(int i=0;i<x;i++)
            {
               // System.out.println("Not Expanded:");
                //space[i].print();
               // System.out.println(space[i].Heuristic());
                if(space[i].check()){
                    found=true;
                    dest=space[i];
                    System.out.println("found");
                    break;
                }
                if(space[i].Heuristic()<=min && space[i].expanded==false)
                {
                    boolean w=false;
                    for(int r=0;r<x;r++){
                        if(space[r].expanded==true){
                            if(space[r].equal(space[i])){
                                w=true;
                                space[i].expanded=true;
                            }
                        }
                    }
                    if(w)continue;
                    min=space[i].Heuristic();
                    in=i;
                }
            }
            if(found)break;
            space[in].expand();
         //   System.out.println("Selected:");
           // space[in].print();
            for(int i=0;i<space[in].size;i++)
            {
                space[i+x]=space[in].child[i];
                //System.out.println("x");
            }
            x+=space[in].size;
            System.out.println(x);
            
        }
        System.out.println(x);
        System.out.println("Path:");
        Stack<Grid> s = new Stack();
        while(dest!=g)
        {
           s.push(dest);
            dest=dest.prev;
        }
        s.push(g);
        int i=0;
        
        while(!s.empty())
        {
            i++;
            System.out.println("Move:"+i);
            Grid t=s.peek();
            t.print();
            s.pop();
        }      
    }}
    

