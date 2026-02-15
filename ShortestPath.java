public class ShortestPath{
    public static void sssp(double[] dist,double[][] cost,int v,int n){
        boolean[] s=new boolean[n];
        for(int i=0;i<n;i++){
            s[i]=false;
            dist[i]=cost[v][i];
        }
        s[v]=true;
        for(int i=0;i<n;i++){
            double min=Double.MAX_VALUE;
            int minVertex=-1;
            for(int u=0;u<n;u++){
                if(dist[u]<min && !s[u]){
                    min=dist[u];
                    minVertex=u;
                }
            }
            if(minVertex==-1) break;
            s[minVertex]=true;
            for(int u=0;u<n;u++){
                if(!s[u] && cost[minVertex][u]<Double.MAX_VALUE){
                    if(dist[u]>(dist[minVertex]+cost[minVertex][u])){
                        dist[u]=(dist[minVertex]+cost[minVertex][u]);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        int n=6;
        double[] dist=new double[n];
        double inf=Double.MAX_VALUE;
        double[][] cost={
            {0,50,45,10,inf,inf},
            {inf,0,10,15,inf,inf},
            {inf,inf,0,inf,30,inf},
            {20,inf,inf,0,15,inf},
            {inf,20,35,inf,0,inf},
            {inf,inf,inf,inf,3,0}
        };
        int v=0;
        sssp(dist, cost, v, n);
        System.out.println("Shortest path from vertex "+v+" to all vertex are: ");
        for(int i=1;i<=n;i++){
            System.out.println((v+1)+" - "+i+" = "+dist[i-1]);
        }
    }
}


