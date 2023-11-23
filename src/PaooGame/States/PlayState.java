package PaooGame.States;

import PaooGame.Factory.EnemyCreator;
import PaooGame.Factory.ItemCreator;
import PaooGame.Items.Hero;
import PaooGame.Items.Item;
import PaooGame.RefLinks;
import PaooGame.Maps.Map;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.util.ArrayList;

/*! \class public class PlayState extends State
    \brief Implementeaza/controleaza jocul.
 */
public class PlayState extends State
{
    private Hero hero;  /*!< Referinta catre obiectul animat erou (controlat de utilizator).*/
    private Map map;    /*!< Referinta catre harta curenta.*/

    private ArrayList<Item> items = new ArrayList<Item>();

    /*! \fn public PlayState(RefLinks refLink)
        \brief Constructorul de initializare al clasei

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public PlayState(RefLinks refLink)
    {
            ///Apel al constructorului clasei de baza
        super(refLink);
            ///Construieste harta jocului
        map = new Map(refLink);
            ///Referinta catre harta construita este setata si in obiectul shortcut pentru a fi accesibila si in alte clase ale programului.
        refLink.SetMap(map);

        /// Folosim o fabrica de inamici
        ItemCreator creator = null;
        creator = new EnemyCreator();

        // Folosind fabrica, generam un inamic de tip specificat pe care il adaugam intr-o lista de iteme
        Item item = null;
        item = creator.GenerateItem("Enemy1",refLink,22*Tile.TILE_WIDTH, 2*Tile.TILE_HEIGHT);
        items.add(item);

        item = creator.GenerateItem("Enemy1",refLink,30*Tile.TILE_WIDTH, 18*Tile.TILE_HEIGHT);
        items.add(item);

        item = creator.GenerateItem("Enemy1",refLink,50*Tile.TILE_WIDTH, 13*Tile.TILE_HEIGHT);
        items.add(item);

        item = creator.GenerateItem("Enemy2",refLink,24*Tile.TILE_WIDTH, 25*Tile.TILE_HEIGHT);
        items.add(item);
        item = creator.GenerateItem("Enemy1",refLink,25*Tile.TILE_WIDTH,13* Tile.TILE_HEIGHT);
        items.add(item);


        // Trimitem lista de iteme catre refLink pentru a o putea folosi si in alte locuri
        refLink.SetItems(items);

        ///Construieste eroul
        hero = new Hero(refLink, 64, 256);
        refLink.SetHero(hero);
    }

    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a jocului.
     */
    @Override
    public void Update()
    {
        map.Update();
        for (Item item:refLink.GetItems()){
            item.Update();
        }
        hero.Update();
    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a jocului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        map.Draw(g);
        for (Item item:refLink.GetItems()){
            item.Draw(g);
        }
        hero.Draw(g);
    }
}
