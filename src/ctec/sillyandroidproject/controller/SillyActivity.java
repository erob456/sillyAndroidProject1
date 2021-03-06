package ctec.sillyandroidproject.controller;

import java.util.ArrayList;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SillyActivity extends Activity
{
	private Button textButton;
	private Button appButton;
	private TextView appText;
	private RelativeLayout appLayout;
	private Random randomColor;
	private ArrayList<Integer> colorList;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_silly);
		
		//Gives you access to a button or any View object
		textButton = (Button) findViewById(R.id.textButton);
		appButton = (Button) findViewById(R.id.firstButton);
		appText = (TextView) findViewById(R.id.sillyTextView);
		appLayout = (RelativeLayout) findViewById(R.id.appLayout);
		randomColor = new Random();
		colorList = new ArrayList<Integer>();
		
		fillTheColorList();
		setupListeners();
	}
	
	private void fillTheColorList()
	{
		colorList.add(R.color.uglyRed);
		colorList.add(R.color.uglyGreen);
		colorList.add(R.color.white);
		colorList.add(R.color.otherBlack);
	}
	
	private void setupListeners()
	{
		appButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
					appLayout.setBackgroundResource(colorList.get(randomColor.nextInt(colorList.size()-1)));
					appText.setTextColor(getResources().getColor(colorList.get(randomColor.nextInt(colorList.size()-1))));
			}
		});
		
		textButton.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				appText.setTextColor(getResources().getColor(colorList.get(randomColor.nextInt(colorList.size()-1))));
			}
		});
	}
}
