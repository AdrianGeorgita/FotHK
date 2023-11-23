package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class SoilTopCenterTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip sol/pamant/mijloc-sus
 */
public class SoilTopCenterTile extends Tile
{
    /*! \fn public SoilTopCenterTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public SoilTopCenterTile(int id)
    {
        super(Assets.soilTopCenter, id);
    }

}
