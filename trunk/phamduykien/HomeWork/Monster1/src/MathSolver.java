//PDKIEN Class dùng tính pt bậc 2, test default class with constructor
public class MathSolver {

	private float m_a;
	private float m_b;
	private float m_c;

	public MathSolver(float a, float b, float c) {
		m_a = a;
		m_b = b;
		m_c = c;
	}

	public float[] Solve() {
		float x1, x2, delta = (m_b * m_b) - 4 * m_a * m_c;
		if (delta < 0) {
			return null;
		} else if (delta == 0) {
			x1 = x2 = (-m_b / (2 * m_a));
		} else {
			x1 = (float) ((-m_b + Math.sqrt(delta)) / (2 * m_a));
			x2 = (float) ((-m_b - Math.sqrt(delta)) / (2 * m_a));
		}
		return new float[] { x1, x2 };
	}
}
