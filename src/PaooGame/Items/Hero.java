package PaooGame.Items;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import PaooGame.RefLinks;
import PaooGame.Graphics.Assets;
import PaooGame.States.PauseState;
import PaooGame.States.PlayState;
import PaooGame.States.State;
import PaooGame.Tiles.Tile;

/*! \class public class Hero extends Character
    \brief Implementeaza notiunea de erou/player (caracterul controlat de jucator).

    Elementele suplimentare pe care le aduce fata de clasa de baza sunt:
        imaginea (acest atribut poate fi ridicat si in clasa de baza)
        deplasarea
        atacul (nu este implementat momentan)
        dreptunghiul de coliziune
 */
public class Hero extends Character
{
    private BufferedImage image;    /*!< Referinta catre imaginea curenta a eroului.*/
    private float ScreenX;
    private float ScreenY;

    protected boolean hasKey = false;
    protected boolean openedChest = false;

    protected int armorLevel = 1;
    private int Score = 0;

    private int Kills = 0;


    private PauseState pauseState;

    /*! \fn public Hero(RefLinks refLink, float x, float y)
        \brief Constructorul de initializare al clasei Hero.

        \param refLink Referinta catre obiectul shortcut (obiect ce retine o serie de referinte din program).
        \param x Pozitia initiala pe axa X a eroului.
        \param y Pozitia initiala pe axa Y a eroului.
     */
    public Hero(RefLinks refLink, float x, float y)
    {
            ///Apel al constructorului clasei de baza
        super(refLink, x,y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT, 0);
            ///Seteaza imaginea de start a eroului
        //damage = 250;
        life = 200;
        maxLife = life;
        image = Assets.heroLeft1;
            ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea implicita(normala)
        normalBounds.x = 32;
        normalBounds.y = 50;
        normalBounds.width = 32;
        normalBounds.height = 32;

            ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea de atac
        attackBounds.x = 0;
        attackBounds.y = 10;
        attackBounds.width = 96;
        attackBounds.height = 72;

        ScreenX = refLink.GetWidth()/2 - 12;    /// Pozitia initiala a eroului -> mijlocul ferestrei de joc
        ScreenY = refLink.GetHeight()/2 - 12;
    }

    /*! \fn public void GetScreenX()
        \brief Returneaza pozitia pe axa X relativa a eroului fata de fereastra de joc
     */
    public float GetScreenX() {return ScreenX;}
    /*! \fn public void GetScreenY()
        \brief Returneaza pozitia pe axa Y relativa a eroului fata de fereastra de joc
     */
    public float GetScreenY() {return ScreenY;}

