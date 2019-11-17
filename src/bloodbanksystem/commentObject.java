/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbanksystem;

public class commentObject {

    String cname,ccomment;
    
    String empty;

    public commentObject(String empty) {
        this.empty = empty;
    }

    public commentObject(String cname, String ccomment) {
        this.cname = cname;
        this.ccomment = ccomment;
    }
   

    
}
