package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class SoilMidLeftTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip sol/pamant/stanga-centru
 */
public class SoilMidLeftTile extends Tile
{
    /*! \fn public SoilMidLeftTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public SoilMidLeftTile(int id)
    {
        super(Assets.soilMidLeft, id);
    }

}
