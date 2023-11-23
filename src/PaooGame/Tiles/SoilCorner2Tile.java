package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class SoilCorner2Tile extends Tile
    \brief Abstractizeaza notiunea de dala de tip sol/pamant/colt2
 */
public class SoilCorner2Tile extends Tile
{
    /*! \fn public SoilCorner2Tile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public SoilCorner2Tile(int id)
    {
        super(Assets.soilCorner2, id);
    }

}
