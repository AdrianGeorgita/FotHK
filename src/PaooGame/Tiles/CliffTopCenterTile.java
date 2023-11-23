package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class CliffTopCenterTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip stanca/mijloc-sus
 */
public class CliffTopCenterTile extends Tile
{
    /*! \fn public CliffTopCenterTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public CliffTopCenterTile(int id)
    {
        super(Assets.cliffTopCenter, id);
    }

    @Override
    public boolean IsSolid() {
        return true;
    }

}
