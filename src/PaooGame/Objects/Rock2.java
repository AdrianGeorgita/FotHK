package PaooGame.Objects;

import PaooGame.Graphics.Assets;

/*! \class public class Rock2 extends Object
    \brief Abstractizeaza notiunea de obiect de tip piatra v2.
 */
public class Rock2 extends Object
{

    public int width,height; // Retin latimea si inaltimea obiectului

    /*! \fn public Rock2(int id)
    \brief Constructorul de initializare al clasei

    \param id Id-ul obiectului util in desenarea hartii.
 */
    public Rock2(int id, int width, int height, boolean Solid)
    {
        super(Assets.rock2, id,Solid);
        this.width = width;
        this.height = height;
    }

    @Override
    public int GetWidth() {return width;}

    @Override
    public int GetHeight(){return height;}

    @Override
    public boolean IsSolid() {return true;}

}
