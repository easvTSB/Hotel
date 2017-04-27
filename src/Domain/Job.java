package Domain;

/**
 * Created by LPNielsen on 27-04-2017.
 */
public class Job {
    private String name;
    private String desc;

    public Job(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
