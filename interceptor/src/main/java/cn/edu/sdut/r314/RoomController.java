package cn.edu.sdut.r314;

import javax.inject.Named;

/**
 *
 * @author subaochen
 */
@Named
public class RoomController {
    
    /**
     * 订房
     * @return 
     */
    //@Audit
    public void checkin(){
        System.out.println("checkin room......");
    }
    
    /**
     * 退房
     * @return 
     */
    //@Audit
    public void checkout(){
        System.out.println("checkout room......");
    }
    
}
