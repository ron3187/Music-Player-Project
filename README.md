# Music Player Project

A lightweight desktop music player interface built with **Java Swing**. The application lets users create and manage a simple playlist, select songs, and move between playlist entries using previous, play, and next controls.

> **Note:** The current implementation manages song titles and artists as playlist entries. It does not yet play audio files.

## Features

- Add songs with a title and artist
- Display songs in a scrollable playlist
- Remove the selected song
- Clear the entire playlist
- Select and display the current song
- Navigate to the previous or next playlist entry
- Basic validation for empty song fields

## Technologies

- Java
- Java Swing
- `LinkedList` for playlist data
- `DefaultListModel` and `JList` for playlist display

## Project Structure

```text
.
└── src
    └── Spotibai
        ├── Song_List.java
        ├── Spotibai.java
        └── Spotibai_GUIandLINK.java
```

## Main Classes

- `Spotibai` — Application entry point.
- `Spotibai_GUIandLINK` — Builds the Swing interface and handles playlist actions.
- `Song_List` — Reserved window class for future song-list functionality.

## Requirements

- Java Development Kit (JDK) 8 or later
- A desktop environment capable of running Swing applications

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/ron3187/Music-Player-Project.git
cd Music-Player-Project
```

### 2. Compile the Source Files

From the repository root, run:

```bash
mkdir -p out
javac -d out src/Spotibai/*.java
```

On Windows PowerShell, use:

```powershell
New-Item -ItemType Directory -Force out
javac -d out src/Spotibai/*.java
```

### 3. Run the Application

```bash
java -cp out Spotibai.Spotibai
```

## Usage

1. Enter a song title and artist.
2. Select **ADD SONG** to add the entry to the playlist.
3. Select a playlist entry.
4. Use **D** to mark the selected entry as currently playing.
5. Use **<<** and **>>** to navigate through the playlist.
6. Use **REMOVE SONG** to delete the selected entry.
7. Use **CLEAR** to remove all entries.

## Current Limitations

- No audio file loading or playback is implemented yet.
- Playlist data is stored in memory and is lost when the application closes.
- The interface uses absolute positioning, so resizing behavior is limited.
- The **View Song List** button is present in the interface but does not currently have an action handler.

## Possible Future Improvements

- Add audio playback using a supported Java audio library.
- Load and save playlists from disk.
- Add pause, stop, volume, and progress controls.
- Improve the layout using Swing layout managers.
- Add keyboard shortcuts and improved input validation.
- Implement the song-list window and connect its button action.

## Contributing

1. Fork the repository.
2. Create a feature branch:

   ```bash
   git checkout -b feature/my-improvement
   ```

3. Make and test your changes.
4. Commit your changes:

   ```bash
   git commit -m "Add my improvement"
   ```

5. Push the branch and open a pull request.

## License

No license has been specified for this repository yet.
