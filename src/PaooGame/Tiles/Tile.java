package PaooGame.Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

/*! \class public class Tile
    \brief Retine toate dalele intr-un vector si ofera posibilitatea regasirii dupa un id.
 */
public class Tile
{
    private static final int NO_TILES   = 40;
    public static Tile[] tiles          = new Tile[NO_TILES];       /*!< Vector de referinte de tipuri de dale.*/

        /// De remarcat ca urmatoarele dale sunt statice si publice. Acest lucru imi permite sa le am incarcate
        /// o singura data in memorie
    public static Tile grassTile        = new GrassTile(0);     /*!< Dala de tip iarba*/

    public static Tile soilTopLeftTile         = new SoilTopLeftTile(10);      /*!< Dala de tip sol/pamant/stanga-sus*/
    public static Tile soilTopCenterTile         = new SoilTopCenterTile(11);      /*!< Dala de tip sol/pamant/mijloc-sus*/
    public static Tile soilTopRightTile         = new SoilTopRightTile(12);      /*!< Dala de tip sol/pamant//dreapta-sus*/
    public static Tile soilMidLeftTile         = new SoilMidLeftTile(13);      /*!< Dala de tip sol/pamant/stanga-centru*/
    public static Tile soilTile         = new SoilTile(14);      /*!< Dala de tip sol/pamant/centru*/
    public static Tile soilMidRightTile         = new SoilMidRightTile(15);      /*!< Dala de tip sol/pamant/dreapta-centru*/
    public static Tile soilBottomLeftTile         = new SoilBottomLeftTile(16);      /*!< Dala de tip sol/pamant/stanga-jos*/
    public static Tile soilBottomCenterTile         = new SoilBottomCenterTile(17);      /*!< Dala de tip sol/pamant/mijloc-jos*/
    public static Tile soilBottomRightTile         = new SoilBottomRightTile(18);      /*!< Dala de tip sol/pamant/dreapta-jos*/

    public static Tile soilCorner1       = new SoilCorner1Tile(6);      /*!< Dala de tip sol/pamant/colt1*/
    public static Tile soilCorner2         = new SoilCorner2Tile(7);      /*!< Dala de tip sol/pamant/colt2*/
    public static Tile soilCorner3         = new SoilCorner3Tile(8);      /*!< Dala de tip sol/pamant/colt3*/
    public static Tile soilCorner4         = new SoilCorner4Tile(9);      /*!< Dala de tip sol/pamant/colt4*/

    /// Plains

    public static Tile cliffTopLeft         = new CliffTopLeftTile(20);      /*!< Dala de tip stanca/stanga-sus*/
    public static Tile cliffTopCenter         = new CliffTopCenterTile(21);      /*!< Dala de tip stanca/mijloc-sus*/
    public static Tile cliffTopRight         = new CliffTopRightTile(22);      /*!< Dala de tip stanca/dreapta-sus*/

    public static Tile cliffMidLeft         = new CliffMidLeftTile(23);      /*!< Dala de tip stanca/stanga-centru*/
    public static Tile cliffMidCenter         = new CliffMidCenterTile(24);      /*!< Dala de tip stanca/centru*/
    public static Tile cliffMidRight         = new CliffMidRightTile(25);      /*!< Dala de tip stanca/dreapta-centru*/

    public static Tile cliffBottomLeft         = new CliffBottomLeftTile(26);      /*!< Dala de tip stanca/stanga-jos*/
    public static Tile cliffBottomCenter         = new CliffBottomCenterTile(27);      /*!< Dala de tip stanca/mijloc-jos*/
    public static Tile cliffBottomRight       = new CliffBottomRightTile(28);      /*!< Dala de tip stanca/dreapta-jos*/

    public static Tile cliffWallLeft       = new CliffWallLeftTile(29);      /*!< Dala de tip stanca/zid/stanga*/
    public static Tile cliffWallCenter       = new CliffWallCenterTile(30);      /*!< Dala de tip stanca/zid/centru*/
    public static Tile cliffWallRight       = new CliffWallRightTile(31);      /*!< Dala de tip stanca/zid/dreapta*/

    public static final int TILE_WIDTH  = 25;                       /*!< Latimea unei dale.*/
    public static final int TILE_HEIGHT = 25;                       /*!< Inaltimea unei dale.*/

    protected BufferedImage img;                                    /*!< Imaginea aferenta tipului de dala.*/
    protected final int id;                                         /*!< Id-ul unic aferent tipului de dala.*/

    /*! \fn public Tile(BufferedImage texture, int id)
        \brief Constructorul aferent clasei.

        \param image Imaginea corespunzatoare dalei.
        \param id Id-ul dalei.
     */
    public Tile(BufferedImage image, int idd)
    {
        img = image;
        id = idd;

        tiles[id] = this;
    }

    /*! \fn public void Update()
        \brief Actualizeaza proprietatile dalei.
     */
    public void Update()
    {

    }

    /*! \fn public void Draw(Graphics g, int x, int y)
        \brief Deseneaza in fereastra dala.

        \param g Contextul grafic in care sa se realizeze desenarea
        \param x Coordonata x in cadrul ferestrei unde sa fie desenata dala
        \param y Coordonata y in cadrul ferestrei unde sa fie desenata dala
     */
    public void Draw(Graphics g, int x, int y)
    {
            /// Desenare dala
        g.drawImage(img, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }

    /*! \fn public boolean IsSolid()
        \brief Returneaza proprietatea de dala solida (supusa coliziunilor) sau nu.
     */
    public boolean IsSolid()
    {
        return false;
    }

    /*! \fn public int GetId()
        \brief Returneaza id-ul dalei.
     */
    public int GetId()
    {
        return id;
    }
}
