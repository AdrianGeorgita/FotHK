package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class CliffWallRightTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip stanca/zid/dreapta
 */
public class CliffWallRightTile extends Tile
{
    /*! \fn public CliffWallRightTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public CliffWallRightTile(int id)
    {
        super(Assets.cliffWallRight, id);
    }

    @Override
    public boolean IsSolid() {
        return true;
    }

}
