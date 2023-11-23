package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class CliffWallCenterTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip stanca/zid/centru
 */
public class CliffWallCenterTile extends Tile
{
    /*! \fn public CliffWallCenterTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public CliffWallCenterTile(int id)
    {
        super(Assets.cliffWallCenter, id);
    }

    @Override
    public boolean IsSolid() {
        return true;
    }
}
