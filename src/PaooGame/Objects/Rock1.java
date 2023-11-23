package PaooGame.Objects;

import PaooGame.Graphics.Assets;

/*! \class public class Rock1 extends Object
    \brief Abstractizeaza notiunea de obiect de tip piatra
 */
public class Rock1 extends Object
{

    public int width,height;    /// Retin latimea si inaltimea obiectului

    /*! \fn public Rock1(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul obiectului util in desenarea hartii.
     */
    public Rock1(int id, int width, int height, boolean Solid)
    {
        super(Assets.rock1, id,Solid);
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
