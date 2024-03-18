package com.algorithms.greedy;

import java.util.*;
import java.util.LinkedList;

public class WeightedGraphsSec {
	static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }
	static class Graph{
		//graph is a collection of vertices and edges
		int vertices;
		//each vertex has a list of edges
        LinkedList<Edge> [] adjacencylist;

        Graph(int vertices) {
            this.vertices = vertices;
            adjacencylist = new LinkedList[vertices];
            //initialize adjacency lists for each of the vertices
            for (int i = 0; i <vertices ; i++) {
                adjacencylist[i] = new LinkedList<>();
            }
        }
        
        
        
        public void printGraph(){
            for (int i = 0; i <vertices ; i++) {
                LinkedList<Edge> list = adjacencylist[i];
                for (int j = 0; j <list.size() ; j++) {
                    System.out.println("vertex-" + i + " is connected to " +
                            list.get(j).destination + " with weight " +  list.get(j).weight);
                }
            }
        }
        
        public void addEgde(int source, int destination, int weight) {
            Edge edge = new Edge(source-'A', destination-'A', weight);
            adjacencylist[source-'A'].addFirst(edge); //for directed graph
        }
        
        
        
        public static int[] dijkstra(Graph graph, int vertices, int source) {
        	int[] dist = new int[vertices];
        	Arrays.fill(dist, Integer.MAX_VALUE);
        	dist[source-'A'] = 0;
        	Queue<Integer> queue = new LinkedList<>();
        	queue.add(source-'A');
        	while(!queue.isEmpty()) {
        		Integer front = queue.poll();
        		List<Edge> adjList = graph.adjacencylist[front];
        		for(int i = 0; i < adjList.size(); i++) {
        			Edge temp = adjList.get(i);
        			if(dist[front] + temp.weight < dist[temp.destination]) {
        				dist[temp.destination] = dist[front] + temp.weight;
        				queue.add(temp.destination);
        			}
        			
        		}
        	}
        	return dist;
        }
        
        //can do using hashmap?
        
        public static void main(String[] args) {
        	 int vertices = 6;
        	 Graph graph = new Graph(vertices);
        	
        	 graph.addEgde('A', 'B', 2);
        	 graph.addEgde('B', 'A', 2);
        	 graph.addEgde('A', 'D', 8);
        	 graph.addEgde('D', 'A', 8);
        	 graph.addEgde('B', 'D', 5);
        	 graph.addEgde('D', 'B', 5);
        	 graph.addEgde('B', 'E', 6);
        	 graph.addEgde('E', 'B', 6);
        	 graph.addEgde('D', 'E', 3);
        	 graph.addEgde('E', 'D', 3);
        	 graph.addEgde('D', 'F', 2);
        	 graph.addEgde('F', 'D', 2);
        	 graph.addEgde('E', 'F', 1);
        	 graph.addEgde('F', 'E', 1);
        	 graph.addEgde('F', 'C', 3);
        	 graph.addEgde('C', 'F', 3);
        	 graph.addEgde('E', 'C', 9);
        	 graph.addEgde('C', 'E', 9);
        	
             graph.printGraph();
             
             int[] res = dijkstra(graph,vertices, 'A') ;
             for(int i = 0; i<res.length;i++) {
            	 System.out.println("Shortest Distance from A to "+((char)(i+'A'))+" is "+res[i]);
             }
		}
	}
}
