package jp.ac.uryukyu.ie.e215721;

import java.util.ArrayList;

public class Board {
    String[][] boardData;
    int boardLength;
    ArrayList<Vector2> emptyPoints;

    Board(int boardLength){
        this.boardLength = boardLength;
        boardData = new String[this.boardLength][this.boardLength];
        makeBoardData();
        emptyPoints = new ArrayList<Vector2>();
        makeEmptyPoints();
    }


    public void makeBoardData(){
        for (int i = 0; i < boardLength; i++){
            for (int k = 0; k < boardLength; k++){
                boardData[k][i] = "*";
            }
        }
    }

    public void makeEmptyPoints(){
        for (int i = 0; i < boardLength; i++){
            for (int k = 0; k < boardLength; k++){
                Vector2 point = new Vector2(k,i);
                emptyPoints.add(point);
            }
        }
    }

    public void display(){
        System.out.println("");
        System.out.println("+ 0 1 2 3 4 5 6 7");
        for (int i = 0; i < boardLength; i++){
            String row = " ";
            for (int k = 0; k < boardLength; k++){
                row += boardData[i][k];
                row += " ";
            }
            System.out.println(i + row);
        }

    }

    public void moved(String color, Vector2 point){
        boardData[point.y][point.x] = color;
        removeEmptyPoint(point);
    }

    public void removeEmptyPoint(Vector2 vec){
        for (int i = 0; i < emptyPoints.size(); i++){
            if (emptyPoints.get(i).x == vec.x && emptyPoints.get(i).y == vec.y){
                emptyPoints.remove(i);
            }
        }
    }

    public void boardInitialize(WhitePlayer wp, BlackPlayer bp){
        moved(wp.color, new Vector2(3,3));
        moved(wp.color, new Vector2(4,4));
        moved(bp.color, new Vector2(3,4));
        moved(bp.color, new Vector2(4,3));
    }

    public String getBoardData(Vector2 point){
        return this.boardData[point.y][point.x];
    }
}