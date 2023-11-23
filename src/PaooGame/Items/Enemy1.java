package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

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
public class Enemy1 extends Character
{
    private BufferedImage image;    /*!< Referinta catre imaginea curenta a inamicului.*/

    /*! \fn public Enemy1(RefLinks refLink, float x, float y)
        \brief Constructorul de initializare al clasei Enemy1.

        \param refLink Referinta catre obiectul shortcut (obiect ce retine o serie de referinte din program).
        \param x Pozitia initiala pe axa X a inamicului.
        \param y Pozitia initiala pe axa Y a inamicului.
     */
    public Enemy1(RefLinks refLink, float x, float y)
    {
            ///Apel al constructorului clasei de baza
        super(refLink, x,y, 48, 48);

        life = 100;
        speed = 2.0f;

            ///Seteaza imaginea de start a inamicului
        image = Assets.enemy1Idle1;
            ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea implicita(normala)
        normalBounds.x = 0;
        normalBounds.y = 36;
        normalBounds.width = 48;
        normalBounds.height = 12;

            ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea de atac
        attackBounds.x = 0;
        attackBounds.y = 0;
        attackBounds.width = 48;
        attackBounds.height = 48;
    }

    /*! \fn public void Update()
        \brief Actualizeaza pozitia si imaginea inamicului.
     */
    @Override
    public void Update(){
        animationCounter++;
        // Daca contorul depaseste o valoare prestabilita (15), acesta se reseteaza si creste indexul de animatie
        if(animationCounter>15){
            animationCounter=0;
            animationIndex++;
            // Daca indexul depaseste valoarea maxima de imagini pentru o animatie (4), acesta se reseteaza la valoarea 1.
            if(animationIndex>4)
                animationIndex=1;
        }

                switch(animationIndex) {
                    case 1:
                        image = Assets.enemy1Idle1;
                        break;
                    case 2:
                        image = Assets.enemy1Idle2;
                        break;
                    case 3:
                        image = Assets.enemy1Idle3;
                        break;
                    case 4:
                        image = Assets.enemy1Idle4;
                        break;
                }
    }


    /*! \fn public void Draw(Graphics g)
        \brief Randeaza/deseneaza inamicul in noua pozitie.

        \brief g Contextul grafi in care trebuie efectuata desenarea inamicului.
     */
    @Override
    public void Draw(Graphics g)
    {

        int screenX = (int)x - (int)refLink.GetHero().GetX() + (int)refLink.GetHero().GetScreenX();
        int screenY = (int)y - (int)refLink.GetHero().GetY() + (int)refLink.GetHero().GetScreenY();
        g.drawImage(image, screenX, screenY, width, height, null);

        /// DEBUG - VIEW WALKING BOUNDS
        //g.setColor(Color.blue);
        //g.fillRect((int)(screenX + bounds.x), (int)(screenY + bounds.y), bounds.width, bounds.height);

        /// DEBUG - VIEW ATTACKING BOUNDS
        //g.setColor(Color.red);
        //g.fillRect((int)(screenX + attackBounds.x), (int)(screenY + attackBounds.y), attackBounds.width, attackBounds.height);
    }
}
