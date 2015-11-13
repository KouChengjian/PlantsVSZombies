package com.game.antity;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.game.global.Config;
import com.game.model.Zombies;
import com.game.view.GameView;

public class Zombie extends Zombies {
	
	private int value;	//����ֵ
	
	public Zombie(int x,int y, int n, int speed){
		super(x, y, n, speed);
		this.value = 100;
		
	}
	
	
	
	
	@Override
	public void draw(Canvas canvas, Paint paint) {
		// TODO �Զ����ɵķ������
		if(isAlive){
			int color = paint.getColor();
			
			paint.setColor(Color.BLUE);
			canvas.drawBitmap(Config.zombie[farmeIndex/5],locationX,locationY-Config.deviceHeight/25,paint);
			if(++farmeIndex > 149){
				farmeIndex = 0;
			}
			if(stop){
				
			}else{
				locationX  -= Config.deviceWidth / 1000 * speed;
				if(locationX < 0){
					isAlive = false;
				}
			}
			paint.setColor(color);
			
			//��ײ���
			GameView.getInstance().checkConllision(this,this.n);	
			
			
			
			
			
		}
	}




	@Override
	public int getModelWidth() {
		// TODO �Զ����ɵķ������
		return Config.zombie[farmeIndex/10].getWidth();
	}



	
}
