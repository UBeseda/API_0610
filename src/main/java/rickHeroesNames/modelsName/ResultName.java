package rickHeroesNames.modelsName;

import java.util.ArrayList;
import java.util.Date;

public class ResultName {
    public int id;
    public String name;
    public String status;
    public String species;
    public String type;
    public String gender;
    public Origin origin;
    public Location location;
    public String image;
    public ArrayList<String> episode;
    public String url;
    public Date created;



    @Override
    public String toString() {
        return "name "+name+"\n"+
                "status "+status+"\n"+
                "species " + species;
    }
}