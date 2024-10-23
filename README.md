# Music Lesson Cost Calculator

## Overview
The **Music Lesson Cost Calculator** is a Java Swing application that allows users to calculate the cost of music lessons based on the instrument and skill level. The app provides lesson prices for Guitar, Piano, and Violin at three levels: Beginner, Intermediate, and Advanced. It features a modern macOS-like user interface and simple navigation through the use of combo boxes and buttons. The application also calculates the average cost of lessons for each level.

## Features
- Select musical instruments: **Guitar**, **Piano**, **Violin**.
- Choose the skill level: **Beginner**, **Intermediate**, or **Advanced**.
- **Submit** button calculates and displays the lesson price.
- **Report** button shows the average lesson cost for each level in a message dialog.
- **Menu system** for easy access to the Submit, Report, and Exit functionalities.
- Modern macOS-like UI with styled buttons and menus.
  
## Usage

1. Clone the repository:
   ```bash
   git clone https://github.com/HChristopherNaoyuki/music-lesson-cost-app-java-project.git
   ```
   
2. Compile and run the program:
   ```bash
   javac Solution/MusicLessonCostApp.java
   java Solution.MusicLessonCostApp
   ```

3. Select an instrument and level, then click **Submit** to display the lesson price.

4. Click **Report** to view the average lesson cost for each level (Beginner, Intermediate, and Advanced).

5. Use the **File > Exit** menu to close the application.

## Screenshots

![App Interface](screenshot.png) *(Include a screenshot of your app running)*

## Technologies Used
- **Java**: Core programming language.
- **Swing**: For building the GUI.
- **macOS Look and Feel**: Using Java's native system look for a modern appearance.

## How It Works
- The user selects a musical instrument and a skill level from the combo boxes.
- When the **Submit** button is clicked, the app retrieves the lesson price from a predefined `HashMap` and displays it in a `JOptionPane` dialog.
- The **Report** button calculates and displays the average lesson cost for all levels.
- Menu items provide alternative access to the **Submit**, **Report**, and **Exit** functionalities.

## Future Enhancements
- Add support for additional musical instruments.
- Store lesson prices in an external database or file.
- Customize UI for other operating systems.

## License
This project is licensed under the MIT License. See the LICENSE file for more details.
