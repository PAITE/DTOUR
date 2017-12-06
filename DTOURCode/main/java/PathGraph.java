import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PathGraph {

    class HeapEdge {
        int source;
        int dest;
        double priority;

        HeapEdge(int src, int dst, double prity) {
            this.source = src;
            this.dest = dst;
            this.priority = prity;
        }
    }

    class Heap_In {
        HeapEdge root;
        PriorityQueue<HeapEdge> children;
        MinHeap children_;
        

        Heap_In() {
            this.root = null;
            children =  new PriorityQueue<HeapEdge>(100, new Comparator<HeapEdge>() {
                public int compare(HeapEdge a, HeapEdge b) {
                    if(a.priority < b.priority) return -1;
                    if(a.priority == b.priority) return 0;
                    if(a.priority > b.priority) return 1;
                    return 0;
                }
            });
            
            children_=new MinHeap<HeapEdge>(100);
            
            
        }
    }

    HashMap<Integer, Heap_In> Hin_Collection;

    /* Constructure just initializes the HashMap we need */
    PathGraph() {
        Hin_Collection = new HashMap<Integer, Heap_In>();
    }

    /* Method to add H_in nodes. If the Heap already existed, then just add the node in as root. If it didn't,
     * then first create the heap, and then add it in
     */
    void addHinEdge(int src, int dest, double priority) {
        if(this.Hin_Collection.get(dest) == null) {
            Heap_In newHeap = new Heap_In();
            HeapEdge newNode = new HeapEdge(src, dest, priority);
            newHeap.root = newNode;
            this.Hin_Collection.put(dest, newHeap);
        } else {
            Heap_In corrHeap = this.Hin_Collection.get(dest);
            if(priority >= corrHeap.root.priority) {
                corrHeap.children.add(new HeapEdge(src, dest, priority));
            } else {
                corrHeap.children.add(new HeapEdge(corrHeap.root.source, corrHeap.root.dest, corrHeap.root.priority));
                corrHeap.root.source = src;
                corrHeap.root.dest = dest;
                corrHeap.root.priority = priority;
            }
        }
    }
}