package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class SoilCorner4Tile extends Tile
    \brief Abstractizeaza notiunea de dala de tip sol/pamant/colt4
 */
public class SoilCorner4Tile extends Tile
{
    /*! \fn public SoilCorner4Tile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public SoilCorner4Tile(int id)
    {
        super(Assets.soilCorner4, id);
    }

}
