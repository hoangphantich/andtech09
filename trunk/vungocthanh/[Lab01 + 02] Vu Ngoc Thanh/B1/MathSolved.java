
	public class MathSolved {
		private double a;
		private double b;
		private double c;
		
		public double getA() {
			return a;
		}
		public double getB() {
			return b;
		}
		public double getC() {
			return c;
		}
		public void setA(double a) {
			this.a = a;
		}
		public void setB(double b) {
			this.b = b;
		}
		public void setC(double c) {
			this.c = c;
		}
		// khai bao 
		public MathSolved( double a,double b, double c ) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
		// ham tinh ptb2 
		public void tinh () {
			double x1 = 0;
			double x2 = 0;
			if( a == 0 ) {
				if ( b == 0 ) {
					if ( c == 0 ) {
						System.out.println( "Phuong trinh vo so nghiem! " );
					}
					else 
						System.out.println( "Phuong trinh vo nghiem! " );
				}
				else {
					x1 = (double) -c/b;  // ep kieu 
					System.out.println( "Phuong trinh co nghiem la: x = " + x1 );
				}
			}
			else {
				double denta = 0;
				denta =  b*b - 4*a*c;
				if ( denta < 0 ) {
					System.out.println( "Phuong trinh vo nghiem! " );
				}
				else if ( denta >0 ) {
					x1 = (double) (-b + Math.sqrt(denta))/(2*a);
					x2 = (double) (-b - Math.sqrt(denta))/(2*a);
					System.out.println ( "Phuong trinh co 2 nghiem phan biet: x1 = " + x1 + " , x2 = " + x2 );
				}
				else 
					System.out.println( "Phuong trinh co nghiem kep: x1 = x2 = " + -b/(2*a) );
			}
		}
		
	}
