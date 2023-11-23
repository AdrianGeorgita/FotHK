package PaooGame.Factory;

import PaooGame.Items.*;
import PaooGame.RefLinks;

/// Subclasa a unei clase abstracte de tip fabrica
/// Permite crearea de inamici de tip specificat
/// Returneaza obiectul creat
public class ChestCreator extends ItemCreator {
    @Override
    protected Item CreateItem(String type, RefLinks reflink, float x, float y, int id){
        switch (type){
            case "Chest1":
                return new Chest(reflink,x,y, id,true,200,5,2);
            case "Chest2":
                return new Chest(reflink,x,y, id,true,300,10,3);
            case "Chest3":
                return new Chest(reflink,x,y, id,true,500,25,4);
            case "Key":
                return new Key(reflink,x,y,id);
            default:
                return null;
        }
    }
}
