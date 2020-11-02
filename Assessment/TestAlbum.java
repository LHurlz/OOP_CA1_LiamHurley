package Assessment;

import javax.swing.*;
import java.awt.*;

public class TestAlbum {
    public static void main(String[] args) {
        Song song1 = new Song("Sugar Baby Love", "Rubettes", "Pop", 136, 1977);
        Song song2 = new Song("Living on a Prayer", "Bon Jovi", "Rock", 184, 1985);
        Song song3 = new Song("Blue Suede Shoes", "Elvis Presley", "Pop", 157, 1963);
        Song song4 = new Song("Someone Like You", "Adele", "Pop", 223, 2013);
        Song song5 = new Song("House of Fun", "Madness", "Pop", 178, 1984);

        Song[] allSongs = new Song[5];

        allSongs[0]=song1;
        allSongs[1]=song2;
        allSongs[2]=song3;
        allSongs[3]=song4;
        allSongs[4]=song5;

        Album album1 = new Album("Now that’s what I call music 98", allSongs, "Universal Music", 2016);

        JTextArea textArea = new JTextArea();
        Font font = new Font("monospaced",Font.PLAIN,12);
        textArea.setFont(font);

        textArea.append(album1.toString());

        textArea.append("\n\n\t\t\t\tAlbum Tracks\n\n");
        textArea.append(String.format("%-20s%-45s%-20s","Track Number","Title","Artist"));

        for(int i=0; i<allSongs.length; i++){
            if(allSongs[i]!=null){
                textArea.append(String.format("\n\n%-20s%-45s%-20s",allSongs[i].getTrackNumber(),allSongs[i].getTitle(),allSongs[i].getArtist()));
            }
        }

        JOptionPane.showMessageDialog(null,textArea,"Album Information",JOptionPane.INFORMATION_MESSAGE);

        int trackRequest = Integer.parseInt(JOptionPane.showInputDialog("Which track number would you like to play?"));

        album1.playTrack(trackRequest);

        String shuffleRequest = JOptionPane.showInputDialog("Do you wish to shuffle the playlist?");

        if(shuffleRequest.toLowerCase().equals("yes")){
            album1.shuffle();
        }
        else
            System.exit(0);



    }
}
