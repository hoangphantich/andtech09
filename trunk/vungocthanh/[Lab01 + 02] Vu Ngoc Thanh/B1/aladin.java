public class aladin {
		private int x;
		private int y;
		
		public void setX(int x) {
			this.x = x;
		}
		public void setY(int y) {
			this.y = y;
		}
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}		
		public aladin( int x, int y ) {
			this.x = x;
			this.y = y;
		}
		public void print() {
			int i = 0,j = 0;
			for(i=0;i < x;i++) {
				System.out.print( "\n" );
				for (j=0;j < y;j++) {
					System.out.print( "*" );
				}
			}
		}
}