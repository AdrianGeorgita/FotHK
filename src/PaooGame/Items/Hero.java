package PaooGame.Items;

import java.awt.*;
import java.awt.image.BufferedImage;

import PaooGame.RefLinks;
import PaooGame.Graphics.Assets;

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

    /*! \fn public Hero(RefLinks refLink, float x, float y)
        \brief Constructorul de initializare al clasei Hero.

        \param refLink Referinta catre obiectul shortcut (obiect ce retine o serie de referinte din program).
        \param x Pozitia initiala pe axa X a eroului.
        \param y Pozitia initiala pe axa Y a eroului.
     */
    public Hero(RefLinks refLink, float x, float y)
    {
            ///Apel al constructorului clasei de baza
        super(refLink, x,y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);
            ///Seteaza imaginea de start a eroului
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
        else{
            animationCounter++;
            // Daca contorul depaseste o valoare prestabilita (5), acesta se reseteaza si creste indexul de animatie
            if(animationCounter>5){
                animationCounter=0;
                animationIndex++;
                // Daca indexul depaseste valoarea maxima de imagini pentru o animatie (5), acesta se reseteaza la valoarea 1.
                if(animationIndex>5)
                    animationIndex=1;
            }

            /// In functie de directia eroului, se incarca animatiile de atac.
            switch(facingPos){
                case 1:
                    switch(animationIndex){
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
                    switch(animationIndex){
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
                    switch(animationIndex){
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
                    switch(animationIndex){
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
    }

    // Se verifica daca dalele xTile si yTile se afla in interiorul hartii
    private boolean CheckIfInsideMap(int xTile,int yTile){
        if(xTile >= 0 && xTile <= 59 && yTile >= 0 && yTile <= 32)
            return true;
        return false;
    }

    /// Se verifica daca dalele xTile si yTile sunt solide si daca exista vreun inamic pe directia eroului
    boolean CheckCollision(int xTile, int yTile){
        if(CheckIfInsideMap(xTile,yTile) && !refLink.GetMap().GetTile(xTile,yTile).IsSolid() &&
                (refLink.GetMap().GetObject(xTile,yTile) == null || !refLink.GetMap().GetObject(xTile,yTile).IsSolid())) {
            for(Item item:refLink.GetItems())
                switch (facingPos){
                    case 1:
                        if(x+bounds.x+ bounds.width >= item.x+item.bounds.x && x+ bounds.x <= item.x+item.bounds.x+item.bounds.width && y+bounds.y-12 <= item.y+item.bounds.y && y+ bounds.y+24+ bounds.height >= item.y+item.bounds.y+item.bounds.height)
                            return true;
                        break;
                    case 2:
                        if(x+bounds.x+ bounds.width >= item.x+item.bounds.x && x+ bounds.x <= item.x+item.bounds.x+item.bounds.width && x+bounds.x >= item.x+item.bounds.x && y+bounds.y-12 <= item.y+item.bounds.y && y+ bounds.y+24+ bounds.height >= item.y+item.bounds.y+item.bounds.height)
                            return true;
                        break;
                    case 3:
                        /// DEBUG - PRINT COORDINATES
                        /*System.out.println("X1: "+(x+bounds.x+ bounds.width)+" >  X2: "+(item.x+item.bounds.x));
                        System.out.println("X3: "+(x+ bounds.x)+" <  X4: "+(item.x+item.bounds.x+item.bounds.width));
                        System.out.println("Y1: "+(y+bounds.y)+" <  Y2: "+(item.y+item.bounds.y));
                        System.out.println("Y3: "+(y+ bounds.y+ bounds.height)+" >  Y4: "+(item.y+item.bounds.y+item.bounds.height));
                        */
                        if(x+bounds.x+ bounds.width >= item.x+item.bounds.x && x+ bounds.x <= item.x+item.bounds.x+item.bounds.width && y+bounds.y-12 <= item.y + item.bounds.y + item.bounds.height && y+bounds.y >= item.y + item.bounds.y)
                            return true;
                        break;
                    case 4:
                        if(x+bounds.x+ bounds.width >= item.x+item.bounds.x && x+ bounds.x <= item.x+item.bounds.x+item.bounds.width && y+bounds.y+ bounds.height+24 >= item.y+item.bounds.y && y+bounds.y+ bounds.height <= item.y+item.bounds.y+item.bounds.height)
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
            attacking = true;
            boolean removed = false;
            for (Item item:refLink.GetItems()){
                switch (facingPos){
                    case 1:
                        if(x+attackBounds.x+ attackBounds.width >= item.x+item.attackBounds.x && x+ attackBounds.x+ attackBounds.width <= item.x+item.attackBounds.x+item.attackBounds.width && y+attackBounds.y <= item.y+item.attackBounds.y && y+ attackBounds.y+ attackBounds.height >= item.y+item.attackBounds.y+item.attackBounds.height)
                            //System.out.println("HIT! 1");
                            {refLink.RemoveItem(item);
                            removed = true;}
                        break;
                    case 2:
                        if(x+attackBounds.x+ attackBounds.width >= item.x+item.attackBounds.x && x+ attackBounds.x <= item.x+item.attackBounds.x+item.attackBounds.width && x+attackBounds.x >= item.x+item.attackBounds.x && y+attackBounds.y <= item.y+item.attackBounds.y && y+ attackBounds.y+ attackBounds.height >= item.y+item.attackBounds.y+item.attackBounds.height)
                            //System.out.println("HIT! 2");
                        {refLink.RemoveItem(item);
                            removed = true;}
                        break;
                    case 3:
                        if(x+attackBounds.x+ attackBounds.width >= item.x+item.attackBounds.x+item.attackBounds.width && x+ attackBounds.x <= item.x+item.attackBounds.x && y+attackBounds.y <= item.y + item.attackBounds.y + item.attackBounds.height && y+attackBounds.y >= item.y + item.attackBounds.y)
                            //System.out.println("HIT! 3");
                        {refLink.RemoveItem(item);
                            removed = true;}
                        break;
                    case 4:
                        if(x+attackBounds.x+ attackBounds.width >= item.x+item.attackBounds.x+item.attackBounds.width && x+ attackBounds.x <= item.x+item.attackBounds.x && y+attackBounds.y+ attackBounds.height >= item.y+item.attackBounds.y && y+attackBounds.y+ attackBounds.height <= item.y+item.attackBounds.y+item.attackBounds.height)
                            //System.out.println("HIT! 4");
                        {refLink.RemoveItem(item);
                            removed = true;}
                        break;
                }
                if(removed)
                    break;

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

    /*! \fn public void Draw(Graphics g)
        \brief Randeaza/deseneaza eroul in noua pozitie.

        \brief g Contextul grafi in care trebuie efectuata desenarea eroului.
     */
    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(image, (int)ScreenX, (int)ScreenY, width, height, null);

        /// DEBUG - VIEW HERO WALKING BOUNDS
        //g.setColor(Color.blue);
        //g.fillRect((int)(ScreenX + bounds.x), (int)(ScreenY + bounds.y), bounds.width, bounds.height);

        /// DEBUG - VIEW ATTACK BOUNDS
        //g.setColor(Color.magenta);
        //g.fillRect((int)(ScreenX + attackBounds.x), (int)(ScreenY + attackBounds.y), attackBounds.width, attackBounds.height);
    }
}
