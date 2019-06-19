import java.util.*;
import java.io.*;
public class BayviewMusicDepartment {
	private static Reader in;
	private static PrintWriter out;
	
	private static int NUM_OF_TEST_CASES = 1; // TODO CHANGE NUMBER OF TEST CASES
	
	// TODO CHANGE FILE NAMES
	private static final String INPUT_FILE_NAME = "";
	private static final String OUTPUT_FILE_NAME = "";
	
    private static boolean crash = true;
    private static boolean flush = false;
    
	
	public static void main(String[]args) throws Exception {
		if (INPUT_FILE_NAME.equals("")) in = new Reader(System.in);
        else in = new Reader(INPUT_FILE_NAME);
        if (OUTPUT_FILE_NAME.equals("")) out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        else out = new PrintWriter(new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME)));
        for (int i = 1; i <= NUM_OF_TEST_CASES; i++) {
            try {
                run(i);
            } catch (Exception e) {
                System.err.println("Exception thrown on test case " + i);
                e.printStackTrace(System.err);
                out.flush();
                if (crash) throw new Exception();
            }
            if (flush) out.flush();
        }
        in.close();
        out.close();
		
	}
    static ArrayList<ArrayList<Edge>> adj = new ArrayList<ArrayList<Edge>>();
    static ArrayList<ArrayList<Edge>> adj2 = new ArrayList<ArrayList<Edge>>();
	public static void run(int testCaseNum) throws Exception {
		int n = in.readInt(), m = in.readInt(), k = in.readInt(), q = in.readInt();
  		for(int i = 0; i <= n; i++) {adj.add(new ArrayList<Edge>()); adj2.add(new ArrayList<Edge>());} 
  		long dis[][] = new long[k][n + 1], dis2[][] = new long[k][n + 1];
  		for(int i = 0; i < m; i++) {
  			int u = in.readInt(), v = in.readInt(), w = in.readInt();
  			adj.get(u).add(new Edge(v, w)); adj2.get(v).add(new Edge(u, w));
  		}
  		for(int i = 0; i < k; i++) {
  			int x = in.readInt(); 
  			dijstras(i, x, dis2, adj); 
  			dijstras(i, x, dis, adj2);
  		}
  		int cnt = 0; long ans = 0;
  		for(int i = 0; i < q; i++) {
  			int u = in.readInt(), v = in.readInt();
  			long max = Integer.MAX_VALUE;
  			for(int j = 0; j < k; j++) {
  				max = Math.min(max, dis[j][u] + dis2[j][v]);
  			}
  			if(max != Integer.MAX_VALUE) {cnt++; ans += max;}
  		}
  		out.println(cnt); out.print(ans); 
	}
	static void dijstras(int hub, int src, long dis[][], ArrayList<ArrayList<Edge>> adj) {
		Arrays.fill(dis[hub], Integer.MAX_VALUE);
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		dis[hub][src] = 0; pq.add(new Edge(src, 0));
		while(!pq.isEmpty()) {
			Edge u = pq.poll();
			if(u.w > dis[hub][u.v]) continue;
			for(Edge e : adj.get(u.v)) {
				if(dis[hub][e.v] > dis[hub][u.v]+ e.w) { 
					dis[hub][e.v] = dis[hub][u.v] + e.w; 
					pq.add(new Edge(e.v, dis[hub][e.v]));
				}
			}
		}
	}
	static class Edge implements Comparable<Edge>{
		int v; long w;
		public Edge(int v, long w) {
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return Long.compare(w, o.w);
		}
	}
	static void print(Object o) {
		out.print(o);
	}

	static void println(Object o) {
		out.println(o);
	}

	static void flush() {
		out.flush();
	}

	static void println() {
		out.println();
	}

	static void exit() throws IOException {
		in.close();
		out.close();
		System.exit(0);
	}
	static class Reader {
		
		final private static int BUFFER_SIZE = 1 << 16;
		private static DataInputStream din = new DataInputStream(System.in);
		private static byte[] buffer = new byte[BUFFER_SIZE];
		private static int bufferPointer = 0, bytesRead = 0;
		public Reader(InputStream stream) {
            din = new DataInputStream(stream);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
		}
		
        public Reader(String fileName) throws IOException {
            din = new DataInputStream(new FileInputStream(fileName));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
		
		public  String readLine() throws IOException {
			byte[] buf = new byte[64]; // line length
			int cnt = 0, c;
			while ((c = Read()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}
		public  String read() throws IOException{
			byte[] ret = new byte[1024];
	        int idx = 0;
	        byte c = Read();
	        while (c <= ' ') {
	            c = Read();
	        }
	        do {
	            ret[idx++] = c;
	            c = Read();
	        } while (c != -1 && c != ' ' && c != '\n' && c != '\r');
	        return new String(ret, 0, idx);
		}
		public int readInt() throws IOException {
			int ret = 0;
			byte c = Read();
			while (c <= ' ')
				c = Read();
			boolean neg = (c == '-');
			if (neg)
				c = Read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = Read()) >= '0' && c <= '9');
	
			if (neg)
				return -ret;
			return ret;
		}
	
		public  long readLong() throws IOException {
			long ret = 0;
			byte c = Read();
			while (c <= ' ')
				c = Read();
			boolean neg = (c == '-');
			if (neg)
				c = Read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = Read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}
	
		public  double readDouble() throws IOException {
			double ret = 0, div = 1;
			byte c = Read();
			while (c <= ' ')
				c = Read();
			boolean neg = (c == '-');
			if (neg)
				c = Read();
	
			do {
				ret = ret * 10 + c - '0';
			} while ((c = Read()) >= '0' && c <= '9');
	
			if (c == '.') {
				while ((c = Read()) >= '0' && c <= '9') {
					ret += (c - '0') / (div *= 10);
				}
			}
	
			if (neg)
				return -ret;
			return ret;
		}
	
		private  void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}
	
		private  byte Read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}
	
		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}
}
