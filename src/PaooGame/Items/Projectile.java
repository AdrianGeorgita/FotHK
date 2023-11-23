package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/*! \class public class Enemy1 extends Character
    \brief Implementeaza notiunea de inamic

    Elementele suplimentare pe care le aduce fata de clasa de baza sunt:
        imaginea (acest atribut poate fi ridicat si in clasa de baza)
        deplasarea
        atacul (nu este implementat momentan)
        dreptunghiul de coliziune
 */
public class Projectile extends Item
{
    private BufferedImage image;    /*!< Referinta catre imaginea curenta a inamicului.*/

    private int speed;
    private int damage;

    private int maxDistance;

    private int direction;

    public boolean inactive = false;
    private int attackingCounter = 0;

    private int initialX;
    private int initialY;

    private int animationCounter = 0;
    private int animationIndex = 0;

    /*! \fn public Enemy1(RefLinks refLink, float x, float y)
        \brief Constructorul de initializare al clasei Enemy1.

        \param refLink Referinta catre obiectul shortcut (obiect ce retine o serie de referinte din program).
        \param x Pozitia initiala pe axa X a inamicului.
        \param y Pozitia initiala pe axa Y a inamicului.
     */
    public Projectile(RefLinks refLink, float x, float y, int id,int direction, int speed, int damage, int maxDistance)
    {
            ///Apel al constructorului clasei de baza
        super(refLink, x,y, 64, 64);

        this.initialX = (int)x;
        this.initialY = (int)y;
        this.direction = direction;
        this.speed = speed;
        this.damage = damage;
        this.maxDistance = maxDistance;

            ///Seteaza imaginea de start a inamicului
        switch (direction){
            case 0:
                image = Assets.fireballLeft1;
                break;
            case 1:
                image = Assets.fireballRight1;
                break;
            case 2:
                image = Assets.fireballUp1;
                break;
            case 3:
                image = Assets.fireballDown1;
                break;
        }


            ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea implicita(normala)
        normalBounds.x = 16;
        normalBounds.y = 24;
        normalBounds.width = 32;
        normalBounds.height = 16;
    }

    // Se verifica daca dalele xTile si yTile se afla in interiorul hartii
    public boolean CheckIfInsideMap(int xTile,int yTile){
        if(xTile >= 0 && xTile <= 59 && yTile >= 0 && yTile <= 32)
            return true;
        return false;
    }

    boolean CheckCollision(int xTile, int yTile){
        if(CheckIfInsideMap(xTile,yTile) && !refLink.GetMap().GetTile(xTile,yTile).IsSolid() &&
                (refLink.GetMap().GetObject(xTile,yTile) == null || !refLink.GetMap().GetObject(xTile,yTile).IsSolid())) {
            ArrayList<Item> items = refLink.GetItems();
            if(refLink.GetChest()!=null)
                items.add(refLink.GetChest());
            for(Item character:items)
                switch (facingPos){
                    case 1:
                        if(x+bounds.x+ bounds.width >= character.x+character.bounds.x && x+ bounds.x <= character.x+character.bounds.x+character.bounds.width && y+bounds.y-12 <= character.y+character.bounds.y && y+ bounds.y+24+ bounds.height >= character.y+character.bounds.y+character.bounds.height)
                            return true;
                        break;
                    case 2:
                        if(x+bounds.x+ bounds.width >= character.x+character.bounds.x && x+ bounds.x <= character.x+character.bounds.x+character.bounds.width && x+bounds.x >= character.x+character.bounds.x && y+bounds.y-12 <= character.y+character.bounds.y && y+ bounds.y+24+ bounds.height >= character.y+character.bounds.y+character.bounds.height)
                            return true;
                        break;
                    case 3:
                        /// DEBUG - PRINT COORDINATES
                        /*System.out.println("X1: "+(x+bounds.x+ bounds.width)+" >  X2: "+(item.x+item.bounds.x));
                        System.out.println("X3: "+(x+ bounds.x)+" <  X4: "+(item.x+item.bounds.x+item.bounds.width));
                        System.out.println("Y1: "+(y+bounds.y)+" <  Y2: "+(item.y+item.bounds.y));
                        System.out.println("Y3: "+(y+ bounds.y+ bounds.height)+" >  Y4: "+(item.y+item.bounds.y+item.bounds.height));
                        */
                        if(x+bounds.x+ bounds.width >= character.x+character.bounds.x && x+ bounds.x <= character.x+character.bounds.x+character.bounds.width && y+bounds.y-12 <= character.y + character.bounds.y + character.bounds.height && y+bounds.y >= character.y + character.bounds.y)
                            return true;
                        break;
                    case 4:
                        if(x+bounds.x+ bounds.width >= character.x+character.bounds.x && x+ bounds.x <= character.x+character.bounds.x+character.bounds.width && y+bounds.y+ bounds.height+24 >= character.y+character.bounds.y && y+bounds.y+ bounds.height <= character.y+character.bounds.y+character.bounds.height)
                            return true;
                        break;
                }
            return false;
        }
        return true;
    }

