import java.util.HashMap;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataSource mySource = new StaticData_Implement();
        Heuristic myHeuristic = new NullHeuristic_Implement();
        PathGraph myPathGraph = new PathGraph();
        AStar myAlgo = new AStar(0,3, mySource, myHeuristic, myPathGraph);

        // Currently the A* code stops running once it finds a path to the destination - I have this while loop here
        // to keep running it until it completes (finds shortest/most probabilistic path to destination), but we can
        // remove this loop and just run it once. Or we could try to implement the feedback scheduling from the paper.
        while(!myAlgo.searchComplete)
            myAlgo.runAlgo();
        List<Integer> order = myAlgo.reconstructPath();
        
        //myPathGraph.treeHeapCollection = new HashMap<Integer,Heap_In>(myPathGraph.Hin_Collection);
       //myPathGraph.treeHeapCollection=new HashMap(myPathGraph.Hin_Collection);
        
        int dest=order.get(order.size()-1);
        
        // run dijkstra on dest to find k paths
        
        
        
        

        for(int i=1;i<order.size();i++) {
        	
        	//PathGraph.Heap_In s=myPathGraph.treeHeapCollection.get(order.get(i));
        	
        	//s.root=myPathGraph.treeHeapCollection.get(order.get(i-1)).root;
        	 
        	
        	//System.out.println(e.toString());
        	
        
        
        
        };
        
        //myPathGraph.treeHeapCollection=myPathGraph.Hin_Collection;
        
        
        System.out.println(myPathGraph.Hin_Collection.get(1).root.dest);
    }
}
