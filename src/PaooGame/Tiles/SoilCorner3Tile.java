package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class SoilCorner3Tile extends Tile
    \brief Abstractizeaza notiunea de dala de tip sol/pamant/colt3
 */
public class SoilCorner3Tile extends Tile
{
    /*! \fn public SoilCorner3Tile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public SoilCorner3Tile(int id)
    {
        super(Assets.soilCorner3, id);
    }

}
