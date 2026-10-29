   void LCA(int N, vector<vector<int>>& edges, int root) {
        n = N;
        LOG = 20;

        adj.assign(n, {});

        for (auto &e : edges) {
            int u = e[0], v = e[1];
            adj[u].push_back(v);
            adj[v].push_back(u);
        }

        up.assign(n, vector<int>(LOG, -1));
        depth.assign(n, 0);

        dfs(root, -1);
    }

    void dfs(int u, int par) {
        up[u][0] = par;

        for (int j = 1; j < LOG; j++) {
            if (up[u][j - 1] != -1)
                up[u][j] = up[up[u][j - 1]][j - 1];
        }

        for (int v : adj[u]) {
            if (v == par) continue;

            depth[v] = depth[u] + 1;
            dfs(v, u);
        }
    }

    int getLCA(int u, int v) {
        if (depth[u] < depth[v])
            swap(u, v);

        int diff = depth[u] - depth[v];

        for (int j = LOG - 1; j >= 0; j--) {
            if ((diff >> j) & 1)
                u = up[u][j];
        }

        if (u == v)
            return u;

        for (int j = LOG - 1; j >= 0; j--) {
            if (up[u][j] != up[v][j]) {
                u = up[u][j];
                v = up[v][j];
            }
        }

        return up[u][0];
    }
