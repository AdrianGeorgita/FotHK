package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class SoilBottomCenterTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip sol/pamant/mijloc-jos
 */
public class SoilBottomCenterTile extends Tile
{
    /*! \fn public SoilBottomCenterTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public SoilBottomCenterTile(int id)
    {
        super(Assets.soilBottomCenter, id);
    }

}
