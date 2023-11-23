package PaooGame.Objects;

import PaooGame.Graphics.Assets;
import PaooGame.Items.Item;
import PaooGame.Main;

import java.awt.*;

/*! \class public class Tree1 extends Object
    \brief Abstractizeaza notiunea de obiect de tip copac.
 */
public class Tree1 extends Object
{

    public int width,height; // Retin latimea si inaltimea obiectului

    /*! \fn public Tree1(int id)
    \brief Constructorul de initializare al clasei

    \param id Id-ul obiectului util in desenarea hartii.
 */
    public Tree1(int id,int width,int height, boolean Solid)
    {
        super(Assets.tree1, id, Solid);
        this.width = width;
        this.height = height;
    }

    // Returneaza latimea unui obiect
    @Override
    public int GetWidth() {return width;}

    // Returneaza inaltimea unui obiect
    @Override
    public int GetHeight(){return height;}

    @Override
    public void Draw(Graphics g, int x, int y)
    {
        /// Desenare copac (repozitionat astfel incat sa coincida cu dreptunghiul de coliziune)

        g.drawImage(img, x-(this.GetWidth()-DEFAULT_OBJECT_WIDTH-25/2), y-(this.GetHeight()-DEFAULT_OBJECT_HEIGHT+this.GetHeight()/12), this.GetWidth(), this.GetHeight(), null);

        /// DEBUG - VIEW COLLISION BOX
        /*
        g.setColor(Color.green);
        g.fillRect(x, y-5, 25, 25);
        */

    }

    // Returneaza "True" pentru ca obiectul sa fie supus coliziunilor
    @Override
    public boolean IsSolid() {return true;}

}
