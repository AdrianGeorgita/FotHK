package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class SoilMidRightTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip sol/pamant/dreapta-centru
 */
public class SoilMidRightTile extends Tile
{
    /*! \fn public SoilMidRightTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public SoilMidRightTile(int id)
    {
        super(Assets.soilMidRight, id);
    }

}
