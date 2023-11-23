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
    public Enemy1(RefLinks refLink, float x, float y, int id)
    {
            ///Apel al constructorului clasei de baza
        super(refLink, x,y, 48, 48,id);

        life = 30;
        maxLife = life;
        speed = 1.0f;
        damage = 5;

        initialX=x;
        initialY=y;

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

    /// Se verifica daca dalele xTile si yTile sunt solide si daca exista vreun inamic pe directia eroului
    boolean CheckCollision(int xTile, int yTile){
        Hero hero = refLink.GetHero();
        if(CheckIfInsideMap(xTile,yTile) && !refLink.GetMap().GetTile(xTile,yTile).IsSolid() &&
                (refLink.GetMap().GetObject(xTile,yTile) == null || !refLink.GetMap().GetObject(xTile,yTile).IsSolid())) {
            for(Item character:refLink.GetItems())
                if(character != this) {
                    switch (facingPos) {
                        case 1:
                            if (x + bounds.x + bounds.width >= character.x + character.bounds.x && x + bounds.x <= character.x + character.bounds.x + character.bounds.width && y + bounds.y - 12 <= character.y + character.bounds.y && y + bounds.y + 24 + bounds.height >= character.y + character.bounds.y + character.bounds.height)
                                return true;
                            if (x + bounds.x + bounds.width >= hero.x + hero.bounds.x && x + bounds.x <= hero.x + hero.bounds.x + hero.bounds.width && y + bounds.y - 12 <= hero.y + hero.bounds.y && y + bounds.y + 24 + bounds.height >= hero.y + character.bounds.y + hero.bounds.height)
                                return true;
                            break;
                        case 2:
                            if (x + bounds.x + bounds.width >= character.x + character.bounds.x && x + bounds.x <= character.x + character.bounds.x + character.bounds.width && x + bounds.x >= character.x + character.bounds.x && y + bounds.y - 12 <= character.y + character.bounds.y && y + bounds.y + 24 + bounds.height >= character.y + character.bounds.y + character.bounds.height)
                                return true;
                            if (x + bounds.x + bounds.width >= hero.x + hero.bounds.x && x + bounds.x <= hero.x + hero.bounds.x + hero.bounds.width && x + bounds.x >= hero.x + hero.bounds.x && y + bounds.y - 12 <= hero.y + hero.bounds.y && y + bounds.y + 24 + bounds.height >= hero.y + hero.bounds.y + hero.bounds.height)
                                return true;
                            break;
                        case 3:
                            /// DEBUG - PRINT COORDINATES
                            /*System.out.println("X1: "+(x+bounds.x+ bounds.width)+" >  X2: "+(item.x+item.bounds.x));
                            System.out.println("X3: "+(x+ bounds.x)+" <  X4: "+(item.x+item.bounds.x+item.bounds.width));
                            System.out.println("Y1: "+(y+bounds.y)+" <  Y2: "+(item.y+item.bounds.y));
                            System.out.println("Y3: "+(y+ bounds.y+ bounds.height)+" >  Y4: "+(item.y+item.bounds.y+item.bounds.height));
                            */
                            if (x + bounds.x + bounds.width >= character.x + character.bounds.x && x + bounds.x <= character.x + character.bounds.x + character.bounds.width && y + bounds.y - 12 <= character.y + character.bounds.y + character.bounds.height && y + bounds.y >= character.y + character.bounds.y)
                                return true;
                            if (x + bounds.x + bounds.width >= hero.x + hero.bounds.x && x + bounds.x <= hero.x + hero.bounds.x + hero.bounds.width && y + bounds.y - 12 <= hero.y + hero.bounds.y + hero.bounds.height && y + bounds.y >= hero.y + hero.bounds.y)
                                return true;
                            break;
                        case 4:
                            if (x + bounds.x + bounds.width >= character.x + character.bounds.x && x + bounds.x <= character.x + character.bounds.x + character.bounds.width && y + bounds.y + bounds.height + 24 >= character.y + character.bounds.y && y + bounds.y + bounds.height <= character.y + character.bounds.y + character.bounds.height)
                                return true;
                            if (x + bounds.x + bounds.width >= hero.x + hero.bounds.x && x + bounds.x <= hero.x + hero.bounds.x + hero.bounds.width && y + bounds.y + bounds.height + 24 >= hero.y + hero.bounds.y && y + bounds.y + bounds.height <= hero.y + hero.bounds.y + hero.bounds.height)
                                return true;
                            break;
                    }
                }
            return false;
        }
        return true;
    }

    private void AttackHero(Hero hero, String direction) {
        if (hero.invincible == false) {
            attacking = true;
            if(attackingCounter<50)
                attackingCounter++;
            else {
                xMove = 0;
                yMove = 0;
                attackingCounter = 0;
                if (GetDamage() >= hero.GetLife()) {
                    hero.SetLife(0);
                    hero.invincible = true;
                } else {
                    hero.SetLife(hero.GetLife() - GetDamage());
                }
            }

        }

    }

    /*! \fn public void Update()
        \brief Actualizeaza pozitia si imaginea inamicului.
     */
    @Override
    public void Update(){
        Move();

        animationCounter++;
        // Daca contorul depaseste o valoare prestabilita (15), acesta se reseteaza si creste indexul de animatie
        if(animationCounter>15){
            animationCounter=0;
            animationIndex++;
            // Daca indexul depaseste valoarea maxima de imagini pentru o animatie (4), acesta se reseteaza la valoarea 1.
            if(animationIndex>4)
                animationIndex=1;
        }

        if(!attacking) {
            switch (animationIndex) {
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

        if(invincible == true){
            if(invincibleCounter<5)
                invincibleCounter++;
            else{
                invincible = false;
                invincibleCounter = 0;
            }
        }

        if(animationIndex==4)
            attacking = false;

        Hero hero = refLink.GetHero();
        /// Hero is 2 tiles to the left AND 2 tiles to the top
        boolean playerNearby = false;
        int TileSize = Tile.TILE_HEIGHT;
        if(hero.x+hero.normalBounds.x+hero.normalBounds.width > x+normalBounds.x-TileSize*4 && hero.x+hero.normalBounds.x <= x+normalBounds.x && hero.y+hero.normalBounds.y+hero.normalBounds.height <= y+normalBounds.y+ normalBounds.height && hero.y+hero.normalBounds.y >= y+normalBounds.y-TileSize*4) {
            facingPos = 2;
            int xTile = (int)((x+bounds.x-speed)/25); // Dala Stanga
            int yTile1 = (int)((y+bounds.y)/25); // Dala Sus
            int yTile2 = (int)((y+bounds.y+ bounds.height)/25); // Dala Jos

            // Se verifica daca Dala din Stanga-Jos, respectiv Stanga-Sus au coliziune. In caz contrar, isi poate continua deplasarea
            if(!CheckCollision(xTile,yTile1) && !CheckCollision(xTile,yTile2) && !CheckCollision(xTile,(yTile1+yTile2)/2)){
                if(initialX-TileSize*8<x && hero.x + hero.normalBounds.x + hero.normalBounds.width <= x+normalBounds.x-TileSize*1) {
                    xMove = -speed;
                    //System.out.println("Hero close - left");
                }
                playerNearby = true;
            }
        }
        else {
            /// Hero is 2 tiles to the left AND 2 tiles to the bottom
            if (hero.x + hero.normalBounds.x + hero.normalBounds.width > x + normalBounds.x + normalBounds.width && hero.x + hero.normalBounds.x < x + normalBounds.x + normalBounds.width + TileSize*4 && hero.y + hero.normalBounds.y + hero.normalBounds.height <= y + normalBounds.y + normalBounds.height + TileSize * 4 && hero.y + hero.normalBounds.y >= y+ normalBounds.y-TileSize) {
                facingPos = 1;
                int xTile = (int)((x+bounds.x+bounds.width+speed)/25); // Dala Dreapta
                int yTile1 = (int)((y+bounds.y)/25); // Dala Sus
                int yTile2 = (int)((y+bounds.y+ bounds.height)/25); // Dala Jos

                // Se verifica daca Dala din Dreapta-Jos, respectiv Dreapta-Sus au coliziune. In caz contrar, eroul isi poate continua deplasarea
                if(!CheckCollision(xTile,yTile1) && !CheckCollision(xTile,yTile2) && !CheckCollision(xTile,(yTile1+yTile2)/2)){
                    if(initialX+TileSize*8>x && hero.x + hero.normalBounds.x <= x+normalBounds.x+ normalBounds.width+TileSize*1) {
                        //System.out.println("Hero close - right");
                        xMove = speed;
                    }
                    playerNearby = true;
                }
            } else {
                /// Eroul este la 2 dale distanta in partea de jos SI la 2 dale distanta in stanga
                if (hero.x+hero.normalBounds.x >= x+ normalBounds.x-TileSize*4 && hero.x+hero.normalBounds.x+hero.normalBounds.width <= x+normalBounds.x+ normalBounds.width && hero.y+hero.normalBounds.y+hero.normalBounds.height >= y+normalBounds.y+ normalBounds.height-TileSize && hero.y+hero.normalBounds.y <= y+ normalBounds.y+ normalBounds.height+TileSize*4) {
                    facingPos = 4;
                    int xTile1 = (int)((x+bounds.x)/25); // Dala Stanga
                    int xTile2 = (int)((x+bounds.x+bounds.width)/25); // Dala Dreapta
                    int yTile = (int)((y+bounds.y+ bounds.height+speed)/25); // Dala Jos

                    // Se verifica daca Dala din Stanga-Jos, respectiv Dreapta-Jos au coliziune. In caz contrar, eroul isi poate continua deplasarea
                    if(!CheckCollision(xTile1,yTile) && !CheckCollision(xTile2,yTile) && !CheckCollision((xTile1+xTile2)/2,yTile)){
                        if(initialY+TileSize*8>y && hero.y+hero.normalBounds.y <= y+normalBounds.y+ normalBounds.height+TileSize*1) {
                            //System.out.println("Hero close - down");
                            yMove = +speed;
                        }
                        playerNearby = true;
                    }
                } else {
                    // Eroul este la 2 dale distanta in partea de sus SI la 2 dale distanta in dreapta
                    if (hero.x+hero.normalBounds.x >= x+ normalBounds.x && hero.x+hero.normalBounds.x+hero.normalBounds.width <= x+ normalBounds.x+ normalBounds.width+TileSize*4 && hero.y+hero.normalBounds.y <= y+ normalBounds.y && hero.y+hero.normalBounds.y+hero.normalBounds.height >= y+ normalBounds.y-TileSize*4) {
                        facingPos = 3;
                        int xTile1 = (int)((x+bounds.x)/25);    // Dala Stanga
                        int xTile2 = (int)((x+bounds.x+bounds.width)/25); // Dala Dreapta
                        int yTile = (int)((y+bounds.y-speed)/25); // Dala Sus

                        // Se verifica daca Dala din Stanga-Sus, respectiv Dreapta-Sus au coliziune. In caz contrar, eroul isi poate continua deplasarea
                        if(!CheckCollision(xTile1,yTile) && !CheckCollision(xTile2,yTile) && !CheckCollision((xTile1+xTile2)/2,yTile)){
                            if(initialY-TileSize*8<y && y+normalBounds.y-TileSize*1 <= hero.y+hero.normalBounds.y+hero.normalBounds.height+TileSize*1) {
                                //System.out.println("Hero close - up");
                                yMove = -speed;

                            }
                            playerNearby = true;
                        }
                    }
                }
            }
        }
        if(!playerNearby) {
            if (x != initialX) {
                if (x > initialX) {
                    facingPos = 2;
                    int xTile = (int)((x+bounds.x-speed)/25); // Dala Stanga
                    int yTile1 = (int)((y+bounds.y)/25); // Dala Sus
                    int yTile2 = (int)((y+bounds.y+ bounds.height)/25); // Dala Jos
                    if(!CheckCollision(xTile,yTile1) && !CheckCollision(xTile,yTile2) && !CheckCollision(xTile,(yTile1+yTile2)/2))
                        xMove = -speed;
                    else
                        xMove = 0;
                }
                else {
                    facingPos = 1;
                    int xTile = (int)((x+bounds.x+bounds.width+speed)/25); // Dala Dreapta
                    int yTile1 = (int)((y+bounds.y)/25); // Dala Sus
                    int yTile2 = (int)((y+bounds.y+ bounds.height)/25); // Dala Jos

                    if(!CheckCollision(xTile,yTile1) && !CheckCollision(xTile,yTile2) && !CheckCollision(xTile,(yTile1+yTile2)/2))
                        xMove = speed;
                    else
                        xMove = 0;
                }
            } else xMove = 0;
            if (y != initialY) {
                if (y > initialY) {
                    facingPos = 3;
                    int xTile1 = (int)((x+bounds.x)/25);    // Dala Stanga
                    int xTile2 = (int)((x+bounds.x+bounds.width)/25); // Dala Dreapta
                    int yTile = (int)((y+bounds.y-speed)/25); // Dala Sus
                    if(!CheckCollision(xTile1,yTile) && !CheckCollision(xTile2,yTile) && !CheckCollision((xTile1+xTile2)/2,yTile))
                        yMove = -speed;
                    else
                        yMove = 0;
                } else {
                    facingPos = 4;
                    int xTile1 = (int)((x+bounds.x)/25);    // Dala Stanga
                    int xTile2 = (int)((x+bounds.x+bounds.width)/25); // Dala Dreapta
                    int yTile = (int)((y+bounds.y-speed)/25); // Dala Sus

                    if(!CheckCollision(xTile1,yTile) && !CheckCollision(xTile2,yTile) && !CheckCollision((xTile1+xTile2)/2,yTile))
                        yMove = speed;
                    else
                        yMove = 0;
                }
            } else
                yMove = 0;
        }
        else{
            if((x+normalBounds.x - hero.x+hero.normalBounds.x+hero.normalBounds.width <= TileSize*8)) {
                if (y + normalBounds.y + TileSize * 2 >= hero.y + hero.normalBounds.y && y + normalBounds.y + normalBounds.height - TileSize * 2 <= hero.y + hero.normalBounds.y + hero.normalBounds.height) {
                    AttackHero(hero, "left");
                }
            } else if (hero.x+hero.normalBounds.x - x+ normalBounds.x+ normalBounds.x <= TileSize*8) {
                if (y + normalBounds.y + TileSize * 2 >= hero.y + hero.normalBounds.y && y + normalBounds.y + normalBounds.height - TileSize * 2 <= hero.y + hero.normalBounds.y + hero.normalBounds.height)
                    AttackHero(hero,"right");
            } else if (hero.y+hero.normalBounds.y - y+ normalBounds.y+ normalBounds.height <= TileSize*8) {
                if(x+normalBounds.x+TileSize*2 >= hero.x+hero.normalBounds.x && x + normalBounds.x + normalBounds.width - TileSize*2 <= hero.x + hero.normalBounds.x + hero.normalBounds.width)
                    AttackHero(hero,"down");
            } else if (y+normalBounds.y - hero.y+hero.normalBounds.y+hero.normalBounds.height <= TileSize*8) {
                if(x+normalBounds.x+TileSize*2 >= hero.x+hero.normalBounds.x && x + normalBounds.x + normalBounds.width - TileSize*2 <= hero.x + hero.normalBounds.x + hero.normalBounds.width)
                    AttackHero(hero,"up");
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

        int screenX = (int)x - (int)refLink.GetHero().GetX() + (int)refLink.GetHero().GetScreenX();
        int screenY = (int)y - (int)refLink.GetHero().GetY() + (int)refLink.GetHero().GetScreenY();
        g.drawImage(image, screenX, screenY, width, height, null);

        if(life<maxLife) {

            double barScale = (double) (Tile.TILE_WIDTH * 2) / maxLife;
            double barValue = barScale * life;

            /// Bara - nivel de viata
            g.setColor(new Color(0, 0, 0));
            g.fillRect(screenX - 2, screenY - 17, Tile.TILE_WIDTH * 2 + 4, 14);

            g.setColor(new Color(255, 0, 30));
            g.fillRect(screenX, screenY - 15, (int) barValue, 10);

        }

        /// DEBUG - VIEW WALKING BOUNDS
        //g.setColor(Color.blue);
        //g.fillRect((int)(screenX + bounds.x), (int)(screenY + bounds.y), bounds.width, bounds.height);

        /// DEBUG - VIEW ATTACKING BOUNDS
        //g.setColor(Color.red);
        //g.fillRect((int)(screenX + attackBounds.x), (int)(screenY + attackBounds.y), attackBounds.width, attackBounds.height);
    }
}
