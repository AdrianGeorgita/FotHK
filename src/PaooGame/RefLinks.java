package PaooGame;

import PaooGame.Items.Hero;
import PaooGame.Items.Item;
import PaooGame.Maps.Map;

import PaooGame.Input.KeyManager;

import java.util.ArrayList;

/*! \class public class RefLinks
    \brief Clasa ce retine o serie de referinte ale unor elemente pentru a fi usor accesibile.

    Altfel ar trebui ca functiile respective sa aiba o serie intreaga de parametri si ar ingreuna programarea.
 */
public class RefLinks
{
    private Game game;          /*!< Referinta catre obiectul Game.*/
    private Map map;            /*!< Referinta catre harta curenta.*/

    private Hero hero;          /*!< Referinta catre obiectul Erou.*/

    private ArrayList<Item> items;          /*!< Referinta catre o lista de obiecte de tip Item*/

    /*! \fn public RefLinks(Game game)
        \brief Constructorul de initializare al clasei.

        \param game Referinta catre obiectul game.
     */
    public RefLinks(Game game)
    {
        this.game = game;
    }

    /*! \fn public KeyManager GetKeyManager()
        \brief Returneaza referinta catre managerul evenimentelor de tastatura.
     */
    public KeyManager GetKeyManager()
    {
        return game.GetKeyManager();
    }

    /*! \fn public int GetWidth()
        \brief Returneaza latimea ferestrei jocului.
     */
    public int GetWidth()
    {
        return game.GetWidth();
    }

    /*! \fn public int GetHeight()
        \brief Returneaza inaltimea ferestrei jocului.
     */
    public int GetHeight()
    {
        return game.GetHeight();
    }

    /*! \fn public Game GetGame()
        \brief Intoarce referinta catre obiectul Game.
     */
    public Game GetGame()
    {
        return game;
    }

    /*! \fn public void SetGame(Game game)
        \brief Seteaza referinta catre un obiect Game.

        \param game Referinta obiectului Game.
     */
    public void SetGame(Game game)
    {
        this.game = game;
    }

    /*! \fn public Map GetMap()
        \brief Intoarce referinta catre harta curenta.
     */
    public Map GetMap()
    {
        return map;
    }

    /*! \fn public void SetMap(Map map)
        \brief Seteaza referinta catre harta curenta.

        \param map Referinta catre harta curenta.
     */
    public void SetMap(Map map)
    {
        this.map = map;
    }
    /*! \fn public Hero GetHero()
        \brief Intoarce referinta catre obiectul erou.
     */

    public Hero GetHero() {return hero;}

    /*! \fn public void SetHero(Hero hero)
        \brief Seteaza referinta catre eroul curent.

        \param map Referinta catre eroul curent.
     */
    public void SetHero(Hero hero)
    {
        this.hero = hero;
    }

     /*! \fn public ArrayList<Item> GetItems()
        \brief Intoarce referinta catre o lista de obiecte de tip Item.
     */

    public ArrayList<Item> GetItems() {return items;}

    /*! \fn public void SetItems(ArrayList<Item> items)
       \brief Seteaza referinta catre o lista de obiecte de tip Item.

       \param map Referinta catre o lista de obiecte de tip Item.
    */
    public void SetItems(ArrayList<Item> items) {this.items = items;}

    /*! \fn public void RemoveItem(Item item)
       \brief Elimina un obiect din lista de obiecte de tip Item.

       \param map Referinta catre o un obiect de tip Item.
    */
    public void RemoveItem(Item item){ this.items.remove(item);}
}
