package PaooGame.States;

import PaooGame.RefLinks;

import java.awt.*;

/*! \class public class MenuState extends State
    \brief Implementeaza notiunea de menu pentru joc.
 */
public class PauseState extends State
{
    /*! \fn public MenuState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */

    private int selectedButton = 0;
    private int inputCounter = 0;

    private int currentMenu = 0;
    private boolean interacting = false;

    private String name = "";

    public PauseState(RefLinks refLink)
    {
            ///Apel al constructorului clasei de baza.
        super(refLink);
    }
    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a meniului.
     */

    public int GetXCenteredText(String text, Graphics g){
        int len = (int)g.getFontMetrics().getStringBounds(text,g).getWidth();
        int x = refLink.GetWidth()/2-len/2;
        return x;
    }

    @Override
    public void Update()
    {
        if(inputCounter == 5){
            inputCounter = 0;

            if(currentMenu == 0) {
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
                            System.out.println("Resume");
                            State.SetState(refLink.GetGame().GetState(1));
                            break;
                        case 1:
                            System.out.println("Save Menu");
                            currentMenu = 1;
                            selectedButton = 0;
                            break;
                            /// TO DO
                        case 2:
                            currentMenu = 0;
                            selectedButton = 0;
                            State.SetState(refLink.GetGame().GetState(2));
                            break;
                        case 3:
                            PlayState playState = (PlayState) refLink.GetGame().GetState(1);
                            playState.LoadData("FreshDataInitialization");
                            State.SetState(refLink.GetGame().GetState(0));
                            break;
                    }

                }

            } else if (currentMenu == 1) {
                if (refLink.GetKeyManager().up && interacting == false) {
                    if (selectedButton > 0)
                        selectedButton--;
                }

                if (refLink.GetKeyManager().down && interacting == false) {
                    if (selectedButton < 2)
                        selectedButton++;
                }

                if(refLink.GetKeyManager().backspace && selectedButton == 0){
                    if(name.length() > 0)
                        name = name.substring(0,name.length()-1);
                }

                if(selectedButton == 0 && name.length() < 11 && interacting == true) {
                    if (refLink.GetKeyManager().q) {
                        name = name + "q";
                    }else if (refLink.GetKeyManager().e) {
                        name = name + "e";
                    } else if (refLink.GetKeyManager().r) {
                        name = name + "r";
                    } else if (refLink.GetKeyManager().t) {
                        name = name + "t";
                    } else if (refLink.GetKeyManager().y) {
                        name = name + "y";
                    } else if (refLink.GetKeyManager().u) {
                        name = name + "u";
                    } else if (refLink.GetKeyManager().i) {
                        name = name + "i";
                    } else if (refLink.GetKeyManager().o) {
                        name = name + "o";
                    } else if (refLink.GetKeyManager().p) {
                        name = name + "p";
                    } else if (refLink.GetKeyManager().up) {
                        name = name + "w";
                    } else if (refLink.GetKeyManager().left) {
                        name = name + "a";
                    } else if (refLink.GetKeyManager().down) {
                        name = name + "s";
                    } else if (refLink.GetKeyManager().right) {
                        name = name + "d";
                    } else if (refLink.GetKeyManager().f) {
                        name = name + "f";
                    } else if (refLink.GetKeyManager().g) {
                        name = name + "g";
                    } else if (refLink.GetKeyManager().h) {
                        name = name + "h";
                    } else if (refLink.GetKeyManager().j) {
                        name = name + "j";
                    } else if (refLink.GetKeyManager().k) {
                        name = name + "k";
                    } else if (refLink.GetKeyManager().l) {
                        name = name + "l";
                    } else if (refLink.GetKeyManager().z) {
                        name = name + "z";
                    } else if (refLink.GetKeyManager().x) {
                        name = name + "x";
                    } else if (refLink.GetKeyManager().c) {
                        name = name + "c";
                    } else if (refLink.GetKeyManager().v) {
                        name = name + "v";
                    } else if (refLink.GetKeyManager().b) {
                        name = name + "b";
                    } else if (refLink.GetKeyManager().n) {
                        name = name + "n";
                    } else if (refLink.GetKeyManager().m) {
                        name = name + "m";
                    }
                }



                    if (refLink.GetKeyManager().enter) {
                    System.out.println(selectedButton);
                    switch (selectedButton) {
                        case 0:
                            interacting = !interacting;
                            break;
                        case 1:
                            System.out.println("Save Game");
                            State.SetState(refLink.GetGame().GetState(3));

                            PlayState playState = (PlayState) refLink.GetGame().GetState(1);
                            playState.SaveData(name);
                            currentMenu = 0;
                            selectedButton = 0;
                            break;
                        case 2:
                            currentMenu = 0;
                            selectedButton = 0;
                            break;
                    }

                }
            } else if (currentMenu == 2) {
                if (refLink.GetKeyManager().up) {
                    if (selectedButton > 0)
                        selectedButton--;
                }

                if (refLink.GetKeyManager().down) {
                    if (selectedButton < 2)
                        selectedButton++;
                }

                if (refLink.GetKeyManager().enter) {
                    System.out.println(selectedButton);
                    switch (selectedButton) {
                        case 0:
                            System.out.println("Restart");
                            State.SetState(refLink.GetGame().GetState(1));
                            refLink.GetGame().Restart();
                            break;
                        case 1:
                            System.out.println("Go to menu");
                            State.SetState(refLink.GetGame().GetState(0));
                            currentMenu = 0;
                            selectedButton = 0;
                            break;
                        /// TO DO
                        case 2:
                            System.exit(0);
                            break;
                    }

                }
            }
            else if (currentMenu == 3) {
                if (refLink.GetKeyManager().up) {
                    if (selectedButton > 0)
                        selectedButton--;
                }

                if (refLink.GetKeyManager().down) {
                    if (selectedButton < 1)
                        selectedButton++;
                }

                if (refLink.GetKeyManager().enter) {
                    System.out.println(selectedButton);
                    switch (selectedButton) {
                        case 0:
                            System.out.println("Go to menu");
                            State.SetState(refLink.GetGame().GetState(0));
                            currentMenu = 0;
                            selectedButton = 0;
                            break;
                        case 1:
                            System.exit(0);
                            break;
                    }

                }
            }
        }
        else{
            inputCounter++;
        }

    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a meniului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        if(currentMenu == 0) {
            g.setColor(new Color(0, 0, 0));
            g.fillRect(0, 0, refLink.GetWidth(), refLink.GetHeight());
            g.setFont(new Font("Impact", Font.PLAIN, 55));
            String text = "Game Paused";
            int x = GetXCenteredText(text, g);
            int y = 16 * 6;

            g.setColor(Color.white);
            g.drawString(text, x, y);

            // Buttons

            g.setFont(new Font("Arial Black", Font.PLAIN, 30));

            text = "Resume";
            x = GetXCenteredText(text, g);
            y = 16 * 20;
            g.drawString(text, x, y);
            if (selectedButton == 0)
                g.drawString(">", x - 32, y);

            text = "Save";
            x = GetXCenteredText(text, g);
            y += 16 * 3;
            g.drawString(text, x, y);
            if (selectedButton == 1)
                g.drawString(">", x - 32, y);

            text = "Settings";
            x = GetXCenteredText(text, g);
            y += 16 * 3;
            g.drawString(text, x, y);
            if (selectedButton == 2)
                g.drawString(">", x - 32, y);

            text = "Quit";
            x = GetXCenteredText(text, g);
            y += 16 * 3;
            g.drawString(text, x, y);
            if (selectedButton == 3)
                g.drawString(">", x - 32, y);
        } else if (currentMenu == 1) {
            g.setColor(new Color(0, 0, 0));
            g.fillRect(0, 0, refLink.GetWidth(), refLink.GetHeight());
            g.setFont(new Font("Impact", Font.PLAIN, 40));
            String text = "Enter your name: ";
            int x = GetXCenteredText(text, g);
            int y = 16 * 6;

            g.setColor(Color.white);
            g.drawString(text, x, y);

            y = 16 * 16;
            g.drawRect(refLink.GetWidth()/2-200,y,400,100);
            if (selectedButton == 0)
                g.drawString(">", refLink.GetWidth()/2-232, y+65);


            g.setFont(new Font("Arial Black", Font.PLAIN, 25));

            if(interacting==false)
                text = "Press Space to Interact";
            else
                text = "Press Space to confirm the username";
            x = GetXCenteredText(text, g);
            y = 8 * 29;
            g.drawString(text, x, y);


            g.setFont(new Font("Impact", Font.PLAIN, 42));
            y = 16*16;

            g.drawString(name,refLink.GetWidth()/2-180,y+65);

            g.setFont(new Font("Arial Black", Font.PLAIN, 30));

            text = "SAVE";
            x = GetXCenteredText(text, g);
            y = 16 * 29;
            g.drawString(text, x, y);
            if (selectedButton == 1)
                g.drawString(">", x - 32, y);

            text = "BACK";
            x = GetXCenteredText(text, g);
            y += 16 * 3;
            g.drawString(text, x, y);
            if (selectedButton == 2)
                g.drawString(">", x - 32, y);
        }
        else if (currentMenu == 2) {
            g.setColor(new Color(0, 0, 0));
            g.fillRect(0, 0, refLink.GetWidth(), refLink.GetHeight());
            g.setFont(new Font("Impact", Font.PLAIN, 55));
            String text = "You have lost!";
            int x = GetXCenteredText(text, g);
            int y = 16 * 6;

            g.setColor(Color.white);
            g.drawString(text, x, y);

            // Buttons

            g.setFont(new Font("Arial Black", Font.PLAIN, 30));

            text = "Restart";
            x = GetXCenteredText(text, g);
            y = 16 * 20;
            g.drawString(text, x, y);
            if (selectedButton == 0)
                g.drawString(">", x - 32, y);

            text = "Go to Menu";
            x = GetXCenteredText(text, g);
            y += 16 * 3;
            g.drawString(text, x, y);
            if (selectedButton == 1)
                g.drawString(">", x - 32, y);

            text = "Quit";
            x = GetXCenteredText(text, g);
            y += 16 * 3;
            g.drawString(text, x, y);
            if (selectedButton == 2)
                g.drawString(">", x - 32, y);
        }
        else if (currentMenu == 3) {
            g.setColor(new Color(0, 0, 0));
            g.fillRect(0, 0, refLink.GetWidth(), refLink.GetHeight());
            g.setFont(new Font("Impact", Font.PLAIN, 55));
            String text = "You have won the game!";
            int x = GetXCenteredText(text, g);
            int y = 16 * 6;

            g.setColor(Color.white);
            g.drawString(text, x, y);

            // Buttons

            g.setFont(new Font("Arial Black", Font.PLAIN, 30));

            text = "Score: "+refLink.GetHero().GetScore();
            x = GetXCenteredText(text, g);
            y = 16 * 20;
            g.drawString(text, x, y);

            text = "Go to Menu";
            x = GetXCenteredText(text, g);
            y += 16 * 3;
            g.drawString(text, x, y);
            if (selectedButton == 0)
                g.drawString(">", x - 32, y);

            text = "Quit";
            x = GetXCenteredText(text, g);
            y += 16 * 3;
            g.drawString(text, x, y);
            if (selectedButton == 1)
                g.drawString(">", x - 32, y);
        }

    }

    public void SetMenu(int Menu){
        currentMenu = Menu;
        selectedButton = 0;
    }
}