    /*! \fn public void Update()
        \brief Actualizeaza pozitia si imaginea eroului.
     */
    @Override
    public void Update()
    {
        /// Se verifica daca nivelul de viata a ajuns la 0 (daca jucatorul a pierdut jocul)
        if(life<=0){
            pauseState = (PauseState) refLink.GetGame().GetState(3);
            if(pauseState!=null)
                pauseState.SetMenu(2);
            State.SetState(refLink.GetGame().GetState(3));
        }


            ///Verifica daca a fost apasata o tasta
        GetInput();
            ///Actualizeaza pozitia
        Move();
            ///Actualizeaza imaginea
        /// Daca eroul nu se afla in stare de atac, se incarca animatiile de mers.
        /// In caz contrar, se incarca animatiile de atac.
        if(attacking == false){
                if(refLink.GetKeyManager().left == true)
                {
                    // Se utilizeaza imaginea respectiva indexului de animatie
                    switch(animationIndex){
                        case 1:
                            image = Assets.heroLeft1;
                            break;
                        case 2:
                            image = Assets.heroLeft2;
                            break;
                        case 3:
                            image = Assets.heroLeft3;
                            break;
                        case 4:
                            image = Assets.heroLeft4;
                            break;
                        case 5:
                            image = Assets.heroLeft5;
                            break;
                    }
                }
                if(refLink.GetKeyManager().right == true) {
                    // Se utilizeaza imaginea respectiva indexului de animatie
                    switch(animationIndex){
                        case 1:
                            image = Assets.heroRight1;
                            break;
                        case 2:
                            image = Assets.heroRight2;
                            break;
                        case 3:
                            image = Assets.heroRight3;
                            break;
                        case 4:
                            image = Assets.heroRight4;
                            break;
                        case 5:
                            image = Assets.heroRight5;
                            break;
                    }
                }
                if(refLink.GetKeyManager().up == true)
                {
                    // Se utilizeaza imaginea respectiva indexului de animatie
                    switch(animationIndex){
                        case 1:
                            image = Assets.heroUp1;
                            break;
                        case 2:
                            image = Assets.heroUp2;
                            break;
                        case 3:
                            image = Assets.heroUp3;
                            break;
                        case 4:
                            image = Assets.heroUp4;
                            break;
                        case 5:
                            image = Assets.heroUp5;
                            break;
                    }
                }
                if(refLink.GetKeyManager().down == true) {
                    // Se utilizeaza imaginea respectiva indexului de animatie
                    switch(animationIndex){
                        case 1:
                            image = Assets.heroDown1;
                            break;
                        case 2:
                            image = Assets.heroDown2;
                            break;
                        case 3:
                            image = Assets.heroDown3;
                            break;
                        case 4:
                            image = Assets.heroDown4;
                            break;
                        case 5:
                            image = Assets.heroDown5;
                            break;
                    }
                }
        }
        else {
            animationCounter++;
            // Daca contorul depaseste o valoare prestabilita (5), acesta se reseteaza si creste indexul de animatie
            if (animationCounter > 5) {
                animationCounter = 0;
                animationIndex++;
                // Daca indexul depaseste valoarea maxima de imagini pentru o animatie (5), acesta se reseteaza la valoarea 1.
                if (animationIndex > 5) {
                    animationIndex = 1;
                    refLink.PlaySound(1);
                }
            }

            /// In functie de directia eroului, se incarca animatiile de atac.
            switch (facingPos) {
                case 1:
                    switch (animationIndex) {
                        case 1:
                            image = Assets.heroRightAttack1;
                            break;
                        case 2:
                            image = Assets.heroRightAttack2;
                            break;
                        case 3:
                            image = Assets.heroRightAttack3;
                            break;
                        case 4:
                            image = Assets.heroRightAttack4;
                            break;
                        case 5:
                            image = Assets.heroRightAttack5;
                            attacking = false;
                            image = Assets.heroRight1;
                            break;
                    }
                    break;
                case 2:
                    switch (animationIndex) {
                        case 1:
                            image = Assets.heroLeftAttack1;
                            break;
                        case 2:
                            image = Assets.heroLeftAttack2;
                            break;
                        case 3:
                            image = Assets.heroLeftAttack3;
                            break;
                        case 4:
                            image = Assets.heroLeftAttack4;
                            break;
                        case 5:
                            image = Assets.heroLeftAttack5;
                            attacking = false;
                            image = Assets.heroLeft1;
                            break;
                    }
                    break;
                case 3:
                    switch (animationIndex) {
                        case 1:
                            image = Assets.heroUpAttack1;
                            break;
                        case 2:
                            image = Assets.heroUpAttack2;
                            break;
                        case 3:
                            image = Assets.heroUpAttack3;
                            break;
                        case 4:
                            image = Assets.heroUpAttack4;
                            break;
                        case 5:
                            image = Assets.heroUpAttack5;
                            attacking = false;
                            image = Assets.heroUp1;
                            break;
                    }
                    break;
                case 4:
                    switch (animationIndex) {
                        case 1:
                            image = Assets.heroDownAttack1;
                            break;
                        case 2:
                            image = Assets.heroDownAttack2;
                            break;
                        case 3:
                            image = Assets.heroDownAttack3;
                            break;
                        case 4:
                            image = Assets.heroDownAttack4;
                            break;
                        case 5:
                            image = Assets.heroDownAttack5;
                            attacking = false;
                            image = Assets.heroDown1;
                            break;
                    }
                    break;
            }

        }


        /// Verificam daca jucatorul a ajuns in punctul de trecere dintre niveluri si setam noul nivel in caz pozitiv
        int xTile,yTile;
        xTile = (int)((x+bounds.x)/25);
        yTile = (int)((y+bounds.y)/25);
        PlayState playState = (PlayState) refLink.GetGame().GetState(1);
        switch (playState.GetLevel()){
            case 1:
                if(xTile == 58 && (yTile >= 13 && yTile <= 14)) {
                    playState.SetLevel(2);
                    x = 16;
                    y = 214;
                }
                break;
            case 2:
                if((xTile == 46 || xTile == 45) && yTile == 0) {
                    playState.SetLevel(3);
                    x = 1120;
                    y = 742;
                }
                break;
        }
    }

