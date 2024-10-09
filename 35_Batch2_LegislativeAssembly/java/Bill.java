// Author: Rohan Daivajna 
// Roll number: 35
// Title: Goa Legislative Assembly
// Start Date: 15-07-2024
// Modified Date: 22-07-2024
// Description: Menu driven program to introduce bills and add members to GLA using classes MLA, Officials and Bill. It also contains an abstract class Entity

public class Bill extends Entity {
    private String title;
    private String description;
    private boolean isPassed;

    public Bill(String title, String description) {
        this.title = title;
        this.description = description;
        this.isPassed = false;
    }

    public void pass() {
        this.isPassed = true;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nDescription: " + description + "\nStatus: " + (isPassed ? "Passed" : "Not Passed");
    }
}
