package PaooGame.Factory;

import PaooGame.Items.*;
import PaooGame.RefLinks;
import PaooGame.Items.Character;

/// Subclasa a unei clase abstracte de tip fabrica
/// Permite crearea de inamici de tip specificat
/// Returneaza obiectul creat
public class EnemyCreator extends ItemCreator {
    @Override
    protected Item CreateItem(String type, RefLinks reflink, float x, float y, int id){
        switch (type){
            case "Enemy1":
                return new Enemy1(reflink,x,y, id);
            case "Enemy2":
                return new Enemy2(reflink,x,y, id);
            case "Enemy3":
                return new Enemy3(reflink,x,y, id);
            case "Boss":
                return new Boss(reflink,x,y, id);
            default:
                return null;
        }
    }
}