    /// Un caracter este atacat de catre erou
    /// Se scade nivelul de viata a inamicului pana ajunge 0, caz in care acesta este distrus
    private boolean AttackCharacter(Character character) {
            if (character.invincible == false) {
                character.invincible = true;
                attackingCounter = 0;
                if (GetDamage() >= character.GetLife()) {
                    character.SetLife(0);
                    Score += character.characterPoints;
                    Kills +=1;
                    if(character.boss){
                        pauseState = (PauseState) refLink.GetGame().GetState(3);
                        if(pauseState!=null)
                            pauseState.SetMenu(3);
                        State.SetState(refLink.GetGame().GetState(3));
                    }
                    refLink.RemoveItem(character);
                    return true;
                } else {
                    //System.out.println("Attack!");
                    character.SetLife(character.GetLife() - GetDamage());
                    return false;
                }
            }
        return false;


    }


    /// Se verifica daca dalele xTile si yTile sunt solide si daca exista vreun inamic pe directia eroului
    boolean CheckCollision(int xTile, int yTile){
        if(CheckIfInsideMap(xTile,yTile) && !refLink.GetMap().GetTile(xTile,yTile).IsSolid() &&
                (refLink.GetMap().GetObject(xTile,yTile) == null || !refLink.GetMap().GetObject(xTile,yTile).IsSolid())) {
            ArrayList<Item> items = refLink.GetItems();
            /*if(refLink.GetChest()!=null)
                items.add(refLink.GetChest());*/
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

    /*! \fn private void GetInput()
        \brief Verifica daca a fost apasata o tasta din cele stabilite pentru controlul eroului.
     */
    private void GetInput()
    {
            ///Implicit eroul nu trebuie sa se deplaseze daca nu este apasata o tasta
        xMove = 0;
        yMove = 0;
        // Nu este permisa deplasarea pe diagonala
        if(refLink.GetKeyManager().up)  ///Verificare apasare tasta "sus"
        {
            facingPos = 3;
            int xTile1 = (int)((x+bounds.x)/25);    // Dala Stanga
            int xTile2 = (int)((x+bounds.x+bounds.width)/25); // Dala Dreapta
            int yTile = (int)((y+bounds.y-speed)/25); // Dala Sus

            // Se verifica daca Dala din Stanga-Sus, respectiv Dreapta-Sus au coliziune. In caz contrar, eroul isi poate continua deplasarea
            if(!CheckCollision(xTile1,yTile) && !CheckCollision(xTile2,yTile) && !CheckCollision((xTile1+xTile2)/2,yTile))
                yMove = -speed;

            /// OLD COLLISION DETECTION
            /*if (!refLink.GetMap().GetTile((int)(((x+32)/25)),(int)((y-speed)/25)+2).IsSolid() &&
                    (refLink.GetMap().GetObject((int)(((x+32)/25)),(int)((y-speed)/25)+2) == null || !refLink.GetMap().GetObject((int)(((x+32)/25)),(int)((y-speed)/25)+2).IsSolid())) {
                System.out.println("X: "+x+" Y: "+y);
                System.out.println("UP: X"+(int)(((x+32)/25))+"  Y: "+(int)(((y-speed)/25)+2));
                yMove = -speed;
            }*/

            /// DEBUG - VIEW TILES
            /*
            System.out.println("X: "+(x+bounds.x+bounds.width)+ "  Tile1: "+xTile1+"  Tile2: "+xTile2);
            System.out.println("Y: "+(y+bounds.y-speed)+ "  Tile: "+yTile);
            */

        } else if (refLink.GetKeyManager().down) {  ///Verificare apasare tasta "jos"
            facingPos = 4;
            int xTile1 = (int)((x+bounds.x)/25); // Dala Stanga
            int xTile2 = (int)((x+bounds.x+bounds.width)/25); // Dala Dreapta
            int yTile = (int)((y+bounds.y+ bounds.height+speed)/25); // Dala Jos

            // Se verifica daca Dala din Stanga-Jos, respectiv Dreapta-Jos au coliziune. In caz contrar, eroul isi poate continua deplasarea
            if(!CheckCollision(xTile1,yTile) && !CheckCollision(xTile2,yTile) && !CheckCollision((xTile1+xTile2)/2,yTile))
                yMove = speed;

            /// OLD COLLISION DETECTION
            /*if (!refLink.GetMap().GetTile((int)(((x+32)/25)),(int)((y+speed)/25)+3).IsSolid() &&
                    (refLink.GetMap().GetObject((int)(((x+32)/25)),(int)((y+speed)/25)+3) == null || !refLink.GetMap().GetObject((int)(((x+32)/25)),(int)((y+speed)/25)+3).IsSolid())) {
                System.out.println("DOWN: X"+(int)(((x+32)/25))+"  Y: "+(int)(((y+speed)/25)+3));
                yMove = speed;
            }*/

            /// DEBUG - VIEW TILES
            /*
            System.out.println("X: "+(x+bounds.x+bounds.width)+ "  Tile1: "+xTile1+"  Tile2: "+xTile2);
            System.out.println("Y: "+(y+bounds.y+bounds.height+speed)+ "  Tile: "+yTile);
             */

        } else if (refLink.GetKeyManager().left) {  ///Verificare apasare tasta "stanga"
            facingPos = 2;
            int xTile = (int)((x+bounds.x-speed)/25); // Dala Stanga
            int yTile1 = (int)((y+bounds.y)/25); // Dala Sus
            int yTile2 = (int)((y+bounds.y+ bounds.height)/25); // Dala Jos

            // Se verifica daca Dala din Stanga-Jos, respectiv Stanga-Sus au coliziune. In caz contrar, eroul isi poate continua deplasarea
            if(!CheckCollision(xTile,yTile1) && !CheckCollision(xTile,yTile2) && !CheckCollision(xTile,(yTile1+yTile2)/2))
                xMove = -speed;

            /// OLD COLLISION DETECTION
            /*if (!refLink.GetMap().GetTile((int)((x/25)-speed+4),(int)((y)/25)+3).IsSolid() &&
                    (refLink.GetMap().GetObject((int)((x/25)-speed+4),(int)((y)/25)+3) == null || !refLink.GetMap().GetObject((int)((x/25)-speed+4),(int)((y)/25)+3).IsSolid())) {
                System.out.println("LEFT: X"+(int)((x/25)-speed+4)+"  Y: "+(int)(((y)/25)+3));
                xMove = -speed;
            }*/

            /// DEBUG - VIEW TILES
            /*
            System.out.println("X: "+(x+bounds.x-speed)+ "  Tile: "+xTile);
            System.out.println("Y: "+(y+bounds.y+bounds.height)+ "  Tile1: "+yTile1+"  Tile2: "+yTile2);
            */

        } else if (refLink.GetKeyManager().right) {  ///Verificare apasare tasta "dreapta"
            facingPos = 1;
            int xTile = (int)((x+bounds.x+bounds.width+speed)/25); // Dala Dreapta
            int yTile1 = (int)((y+bounds.y)/25); // Dala Sus
            int yTile2 = (int)((y+bounds.y+ bounds.height)/25); // Dala Jos

            // Se verifica daca Dala din Dreapta-Jos, respectiv Dreapta-Sus au coliziune. In caz contrar, eroul isi poate continua deplasarea
            if(!CheckCollision(xTile,yTile1) && !CheckCollision(xTile,yTile2) && !CheckCollision(xTile,(yTile1+yTile2)/2))
                xMove = speed;

            /// OLD COLLISION DETECTION
            /*System.out.println("X: "+(x+bounds.x+bounds.width));
            if (!refLink.GetMap().GetTile((int)((x/25)+speed),(int)((y)/25)+3).IsSolid() &&
                    (refLink.GetMap().GetObject((int)(((x+bounds.x+bounds.width)/25)+speed),(int)((y)/25)+3) == null || !refLink.GetMap().GetObject((int)(((x+bounds.x+bounds.width)/25)+speed),(int)((y)/25)+3).IsSolid())) {
                System.out.println("RIGHT: X"+(int)((x/25)+speed)+"  Y: "+(int)(((y/25)+3)));
                xMove = speed;
            }*/

            /// DEBUG - VIEW TILES
            /*
            System.out.println("X: "+(x+bounds.x+bounds.width+speed)+ "  Tile: "+xTile);
            System.out.println("Y: "+(y+bounds.y+bounds.height)+ "  Tile1: "+yTile1+"  Tile2: "+yTile2);
            */
        } else if (refLink.GetKeyManager().space) {  ///Verificare apasare tasta "space"
            if (attacking == false){
                attacking = true;
                boolean removed = false;
                for (Item character : refLink.GetItems()) {
                    switch (facingPos) {
                        case 1:
                            if (x + attackBounds.x + attackBounds.width >= character.x + character.attackBounds.x && x + attackBounds.x + attackBounds.width <= character.x + character.attackBounds.x + character.attackBounds.width && y + attackBounds.y <= character.y + character.attackBounds.y + Tile.TILE_HEIGHT && y + attackBounds.y + attackBounds.height >= character.y + character.attackBounds.y + character.attackBounds.height - Tile.TILE_HEIGHT)
                                //System.out.println("HIT! 1");
                                if (AttackCharacter((Character) character))
                                    removed = true;
                            break;
                        case 2:
                            if (x + attackBounds.x + attackBounds.width >= character.x + character.attackBounds.x && x + attackBounds.x <= character.x + character.attackBounds.x + character.attackBounds.width && x + attackBounds.x >= character.x + character.attackBounds.x && y + attackBounds.y <= character.y + character.attackBounds.y+Tile.TILE_HEIGHT && y + attackBounds.y + attackBounds.height >= character.y + character.attackBounds.y + character.attackBounds.height - Tile.TILE_HEIGHT)
                                //System.out.println("HIT! 2");
                                if (AttackCharacter((Character) character))
                                    removed = true;
                            break;
                        case 3:
                            if (x + attackBounds.x + attackBounds.width >= character.x + character.attackBounds.x + character.attackBounds.width - Tile.TILE_WIDTH && x + attackBounds.x <= character.x + character.attackBounds.x + Tile.TILE_WIDTH && y + attackBounds.y <= character.y + character.attackBounds.y + character.attackBounds.height && y + attackBounds.y >= character.y + character.attackBounds.y)
                                //System.out.println("HIT! 3");
                                if (AttackCharacter((Character) character))
                                    removed = true;
                            break;
                        case 4:
                            if (x + attackBounds.x + attackBounds.width >= character.x + character.attackBounds.x + character.attackBounds.width - Tile.TILE_WIDTH && x + attackBounds.x <= character.x + character.attackBounds.x + Tile.TILE_WIDTH && y + attackBounds.y + attackBounds.height >= character.y + character.attackBounds.y && y + attackBounds.y + attackBounds.height <= character.y + character.attackBounds.y + character.attackBounds.height)
                                //System.out.println("HIT! 4");
                                if (AttackCharacter((Character) character))
                                    removed = true;
                            break;
                    }
                    if (removed)
                        break;

                    }
                }
            } else if (refLink.GetKeyManager().escape) {
                State.SetState(refLink.GetGame().GetState(3));
            } else if (refLink.GetKeyManager().f) {
                Chest chest = refLink.GetChest();
                int TileSize = Tile.TILE_HEIGHT;
                if(chest!=null){
                    if((x+normalBounds.x - (chest.x+chest.normalBounds.x+chest.normalBounds.width) <= TileSize*2) && (x+normalBounds.x - (chest.x+chest.normalBounds.x+chest.normalBounds.width)>0)) {
                        if (y + normalBounds.y + TileSize * 2 >= chest.y + chest.normalBounds.y && y + normalBounds.y + normalBounds.height - TileSize * 2 <= chest.y + chest.normalBounds.y + chest.normalBounds.height)
                            chest.Open();
                    } else if (chest.x+chest.normalBounds.x - (x+ normalBounds.x+ normalBounds.x) <= TileSize*2 && chest.x+chest.normalBounds.x - (x+ normalBounds.x+ normalBounds.x)>0) {
                        if (y + normalBounds.y + TileSize * 2 >= chest.y + chest.normalBounds.y && y + normalBounds.y + normalBounds.height - TileSize * 2 <= chest.y + chest.normalBounds.y + chest.normalBounds.height)
                            chest.Open();
                    } else if (chest.y+chest.normalBounds.y - (y+ normalBounds.y+ normalBounds.height) <= TileSize*4 && chest.y+chest.normalBounds.y - (y+ normalBounds.y+ normalBounds.height)>0) {
                        if(x+normalBounds.x+TileSize*2 >= chest.x+chest.normalBounds.x && x + normalBounds.x + normalBounds.width - TileSize*2 <= chest.x + chest.normalBounds.x + chest.normalBounds.width) {
                            chest.Open();
                        }
                    } else if (y+normalBounds.y - (chest.y+chest.normalBounds.y+chest.normalBounds.height) <= TileSize*2 && y+normalBounds.y - (chest.y+chest.normalBounds.y+chest.normalBounds.height)>0) {
                        if(x+normalBounds.x+TileSize*2 >= chest.x+chest.normalBounds.x && x + normalBounds.x + normalBounds.width - TileSize*2 <= chest.x + chest.normalBounds.x + chest.normalBounds.width)
                            chest.Open();
                    }
                }

                Key key = refLink.GetKey();
                if(key!=null && !hasKey){
                    if((x+normalBounds.x - (key.x+key.normalBounds.x+key.normalBounds.width) <= TileSize*2) && (x+normalBounds.x - (key.x+key.normalBounds.x+key.normalBounds.width)>0)) {
                        if (y + normalBounds.y + TileSize * 2 >= key.y + key.normalBounds.y && y + normalBounds.y + normalBounds.height - TileSize * 2 <= key.y + key.normalBounds.y + key.normalBounds.height)
                            key.PickUp();
                    } else if (key.x+key.normalBounds.x - (x+ normalBounds.x+ normalBounds.x) <= TileSize*2 && key.x+key.normalBounds.x - (x+ normalBounds.x+ normalBounds.x)>0) {
                        if (y + normalBounds.y + TileSize * 2 >= key.y + key.normalBounds.y && y + normalBounds.y + normalBounds.height - TileSize * 2 <= key.y + key.normalBounds.y + key.normalBounds.height)
                            key.PickUp();
                    } else if (key.y+key.normalBounds.y - (y+ normalBounds.y+ normalBounds.height) <= TileSize*2 && key.y+key.normalBounds.y - (y+ normalBounds.y+ normalBounds.height)>0) {
                        if(x+normalBounds.x+TileSize*2 >= key.x+key.normalBounds.x && x + normalBounds.x + normalBounds.width - TileSize*2 <= key.x + key.normalBounds.x + key.normalBounds.width)
                            key.PickUp();
                    } else if (y+normalBounds.y - (key.y+key.normalBounds.y+key.normalBounds.height) <= TileSize*2 && y+normalBounds.y - (key.y+key.normalBounds.y+key.normalBounds.height)>0) {
                        if(x+normalBounds.x+TileSize*2 >= key.x+key.normalBounds.x && x + normalBounds.x + normalBounds.width - TileSize*2 <= key.x + key.normalBounds.x + key.normalBounds.width)
                            key.PickUp();
                    }
                }
        }


        // Se incrementeaza contorul la fiecare apasare a unei taste
        if(attacking == false)
            animationCounter++;
        // Daca contorul depaseste o valoare prestabilita (5), acesta se reseteaza si creste indexul de animatie
            if(animationCounter>5){
                animationCounter=0;
                animationIndex++;
                // Daca indexul depaseste valoarea maxima de imagini pentru o animatie (5), acesta se reseteaza la valoarea 1.
                    if(animationIndex>5)
                        animationIndex=1;
            }
    }

    public int GetScore(){
        return Score;
    }

    public void SetScore(int Score){
        this.Score = Score;
    }

    public int GetArmorLevel(){
        return armorLevel;
    }

    public void SetArmorLevel(int ArmorLevel){
        this.armorLevel = ArmorLevel;
    }

    public int GetKills(){
        return Kills;
    }

    public void SetKills(int Kills){
        this.Kills = Kills;
    }

    public boolean HasKey(){
        return hasKey;
    }

    public boolean HasOpenedChest(){
        return openedChest;
    }

    public void SetKey(boolean value){
        this.hasKey = value;
    }

    /*! \fn public void Draw(Graphics g)
        \brief Randeaza/deseneaza eroul in noua pozitie.

        \brief g Contextul grafi in care trebuie efectuata desenarea eroului.
     */
    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(image, (int)ScreenX, (int)ScreenY, width, height, null);

        double barScale = (double) (Tile.TILE_WIDTH * 6) / maxLife;
        double barValue = barScale * life;

        /// Bara
        g.setColor(new Color(35,35,35,200));
        g.fillRect(0,0,refLink.GetWidth(),64);

        /// Bara - nivel de viata
        g.setColor(new Color(0, 0, 0));
        g.fillRect(46, 20, Tile.TILE_WIDTH * 6 + 4, 24);

        g.setColor(new Color(255, 0, 30));
        g.fillRect(48, 22, (int) barValue, 20);

        g.drawImage(Assets.lifeIcon,8,16,null);

        /// Armor Level

        g.drawImage(Assets.armorIcon,215,16,null);

        g.setColor(new Color(0, 0, 0));
        g.fillRect(250, 20, Tile.TILE_WIDTH * 3 + 4, 24);

        g.setColor(new Color(255,255,255));
        g.setFont(new Font("Impact", Font.PLAIN, 18));
        g.drawString(String.valueOf(armorLevel),280,38);

        /// Score

        g.setColor(new Color(255,255,255));
        g.setFont(new Font("Impact", Font.PLAIN, 40));
        g.drawString(String.valueOf(Score),450,50);

        /// Kills

        g.setColor(new Color(0, 0, 0));
        g.fillRect(675, 20, Tile.TILE_WIDTH * 3 + 4, 24);

        g.drawImage(Assets.killsIcon,650,16,null);

        g.setColor(new Color(255,255,255));
        g.setFont(new Font("Impact", Font.PLAIN, 18));
        g.drawString(String.valueOf(Kills),700,38);

        /// Kills

        g.setColor(new Color(0, 0, 0));
        g.fillRect(800, 20, Tile.TILE_WIDTH * 3 + 4, 24);

        g.drawImage(Assets.damageIcon,875,16,null);

        g.setColor(new Color(255,255,255));
        g.setFont(new Font("Impact", Font.PLAIN, 18));
        g.drawString(String.valueOf(damage),825,38);

        /// DEBUG - VIEW HERO WALKING BOUNDS
        //g.setColor(Color.blue);
        //g.fillRect((int)(ScreenX + bounds.x), (int)(ScreenY + bounds.y), bounds.width, bounds.height);

        /// DEBUG - VIEW ATTACK BOUNDS
        //g.setColor(Color.magenta);
        //g.fillRect((int)(ScreenX + attackBounds.x), (int)(ScreenY + attackBounds.y), attackBounds.width, attackBounds.height);
    }
}
