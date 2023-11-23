package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class SoilTopLeftTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip sol/pamant/stanga-sus
 */
public class SoilTopLeftTile extends Tile
{
    /*! \fn public SoilTopLeftTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public SoilTopLeftTile(int id)
    {
        super(Assets.soilTopLeft, id);
    }

}
