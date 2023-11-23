package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class CliffWallLeftTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip stanca/zid/stanga
 */
public class CliffWallLeftTile extends Tile
{
    /*! \fn public CliffWallLeftTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public CliffWallLeftTile(int id)
    {
        super(Assets.cliffWallLeft, id);
    }

    @Override
    public boolean IsSolid() {
        return true;
    }

}
