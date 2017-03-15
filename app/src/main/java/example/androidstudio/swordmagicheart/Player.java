package example.androidstudio.swordmagicheart;

/**
 * Created by thomasmilgrew on 3/15/17.
 */

public class Player {

    int score;
    int imageId;

    public Player(){

    }

    public  int getScore(){
        return score;
    }

    public int getImageId(){
        return imageId;
    }

    public void setImageId(int id){
        imageId =  id;
    }

}
