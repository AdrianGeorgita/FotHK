package PaooGame.States;

import PaooGame.Exceptions.InvalidDataLoaded;
import PaooGame.Factory.ChestCreator;
import PaooGame.Factory.EnemyCreator;
import PaooGame.Factory.ItemCreator;
import PaooGame.Items.Hero;
import PaooGame.RefLinks;
import PaooGame.Maps.Map;
import PaooGame.Tiles.Tile;
import PaooGame.Items.*;


import java.awt.*;
import java.util.ArrayList;
import java.sql.*;
import java.util.Set;

/*! \class public class PlayState extends State
    \brief Implementeaza/controleaza jocul.
 */
public class PlayState extends State
{
    private Hero hero;  /*!< Referinta catre obiectul animat erou (controlat de utilizator).*/
    private Map map;    /*!< Referinta catre harta curenta.*/

    private ArrayList<Item> items = new ArrayList<Item>();

    private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

    private Chest chest;
    private Key key;
    private int chestOpen = 0;
    private int hasKey = 0;

    private int level = 1;

    /*! \fn public PlayState(RefLinks refLink)
        \brief Constructorul de initializare al clasei

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public PlayState(RefLinks refLink)
    {
            ///Apel al constructorului clasei de baza
        super(refLink);
            ///Construieste harta jocului
        map = new Map(refLink, level);
            ///Referinta catre harta construita este setata si in obiectul shortcut pentru a fi accesibila si in alte clase ale programului.
        refLink.SetMap(map);

        LoadCharacters(false,null);

        ///Construieste eroul
        hero = new Hero(refLink, 64, 256);
        refLink.SetHero(hero);

        chest = refLink.GetChest();
        key = refLink.GetKey();
    }

    private void LoadCharacters(boolean Loading, String Enemies){
        /// Folosim o fabrica de inamici
        refLink.SetProjectiles(projectiles);

        ItemCreator creator = null;
        ItemCreator chestCreator = new ChestCreator();
        creator = new EnemyCreator();

        if(Loading){
            items = new ArrayList<Item>();
            refLink.SetItems(items);
            refLink.SetProjectiles(projectiles);
        }

        // Folosind fabrica, generam un inamic de tip specificat pe care il adaugam intr-o lista de iteme
        Item item = null;
        switch (level){
            case 1:
                if(Loading == false){
                    item = creator.GenerateItem("Enemy1",refLink,22*Tile.TILE_WIDTH, 2*Tile.TILE_HEIGHT,1);
                    items.add(item);
                    item = creator.GenerateItem("Enemy1",refLink,30*Tile.TILE_WIDTH, 18*Tile.TILE_HEIGHT,2);
                    items.add(item);
                    item = creator.GenerateItem("Enemy1",refLink,50*Tile.TILE_WIDTH, 13*Tile.TILE_HEIGHT,3);
                    items.add(item);
                    item = creator.GenerateItem("Enemy2",refLink,24*Tile.TILE_WIDTH, 25*Tile.TILE_HEIGHT,4);
                    items.add(item);
                    item = creator.GenerateItem("Enemy1",refLink,25*Tile.TILE_WIDTH,13* Tile.TILE_HEIGHT,5);
                    items.add(item);
                    item = chestCreator.GenerateItem("Chest1",refLink,4*Tile.TILE_WIDTH, 27*Tile.TILE_HEIGHT,78);
                    refLink.SetChest((Chest) item);
                    chest = (Chest) item;
                    item = chestCreator.GenerateItem("Key",refLink,42*Tile.TILE_WIDTH,8*Tile.TILE_HEIGHT,79);
                    refLink.SetKey((Key) item);
                    key = (Key) item;
                }
                else{
                    String ids[] = Enemies.split(" ");
                    for(String idString: ids){
                        int id = Integer.parseInt(idString);
                        if(id == 1){
                            item = creator.GenerateItem("Enemy1",refLink,22*Tile.TILE_WIDTH, 2*Tile.TILE_HEIGHT,1);
                            items.add(item);
                        }
                        if(id == 2){
                            item = creator.GenerateItem("Enemy1",refLink,30*Tile.TILE_WIDTH, 18*Tile.TILE_HEIGHT,2);
                            items.add(item);
                        }
                        if(id == 3){
                            item = creator.GenerateItem("Enemy1",refLink,50*Tile.TILE_WIDTH, 13*Tile.TILE_HEIGHT,3);
                            items.add(item);
                        }
                        if(id == 4){
                            item = creator.GenerateItem("Enemy2",refLink,24*Tile.TILE_WIDTH, 25*Tile.TILE_HEIGHT,4);
                            items.add(item);
                        }
                        if(id == 5){
                            item = creator.GenerateItem("Enemy1",refLink,25*Tile.TILE_WIDTH,13* Tile.TILE_HEIGHT,5);
                            items.add(item);
                        }
                    }
                    item = chestCreator.GenerateItem("Chest1",refLink,4*Tile.TILE_WIDTH, 27*Tile.TILE_HEIGHT,78);
                    refLink.SetChest((Chest) item);
                    chest = (Chest) item;
                    item = chestCreator.GenerateItem("Key",refLink,42*Tile.TILE_WIDTH,8*Tile.TILE_HEIGHT,79);
                    refLink.SetKey((Key) item);
                    key = (Key) item;
                }
                break;
            case 2:
                if(Loading == false) {
                    item = creator.GenerateItem("Enemy1", refLink, 8 * Tile.TILE_WIDTH, 17 * Tile.TILE_HEIGHT, 6);
                    items.add(item);

                    item = creator.GenerateItem("Enemy2", refLink, 6 * Tile.TILE_WIDTH, 27 * Tile.TILE_HEIGHT, 7);
                    items.add(item);

                    item = creator.GenerateItem("Enemy1", refLink, 28 * Tile.TILE_WIDTH, 27 * Tile.TILE_HEIGHT, 8);
                    items.add(item);

                    item = creator.GenerateItem("Enemy1", refLink, 50 * Tile.TILE_WIDTH, 27 * Tile.TILE_HEIGHT, 9);
                    items.add(item);
                    item = creator.GenerateItem("Enemy1", refLink, 30 * Tile.TILE_WIDTH, 16 * Tile.TILE_HEIGHT, 10);
                    items.add(item);
                    item = creator.GenerateItem("Enemy1", refLink, 14 * Tile.TILE_WIDTH, 20 * Tile.TILE_HEIGHT, 11);
                    items.add(item);
                    item = creator.GenerateItem("Enemy2", refLink, 53 * Tile.TILE_WIDTH, 19 * Tile.TILE_HEIGHT, 12);
                    items.add(item);
                    item = creator.GenerateItem("Enemy2", refLink, 45 * Tile.TILE_WIDTH, 4 * Tile.TILE_HEIGHT, 13);
                    items.add(item);
                    item = creator.GenerateItem("Enemy2", refLink, 36 * Tile.TILE_WIDTH, 6 * Tile.TILE_HEIGHT, 14);
                    items.add(item);
                    item = creator.GenerateItem("Enemy1", refLink, 20 * Tile.TILE_WIDTH, 3 * Tile.TILE_HEIGHT, 15);
                    items.add(item);

                    item = chestCreator.GenerateItem("Chest2", refLink, 36 * Tile.TILE_WIDTH, 1 * Tile.TILE_HEIGHT, 88);
                    refLink.SetChest((Chest) item);
                    chest = (Chest) item;
                    item = chestCreator.GenerateItem("Key", refLink, 55 * Tile.TILE_WIDTH, 30 * Tile.TILE_HEIGHT, 89);
                    refLink.SetKey((Key) item);
                    key = (Key) item;

                }else{

                    item = chestCreator.GenerateItem("Chest2", refLink, 36 * Tile.TILE_WIDTH, 1 * Tile.TILE_HEIGHT, 88);
                    refLink.SetChest((Chest) item);
                    chest = (Chest) item;
                    item = chestCreator.GenerateItem("Key", refLink, 55 * Tile.TILE_WIDTH, 30 * Tile.TILE_HEIGHT, 89);
                    refLink.SetKey((Key) item);
                    key = (Key) item;

                    String ids[] = Enemies.split(" ");
                    for(String idString: ids) {
                        int id = Integer.parseInt(idString);
                        if (id == 6) {
                            item = creator.GenerateItem("Enemy1", refLink, 8 * Tile.TILE_WIDTH, 17 * Tile.TILE_HEIGHT, 6);
                            items.add(item);
                        }
                        if (id == 7) {
                            item = creator.GenerateItem("Enemy2", refLink, 6 * Tile.TILE_WIDTH, 27 * Tile.TILE_HEIGHT, 7);
                            items.add(item);
                        }
                        if (id == 8) {
                            item = creator.GenerateItem("Enemy1", refLink, 28 * Tile.TILE_WIDTH, 27 * Tile.TILE_HEIGHT, 8);
                            items.add(item);
                        }
                        if (id == 9) {
                            item = creator.GenerateItem("Enemy1", refLink, 50 * Tile.TILE_WIDTH, 27 * Tile.TILE_HEIGHT, 9);
                            items.add(item);
                        }
                        if (id == 10) {
                            item = creator.GenerateItem("Enemy1", refLink, 30 * Tile.TILE_WIDTH, 16 * Tile.TILE_HEIGHT, 10);
                            items.add(item);
                        }
                        if (id == 11) {
                            item = creator.GenerateItem("Enemy1", refLink, 14 * Tile.TILE_WIDTH, 20 * Tile.TILE_HEIGHT, 11);
                            items.add(item);
                        }
                        if (id == 12) {
                            item = creator.GenerateItem("Enemy2", refLink, 53 * Tile.TILE_WIDTH, 19 * Tile.TILE_HEIGHT, 12);
                            items.add(item);
                        }
                        if (id == 13) {
                            item = creator.GenerateItem("Enemy2", refLink, 45 * Tile.TILE_WIDTH, 4 * Tile.TILE_HEIGHT, 13);
                            items.add(item);
                        }
                        if (id == 14) {
                            item = creator.GenerateItem("Enemy2", refLink, 36 * Tile.TILE_WIDTH, 6 * Tile.TILE_HEIGHT, 14);
                            items.add(item);
                        }
                        if (id == 15) {
                            item = creator.GenerateItem("Enemy1", refLink, 20 * Tile.TILE_WIDTH, 3 * Tile.TILE_HEIGHT, 15);
                            items.add(item);
                        }
                    }
                }

                    break;


            case 3:
                if(Loading == false) {
                    System.out.println("Create enemies for 3rd level");
                    item = creator.GenerateItem("Enemy3", refLink, 4 * Tile.TILE_WIDTH, 7 * Tile.TILE_HEIGHT, 16);
                    items.add(item);
                    item = creator.GenerateItem("Enemy2", refLink, 5 * Tile.TILE_WIDTH, 19 * Tile.TILE_HEIGHT, 17);
                    items.add(item);
                    item = creator.GenerateItem("Enemy1", refLink, 13 * Tile.TILE_WIDTH, 19 * Tile.TILE_HEIGHT, 18);
                    items.add(item);
                    item = creator.GenerateItem("Enemy1", refLink, 26 * Tile.TILE_WIDTH, 11 * Tile.TILE_HEIGHT, 19);
                    items.add(item);
                    item = creator.GenerateItem("Enemy2", refLink, 17 * Tile.TILE_WIDTH, 10 * Tile.TILE_HEIGHT, 20);
                    items.add(item);
                    item = creator.GenerateItem("Enemy2", refLink, 37 * Tile.TILE_WIDTH, 10 * Tile.TILE_HEIGHT, 21);
                    items.add(item);
                    item = creator.GenerateItem("Enemy2", refLink, 50 * Tile.TILE_WIDTH, 8 * Tile.TILE_HEIGHT, 22);
                    items.add(item);
                    item = creator.GenerateItem("Enemy1", refLink, 45 * Tile.TILE_WIDTH, 16 * Tile.TILE_HEIGHT, 23);
                    items.add(item);
                    item = creator.GenerateItem("Enemy1", refLink, 56 * Tile.TILE_WIDTH, 16 * Tile.TILE_HEIGHT, 24);
                    items.add(item);
                    item = creator.GenerateItem("Enemy3", refLink, 50 * Tile.TILE_WIDTH, 3 * Tile.TILE_HEIGHT, 25);
                    items.add(item);
                    item = creator.GenerateItem("Enemy2", refLink, 32 * Tile.TILE_WIDTH, 16 * Tile.TILE_HEIGHT, 26);
                    items.add(item);
                    item = creator.GenerateItem("Enemy1", refLink, 38 * Tile.TILE_WIDTH, 18 * Tile.TILE_HEIGHT, 27);
                    items.add(item);
                    item = creator.GenerateItem("Enemy2", refLink, 10 * Tile.TILE_WIDTH, 28 * Tile.TILE_HEIGHT, 28);
                    items.add(item);
                    item = creator.GenerateItem("Enemy2", refLink, 16 * Tile.TILE_WIDTH, 30 * Tile.TILE_HEIGHT, 29);
                    items.add(item);
                    item = creator.GenerateItem("Enemy2", refLink, 30 * Tile.TILE_WIDTH, 30 * Tile.TILE_HEIGHT, 30);
                    items.add(item);
                    item = creator.GenerateItem("Enemy1", refLink, 40 * Tile.TILE_WIDTH, 28 * Tile.TILE_HEIGHT, 31);
                    items.add(item);
                    item = creator.GenerateItem("Enemy2", refLink, 56 * Tile.TILE_WIDTH, 24 * Tile.TILE_HEIGHT, 32);
                    items.add(item);
                    item = creator.GenerateItem("Enemy3", refLink, 38 * Tile.TILE_WIDTH, 3 * Tile.TILE_HEIGHT, 33);
                    items.add(item);
                    item = creator.GenerateItem("Boss", refLink, 14 * Tile.TILE_WIDTH, 3 * Tile.TILE_HEIGHT, 34);
                    items.add(item);

                    item = chestCreator.GenerateItem("Chest3", refLink, 56 * Tile.TILE_WIDTH, 30 * Tile.TILE_HEIGHT, 98);
                    refLink.SetChest((Chest) item);
                    chest = (Chest) item;
                    item = chestCreator.GenerateItem("Key", refLink, 4 * Tile.TILE_WIDTH, 2 * Tile.TILE_HEIGHT, 99);
                    refLink.SetKey((Key) item);
                    key = (Key) item;
                }else{
                    item = chestCreator.GenerateItem("Chest3", refLink, 56 * Tile.TILE_WIDTH, 30 * Tile.TILE_HEIGHT, 98);
                    refLink.SetChest((Chest) item);
                    chest = (Chest) item;
                    item = chestCreator.GenerateItem("Key", refLink, 4 * Tile.TILE_WIDTH, 2 * Tile.TILE_HEIGHT, 99);
                    refLink.SetKey((Key) item);
                    key = (Key) item;

                    String ids[] = Enemies.split(" ");
                    for(String idString: ids) {
                        int id = Integer.parseInt(idString);
                        if (id == 16) {
                            item = creator.GenerateItem("Enemy3", refLink, 4 * Tile.TILE_WIDTH, 7 * Tile.TILE_HEIGHT, 16);
                            items.add(item);
                        }
                        if (id == 17) {
                            item = creator.GenerateItem("Enemy2", refLink, 5 * Tile.TILE_WIDTH, 19 * Tile.TILE_HEIGHT, 17);
                            items.add(item);
                        }
                        if (id == 18) {
                            item = creator.GenerateItem("Enemy1", refLink, 13 * Tile.TILE_WIDTH, 19 * Tile.TILE_HEIGHT, 18);
                            items.add(item);
                        }
                        if (id == 19) {
                            item = creator.GenerateItem("Enemy1", refLink, 26 * Tile.TILE_WIDTH, 11 * Tile.TILE_HEIGHT, 19);
                            items.add(item);
                        }
                        if (id == 20) {
                            item = creator.GenerateItem("Enemy2", refLink, 17 * Tile.TILE_WIDTH, 10 * Tile.TILE_HEIGHT, 20);
                            items.add(item);
                        }
                        if (id == 21) {
                            item = creator.GenerateItem("Enemy2", refLink, 37 * Tile.TILE_WIDTH, 10 * Tile.TILE_HEIGHT, 21);
                            items.add(item);
                        }
                        if (id == 22) {
                            item = creator.GenerateItem("Enemy2", refLink, 50 * Tile.TILE_WIDTH, 8 * Tile.TILE_HEIGHT, 22);
                            items.add(item);
                        }
                        if (id == 23) {
                            item = creator.GenerateItem("Enemy1", refLink, 45 * Tile.TILE_WIDTH, 16 * Tile.TILE_HEIGHT, 23);
                            items.add(item);
                        }
                        if (id == 24) {
                            item = creator.GenerateItem("Enemy1", refLink, 56 * Tile.TILE_WIDTH, 16 * Tile.TILE_HEIGHT, 24);
                            items.add(item);
                        }
                        if (id == 25) {
                            item = creator.GenerateItem("Enemy3", refLink, 50 * Tile.TILE_WIDTH, 3 * Tile.TILE_HEIGHT, 25);
                            items.add(item);
                        }
                        if (id == 26) {
                            item = creator.GenerateItem("Enemy2", refLink, 32 * Tile.TILE_WIDTH, 16 * Tile.TILE_HEIGHT, 26);
                            items.add(item);
                        }
                        if (id == 27) {
                            item = creator.GenerateItem("Enemy1", refLink, 38 * Tile.TILE_WIDTH, 18 * Tile.TILE_HEIGHT, 27);
                            items.add(item);
                        }
                        if (id == 28) {
                            item = creator.GenerateItem("Enemy2", refLink, 10 * Tile.TILE_WIDTH, 28 * Tile.TILE_HEIGHT, 28);
                            items.add(item);
                        }
                        if (id == 29) {
                            item = creator.GenerateItem("Enemy2", refLink, 16 * Tile.TILE_WIDTH, 30 * Tile.TILE_HEIGHT, 29);
                            items.add(item);
                        }
                        if (id == 30) {
                            item = creator.GenerateItem("Enemy2", refLink, 30 * Tile.TILE_WIDTH, 30 * Tile.TILE_HEIGHT, 30);
                            items.add(item);
                        }
                        if (id == 31) {
                            item = creator.GenerateItem("Enemy1", refLink, 40 * Tile.TILE_WIDTH, 28 * Tile.TILE_HEIGHT, 31);
                            items.add(item);
                        }
                        if (id == 32) {
                            item = creator.GenerateItem("Enemy2", refLink, 56 * Tile.TILE_WIDTH, 24 * Tile.TILE_HEIGHT, 32);
                            items.add(item);
                        }
                        if (id == 33) {
                            item = creator.GenerateItem("Enemy3", refLink, 38 * Tile.TILE_WIDTH, 3 * Tile.TILE_HEIGHT, 33);
                            items.add(item);
                        }
                        if (id == 34) {
                            item = creator.GenerateItem("Boss", refLink, 14 * Tile.TILE_WIDTH, 3 * Tile.TILE_HEIGHT, 34);
                            items.add(item);
                        }
                    }
                }

                break;
        }
        // Trimitem lista de iteme catre refLink pentru a o putea folosi si in alte locuri
        if(hasKey==1)
            key.MarkAsPickedUp();
        if(chestOpen==1)
            chest.Open();
        refLink.SetItems(items);
    }

    /*! \fn public int GetLevel()
        \brief Returneaza nivelul curent al jocului
     */
    public int GetLevel(){return level;}

