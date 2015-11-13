package com.game.antity;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.game.model.BaseModel;
import com.game.view.GameView;

public class ZombieMannger extends BaseModel {
	private boolean isAlive;
	private long makeTime;
	private int makeSpeed;	//生产速度
	
	public ZombieMannger(){
		isAlive = true;
		makeSpeed = 1000;	//第一次僵尸出现为15秒
		makeTime = System.currentTimeMillis();
		
	}

	@Override
	public void draw(Canvas canvas, Paint paint) {
		// TODO 自动生成的方法存根
		if(System.currentTimeMillis() - makeTime > makeSpeed){	//僵尸生产速度为1到10秒
			makeSpeed = (int) (Math.random() * 5000) + 1000;
			makeTime = System.currentTimeMillis();
			
			makeZombie();
		}
	}
	private void makeZombie(){
		GameView.getInstance().makeZombie();
	}
}
