package PaooGame.Factory;

import PaooGame.Items.Item;
import PaooGame.RefLinks;

/// Sablonul Metoda Fabrica
/// Clasa abstracta pentru crearea unui obiect dar care permite subclaselor sa decida ce clasa sa instantieze
/// String type => Tipul de Item ce trebuie creat
/// float x,y => Coordonatele la care se creaza un item
public abstract class ItemCreator {
    public Item GenerateItem(String type, RefLinks reflink, float x, float y){
        Item item;

        item = CreateItem(type, reflink, x, y);

        return item;
    }

    protected abstract Item CreateItem(String type, RefLinks refLink, float x, float y);
}
