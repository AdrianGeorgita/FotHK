package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

import java.awt.image.BufferedImage;

/*! \class public class CliffWallRightTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip stanca/zid/dreapta
 */
public class CatacombsWall extends Tile
{
    /*! \fn public CliffWallRightTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public CatacombsWall(int id, BufferedImage img)
    {
        super(img, id);
    }

    @Override
    public boolean IsSolid() {
        return true;
    }

}
