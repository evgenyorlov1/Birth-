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
    Boolean delete = Boolean.FALSE;
    
    public entity(String tag1, String tag2, String tag3, String date) {
        this.tag1 = tag1;
        this.tag2 = tag2;
        this.tag3 = tag3;
        this.date = date;                
    }
    
    public String getTag1() {
        return this.tag1;
    }
    
    public void setTag1(String tag1) {
        this.tag1 = tag1;
    }
    
    public String getTag2() {
        return this.tag2;
    }
    
    public void setTag2(String tag2) {
        this.tag2 = tag2;
    }
    
    public String getTag3() {
        return this.tag3;
    }
    
    public void setTag3(String tag3) {
        this.tag3 = tag3;
    }
    
    public String getDate() {
        return this.date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
    public Boolean getDelete() {
        return this.delete;
    }
    
    public void setDelete(Boolean flag) {
        this.delete = flag;
    }
}