    private void AttackHero(Hero hero) {
        if (hero.invincible == false) {
            if (damage >= hero.GetLife()) {
                hero.SetLife(0);
                hero.invincible = true;
            } else {
                hero.SetLife(hero.GetLife() - damage);
            }
        }
    }


    /*! \fn public void Update()
        \brief Actualizeaza pozitia si imaginea inamicului.
     */
    @Override
    public void Update(){
        if(!inactive) {
            if (animationCounter < 15) {
                animationCounter++;
                refLink.PlaySound(4);
            }
            else {
                animationCounter = 0;

                if (animationIndex < 4)
                    animationIndex++;
                else
                    animationIndex = 0;

                switch (direction) {
                    case 0:
                        switch (animationIndex) {
                            case 0:
                                image = Assets.fireballLeft1;
                                break;
                            case 1:
                                image = Assets.fireballLeft2;
                                break;
                            case 2:
                                image = Assets.fireballLeft3;
                                break;
                            case 3:
                                image = Assets.fireballLeft4;
                                break;
                            case 4:
                                image = Assets.fireballLeft5;
                                break;
                        }
                        break;
                    case 1:
                        switch (animationIndex) {
                            case 0:
                                image = Assets.fireballRight1;
                                break;
                            case 1:
                                image = Assets.fireballRight2;
                                break;
                            case 2:
                                image = Assets.fireballRight3;
                                break;
                            case 3:
                                image = Assets.fireballRight4;
                                break;
                            case 4:
                                image = Assets.fireballRight5;
                                break;
                        }
                        break;
                    case 2:
                        switch (animationIndex) {
                            case 0:
                                image = Assets.fireballUp1;
                                break;
                            case 1:
                                image = Assets.fireballUp2;
                                break;
                            case 2:
                                image = Assets.fireballUp3;
                                break;
                            case 3:
                                image = Assets.fireballUp4;
                                break;
                            case 4:
                                image = Assets.fireballUp5;
                                break;
                        }
                        break;
                    case 3:
                        switch (animationIndex) {
                            case 0:
                                image = Assets.fireballDown1;
                                break;
                            case 1:
                                image = Assets.fireballDown2;
                                break;
                            case 2:
                                image = Assets.fireballDown3;
                                break;
                            case 3:
                                image = Assets.fireballDown4;
                                break;
                            case 4:
                                image = Assets.fireballDown5;
                                break;
                        }
                        break;
                }
            }

            int xTile,xTile2,xTile1,yTile, yTile1, yTile2;
            Hero hero = refLink.GetHero();
            switch (direction){
                case 0:
                    facingPos = 2;
                    xTile = (int)((x+bounds.x-speed)/25); // Dala Stanga
                    yTile1 = (int)((y+bounds.y)/25); // Dala Sus
                    yTile2 = (int)((y+bounds.y+ bounds.height)/25); // Dala Jos

                    // Se verifica daca Dala din Stanga-Jos, respectiv Stanga-Sus au coliziune. In caz contrar, eroul isi poate continua deplasarea
                    if(!CheckCollision(xTile,yTile1) && !CheckCollision(xTile,yTile2) && !CheckCollision(xTile,(yTile1+yTile2)/2)){
                        if (x >= initialX-maxDistance) {
                            x-=speed;
                            if(x+normalBounds.x<=hero.x+hero.normalBounds.x+hero.normalBounds.width){
                                if(y+normalBounds.y+Tile.TILE_HEIGHT*1>=hero.y+hero.normalBounds.y && y+normalBounds.y+normalBounds.height-Tile.TILE_HEIGHT*1 <= hero.y+hero.normalBounds.y+hero.normalBounds.height) {
                                    inactive = true;
                                    AttackHero(hero);
                                }
                            }
                        }
                        else{
                            inactive = true;
                        }
                    }
                    else{
                        inactive = true;
                    }
                    break;
                case 1:
                    facingPos = 1;
                    xTile = (int)((x+bounds.x+bounds.width+speed)/25); // Dala Dreapta
                    yTile1 = (int)((y+bounds.y)/25); // Dala Sus
                    yTile2 = (int)((y+bounds.y+ bounds.height)/25); // Dala Jos

                    // Se verifica daca Dala din Dreapta-Jos, respectiv Dreapta-Sus au coliziune. In caz contrar, eroul isi poate continua deplasarea
                    if(!CheckCollision(xTile,yTile1) && !CheckCollision(xTile,yTile2) && !CheckCollision(xTile,(yTile1+yTile2)/2)){
                        if (x <= initialX+maxDistance) {
                            x+=speed;
                            if(x+normalBounds.x+normalBounds.width>=hero.x+hero.normalBounds.x){
                                if(y+normalBounds.y+Tile.TILE_HEIGHT*1>=hero.y+hero.normalBounds.y && y+normalBounds.y+normalBounds.height-Tile.TILE_HEIGHT*1 <= hero.y+hero.normalBounds.y+hero.normalBounds.height) {
                                    inactive = true;
                                    AttackHero(hero);
                                }
                            }
                        }
                        else{
                            inactive = true;
                        }
                    }
                    else{
                        inactive = true;
                    }
                    break;
                case 2:
                    facingPos = 3;
                    xTile1 = (int)((x+bounds.x)/25);    // Dala Stanga
                    xTile2 = (int)((x+bounds.x+bounds.width)/25); // Dala Dreapta
                    yTile = (int)((y+bounds.y-speed)/25); // Dala Sus

                    // Se verifica daca Dala din Stanga-Sus, respectiv Dreapta-Sus au coliziune. In caz contrar, eroul isi poate continua deplasarea
                    if(!CheckCollision(xTile1,yTile) && !CheckCollision(xTile2,yTile) && !CheckCollision((xTile1+xTile2)/2,yTile)){
                        if (y >= initialY-maxDistance) {
                            y-=speed;
                            if(y+normalBounds.y < hero.y+hero.normalBounds.y+hero.normalBounds.height){
                                if(x+normalBounds.x+ Tile.TILE_WIDTH*1 >= hero.x+hero.normalBounds.x && x+normalBounds.x+normalBounds.width-Tile.TILE_WIDTH*1 <= hero.x+hero.normalBounds.x+hero.normalBounds.width) {
                                    inactive = true;
                                    AttackHero(hero);
                                }
                            }
                        }
                        else{
                            inactive = true;
                        }
                    }
                    else{
                        inactive = true;
                    }
                    break;
                case 3:
                    facingPos = 4;
                    xTile1 = (int)((x+bounds.x)/25); // Dala Stanga
                    xTile2 = (int)((x+bounds.x+bounds.width)/25); // Dala Dreapta
                    yTile = (int)((y+bounds.y+ bounds.height+speed)/25); // Dala Jos

                    // Se verifica daca Dala din Stanga-Jos, respectiv Dreapta-Jos au coliziune. In caz contrar, eroul isi poate continua deplasarea
                    if(!CheckCollision(xTile1,yTile) && !CheckCollision(xTile2,yTile) && !CheckCollision((xTile1+xTile2)/2,yTile)){
                        if (y <= initialY+maxDistance) {
                            y+=speed;
                            if(y+normalBounds.y+normalBounds.height > hero.y+hero.normalBounds.y){
                                if(x+normalBounds.x+ Tile.TILE_WIDTH*1 >= hero.x+hero.normalBounds.x && x+normalBounds.x+normalBounds.width-Tile.TILE_WIDTH*1 <= hero.x+hero.normalBounds.x+hero.normalBounds.width) {
                                    inactive = true;
                                    AttackHero(hero);
                                }
                            }
                        }
                        else{
                            inactive = true;
                        }
                    }
                    else{
                        inactive = true;
                    }
                    break;
            }
        }

    }



    /*! \fn public void Draw(Graphics g)
        \brief Randeaza/deseneaza inamicul in noua pozitie.

        \brief g Contextul grafi in care trebuie efectuata desenarea inamicului.
     */
    @Override
    public void Draw(Graphics g)
    {

        if(!inactive){
            int screenX = (int)x - (int)refLink.GetHero().GetX() + (int)refLink.GetHero().GetScreenX();
            int screenY = (int)y - (int)refLink.GetHero().GetY() + (int)refLink.GetHero().GetScreenY();
            g.drawImage(image, screenX, screenY, width, height, null);


            /// DEBUG - VIEW WALKING BOUNDS
            //g.setColor(Color.blue);
            //g.fillRect((int)(screenX + bounds.x), (int)(screenY + bounds.y), bounds.width, bounds.height);

        }
    }
}
