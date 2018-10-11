//Social network connectivity. Given a social network containing n members and a log file containing m timestamps 
//at which times pairs of members formed friendships, design an algorithm to determine the earliest time at which 
//all members are connected (i.e., every member is a friend of a friend of a friend ... of a friend). 
//Assume that the log file is sorted by timestamp and that friendship is an equivalence relation. The running time 
//of your algorithm should be m log n (mlogn) or better and use extra space proportional to n.

package algo_part1;

public class SocialNetworkConnectivity {
	int[] id;
	int[] sz;

	public SocialNetworkConnectivity(int n) {
		id = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
		sz = new int[n];
		for (int i = 0; i < n; i++) {
			sz[i] = 1;
		}
	}

	public boolean isFriends(int p, int q) {
		return root(p) == root(q);
	}

	private int root(int p) {
		while (id[p] != p) {
			p = id[p];
		}
		return p;
	}

	public void makeFriends(int p, int q) {
		int i = id[p];
		int j = id[q];
		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[i] = sz[i] + sz[j];

		} else {
			id[j] = i;
			sz[j] = sz[j] + sz[i];
		}
	}

}
