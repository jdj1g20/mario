package com.mygdx.mario.Scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.mario.Mario;

public class Hud {
    public Stage stage;
    /**
     * The hud has its own viewport to keep it locked in place.
     */
    private Viewport viewPort;

    /**
     * Variables to keep track of different values
     * worldTimer - time limit
     * timeCount - time that has passed
     * score - the score
     */
    private Integer worldTimer;

    private float timeCount;

    private Integer score;

    /**
     * Labels to display different information
     */
    Label countdownLabel;
    Label scoreLabel;
    Label timeLabel;
    Label levelLabel;
    Label worldLabel;
    Label marioLabel;

    /**
     * Constructor
     * @param sb - takes in the existing sb, to not use up extra memory
     */
    public Hud(SpriteBatch sb){
        /**
         * Initialise values
         */
        worldTimer = 300;
        timeCount = 0;
        score = 0;

        viewPort = new FitViewport(Mario.V_WIDTH, Mario.V_HEIGHT, new OrthographicCamera());
        /**
         * Stages allow us to organise our labels
         */
        stage = new Stage(viewPort, sb);

        /**
         * We can use the table to align the labels
         */
        Table table = new Table();
        table.top();
        /**
         * Set the table to the size of the stage
         */
        table.setFillParent(true);
        /**
         * "%03d" will set the label to be made up of 3 integers
         * LabelStyle sets the font and the colour
         */
        countdownLabel = new Label(String.format("%03d", worldTimer), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        scoreLabel = new Label(String.format("%06d", score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        timeLabel = new Label("TIME", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        levelLabel = new Label("1-1", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        worldLabel = new Label("WORLD", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        marioLabel = new Label("MARIO", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        /**
         * expandX() will fill up the entire X coordinate, with multiple expandX() they will share the space
         * padTop(10) will cause it to use up the top 10 pixels of the screen
         */
        table.add(marioLabel).expandX().padTop(10);
        table.add(worldLabel).expandX().padTop(10);
        table.add(timeLabel).expandX().padTop(10);
        /**
         * Everything after table.row(); will be on a new row
         */
        table.row();

        table.add(scoreLabel).expandX();
        table.add(levelLabel).expandX();
        table.add(countdownLabel).expandX();

        /**
         * Add the table to the stage
         */
        stage.addActor(table);

    }


}
