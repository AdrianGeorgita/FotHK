package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class SoilBottomLeftTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip sol/pamant/stanga-jos
 */
public class SoilBottomLeftTile extends Tile
{
    /*! \fn public SoilBottomLeftTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public SoilBottomLeftTile(int id)
    {
        super(Assets.soilBottomLeft, id);
    }

}
