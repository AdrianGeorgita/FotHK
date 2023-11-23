package PaooGame;

import PaooGame.States.SettingsState;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {

    private static Sound instance = null;
    Clip clip;
    URL SoundURL[] = new URL[5];

    boolean isSE = false;

    private Sound(){
        SoundURL[0] = getClass().getResource("/sound/music.wav");
        SoundURL[1] = getClass().getResource("/sound/attack.wav");
        SoundURL[2] = getClass().getResource("/sound/attack2.wav");
        SoundURL[3] = getClass().getResource("/sound/fireball.wav");
    }

    public static Sound GetInstance(){
        if(instance == null)
            instance = new Sound();
        return instance;
    }

    public static void Reset(){ instance = null;}

    public void setFile(int i){
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(SoundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
            if(i>0)
                isSE = true;
            else
                isSE = false;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void play(){
        if((!isSE && SettingsState.music == true) || (isSE && SettingsState.soundEffects == true))
            clip.start();
    }

    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop(){
        clip.stop();
    }
}
