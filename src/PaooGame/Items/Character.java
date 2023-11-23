package PaooGame.Items;

import PaooGame.RefLinks;

/*! \class public abstract class Character extends Item
    \brief Defineste notiunea abstracta de caracter/individ/fiinta din joc.

    Notiunea este definita doar de viata, viteza de deplasare si distanta cu care trebuie sa se
    miste/deplaseze in urma calculelor.
 */
public abstract class Character extends Item
{
    public static final int DEFAULT_LIFE            = 10;   /*!< Valoarea implicita a vietii unui caracter.*/

    public static final int DEFAULT_DAMAGE           = 10;   /*!< Valoarea implicita a daunei cauzate de un caracter.*/
    public static final float DEFAULT_SPEED         = 3.0f; /*!< Viteza implicita a unu caracter.*/
    public static final int DEFAULT_CREATURE_WIDTH  = 96;   /*!< Latimea implicita a imaginii caracterului.*/
    public static final int DEFAULT_CREATURE_HEIGHT = 96;   /*!< Inaltimea implicita a imaginii caracterului.*/

    public static final int DEFAULT_POINTS = 100;   /*!< Punctele obtinute implicit atunci cand caracterul este invins.*/

    protected int life;     /*!< Retine viata caracterului.*/
    protected  int maxLife;

    protected int damage; /*!< Retine dauna pe care o cauzeaza caracterul.*/

    protected float speed;  /*!< Retine viteza de deplasare caracterului.*/
    protected float xMove;  /*!< Retine noua pozitie a caracterului pe axa X.*/
    protected float yMove;  /*!< Retine noua pozitie a caracterului pe axa Y.*/

    protected float initialX;
    protected float initialY;

    protected boolean attacking = false;

    protected boolean invincible = false;

    protected boolean boss = false;

    protected int characterPoints;

    protected int invincibleCounter = 0;
    protected int attackingCounter = 0;

    protected int animationIndex = 1;   /// Retine index-ul animatiei caracterului
    protected int animationCounter = 0; /// Se foloseste pentru a incetini rata de redesenare a animatiilor

    /*! \fn public Character(RefLinks refLink, float x, float y, int width, int height)
        \brief Constructor de initializare al clasei Character

        \param refLink Referinta catre obiectul shortcut (care retine alte referinte utile/necesare in joc).
        \param x Pozitia de start pa axa X a caracterului.
        \param y Pozitia de start pa axa Y a caracterului.
        \param width Latimea imaginii caracterului.
        \param height Inaltimea imaginii caracterului.
     */
    public Character(RefLinks refLink, float x, float y, int width, int height, int id)
    {
            ///Apel constructor la clasei de baza
        super(refLink, x,y, width, height);
            //Seteaza pe valorile implicite pentru viata, viteza si distantele de deplasare
        this.id = id;
        characterPoints = DEFAULT_POINTS;
        life    = DEFAULT_LIFE;
        maxLife = life;
        speed   = DEFAULT_SPEED;
        damage = DEFAULT_DAMAGE;
        xMove   = 0;
        yMove   = 0;
    }

    // Se verifica daca dalele xTile si yTile se afla in interiorul hartii
    public boolean CheckIfInsideMap(int xTile,int yTile){
        if(xTile >= 0 && xTile <= 59 && yTile >= 0 && yTile <= 32)
            return true;
        return false;
    }

    /*! \fn public void Move()
        \brief Modifica pozitia caracterului
     */
    public void Move()
    {
            ///Modifica pozitia caracterului pe axa X.
            ///Modifica pozitia caracterului pe axa Y.
        MoveX();
        MoveY();
    }

    /*! \fn public void MoveX()
        \brief Modifica pozitia caracterului pe axa X.
     */
    public void MoveX()
    {
            ///Aduna la pozitia curenta numarul de pixeli cu care trebuie sa se deplaseze pe axa X.
        x += xMove;
    }

    /*! \fn public void MoveY()
        \brief Modifica pozitia caracterului pe axa Y.
     */
    public void MoveY()
    {
            ///Aduna la pozitia curenta numarul de pixeli cu care trebuie sa se deplaseze pe axa Y.
        y += yMove;
    }


    /*! \fn public int GetDamage()
        \brief Returneaza dauna cauzata de caracter.
     */
    public int GetDamage()
    {
        return damage;
    }

    /*! \fn public int GetLife()
        \brief Returneaza viata caracterului.
     */

    /*! \fn public void SetDamage(int damage)
        \brief Seteaza dauna cauzata de caracter.
     */
    public void SetDamage(int damage)
    {
        this.damage = damage;
    }

    public int GetLife()
    {
        return life;
    }

    /*! \fn public int GetSpeed()
        \brief Returneaza viteza caracterului.
     */
    public float GetSpeed()
    {
        return speed;
    }

    /*! \fn public void SetLife(int life)
        \brief Seteaza viata caracterului.
     */
    public void SetLife(int life)
    {
        this.life = life;
    }

    /*! \fn public void SetSpeed(float speed)
        \brief
     */
    public void SetSpeed(float speed) {
        this.speed = speed;
    }

    /*! \fn public float GetXMove()
        \brief Returneaza distanta in pixeli pe axa X cu care este actualizata pozitia caracterului.
     */
    public float GetXMove()
    {
        return xMove;
    }

    /*! \fn public float GetYMove()
        \brief Returneaza distanta in pixeli pe axa Y cu care este actualizata pozitia caracterului.
     */
    public float GetYMove()
    {
        return yMove;
    }

    /*! \fn public void SetXMove(float xMove)
        \brief Seteaza distanta in pixeli pe axa X cu care va fi actualizata pozitia caracterului.
     */
    public void SetXMove(float xMove)
    {
        this.xMove = xMove;
    }

    /*! \fn public void SetYMove(float yMove)
        \brief Seteaza distanta in pixeli pe axa Y cu care va fi actualizata pozitia caracterului.
     */
    public void SetYMove(float yMove)
    {
        this.yMove = yMove;
    }
}

