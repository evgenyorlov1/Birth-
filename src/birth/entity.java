package birth;

/**
 *
 * @author pc
 */
public class entity {
    
    String tag1;
    String tag2;
    String tag3;    
    String date;
    
    public entity(String tag1, String tag2, String tag3, String date) {
        this.tag1 = tag1;
        this.tag2 = tag2;
        this.tag3 = tag3;
        this.date = date;                
    }
    
    public String getTag1() {
        return this.tag1;
    }
    
    public String getTag2() {
        return this.tag2;
    }
    
    public String getTag3() {
        return this.tag3;
    }
    
    public String getDate() {
        return this.date;
    }
    
}
