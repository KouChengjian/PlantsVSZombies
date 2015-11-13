package com.game.antity;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.game.model.BaseModel;
import com.game.view.GameView;

public class ZombieMannger extends BaseModel {
	private boolean isAlive;
	private long makeTime;
	private int makeSpeed;	//�����ٶ�
	
	public ZombieMannger(){
		isAlive = true;
		makeSpeed = 1000;	//��һ�ν�ʬ����Ϊ15��
		makeTime = System.currentTimeMillis();
		
	}

	@Override
	public void draw(Canvas canvas, Paint paint) {
		// TODO �Զ����ɵķ������
		if(System.currentTimeMillis() - makeTime > makeSpeed){	//��ʬ�����ٶ�Ϊ1��10��
			makeSpeed = (int) (Math.random() * 5000) + 1000;
			makeTime = System.currentTimeMillis();
			
			makeZombie();
		}
	}
	private void makeZombie(){
		GameView.getInstance().makeZombie();
	}
}
