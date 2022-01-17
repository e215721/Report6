package jp.ac.uryukyu.ie.e215721;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Board b = new Board(8);
        WhitePlayer wp = new WhitePlayer();
        BlackPlayer bp = new BlackPlayer();
        b.boardInitialize(wp, bp);
        b.display();
        int endFlag = 0;
        boolean whiteTurn = true;


        Scanner sc = new Scanner(System.in);
        Player p;

        while (true){
            if (whiteTurn){
                p = wp;
            }
            else{
                p = bp;
            }
            System.out.println(p.name + "のターンです");
            ArrayList<Vector2> movablePoints = p.getMovablePoints(b);

            if (movablePoints.isEmpty()){
                whiteTurn = !whiteTurn;
                endFlag += 1;
                if (endFlag == 2){
                    break;
                }
                continue;
            }

            int x = sc.nextInt();
            int y = sc.nextInt();
            Vector2 point = new Vector2(x,y);

            if (!p.isMovable(movablePoints, point)){
                System.out.println("そこには置けません\n");
                continue;
            }


            p.move(b, point);

            p.change(b,point);

            b.display();

            endFlag = 0;

            whiteTurn = !whiteTurn;
        }

        System.out.println("ゲーム終了");



    }

}