package hu.ait.android.tictactoe.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import hu.ait.android.tictactoe.MainActivity;
import hu.ait.android.tictactoe.R;
import hu.ait.android.tictactoe.model.TicTacToeModel;

/**
 * Created by jakevitale on 9/17/15.
 */
public class TicTacToeView extends View {

    private Paint paintBg;
    private Paint paintLine;

    private Bitmap backGround;

    public TicTacToeView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paintBg = new Paint();
        paintBg.setColor(Color.BLACK);
        paintBg.setStyle(Paint.Style.FILL);

        paintLine = new Paint();
        paintLine.setColor(Color.WHITE);
        paintLine.setStyle(Paint.Style.STROKE);
        paintLine.setStrokeWidth(5);

        backGround = BitmapFactory.decodeResource(getResources(),
                R.drawable.background);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //drawing rectangle
        canvas.drawRect(0, 0, getWidth(), getHeight(), paintBg);
        canvas.drawBitmap(backGround, 0, 0, null);
        //draws lines
        drawGameArea(canvas);
        //draw circles and crosses
        drawPlayers(canvas);
    }

    private void drawPlayers(Canvas canvas) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (TicTacToeModel.getInstance().getFieldContent(i, j)
                        == TicTacToeModel.CIRCLE) {
                    drawCircle(canvas, i, j);


                } else if (TicTacToeModel.getInstance().getFieldContent(i,j) == TicTacToeModel.CROSS) {
                    drawCross(canvas, i, j);
                }
            }
        }
    }

    private void drawCross(Canvas canvas, int i, int j) {
        canvas.drawLine(i * getWidth() / 3, j * getHeight() / 3,
                (i + 1) * getWidth() / 3,
                (j + 1) * getHeight() / 3, paintLine);

        canvas.drawLine((i + 1) * getWidth() / 3, j * getHeight() / 3,
                i * getWidth() / 3, (j + 1) * getHeight() / 3, paintLine);
    }

    private void drawCircle(Canvas canvas, int i, int j) {
        // draw a circle at the center of the field

        // X coordinate: left side of the square + half width of the square
        float centerX = i * getWidth() / 3 + getWidth() / 6;
        float centerY = j * getHeight() / 3 + getHeight() / 6;
        int radius = getHeight() / 6 - 2;


        canvas.drawCircle(centerX, centerY, radius, paintLine);
    }

    private void drawGameArea(Canvas canvas) {
        // border
        canvas.drawRect(0, 0, getWidth(), getHeight(), paintLine);
        // two horizontal lines
        canvas.drawLine(0, getHeight() / 3, getWidth(), getHeight() / 3,
                paintLine);
        canvas.drawLine(0, 2 * getHeight() / 3, getWidth(),
                2 * getHeight() / 3, paintLine);

        // two vertical lines
        canvas.drawLine(getWidth() / 3, 0, getWidth() / 3, getHeight(),
                paintLine);
        canvas.drawLine(2 * getWidth() / 3, 0, 2 * getWidth() / 3, getHeight(),
                paintLine);
    }

   /* @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            int tx = ((int) event.getX()) / (getWidth()/3);
            int ty = ((int) event.getY()) / (getHeight()/3);

            handlePlayerMove(tx, ty);

            TicTacToeModel.getInstance().isWinner();
        }
        return super.onTouchEvent(event);
    }

    private void handlePlayerMove(int tx, int ty) {
        if (tx < 3 && ty < 3 &&
                TicTacToeModel.getInstance().getFieldContent(tx,ty) ==
                        TicTacToeModel.EMPTY)
        {
            TicTacToeModel.getInstance().setFieldContent(
                    tx, ty, TicTacToeModel.getInstance().getNextPlayer());

            TicTacToeModel.getInstance().changeNextPlayer();

            ((MainActivity)getContext()).showSnackBarMessage(
                    getContext().getString(R.string.txt_next_player,
                            ((TicTacToeModel.getInstance().getNextPlayer() ==
                                    TicTacToeModel.CIRCLE) ? "O" : "X")));
            invalidate();
        }
        else if (winnercheck == TicTacToeModel.CIRCLE){
            ((MainActivity)getContext()).showSnackBarWithDelete("Winner is O");
        }
        else if (winnercheck == TicTacToeModel.CROSS){
            ((MainActivity)getContext()).showSnackBarWithDelete("Winner is X");
        }
        else if (winnercheck == TicTacToeModel.EMPTY){
            ((MainActivity)getContext()).showSnackBarWithDelete("Tie Game");
        }
    }*/


    private void handleFieldTouch(int tX, int tY) {
        if (tX < 3 && tY < 3 &&
                TicTacToeModel.getInstance().getFieldContent(tX, tY) ==
                        TicTacToeModel.EMPTY) {
            TicTacToeModel.getInstance().setFieldContent(
                    tX, tY, TicTacToeModel.getInstance().getNextPlayer()
            );
            TicTacToeModel.getInstance().changeNextPlayer();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            int tX = ((int) event.getX()) / (getWidth() / 3);
            int tY = ((int) event.getY()) / (getHeight() / 3);

            handleFieldTouch(tX, tY);

            int winnerCheck = TicTacToeModel.getInstance().getWinner();
            if (winnerCheck == TicTacToeModel.NO_WINNER_YET) {

                ((MainActivity) getContext()).showSnackBarMessage(
                        getContext().getString(R.string.txt_next_player,
                                ((TicTacToeModel.getInstance().getNextPlayer()
                                        ==
                                        TicTacToeModel.CIRCLE) ? "O" : "X")));


            } else if (winnerCheck == TicTacToeModel.CIRCLE) {
                ((MainActivity)getContext()).showSnackBarWithDelete(
                        "Winner is O"
                );
            } else if (winnerCheck == TicTacToeModel.CROSS) {
                ((MainActivity)getContext()).showSnackBarWithDelete(
                        "Winner is X"
                );
            } else if (winnerCheck == TicTacToeModel.EMPTY) {
                ((MainActivity)getContext()).showSnackBarWithDelete(
                        "Tie game"
                );
            }
            invalidate();
        }

        return super.onTouchEvent(event);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);
        int d = w == 0 ? h : h == 0 ? w : w < h ? w : h;
        setMeasuredDimension(d, d);
    }

    public void clearGameArea() {
        TicTacToeModel.getInstance().resetModel();
        invalidate();
    }
}
