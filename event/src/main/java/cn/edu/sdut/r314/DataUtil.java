/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.sdut.r314;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author subaochen
 */
@Named("dataUtil")
@ApplicationScoped
public class DataUtil {
    public RoomStatus[] getRoomStatuses(){
        return RoomStatus.values();
    }
    
    public RoomType[] getRoomTypes(){
        return RoomType.values();
    }
}
