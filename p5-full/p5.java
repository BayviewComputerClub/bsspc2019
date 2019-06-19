import java.util.*;
public class TaroMilkTea {
	static Scanner in = new Scanner(System.in);
	public static void main(String [] args) throws Exception {
		int n = in.nextInt();
		long a = in.nextLong(), b = in.nextLong(); 
		long c[] = new long[n]; 
		int e[] = new int[n];
		for(int i=0; i<n; i++) c[i] = in.nextLong();
		for(int i=0; i<n; i++) e[i] = in.nextInt();
		long dif[] = new long[n+1];
		initDif(c, dif);
		int q = in.nextInt();
		for(int i=0; i<q; i++) {
			int idx = in.nextInt(); long s = in.nextInt();
			int l = Math.max(1, idx - e[idx-1]);
			int r = Math.min(n, idx + e[idx-1]);
			update(dif, l-1, r-1, s);
		}
		long ans[] = getArray(dif); int cnt = 0;
		for(int i=0; i<n; i++) {
			//System.out.println(ans[i]);
			if(a <= ans[i] && ans[i] <= b) cnt++;
		}
		System.out.println(cnt);
	}
	static void initDif(long a[], long d[]) {
		d[0] = a[0];
		d[a.length] = 0;
		for(int i=1; i<a.length; i++)
			d[i] = a[i] - a[i-1];
	}
	static void update(long dif[], int l, int r, long x) {
		dif[l] += x;
		dif[r+1] -=x;
	}
	static long[] getArray(long dif[]) {
		long ans[] = new long[dif.length];
		ans[0] = dif[0];
		for(int i=1; i<ans.length; i++) {
			ans[i] = dif[i] + ans[i-1];
		}
		return ans;
	}
}
