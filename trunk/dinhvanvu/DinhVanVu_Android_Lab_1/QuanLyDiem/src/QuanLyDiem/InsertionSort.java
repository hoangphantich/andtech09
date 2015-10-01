package QuanLyDiem;

import java.util.ArrayList;

/*
 ** Create By VuDv -  2015-3-16
 ** Giải thuật sắp xếp chèn
 */

public class InsertionSort extends SortArray {
	//Biến toàn cục của lớp copy mảng lưu thông tin sinh viên
	ArrayList<InfoStudent> _InfoStudents = new ArrayList<>();
	/*
	 ** Create By Vudv - 2015-3-16
	 **  input: _infoSv - Mảng lưu thông tin sinh viên
	 ** output: Mảng lưu thông tin sinh viên đã được sắp xếp  
	 ** giải thuật: duyệt mảng sinh viên từ 1-> cuối
	 */
	public InsertionSort(ArrayList<InfoStudent> _infoSv) {
		_InfoStudents.addAll(_infoSv);
		int k = 1;
		while (k < _InfoStudents.size()) {
			Insert(_InfoStudents, k, _InfoStudents.get(k));
			k = k + 1;
		}
	}

	/*
	 ** Create By Vudv - 2015-3-16
	 ** input: _infoSv - Mảng lưu thông tin sinh viên
	 **		   _sv     - Thông tin một sinh viên
	 ** output: Chèn sinh viên được chọn vào vị trí thích hợp
	 ** Giải thuật: sinh viên thứ k lần lượt so sánh điểm số với sinh viên đứng trước và sinh viên đứng sau
	 ** nếu điểm số lớn hơn sinh viên thứ i thì chèn sinh viên thứ k vào trước nó
	 */
	public void Insert(ArrayList<InfoStudent> _infoSv, int k, InfoStudent _sv) {
		int i = k - 1;
		while (i >= 0 && _infoSv.get(i).average < _sv.average) {
			_infoSv.set(i + 1, _infoSv.get(i));
			i = i - 1;
		}
		_infoSv.set(i + 1, _sv);
	}
}