    /*! \fn public void SetLevel(int level)
        \brief Actualizeaza nivelul curent al jocului
     */
    public void SetLevel(int level) {
        this.level = level;
        map.LoadWorld(level);
        items = new ArrayList<Item>();
        refLink.SetItems(items);
        refLink.GetChest().MarkAsOpen();
        refLink.GetChest().Hide();
        refLink.GetKey().MarkAsPickedUp();
        hasKey = 0;
        chestOpen=0;
        hero.SetKey(false);
        LoadCharacters(false,null);
    }

    public void LoadData(String userName){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:GameDatabase.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String query = "SELECT * FROM DATA WHERE Username="+"'"+userName+"';";
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){

                try{
                    int Life = rs.getInt("Life");
                    int Damage = rs.getInt("Damage");
                    int HeroX = rs.getInt("HeroX");
                    int HeroY = rs.getInt("HeroY");
                    String Enemies = rs.getString("Enemies");
                    int HasChest = rs.getInt("HasChest");
                    int HasKey = rs.getInt("HasKey");
                    int Score = rs.getInt("Score");
                    int ArmorLevel =rs.getInt("ArmorLevel");
                    int Kills = rs.getInt("Kills");
                    int CurrentLevel = rs.getInt("CurrentLevel");

                    if(Life<0)
                        throw new InvalidDataLoaded("Life can't be a negative value");
                    if(Damage < 0)
                        throw new InvalidDataLoaded("Damage can't be a negative value");
                    if(HeroX<0 || HeroX>960)
                        throw new InvalidDataLoaded("The Hero X coordinate is out of bounds");
                    if(HeroY<0 || HeroY>576)
                        throw new InvalidDataLoaded("The Hero Y coordinate is out of bounds");
                    if(Enemies.contains("abcdefghijklmnopqrstuvwxiz"))
                        throw new InvalidDataLoaded("The Enemies List cointains invalid values");
                    if(HasChest < 0 || HasChest > 1 )
                        throw new InvalidDataLoaded("The Chest Value can only be 0 or 1");
                    if(HasKey < 0 || HasKey > 1)
                        throw new InvalidDataLoaded("The Key Value can only be 0 or 1");
                    if(Score < 0)
                        throw new InvalidDataLoaded("The Score can't be a negative value");
                    if(ArmorLevel < 0 || ArmorLevel > 4)
                        throw new InvalidDataLoaded("The Armor Level Value can only be between 0 and 4");
                    if(Kills < 0)
                        throw new InvalidDataLoaded("The Kills can't be a negative value");
                    if(CurrentLevel < 0 || CurrentLevel > 3)
                        throw new InvalidDataLoaded("The Current Level Value can only be between 0 and 3");



                    hero.SetLife(Life);
                    hero.SetDamage(Damage);
                    hero.SetX((float)HeroX);
                    hero.SetY((float)HeroY);
                    hero.SetScore(Score);
                    hero.SetArmorLevel(ArmorLevel);
                    hero.SetKills(Kills);
                    SetLevel(CurrentLevel);
                    if(HasChest == 1){
                        chestOpen = 1;
                    }
                    else
                        chestOpen =0;
                    if(HasKey==1){
                        hero.SetKey(true);
                        hasKey = 1;
                    }
                    LoadCharacters(true,Enemies);

                    //System.out.println(Life+" "+Damage+" "+HeroX+" "+HeroY+" "+Enemies);
                } catch (InvalidDataLoaded e){
                    System.out.println("Error at loading data from the database: "+e.getMessage());
                }
            }

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Loaded database successfully");
    }


    public void SaveData(String userName){
        String Enemies = "";
        for (Item item:refLink.GetItems()){
            Enemies = Enemies+item.GetID()+" ";
        }
        System.out.println("Enemies String: "+Enemies);

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:GameDatabase.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String query = "SELECT * FROM DATA WHERE Username="+"'"+userName+"';";
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){
                System.out.println("Already has some data");
                PreparedStatement updateQuery = c.prepareStatement("UPDATE DATA SET Life = ?, Damage = ?, HeroX = ?, HeroY = ?, Enemies = ?, HasKey = ?, HasChest = ?, Score = ?,  CurrentLevel = ?, ArmorLevel = ?, Kills = ? WHERE Username = ?");
                updateQuery.setInt(1,hero.GetLife());
                updateQuery.setInt(2,hero.GetDamage());
                updateQuery.setInt(3,(int)hero.GetX());
                updateQuery.setInt(4,(int)hero.GetY());
                updateQuery.setString(5,Enemies);
                if(hero.HasKey())
                    updateQuery.setInt(6,1);
                else
                    updateQuery.setInt(6,0);
                if(hero.HasOpenedChest())
                    updateQuery.setInt(7,1);
                else
                    updateQuery.setInt(7,0);
                updateQuery.setInt(8,hero.GetScore());
                updateQuery.setInt(9,level);
                updateQuery.setInt(10,hero.GetArmorLevel());
                updateQuery.setInt(11,hero.GetKills());
                updateQuery.setString(12,userName);
                updateQuery.execute();
                stmt.close();
                updateQuery.close();
                c.commit();
                c.close();
            }
            else {
                System.out.println("Doesn't have any data");
                PreparedStatement updateQuery = c.prepareStatement("INSERT INTO DATA (Username,Life,Damage,HeroX,HeroY,Enemies,HasKey,HasChest,Score,CurrentLevel,ArmorLevel,Kills) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
                updateQuery.setString(1,userName);
                updateQuery.setInt(2,hero.GetLife());
                updateQuery.setInt(3,hero.GetDamage());
                updateQuery.setInt(4,(int)hero.GetX());
                updateQuery.setInt(5,(int)hero.GetY());
                updateQuery.setString(6,Enemies);
                if(hero.HasKey())
                    updateQuery.setInt(7,1);
                else
                    updateQuery.setInt(7,0);
                if(hero.HasOpenedChest())
                    updateQuery.setInt(8,1);
                else
                    updateQuery.setInt(8,0);
                updateQuery.setInt(9,hero.GetScore());
                updateQuery.setInt(10,level);
                updateQuery.setInt(11,hero.GetArmorLevel());
                updateQuery.setInt(12,hero.GetKills());
                updateQuery.execute();
                stmt.close();
                updateQuery.close();
                c.commit();
                c.close();
            }
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Saved database successfully");
    }

    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a jocului.
     */
    @Override
    public void Update()
    {
        map.Update();
        chest.Update();
        key.Update();
        for (Item item:refLink.GetItems()){
            item.Update();
        }
        for (Projectile projectile:refLink.GetProjectiles()){
            if(projectile!=null) {
                if(projectile.inactive == false)
                    projectile.Update();
                else{
                    projectile = null;
                }
            }
        }
        hero.Update();
    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a jocului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        map.Draw(g);
        chest.Draw(g);
        key.Draw(g);
        for (Item item:refLink.GetItems()){
            item.Draw(g);
        }
        if(refLink.GetProjectiles()!=null)
            for (Projectile projectile:refLink.GetProjectiles()){
                projectile.Draw(g);
            }
        hero.Draw(g);
    }
}
