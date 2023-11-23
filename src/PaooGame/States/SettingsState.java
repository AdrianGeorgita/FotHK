package PaooGame.States;

import PaooGame.RefLinks;

import java.awt.*;

/*! \class public class SettingsState extends State
    \brief Implementeaza notiunea de settings pentru joc.

    Aici setarile vor trebui salvate/incarcate intr-un/dintr-un fisier/baza de date sqlite.
 */
public class SettingsState extends State
{

    private int selectedButton = 0;
    private int inputCounter = 0;

    private int heroDamage;
    private int heroLife;

    public static boolean music = true;
    public static boolean soundEffects = true;
    public static boolean cheats = false;

    /*! \fn public SettingsState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public SettingsState(RefLinks refLink)
    {
            ///Apel al construcotrului clasei de baza.
        super(refLink);
    }

    public int GetXCenteredText(String text, Graphics g){
        int len = (int)g.getFontMetrics().getStringBounds(text,g).getWidth();
        int x = refLink.GetWidth()/2-len/2;
        return x;
    }

    /*! \fn public void Update()
        \brief Actualizeaza starea setarilor.
     */
    @Override
    public void Update()
    {
        inputCounter++;
        if(inputCounter == 5) {
            inputCounter = 0;

            if (refLink.GetKeyManager().up) {
                if (selectedButton > 0)
                    selectedButton--;
            }

            if (refLink.GetKeyManager().down) {
                if (selectedButton < 3)
                    selectedButton++;
            }

            if (refLink.GetKeyManager().enter) {
                System.out.println(selectedButton);
                switch (selectedButton) {
                    case 0:
                        music = !music;
                        if(music==false){
                            refLink.StopMusic();
                        }
                        else
                            refLink.PlayMusic();
                        break;
                    case 1:
                        soundEffects = !soundEffects;
                        break;
                    case 2:
                        cheats = !cheats;
                        if(cheats){
                            heroDamage = refLink.GetHero().GetDamage();
                            heroLife = refLink.GetHero().GetLife();
                            refLink.GetHero().SetDamage(500);
                            refLink.GetHero().SetLife(5000);
                        }else{
                            refLink.GetHero().SetDamage(heroDamage);
                            refLink.GetHero().SetLife(heroLife);
                        }
                        break;
                    case 3:
                        selectedButton = 0;
                        State.SetState(State.GetPreviousState());
                        break;
                }

            }
        }
    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran setarile.

        \param g Contextul grafic in care trebuie sa deseneze starea setarilor pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, refLink.GetWidth(), refLink.GetHeight());
        g.setFont(new Font("Impact", Font.PLAIN, 55));
        String text = "Settings";
        int x = GetXCenteredText(text, g);
        int y = 16 * 6;

        g.setColor(Color.white);
        g.drawString(text, x, y);

        // Buttons

        g.setFont(new Font("Arial Black", Font.PLAIN, 30));

        text = "Music";
        x = GetXCenteredText(text, g);
        y = 16 * 17;
        g.drawString(text, x, y);
        if (selectedButton == 0)
            g.drawString(">", x - 32, y);

        g.fillRect(x+240,y-30,32,32);
        g.setColor(new Color(0,0,0));
        g.fillRect(x+242,y-28,28,28);

        g.setColor(Color.white);
        if(music){
            g.drawString("X",x+244,y-4);
        }


        text = "Sound Effects";
        x = GetXCenteredText(text, g);
        y += 16 * 3;
        g.drawString(text, x, y);
        if (selectedButton == 1)
            g.drawString(">", x - 32, y);

        g.fillRect(x+240,y-30,32,32);
        g.setColor(new Color(0,0,0));
        g.fillRect(x+242,y-28,28,28);

        g.setColor(Color.white);
        if(soundEffects){
            g.drawString("X",x+244,y-4);
        }

        text = "Cheat Mode";
        x = GetXCenteredText(text, g);
        y += 16 * 3;
        g.drawString(text, x, y);
        if (selectedButton == 2)
            g.drawString(">", x - 32, y);

        g.fillRect(x+240,y-30,32,32);
        g.setColor(new Color(0,0,0));
        g.fillRect(x+242,y-28,28,28);

        g.setColor(Color.white);
        if(cheats){
            g.drawString("X",x+244,y-4);
        }

        text = "Back";
        x = GetXCenteredText(text, g);
        y += 16 * 3;
        g.drawString(text, x, y);
        if (selectedButton == 3)
            g.drawString(">", x - 32, y);
    }
}
