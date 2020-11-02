package Assessment;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.swing.*;
import java.util.Arrays;

public class Album {
    private String name;
    private Song[] tracks;
    private String producer;
    private int releaseYear;

    public Album(String name, Song[] tracks, String producer, int releaseYear){
        setName(name);
        setTracks(tracks);
        setProducer(producer);
        setReleaseYear(releaseYear);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.equals("") || name.equals(null))
            this.name="No name specified";
        else
            this.name=name;
    }

    public Song[] getTracks() {
        return tracks;
    }

    public void setTracks(Song[] tracks) {
        this.tracks = tracks;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getNumberOfTracks(){
        int count=0;

        for(int i=0; i<tracks.length; i++){
            if(tracks[i]!=null){
                count++;
            }
        }
        return count;
    }

    public int getPlayingTime(){
        int count=0;

        for(int i=0; i<tracks.length; i++){
            if(tracks[i]!=null){
                count+=tracks[i].getDuration();
            }
        }

        return count;

    }

    public void playTrack(int request){
        if(request>0 && request<=tracks.length){
            JOptionPane.showMessageDialog(null,"Now playing track - details are as follows:\n\n"+tracks[request-1].toString(),"Playing Track",JOptionPane.INFORMATION_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(null,"An invalid track number was supplied!","Bad Track Number",JOptionPane.ERROR_MESSAGE);

    }

   public void shuffle(){
        Song[] shuffledSongs = new Song[tracks.length];
        Boolean[] alreadyPicked = {false,false,false,false,false};
        int[] randomNumbers = new int[tracks.length];
        String txt="";

        int range=(((shuffledSongs.length-1) - 0)+1);

        /*for(int i=0; i<randomNumbers.length; i++){
            randomNumbers[i]=(int)(Math.random()*range);
        }*/

        /*for(int i=0; i<shuffledSongs.length; i++){
            if(alreadyPicked[i]=false && alreadyPicked[i]!=null){
                randomNumbers[i]=(int)(Math.random()*range);
                shuffledSongs[i]=tracks[randomNumbers[i]];
                alreadyPicked[randomNumbers[i]]=true;
            }
        }*/

       for(int i=0; i<randomNumbers.length; i++){
           randomNumbers[i]=(int)(Math.random()*range);
           alreadyPicked[randomNumbers[i]]=true;
           if(alreadyPicked[randomNumbers[i]]=false){
               shuffledSongs[i]=tracks[randomNumbers[i]];
           }
       }

        for(int i=0; i<randomNumbers.length; i++){
            if(shuffledSongs[i]!=null)
                txt+=shuffledSongs[i].toString()+"\n";
        }

        JOptionPane.showMessageDialog(null,"Shuffled playlist is as follows:\n\n"+txt,"Shuffled Playlist",JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public String toString() {
        return "Name: "+getName()+"\n\nProducer: "+getProducer()+"\n\nRelease Year: "+getReleaseYear()+"\n\nNumber of Tracks: "+getNumberOfTracks()
                +"\n\nTotal Playing Time: "+getPlayingTime();
    }
}
