
public class SkyScraper {
	private int k;
	
	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}
	
	public SkyScraper(int k) {
		this.k = k;
	}
	public void build() {
		int i,j;
		for(i=1;i<=k;i++) {
			for(j=0;j<k-i;j++) {
				System.out.print(" ");
				}
			for(j=0;j<i;j++) {
				System.out.print("* ");	
			}
				System.out.print("\n");
			
		}
	}
}
