package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class CliffMidRightTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip stanca/dreapta-centru
 */
public class CliffMidRightTile extends Tile
{
    /*! \fn public CliffMidRightTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public CliffMidRightTile(int id)
    {
        super(Assets.cliffMidRight, id);
    }

    public boolean IsSolid() {
        return true;
    }

}
