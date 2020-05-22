/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package havuzproblemi;


import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.view.Viewer;


/**
 *
 * @author beyter
 */
public class HavuzProblemi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    /*   EdmondsKarp edmon = new EdmondsKarp(8, 15);
       edmon.addEdge(0,1, 8);
       edmon.addEdge(0,2, 7);
       edmon.addEdge(0,3, 4);
       edmon.addEdge(1,2, 2);
       edmon.addEdge(1,4, 3);
       edmon.addEdge(1,5, 9);
       edmon.addEdge(2,3, 5);
       edmon.addEdge(2,5, 6);
       edmon.addEdge(3,5, 7);
       edmon.addEdge(3,6, 2);
       edmon.addEdge(4,7, 9);
       edmon.addEdge(5,4, 3);
       edmon.addEdge(5,7, 5);
       edmon.addEdge(5,6, 4);
       edmon.addEdge(6,7, 8);*/
       MaxFlow edmon = new MaxFlow(6, 8);
       edmon.addEdge(0,1, 3);
       edmon.addEdge(0,2, 3);
       edmon.addEdge(1,2, 2);
       edmon.addEdge(1,3, 3);
       edmon.addEdge(2,4, 2);
       edmon.addEdge(3,5, 2);
       edmon.addEdge(3,4, 4);
       edmon.addEdge(4,5, 3);       
       System.out.println("cevap "+edmon.startFlow(0, 5));
  
    }

}
