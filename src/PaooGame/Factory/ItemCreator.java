package PaooGame.Factory;

import PaooGame.RefLinks;
import PaooGame.Items.Item;

/// Sablonul Metoda Fabrica
/// Clasa abstracta pentru crearea unui obiect dar care permite subclaselor sa decida ce clasa sa instantieze
/// String type => Tipul de Item ce trebuie creat
/// float x,y => Coordonatele la care se creaza un item
public abstract class ItemCreator {
    public Item GenerateItem(String type, RefLinks reflink, float x, float y, int id){
        Item item;

        item = CreateItem(type, reflink, x, y,id);

        return item;
    }

    protected abstract Item CreateItem(String type, RefLinks refLink, float x, float y, int id);
}
