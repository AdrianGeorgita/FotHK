package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class CliffBottomRightTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip dreapta-jos
 */
public class CliffBottomRightTile extends Tile
{
    /*! \fn public CliffBottomRightTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public CliffBottomRightTile(int id)
    {
        super(Assets.cliffBottomRight, id);
    }

    public boolean IsSolid() {
        return true;
    }

}
