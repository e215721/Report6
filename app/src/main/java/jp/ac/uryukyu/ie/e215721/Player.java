package jp.ac.uryukyu.ie.e215721;

import java.util.ArrayList;

public class Player {
    String color;
    String opponent_color;
    boolean isTurn;
    String name;
    String opponent_name;

    /**
     * コンストラクタ
     * @param color
     * @param opponent
     * @param name
     * @param opponent_name
     */
    Player(String color, String opponent, String name, String opponent_name){
        this.color = color;
        this.opponent_color = opponent;
        this.isTurn = true;
        this.name = name;
        this.opponent_name = opponent_name;
    }

    public void move(Board board, Vector2 point){
        board.moved(this.color, point);
    }

    public ArrayList<Vector2> getMovablePoints(Board b){
        ArrayList<Vector2> movablePoints = new ArrayList<Vector2>();
        for (Vector2 emptyPoint : b.emptyPoints){
            if (!scan(emptyPoint, b).isEmpty()){
                movablePoints.add(emptyPoint);
            }
        }
        return movablePoints;
    }

    public void change(Board b, Vector2 point){
        ArrayList<Vector2> changeablePoints = scan(point, b);
        for (Vector2 changeablePoint : changeablePoints){
            move(b, changeablePoint);
        }
    }

    public ArrayList<Vector2> scan(Vector2 point, Board b){

        ArrayList<Vector2> changeablePoints = new ArrayList<Vector2>();
        //全ての方角
        Vector2[] all_direction = {new Vector2(1,0), new Vector2(-1, 0), new Vector2(0,1), new Vector2(0,-1), new Vector2(1 ,1), new Vector2(1,-1), new Vector2(-1,-1), new Vector2(-1,1)};

        for (Vector2 direction : all_direction){
            for ( Vector2 changeablePoint : scanRay(point, b, direction)){
                changeablePoints.add(changeablePoint);
            }
        }

        return changeablePoints;
    }

    public ArrayList<Vector2> scanRay(Vector2 point, Board b, Vector2 adjust){
        ArrayList<Vector2> changeablePoints = new ArrayList<Vector2>();
        Vector2 scanFrame = point.add(adjust);

        while (0 <= scanFrame.x && scanFrame.x <= 7 && 0 <= scanFrame.y && scanFrame.y <= 7){
            if (b.getBoardData(scanFrame).equals("*")){
                break;
            }

            if (b.getBoardData(scanFrame).equals(opponent_color)){
                changeablePoints.add(scanFrame.copy());
            }

            if (b.getBoardData(scanFrame).equals(color)){
                return changeablePoints;
            }

            scanFrame = scanFrame.add(adjust);
        }

        changeablePoints.clear();

        return changeablePoints;
    }

    public boolean isMovable(ArrayList<Vector2> movablePoints, Vector2 point){
        for (Vector2 movablePoint : movablePoints){
            if (movablePoint.equals(point)){
                return true;
            }
        }
        return false;
    }



}