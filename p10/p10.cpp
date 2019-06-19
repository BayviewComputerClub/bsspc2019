#include <bits/stdc++.h>

#define MAXN 10010

using namespace std;

int N, value[MAXN], dp[MAXN][2];
vector<int> adjList[MAXN];

int dfs(int node, int prev, int pick) {
	if (dp[node][pick] != -1) return dp[node][pick];
	int ret = 0;
	for (int u : adjList[node]) {
		if (u == prev) continue;
		int tmp = dfs(u, node, 0);
		if (pick == 0) tmp = max(tmp, value[u] + dfs(u, node, 1));
		ret += tmp;
	}
	return dp[node][pick] = ret;
}

int main() {
	cin >> N;
	for (int i = 0; i < N; i++) cin >> value[i];
	for (int i = 0, a, b; i < N - 1; i++) {
		cin >> a >> b;
		a--, b--;
		adjList[b].push_back(a);
		adjList[a].push_back(b);
	}

	memset(dp, -1, sizeof dp);
	cout << max(dfs(0, -1, 0), value[0] + dfs(0, -1, 1)) << endl;
}
