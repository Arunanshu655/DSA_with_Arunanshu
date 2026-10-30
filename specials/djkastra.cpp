class Solution {
public:
    // int solve(int n, vector<vector<pair<int,int>>>& edges, string labels, int k, int curr, int prev){
    // }
    int shortestPath(int n, vector<vector<int>>& edges, string labels, int k) {
        vector<vector<pair<int,int>>> adj(n);
        // vector<bool> vis(n,false);

        for(vector<int> edge : edges){
            int u = edge[0], v = edge[1], w = edge[2];
            adj[u].push_back(make_pair(v,w));
        }

        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;

        pq.push({0,0,1});
        vector<vector<long long>> dist(n,
        vector<long long> (k+1,LLONG_MAX)
        );
        dist[0][1]=0;

        while(!pq.empty()){
            int d = pq.top()[0];
            int u = pq.top()[1];
            int cnt = pq.top()[2];

            for(auto neigh : adj[u]){
                int v = neigh.first, w = neigh.second, c = cnt;
                if(labels[v] == labels[u]) c++;
                else c = 1;
                if(c>k) continue;
                if(d+w < dist[v][c]){
                    dist[v][c] = d + w;
                    pq.push({(int) dist[v][c],v,c});
                }
            }
            pq.pop();
        }

        long long ans = LLONG_MAX;
        for(int i = 1 ; i <= k ; i++){
            ans = min(ans,dist[n-1][i]);
        }
        return (ans == LLONG_MAX) ? -1 : (int) ans;

    }
};
