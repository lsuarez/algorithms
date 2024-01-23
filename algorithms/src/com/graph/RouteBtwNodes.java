package com.graph;

import java.util.LinkedList;

public class RouteBtwNodes {
    enum State{ UNVISITED("unvisited"), VISITED_("visited"), VISITING("visiting");
        
        private String state;

        State(String state) {
            this.state = state;
        }
        public String getState() {
            return state;
        }
    }

    public boolean isThereARoute(Graph graph, Node start, Node end){
        if(start == end){
            return true;
        }
        LinkedList<Node> q= new LinkedList<>();

        for(Node u: graph.getNodes()){
            u.setState(State.UNVISITED.getState());
            q.add(u);
        }
        //start.setState(State.VISITING.getState());

        Node u;
        while(!q.isEmpty()){
            u = q.removeFirst();
            if(u.getChildren()!= null){
                for(Node v:u.getChildren()){
                    if(v.getState().equals(State.UNVISITED.getState())){
                        if(v.getNode().equals(end.getNode())){
                            return true;
                        }else{
                            v.setState(State.VISITING.getState());
                            q.add(v);
                        }
                    }
                }
                u.setState(State.UNVISITED.getState());
            }
        }
        return false;
    }
    public static void main(String[] args) {

        Node[] petFriends= new Node[1];
        petFriends[0]= new Node("Roy", State.UNVISITED.getState());

        Node[] danyFriends= new Node[2];
        danyFriends[0]=new Node("Patricia", State.UNVISITED.getState());
        danyFriends[1]=new Node("Rosa", State.UNVISITED.getState());

        Node[] saraFriends= new Node[3];
        saraFriends[0]= new Node("Dany", danyFriends, State.UNVISITED.getState());
        saraFriends[1]= new Node("Peter",petFriends, State.UNVISITED.getState());
        saraFriends[2]= new Node("Ronald",petFriends, State.UNVISITED.getState());

        Graph g = new Graph(new Node[]{new Node("Sara", saraFriends, State.UNVISITED.getState())});
        RouteBtwNodes obj= new RouteBtwNodes();
        System.out.println(obj.isThereARoute(g, new Node("Sara"), new Node("Peter")));
    }
}
