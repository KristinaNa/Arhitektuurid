package model;
public class Radio {
    private int id ;
    private String name ;
    private int sequence ;


    public void setId(int id)
    {
        this.id = id;
    }

    public void setName (String name)
    {
        this.name= name;
    }

    public void setSequence(int sequence)
    {
        this.sequence = sequence;
    }


    public int getId()
    {
        return this.id ;
    }

    public String getName ()
    {
        return this.name ;
    }

    public int getSequence ()
    {
        return this.sequence ;
    }



}
