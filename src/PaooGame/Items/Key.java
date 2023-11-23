package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;

/*! \class public class Enemy1 extends Character
    \brief Implementeaza notiunea de inamic

    Elementele suplimentare pe care le aduce fata de clasa de baza sunt:
        imaginea (acest atribut poate fi ridicat si in clasa de baza)
        deplasarea
        atacul (nu este implementat momentan)
        dreptunghiul de coliziune
 */
public class Key extends Item
{
    private BufferedImage image;    /*!< Referinta catre imaginea curenta a inamicului.*/

    private boolean pickedUp = false;

    /*! \fn public Enemy1(RefLinks refLink, float x, float y)
        \brief Constructorul de initializare al clasei Enemy1.

        \param refLink Referinta catre obiectul shortcut (obiect ce retine o serie de referinte din program).
        \param x Pozitia initiala pe axa X a inamicului.
        \param y Pozitia initiala pe axa Y a inamicului.
     */
    public Key(RefLinks refLink, float x, float y, int id)
    {
            ///Apel al constructorului clasei de baza
        super(refLink, x,y, 24, 24);

            ///Seteaza imaginea de start a inamicului
        image = Assets.key;
            ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea implicita(normala)
        normalBounds.x = 0;
        normalBounds.y = 0;
        normalBounds.width = 24;
        normalBounds.height = 24;

    }


    /*! \fn public void Update()
        \brief Actualizeaza pozitia si imaginea inamicului.
     */
    @Override
    public void Update(){

    }

    public void PickUp(){
        if(!pickedUp){
            System.out.println("Pick up - key");
            Hero hero = refLink.GetHero();
            pickedUp = true;
            hero.SetKey(true);
        }
    }

    public void MarkAsPickedUp(){
        pickedUp = true;
    }


    /*! \fn public void Draw(Graphics g)
        \brief Randeaza/deseneaza inamicul in noua pozitie.

        \brief g Contextul grafi in care trebuie efectuata desenarea inamicului.
     */
    @Override
    public void Draw(Graphics g)
    {

        int screenX = (int) x - (int) refLink.GetHero().GetX() + (int) refLink.GetHero().GetScreenX();
        int screenY = (int) y - (int) refLink.GetHero().GetY() + (int) refLink.GetHero().GetScreenY();

        if(!pickedUp) {
            g.drawImage(image, screenX, screenY, width, height, null);
        }


        /// DEBUG - VIEW WALKING BOUNDS
        //g.setColor(Color.blue);
        //g.fillRect((int)(screenX + bounds.x), (int)(screenY + bounds.y), bounds.width, bounds.height);
    }
}
