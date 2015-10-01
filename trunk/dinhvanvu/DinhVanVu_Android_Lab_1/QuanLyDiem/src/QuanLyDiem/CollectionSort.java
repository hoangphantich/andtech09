package QuanLyDiem;

import java.util.Comparator;
/*
 ** Create by Vudv - 2015-3-16 
 ** Sắp xếp sử dụng thử viện collection sort trong java
 */
public class CollectionSort implements Comparator<InfoStudent> {
	/*
	 ** Create by Vudv - 2015-3-16
	 ** Hàm so sánh 2 đổi tượng sv1 và sv2 nếu nhỏ hơn thì trả về giá trị +1 và ngược lại 
	 */
	public int compare(InfoStudent sv1, InfoStudent sv2) {
		int values = -1;
		if ((sv1.average < sv2.average))
			values = 1;
		return values;
	}
}
