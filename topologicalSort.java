import java.util.*;
/*
* Java Program to perform topological sort.
  NOte : the nodes must be in incrementing order from 0.
  If a node does not have a destination keep node to INFINITY as an edge.
*/
class TopologicalSort{

    private Map<Integer, LinkedList<Integer>> adjacency_list;
    private LinkedList<Integer> indegreeList;
    private Queue<Integer> queue;
    private static final Integer INFINITY = -999;

    public TopologicalSort(){
        adjacency_list = new HashMap<Integer, LinkedList<Integer>>();
        indegreeList = new LinkedList<Integer>();
        queue = new LinkedList<Integer>();
    }

    public void addEdge(int source, int destination){
        LinkedList<Integer> edgeList = adjacency_list.get(source);

        if (edgeList == null){

            LinkedList<Integer> list = new LinkedList<Integer>();
            if (destination != INFINITY)
             list.add(destination);

            adjacency_list.put(source, list);
        }else{
            if (destination != INFINITY)
             (adjacency_list.get(source)).add(destination);
        }

        //System.out.println(adjacency_list.get(source));
    }

    private void constructIndegree(){
      int indegree = 0;
      for (Integer vertex : adjacency_list.keySet()){
         indegree = 0;
         //System.out.println("the vertex is " + vertex);

         for(Integer key : adjacency_list.keySet())
           if ((adjacency_list.get(key)).contains(vertex))
             indegree++;

         indegreeList.set(vertex, indegree);
    }
  }

    private Set<Integer> retrieveZeroIndegreeVertex(){
      Set<Integer> zeroIndegreeSet = new HashSet<Integer>();
      //System.out.println("the indegree list is retrieveZeroIndegreeVertex :" + indegreeList);
      for (int vertex = 0; vertex < indegreeList.size(); vertex++)
        if (indegreeList.get(vertex).equals(0))
            zeroIndegreeSet.add(vertex);

      return zeroIndegreeSet;
    }

    private void deleteZeroIndegreeVertex(Set<Integer> zeroIndegreeSet){

      for(Integer vertex : zeroIndegreeSet){
        //System.out.println("the vertex is " + vertex);
        indegreeList.set(vertex, (indegreeList.get(vertex) - 1));
        //System.out.println("the indegree list is deleteZeroIndegreeVertex :" + indegreeList);

        LinkedList<Integer> edgeVertex = adjacency_list.get(vertex);

        for (Integer destinationVertex  : edgeVertex)
          indegreeList.set(destinationVertex, (indegreeList.get(destinationVertex) - 1));
        //remove the vertex;
        adjacency_list.remove(vertex);

        //print the vertex;
        System.out.print ("\t"+vertex);
      }
    }

    private void initializeIndegree(){
      //set all the indegree as -1 to indicate empty.
      //System.out.println("the size of the list is " + adjacency_list.keySet().size());
      for (int index = 0; index < adjacency_list.keySet().size(); index++)
        indegreeList.add(-1);
    }

    public void topologicalSort(){

      System.out.print("The topological sort is : " );
      initializeIndegree();

      while(true){
        constructIndegree();
        Set<Integer> zeroIndegreeSet = retrieveZeroIndegreeVertex();

        //System.out.println("The zero set :c" + zeroIndegreeSet);

        if (zeroIndegreeSet.size() == 0)
          return;

        deleteZeroIndegreeVertex(zeroIndegreeSet);
      }
    }

    public static void main(String[] arg){

      Scanner scanner = new Scanner(System.in);
      TopologicalSort topo = new TopologicalSort();

      int source = 0, destination = 0;

      System.out.println("Enter the graph :<format> source destination");
      while(true){
        source = scanner.nextInt();
        destination = scanner.nextInt();

        if (source ==  -999 && destination == -999)
          break;

        topo.addEdge(source,destination);
      }

      topo.topologicalSort();
      System.out.println();
    }

}
