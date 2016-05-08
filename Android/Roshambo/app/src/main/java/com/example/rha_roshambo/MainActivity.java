package com.example.rha_roshambo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private ImageView imgView;
	private ImageButton r_imgBtn, h_imgBtn, n_imgBtn;
	private TextView result_tv, count_tv, ties_tv, losses_tv, wins_tv;
	int count = 0, ties = 0, losses = 0, wins = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		r_imgBtn = (ImageButton) findViewById(R.id.roaches);
		h_imgBtn = (ImageButton) findViewById(R.id.humans);
		n_imgBtn = (ImageButton) findViewById(R.id.nuclear);
		imgView = (ImageView) findViewById(R.id.viewCmp);
		result_tv = (TextView) findViewById(R.id.textResult);
		count_tv = (TextView) findViewById(R.id.textCount);
		ties_tv = (TextView) findViewById(R.id.textTies);
		losses_tv = (TextView) findViewById(R.id.textLosses);
		wins_tv = (TextView) findViewById(R.id.textWins);

		
		r_imgBtn.setOnClickListener(new MyOnClickListener());
		h_imgBtn.setOnClickListener(new MyOnClickListener());
		n_imgBtn.setOnClickListener(new MyOnClickListener());
	}

	private class MyOnClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			double rand = Math.random();

			if (rand < 0.34) {
				imgView.setImageResource(R.drawable.roaches);
				if (v.getId() == R.id.roaches) {
					result("tied");
					}
				else if (v.getId() == R.id.humans) {
					result("win");
					}
				else if (v.getId() == R.id.nuclear) {
					result("loss");
					}
				else {
					// escapes errors
					}
				}
			else if (rand >= 0.34 && rand < 0.67) {
				imgView.setImageResource(R.drawable.humans);
				if (v.getId() == R.id.roaches) {
					result("loss");
					}
				else if (v.getId() == R.id.humans) {
					result("tied");
					}
				else if (v.getId() == R.id.nuclear) {
					result("win");
					}
				else {
					// escapes errors
					}
				}
			else if (rand >=0.67) {
				imgView.setImageResource(R.drawable.nuclear);
				if (v.getId() == R.id.roaches) {
					result("win");
					}
				else if (v.getId() == R.id.humans) {
					result("loss");
					}
				else if (v.getId() == R.id.nuclear) {
					result("tied");
					}
				else {
					// escapes errors
					}
			}
			else {
				// escapes errors
				}
		}
		
		public void result(String v) {
			String tied = "Result: Tied!";
			String loss = "Result: You Lose!";
			String win = "Result: You Win!";
			
			if (v.equals("win")) {
				result_tv.setText(win);
				wins++;
				}
			else if (v.equals("tied")) {
				result_tv.setText(tied);
				ties++;
				}
			else if (v.equals("loss")) {
				result_tv.setText(loss);
				losses++;
				}
			count++;
			count_tv.setText("Round: " + count);
			ties_tv.setText("Ties: " + ties);
			losses_tv.setText("Losses: " + losses);
			wins_tv.setText("Wins: " + wins);
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}