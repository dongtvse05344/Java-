import java.io.*;
import java.util.*;
import java.lang.*;

class FastReader {

    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() throws IOException {
        while (st == null || !st.hasMoreElements()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    public String nextLine() throws IOException {
        String str = "";
        str = br.readLine();
        return str;
    }
}

class Value implements Comparable<Value>
{
    public int v,p; 
    public Value(int v,int p)
    {
        this.v =v ;
        this.p =p ;
    }

    @Override
    public int compareTo(Value t) {
        if (this.v == t.v) return 0;
        if (this.v > t.v) return 1;
        return -1;
    }
    

}

/*
 * Using Binary Indexed Tree
*/
class BIT {
    int[] a,b;

    
    int[] T = new int[30010];
    Value[] v = new Value[30010];
    int n;
    
    public BIT()
    {
        a= new int[30010];
        b= new int[30010];
    }
    
    public int Get(int x)
    {
        int ans = 0;
        if(x==0) return 0;
        while(x>0)
        {
            ans = (Math.max(ans, T[x]));
            x = x&(x-1);
        }
        return ans;
    }
    
    public void Update(int x, int v)
    {
        while(x<=n)
        {
            T[x] =Math.max(T[x],v);
            x += x&-x;
        }
    }
    
    public void Input() throws IOException
    {
//        Scanner sc = new Scanner(System.in);
//        n = Integer.parseInt(sc.nextLine());
//        for (int i = 0; i < n; i++) {
//            a[i] = Integer.parseInt(sc.next());
//            v[i] = new Value(a[i], i);
//        }
        FastReader sc = new FastReader();
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(sc.next());
            v[i] = new Value(a[i], i);
        }
                

        Arrays.sort(v,0,n);
        
        int dem =1;
        b[v[0].p] = dem;
        for (int i = 1; i < n;i++) {
            if(v[i].v > v[i-1].v) dem++;
            b[v[i].p] = dem;
        }
        
        for (int i = 0; i < n; i++) {
            a[i] = b[i];
        }
    }
    
    public void doing() throws IOException
    {
        int ans = 0;
        Input();
        
        
        for (int i = 0; i < n; i++) {
            int t = Get(a[i]-1)+1;
            Update(a[i], t);
            ans = Math.max(ans, t);
        }
        
        System.out.println(ans);
       

    }
    
    public static void main (String[] args) throws java.lang.Exception
	{
            BIT b = new BIT();
            b.doing();
	}
    
}
