package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class SoilBottomRightTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip sol/pamant/dreapta-jos
 */
public class SoilBottomRightTile extends Tile
{
    /*! \fn public SoilBottomRightTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public SoilBottomRightTile(int id)
    {
        super(Assets.soilBottomRight, id);
    }

}
