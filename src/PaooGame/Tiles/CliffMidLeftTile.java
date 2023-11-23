package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class CliffMidLeftTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip stanca/stanga-centru
 */
public class CliffMidLeftTile extends Tile
{
    /*! \fn public CliffMidLeftTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public CliffMidLeftTile(int id)
    {
        super(Assets.cliffMidLeft, id);
    }

    public boolean IsSolid() {
        return true;
    }

}
