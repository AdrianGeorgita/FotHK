package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class CliffTopLeftTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip stanca/stanga-sus
 */
public class CliffTopLeftTile extends Tile
{
    /*! \fn public CliffTopLeftTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public CliffTopLeftTile(int id)
    {
        super(Assets.cliffTopLeft, id);
    }

    public boolean IsSolid() {
        return true;
    }

}
