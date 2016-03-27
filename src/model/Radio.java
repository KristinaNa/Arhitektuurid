package model;
public class Radio {
    private int radio;
    private String name ;
    private String description ;
    private int sequence ;


    public void setId(int id) { this.radio = id; }

    public void setName (String name) { this.name= name; }
    public void setSequence(int sequence)
    {
        this.sequence = sequence;
    }
    public void setDescription (String description) { this.description= description; }


    public int getId() {
        System.out.print(this.radio);
        return this.radio;
    }

    public String getName ()
    {
        return this.name ;
    }
    public int getSequence ()
    {
        return this.sequence ;
    }
    public String getDescription ()
    {
        return this.description ;
    }



}
