// Author: Rohan Daivajna 
// Roll number: 35
// Title: Goa Legislative Assembly
// Start Date: 15-07-2024
// Modified Date: 22-07-2024
// Description: Menu driven program to introduce bills and add members to GLA using classes MLA, Officials and Bill. It also contains an abstract class Entity

public class MLA extends Entity {
    private final String name;
    private final String constituency;

    public MLA(String name, String constituency) {
        this.name = name;
        this.constituency = constituency;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nConstituency: " + constituency;
    }
}
