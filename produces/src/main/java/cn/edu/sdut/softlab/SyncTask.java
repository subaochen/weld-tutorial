/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.sdut.softlab;

import java.io.Serializable;

/**
 *
 * @author SuBaochen:subaochen@126.com
 */
public class SyncTask implements Task,Serializable {
  
  public String getName() {
    return "sync task";
  }
  
}
