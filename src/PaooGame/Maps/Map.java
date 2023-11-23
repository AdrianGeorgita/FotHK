package PaooGame.Maps;

import PaooGame.Objects.Object;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.awt.*;

/*! \class public class Map
    \brief Implementeaza notiunea de harta a jocului.
 */
public class Map
{
    private RefLinks refLink;   /*!< O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.*/
    private int width;          /*!< Latimea hartii in numar de dale.*/
    private int height;         /*!< Inaltimea hartii in numar de dale.*/
    private int [][] tiles;     /*!< Referinta catre o matrice cu codurile dalelor ce vor construi harta.*/
    private int [][] objects;   /*!< Referinta catre o matrice cu codurile obiectelor ce vor fi construite pe harta.*/

    /*! \fn public Map(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public Map(RefLinks refLink, int level)
    {
            /// Retine referinta "shortcut".
        this.refLink = refLink;
            ///incarca harta de start. Functia poate primi ca argument id-ul hartii ce poate fi incarcat.
        LoadWorld(level);
    }

    /*! \fn public  void Update()
        \brief Actualizarea hartii in functie de evenimente (un copac a fost taiat)
     */
    public  void Update()
    {
        for(int y = 0; y < 33; y++) {
            for (int x = 0; x < 60; x++) {
                if(objects[x][y] != -1) {
                    GetObject(x, y).Update();
                }
            }
        }
    }

    /*! \fn public void Draw(Graphics g)
        \brief Functia de desenare a hartii.

        \param g Contextl grafi in care se realizeaza desenarea.
     */
    public void Draw(Graphics g)
    {
            ///Se parcurge matricea de dale (codurile aferente) si se deseneaza harta respectiva
        for(int y = 0; y < 33; y++)
        {
            //for(int x = 0; x < refLink.GetGame().GetWidth()/Tile.TILE_WIDTH; x++)
            for(int x = 0; x < 60; x++)
            {
                int worldX = (int)x * Tile.TILE_WIDTH;
                int worldY  = (int)y * Tile.TILE_HEIGHT;
                int screenX = worldX - (int)refLink.GetHero().GetX() + (int)refLink.GetHero().GetScreenX();
                int screenY = worldY - (int)refLink.GetHero().GetY() + (int)refLink.GetHero().GetScreenY();
                GetTile(x, y).Draw(g, screenX, screenY);
            }
        }
         /// Se deseneaza obiectele din matricea de obiecte peste dale.
        for(int y = 0; y < 33; y++) {
            for (int x = 0; x < 60; x++) {
                if(objects[x][y] != -1) {
                    int worldX = (int)x * Tile.TILE_WIDTH;
                    int worldY  = (int)y * Tile.TILE_HEIGHT;
                    int screenX = worldX - (int)refLink.GetHero().GetX() + (int)refLink.GetHero().GetScreenX();
                    int screenY = worldY - (int)refLink.GetHero().GetY() + (int)refLink.GetHero().GetScreenY();
                    GetObject(x, y).Draw(g, screenX, screenY);
                }
            }
        }


    }

    /*! \fn public Tile GetTile(int x, int y)
        \brief Intoarce o referinta catre dala aferenta codului din matrice de dale.

        In situatia in care dala nu este gasita datorita unei erori ce tine de cod dala, coordonate gresite etc se
        intoarce o dala predefinita (ex. soilTile, cliffWallCenter)
     */
    public Tile GetTile(int x, int y)
    {
        if(x < 0 || y < 0 || x >= width || y >= height)
        {
            return Tile.soilTile;
        }
        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null)
        {
            return Tile.cliffWallCenter;
        }
        return t;
    }

    /*! \fn public Tile GetObject(int x, int y)
        \brief Intoarce o referinta catre dala aferenta codului din matrice de obiecte.

        In situatia in care obictul nu este gasita datorita unei erori ce tine de cod dala, coordonate gresite etc se
        intoarce valoarea null
     */
    public Object GetObject(int x, int y)
    {
        if(objects[x][y] != -1) {
            Object t = Object.objects[objects[x][y]];
            if (t == null) {
                return null;
            }
            return t;
        }
        return null;
    }

    /*! \fn private void LoadWorld()
        \brief Functie de incarcare a hartii jocului.
        Aici se poate genera sau incarca din fisier harta. Momentan este incarcata static.
     */
    public void LoadWorld(int level)
    {
        //atentie latimea si inaltimea trebuiesc corelate cu dimensiunile ferestrei sau
        //se poate implementa notiunea de camera/cadru de vizualizare al hartii
            ///Se stabileste latimea hartii in numar de dale.
        width = 60;
            ///Se stabileste inaltimea hartii in numar de dale
        height = 33;
            ///Se construieste matricea de coduri de dale
        tiles = new int[width][height];
        objects = new int[width][height];
            //Se incarca matricea cu coduri

        try {
            File mapFile = null;
            File objectsFile = null;

            switch (level) {
                case 1:
                    mapFile = new File("res/maps/Map1Tiles.txt");
                    objectsFile = new File("res/maps/Map1Objects.txt");
                    break;
                case 2:
                    mapFile = new File("res/maps/Map2Tiles.txt");
                    objectsFile = new File("res/maps/Map2Objects.txt");
                    break;
                case 3:
                    mapFile = new File("res/maps/Map3Tiles.txt");
                    objectsFile = new File("res/maps/Map3Objects.txt");
                    break;
            }


            Scanner mapScanner = new Scanner(mapFile);
            Scanner objectsScanner = new Scanner(objectsFile);


            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int Id = mapScanner.nextInt();
                    int Id2 = objectsScanner.nextInt();
                    tiles[x][y] = Id; //Level2Tiles(y, x);
                    objects[x][y] = Id2; //Level2Objects(y, x);
                }
            }
        }
        catch(FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}