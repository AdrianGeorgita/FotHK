package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class SoilCorner1Tile extends Tile
    \brief Abstractizeaza notiunea de dala de tip sol/pamant/colt1
 */
public class SoilCorner1Tile extends Tile
{
    /*! \fn public SoilCorner1Tile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public SoilCorner1Tile(int id)
    {
        super(Assets.soilCorner1, id);
    }

}
