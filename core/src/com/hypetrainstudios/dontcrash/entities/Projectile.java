package com.hypetrainstudios.dontcrash.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.hypetrainstudios.dontcrash.handlers.AssetHandler;

public class Projectile extends Entity{
	private float speed;
	
	public Projectile(float x, float y){
		this.image = new Sprite(AssetHandler.manager.get(AssetHandler.atlasImages).findRegion("projectile"));
		this.x = x;
		this.y = y;
		this.image.setCenter(this.x, this.y);
		this.active = true;
		this.speed = 1000f;
		this.rectangleForCollision = this.image.getBoundingRectangle();
	}
	@Override
	public void update(float delta){
		move(delta);
	}
	private void move(float delta){
		this.x += speed * delta;
		this.image.setX(this.x);
		this.rectangleForCollision = this.image.getBoundingRectangle();
	}
	public void collisionWithSpaceRock(){
		deactivate();
	}
	
}
