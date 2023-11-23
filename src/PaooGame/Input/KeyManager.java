package PaooGame.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*! \class public class KeyManager implements KeyListener
    \brief Gestioneaza intrarea (input-ul) de tastatura.

    Clasa citeste daca au fost apasata o tasta, stabiliteste ce tasta a fost actionata si seteaza corespunzator un flag.
    In program trebuie sa se tina cont de flagul aferent tastei de interes. Daca flagul respectiv este true inseamna
    ca tasta respectiva a fost apasata si false nu a fost apasata.
 */
public class KeyManager implements KeyListener
{
    private boolean[] keys; /*!< Vector de flaguri pentru toate tastele. Tastele vor fi regasite dupa cod [0 - 255]*/
    public boolean up;      /*!< Flag pentru tasta "sus" apasata.*/
    public boolean down;    /*!< Flag pentru tasta "jos" apasata.*/
    public boolean left;    /*!< Flag pentru tasta "stanga" apasata.*/
    public boolean right;   /*!< Flag pentru tasta "dreapta" apasata.*/

    public boolean space; /*!< Flag pentru tasta "space" apasata.*/

    public boolean enter; /*!< Flag pentru tasta "enter" apasata.*/

    public boolean backspace; /*!< Flag pentru tasta "backspace" apasata.*/

    public boolean q; /*!< Flag pentru tasta "q" apasata.*/

    public boolean e; /*!< Flag pentru tasta "e" apasata.*/
    public boolean r; /*!< Flag pentru tasta "r" apasata.*/
    public boolean t; /*!< Flag pentru tasta "t" apasata.*/
    public boolean y; /*!< Flag pentru tasta "y" apasata.*/
    public boolean u; /*!< Flag pentru tasta "u" apasata.*/
    public boolean i; /*!< Flag pentru tasta "i" apasata.*/
    public boolean o; /*!< Flag pentru tasta "o" apasata.*/
    public boolean p; /*!< Flag pentru tasta "p" apasata.*/
    public boolean f; /*!< Flag pentru tasta "f" apasata.*/
    public boolean g; /*!< Flag pentru tasta "g" apasata.*/
    public boolean h; /*!< Flag pentru tasta "h" apasata.*/
    public boolean j; /*!< Flag pentru tasta "j" apasata.*/
    public boolean k; /*!< Flag pentru tasta "k" apasata.*/
    public boolean l; /*!< Flag pentru tasta "l" apasata.*/
    public boolean z; /*!< Flag pentru tasta "z" apasata.*/
    public boolean x; /*!< Flag pentru tasta "x" apasata.*/
    public boolean c; /*!< Flag pentru tasta "c" apasata.*/
    public boolean v; /*!< Flag pentru tasta "v" apasata.*/
    public boolean b; /*!< Flag pentru tasta "b" apasata.*/
    public boolean n; /*!< Flag pentru tasta "n" apasata.*/
    public boolean m; /*!< Flag pentru tasta "m" apasata.*/

    public boolean escape; /*!< Flag pentru tasta "escape" apasata.*/

    /*! \fn public KeyManager()
        \brief Constructorul clasei.
     */
    public KeyManager()
    {
            ///Constructie vector de flaguri aferente tastelor.
        keys = new boolean[256];
    }


    public void Update()
    {
        up    = keys[KeyEvent.VK_W];
        down  = keys[KeyEvent.VK_S];
        left  = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
        space = keys[KeyEvent.VK_SPACE];
        enter = keys[KeyEvent.VK_ENTER];
        backspace = keys[KeyEvent.VK_BACK_SPACE];
        q = keys[KeyEvent.VK_Q];
        e = keys[KeyEvent.VK_E];
        r = keys[KeyEvent.VK_R];
        t = keys[KeyEvent.VK_T];
        y = keys[KeyEvent.VK_Y];
        u = keys[KeyEvent.VK_U];
        i = keys[KeyEvent.VK_I];
        o = keys[KeyEvent.VK_O];
        p = keys[KeyEvent.VK_P];
        f = keys[KeyEvent.VK_F];
        g = keys[KeyEvent.VK_G];
        h = keys[KeyEvent.VK_H];
        j = keys[KeyEvent.VK_J];
        k = keys[KeyEvent.VK_K];
        l = keys[KeyEvent.VK_L];
        z = keys[KeyEvent.VK_Z];
        x = keys[KeyEvent.VK_X];
        c = keys[KeyEvent.VK_C];
        v = keys[KeyEvent.VK_V];
        b = keys[KeyEvent.VK_B];
        n = keys[KeyEvent.VK_N];
        m = keys[KeyEvent.VK_M];
        escape = keys[KeyEvent.VK_ESCAPE];
    }

    /*! \fn public void keyPressed(KeyEvent e)
        \brief Functie ce va fi apelata atunci cand un un eveniment de tasta apasata este generat.

         \param e obiectul eveniment de tastatura.
     */
    @Override
    public void keyPressed(KeyEvent e)
    {
            ///se retine in vectorul de flaguri ca o tasta a fost apasata.
        keys[e.getKeyCode()] = true;
    }

    /*! \fn public void keyReleased(KeyEvent e)
        \brief Functie ce va fi apelata atunci cand un un eveniment de tasta eliberata este generat.

         \param e obiectul eveniment de tastatura.
     */
    @Override
    public void keyReleased(KeyEvent e)
    {
            ///se retine in vectorul de flaguri ca o tasta a fost eliberata.
        keys[e.getKeyCode()] = false;
    }

    /*! \fn public void keyTyped(KeyEvent e)
        \brief Functie ce va fi apelata atunci cand o tasta a fost apasata si eliberata.
        Momentan aceasta functie nu este utila in program.
     */
    @Override
    public void keyTyped(KeyEvent e)
    {

    }
}
