package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class SoilTopRightTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip sol/pamant/dreapta-sus
 */
public class SoilTopRightTile extends Tile
{
    /*! \fn public SoilTopRightTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public SoilTopRightTile(int id)
    {
        super(Assets.soilTopRight, id);
    }

}
