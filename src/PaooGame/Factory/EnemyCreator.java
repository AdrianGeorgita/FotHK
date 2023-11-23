package PaooGame.Factory;

import PaooGame.Items.*;
import PaooGame.RefLinks;

/// Subclasa a unei clase abstracte de tip fabrica
/// Permite crearea de inamici de tip specificat
/// Returneaza obiectul creat
public class EnemyCreator extends ItemCreator {
    @Override
    protected Item CreateItem(String type, RefLinks reflink, float x, float y){
        switch (type){
            case "Enemy1":
                return new Enemy1(reflink,x,y);
            case "Enemy2":
                return new Enemy2(reflink,x,y);
            default:
                return null;
        }
    }
}
