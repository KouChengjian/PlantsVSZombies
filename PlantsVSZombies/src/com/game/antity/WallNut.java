package com.game.antity;

import com.game.global.Config;
import com.game.model.Plants;

import android.graphics.Canvas;
import android.graphics.Paint;

public class WallNut extends Plants {
	private int n;
	public WallNut(int left, int top, int x, int y, int v) {
		super(left, top, x, y, v);
		// TODO �Զ����ɵĹ��캯�����
		Config._sun -= Config.sunWallNut;
		n = x;
		
	}

	@Override
	public void draw(Canvas canvas, Paint paint) {
		// TODO �Զ����ɵķ������
		//if(isAlive()){
			if(this.value < 500){
				canvas.drawBitmap(Config.wallnut[2], locationX, locationY, paint);
			}else if(this.value < 1000){
				canvas.drawBitmap(Config.wallnut[1], locationX, locationY, paint);
			}else{
				canvas.drawBitmap(Config.wallnut[0], locationX, locationY, paint);
			}
		//}
		
		
		super.draw(canvas, paint);
	}
	@Override
	public int getModelWidth() {
		// TODO �Զ����ɵķ������
		return Config.sunflower[0].getWidth();
	}
}
