package PaooGame.Objects;

import PaooGame.Graphics.Assets;
import PaooGame.Items.Item;
import PaooGame.Tiles.*;

import java.awt.*;
import java.awt.image.BufferedImage;

/*! \class public class Object
    \brief Retine toate obiectele intr-un vector si ofera posibilitatea regasirii dupa un id.
 */
public class Object
{
    private static final int NO_TILES   = 22;

    public static final int DEFAULT_OBJECT_WIDTH  = 48;                       /*!< Latimea standard a unui obiect.*/
    public static final int DEFAULT_OBJECT_HEIGHT = 48;                       /*!< Inaltimea standard a unui obiect.*/

    public static Object[] objects          = new Object[NO_TILES];       /*!< Vector de referinte de tipuri de obiecte.*/

        /// De remarcat ca urmatoarele obiecte sunt statice si publice. Acest lucru imi permite sa le am incarcate
        /// o singura data in memorie


    public static Object tree1  = new Tree1(10,90,120);      /*!< Obstacol de tip Copac de dimensiuni diferite*/
    public static Object rock1  = new Rock1(20,Object.DEFAULT_OBJECT_WIDTH,Object.DEFAULT_OBJECT_HEIGHT);      /*!< Obstacol de tip piatra v1*/

    public static Object rock2  = new Rock2(21,Object.DEFAULT_OBJECT_WIDTH,Object.DEFAULT_OBJECT_HEIGHT);      /*!< Obstacol de tip piatra v2*/


    protected BufferedImage img;                                    /*!< Imaginea aferenta tipului de obiect.*/
    protected final int id;                                         /*!< Id-ul unic aferent tipului de obiect.*/

    /*! \fn public Object(BufferedImage texture, int id)
        \brief Constructorul aferent clasei.

        \param image Imaginea corespunzatoare dalei.
        \param id Id-ul obiectului.
     */
    public Object(BufferedImage image, int idd)
    {
        img = image;
        id = idd;

        objects[id] = this;
    }

    // Returneaza latimea unui obiect
    public int GetWidth(){ return DEFAULT_OBJECT_WIDTH; }
    // Returneaza inaltimea unui obiect
    public int GetHeight(){ return DEFAULT_OBJECT_HEIGHT; }

    /*! \fn public void Update()
        \brief Actualizeaza proprietatile obiectului.
     */
    public void Update()
    {

    }

    /*! \fn public void Draw(Graphics g, int x, int y)
        \brief Deseneaza in fereastra dala.

        \param g Contextul grafic in care sa se realizeze desenarea
        \param x Coordonata x in cadrul ferestrei unde sa fie desenat obiectul
        \param y Coordonata y in cadrul ferestrei unde sa fie desenat obiectul
     */
    public void Draw(Graphics g, int x, int y)
    {
            /// Desenare obiect

        g.drawImage(img, x-25/2, y-25/2, this.GetWidth(), this.GetHeight(), null);

        /// DEBUG - VIEW COLLISION BOX
        /*
        g.setColor(Color.gray);
        g.fillRect(x, y, 25, 25);
        */

    }

    /*! \fn public boolean IsSolid()
        \brief Returneaza proprietatea de obiect solid (supus coliziunilor) sau nu.
     */

    public boolean IsSolid() {return false;}

    /*! \fn public int GetId()
        \brief Returneaza id-ul obiectului.
     */
    public int GetId()
    {
        return id;
    }
}
