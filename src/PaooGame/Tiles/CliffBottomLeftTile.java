package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class CliffBottomLeftTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip stanca/stanga-jos
 */
public class CliffBottomLeftTile extends Tile
{
    /*! \fn public CliffBottomLeftTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public CliffBottomLeftTile(int id)
    {
        super(Assets.cliffBottomLeft, id);
    }

    public boolean IsSolid() {
        return true;
    }

}
