package PaooGame.Objects;

import PaooGame.Graphics.Assets;

import java.awt.*;

/*! \class public class Rock1 extends Object
    \brief Abstractizeaza notiunea de obiect de tip piatra
 */
public class Candle extends Object
{

    public int width,height;    /// Retin latimea si inaltimea obiectului
    private int animationCounter = 0;
    private int animationIndex = 0;

    /*! \fn public Rock1(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul obiectului util in desenarea hartii.
     */
    public Candle(int id, int width, int height, boolean Solid)
    {
        super(Assets.candles1, id,Solid);
        this.width = width;
        this.height = height;
    }

    @Override
    public void Update(){
        switch (animationIndex){
            case 0:
                img = Assets.candles1;
                break;
            case 1:
                img = Assets.candles2;
                break;
            case 3:
                img = Assets.candles3;
                break;
            case 4:
                img = Assets.candles4;
                break;
        }

        if(animationCounter==500){
            if(animationIndex < 3)
                animationIndex++;
            else
                animationIndex = 0;
            animationCounter=0;
        }
        else
            animationCounter++;
    }

    @Override
    public void Draw(Graphics g, int x, int y)
    {
        /// Desenare copac (repozitionat astfel incat sa coincida cu dreptunghiul de coliziune)

        g.drawImage(img, x, y, this.GetWidth(), this.GetHeight(), null);

        /// DEBUG - VIEW COLLISION BOX
        /*
        g.setColor(Color.green);
        g.fillRect(x, y-5, 25, 25);
        */

    }

}
