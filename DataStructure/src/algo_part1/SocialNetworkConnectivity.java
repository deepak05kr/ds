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

	public void printArray() {
		System.out.println("Printing index");
		for (int i = 0; i < id.length; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("Printing id array");
		for (int i = 0; i < id.length; i++) {
			System.out.print(id[i] + " ");
		}
		System.out.println();
		System.out.println("Printing sz array");
		for (int i = 0; i < id.length; i++) {
			System.out.print(sz[i] + " ");
		}
	}

	public static void main(String args[]) {
		int size = 10;
		SocialNetworkConnectivity socialNetwork = new SocialNetworkConnectivity(size);
		socialNetwork.makeFriends(4, 5);
		socialNetwork.makeFriends(3, 4);
		socialNetwork.makeFriends(2, 3);
		socialNetwork.makeFriends(1, 2);
		socialNetwork.makeFriends(0, 1);

		socialNetwork.makeFriends(8, 9);
		socialNetwork.makeFriends(7, 8);
		socialNetwork.makeFriends(6, 7);
		
		
		socialNetwork.printArray();
	}
}
