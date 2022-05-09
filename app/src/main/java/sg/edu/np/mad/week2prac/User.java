package sg.edu.np.mad.week2prac;

import android.view.View;

import java.sql.DriverPropertyInfo;

public class User {
    public String name;
    public String description;
    public int id;
    public boolean followed;

    public User (String name, String description, int id, boolean followed)
    {
        name = name;
        description = description;
        id = id;
        followed = followed;
    }
}



