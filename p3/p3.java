import java.util.*;
public class ShakespeareInsults {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); word adj1[] = new word[n];
		for(int i=0; i<n; i++)
			adj1[i] = new word(sc.next(), sc.nextInt());
		int m = sc.nextInt(); word adj2[] = new word[m];
		for(int i=0; i<m; i++)
			adj2[i] = new word(sc.next(), sc.nextInt());
		int k = sc.nextInt(); word noun[] = new word[k];
		for(int i=0; i<k; i++)
			noun[i] = new word(sc.next(), sc.nextInt());
		
		Arrays.sort(adj1); Arrays.sort(adj2); Arrays.sort(noun);
		String first = adj1[0].str + " " + adj2[0].str + " " + noun[0].str;
		
		String second = "";
		int v1 = adj1[0].value + adj2[0].value + noun[1].value; 
		String s1 = adj1[0].str + " " + adj2[0].str + " " + noun[1].str;
		int v2 = adj1[0].value + adj2[1].value + noun[0].value; 
		String s2 = adj1[0].str + " " + adj2[1].str + " " +noun[0].str;
		int v3 = adj1[1].value + adj2[0].value + noun[0].value; 
		String s3 = adj1[1].str + " " + adj2[0].str + " " +noun[0].str;
		
		boolean u1 = false, u2 = false, u3 = false;
		word tmp[] = new word[3];
		tmp[0] = new word(s1,v1); tmp[1] = new word(s2,v2); tmp[2] = new word(s3, v3);
		
		Arrays.sort(tmp); word max = tmp[0]; 
		if(max.value == v1 && max.str.equals(s1)) {
			second = s1;
			u1 = true;
		}
		else if(max.value == v2 && max.str.equals(s2))  {
			second = s2;
			u2 = true;
		}
		else if(max.value == v3 && max.str.equals(s3))  {
			second = s3;
			u3 = true;
		}
		
		String third = "";
		
		if(u1) {
			word max2[] = new word[2];
			max2[0] = new word(s2, v2);
			max2[1] = new word(s3, v3);
			Arrays.sort(max2);
			third = max2[0].str;
		}
		else if(u2) {
			word max2[] = new word[2];
			max2[0] = new word(s1, v1);
			max2[1] = new word(s3, v3);
			Arrays.sort(max2);
			third = max2[0].str;
		}
		else if(u3) {
			word max2[] = new word[2];
			max2[0] = new word(s1, v1);
			max2[1] = new word(s2, v2);
			Arrays.sort(max2);
			third = max2[0].str;
		}
		System.out.println("1. " + first);
		System.out.println("2. " + second);
		System.out.println("3. " + third);
		sc.close();
	}
	static class word implements Comparable<word>{
		String str; int value;
		public word(String str, int value) {
			this.str = str;
			this.value = value;
		}
		@Override
		public int compareTo(word o) {
			if(o.value == value)
				return o.str.compareTo(str);
			return o.value - value;
		}
	}
}
