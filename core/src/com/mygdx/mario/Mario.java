package com.mygdx.mario;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.mario.Screens.PlayScreen;

/**
 * Main game loop, will delegate action to a screen
 */
public class Mario extends Game {
	/**
	 * SpriteBatch -
	 * Memory intensive so we only want one to be shared across all screens
	 */
	public SpriteBatch batch;

	/**
	 * Virtual width and height for our game
	 */
	public static final int V_WIDTH = 400;
	public static final int V_HEIGHT = 208;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		/**
		 * Delegate a screen for the game to display
		 */
		setScreen(new PlayScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}

}
