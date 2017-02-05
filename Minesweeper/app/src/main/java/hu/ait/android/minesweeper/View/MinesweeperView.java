package hu.ait.android.minesweeper.View;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.graphics.Color;
import android.graphics.Paint;

import hu.ait.android.minesweeper.MinesweeperGame;
import hu.ait.android.minesweeper.Model.MinesweeperModel;
import hu.ait.android.minesweeper.R;

/**
 * Created by jakevitale on 9/30/15.
 */



public class MinesweeperView extends View {

    private Paint paintBg;
    private Paint paintLine;

    public MinesweeperView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paintBg = new Paint();
        paintBg.setColor(Color.BLUE);
        paintBg.setStyle(Paint.Style.FILL);

        paintLine = new Paint();
        paintLine.setColor(Color.BLACK);
        paintLine.setStyle(Paint.Style.STROKE);
        paintLine.setStrokeWidth(5);

    }


}

