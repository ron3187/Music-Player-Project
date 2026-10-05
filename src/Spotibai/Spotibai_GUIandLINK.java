package Spotibai;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.*;

public class Spotibai_GUIandLINK extends JFrame implements ActionListener {
//Gui

    private JLabel Hdr, lbltitle, lblartist, lblPlaylist, lblplaying, lblplayingsong;
    private JButton btnAddSong, btnRemoveSong, btnClear, btnprev, btnplay, btnnext, btnSonglist;
    private JTextField txtTitle, txtArtist;
    //Panels
    private JList<String> songlist;
    private JScrollPane pane;
    //Linked list 
    private LinkedList<String> list;
    private DefaultListModel<String> def;

    //data
    private String SongTitle, Artist, Current;
    private int IndexSelect, ItemCount, prevno;

    Spotibai_GUIandLINK() {
        list = new LinkedList<>();
        def = new DefaultListModel<>();
        setSize(600, 700);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //lbl
        Hdr = new JLabel("MY MUSIC PLAYER");
        Hdr.setBounds(250, 30, 150, 50);
        add(Hdr);
        lbltitle = new JLabel("Song Title: ");
        lbltitle.setBounds(50, 100, 150, 30);
        add(lbltitle);
        lblartist = new JLabel("Artist: ");
        lblartist.setBounds(50, 130, 150, 30);
        add(lblartist);
        lblPlaylist = new JLabel("MY PLAYLIST");
        lblPlaylist.setBounds(50, 250, 150, 30);
        add(lblPlaylist);
        lblplaying = new JLabel(" Now Playing:");
        lblplaying.setBounds(50, 500, 150, 30);
        add(lblplaying);
        lblplayingsong = new JLabel("NONE");
        lblplayingsong.setBounds(200, 500, 150, 30);
        add(lblplayingsong);
        //btn
        btnAddSong = new JButton("ADD SONG");
        btnAddSong.setBounds(50, 170, 150, 30);
        add(btnAddSong);
        btnRemoveSong = new JButton("REMOVE SONG");
        btnRemoveSong.setBounds(230, 170, 150, 30);
        add(btnRemoveSong);
        btnClear = new JButton("CLEAR");
        btnClear.setBounds(410, 170, 150, 30);
        add(btnClear);
        btnprev = new JButton("<<");
        btnprev.setBounds(100, 550, 100, 30);
        add(btnprev);
        btnplay = new JButton("D");
        btnplay.setBounds(220, 550, 100, 30);
        add(btnplay);
        btnnext = new JButton(">>");
        btnnext.setBounds(340, 550, 100, 30);
        add(btnnext);
        btnSonglist = new JButton("View Song List");
        btnSonglist.setBounds(400, 250, 150, 30);
        add(btnSonglist);

        //txta
        txtTitle = new JTextField();
        txtTitle.setBounds(230, 105, 200, 20);
        add(txtTitle);
        txtArtist = new JTextField();
        txtArtist.setBounds(230, 135, 200, 20);
        add(txtArtist);

        //linklist
        songlist = new JList<>(def);
        pane = new JScrollPane(songlist);
        pane.setBounds(50, 280, 500, 200);
        add(pane);

        //action
        btnAddSong.addActionListener(this);
        btnRemoveSong.addActionListener(this);
        btnClear.addActionListener(this);
        btnprev.addActionListener(this);
        btnplay.addActionListener(this);
        btnnext.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAddSong) {
            SongTitle = txtTitle.getText().trim();
            Artist = txtArtist.getText().trim();
            if (!SongTitle.isEmpty() && !Artist.isEmpty()) {
                String Combine = SongTitle + " by " + Artist;
                list.add(Combine);
                def.addElement(Combine);
                txtTitle.setText("");
                txtArtist.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Fill All The Text");
            }
        } else if (e.getSource() == btnRemoveSong) {
            IndexSelect = songlist.getSelectedIndex();
            if (IndexSelect != -1) {
                list.remove(IndexSelect);
                def.removeElementAt(IndexSelect);
                lblplayingsong.setText("NONE");

            }
        } else if (e.getSource() == btnClear) {
            ItemCount = def.getSize();
            if (ItemCount > 0) {
                list.clear();
                def.clear();
                lblplayingsong.setText("NONE");
            } else {
                JOptionPane.showMessageDialog(this, "All Cleared");

            }
        } else if (e.getSource() == btnplay) {
            IndexSelect = songlist.getSelectedIndex();
            if (IndexSelect != -1) {
                Current = def.getElementAt(IndexSelect);
                lblplayingsong.setText(Current);

            } else {
                JOptionPane.showMessageDialog(this, "Select a Song To Play");
            }
        } else if (e.getSource() == btnprev) {
            ItemCount = def.getSize();
            IndexSelect = songlist.getSelectedIndex();
            if (IndexSelect > 0 && ItemCount > 0) {
                IndexSelect--;
                songlist.setSelectedIndex(IndexSelect);
                Current = def.getElementAt(IndexSelect);
                lblplayingsong.setText(Current);

            }
        } else if (e.getSource() == btnnext) {
            IndexSelect = songlist.getSelectedIndex();
            ItemCount = def.getSize();
            if (IndexSelect < ItemCount - 1) {
                IndexSelect++;
                songlist.setSelectedIndex(IndexSelect);
                Current = def.getElementAt(IndexSelect);
                lblplayingsong.setText(Current);
                System.out.println(IndexSelect);
                System.out.println(ItemCount);
            }
        }
    }
}
