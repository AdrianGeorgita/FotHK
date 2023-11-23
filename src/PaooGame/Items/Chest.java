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
public class Chest extends Item
{
    private BufferedImage image;    /*!< Referinta catre imaginea curenta a inamicului.*/

    private int animationIndex = 0;
    private int animationCounter = 0;

    private boolean fullLife=false;
    private int lifeIncrease=0;
    private int damageIncrease=0;

    private int armorlevel;

    private boolean openened = false;

    private boolean hidden = false;

    /*! \fn public Enemy1(RefLinks refLink, float x, float y)
        \brief Constructorul de initializare al clasei Enemy1.

        \param refLink Referinta catre obiectul shortcut (obiect ce retine o serie de referinte din program).
        \param x Pozitia initiala pe axa X a inamicului.
        \param y Pozitia initiala pe axa Y a inamicului.
     */
    public Chest(RefLinks refLink, float x, float y, int id,boolean fullLife,int lifeIncrease, int damageIncrease, int armorLevel)
    {
            ///Apel al constructorului clasei de baza
        super(refLink, x,y, 48, 48);

        this.fullLife = fullLife;
        this.lifeIncrease = lifeIncrease;
        this.damageIncrease = damageIncrease;
        this.armorlevel = armorLevel;

            ///Seteaza imaginea de start a inamicului
        image = Assets.chest1;
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
        if(openened){
            if(animationCounter<15)
                animationCounter++;
            else{
                animationCounter = 0;
                if(animationIndex<3)
                    animationIndex++;
            }

            switch (animationIndex){
                case 0:
                    image = Assets.chest1;
                    break;
                case 1:
                    image = Assets.chest2;
                    break;
                case 2:
                    image = Assets.chest3;
                    break;
                case 3:
                    image = Assets.chest4;
                    break;
            }
        }
    }

    public void Open(){
        if(!openened){
            Hero hero = refLink.GetHero();
            if(hero.HasKey()) {
                openened = true;

                hero.openedChest = true;
                if (lifeIncrease > 0) {
                    hero.SetLife(hero.GetLife() + lifeIncrease);
                    hero.armorLevel = armorlevel;
                    hero.maxLife = hero.GetLife();
                }

                if (damageIncrease > 0) {
                    hero.SetDamage(hero.GetDamage() + damageIncrease);
                }

                if (fullLife) {
                    hero.SetLife(hero.maxLife);
                }
            }
        }
    }

    public void MarkAsOpen(){
        openened = true;
    }

    public void Hide(){
        hidden = true;
    }


    /*! \fn public void Draw(Graphics g)
        \brief Randeaza/deseneaza inamicul in noua pozitie.

        \brief g Contextul grafi in care trebuie efectuata desenarea inamicului.
     */
    @Override
    public void Draw(Graphics g)
    {

        if(!hidden) {
            int screenX = (int) x - (int) refLink.GetHero().GetX() + (int) refLink.GetHero().GetScreenX();
            int screenY = (int) y - (int) refLink.GetHero().GetY() + (int) refLink.GetHero().GetScreenY();
            g.drawImage(image, screenX, screenY, width, height, null);


            /// DEBUG - VIEW WALKING BOUNDS
            //g.setColor(Color.blue);
            //g.fillRect((int)(screenX + bounds.x), (int)(screenY + bounds.y), bounds.width, bounds.height);

            /// DEBUG - VIEW ATTACKING BOUNDS
            //g.setColor(Color.red);
            //g.fillRect((int)(screenX + attackBounds.x), (int)(screenY + attackBounds.y), attackBounds.width, attackBounds.height);
        }
    }
}
