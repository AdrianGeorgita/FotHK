package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class CliffBottomCenterTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip stanca/mijloc-jos
 */
public class CliffBottomCenterTile extends Tile
{
    /*! \fn public CliffBottomCenterTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public CliffBottomCenterTile(int id)
    {
        super(Assets.cliffBottomCenter, id);
    }

    @Override
    public boolean IsSolid() {
        return true;
    }

}
