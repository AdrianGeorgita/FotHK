package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class CliffMidCenterTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip stanca/centru
 */
public class CliffMidCenterTile extends Tile
{
    /*! \fn public CliffMidCenterTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public CliffMidCenterTile(int id)
    {
        super(Assets.cliffMidCenter, id);
    }


}
