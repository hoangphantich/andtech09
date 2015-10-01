package QuanLyDiem;

import java.util.ArrayList;
/*
 ** Create By VuDv -  2015-3-16
 ** Giải thuật sắp xếp nổi bọt
 */
public class BubbleSort extends SortArray {
	ArrayList<InfoStudent> _InfoStudents = new ArrayList<>();
	public BubbleSort() {
		// TODO Auto-generated constructor stub
	}
/*
 ** input: Mảng lưu thông danh sách sinh viên
 ** ouput: Mảng lưu thông tin sinh viên đã được sắp xếp
 ** Giải thuật: so sánh lần lượt một phần tử với các phần tử còn lại
 ** nếu nhỏ hơn thì đổi chỗ 2 phần tử cho nhau 
 */
	public BubbleSort(ArrayList<InfoStudent> _infoSv) {
		_InfoStudents.addAll(_infoSv);
		for (int i = 0; i < _InfoStudents.size(); i++) {
			for (int j = (_InfoStudents.size() - 1); j > i; j--) {
				if (_InfoStudents.get(i).average < _InfoStudents.get(j).average) {
					InfoStudent temp = _InfoStudents.get(j);
					_InfoStudents.set(j, _InfoStudents.get(i));
					_InfoStudents.set(i, temp);
				}
			}
		}
	}

	
}
