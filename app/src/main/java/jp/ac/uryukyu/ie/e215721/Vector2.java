package jp.ac.uryukyu.ie.e215721;


public class Vector2 {
    int x,y;
    Vector2(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Vector2 getAdd(Vector2 vec){
        Vector2 result = new Vector2(this.x, this.y);
        result.x += vec.x;
        result.y += vec.y;
        return result;
    }


    public boolean equals(Vector2 vec){
        if (this.x == vec.x && this.y == vec.y){
            return true;
        }
        else{
            return false;
        }
    }

    public Vector2 add(Vector2 vec){
        return new Vector2(this.x + vec.x, this.y + vec.y);

    }

    public Vector2 copy(){
        return new Vector2(this.x, this.y);
    }
}