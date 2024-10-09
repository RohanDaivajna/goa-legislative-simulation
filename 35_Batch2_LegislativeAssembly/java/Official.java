// Author: Rohan Daivajna 
// Roll number: 35
// Title: Goa Legislative Assembly
// Start Date: 15-07-2024
// Modified Date: 22-07-2024
// Description: Menu driven program to introduce bills and add members to GLA using classes MLA, Officials and Bill. It also contains an abstract class Entity

public class Official extends Entity {
    private String position;
    private String name;

    public Official(String position, String name) {
        this.position = position;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Position: " + position + "\nName: " + name;
    }
}
