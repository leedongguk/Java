public class Test {
    long sum(int[] a) {
        long ans = 0;
        
         for(int j=0; j<a.length;j++) {
			   ans += a[j];
		   }
        
        return ans;
    }
}
