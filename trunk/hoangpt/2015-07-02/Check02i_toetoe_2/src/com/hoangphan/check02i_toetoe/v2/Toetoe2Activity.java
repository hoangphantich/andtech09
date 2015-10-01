package com.hoangphan.check02i_toetoe.v2;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridLayout;

public class Toetoe2Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_toetoe2);
		
		//find UI
		GridLayout gl = (GridLayout) findViewById(R.id.grid);
		
		//get width of device ->/3 = button
		WindowManager manager = getWindowManager();
		Display d = manager.getDefaultDisplay();
		int w = d.getWidth();
		int wb = w/3 - 20;
		
		//add button to grid
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				Button b = new Button(this);
				b.setWidth(wb);
				b.setHeight(wb);
				
				gl.addView(b);
				PlayListener p = new PlayListener(i,j);
				b.setOnClickListener(p);
			}
		}
	}
	
	int turn = 0;
	String[][] mapper = new String[3][3];
	
	class PlayListener implements OnClickListener {

		int i,j;
		public PlayListener(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public void onClick(View v) {
			Button b = (Button) v;
			b.setTextSize(50);
			String c = "X";
			
			if(turn%2==0){
				b.setText("X");
				//mapper to toa do cua button
				mapper[i][j] = "X";
			} else {
				b.setText("O");
				b.setTextColor(Color.RED);
				mapper[i][j] = "O";
			}
			
			b.setEnabled(false);
			
			//check win
			boolean f = checkWin(c);
			turn++;
		}

		private boolean checkWin(String c) {
			//check row
			for (int i = 0; i < 3; i++) {
				if(mapper[i][3-i].equals(c) && mapper[i][2-i].equals(c) && mapper[i][1-i].equals(c)){
					String mes = c+"Win";
					Log.d("who", mes);
					return true;
				}
			}
			
			return false;
		}
	}
}
