package PaooGame.Graphics;

import java.awt.image.BufferedImage;

/*! \class public class Assets
    \brief Clasa incarca fiecare element grafic necesar jocului.

    Game assets include tot ce este folosit intr-un joc: imagini, sunete, harti etc.
 */
public class Assets
{
        /// Referinte catre elementele grafice (dale) utilizate in joc.


    /// Hero
    public static BufferedImage heroLeft1;
    public static BufferedImage heroLeft2;
    public static BufferedImage heroLeft3;
    public static BufferedImage heroLeft4;
    public static BufferedImage heroLeft5;
    public static BufferedImage heroRight1;
    public static BufferedImage heroRight2;
    public static BufferedImage heroRight3;
    public static BufferedImage heroRight4;
    public static BufferedImage heroRight5;
    public static BufferedImage heroUp1;
    public static BufferedImage heroUp2;
    public static BufferedImage heroUp3;
    public static BufferedImage heroUp4;
    public static BufferedImage heroUp5;

    public static BufferedImage heroDown1;
    public static BufferedImage heroDown2;
    public static BufferedImage heroDown3;
    public static BufferedImage heroDown4;
    public static BufferedImage heroDown5;

    public static BufferedImage heroLeftAttack1;
    public static BufferedImage heroLeftAttack2;
    public static BufferedImage heroLeftAttack3;
    public static BufferedImage heroLeftAttack4;
    public static BufferedImage heroLeftAttack5;

    public static BufferedImage heroRightAttack1;
    public static BufferedImage heroRightAttack2;
    public static BufferedImage heroRightAttack3;
    public static BufferedImage heroRightAttack4;
    public static BufferedImage heroRightAttack5;

    public static BufferedImage heroDownAttack1;
    public static BufferedImage heroDownAttack2;
    public static BufferedImage heroDownAttack3;
    public static BufferedImage heroDownAttack4;
    public static BufferedImage heroDownAttack5;

    public static BufferedImage heroUpAttack1;
    public static BufferedImage heroUpAttack2;
    public static BufferedImage heroUpAttack3;
    public static BufferedImage heroUpAttack4;
    public static BufferedImage heroUpAttack5;


    /// Enemies

    public static BufferedImage enemy1Idle1;
    public static BufferedImage enemy1Idle2;
    public static BufferedImage enemy1Idle3;
    public static BufferedImage enemy1Idle4;

    public static BufferedImage enemy2Idle1;
    public static BufferedImage enemy2Idle2;
    public static BufferedImage enemy2Idle3;
    public static BufferedImage enemy2Idle4;

    /// Plains

    public static BufferedImage cliffTopLeft;
    public static BufferedImage cliffTopCenter;
    public static BufferedImage cliffTopRight;

    public static BufferedImage cliffMidLeft;
    public static BufferedImage cliffMidCenter;
    public static BufferedImage cliffMidRight;

    public static BufferedImage cliffBottomLeft;
    public static BufferedImage cliffBottomCenter;
    public static BufferedImage cliffBottomRight;

    public static BufferedImage cliffWallLeft;
    public static BufferedImage cliffWallCenter;
    public static BufferedImage cliffWallRight;

    /// Dirt Path

    public static BufferedImage grass;
    public static BufferedImage soil;
    public static BufferedImage soilTopLeft;
    public static BufferedImage soilTopCenter;
    public static BufferedImage soilTopRight;
    public static BufferedImage soilMidLeft;
    public static BufferedImage soilMidRight;

    public static BufferedImage soilBottomLeft;
    public static BufferedImage soilBottomCenter;
    public static BufferedImage soilBottomRight;
    public static BufferedImage soilCorner1;
    public static BufferedImage soilCorner2;
    public static BufferedImage soilCorner3;
    public static BufferedImage soilCorner4;

    /// Objects

    public static BufferedImage tree1;

    public static BufferedImage rock1;
    public static BufferedImage rock2;

