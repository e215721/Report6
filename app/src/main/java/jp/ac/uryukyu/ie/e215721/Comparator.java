package jp.ac.uryukyu.ie.e215721;

import java.util.ArrayList;

public class Comparator {
    Comparator(){

    }
    public boolean compare(ArrayList<Vector2> listA, ArrayList<Vector2> listB){
        int sum = 0;
        if (!(listA.size() == listB.size())){
            return false;
        }
        else {
            for (int i = 0; i < listA.size(); i++) {
                for (int k = 0; k < listB.size(); k++){
                    if (listA.get(i).equals((listB.get(k)))){
                        sum += 1;
                    }
                }
            }
        }
        if (sum == listA.size()){
            return true;
        }
        else{
            return false;
        }
    }


}