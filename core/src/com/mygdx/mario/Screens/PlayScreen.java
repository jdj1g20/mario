package com.mygdx.mario.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.mario.Mario;

/**
 * Screen that the game will be displayed on and executes the logic of the game
 */
public class PlayScreen implements Screen {
    /**
     * The Game class
     */
    private Mario game;

    Texture texture;

    /**
     * What the viewport will display
     */
    private OrthographicCamera gameCam;

    /**
     * The viewport handles scaling the screen for different aspect ratios
     */
    private Viewport gameViewPort;

    /**
     * Constructor
     * @param game
     */
    public PlayScreen(Mario game) {
        this.game = game;
        texture = new Texture("badlogic.jpg");
        gameCam = new OrthographicCamera();

        gameViewPort = new FitViewport(Mario.V_WIDTH, Mario.V_HEIGHT, gameCam);

    }

    /**
     * Called when this screen becomes the current screen for a {@link Game}.
     */
    @Override
    public void show() {
    }

    /**
     * Called when the screen should render itself.
     *
     * @param delta The time in seconds since the last render.
     */
    @Override
    public void render(float delta) {
        /**
         * Clear the Screen
         */
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        /**
         * Draw the texture to the spriteBatch, then render it with .end()
         */
        game.batch.setProjectionMatrix(gameCam.combined);
        game.batch.begin();
        game.batch.draw(texture, 0, 0);
        game.batch.end();
    }

    /**
     *
     * @param width
     * @param height
     * @see ApplicationListener#resize(int, int)
     */
    @Override
    public void resize(int width, int height) {
        /**
         * Updates the viewport size when the window size changes
         */
        gameViewPort.update(width, height);
    }

    /**
     * @see ApplicationListener#pause()
     */
    @Override
    public void pause() {

    }

    /**
     * @see ApplicationListener#resume()
     */
    @Override
    public void resume() {

    }

    /**
     * Called when this screen is no longer the current screen for a {@link Game}.
     */
    @Override
    public void hide() {

    }

    /**
     * Called when this screen should release all resources.
     */
    @Override
    public void dispose() {

    }
}