    /*! \fn public static void Init()
        \brief Functia initializaza referintele catre elementele grafice utilizate.

        Aceasta functie poate fi rescrisa astfel incat elementele grafice incarcate/utilizate
        sa fie parametrizate. Din acest motiv referintele nu sunt finale.
     */
    public static void Init()
    {
        /// Se creaza temporar un obiect SpriteSheet initializat prin intermediul clasei ImageLoader
        SpriteSheet tilesSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/GroundTileset.png"));

        /// Se obtin subimaginile corespunzatoare elementelor necesare.
        grass = tilesSheet.crop(10,1);
        soil = tilesSheet.crop(1,11);
        soilTopLeft = tilesSheet.crop(0,10);
        soilTopCenter = tilesSheet.crop(1,10);
        soilTopRight = tilesSheet.crop(2,10);
        soilMidLeft = tilesSheet.crop(0,11);
        soilMidRight = tilesSheet.crop(2,11);
        soilBottomLeft = tilesSheet.crop(0,12);
        soilBottomCenter = tilesSheet.crop(1,12);
        soilBottomRight = tilesSheet.crop(2,12);
        soilCorner1 = tilesSheet.crop(5,11);
        soilCorner2 = tilesSheet.crop(5,12);
        soilCorner3 = tilesSheet.crop(6,11);
        soilCorner4 = tilesSheet.crop(6,12);

        /// Cliffs

        SpriteSheet plainsSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Cliff.png"));

        cliffTopLeft = plainsSheet.crop(7,0);
        cliffTopCenter = plainsSheet.crop(8,0);
        cliffTopRight = plainsSheet.crop(9,0);

        cliffMidLeft = plainsSheet.crop(7,1);
        cliffMidCenter = plainsSheet.crop(8,1);
        cliffMidRight = plainsSheet.crop(9,1);

        cliffBottomLeft = plainsSheet.crop(7,2);
        cliffBottomCenter = plainsSheet.crop(8,2);
        cliffBottomRight = plainsSheet.crop(9,2);

        cliffWallLeft = plainsSheet.crop(7,4);
        cliffWallCenter = plainsSheet.crop(8,4);
        cliffWallRight = plainsSheet.crop(9,4);

        /// Objects

        SpriteSheet treesSprite = new SpriteSheet(ImageLoader.LoadImage("/textures/Trees.png"));

        tree1 = treesSprite.cropScale(0,14,5,7);

        SpriteSheet rocksSprite = new SpriteSheet(ImageLoader.LoadImage("/textures/Rocks.png"));

        rock1 = rocksSprite.cropScale(0,0,1,1);
        rock2 = rocksSprite.cropScale(1,0,1,1);


        /// Hero

        SpriteSheet heroSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/knight.png"));

        heroDown1 = heroSheet.cropScale(0,0,2,2);
        heroDown2 = heroSheet.cropScale(2,0,2,2);
        heroDown3 = heroSheet.cropScale(4,0,2,2);
        heroDown4 = heroSheet.cropScale(6,0,2,2);
        heroDown5 = heroSheet.cropScale(8,0,2,2);
        heroUp1 = heroSheet.cropScale(0,2,2,2);
        heroUp2 = heroSheet.cropScale(2,2,2,2);
        heroUp3 = heroSheet.cropScale(4,2,2,2);
        heroUp4 = heroSheet.cropScale(6,2,2,2);
        heroUp5 = heroSheet.cropScale(8,2,2,2);
        heroLeft1 = heroSheet.cropScale(0,4,2,2);
        heroLeft2 = heroSheet.cropScale(2,4,2,2);
        heroLeft3 = heroSheet.cropScale(4,4,2,2);
        heroLeft4 = heroSheet.cropScale(6,4,2,2);
        heroLeft5 = heroSheet.cropScale(8,4,2,2);
        heroRight1 = heroSheet.cropScale(0,6,2,2);
        heroRight2 = heroSheet.cropScale(2,6,2,2);
        heroRight3 = heroSheet.cropScale(4,6,2,2);
        heroRight4 = heroSheet.cropScale(6,6,2,2);
        heroRight5 = heroSheet.cropScale(8,6,2,2);

        heroLeftAttack1 = heroSheet.cropScale(0,12,2,2);
        heroLeftAttack2 = heroSheet.cropScale(2,12,2,2);
        heroLeftAttack3 = heroSheet.cropScale(4,12,2,2);
        heroLeftAttack4 = heroSheet.cropScale(6,12,2,2);
        heroLeftAttack5 = heroSheet.cropScale(8,12,2,2);

        heroRightAttack1 = heroSheet.cropScale(0,14,2,2);
        heroRightAttack2 = heroSheet.cropScale(2,14,2,2);
        heroRightAttack3 = heroSheet.cropScale(4,14,2,2);
        heroRightAttack4 = heroSheet.cropScale(6,14,2,2);
        heroRightAttack5 = heroSheet.cropScale(8,14,2,2);

        heroUpAttack1 = heroSheet.cropScale(0,10,2,2);
        heroUpAttack2 = heroSheet.cropScale(2,10,2,2);
        heroUpAttack3 = heroSheet.cropScale(4,10,2,2);
        heroUpAttack4 = heroSheet.cropScale(6,10,2,2);
        heroUpAttack5 = heroSheet.cropScale(8,10,2,2);

        heroDownAttack1 = heroSheet.cropScale(0,8,2,2);
        heroDownAttack2 = heroSheet.cropScale(2,8,2,2);
        heroDownAttack3 = heroSheet.cropScale(4,8,2,2);
        heroDownAttack4 = heroSheet.cropScale(6,8,2,2);
        heroDownAttack5 = heroSheet.cropScale(8,8,2,2);


        /// Enemies

        SpriteSheet enemy1Sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Enemy1.png"));

        enemy1Idle1 = enemy1Sheet.crop(0,0);
        enemy1Idle2 = enemy1Sheet.crop(1,0);
        enemy1Idle3 = enemy1Sheet.crop(2,0);
        enemy1Idle4 = enemy1Sheet.crop(3,0);

        SpriteSheet enemy2Sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Enemy2.png"));

        enemy2Idle1 = enemy2Sheet.crop(0,0);
        enemy2Idle2 = enemy2Sheet.crop(1,0);
        enemy2Idle3 = enemy2Sheet.crop(2,0);
        enemy2Idle4 = enemy2Sheet.crop(3,0);
    }
}
