package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class CliffTopRightTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip stanca/dreapta-sus
 */
public class CliffTopRightTile extends Tile
{
    /*! \fn public CliffTopRightTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public CliffTopRightTile(int id)
    {
        super(Assets.cliffTopRight, id);
    }

    public boolean IsSolid() {
        return true;
    }

}
